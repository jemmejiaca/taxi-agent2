package co.edu.unal.isi.taxiagent2.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class JRequestGenerationPanel extends JPanel {
	JRadioButton radioButtonManually = new JRadioButton("Manually");
	JRadioButton radioButtonRandomly = new JRadioButton("Randomly");
	JProbabilitySelectionPanel probSelectionPanel = new JProbabilitySelectionPanel();
	
	public JRequestGenerationPanel() {
		setLayout(new GridLayout(3, 1));
		setBorder(BorderFactory.createTitledBorder("Request Generation"));
		add(radioButtonManually);
		add(radioButtonRandomly);
		add(probSelectionPanel);
	}

}

class JProbabilitySelectionPanel extends JPanel {
	//String[] probDistributionsNames = {"Uniform", "Poisson", "Normal", };
	JLabel labelProbability = new JLabel("Probability Distribution:");
	//JComboBox<String> cmbBoxProbability = new JComboBox<>();
	JTextField fieldProbability = new JTextField(3);
	
	public JProbabilitySelectionPanel() {
		setLayout(new FlowLayout());
		add(labelProbability);
		add(fieldProbability);
	}
}