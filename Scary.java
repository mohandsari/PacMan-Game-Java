package prototype;

import java.awt.Color;
import java.util.Random;

public class Scary {
	private Game game;
	private Point point;
	private Direction direction;
	private Color color;
	
	public Scary(Game game, Point point, Color color) {
		this.game = game;
		this.point = point;
		this.direction = numDirection(randomValue());
		this.color = color;
	}
	
	public Point getPoint() {
		return point;
	}

	public void setPoint(Point point) {
		this.point = point;
	}
	
	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
	private int randomValue() {
		Random r = new Random();
		return r.nextInt(4);
	}
	
	private Direction numDirection(int x) {
		if(x == 0) return Direction.Down;
		else if(x == 1) return Direction.Left;
		else if(x == 2) return Direction.Up;
		else return Direction.Right;
	}

	private void changeDirection() {
		int x = point.getX() + direction.getX();
		int y = point.getY() + direction.getY();
		if(x == -1 && y == 9) x = 19;
		else if(x == 20 && y == 9) x = 0;
		else if(x == 9 && y == -1) y = 19;
		else if(x == 9 && y == 20) y = 0;
		while(game.getValeur(x, y) == -1) {
			x = point.getX() + direction.getX();
			y = point.getY() + direction.getY();
			direction = numDirection(randomValue());
		}
	}

	public void move() {
		int x = point.getX() + direction.getX();
		int y = point.getY() + direction.getY();
		if(x == -1 && (y == 10 || y == 15 || y == 2)) x = 19;
		else if(x == 20 && (y == 10 || y == 15 || y == 2)) x = 0;
		else if(x == 9 && y == 0) y = 19;
		else if(x == 9 && y == 21) y = 0;
		if(game.getValeur(x, y) == -1) {
			changeDirection();
			x = point.getX() + direction.getX();
			y = point.getY() + direction.getY();
		}
		if(game.getValeur(x, y) != -1 && (game.getPacman().getState() != State.Super || game.getPacman().getTime() % 1000 != 500))
			point = new Point(x, y);
	}
}