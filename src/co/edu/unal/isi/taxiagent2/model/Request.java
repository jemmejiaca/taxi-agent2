package co.edu.unal.isi.taxiagent2.model;

public class Request {
	private Position startPosition;
	private Position endPosition;
	private int numOfPassengers;
	
	public Request(Position startPosition, Position endPosition, int numOfPassengers) {
		this.startPosition = startPosition;
		this.endPosition = endPosition;
		this.numOfPassengers = numOfPassengers;
	}

	public Position getStartPosition() {
		return startPosition;
	}

	public void setStartPosition(Position startPosition) {
		this.startPosition = startPosition;
	}

	public Position getEndPosition() {
		return endPosition;
	}

	public void setEndPosition(Position endPosition) {
		this.endPosition = endPosition;
	}

	public int getNumOfPassengers() {
		return numOfPassengers;
	}

	public void setNumOfPassengers(int numOfPassengers) {
		this.numOfPassengers = numOfPassengers;
	}
	
}