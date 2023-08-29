package gameHistory;

import project.player.Player;

import java.util.List;

public class GameHistoryService {
    private GameHistoryDao dao;

    public GameHistoryService() {
        this.dao = new GameHistoryDao();
    }

    public int setWinner(int gameId, int playerId) {
        return dao.insert(gameId, playerId);
    }

    public int setWinner(int gameId, List<Player> players) {
        int count = 0;

        for (Player p : players) {
            // TODO player 클래스 구현 후 추가 예정
//            count += setWinner(gameId, p.getPlayerId());

        }

        return count;
    }

    public List<GameHistoryQueryVo> getMyHistory(int playerId) {
        return dao.findByPlayerId(playerId);
    }


}
