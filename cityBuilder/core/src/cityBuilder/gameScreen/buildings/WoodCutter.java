package cityBuilder.gameScreen.buildings;

import java.util.ArrayList;

import cityBuilder.load.Data;
import cityBuilder.objects.Tile;

public class WoodCutter extends Data {

	Tile[] woodcutterTiles;
	private int TileNumber = 0;

	public WoodCutter( int TileNumber )
	{
		woodcutterTiles = new Tile[4];
		this.TileNumber = TileNumber;
	}

	public void update()
	{
	}

	public void buildWoodcutter(ArrayList<Tile> tiles, int selectedTile, int rotation) {
		tiles.get(selectedTile).setOccupied(2, 0, rotation);
		tiles.get(selectedTile-gridSizeWidth).setOccupied(2, 1, rotation);
		tiles.get(selectedTile-(gridSizeWidth-1)).setOccupied(2, 2, rotation);
		tiles.get(selectedTile+1).setOccupied(2, 3, rotation);

		woodcutterTiles[0] = tiles.get(selectedTile);
		woodcutterTiles[1] = tiles.get(selectedTile-gridSizeWidth);
		woodcutterTiles[2] = tiles.get(selectedTile-(gridSizeWidth-1));
		woodcutterTiles[3] = tiles.get(selectedTile+1);
	}
}