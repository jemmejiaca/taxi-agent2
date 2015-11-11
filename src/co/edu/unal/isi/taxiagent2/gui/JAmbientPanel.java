package co.edu.unal.isi.taxiagent2.gui;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import co.edu.unal.isi.taxiagent2.model.Position;

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
	private JMainFrame mainFrame;
	
	public JAmbientPanel(int state, int rows, int cols, JMainFrame mainFrame) {
		this.rows = rows;
		this.cols = cols;
		this.state = state;
		this.requestState = BLOCKED;
		this.cellGrid = new JCell[rows][cols];
		//this.situation = new Situation();
		this.mainFrame = mainFrame;
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
		
	}
	
	public JCell[][] getGrid() {
		return cellGrid;
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
