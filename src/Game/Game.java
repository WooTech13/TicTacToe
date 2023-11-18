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
		this.table.printTable();
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
			this.setPlayer2(new Player(name, 'O'));
		} else {
			this.setPlayer2(new Player(name, 'X'));
		}
		in.close();
	}
	
	public void run() {
		Scanner in = new Scanner(System.in);
		boolean end = false;
		while(end==false) {
			
		}
		in.close();
	}
	
	public void askPlayer() {
		Scanner in = new Scanner(System.in);
		String reg = "^[0-2],[0-2]$";
		int x,y;
		
		System.out.print("Cell (top-left cell is 0,0, format is x,y : ");
		String cell = in.nextLine();
		boolean cellGood = false;
		while(cellGood==false) {
			if(Pattern.matches(reg, cell)) {
				x = cell.charAt(0);
				y = cell.charAt(2);
				cellGood=true;
			} else {
				System.out.print("Wrong format.\nCell (top-left cell is 0,0, format is x,y : ");
				cell = in.nextLine();
			}
		}
		in.close();
		
	}
	

}
