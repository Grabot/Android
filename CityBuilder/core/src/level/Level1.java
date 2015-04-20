package level;

import tile.types.*;

public class Level1 extends Level {

	public Level1() {
		super(5, 5);

		for (int x = 0; x < getWidth(); x++) {
			for (int y = 0; y < getHeight(); y++) {
				level[x][y] = new Grass();
			}
		}

		level[0][0] = new Wood(10);
		level[1][0] = new Wood(10);
		level[0][1] = new Wood(10);
		level[1][1] = new Wood(10);
		
		level[2][0] = new Water();
		level[2][1] = new Water();
		level[2][2] = new Water();
		level[2][3] = new Water();
		level[2][4] = new Water();
		
		level[4][4] = new Iron(25);
		level[3][3] = new Stone(25);
	}
}
