package co.edu.unal.isi.taxiagent2.model;

public class AdjacencyMatrix {
	private int numberOfVertices;
	private int[][] matrix;
	
	public AdjacencyMatrix(int n) {
		numberOfVertices = n;
		matrix = new int[n][n];
		for (int x = 0; x < n; ++x)
			for (int y = 0; y < n; ++y)
				if (x == y) matrix[x][y] = 0;
				else matrix[x][y] = -1;
	}
	
	public void addEdge(int i, int j, int cost) {
		matrix[i][j] = cost;
	}
	
	public void removeEdge(int i, int j) {
		matrix[i][j] = -1;
	}
	
	public boolean hasEdge(int i, int j) {
		return matrix[i][j] > 0;
	}
	
	public String print() {
		StringBuilder str = new StringBuilder();
		for (int x = 0; x < numberOfVertices; ++x)
			for (int y = 0; y < numberOfVertices; ++y)
				str.append("\t" + matrix[x][y]);
		return str.toString();
	}

}
