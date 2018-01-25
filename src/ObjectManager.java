import java.awt.Graphics;
import java.util.ArrayList;

public class ObjectManager {
	RocketShip rock;
	ArrayList<Projectile> list = new ArrayList<Projectile>();

	public ObjectManager(RocketShip rock) {
		this.rock = rock;
	}

	public void update() {
		rock.update();
		for(Projectile p: list) {
			p.update();
		}
	}

	public void draw(Graphics g) {
		rock.draw(g);
		for(Projectile p: list) {
			p.draw(g);
		}
	}
	public void addProjectile(Projectile pro) {
		list.add(pro);
	}
}
