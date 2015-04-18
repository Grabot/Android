package levels;

import tile.Tile;

public class Level {

	protected Tile[][] level;
	private int width;
	private int height;
	
	public Level(int width, int height) {
		this.width = width;
		this.height = height;
		
		level = new Tile[width][height];
	}
	
	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public Tile getTile(int x, int y) {
		return level[x][y];
	}
	
}
