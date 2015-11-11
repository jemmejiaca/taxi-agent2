package co.edu.unal.isi.taxiagent2.model;

public class TaxiAgent {
	private int maxQuota;
	private Position position;
	
	public TaxiAgent(Position position, int quota) {
		this.position = position;
		maxQuota = quota;
	}

	public int getMaxQuota() {
		return maxQuota;
	}

	public void setMaxQuota(int maxQuota) {
		this.maxQuota = maxQuota;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}
	
}
