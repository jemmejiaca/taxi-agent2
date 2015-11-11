package co.edu.unal.isi.taxiagent2.gui;

import java.awt.BorderLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import co.edu.unal.isi.taxiagent2.util.SpringUtilities;

public class JGeneticAlgorithmParametersPanel extends JPanel implements ItemListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8732798162584414587L;
	JGeneticAlgorithmParametersAuxPanel auxPanel = new JGeneticAlgorithmParametersAuxPanel();
	JRadioButton radioButtonElitism = new JRadioButton("Elitism");

	public JGeneticAlgorithmParametersPanel() {
		//setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBorder(BorderFactory.createTitledBorder("Genetic Algorithm Parameters"));
		add(auxPanel, BorderLayout.CENTER);
		radioButtonElitism.addItemListener(this);
		add(radioButtonElitism, BorderLayout.SOUTH);
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub

	}
}

class JGeneticAlgorithmParametersAuxPanel extends JPanel {

	JLabel labelPoblationSize = new JLabel("Poblation Size:", JLabel.TRAILING);
	JLabel labelNumOfGenerations = new JLabel("Number of generations:", JLabel.TRAILING);
	JLabel labelCrossoverRate = new JLabel("Crossover Rate:", JLabel.TRAILING);
	JLabel labelMutationRate = new JLabel("Mutation Rate:", JLabel.TRAILING);

	JTextField textFieldPoblationSize = new JTextField(4);
	JTextField textFieldNumOfGenerations = new JTextField(4);
	JTextField textFieldCrossoverRate = new JTextField(4);
	JTextField textFieldMutationRate = new JTextField(4);

	public JGeneticAlgorithmParametersAuxPanel() {
		setLayout(new SpringLayout());

		add(labelPoblationSize);
		labelPoblationSize.setLabelFor(textFieldPoblationSize);
		add(textFieldPoblationSize);

		add(labelNumOfGenerations);
		labelNumOfGenerations.setLabelFor(textFieldNumOfGenerations);
		add(textFieldNumOfGenerations);

		add(labelCrossoverRate);
		labelCrossoverRate.setLabelFor(textFieldCrossoverRate);
		add(textFieldCrossoverRate);

		add(labelMutationRate);
		labelMutationRate.setLabelFor(textFieldMutationRate);
		add(textFieldMutationRate);

		SpringUtilities.makeCompactGrid(this, 4, 2, 6, 6, 6, 6);
	}

}
