package Main;

import Game.Game;

public class Main {

	public static void main(String[] args) {
		System.out.println("Hello");
		System.out.print("\033\143");
		Game g = new Game();
		System.out.println(g.getPlayer1().getNom());
		System.out.println(g.getPlayer2().getNom());
	}
}
