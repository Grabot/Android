package tile.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

import tile.ResourceTileSpriteAdapter;

public class WoodSprite extends ResourceTileSpriteAdapter {

	private static final WoodSprite instance = new WoodSprite();
 
	protected WoodSprite() {
		standard = new Sprite(new Texture("images/pinetree.png"));
	}
 
	public static WoodSprite getInstance() {
		return instance;
	}
	
}
