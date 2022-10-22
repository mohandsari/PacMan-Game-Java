package prototype;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Gui {
	private Game game;
	private JFrame frame = new JFrame("Pacman");
	private JComponent component = new JComponent() {
		private static final long serialVersionUID = 1L;
		@Override
		public void paintComponent(Graphics g){
			super.paintComponent(g);
			setBackground(Color.BLACK);
			for(int i = 0; i < 20; i++) {
				for(int j = 0; j < 21; j++) setCase(g, i, j);
			}
			g.setColor(game.getPacman().getColor());
			g.fillArc(game.getPacman().getPoint().getX()*30, game.getPacman().getPoint().getY()*30, 30, 30,20,300);
			for(int i = 0; i < 4; i++) {
				g.setColor(game.getFantome(i).getColor());
				g.fill3DRect(game.getFantome(i).getPoint().getX()*30, game.getFantome(i).getPoint().getY()*30, 28, 28,true);
			}
		}

		private void setCase(Graphics g, int i, int j) {
			if(game.getValeur(i, j) == 9) {
				g.setColor(Color.white);
				g.fillRect(i*30, j*30, 30, 30);
			}
			if(game.getValeur(i, j) == -1) {
				g.setColor(new Color(60,32,20));
				g.fill3DRect(i*30, j*30, 30, 30,true);
			}
			else if(game.getValeur(i, j) == 1) {
				g.setColor(Color.BLUE);
				g.fillOval(i*30+10, j*30+10, 10, 10);
			}
			if (game.getValeur(i, j) >= 2 ) {
				if (game.getValeur(i, j) == 2 ) g.setColor(new Color(238, 130, 238));
				if (game.getValeur(i, j) == 3 ) g.setColor(Color.ORANGE);
				if (game.getValeur(i, j) == 4 ) g.setColor(Color.GREEN);
				g.fillOval(i*30+10, j*30+10, 15, 15);
			}
		}
	};
	private JLabel texte;
	
	public Gui(Game game) {
		this.game = game;
		frame.setSize(618, 672);
		component.setLayout(new BorderLayout());
		texte = new JLabel( "     Etat: " + game.getPacman().getState()+"   Points de vie: " + game.getPacman().getVie() + "     Score: " + game.getScore());
		texte.setFont(new Font("Arial", Font.BOLD, 25));
		component.add(texte, BorderLayout.NORTH);
		frame.setContentPane(component);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.addKeyListener(
			new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e){
					if(e.getKeyCode() == KeyEvent.VK_LEFT) game.getPacman().setDirection(Direction.Left);
					if(e.getKeyCode() == KeyEvent.VK_RIGHT) game.getPacman().setDirection(Direction.Right);
					if(e.getKeyCode() == KeyEvent.VK_UP) game.getPacman().setDirection(Direction.Up);
					if(e.getKeyCode() == KeyEvent.VK_DOWN) game.getPacman().setDirection(Direction.Down);
				}
			}
		);
	}
	
	public void endGame() {
		String str = "";
		if(game.getNbGommes() == 0) str = "YOU WIN ! ";
		else str = "GAME OVER  ";
		str += "Score: " + game.getScore();
		JOptionPane.showMessageDialog(frame, str, "END !", JOptionPane.INFORMATION_MESSAGE);
		System.exit(0);
	}
	
	public void printData() {
		texte.setText("LIFE: " + game.getPacman().getVie() + "     SCORE: " + game.getScore()
						+ "     STATE: " + game.getPacman().getState());
		component.repaint();
	}
}
