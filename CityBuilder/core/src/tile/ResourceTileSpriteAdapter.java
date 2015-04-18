package tile;

import managers.SettingManager;

import com.badlogic.gdx.graphics.g2d.Sprite;

public abstract class ResourceTileSpriteAdapter extends TileSpriteAdapter {
	
	private Sprite resourceDepleted;
	
	public Sprite getSprite(ResourceTile tile) {
		Sprite sprite = super.getSprite(tile);
		
		
		sprite.setSize(SettingManager.WORLD_WIDTH, SettingManager.WORLD_HEIGHT);
		return sprite;
	}
}