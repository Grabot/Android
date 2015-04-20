package tile.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

import tile.LayeredSprite;
import tile.TileSprite;

public class WoodSprite extends TileSprite {

	private static final WoodSprite instance = new WoodSprite();
 
	protected WoodSprite() {
		standard = new LayeredSprite(new Sprite(new Texture("images/grass.png")));
		standard.add(new Sprite(new Texture("images/pinetree.png")));
	}
 
	public static WoodSprite getInstance() {
		return instance;
	}
	
}
