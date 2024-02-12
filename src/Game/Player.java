package Game;

public class Player {
	
	private String nom;
	private char sign;
	
	public Player(String nom, char sign) {
		this.setNom(nom);
		this.setSign(sign);
	}
	public Player() {
		this.setNom("");
		this.setSign(' ');
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public char getSign() {
		return sign;
	}

	public void setSign(char sign) {
		this.sign = sign;
	}

	@Override
	public String toString(){
		return String.format("Name : %s, sign : %c.", this.getNom(), this.getSign());
	}

}
