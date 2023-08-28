package project.admin;

public enum VanReason {
    욕설(1), 게임방해(2), 버그악용(3);
    int Ban;

	private VanReason(int ban) {
		Ban = ban;
	}

	public int getBan() {
		return Ban;
	}

	public void setBan(int ban) {
		Ban = ban;
	}

}
