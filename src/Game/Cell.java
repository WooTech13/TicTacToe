package Game;

public class Cell {
	private char value;
	
	public Cell() {
		this.setValue(' ');
	}
	
	public Cell(char c) {
		this.setValue(c);
	}
	
	public char getValue() {
		return this.value;
	}
	
	public void setValue(char value) {
		this.value = value;
	}

}
