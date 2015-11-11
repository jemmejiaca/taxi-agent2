package co.edu.unal.isi.taxiagent2.gui;
import javax.swing.JPanel;

import co.edu.unal.isi.taxiagent2.model.Position;

public class JCell extends JPanel {

	private int width, height;
	private Position position;
	//JAmbientFrame ambient;
	
	public JCell(int width, int height) {//), JAmbient ambient) {
		this.width = width;
		this.height = height;
		//this.ambient = ambient;
		setSize(this.width, this.height);
	}
	
	public void setPosition(Position position) {
		this.position = position;
	}
	
	public Position getPosition() {
		return position;
	}

}