package co.edu.unal.isi.taxiagent2.gui;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

import com.sun.xml.internal.ws.api.Component;

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
		if (source == buttonOK) {
			if (environmentCreationPanel.radioButtonManually.isSelected()) {
				int rows = environmentCreationPanel.getRows();
				int cols = environmentCreationPanel.getCols();
			} else if (environmentCreationPanel.radioButtonLoadFile.isSelected()) {
				File mapFile = environmentCreationPanel.getMapFile();
			}
			this.setVisible(false);
		}
	}

}
