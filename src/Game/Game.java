package Game;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Game {
	
	private GameTable table;
	private Player player1, player2;
	private static final String REG_OX = "^[OX]$";
	
	public Game() {
		this.setTable(new GameTable());
		this.setPlayers();
		this.run();
	}

	public GameTable getTable() {
		return table;
	}

	public void setTable(GameTable table) {
		this.table = table;
	}
	
	public Player getPlayer1() {
		return player1;
	}

	public void setPlayer1(Player player1) {
		this.player1 = player1;
	}

	public Player getPlayer2() {
		return player2;
	}

	public void setPlayer2(Player player2) {
		this.player2 = player2;
	}
	
	public void setPlayers() {
		Scanner in = new Scanner(System.in);
		String name, sign;
		
		System.out.print("Name of player 1 : ");
		name = in.nextLine();
		
		System.out.print("Sign of player 1 ('O' or 'X') : ");
		sign = in.nextLine();
		boolean signGood = false;
		while(signGood==false) {
			if(Pattern.matches(REG_OX, sign)) {
				signGood=true;
			} else {
				System.out.print("Wrong format.\nSign of player 1 ('O' or 'X') : ");
				sign = in.nextLine();
			}
		}
		this.setPlayer1(new Player(name,sign.charAt(0)));
		
		System.out.print("Name of player 2 : ");
		name = in.nextLine();
		
		if(sign.charAt(0)=='O') {
			this.setPlayer2(new Player(name, 'X'));
		} else {
			this.setPlayer2(new Player(name, 'O'));
		}
		//in.close();
	}
	
	public void run() {
		int pos[] = new int[2];
		while(true) {
			this.table.printTable();
			pos = this.askPlayer(this.player1);
			if(this.table.isWin(pos)) {
				this.table.printTable();
				System.out.print("\n"+this.player1.getNom()+" won ! End of the game");
				System.exit(0);
			} else if(this.table.isDraw()) {
				this.table.printTable();
				System.out.print("\nDraw... End of the game");
				System.exit(0);
			}
			
			this.table.printTable();
			pos = this.askPlayer(this.player2);
			if(this.table.isWin(pos)) {
				this.table.printTable();
				System.out.print("\n"+this.player2.getNom()+" won ! End of the game");
				System.exit(0);
			} else if(this.table.isDraw()) {
				this.table.printTable();
				System.out.print("\nDraw... End of the game");
				System.exit(0);
			}
		}
	}
	
	public int[] askPlayer(Player player) {
		Scanner in = new Scanner(System.in);
		String reg = "^[0-2],[0-2]$";
		String cellPos;
		boolean cellGood = false;
		int[] pos = new int[2];
		
		System.out.print(player.getNom()+" turn, cell to play (top-left cell is 0,0, format is x,y) ?  ");
		cellPos = in.nextLine();
		while(cellGood==false) {
			if(Pattern.matches(reg, cellPos)) {
				pos[0] = Integer.parseInt(cellPos.split(",")[0]);
				pos[1] = Integer.parseInt(cellPos.split(",")[1]);
				cellGood=true;
			} else {
				System.out.print("Wrong format.\nCell (top-left cell is 0,0, format is x,y : ");
				cellPos = in.nextLine();
			}
		}		

		this.table.getTable()[pos[1]][pos[0]].setValue(player.getSign());
		return pos;
		
	}
	

}
