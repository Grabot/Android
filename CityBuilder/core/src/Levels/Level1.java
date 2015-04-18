package levels;

import tile.types.*;

public class Level1 extends Level {

	public Level1() {
		super(15, 15);	
		
		for (int x = 0; x < getWidth(); x++) {
			for (int y = 0; y < getHeight(); y++) {
				if (x % 3 == 0 || y % 3 == 0) {
					level[x][y] = new Grass();
				} else {
					level[x][y] = new Wood(100);
				}
			}
		}
		
	}
	
}
