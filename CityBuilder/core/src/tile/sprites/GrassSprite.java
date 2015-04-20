package tile.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

import tile.LayeredSprite;
import tile.TileSprite;

public class GrassSprite extends TileSprite {

	private static final GrassSprite instance = new GrassSprite();
 
	protected GrassSprite() {
		standard = new LayeredSprite(new Sprite(new Texture("images/Grass.png")));
		
		selected = new LayeredSprite(new Sprite(new Texture("images/Grass.png")));
		selected.add(new Sprite(new Texture("images/SquareSelectedSmall.png")));
	}
 
	public static GrassSprite getInstance() {
		return instance;
	}
	
}
