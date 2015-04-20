package tile.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

import tile.LayeredSprite;
import tile.TileSprite;

public class WaterSprite extends TileSprite {

	private static final WaterSprite instance = new WaterSprite();
 
	protected WaterSprite() {
		standard = new LayeredSprite(new Sprite(new Texture("images/resources/water.png")));
	}
 
	public static WaterSprite getInstance() {
		return instance;
	}
	
}
