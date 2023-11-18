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

}
