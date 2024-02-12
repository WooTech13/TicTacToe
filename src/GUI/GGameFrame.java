package GUI;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class GGameFrame extends JFrame implements ActionListener {
	private GCell[][] table;
	
	public GGameFrame() {
		super("TicTacToe game !");
		this.setSize(600,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.table = new GCell[3][3];
		this.setLayout(new GridLayout(3,3));
		this.setTable();
		
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	public GCell[][] getTable() {
		return table;
	}

	public void setTable(GCell[][] table) {
		this.table = table;
	}
	
	public void setTable() {
		int x,y;
		for(y=0;y<3;y++) {
			for(x=0;x<3;x++) {
				this.table[y][x] = new GCell();
				this.table[y][x].addActionListener(this);
				this.add(this.table[y][x]);
			}
		}
	}
	
	public char getGCellValue(int[] pos) {
		return this.table[pos[1]][pos[0]].getValue();
	}
	
	public void printTable() {
		int x,y;
		System.out.print("-------------\n");
		for(x=0;x<3;x++) {
			for(y=0;y<3;y++) {
				System.out.print("| "+this.table[x][y].getValue()+" ");
			}
			System.out.print("|\n-------------\n");
		}
	}
	
	public boolean isDraw() {
		int x,y;
		for(x=0;x<3;x++) {
			for(y=0;y<3;y++) {
				if(this.table[y][x].getValue()==' ') {
					return false;
				}
			}
		}
		return true;
	}
	
	public boolean isWin(int[] pos) {
		int x = pos[0],y = pos[1];
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
	
	public boolean verifDiagTopLeft(char sign) {
		if((this.table[0][0].getValue() == sign) && (this.table[1][1].getValue() == sign) && (this.table[2][2].getValue() == sign)) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean verifDiagTopRight(char sign) {
		if((this.table[0][2].getValue() == sign) && (this.table[1][1].getValue() == sign) && (this.table[2][0].getValue() == sign)) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean verifDiag(int offset, char sign) {
		if((this.table[0][0+offset].getValue() == sign) && (this.table[1][1].getValue() == sign) && (this.table[2][0+offset].getValue() == sign)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		int x,y;
		for(y=0;y<3;y++) {
			for(x=0;x<3;x++) {
				if((GCell) arg0.getSource() == this.table[y][x]) {
					System.out.println("Cell "+x+","+y);
				}
			}
		}
		
	}
	
}
