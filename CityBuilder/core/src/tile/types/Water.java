package tile.types;

import tile.Tile;
import tile.TileType;
import tile.sprites.GrassSprite;
import tile.sprites.WaterSprite;

public class Water extends Tile {

	public Water() {
		super(TileType.water);
		
		this.spriteAdapter = WaterSprite.getInstance();
	}

}
