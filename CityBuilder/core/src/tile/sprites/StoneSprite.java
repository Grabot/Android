package tile.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

import tile.LayeredSprite;
import tile.TileSprite;

public class StoneSprite extends TileSprite {

	private static final StoneSprite instance = new StoneSprite();
 
	protected StoneSprite() {
		standard = new LayeredSprite(new Sprite(new Texture("images/rock3.png")));
		standard.add(0, new Sprite(new Texture("images/grass.png")));
	}
 
	public static StoneSprite getInstance() {
		return instance;
	}
	
}
