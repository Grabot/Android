package onzichtbaar.net.Android.CityBuilder.load;

public abstract class Data 
{
	
	protected int ScreenWidth = 1280;
	protected int ScreenHeight = 720;
	
	protected int tileWidth = 64;
	protected int tileHeight = 64;
	
	protected int tileStartWidth = 126;
	protected int tileStartHeight = 126;
	
	protected int gridSize = 5;
	protected int numberOfTiles = 25;

	protected int unavailable = 10;
	protected int available = 11;
	
	protected int grass = 1;
	protected int wood = 2;
	protected int town = 3;
	protected int sheep = 4;
	protected int desert = 5;

}