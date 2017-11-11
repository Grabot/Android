package cityBuilder.load;

import cityBuilder.gameScreen.Simulation;
import cityBuilder.objects.Tile;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class DrawBuildingControl extends Data
{
	private TextureRegion SquareOutlineFull;
	private TextureRegion SquareOutlineEdge;

	public DrawBuildingControl(TextureAtlas atlas)
	{
		SquareOutlineFull = atlas.findRegion("outlineFull2");
		SquareOutlineEdge = atlas.findRegion("outlineEdge2");
	}

	public void drawWarehouseBuild(BuildingAvailabilityControl buildingAvailabilityControlSimulation, Simulation simulation, Batch batch, int tileNumber) {
		if( tileNumber < (gridSizeWidth-1) )
		{
			tileNumber = (tileNumber + gridSizeWidth);
		}
		else if( tileNumber == (gridSizeWidth-1) )
		{
			tileNumber = (tileNumber + gridSizeWidth -1 );
		}
		else if( (tileNumber+1) % gridSizeWidth == 0 )
		{
			tileNumber = (tileNumber - 1);
		}

		buildingAvailabilityControlSimulation.buildingAvailability(batch, simulation.tiles.get(tileNumber), 1, 0);
		buildingAvailabilityControlSimulation.buildingAvailability(batch, simulation.tiles.get(tileNumber+1), 1, 1);
		buildingAvailabilityControlSimulation.buildingAvailability(batch, simulation.tiles.get((tileNumber-gridSizeWidth)+1), 1, 2);
		buildingAvailabilityControlSimulation.buildingAvailability(batch, simulation.tiles.get(tileNumber-gridSizeWidth), 1, 3);
		buildingAvailabilityControlSimulation.buildingAvailability(batch, simulation.tiles.get((tileNumber-gridSizeWidth)-1), 1, 4);
		buildingAvailabilityControlSimulation.buildingAvailability(batch, simulation.tiles.get(tileNumber-1), 1, 5);
		buildingAvailabilityControlSimulation.buildingAvailability(batch, simulation.tiles.get((tileNumber+gridSizeWidth)-1), 1, 6);
		buildingAvailabilityControlSimulation.buildingAvailability(batch, simulation.tiles.get((tileNumber+gridSizeWidth)), 1, 7);
		buildingAvailabilityControlSimulation.buildingAvailability(batch, simulation.tiles.get((tileNumber+gridSizeWidth)+1), 1, 8);
	}


	public void drawFarmBuild(BuildingAvailabilityControl buildingAvailabilityControlSimulation, Simulation simulation, Batch batch, int tileNumber)
	{
		if( tileNumber < (gridSizeWidth-1) ) {
			tileNumber = (tileNumber + gridSizeWidth);
		} else if( tileNumber == (gridSizeWidth-1) ) {
			tileNumber = (tileNumber + gridSizeWidth -1 );
		} else if( (tileNumber+1) % gridSizeWidth == 0 ) {
			tileNumber = (tileNumber - 1);
		}

		buildingAvailabilityControlSimulation.buildingAvailability(batch, simulation.tiles.get(tileNumber), 0, 0);
		buildingAvailabilityControlSimulation.buildingAvailability(batch, simulation.tiles.get(tileNumber+1), 0, 1);
		buildingAvailabilityControlSimulation.buildingAvailability(batch,  simulation.tiles.get((tileNumber-gridSizeWidth)+1), 0, 2);
		buildingAvailabilityControlSimulation.buildingAvailability(batch,  simulation.tiles.get(tileNumber-gridSizeWidth), 0, 3);
	}

	public void drawWoodCutterBuild( BuildingAvailabilityControl buildingAvailabilityControlSimulation, Simulation simulation, Batch batch, int tileNumber )
	{
		if( tileNumber < (gridSizeWidth-1) )
		{
			tileNumber = (tileNumber + gridSizeWidth);
		}
		else if( tileNumber == (gridSizeWidth-1) )
		{
			tileNumber = (tileNumber + gridSizeWidth -1 );
		}
		else if( (tileNumber+1) % gridSizeWidth == 0 )
		{
			tileNumber = (tileNumber - 1);
		}

		buildingAvailabilityControlSimulation.buildingAvailability(batch, simulation.tiles.get(tileNumber), 2, 0);
		buildingAvailabilityControlSimulation.buildingAvailability(batch, simulation.tiles.get(tileNumber+1), 2, 1);
		buildingAvailabilityControlSimulation.buildingAvailability(batch,  simulation.tiles.get((tileNumber-gridSizeWidth)+1), 2, 2);
		buildingAvailabilityControlSimulation.buildingAvailability(batch,  simulation.tiles.get(tileNumber-gridSizeWidth), 2, 3);

		WoodCutterOutline(simulation, batch, tileNumber );
	}

	private void WoodCutterOutline(Simulation simulation, Batch batch, int tileNumber )
	{

		//draw outline region for woodcutter
		if(!(tileNumber <= (gridSizeWidth*4)))
		{
			//top side
			batch.draw( SquareOutlineFull, (32 + simulation.tiles.get(tileNumber-(gridSizeWidth*4)).getPosition().x), (32 + simulation.tiles.get(tileNumber-(gridSizeWidth*4)).getPosition().y), 0, 0, 64, 64, 1, 1, 180, false);
			batch.draw( SquareOutlineFull, (32 + simulation.tiles.get(tileNumber-(gridSizeWidth*4)+1).getPosition().x), (32 + simulation.tiles.get(tileNumber-(gridSizeWidth*4)+1).getPosition().y), 0, 0, 64, 64, 1, 1, 180, false);
		}
		if(!(tileNumber >= (gridSizeWidth*(gridSizeHeight-3))))
		{
			//bottom side
			batch.draw( SquareOutlineFull, (-32 + simulation.tiles.get(tileNumber+(gridSizeWidth*3)).getPosition().x), (-32 + simulation.tiles.get(tileNumber+(gridSizeWidth*3)).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
			batch.draw( SquareOutlineFull, (-32 + simulation.tiles.get(tileNumber+(gridSizeWidth*3)+1).getPosition().x), (-32 + simulation.tiles.get(tileNumber+(gridSizeWidth*3)+1).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
		}

		if(!(((((tileNumber)%gridSizeWidth) == 0)) || ((((tileNumber-1)%gridSizeWidth) == 0)) || ((((tileNumber-2)%gridSizeWidth) == 0))))
		{
			batch.draw( SquareOutlineFull, (-32 + simulation.tiles.get(tileNumber-3).getPosition().x), (32 + simulation.tiles.get(tileNumber-3).getPosition().y), 0, 0, 64, 64, 1, 1, -90, false);
			batch.draw( SquareOutlineFull, (-32 + simulation.tiles.get((tileNumber-3)-gridSizeWidth).getPosition().x), (32 + simulation.tiles.get((tileNumber-3)-gridSizeWidth).getPosition().y), 0, 0, 64, 64, 1, 1, -90, false);
		}

		if(!((((tileNumber+4)%(gridSizeWidth)) == 0) || (((tileNumber+3)%(gridSizeWidth)) == 0) || (((tileNumber+2)%(gridSizeWidth)) == 0)))
		{
			//right side
			batch.draw( SquareOutlineFull, (32 + simulation.tiles.get(tileNumber+4).getPosition().x), (-32 + simulation.tiles.get(tileNumber+4).getPosition().y), 0, 0, 64, 64, 1, 1, 90, false);
			batch.draw( SquareOutlineFull, (32 + simulation.tiles.get((tileNumber+4)-gridSizeWidth).getPosition().x), (-32 + simulation.tiles.get((tileNumber+4)-gridSizeWidth).getPosition().y), 0, 0, 64, 64, 1, 1, 90, false);
		}


		if(!(tileNumber <= (gridSizeWidth*4)))
		{
			//top left and top right
			if(!(((tileNumber)%gridSizeWidth) == 0))
			{
				batch.draw( SquareOutlineEdge, (-32 + simulation.tiles.get((tileNumber-1)-(gridSizeWidth*4)).getPosition().x), (32 + simulation.tiles.get((tileNumber-1)-(gridSizeWidth*4)).getPosition().y), 0, 0, 64, 64, 1, 1, -90, false);
			}

			if(!(((tileNumber+2)%(gridSizeWidth)) == 0))
			{
				batch.draw( SquareOutlineEdge, (32 + simulation.tiles.get((tileNumber+2)-(gridSizeWidth*4)).getPosition().x), (32 + simulation.tiles.get((tileNumber+2)-(gridSizeWidth*4)).getPosition().y), 0, 0, 64, 64, 1, 1, 180, false);
			}

		}
		if(!(tileNumber <= (gridSizeWidth*3)))
		{
			//top left and top right
			if(!((((tileNumber-1)%gridSizeWidth) == 0) || (((tileNumber)%gridSizeWidth) == 0)))
			{
				batch.draw( SquareOutlineEdge, (-32 + simulation.tiles.get((tileNumber-2)-(gridSizeWidth*3)).getPosition().x), (32 + simulation.tiles.get((tileNumber-2)-(gridSizeWidth*3)).getPosition().y), 0, 0, 64, 64, 1, 1, -90, false);
			}

			if(!((((tileNumber+3)%(gridSizeWidth)) == 0) || (((tileNumber+2)%(gridSizeWidth)) == 0)))
			{
				batch.draw( SquareOutlineEdge, (32 + simulation.tiles.get((tileNumber+3)-(gridSizeWidth*3)).getPosition().x), (32 + simulation.tiles.get((tileNumber+3)-(gridSizeWidth*3)).getPosition().y), 0, 0, 64, 64, 1, 1, 180, false);
			}
		}
		if(!(tileNumber <= (gridSizeWidth*2)))
		{
			//top left and right
			if(!((((tileNumber-2)%gridSizeWidth) == 0) || (((tileNumber-1)%gridSizeWidth) == 0) || (((tileNumber)%gridSizeWidth) == 0)))
			{
				batch.draw( SquareOutlineEdge, (-32 + simulation.tiles.get((tileNumber-3)-(gridSizeWidth*2)).getPosition().x), (32 + simulation.tiles.get((tileNumber-3)-(gridSizeWidth*2)).getPosition().y), 0, 0, 64, 64, 1, 1, -90, false);
			}
			if(!((((tileNumber+4)%(gridSizeWidth)) == 0) || (((tileNumber+3)%(gridSizeWidth)) == 0) || (((tileNumber+2)%(gridSizeWidth)) == 0)))
			{
				batch.draw( SquareOutlineEdge, (32 + simulation.tiles.get((tileNumber+4)-(gridSizeWidth*2)).getPosition().x), (32 + simulation.tiles.get((tileNumber+4)-(gridSizeWidth*2)).getPosition().y), 0, 0, 64, 64, 1, 1, 180, false);
			}
		}

		if(!(tileNumber >= (gridSizeWidth*(gridSizeHeight-3))))
		{
			//bottom left and right
			if(!(((tileNumber)%gridSizeWidth) == 0))
			{
				batch.draw( SquareOutlineEdge, (-32 + simulation.tiles.get((tileNumber-1)+(gridSizeWidth*3)).getPosition().x), (-32 + simulation.tiles.get((tileNumber-1)+(gridSizeWidth*3)).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
			}
			if(!(((tileNumber+2)%(gridSizeWidth)) == 0))
			{
				batch.draw( SquareOutlineEdge, (32 + simulation.tiles.get((tileNumber+2)+(gridSizeWidth*3)).getPosition().x), (-32 + simulation.tiles.get((tileNumber+2)+(gridSizeWidth*3)).getPosition().y), 0, 0, 64, 64, 1, 1, 90, false);
			}
		}
		if(!(tileNumber >= (gridSizeWidth*(gridSizeHeight-2))))
		{
			//bottom left and right
			if(!((((tileNumber-1)%gridSizeWidth) == 0) || (((tileNumber)%gridSizeWidth) == 0)))
			{
				batch.draw( SquareOutlineEdge, (-32 + simulation.tiles.get((tileNumber-2)+(gridSizeWidth*2)).getPosition().x), (-32 + simulation.tiles.get((tileNumber-2)+(gridSizeWidth*2)).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
			}
			if(!((((tileNumber+3)%(gridSizeWidth)) == 0) || (((tileNumber+2)%(gridSizeWidth)) == 0)))
			{
				batch.draw( SquareOutlineEdge, (32 + simulation.tiles.get((tileNumber+3)+(gridSizeWidth*2)).getPosition().x), (-32 + simulation.tiles.get((tileNumber+3)+(gridSizeWidth*2)).getPosition().y), 0, 0, 64, 64, 1, 1, 90, false);
			}
		}
		if(!(tileNumber >= (gridSizeWidth*(gridSizeHeight-1))))
		{
			//bottom left and right
			if(!((((tileNumber-2)%gridSizeWidth) == 0) || (((tileNumber-1)%gridSizeWidth) == 0) || (((tileNumber)%gridSizeWidth) == 0)))
			{
				batch.draw( SquareOutlineEdge, (-32 + simulation.tiles.get((tileNumber-3)+(gridSizeWidth*1)).getPosition().x), (-32 + simulation.tiles.get((tileNumber-3)+(gridSizeWidth*1)).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
			}
			if(!((((tileNumber+4)%(gridSizeWidth)) == 0) || (((tileNumber+3)%(gridSizeWidth)) == 0) || (((tileNumber+2)%(gridSizeWidth)) == 0)))
			{
				batch.draw( SquareOutlineEdge, (32 + simulation.tiles.get((tileNumber+4)+(gridSizeWidth*1)).getPosition().x), (-32 + simulation.tiles.get((tileNumber+4)+(gridSizeWidth*1)).getPosition().y), 0, 0, 64, 64, 1, 1, 90, false);
			}
		}
	}
}
