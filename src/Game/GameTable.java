package Game;

public class GameTable {
	private Cell[][] table;
	
	public GameTable() {
		this.table = new Cell[3][3];
		this.setTable();
	}

	public Cell[][] getTable() {
		return table;
	}

	public void setTable(Cell[][] table) {
		this.table = table;
	}
	
	public void setTable() {
		int x,y;
		for(x=0;x<3;x++) {
			for(y=0;y<3;y++) {
				this.table[x][y] = new Cell(' ');
			}
		}
	}
	
	public char getCellValue(int[] pos) {
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
	
}
