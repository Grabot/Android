package cityBuilder.load;

import cityBuilder.gameScreen.Simulation;
import cityBuilder.objects.Tile;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.ArrayList;

public class DrawTiles extends Data
{
	private DrawSelectionControl drawselection;

	public DrawTiles(TextureAtlas atlas)
	{
		drawselection = new DrawSelectionControl(atlas);
	}

	public void fillTiles( Batch batch, Tile[][] tiles)
	{
		for (int x = 0; x < tiles.length; x++ ) {
			for (int y = 0; y < tiles[x].length; y++ ) {
				tiles[x][y].drawTile( batch );

				if (tiles[x][y].getOccupied() != 0) {
					if (tiles[x][y].getOccupied() == 1) {
						tiles[x][y].drawFarm(batch);
					} else if (tiles[x][y].getOccupied() == 2) {
						tiles[x][y].drawWoodCutter(batch);
					} else if (tiles[x][y].getOccupied() == 3) {
						tiles[x][y].drawWoods(batch);
					} else if (tiles[x][y].getOccupied() == 4) {
						tiles[x][y].drawWarehouse(batch);
					} else if (tiles[x][y].getOccupied() == 5) {
						tiles[x][y].drawRoads(batch);
					} else if (tiles[x][y].getOccupied() == 6) {
						// nothing yet
					}
				}
			}
		}
	}

	public void drawBuildingInformation(Batch batch, Tile[][] tiles) {
		for (int x = 0; x < tiles.length; x++ ) {
			for (int y = 0; y < tiles[x].length; y++) {

				if (tiles[x][y].getOccupied() == 2) {
					tiles[x][y].getWoodCutter().drawInformation(batch);
				}
			}
		}
	}

	public void drawRegionOwned(Batch bitch, Tile[][] tiles) {
		for (int x = 0; x < tiles.length; x++ ) {
			for (int y = 0; y < tiles[x].length; y++) {
				tiles[x][y].drawRegionOwned(bitch);
			}
		}
	}

	public void drawSelected( BuildingAvailabilityControl buildingAvailabilityControl, Tile[][] tiles, Batch batch, TextureAtlas atlas, int x, int y )
	{
		TextureRegion SquareTileRegionSelected = atlas.findRegion("SquareGreySmall");

		if( tiles[x][y].getOccupied() == 0 ) {
			// batch.draw( SquareTileRegionSelected, (-32 + tiles.get(x).get(y).getPosition().x), (-32 + tiles.get(x).get(y).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
		} else if( tiles[x][y].getOccupied() == 1 ) {
			drawselection.drawFarmSelected(tiles, batch, x, y);
		} else if( tiles[x][y].getOccupied() == 2 ) {
			drawselection.drawWoodCutterSelected(buildingAvailabilityControl, tiles, batch, x, y);
		} else if( tiles[x][y].getOccupied() == 3 ) {
			drawselection.drawWoodSelected(tiles, batch, x, y);
		} else if ( tiles[x][y].getOccupied() == 4 ) {
			drawselection.drawWarehouseSelected(buildingAvailabilityControl, tiles, batch, x, y);
		}
	}

}
