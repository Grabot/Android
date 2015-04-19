package tile;

import managers.SettingManager;

import com.badlogic.gdx.graphics.g2d.Sprite;

public abstract class TileSprite implements ITileSprite {

	protected Sprite standard;
	protected Sprite resourceDepleted;
	
	@Override
	public Sprite getSprite(Tile tile) {
		Sprite sprite = standard;

		
		if (sprite != null)
			sprite.setSize(SettingManager.WORLD_WIDTH, SettingManager.WORLD_HEIGHT);

		return sprite;
	}
}