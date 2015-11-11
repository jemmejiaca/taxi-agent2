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
	
	static String logText = "";
	JAmbientPanel ambientPanel;
	JMainFrame mainFrame;
	JTextArea log = new JTextArea(30, 35);
	JScrollPane scrollPane = new JScrollPane(log);
	JButton buttonAccept = new JButton("Accept");
	Container contentPane = getContentPane();
	GroupLayout layout = new GroupLayout(contentPane);
	Font logFont = new Font("Courier New", Font.PLAIN, 14);
	
	public JAmbientFrame(int state, int rows, int cols, JMainFrame mainFrame) {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.mainFrame = mainFrame;
		//contentPane.setLayout(layout);
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);
		
		//setLayout(new FlowLayout());
		ambientPanel = new JAmbientPanel(state, rows, cols, this);
		add(ambientPanel, BorderLayout.CENTER);
		log.setEditable(false);
		log.setFont(logFont);
		add(scrollPane, BorderLayout.EAST);
		buttonAccept.addActionListener(this);
		add(buttonAccept, BorderLayout.SOUTH);
		setSize(1000, 700);
		setResizable(false);
		//pack();
		setLocationRelativeTo(null);
		
	}
	
	public void setLog(String msg) {
		logText += (" > " + msg + "\n");
		log.setText(logText);
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
		Object source = e.getSource();
		if(source == buttonAccept) {
			if (ambientPanel.isAgentSetted()) {
				buttonAccept.setText("Enough Requests!");
				ambientPanel.setState(JAmbientPanel.SETTING_REQUESTS);
			}
		}
		
	}

}
