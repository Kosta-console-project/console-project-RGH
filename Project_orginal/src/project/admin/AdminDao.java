package project.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import project.config.DBConnect;
import project.player.Player;

public class AdminDao {
	private DBConnect dbconn;

	public AdminDao() {
		dbconn = DBConnect.getInstance();
	}

	public Player select(int playerId) {
		Connection conn = dbconn.conn();

		String sql = "select * from player where player_id = ?";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, playerId);
			
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				return new Player(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getDate(5), rs.getDate(6));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			dbconn.disconnectDB(conn);
		}
	}
	
	//수정
	public void update(int playerId) {
		Connection conn = dbconn.conn();

		String sql = "update player set credit=? where player_id = (select credit from player)";

		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.set(1, credit);//player 테이블에서 가져올 크레딧
			pstmt.setInt(1, playerId);
			
			pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  finally {
			  dbconn.disconnectDB(conn);
		}
	}
	

}
