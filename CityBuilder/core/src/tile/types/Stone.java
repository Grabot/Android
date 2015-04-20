package tile.types;

import tile.ResourceTile;
import tile.TileType;
import tile.sprites.StoneSprite;
import tile.sprites.WoodSprite;

public class Stone extends ResourceTile {

	public Stone(int amount) {
		super(TileType.stone, amount);
		
		this.spriteAdapter = StoneSprite.getInstance();
	}
	
}