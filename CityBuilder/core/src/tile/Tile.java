package tile;

import com.badlogic.gdx.graphics.g2d.Sprite;


public class Tile {
	
	private TileType type;
	
	protected TileSpriteAdapter spriteAdapter; 
	protected boolean isResource;

	public Tile(TileType type) {
		this.setType(type);
	}
	
	public Sprite getSprite() {
		if (spriteAdapter == null)
			return null;
		
		return spriteAdapter.getSprite(this);
	}
	
	public TileType getType() {
		return type;
	}

	public void setType(TileType type) {
		this.type = type;
	}
	
	public boolean isResource() {
		return false;
	}

}