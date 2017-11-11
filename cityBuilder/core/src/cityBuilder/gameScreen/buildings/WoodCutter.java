package cityBuilder.gameScreen.buildings;

import java.util.ArrayList;

import cityBuilder.load.Data;
import cityBuilder.objects.Tile;

public class WoodCutter extends Data
{
	public ArrayList<Tile> tiles = new ArrayList<Tile>();
	private int TileNumber = 0;

	public WoodCutter( int TileNumber, ArrayList<Tile> tiles )
	{
		this.tiles = tiles;
		this.TileNumber = TileNumber;
	}

	public void update()
	{
	}
}