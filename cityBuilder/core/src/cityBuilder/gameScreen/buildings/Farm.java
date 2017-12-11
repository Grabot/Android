package cityBuilder.gameScreen.buildings;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.ArrayList;

import cityBuilder.load.Building;
import cityBuilder.load.Data;
import cityBuilder.objects.Tile;

public class Farm extends Data implements Building {

	private Tile[] farmTiles;
	private int TileNumber;
	private int rotation;
	private TextureRegion SquareTileRegionFarmBottomLeft;
	private TextureRegion SquareTileRegionFarmBottomRight;
	private TextureRegion SquareTileRegionFarmTopLeft;
	private TextureRegion SquareTileRegionFarmTopRight;

	public Farm(int TileNumber, int rotation, TextureAtlas atlas)
	{
		farmTiles = new Tile[4];
		this.TileNumber = TileNumber;
		this.rotation = rotation;
		SquareTileRegionFarmBottomLeft = atlas.findRegion("cubeLight");
		SquareTileRegionFarmTopLeft = atlas.findRegion("cubeLight");
		SquareTileRegionFarmTopRight = atlas.findRegion("cubeLight");
		SquareTileRegionFarmBottomRight = atlas.findRegion("cubeLight");
	}

	@Override
	public void render(Batch batch, int position, float x, float y) {
		System.out.println("" + position);
		if( position == 0 ) {
			//bottom left
			batch.draw( SquareTileRegionFarmBottomLeft, -32 + x, -32 + y, 32, 32, 64, 64, 1, 1, -(90 * rotation), false);
		} else if( position == 1 ) {
			//top left
			batch.draw( SquareTileRegionFarmTopLeft, -32 + x , -32 + y, 32, 32, 64, 64, 1, 1, -(90 * rotation), false);
		} else if( position == 2 ) {
			//top right
			batch.draw( SquareTileRegionFarmTopRight, -32 + x , -32 + y, 32, 32, 64, 64, 1, 1, -(90 * rotation), false);
		} else if( position == 3 ) {
			//bottom right
			batch.draw( SquareTileRegionFarmBottomRight, -32 + x , -32 + y, 32, 32, 64, 64, 1, 1, -(90 * rotation), false);
		}
	}

	public void update()
	{
		//get the farm foods, think it's wrong
		farmTiles[0].setResources(farmTiles[0].getResources() - 1);
		farmTiles[1].setResources(farmTiles[1].getResources() - 1);
		farmTiles[2].setResources(farmTiles[2].getResources() - 1);
		farmTiles[3].setResources(farmTiles[3].getResources() - 1);
	}

	@Override
	public void buildBuilding(ArrayList<Tile> tiles, int selectedTile, int rotation) {
		// set the correct tiles and save the farm tiles so that it can be used for update functionality
		tiles.get(selectedTile).setOccupiedFarm(0, this);
		tiles.get(selectedTile-gridSizeWidth).setOccupiedFarm(1, this);
		tiles.get(selectedTile-(gridSizeWidth-1)).setOccupiedFarm(2, this);
		tiles.get(selectedTile+1).setOccupiedFarm(3, this);

		farmTiles[0] = tiles.get(selectedTile);
		farmTiles[1] = tiles.get(selectedTile-gridSizeWidth);
		farmTiles[2] = tiles.get(selectedTile-(gridSizeWidth-1));
		farmTiles[3] = tiles.get(selectedTile+1);
	}
}
