package co.edu.unal.isi.taxiagent2.gui;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class JGeneticAlgorithmParametersPanel extends JPanel {
	JLabel labelPoblationSize = new JLabel("Poblation Size:");
	JLabel labelNumOfGenerations = new JLabel("Number of generations:");
	JLabel labelCrossoverRate = new JLabel("Crossover Rate:");
	JLabel labelMutationRate  = new JLabel("Mutation Rate:");
	JRadioButton radioButtonElitism = new JRadioButton("Elitism");
	JTextField textFieldPoblationSize = new JTextField(4);
	JTextField textFieldNumOfGenerations = new JTextField(4);
	JTextField textFieldCrossoverRate = new JTextField(4);
	JTextField textFieldMutationRate = new JTextField(4);
	JPanel poblationSizePanel = new JPanel(new FlowLayout());
	JPanel numOfGenerationsPanel = new JPanel(new FlowLayout());
	JPanel crossoverRatePanel = new JPanel(new FlowLayout());
	JPanel mutationRatePanel = new JPanel(new FlowLayout());
	
	public JGeneticAlgorithmParametersPanel() {
		setLayout(new GridLayout(5, 1));
		setBorder(BorderFactory.createTitledBorder("Genetic Algorithm Parameters"));
		poblationSizePanel.add(labelPoblationSize);
		poblationSizePanel.add(textFieldPoblationSize);
		add(poblationSizePanel);
		numOfGenerationsPanel.add(labelNumOfGenerations);
		numOfGenerationsPanel.add(textFieldNumOfGenerations);
		add(numOfGenerationsPanel);
		add(radioButtonElitism);
		crossoverRatePanel.add(labelCrossoverRate);
		crossoverRatePanel.add(textFieldCrossoverRate);
		add(crossoverRatePanel);
		mutationRatePanel.add(labelMutationRate);
		mutationRatePanel.add(textFieldMutationRate);
		add(mutationRatePanel);
		
	}

}
