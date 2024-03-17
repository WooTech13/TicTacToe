package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.MenuBar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import Game.Player;

public class GGame extends JFrame implements ActionListener{

	private Player[] players;
	private GCell[][] table;
	private int playerToPlay = 0;
	private static final String REG_OX = "^[OX]$";
	private JPanel panTop,panMid;
	private JLabel stateLabel;

	private JMenuBar bar;
	private JMenu file;
	private JMenuItem newG, quit;
	
	public GGame() {
		super("TicTacToe game !");
		this.setFrame();

		this.setPlayers();
		this.setStateLabel(this.players[this.playerToPlay].getNom()+" turn", Color.orange);
	}

	public GCell[][] getTable() {
		return table;
	}

	public void setTable(GCell[][] table) {
		this.table = table;
	}
	
	public void setTable() {
		this.table = new GCell[3][3];
		int x,y;
		for(y=0;y<3;y++) {
			for(x=0;x<3;x++) {
				this.table[y][x] = new GCell();
				this.table[y][x].addActionListener(this);
				this.panMid.add(this.table[y][x]);
			}
		}
	}

	public void setFrame(){
		bar = new JMenuBar();
		file = new JMenu("File");
		newG = new JMenuItem("New");
		newG.addActionListener(this);
		quit = new JMenuItem("Quit");
		
		file.add(newG);
		file.add(quit);
		bar.add(file);

		this.setJMenuBar(bar);

		panTop = new JPanel();
		stateLabel = new JLabel();
		this.setStateLabel("Configuring players...", Color.orange);
		panTop.add(stateLabel);

		panMid = new JPanel();
		panMid.setLayout(new GridLayout(3,3));
		this.setTable();

		this.add(panTop, BorderLayout.NORTH);
		this.add(panMid, BorderLayout.CENTER);

		this.setSize(600,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	public void setStateLabel(String text, Color color){
		this.stateLabel.setText(text);
		this.panTop.setBackground(color);
	}
	
	public void changePlayer(){
		this.playerToPlay = (this.playerToPlay+1)%2;
	}

	public void setPlayers() {
		this.players = new Player[2];
		this.players[0] = new Player();
		this.players[1] = new Player();

		JPanel pan = new JPanel();
		pan.setLayout(new BoxLayout(pan, BoxLayout.Y_AXIS));
		ButtonGroup bgp = new ButtonGroup();
        JRadioButton button1 = new JRadioButton("O");
		button1.setActionCommand("O");
		button1.setSelected(true);
        JRadioButton button2 = new JRadioButton("X");
		button2.setActionCommand("X");
		
		bgp.add(button1);
		bgp.add(button2);
        JLabel labNameP1 = new JLabel("Player 1 name :");
        JLabel labNameP2 = new JLabel("Player 2 name :");
        JTextField nameP1 = new JTextField("",20);
        JTextField nameP2 = new JTextField("",20);
        JLabel labSign = new JLabel("Player1 sign :");
        JPanel top = new JPanel();
        top.setLayout(new FlowLayout());
        JPanel middle = new JPanel();
        middle.setLayout(new FlowLayout());
        JPanel bottom = new JPanel();
        bottom.setLayout(new FlowLayout());
        
        top.add(labNameP1);
        top.add(nameP1);
        
        middle.add(labSign);
        middle.add(button1);
        middle.add(button2);
        
        bottom.add(labNameP2);
        bottom.add(nameP2);
        
        pan.add(top);
        pan.add(middle);
        pan.add(bottom);
		JOptionPane.showMessageDialog(null, pan);
		this.players[0].setNom(nameP1.getText());
		this.players[1].setNom(nameP2.getText());
		if(bgp.getSelection().getActionCommand().charAt(0) == 'X'){
			this.players[0].setSign('X');
			this.players[1].setSign('O');
		} else {
			this.players[0].setSign('O');
			this.players[1].setSign('X');
		}
	}

	public boolean isDraw() {
		int x,y;
		for(x=0;x<3;x++) {
			for(y=0;y<3;y++) {
				if(this.table[y][x].getValue()==Character.MIN_VALUE) {
					return false;
				}
			}
		}
		return true;
	}

	
	
	public boolean isWin(int[] pos) {
		int y = pos[0],x = pos[1];
		boolean isWin = false;
		char sign = this.table[y][x].getValue();
		
		if((x+y==0) || (x+y==4)) {
			isWin = this.verifVert(x,sign) || this.verifHori(y, sign) || this.verifDiag(0,sign);
		} else if((x+y==2) && (x!=y)){
			isWin = this.verifVert(x,sign) || this.verifHori(y, sign) || this.verifDiag(2,sign);
		} else if((x+y==1) || (x+y==3)) {
			isWin = this.verifVert(x,sign) || this.verifHori(y, sign);
		} else {
			isWin = this.verifVert(x,sign) || this.verifHori(y, sign) || this.verifDiag(0,sign) || this.verifDiag(2,sign);
		}
		if(isWin) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean verifVert(int x, char sign) {
		if((this.table[0][x].getValue() == sign) && (this.table[1][x].getValue() == sign) && (this.table[2][x].getValue() == sign)) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean verifHori(int y, char sign) {
		if((this.table[y][0].getValue() == sign) && (this.table[y][1].getValue() == sign) && (this.table[y][2].getValue() == sign)) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean verifDiag(int offset, char sign) {
		if((this.table[0][0+offset].getValue() == sign) && (this.table[1][1].getValue() == sign) && (this.table[2][2-offset].getValue() == sign)) {
			return true;
		} else {
			return false;
		}
	}
	@Override
	public void actionPerformed(ActionEvent event) {
		System.out.println(event.getSource().getClass());
		if(event.getSource().getClass());
		/*int x,y;
		for(y=0;y<3;y++) {
			for(x=0;x<3;x++) {
				if((GCell) event.getSource() == this.table[y][x]) {
					this.table[y][x].setEnabled(false);
					this.table[y][x].setValue(this.players[this.playerToPlay].getSign());

					int pos[] = {y,x};
					System.out.println("y="+pos[0]);
					System.out.println("x="+pos[1]);
					this.run(pos);
				}
			}
		}*/
	}

	public void endGame() {
		int x,y;
		for(y=0;y<3;y++) {
			for(x=0;x<3;x++) {
				this.table[y][x].setEnabled(false);
			}
		}
	}
	
	public void run(int[] pos) {
			if(this.isWin(pos)) {
				this.setStateLabel(this.players[this.playerToPlay].getNom()+" win !", Color.green);
				this.endGame();
			} else if(this.isDraw()) {
				this.setStateLabel("Nobody win...", Color.red);
				this.endGame();
			} else {
				this.changePlayer();
				this.setStateLabel(this.players[this.playerToPlay].getNom()+" turn", Color.orange);
			}
	}
}
