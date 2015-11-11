package co.edu.unal.isi.taxiagent2.gui;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import co.edu.unal.isi.taxiagent2.model.Position;
import co.edu.unal.isi.taxiagent2.model.Request;
import co.edu.unal.isi.taxiagent2.model.TaxiAgent;

public class JAmbientPanel extends JPanel implements MouseListener {
	
	public static final int BLOCKED = 0;
	public static final int SETTING_ROAD = 1;
	public static final int SETTING_TAXI_AGENT = 2;
	public static final int SETTING_REQUESTS = 3;
	public static final int SETTING_DESTINY = 4;

	public static final Color DISABLED_COLOR = Color.WHITE;
	public static final Color ROAD_COLOR = Color.DARK_GRAY;
	public static final Color ORIGIN_COLOR = Color.BLUE;
	public static final Color DESTINY_COLOR = Color.RED;
	public static final Color TAXI_AGENT_COLOR = Color.YELLOW;
	public static final int ESTABLISHED_ORIGIN = 1;

	public static final int GAP = 2;

	private int rows, cols;
	private int state, requestState;
	private JCell[][] cellGrid;
	private JAmbientFrame mainFrame;
	Request tmpRequest = new Request();
	
	public JAmbientPanel(int state, int rows, int cols, JAmbientFrame ambientFrame) {
		this.rows = rows;
		this.cols = cols;
		this.state = state;
		this.requestState = BLOCKED;
		this.cellGrid = new JCell[rows][cols];
		//this.situation = new Situation();
		this.mainFrame = ambientFrame;
		setLayout(new GridLayout(rows, cols, GAP, GAP));
		setBackground(Color.BLACK);
		setBorder(BorderFactory.createLineBorder(Color.black));

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				cellGrid[i][j] = new JCell(20, 20);//, this);
				cellGrid[i][j].addMouseListener(this);
				cellGrid[i][j].setPosition(new Position(i, j));
				add(cellGrid[i][j]);
			}
		}
		setSize(600, 600);
		//graph = new Graph(rows, cols);
		//System.out.println(state);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (state == SETTING_ROAD) {
			//RoadMap road = new RoadMap();
			Position selectedCellPosition;
			Object source = e.getSource();
			if (source instanceof JCell) {
				JCell selectedPanel = (JCell) source;
				selectedCellPosition = selectedPanel.getPosition();
				int i = selectedCellPosition.getI();
				int j = selectedCellPosition.getJ();
				cellGrid[i][j].setBackground(ROAD_COLOR);
				//road.addPosition(selectedCellPosition);
				//situation.setInputRoad(road);
				
				//en mi ejemplo hacer solo caso al grafo que constru�
				//graph.addEdge(i, j);

			}
		} else if (state == SETTING_TAXI_AGENT) {
			Object source = e.getSource();
			//TaxiAgent taxiAgent = new TaxiAgent();
			Position selectedCellPosition;
			if (source instanceof JCell) {
				JCell selectedCell = (JCell) source;
				selectedCellPosition = selectedCell.getPosition();
				System.out.println("Agent setted at: " + selectedCellPosition);
				int i = selectedCellPosition.getI();
				int j = selectedCellPosition.getJ();
				cellGrid[i][j].setBackground(TAXI_AGENT_COLOR); //pintar la casilla del taxi
				//taxiAgent.setPosition(selectedCellPosition);
				//situation.setTaxiAgent(taxiAgent);
				setState(BLOCKED);
				//graph.getAgent().setPosition(selectedCellPosition); //mi taxi en el grafo
				//graph.print();
				//System.out.println(taxiAgent);
			}
		} 
		else if (state == SETTING_REQUESTS) 
		{
			int numOfPassengers;
			
			Position startPosition, endPosition;
			Object source = e.getSource();

			if (source instanceof JCell) {
				JCell selectedCell = (JCell) source;
				startPosition = selectedCell.getPosition();
				int startI = startPosition.getI();
				int startJ = startPosition.getJ();
				if (requestState == BLOCKED && cellGrid[startI][startJ].getBackground().equals(ROAD_COLOR)) 
				{
					cellGrid[startI][startJ].setBackground(ORIGIN_COLOR); //coloreando la celda de la peticion(donde est� el pasajero)
					tmpRequest.setStartPosition(startPosition);
					requestState = ESTABLISHED_ORIGIN;
				}
				else if (requestState == ESTABLISHED_ORIGIN) 
				{
					endPosition = selectedCell.getPosition();
					int endI = endPosition.getI();
					int endJ = endPosition.getJ();
					if (cellGrid[endI][endJ].getBackground().equals(ROAD_COLOR) || cellGrid[endI][endJ].getBackground().equals(DESTINY_COLOR)) 
					{
						cellGrid[endI][endJ].setBackground(DESTINY_COLOR); //coloreando la celda del destino(donde hay que llevar al pasajero)
						tmpRequest.setEndPosition(endPosition);
						System.out.println("end=" + cellGrid[endI][endJ].getPosition());
						numOfPassengers = Integer.parseInt(
								JOptionPane.showInputDialog(this, "Enter the number"
										+ " of passengers of this request:"));
						tmpRequest.setNumOfPassengers(numOfPassengers);
						//situation.getRequests().add(tmpRequest);
						// Es mas conveniente tener este ArrayList dentro de la
						// clase Graph
						//graph.getPeticiones().add(tmpRequest);
						
						System.out.println(tmpRequest);
						requestState = BLOCKED;
						
						//darle nueva memoria
						tmpRequest = new Request();
					}
				}
			}
		}
	}
	
	public JCell[][] getGrid() {
		return cellGrid;
	}

	public void setState(int state) {
		this.state = state;
	}
	
	// ********** Non-used methods ***********
	
	@Override
	public void mousePressed(MouseEvent e) { }

	@Override
	public void mouseReleased(MouseEvent e) { }

	@Override
	public void mouseEntered(MouseEvent e) { }

	@Override
	public void mouseExited(MouseEvent e) {	}
	
	// *****************************************

}
