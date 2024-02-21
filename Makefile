run: GUI
	java -classpath ./bin/ Main.Main

GUI: 
	javac -d bin/ src/GUI/GCell.java
	javac -cp bin/ -d bin/ src/Game/Player.java
	javac -cp bin/ -d bin/ src/GUI/GGame.java
	javac -cp bin/ -d bin/ src/Main/Main.java

clean: 
	rm bin/GUI/*.class
	rm bin/Game/*.class
	rm bin/Main/*.class