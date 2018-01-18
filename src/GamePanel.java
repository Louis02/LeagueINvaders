
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	Timer timer;
	final int MENU_STATE = 0;

	final int GAME_STATE = 1;

	final int END_STATE = 2;

	int CURRENT_STATE;
	Font titleFont;
	RocketShip rock = new RocketShip(250, 750, 50, 50);
	public GamePanel() {
		timer = new Timer(1000 / 60, this);
		titleFont = new Font("arial", Font.PLAIN, 48);
	}

	@Override

	public void paintComponent(Graphics g) {
		if (CURRENT_STATE == MENU_STATE) {

			drawMenuState(g);

		} else if (CURRENT_STATE == GAME_STATE) {

			drawGameState(g);

		} else if (CURRENT_STATE == END_STATE) {

			drawEndState(g);

		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (CURRENT_STATE == MENU_STATE) {

			updateMenuState();

		} else if (CURRENT_STATE == GAME_STATE) {

			updateGameState();

		} else if (CURRENT_STATE == END_STATE) {

			updateEndState();

		}

		repaint();
	}

	void startGame() {
		timer.start();
	}

	void updateMenuState() {

	}

	void updateGameState() {
		rock.update();
	}

	void updateEndState() {

	}

	void drawMenuState(Graphics g) {
		g.setColor(Color.blue);
		g.fillRect(0, 0, LeagueInvaders.width, LeagueInvaders.height);
		g.setFont(titleFont);
		g.setColor(Color.pink);
		g.drawString("LeagueInvaders", 75, 100);
	}

	void drawGameState(Graphics g) {
		g.setColor(Color.black);

		g.fillRect(0, 0, LeagueInvaders.width, LeagueInvaders.height);
		rock.draw(g);
	}

	void drawEndState(Graphics g) {
		g.setColor(Color.red);

		g.fillRect(0, 0, LeagueInvaders.width, LeagueInvaders.height);
		g.setFont(titleFont);
		g.setColor(Color.pink);
		g.drawString("Game Over", 110, 100);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			CURRENT_STATE++;

			if (CURRENT_STATE > END_STATE) {

				CURRENT_STATE = MENU_STATE;

			}
		}
		if(e.getKeyCode() == KeyEvent.VK_UP){
			rock.up=true;
		}
		if(e.getKeyCode() == KeyEvent.VK_DOWN){
			rock.down=true;
		}
		if(e.getKeyCode() == KeyEvent.VK_LEFT){
			rock.left=true;
		}
		if(e.getKeyCode() == KeyEvent.VK_RIGHT){
			rock.right=true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode() == KeyEvent.VK_UP){
			rock.up=false;
		}
		if(e.getKeyCode() == KeyEvent.VK_DOWN){
			rock.down=false;
		}
		if(e.getKeyCode() == KeyEvent.VK_LEFT){
			rock.left=false;
		}
		if(e.getKeyCode() == KeyEvent.VK_RIGHT){
			rock.right=false;
		}
	}
}
