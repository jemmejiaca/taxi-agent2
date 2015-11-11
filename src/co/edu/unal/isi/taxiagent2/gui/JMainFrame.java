package co.edu.unal.isi.taxiagent2.gui;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * The main frame: this is the entry point of the program.
 * @author Mauricio Mejía
 *
 */
public class JMainFrame extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5627287861308361593L;
	JEnvironmentCreationPanel environmentCreationPanel = new JEnvironmentCreationPanel();
	JRequestGenerationPanel requestGenerationPanel = new JRequestGenerationPanel();
	JGeneticAlgorithmParametersPanel geneticAlgorithmParametersPanel = new JGeneticAlgorithmParametersPanel();
	JButton buttonOK = new JButton("Accept");
	Container contentPane = getContentPane();
	
	public JMainFrame() {
		super("Taxi Agent 2");
		setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		contentPane.add(environmentCreationPanel);
		contentPane.add(requestGenerationPanel);
		contentPane.add(geneticAlgorithmParametersPanel);
		buttonOK.addActionListener(this);
		contentPane.add(buttonOK);
		
		setSize(290, 520);
		setResizable(false);
		pack();
		setLocationRelativeTo(null);
		
	}

	public static void main(String[] args) {
		JMainFrame mainFrame = new JMainFrame();
		mainFrame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		JAmbientFrame ambientFrame = null;
		int rows = -1, cols = -1;
		if (source == buttonOK) {
			if (environmentCreationPanel.radioButtonManually.isSelected()) {
				rows = environmentCreationPanel.getRows();
				cols = environmentCreationPanel.getCols();
				ambientFrame = new JAmbientFrame(JAmbientPanel.SETTING_ROAD, rows, cols, this);
				
			} else if (environmentCreationPanel.radioButtonLoadFile.isSelected()) {
				File mapFile = environmentCreationPanel.getMapFile();
				try {
					BufferedReader br = new BufferedReader(new FileReader(mapFile));
					String line = br.readLine();
					String[] rawFirstLine = line.split(" ");
					rows = Integer.parseInt(rawFirstLine[0]);
					cols = Integer.parseInt(rawFirstLine[1]);
					System.out.printf("%s, %s\n", rows, cols);
					String[] strs = new String[rows];
					ambientFrame = new JAmbientFrame(JAmbientPanel.SETTING_TAXI_AGENT, rows, cols, this);
					ambientFrame.buttonAccept.setEnabled(false);
					int i = 0;
					while (line != null && i < rows) {
						line = br.readLine();
						strs[i] = line;
						System.out.println(strs[i]);
						i++;
					}
					ambientFrame.parseString(strs);
					ambientFrame.setLog("Loaded file: " + mapFile.getName());
					br.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
			}
			ambientFrame.setLog("Size of the ambient " + rows + "x" + cols);
			this.setVisible(false);
			ambientFrame.setVisible(true);
		}
	}

}
