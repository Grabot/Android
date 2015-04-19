package renderer;

import level.Level;
import managers.SettingManager;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class LevelRenderer {

	public static void render(SpriteBatch batch, Level level) {
		for (int x = 0; x < level.getWidth(); x++) {
			for (int y = 0; y < level.getHeight(); y++) {
				if (level.getTile(x, y).getSprite() != null) {
					level.getTile(x, y).getSprite().setPosition(x * SettingManager.WORLD_WIDTH, y * SettingManager.WORLD_HEIGHT);
					level.getTile(x, y).getSprite().draw(batch);
				}
			}
		}
	}
}