package managers;

import java.util.HashMap;
import java.util.Map;

import com.badlogic.gdx.graphics.g2d.Sprite;

public class SpriteManager {
	private static final SpriteManager instance = new SpriteManager();
	
	private Map<String, Sprite> sprites = new HashMap<String, Sprite>();
	
	private SpriteManager() {
	}
	
	public static SpriteManager getInstance() {
		return instance;
	}
	
}
