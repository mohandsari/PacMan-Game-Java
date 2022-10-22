package prototype;

import java.awt.Color;

public class Game {
	private Gui gui;
	private int[][] map;
	private Pacman pacman;
	private Scary[] fantomes;
	private int score;
	private int speed;
	private boolean checkLife;
	private int nbGommes;
	private int thisMap;
	
	public Game() {
		this.map = mapDownload1();
		this.pacman = new Pacman(this, new Point(1, 2));
		this.fantomes = new Scary[4];
		createFantomes();
		this.speed = 400;
		this.checkLife = false;
	}
	
	public void setGui(Gui gui) {
		this.gui = gui;
	}

	public int getValeur(int x, int y) {
		return map[x][y];
	}

	public void setValeur(int x, int y, int valeur) {
		map[x][y] = valeur;
	}

	public Pacman getPacman() {
		return pacman;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public Scary getFantome(int i) {
		return fantomes[i];
	}
	
	public int getNbGommes() {
		return nbGommes;
	}

	public void setNbGommes(int nbGommes) {
		this.nbGommes = nbGommes;
	}
	
	private int[][] mapDownload1() {
		int[][] c = {
				{9,  -1,  0, -1, -1, -1, -1, -1, -1, -1,  0, -1, -1, -1, -1,  0, -1, -1, -1, -1, -1},
				{9,  -1,  1,  3,  1, -1,  1,  1,  1,  1,  1,  2,  1,  1,  1,  1, -1,  1,  1,  2, -1},
				{9,  -1,  1, -1,  1, -1,  1, -1, -1,  1, -1,  1, -1, -1, -1,  1, -1,  1, -1,  1, -1},
				{9,  -1,  1, -1,  1,  1,  1,  1,  1,  1, -1,  1,  1,  1,  1,  1,  1,  1, -1,  1, -1},
				{9,  -1,  1, -1,  1, -1,  1,  1, -1, -1, -1, -1, -1,  1, -1, -1, -1,  1, -1,  1, -1},
				{9,  -1,  1,  1,  1, -1,  1,  1,  1,  1, -1,  1,  1,  1, -1,  1,  1,  1,  1,  1, -1},
				{9,  -1,  1, -1, -1, -1,  1, -1, -1,  1, -1,  1, -1,  1, -1,  1,  1, -1, -1,  1, -1},
				{9,  -1,  1,  1,  1,  1,  1, -1, -1,  1,  1,  1, -1,  1,  1,  1,  1, -1, -1,  1, -1},
				{9,  -1,  1, -1,  1, -1,  1,  2,  1,  1, -1,  1,  1,  1,  1,  1,  1, -1, -1,  3, -1},
				{9,   0,  3, -1,  1, -1,  1, -1, -1,  1, -1,  1, -1, -1,  2, -1,  1, -1, -1,  1,  0},
				{9,  -1,  1, -1,  1, -1,  1, -1, -1,  1,  4,  1, -1, -1,  1, -1,  1, -1, -1,  1, -1},
				{9,  -1,  1, -1,  1, -1,  1, -1, -1,  1, -1,  1, -1, -1,  1, -1,  1, -1, -1,  1, -1},
				{9,  -1,  1, -1,  1, -1,  1, -1, -1,  1, -1,  1, -1, -1,  1, -1,  1, -1, -1,  1, -1},
				{9,  -1,  1, -1,  1, -1,  1,  1,  1,  1,  1,  1,  1,  1,  1, -1,  1, -1, -1,  1, -1},
				{9,  -1,  1,  1,  1,  1,  1,  2,  1, -1, -1, -1, -1,  1,  1,  1,  1,  1,  1,  1, -1},
				{9,  -1,  1, -1,  1, -1, -1, -1,  1,  1,  1,  1,  1,  1, -1, -1, -1,  1, -1,  1, -1},
				{9,  -1,  1, -1,  1,  1,  1, -1,  1, -1, -1, -1, -1,  1, -1,  1,  1,  1, -1,  1, -1},
				{9,  -1,  1, -1,  1, -1,  1, -1,  1, -1, -1, -1, -1,  1, -1,  1, -1,  1, -1,  1, -1},
				{9,  -1,  3,  1,  1, -1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1, -1,  1,  1,  3, -1},
				{9,  -1,  0, -1, -1, -1, -1, -1, -1, -1,  0, -1, -1, -1, -1,  0, -1, -1, -1, -1, -1},
		};
		nbGommes = 178;
		thisMap = 1;
		return c;
	}
	
	private int[][] mapDownload3() {
		int[][] c = {
				{9,  -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
				{9,  -1,  1,  1,  2, -1,  1,  1,  1,  1,  3,  1,  1,  1,  1,  1, -1, -1,  1,  1, -1},
				{9,  -1,  1, -1,  1, -1,  1, -1,  1, -1, -1, -1, -1,  1, -1,  1, -1,  1, -1,  1, -1},
				{9,  -1,  1, -1,  1,  1,  1, -1,  1, -1, -1, -1, -1,  1, -1,  1,  1,  1, -1,  1, -1},
				{9,  -1,  1, -1,  1, -1, -1, -1,  1,  1,  1,  1,  1,  1, -1, -1, -1,  1, -1,  1, -1},
				{9,  -1,  1,  1,  1, -1,  1,  1,  1,  1, -1,  1,  1,  1, -1,  1,  1,  1,  1,  1, -1},
				{9,  -1,  1, -1, -1, -1,  1, -1, -1,  1, -1,  1, -1,  1, -1,  1,  1, -1, -1,  1, -1},
				{9,  -1,  1,  1,  1,  1,  1, -1, -1,  1,  1,  1, -1,  1,  1,  1,  1, -1, -1,  1, -1},
				{9,  -1,  1, -1,  1, -1,  1,  1,  1,  1, -1,  1,  1,  3,  1,  1,  1, -1, -1,  1, -1},
				{9,  -1,  1, -1,  1, -1,  1, -1, -1,  1, -1,  1, -1, -1,  1, -1,  1, -1, -1,  1, -1},
				{9,  -1,  3, -1,  1, -1,  1, -1, -1,  1,  1,  1, -1, -1,  1, -1,  1, -1, -1,  1, -1},
				{9,  -1,  1, -1,  1, -1,  1, -1, -1,  1, -1,  1, -1, -1,  1, -1,  1, -1, -1,  1, -1},
				{9,  -1,  1, -1,  1, -1,  1, -1, -1,  1, -1,  1, -1, -1,  1, -1,  1, -1, -1,  1, -1},
				{9,  -1,  1, -1,  1, -1,  1,  3,  1,  1,  2,  1,  1,  1,  1, -1,  1, -1, -1,  1, -1},
				{9,  -1,  1,  1,  1,  1,  1,  1,  1, -1, -1, -1, -1,  1,  1,  1,  1,  1,  1,  1, -1},
				{9,  -1,  1, -1,  1, -1,  1,  1, -1, -1, -1, -1, -1,  1, -1, -1, -1,  1, -1,  1, -1},
				{9,  -1,  1, -1,  1,  1,  1,  1,  1,  1, -1,  1,  1,  1,  1,  1,  1,  1, -1,  1, -1},
				{9,  -1,  1, -1,  1, -1,  1, -1, -1,  1, -1,  1, -1, -1, -1,  1, -1,  1, -1,  1, -1},
				{9,  -1,  2,  1,  1, -1,  1,  1,  1,  1,  1,  1,  1,  3,  1,  1, -1,  1,  1,  2, -1},
				{9,  -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
		};
		nbGommes = 197;
		thisMap = 3;
		return c;
	}
	
	private int[][] mapDownload2() {
		int[][] c = {
				{9, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
				{9, -1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1, -1},
				{9, -1,  1,  1, -1, -1, -1, -1, -1, -1,  1,  1, -1, -1, -1, -1, -1, -1,  1,  1, -1},
				{9, -1,  1,  1, -1,  1, -1,  1,  1,  1,  1,  1, -1,  1,  1,  1,  1,  1,  1,  1, -1},
				{9, -1,  1,  1, -1,  1, -1,  1,  1,  1,  1,  1, -1, -1, -1, -1,  1,  1,  1,  1, -1},
				{9, -1,  1,  1, -1,  1, -1,  1,  1,  1,  1,  1, -1,  1,  1,  1,  1,  1,  1,  1, -1},
				{9, -1,  1,  1, -1, -1, -1,  1,  1,  1,  1,  1, -1, -1, -1, -1, -1, -1,  1,  1, -1},
				{9, -1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1, -1},
				{9, -1,  1,  1, -1, -1, -1, -1, -1, -1,  1,  1, -1, -1, -1, -1, -1, -1,  1,  1, -1},
				{9, -1,  1,  1, -1,  1, -1,  1,  1,  1,  1,  1, -1,  1, -1,  1,  1,  1,  1,  1, -1},
				{9, -1,  1,  1, -1,  1, -1,  1,  1,  1,  1,  1, -1,  1, -1,  1,  1,  1,  1,  1, -1},
				{9, -1,  1,  1, -1, -1, -1, -1, -1, -1,  1,  1, -1, -1, -1, -1, -1, -1,  1,  1, -1},
				{9, -1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1, -1},
				{9, -1,  1,  1, -1, -1, -1, -1, -1, -1,  1,  1, -1, -1, -1, -1, -1, -1,  1,  1, -1},
				{9, -1,  1,  1, -1,  1,  1,  1,  1, -1,  1,  1, -1,  1,  1,  1,  1,  1,  1,  1, -1},
				{9, -1,  1,  1, -1,  1,  1,  1,  1, -1,  1,  1,  1, -1, -1, -1, -1,  1,  1,  1, -1},
				{9, -1,  1,  1, -1,  1,  1,  1,  1, -1,  1,  1,  1,  1,  1,  1,  1, -1,  1,  1, -1},
				{9, -1,  1,  1, -1,  1,  1,  1,  1, -1,  1,  1, -1, -1, -1, -1, -1, -1,  1,  1, -1},
				{9, -1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  4,  1,  1, -1},
				{9, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
		};
		nbGommes = 324;
		thisMap = 2;
		return c;
	}
	
	private void createFantomes() {
		CreateFantome(0,Color.RED);
		CreateFantome(1,Color.cyan);
		CreateFantome(2,Color.GREEN);
		CreateFantome(3,Color.ORANGE);
	}
	
	public void CreateFantome(int indice, Color color) {
		fantomes[indice] = new Scary(this, new Point(9, 9), color);
	}
	
	public void changemap() {
		if(thisMap == 1) map = mapDownload2();
		else if(thisMap == 2) map = mapDownload3();
		pacman.setPoint(new Point(1, 2));
		for(int i = 0; i < 4; i++) fantomes[i].setPoint(new Point(9, 9));
	}
	
	private void step() {
		pacman.move();
		if(score >= 5000 && !checkLife) addLife(1);
		for(int i = 0; i < 4; i++) {
			fantomes[i].move();
			if(pacman.getPoint().equals(fantomes[i].getPoint())) {
				if(pacman.getState() == State.Normal) {
					pacman.setVie(pacman.getVie() - 1);
					if(pacman.getVie() == 0) break;
				}
				else if(pacman.getState() == State.Super) fantomes[i].setPoint(new Point(9, 9));
			}
		}
		if(pacman.getState() == State.Invisible || pacman.getState() == State.Super) {
			pacman.setTime(pacman.getTime() - speed);
			if(pacman.getTime() == 0) {
				pacman.setState(State.Normal);
				pacman.setColor(Color.YELLOW);
				createFantomes();
			}
		}
		gui.printData();
	}
	
	private void addLife(int x) {
		checkLife = true;
		pacman.setVie(pacman.getVie() + x);
	}
	
	public void gameStart() {
		while(pacman.getVie() > 0 && nbGommes > 0){
			step();
			try{
				Thread.sleep(speed);
			}
			catch (InterruptedException e){
				e.printStackTrace();
			}
		}
		gui.endGame();
	}
	
	public static void main(String[] args) {
		Game game = new Game();
		Gui gui = new Gui(game);
		game.setGui(gui);
		game.gameStart();
	}
}
