package GUI;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.border.LineBorder;

public class GCell extends JButton {
	private static final long serialVersionUID = 1L;
	private char value;
	
	public GCell() {
		super();
		this.setValue(Character.MIN_VALUE);
		
		this.setBackground(Color.white);
		this.setBorder(new LineBorder(Color.black));
		this.setFont(new Font("Arial", Font.PLAIN, 40));
		this.setText(""+this.getValue());
	}
	
	public GCell(char c) {
		this.setValue(c);
	}
	
	public char getValue() {
		return this.value;
	}
	
	public void setValue(char value) {
		this.value = value;
		this.setText(""+this.value);
	}
}
