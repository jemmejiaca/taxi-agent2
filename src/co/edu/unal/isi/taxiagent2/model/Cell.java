package co.edu.unal.isi.taxiagent2.model;

public class Cell {
	private Position position;
	private boolean isRequestEnd;
	private boolean isRequestStart;
	private boolean isRoad;
	
	public Cell(Position position) {
		this.position = position;
	}
	
	public Position getPosition() {
		return position;
	}
	public void setPosition(Position position) {
		this.position = position;
	}
	public boolean isRequestEnd() {
		return isRequestEnd;
	}
	public void setRequestEnd(boolean isRequestEnd) {
		this.isRequestEnd = isRequestEnd;
	}
	public boolean isRequestStart() {
		return isRequestStart;
	}
	public void setRequestStart(boolean isRequestStart) {
		this.isRequestStart = isRequestStart;
	}
	public boolean isRoad() {
		return isRoad;
	}
	public void setRoad(boolean isRoad) {
		this.isRoad = isRoad;
	}
	

}
