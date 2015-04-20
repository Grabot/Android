package tile.types;

import tile.ResourceTile;
import tile.TileType;
import tile.sprites.IronSprite;

public class Iron extends ResourceTile {

	public Iron(int amount) {
		super(TileType.iron, amount);
		
		this.spriteAdapter = IronSprite.getInstance();
	}
	
}