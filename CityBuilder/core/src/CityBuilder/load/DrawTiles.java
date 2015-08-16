package CityBuilder.load;

import CityBuilder.gameScreen.Simulation;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class DrawTiles extends Data
{	
	public DrawTiles()
	{	
	}
	
	public void fillTiles( Simulation simulation, Batch batch, TextureAtlas atlas )
	{
		for( int i = 0; i < simulation.tiles.size(); i++ )
		{
			simulation.tiles.get(i).drawTile( batch, atlas );
			
			if( simulation.tiles.get(i).getOccupied() != 0 )
			{
				//find out what is on the tile
				if( simulation.tiles.get(i).getOccupied() == 1 )
				{
					//it is a farm
					simulation.tiles.get(i).drawFarm( batch, atlas );
				}
			}
		}
	}
	
	public void drawSelected( Simulation simulation, Batch batch, TextureAtlas atlas, int tileNumber )
	{
		TextureRegion SquareTileRegionSelected;
		SquareTileRegionSelected = atlas.findRegion("SquareGreySmall");
		if( simulation.tiles.get(tileNumber).getOccupied() == 0 )
		{
			batch.draw( SquareTileRegionSelected, (-32 + simulation.tiles.get(tileNumber).getPosition().x), (-32 + simulation.tiles.get(tileNumber).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
		}
		else
		{
			if( simulation.tiles.get(tileNumber).getOccupied() == 1 )
			{
				//farm, select all farm tiles of the farm. Check the tiles next to it.
				batch.draw( SquareTileRegionSelected, (-32 + simulation.tiles.get(tileNumber).getPosition().x), (-32 + simulation.tiles.get(tileNumber).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
				if( simulation.tiles.get(tileNumber).getBuildingPosition() == 0 )
				{
					batch.draw( SquareTileRegionSelected, (-32 + simulation.tiles.get(tileNumber+1).getPosition().x), (-32 + simulation.tiles.get(tileNumber+1).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
					batch.draw( SquareTileRegionSelected, (-32 + simulation.tiles.get(tileNumber-gridSizeWidth).getPosition().x), (-32 + simulation.tiles.get(tileNumber-gridSizeWidth).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
					batch.draw( SquareTileRegionSelected, (-32 + simulation.tiles.get(tileNumber-(gridSizeWidth-1)).getPosition().x), (-32 + simulation.tiles.get(tileNumber-(gridSizeWidth-1)).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
				}
				else if( simulation.tiles.get(tileNumber).getBuildingPosition() == 1 )
				{
					batch.draw( SquareTileRegionSelected, (-32 + simulation.tiles.get(tileNumber+1).getPosition().x), (-32 + simulation.tiles.get(tileNumber+1).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
					batch.draw( SquareTileRegionSelected, (-32 + simulation.tiles.get(tileNumber+gridSizeWidth).getPosition().x), (-32 + simulation.tiles.get(tileNumber+gridSizeWidth).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
					batch.draw( SquareTileRegionSelected, (-32 + simulation.tiles.get(tileNumber+(gridSizeWidth+1)).getPosition().x), (-32 + simulation.tiles.get(tileNumber+(gridSizeWidth+1)).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
				}
				else if( simulation.tiles.get(tileNumber).getBuildingPosition() == 2 )
				{
					batch.draw( SquareTileRegionSelected, (-32 + simulation.tiles.get(tileNumber-1).getPosition().x), (-32 + simulation.tiles.get(tileNumber-1).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
					batch.draw( SquareTileRegionSelected, (-32 + simulation.tiles.get(tileNumber+gridSizeWidth).getPosition().x), (-32 + simulation.tiles.get(tileNumber+gridSizeWidth).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
					batch.draw( SquareTileRegionSelected, (-32 + simulation.tiles.get(tileNumber+(gridSizeWidth-1)).getPosition().x), (-32 + simulation.tiles.get(tileNumber+(gridSizeWidth-1)).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
				}
				else if( simulation.tiles.get(tileNumber).getBuildingPosition() == 3 )
				{
					batch.draw( SquareTileRegionSelected, (-32 + simulation.tiles.get(tileNumber-1).getPosition().x), (-32 + simulation.tiles.get(tileNumber-1).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
					batch.draw( SquareTileRegionSelected, (-32 + simulation.tiles.get(tileNumber-gridSizeWidth).getPosition().x), (-32 + simulation.tiles.get(tileNumber-gridSizeWidth).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
					batch.draw( SquareTileRegionSelected, (-32 + simulation.tiles.get(tileNumber-(gridSizeWidth+1)).getPosition().x), (-32 + simulation.tiles.get(tileNumber-(gridSizeWidth+1)).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
				}
			}
		}
	}
		
	
	public void drawFarmBuild( Simulation simulation, Batch batch, TextureAtlas atlas, int tileNumber )
	{
		TextureRegion SquareTileRegionSelected;
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
		
		if( simulation.tiles.get(tileNumber-gridSizeWidth).getType().toString() == "water" )
		{
			SquareTileRegionSelected = atlas.findRegion("farmbuilding3preFault");
		}
		else
		{
			SquareTileRegionSelected = atlas.findRegion("farmbuilding3pre");
		}
		batch.draw( SquareTileRegionSelected, (-32 + simulation.tiles.get((tileNumber-gridSizeWidth)).getPosition().x), (-32 + simulation.tiles.get((tileNumber-gridSizeWidth)).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
		if( simulation.tiles.get((tileNumber-gridSizeWidth)+1).getType().toString() == "water" )
		{
			SquareTileRegionSelected = atlas.findRegion("farmbuilding4preFault");
		}
		else
		{
			SquareTileRegionSelected = atlas.findRegion("farmbuilding4pre");
		}
		batch.draw( SquareTileRegionSelected, (-32 + simulation.tiles.get((tileNumber-gridSizeWidth)+1).getPosition().x), (-32 + simulation.tiles.get((tileNumber-gridSizeWidth)+1).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
		if( simulation.tiles.get(tileNumber+1).getType().toString() == "water" )
		{
			SquareTileRegionSelected = atlas.findRegion("farmbuilding1preFault");
		}
		else
		{
			SquareTileRegionSelected = atlas.findRegion("farmbuilding1pre");
		}
		batch.draw( SquareTileRegionSelected, (-32 + simulation.tiles.get(tileNumber+1).getPosition().x), (-32 + simulation.tiles.get(tileNumber+1).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
		if( simulation.tiles.get(tileNumber).getType().toString() == "water" )
		{
			SquareTileRegionSelected = atlas.findRegion("farmbuilding2preFault");
		}
		else
		{
			SquareTileRegionSelected = atlas.findRegion("farmbuilding2pre");
		}
		batch.draw( SquareTileRegionSelected, (-32 + simulation.tiles.get(tileNumber).getPosition().x), (-32 + simulation.tiles.get(tileNumber).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
	
	}
	
}
