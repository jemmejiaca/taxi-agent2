package co.edu.unal.isi.taxiagent2.gui;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class JEnvironmentCreationPanel extends JPanel implements ItemListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1730252931506111774L;
	
	static final String BORDER_TITLE = "Environment Creation";
	JRadioButton rbManually = new JRadioButton("Manually");
	JRadioButton rbLoadFile = new JRadioButton("Load file (*.tae)");
	JAmbientSizePanel ambientSizePanel = new JAmbientSizePanel();
	JSearchFilePanel searchFilePanel = new JSearchFilePanel();
	ButtonGroup group = new ButtonGroup();
	
	public JEnvironmentCreationPanel() {
		setLayout(new GridLayout(4, 1, 0, 0));
		setBorder(BorderFactory.createTitledBorder(BORDER_TITLE));
		add(rbManually);
		group.add(rbManually);
		add(ambientSizePanel);
		add(rbLoadFile);
		group.add(rbLoadFile);
		add(searchFilePanel);
		
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		Object source = e.getItem();
		
		if(group.isSelected((ButtonModel) rbManually)) searchFilePanel.tfFile.setEditable(false);
		else if (group.isSelected((ButtonModel) rbLoadFile)) ambientSizePanel.rowsField.setEditable(false);
			
		if (source == rbManually) {
			int select = e.getStateChange();
			if(select == ItemEvent.SELECTED) {
				ambientSizePanel.rowsField.setEditable(true);
				ambientSizePanel.colsField.setEnabled(true);
				searchFilePanel.btSearch.setEnabled(false);
				searchFilePanel.tfFile.setEditable(false);
			}
		}
		else if(source == rbLoadFile) {
			int select = e.getStateChange();
			if(select == ItemEvent.SELECTED) {
				ambientSizePanel.rowsField.setEnabled(false);
				ambientSizePanel.colsField.setEnabled(false);
				searchFilePanel.btSearch.setEnabled(true);
				searchFilePanel.tfFile.setEditable(true);
			}
		}
	}
	
	
	
}

class JAmbientSizePanel extends JPanel {
	JLabel rowsLabel = new JLabel("Rows:");
	JLabel colsLabel = new JLabel("Columns:");
	JTextField rowsField = new JTextField(3);
	JTextField colsField = new JTextField(3);
	
	public JAmbientSizePanel() {
		setLayout(new FlowLayout());
		add(rowsLabel);
		add(rowsField);
		add(colsLabel);
		add(colsField);
	}
	
}

class JSearchFilePanel extends JPanel {
	
	JTextField tfFile = new JTextField(10);
	JButton btSearch = new JButton("Search");
	
	public JSearchFilePanel() {
		setLayout(new FlowLayout());
		add(btSearch);
		add(tfFile);
		
	}

}
