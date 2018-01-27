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
	private TextureRegion SquareTileRegionSelected;
	public DrawTiles(TextureAtlas atlas)
	{
		drawselection = new DrawSelectionControl(atlas);
		SquareTileRegionSelected = atlas.findRegion("selectedIso");
	}

	public void fillTiles( Batch batch, Tile[][] tiles, int globalRotation)
	{
		for (int x = 0; x < tiles.length; x++ ) {
			for (int y = 0; y < tiles[x].length; y++ ) {
				tiles[x][y].drawTile( batch );
			}
		}

		for ( int x = 0; x < tiles.length; x++ ) {
			for (int y = 0; y < tiles[x].length; y++ ) {
				if (tiles[x][y].getOccupied() != 0) {
					if (tiles[x][y].getOccupied() == 1) {
						tiles[x][y].drawFarm(batch, globalRotation);
					} else if (tiles[x][y].getOccupied() == 2) {
						tiles[x][y].drawWoodCutter(batch, globalRotation);
					} else if (tiles[x][y].getOccupied() == 3) {
						tiles[x][y].drawWoods(batch, globalRotation);
					} else if (tiles[x][y].getOccupied() == 4) {
						tiles[x][y].drawWarehouse(batch, globalRotation);
					} else if (tiles[x][y].getOccupied() == 5) {
						tiles[x][y].drawRoads(batch, globalRotation);
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
		if( tiles[x][y].getOccupied() == 0 ) {
			batch.draw( SquareTileRegionSelected, (-45 + tiles[x][y].getPosition().x), (-23 + tiles[x][y].getPosition().y), 0, 0, 90, 46, 1, 1, 0, false);
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
