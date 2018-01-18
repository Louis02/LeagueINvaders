import java.awt.Color;
import java.awt.Graphics;

public class RocketShip extends GameObject {

	boolean up = false;
	boolean down = false;
	boolean left = false;
	boolean right = false;
	int speed;
	public RocketShip(int x, int y, int width, int height) {
		super(x, y, width, height);
		
		speed=10;
		
		
	}
	void update() {
		if(up == true) {
			y-=speed;
		}
		if(down == true) {
			y+=speed;
		}
		if(left == true) {
			x-=speed;
		}
		if(right == true) {
			x+=speed;
		}
	}
	void draw(Graphics g) {
		g.setColor(Color.blue);
		g.fillRect(x, y, width, height);
	}
}
