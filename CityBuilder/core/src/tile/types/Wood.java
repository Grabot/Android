package tile.types;

import tile.ResourceTile;
import tile.TileType;
import tile.sprites.WoodSprite;

public class Wood extends ResourceTile {

	public Wood(int amount) {
		super(TileType.wood, amount);
		
		this.spriteAdapter = WoodSprite.getInstance();
	}
	
}