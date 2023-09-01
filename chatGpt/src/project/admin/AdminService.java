package project.admin;

import java.util.ArrayList;
import java.util.Scanner;

import project.item.Item;
import project.item.ItemDao;
import project.player.Player;
import project.player.PlayerDao;

public class AdminService {
	private AdminDao adminDao;
	private ItemDao itemDao;
	private PlayerDao playerDao;

	public AdminService() {
		adminDao = new AdminDao();
		itemDao = new ItemDao();
		playerDao = new PlayerDao();
	}

	public void addCredit(Scanner sc) {
		System.out.println("===크레딧 부여===");

		System.out.println("크레딧을 부여할 플레이어 닉네임:");
		String nickname = sc.next();
		Player p = playerDao.findByNickname(nickname);

		System.out.println("부여할 크레딧:");
		int newCredit = sc.nextInt();
		playerDao.updateCredit(p, newCredit);

		System.out.println("크레딧이 부여되었습니다.");

	}

	public void subCredit(Scanner sc) {
		System.out.println("===크레딧 삭감===");

		System.out.println("크레딧을 삭감할 플레이어 닉네임:");
		String nickname = sc.next();
		Player p = playerDao.findByNickname(nickname);

		System.out.println("삭감할 크레딧:");
		int newCredit = sc.nextInt();

		playerDao.updateCredit(p, -newCredit);

		System.out.println("크레딧이 삭감되었습니다.");

	}

	public void printAll() {
		System.out.println("===모든 플레이어 조회===");
		ArrayList<Player> list = adminDao.selectAll();

		for (Player p : list) {
			System.out.println(p);
		}
	}

	public void addToBlackList(Scanner sc) { // TODO 해당 메서드는 메뉴로 이동하거나 playerService에서 구동.
		System.out.println("===플레이어 블랙리스트에 추가===");

		System.out.println("블랙리스트에 추가될 플레이어 아이디:");
		int playerId = sc.nextInt();

		System.out.println("1. 욕설 2. 버그 악용 3. 게임 방해");
		System.out.println("밴 사유:");
		int index = sc.nextInt();
		int m = index;

		switch (m) {
		case 1:
			adminDao.addBlackList(playerId, "욕설");
			break;
		case 2:
			adminDao.addBlackList(playerId, "버그 악용");
			break;
		case 3:
			adminDao.addBlackList(playerId, "게임 방해");
			break;
		}
		System.out.println("플레이어가 블랙리스트에 추가 되었습니다. 활동이 금지됩니다.");
	}

	public void printAllBlackList() {
		System.out.println("=== 블랙리스트 전체 출력===");
		ArrayList<BlackList> list = adminDao.selectAllBlackList();

		if (list.isEmpty() || list == null) {// 확인 필요
			System.out.println("블랙리스트에 추가된 플레이어가 없습니다.");
		} else {
			for (BlackList b : list) {
				System.out.println(b);
			}
		}
	}

	public void delFromBlackList(Scanner sc) {
		System.out.println("===블랙리스트에서 플레이어 삭제===");

		System.out.println("밴 해제할 플레이어 아이디:");
		int playerId = sc.nextInt();

		adminDao.delBlackList(playerId);

		System.out.println("플레이어가 블랙리스트에서 삭제되었습니다.");
	}

}
