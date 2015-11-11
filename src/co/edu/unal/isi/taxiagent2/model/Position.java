package co.edu.unal.isi.taxiagent2.model;

public class Position {
	private int i, j;
	
	public Position(int x, int y) {
		i = x; j = y;
	}
	
	public Position() {
		i = 0; j = 0;
	}

	public int getI() {
		return i;
	}

	public int getJ() {
		return j;
	}

	public void setI(int i) {
		this.i = i;
	}

	public void setJ(int j) {
		this.j = j;
	}
	
	public double euclideanDistanceTo(Position p) {
		int a = i, b = j, c = p.getI(), d = p.getJ();
		return Math.sqrt( Math.pow(a - c, 2) + Math.pow(b - d, 2) );
	}
	
	public int manhattanDistanceTo(Position p) {
		return Math.abs(i - p.getI()) + Math.abs(j - p.getJ());
	}

	@Override
	public String toString() {
		return "(" + i + ", " + j + ")";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + i;
		result = prime * result + j;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Position other = (Position) obj;
		if (i != other.i)
			return false;
		if (j != other.j)
			return false;
		return true;
	}
	
}
