package cityBuilder.gameScreen.buildings;

import java.util.ArrayList;

import cityBuilder.load.Data;
import cityBuilder.objects.Tile;

public class Farm extends Data {

	private Tile[] farmTiles;
	private int TileNumber = 0;

	public Farm( int TileNumber )
	{
		farmTiles = new Tile[4];
		this.TileNumber = TileNumber;
	}

	public void update()
	{
		//get the farm foods, think it's wrong
		farmTiles[0].setResources(farmTiles[0].getResources() - 1);
		farmTiles[1].setResources(farmTiles[1].getResources() - 1);
		farmTiles[2].setResources(farmTiles[2].getResources() - 1);
		farmTiles[3].setResources(farmTiles[3].getResources() - 1);
	}

	public void buildFarm(ArrayList<Tile> tiles, int selectedTile, int rotation) {
		// set the correct tiles and save the farm tiles so that it can be used for update functionality
		tiles.get(selectedTile).setOccupied(1, 0, rotation);
		tiles.get(selectedTile-gridSizeWidth).setOccupied(1, 1, rotation);
		tiles.get(selectedTile-(gridSizeWidth-1)).setOccupied(1, 2, rotation);
		tiles.get(selectedTile+1).setOccupied(1, 3, rotation);

		farmTiles[0] = tiles.get(selectedTile);
		farmTiles[1] = tiles.get(selectedTile-gridSizeWidth);
		farmTiles[2] = tiles.get(selectedTile-(gridSizeWidth-1));
		farmTiles[3] = tiles.get(selectedTile+1);
	}
}
