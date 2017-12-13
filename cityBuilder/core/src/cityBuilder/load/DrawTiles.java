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
		for( int i = 0; i < simulation.tiles.size(); i++ )
		{
			simulation.tiles.get(i).drawTile( batch );

			if( simulation.tiles.get(i).getOccupied() != 0 ) {
				// find out what is on the tile
				if( simulation.tiles.get(i).getOccupied() == 1 ) {
					// it is a farm
					simulation.tiles.get(i).drawFarm( batch );
				} else if( simulation.tiles.get(i).getOccupied() == 2 ) {
					// it is a farm
					simulation.tiles.get(i).drawWoodCutter( batch );
				} else if( simulation.tiles.get(i).getOccupied() == 3 ) {
					// it is woods
					simulation.tiles.get(i).drawWoods( batch );
				} else if (simulation.tiles.get(i).getOccupied() == 5 ) {
					// it is warehouse
					simulation.tiles.get(i).drawWarehouse( batch );
				}else if (simulation.tiles.get(i).getOccupied() == 6 ) {
					simulation.tiles.get(i).drawRoads( batch );
				}
			}
		}
	}

	public void drawSelected( BuildingAvailabilityControl buildingAvailabilityControl, Simulation simulation, Batch batch, TextureAtlas atlas, int tileNumber )
	{
		TextureRegion SquareTileRegionSelected = atlas.findRegion("SquareGreySmall");

		if( simulation.tiles.get(tileNumber).getOccupied() == 0 ) {
			batch.draw( SquareTileRegionSelected, (-32 + simulation.tiles.get(tileNumber).getPosition().x), (-32 + simulation.tiles.get(tileNumber).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
		} else if( simulation.tiles.get(tileNumber).getOccupied() == 1 ) {
			drawselection.drawFarmSelected(simulation, batch, tileNumber);
		} else if( simulation.tiles.get(tileNumber).getOccupied() == 2 ) {
			drawselection.drawWoodCutterSelected(buildingAvailabilityControl, simulation, batch, tileNumber);
		} else if( simulation.tiles.get(tileNumber).getOccupied() == 3 ) {
			drawselection.drawWoodSelected(simulation, batch, tileNumber);
		} else if ( simulation.tiles.get(tileNumber).getOccupied() == 4 ) {
			drawselection.drawWarehouseSelected(buildingAvailabilityControl, simulation, batch, tileNumber);
		}
	}

}
