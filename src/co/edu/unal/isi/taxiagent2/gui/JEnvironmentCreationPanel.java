package co.edu.unal.isi.taxiagent2.gui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class JEnvironmentCreationPanel extends JPanel implements ItemListener, ActionListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1730252931506111774L;
	
	static final String BORDER_TITLE = "Environment Creation";
	JRadioButton radioButtonManually = new JRadioButton("Manually");
	JRadioButton radioButtonLoadFile = new JRadioButton("Load file (*.tae)");
	JAmbientSizePanel ambientSizePanel = new JAmbientSizePanel();
	JSearchFilePanel searchFilePanel = new JSearchFilePanel();
	JFileChooser fileChooser = new JFileChooser();
	JTaxiMaximumQuotaPanel taxiMaximumQuotaPanel = new JTaxiMaximumQuotaPanel();
	ButtonGroup group = new ButtonGroup();
	private int nRows, nCols;
	private File mapFile;
	
	public JEnvironmentCreationPanel() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBorder(BorderFactory.createTitledBorder(BORDER_TITLE));
		radioButtonManually.addItemListener(this);
		add(radioButtonManually);
		group.add(radioButtonManually);
		add(ambientSizePanel);
		radioButtonLoadFile.addItemListener(this);
		add(radioButtonLoadFile);
		group.add(radioButtonLoadFile);
		searchFilePanel.btSearch.addActionListener(this);
		add(searchFilePanel);
		add(taxiMaximumQuotaPanel);
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		Object source = e.getItem();
		int select = e.getStateChange();
		if (source == radioButtonManually) {
			if (select == ItemEvent.SELECTED) {
				ambientSizePanel.colsField.setEditable(true);
				ambientSizePanel.rowsField.setEditable(true);
				searchFilePanel.btSearch.setEnabled(false);
				searchFilePanel.tfFile.setEditable(false);
			}
			else {
				ambientSizePanel.colsField.setEditable(false);
				ambientSizePanel.rowsField.setEditable(false);
				searchFilePanel.btSearch.setEnabled(true);
				searchFilePanel.tfFile.setEditable(true);
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if (source == searchFilePanel.btSearch) {
			int returnValue = fileChooser.showOpenDialog(this);
			if (returnValue == JFileChooser.APPROVE_OPTION)
				mapFile = fileChooser.getSelectedFile();
		}
	}

	public int getRows() {
		return Integer.parseInt(ambientSizePanel.rowsField.getText());
	}

	public int getCols() {
		return Integer.parseInt(ambientSizePanel.colsField.getText());
	}

	public File getMapFile() {
		return mapFile;
	}

	public void setMapFile(File mapFile) {
		this.mapFile = mapFile;
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
	public JButton btSearch = new JButton("Search");
	
	public JSearchFilePanel() {
		setLayout(new FlowLayout());
		add(btSearch);
		add(tfFile);
		
	}

}

class JTaxiMaximumQuotaPanel extends JPanel {
	JLabel labelTaxiQuota = new JLabel("Taxi Quota:");
	JTextField fieldTaxiQuota = new JTextField(2);
	
	public JTaxiMaximumQuotaPanel() {
		setLayout(new FlowLayout());
		add(labelTaxiQuota);
		add(fieldTaxiQuota);
	}
	
}
