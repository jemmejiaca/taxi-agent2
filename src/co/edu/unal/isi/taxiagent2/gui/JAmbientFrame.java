package co.edu.unal.isi.taxiagent2.gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class JAmbientFrame extends JFrame implements ActionListener {
	
	JAmbientPanel ambientPanel;
	JTextArea log = new JTextArea(30, 35);
	JScrollPane scrollPane = new JScrollPane(log);
	JButton buttonAccept = new JButton("Accept");
	Container contentPane = getContentPane();
	GroupLayout layout = new GroupLayout(contentPane);
	Font logFont = new Font("Courier New", Font.PLAIN, 14);
	
	public JAmbientFrame(int state, int rows, int cols, JMainFrame mainFrame) {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		//contentPane.setLayout(layout);
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);
		
		//setLayout(new FlowLayout());
		ambientPanel = new JAmbientPanel(state, rows, cols, mainFrame);
		add(ambientPanel, BorderLayout.CENTER);
		log.setEditable(false);
		log.setFont(logFont);
		add(log, BorderLayout.EAST);
		add(buttonAccept, BorderLayout.SOUTH);
		setSize(1000, 700);
		//pack();
		setLocationRelativeTo(null);
		
	}
	
	public void setLog(String msg) {
		log.setText(" > " + msg + "\n");
	}
	
	public void parseString(String[] strs) {
		for (int i = 0; i < strs.length; i++) {
			for (int j = 0; j < strs[i].length(); j++) {
				if (strs[i].charAt(j) == '-')
					ambientPanel.getGrid()[i][j].setBackground(JAmbientPanel.ROAD_COLOR);
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
