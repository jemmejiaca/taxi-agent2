package co.edu.unal.isi.taxiagent2.model;

public class Ambient {
	private TaxiAgent    taxiAgent;
	private Position[][] grid;
	private Position[]   road;
	private Request[]    requests;
	
	public Ambient(TaxiAgent taxiAgent, Position[][] grid, Position[] road, Request[] requests) {
		this.taxiAgent = taxiAgent;
		this.grid 	   = grid;
		this.road 	   = road;
		this.requests  = requests;
	}

	public TaxiAgent getTaxiAgent() {
		return taxiAgent;
	}

	public void setTaxiAgent(TaxiAgent taxiAgent) {
		this.taxiAgent = taxiAgent;
	}

	public Position[][] getGrid() {
		return grid;
	}

	public void setGrid(Position[][] grid) {
		this.grid = grid;
	}

	public Position[] getRoad() {
		return road;
	}

	public void setRoad(Position[] road) {
		this.road = road;
	}

	public Request[] getRequest() {
		return requests;
	}

	public void setRequest(Request[] request) {
		this.requests = request;
	}
	
	public AdjacencyMatrix buildGraph() {
		AdjacencyMatrix graph = new AdjacencyMatrix(requests.length);
		for (int i = 0; i < requests.length; i++) {
			for (int j = 0; j < requests.length; j++) {
				graph.addEdge(i, j, requests[i].getEndPosition().manhattanDistanceTo(requests[i].getStartPosition()));
			}
		}
		return graph;
	}
	
}
