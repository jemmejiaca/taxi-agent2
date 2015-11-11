package co.edu.unal.isi.taxiagent2.model;

public class Road {
	private Position[] roadPositionList;
	
	public Road(Position[] roadPositionList) {
		this.roadPositionList = roadPositionList;
	}

	public Position[] getRoadPositionList() {
		return roadPositionList;
	}

	public void setRoadPositionList(Position[] roadPositionList) {
		this.roadPositionList = roadPositionList;
	}
	
	public int getSize() {
		return roadPositionList.length;
	}

}
