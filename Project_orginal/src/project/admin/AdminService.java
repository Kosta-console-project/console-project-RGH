package project.admin;

import java.util.ArrayList;
import java.util.Scanner;

import project.player.Player;

public class AdminService {
	private AdminDao dao;
	public static String pwd;//비밀번호 어떻게 설정할지

	public AdminService() {
		dao = new AdminDao();
	}

	public void addCredit(Scanner sc) {
		System.out.println("===크레딧 부여===");
		
		System.out.println("크레딧을 부여할 플레이어:");
		String playerName = sc.next();
		
		System.out.println("부여할 크레딧:");
		int credit = sc.nextInt();
		
		Player p = dao.update(new Player());
		
	}

	public void subCredit(Scanner sc) {
		System.out.println("===크레딧 삭감===");
		
		System.out.println("크레딧을 삭감할 플레이어 아이디:");
		int playerId = sc.nextInt();
		
		System.out.println("삭감할 크레딧:");
		int credit = sc.nextInt();
	}

	public void printAll(ArrayList<Player> list) {
		System.out.println("모든 플레이어 조회");
		
		for (Player p : list) {
			System.out.println(p);//toString으로 변환 필요
		}

	}

	public void editPlayer(Scanner sc) {
		System.out.println("플레이어 수정");
		
		System.out.print("수정할 플레이어:");
		int playerId = sc.nextInt();
		Player p = dao.select(playerId);
		
		//수정할 플레이어 내용
		
	}

}
