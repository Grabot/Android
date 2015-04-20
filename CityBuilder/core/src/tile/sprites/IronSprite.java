package tile.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

import tile.LayeredSprite;
import tile.TileSprite;

public class IronSprite extends TileSprite {

	private static final IronSprite instance = new IronSprite();
 
	protected IronSprite() {
		standard  = new LayeredSprite(new Sprite(new Texture("images/resources/ironOreSmall.png")));
	}
 
	public static IronSprite getInstance() {
		return instance;
	}
	
}
