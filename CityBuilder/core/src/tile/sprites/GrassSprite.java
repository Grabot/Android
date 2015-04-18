package tile.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

import tile.TileSpriteAdapter;

public class GrassSprite extends TileSpriteAdapter {

	private static final GrassSprite instance = new GrassSprite();
 
	protected GrassSprite() {
		standard = new Sprite(new Texture("images/grass.png"));
	}
 
	public static GrassSprite getInstance() {
		return instance;
	}
	
}
