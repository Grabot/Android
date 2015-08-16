package CityBuilder.gameScreen.buildings;

import java.util.ArrayList;

import CityBuilder.load.Data;
import CityBuilder.objects.Tile;

public class Farm extends Data
{
	public ArrayList<Tile> tiles = new ArrayList<Tile>();
	private int TileNumber = 0;
	
	public Farm( int TileNumber, ArrayList<Tile> tiles )
	{
		this.tiles = tiles;
		this.TileNumber = TileNumber;
	}
	
	public void update()
	{
		//get the farm foods, think it's wrong
		tiles.get(TileNumber).setResources(tiles.get(TileNumber).getResources() - 1);
		tiles.get(TileNumber+1).setResources(tiles.get(TileNumber+1).getResources() - 1);
		tiles.get(TileNumber-gridSizeWidth).setResources(tiles.get(TileNumber-gridSizeWidth).getResources() - 1);
		tiles.get(TileNumber-(gridSizeWidth+1)).setResources(tiles.get(TileNumber-(gridSizeWidth+1)).getResources() - 1);
	}
}
