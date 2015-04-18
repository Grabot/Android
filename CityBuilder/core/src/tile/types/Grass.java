package tile.types;

import tile.Tile;
import tile.TileType;
import tile.sprites.GrassSprite;

public class Grass extends Tile {

	public Grass() {
		super(TileType.grass);
		
		this.spriteAdapter = GrassSprite.getInstance();
	}

}
