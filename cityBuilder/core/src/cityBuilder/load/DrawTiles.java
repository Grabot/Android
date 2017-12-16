package cityBuilder.load;

import cityBuilder.gameScreen.Simulation;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class DrawTiles extends Data
{
	private DrawSelectionControl drawselection;

	public DrawTiles(TextureAtlas atlas)
	{
		drawselection = new DrawSelectionControl(atlas);
	}

	public void fillTiles( BuildingAvailabilityControl buildingAvailabilityControl, Simulation simulation, Batch batch )
	{
		for (int x = 0; x < simulation.tiles.size(); x++ ) {
			for (int y = 0; y < simulation.tiles.get(x).size(); y++ ) {
				simulation.tiles.get(x).get(y).drawTile( batch );

				if (simulation.tiles.get(x).get(y).getOccupied() != 0) {
					if (simulation.tiles.get(x).get(y).getOccupied() == 1) {
						simulation.tiles.get(x).get(y).drawFarm(batch);
					} else if (simulation.tiles.get(x).get(y).getOccupied() == 2) {
						simulation.tiles.get(x).get(y).drawWoodCutter(batch);
					} else if (simulation.tiles.get(x).get(y).getOccupied() == 3) {
						simulation.tiles.get(x).get(y).drawWoods(batch);
					} else if (simulation.tiles.get(x).get(y).getOccupied() == 4) {
						// nothing yet
					} else if (simulation.tiles.get(x).get(y).getOccupied() == 5) {
						simulation.tiles.get(x).get(y).drawWarehouse(batch);
					} else if (simulation.tiles.get(x).get(y).getOccupied() == 6) {
						simulation.tiles.get(x).get(y).drawRoads(batch);
					}
				}
			}
		}
	}

	public void drawSelected( BuildingAvailabilityControl buildingAvailabilityControl, Simulation simulation, Batch batch, TextureAtlas atlas, int x, int y )
	{
		TextureRegion SquareTileRegionSelected = atlas.findRegion("SquareGreySmall");

		if( simulation.tiles.get(x).get(y).getOccupied() == 0 ) {
			batch.draw( SquareTileRegionSelected, (-32 + simulation.tiles.get(x).get(y).getPosition().x), (-32 + simulation.tiles.get(x).get(y).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
		} else if( simulation.tiles.get(x).get(y).getOccupied() == 1 ) {
			drawselection.drawFarmSelected(simulation, batch, x, y);
		} else if( simulation.tiles.get(x).get(y).getOccupied() == 2 ) {
			drawselection.drawWoodCutterSelected(buildingAvailabilityControl, simulation, batch, x, y);
		} else if( simulation.tiles.get(x).get(y).getOccupied() == 3 ) {
			drawselection.drawWoodSelected(simulation, batch, x, y);
		} else if ( simulation.tiles.get(x).get(y).getOccupied() == 4 ) {
			drawselection.drawWarehouseSelected(buildingAvailabilityControl, simulation, batch, x, y);
		}
	}

}
