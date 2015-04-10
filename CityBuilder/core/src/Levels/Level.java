package Levels;

import tile.Tile;

public class Level {

	protected Tile[][] tiles;
	private int width;
	private int height;
	
	public Level(int width, int height) {
		this.width = width;
		this.height = height;
		
		tiles = new Tile[width][height];
	}
}
