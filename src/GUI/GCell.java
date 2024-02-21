package GUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.border.LineBorder;

public class GCell extends JButton implements ActionListener{
	private static final long serialVersionUID = 1L;
	private char value;
	
	public GCell() {
		super();
		this.setValue(Character.MIN_VALUE);
		this.setBackground(new Color(255,255,255));
		this.setBorder(new LineBorder(Color.BLACK));
		this.setText(""+this.getValue());
		//this.addActionListener(this);
	}
	
	public GCell(JButton but) {
		
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

	@Override
	public void actionPerformed(ActionEvent arg0) {
		System.out.println((GCell) arg0.getSource());
		
	}

}
