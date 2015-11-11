package co.edu.unal.isi.taxiagent2.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class JRequestGenerationPanel extends JPanel implements ItemListener {
	JRadioButton radioButtonManually = new JRadioButton("Manually");
	JRadioButton radioButtonRandomly = new JRadioButton("Randomly");
	JProbabilitySelectionPanel probSelectionPanel = new JProbabilitySelectionPanel();
	ButtonGroup group = new ButtonGroup();
	
	public JRequestGenerationPanel() {
		setLayout(new GridLayout(3, 1));
		setBorder(BorderFactory.createTitledBorder("Request Generation"));
		radioButtonManually.addItemListener(this);
		radioButtonRandomly.addItemListener(this);
		add(radioButtonManually);
		add(radioButtonRandomly);
		add(probSelectionPanel);
		group.add(radioButtonManually);
		group.add(radioButtonRandomly);
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		Object source = e.getItem();
		int select = e.getStateChange();
		if (source == radioButtonManually) {
			if (select == ItemEvent.DESELECTED) {
				probSelectionPanel.fieldProbability.setEditable(true);
			}
			else {
				probSelectionPanel.fieldProbability.setEditable(false);
			}
		}
	}

}

class JProbabilitySelectionPanel extends JPanel {
	//String[] probDistributionsNames = {"Uniform", "Poisson", "Normal", };
	JLabel labelProbability = new JLabel("Probability:");
	//JComboBox<String> cmbBoxProbability = new JComboBox<>();
	JTextField fieldProbability = new JTextField(3);
	
	public JProbabilitySelectionPanel() {
		setLayout(new FlowLayout());
		add(labelProbability);
		add(fieldProbability);
	}
}