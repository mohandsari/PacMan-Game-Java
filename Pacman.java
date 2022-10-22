package prototype;

import java.awt.Color;

public class Pacman {
	private Game game;
	private int vie;
	private Point point;
	private Direction direction;
	private State state;
	private Color color;
	private int time;
	
	public Pacman(Game game, Point point) {
		this.game = game;
		this.vie = 3;
		this.point = point;
		this.direction = null;
		this.state = State.Normal;
		this.color = Color.YELLOW;
		this.time = 0;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public int getVie() {
		return vie;
	}

	public void setVie(int vie) {
		this.vie = vie;
	}

	public Point getPoint() {
		return point;
	}

	public void setPoint(Point point) {
		this.point = point;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public void move() {
		if(direction == null) return;
		int x = point.getX() + direction.getX();
		int y = point.getY() + direction.getY();
		if(x == -1 && (y == 10 || y == 15 || y == 2)) x = 19;
		else if(x == 20 && (y == 10 || y == 15 || y == 2)) x = 0;
		else if(x == 9 && y == 0) y = 19;
		else if(x == 9 && y == 21) y = 0;
		if(game.getValeur(x, y) != -1){
			point = new Point(x, y);
			if(game.getValeur(x, y) == 1) addScore(100);
			else if(game.getValeur(x, y) == 2){
				addScore(300);
				if(state == State.Normal) changeState("invisible");
				else if(state == State.Invisible) time += 10000;
			}
			else if(game.getValeur(x, y) == 3){
				addScore(500);
				if(state == State.Normal) changeState("super");
				else if(state == State.Super) time += 10000;
			}
			else if(game.getValeur(x, y) == 4){
				addScore(1000);
				game.changemap();
			}
			if(game.getValeur(x, y) != 4) game.setValeur(x, y, 0);
		}
	}

	private void changeState(String string) {
		if(string == "invisible") {
			state = State.Invisible;
			color = new Color(255, 228, 54);
			time = 10000;
		}
		else if(string == "super") {
			state = State.Super;
			color = Color.ORANGE;
			time = 10000;
			for(int i = 0; i < 4; i++) game.getFantome(i).setColor(Color.BLUE);
		}
	}

	private void addScore(int i) {
		game.setScore(game.getScore() + i);
		game.setNbGommes(game.getNbGommes() - 1);
	}
}
