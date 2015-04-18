package tile;

import managers.SettingManager;

import com.badlogic.gdx.graphics.g2d.Sprite;

public abstract class TileSpriteAdapter {
	
	protected Sprite standard;

	public Sprite getSprite(Tile tile) {
		Sprite sprite = standard;
		
		
		sprite.setSize(SettingManager.WORLD_WIDTH, SettingManager.WORLD_HEIGHT);
		return sprite;
	}
}