package CityBuilder.load;

public abstract class Data 
{
	
	protected int ScreenWidth = 1280;
	protected int ScreenHeight = 720;
	
	protected int tileWidth = 64;
	protected int tileHeight = 64;
	
	protected int tileStartWidth = 0;
	protected int tileStartHeight = (24*64);
	
	protected int gridSizeWidth = 25;
	protected int gridSizeHeight = 25;
	protected int numberOfTiles = 625;

	protected int unavailable = 50;
	protected int available = 51;
	
}
