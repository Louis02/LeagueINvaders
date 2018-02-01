import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
	RocketShip rock;
	ArrayList<Projectile> list = new ArrayList<Projectile>();
	ArrayList<Alien> alist = new ArrayList<Alien>();
	long enemyTimer = 0;
	int enemySpawnTime = 900;

	public ObjectManager(RocketShip rock) {
		this.rock = rock;
	}

	public void update() {
		rock.update();
		for (Projectile p : list) {
			p.update();
		}
		for (Alien a : alist) {
			a.update();
		}
	}

	public void draw(Graphics g) {
		rock.draw(g);
		for (Projectile p : list) {
			p.draw(g);
		}
		for (Alien a : alist) {
			a.draw(g);
		}
	}

	public void addProjectile(Projectile pro) {
		list.add(pro);
	}

	public void addAlien(Alien a) {
		alist.add(a);
	}

	public void manageEnemies() {
		if (System.currentTimeMillis() - enemyTimer >= enemySpawnTime) {
			addAlien(new Alien(new Random().nextInt(LeagueInvaders.width), 0, 50, 50));

			enemyTimer = System.currentTimeMillis();
		}
	}

	public void purgeObjects() {
		for (Alien a : alist) {
			if (!a.isAlive) {
				alist.remove(a);
			}
		
		}
		for(Projectile p: list) {
			if(!p.isAlive) {
				list.remove(p);
			}
		}
		
	}
}
