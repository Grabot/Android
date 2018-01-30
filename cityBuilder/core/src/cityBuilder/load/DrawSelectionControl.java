package cityBuilder.load;

import cityBuilder.gameScreen.Simulation;
import cityBuilder.gameScreen.buildings.Farm;
import cityBuilder.gameScreen.buildings.Warehouse;
import cityBuilder.gameScreen.buildings.WoodCutter;
import cityBuilder.objects.Tile;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.ArrayList;

public class DrawSelectionControl extends Data {

	private TextureRegion SquareTileRegionSelected;

	public DrawSelectionControl(TextureAtlas atlas) {
		SquareTileRegionSelected = atlas.findRegion("selectedIso");
	}

	public void drawWarehouseSelected(BuildingAvailabilityControl buildingAvailabilityControl, Tile[][] tiles, Batch batch, int x, int y) {

		if (tiles[x][y].getBuildingPosition() == 0) {
			buildingAvailabilityControl.OutlineAvailability(tiles, batch, x, y, 1, 16);
		} else if (tiles[x][y].getBuildingPosition() == 1) {
			buildingAvailabilityControl.OutlineAvailability(tiles, batch, x-1, y, 1, 16);
		} else if (tiles[x][y].getBuildingPosition() == 2) {
			buildingAvailabilityControl.OutlineAvailability(tiles, batch, x-1, y-1, 1, 16);
		} else if (tiles[x][y].getBuildingPosition() == 3) {
			buildingAvailabilityControl.OutlineAvailability(tiles, batch, x, y-1, 1, 16);
		} else if (tiles[x][y].getBuildingPosition() == 4) {
			buildingAvailabilityControl.OutlineAvailability(tiles, batch, x+1, y-1, 1, 16);
		} else if (tiles[x][y].getBuildingPosition() == 5) {
			buildingAvailabilityControl.OutlineAvailability(tiles, batch, x+1, y, 1, 16);
		} else if (tiles[x][y].getBuildingPosition() == 6) {
			buildingAvailabilityControl.OutlineAvailability(tiles, batch, x+1, y+1, 1, 16);
		} else if (tiles[x][y].getBuildingPosition() == 7) {
			buildingAvailabilityControl.OutlineAvailability(tiles, batch, x, y+1, 1, 16);
		} else if (tiles[x][y].getBuildingPosition() == 8) {
			buildingAvailabilityControl.OutlineAvailability(tiles, batch, x-1, y+1, 1, 16);
		}
		// we know this tile has a warehouse object, we will use it to determine which tiles to draw selected.
		Warehouse warehouse = tiles[x][y].getWarehouse();
		for (Tile tile : warehouse.getWarehouseTiles()) {
			if (tile != null) {
				drawSingleTile(batch, tile);
			}
		}
	}

	public void drawFarmSelected(Tile[][] tiles, Batch batch, int x, int y) {
		// we know this tile has a farm object, we will use it to determine which tiles to draw selected.
		Farm farm = tiles[x][y].getFarm();
		for (Tile tile : farm.getFarmTiles()) {
			drawSingleTile(batch, tile);
		}
	}

	public void drawWoodCutterSelected(BuildingAvailabilityControl buildingAvailabilityControl, Tile[][] tiles, Batch batch, int x, int y) {
		//woodcutter, select all woodcutter tiles of the farm. The first tile is at the bottom otherwise the availability is drawn over it.
		if( tiles[x][y].getBuildingPosition() == 0 ) {
			buildingAvailabilityControl.OutlineAvailability(tiles, batch, x, y, 2, 3);
		} else if( tiles[x][y].getBuildingPosition() == 1 ) {
			buildingAvailabilityControl.OutlineAvailability(tiles, batch, x-1, y, 2, 3);
		} else if( tiles[x][y].getBuildingPosition() == 2 ) {
			buildingAvailabilityControl.OutlineAvailability(tiles, batch, x-1, y-1, 2, 3);
		} else if( tiles[x][y].getBuildingPosition() == 3 ) {
			buildingAvailabilityControl.OutlineAvailability(tiles, batch, x, y-1, 2, 3);
		}
		// we know this tile has a farm object, we will use it to determine which tiles to draw selected.
		WoodCutter woodCutter = tiles[x][y].getWoodCutter();
		for (Tile tile : woodCutter.getWoodCutterTiles()) {
			drawSingleTile(batch, tile);
		}
	}

	public void drawWoodSelected(Tile[][] tiles, Batch batch, int x, int y) {
		drawSingleTile(batch, tiles[x][y]);
	}

	private void drawSingleTile(Batch bitch, Tile tile) {
		bitch.draw( SquareTileRegionSelected, (tile.getPosition().x - 45), (tile.getPosition().y - 23), 0, 0, 90, 46, 1, 1, 0, false);
	}
}
