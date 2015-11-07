package co.edu.unal.isi.taxiagent2.gui;

import java.awt.GridLayout;
import java.awt.HeadlessException;

import javax.swing.BoxLayout;
import javax.swing.JFrame;

/**
 * The main frame: this is the entry point of the program.
 * @author Mauricio Mejía
 *
 */
public class JMainFrame extends JFrame {
	JEnvironmentCreationPanel envirnmentCreationPanel = new JEnvironmentCreationPanel();
	JRequestGenerationPanel requestGenerationPanel = new JRequestGenerationPanel();
	JGeneticAlgorithmParametersPanel geneticAlgorithmParametersPanel = new JGeneticAlgorithmParametersPanel();
	
	public JMainFrame() {
		super("Taxi Agent 2");
		setLayout(new GridLayout(3, 1));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		add(envirnmentCreationPanel);
		add(requestGenerationPanel);
		add(geneticAlgorithmParametersPanel);
		
		setSize(400, 400);
		pack();
	}

	public static void main(String[] args) {
		JMainFrame mainFrame = new JMainFrame();
		mainFrame.setVisible(true);
	}

}
