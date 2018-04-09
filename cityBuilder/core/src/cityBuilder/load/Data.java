package cityBuilder.load;

import com.badlogic.gdx.Gdx;

public abstract class Data
{

	protected int ScreenWidth = Gdx.graphics.getWidth();
	protected int ScreenHeight = Gdx.graphics.getHeight();

	protected int tileWidth = 64;
	protected int tileHeight = 64;

	protected int gridSizeWidth = 400;
	protected int gridSizeHeight = 400;

	protected int unavailable = 50;
	protected int available = 51;

}
