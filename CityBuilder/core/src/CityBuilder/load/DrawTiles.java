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
				else if( simulation.tiles.get(i).getOccupied() == 2 )
				{
					//it is a farm
					simulation.tiles.get(i).drawWoodCutter(batch, atlas);
				}
			}
		}
	}
	
	public void drawSelected( Simulation simulation, Batch batch, TextureAtlas atlas, int tileNumber )
	{
		TextureRegion SquareTileRegionSelected = atlas.findRegion("SquareGreySmall");
		
		if( simulation.tiles.get(tileNumber).getOccupied() == 0 )
		{
			batch.draw( SquareTileRegionSelected, (-32 + simulation.tiles.get(tileNumber).getPosition().x), (-32 + simulation.tiles.get(tileNumber).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
		}
		else
		{
			if(( simulation.tiles.get(tileNumber).getOccupied() == 1 ) || ( simulation.tiles.get(tileNumber).getOccupied() == 2 ))
			{
				//farm, select all farm tiles of the farm. Check the tiles next to it.
				batch.draw( SquareTileRegionSelected, (-32 + simulation.tiles.get(tileNumber).getPosition().x), (-32 + simulation.tiles.get(tileNumber).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
				if( simulation.tiles.get(tileNumber).getBuildingPosition() == 0 )
				{
					drawOutline( simulation, batch, atlas, tileNumber );
					batch.draw( SquareTileRegionSelected, (-32 + simulation.tiles.get(tileNumber+1).getPosition().x), (-32 + simulation.tiles.get(tileNumber+1).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
					batch.draw( SquareTileRegionSelected, (-32 + simulation.tiles.get(tileNumber-gridSizeWidth).getPosition().x), (-32 + simulation.tiles.get(tileNumber-gridSizeWidth).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
					batch.draw( SquareTileRegionSelected, (-32 + simulation.tiles.get(tileNumber-(gridSizeWidth-1)).getPosition().x), (-32 + simulation.tiles.get(tileNumber-(gridSizeWidth-1)).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
				}
				else if( simulation.tiles.get(tileNumber).getBuildingPosition() == 1 )
				{
					drawOutline( simulation, batch, atlas, (tileNumber+gridSizeWidth) );
					batch.draw( SquareTileRegionSelected, (-32 + simulation.tiles.get(tileNumber+1).getPosition().x), (-32 + simulation.tiles.get(tileNumber+1).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
					batch.draw( SquareTileRegionSelected, (-32 + simulation.tiles.get(tileNumber+gridSizeWidth).getPosition().x), (-32 + simulation.tiles.get(tileNumber+gridSizeWidth).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
					batch.draw( SquareTileRegionSelected, (-32 + simulation.tiles.get(tileNumber+(gridSizeWidth+1)).getPosition().x), (-32 + simulation.tiles.get(tileNumber+(gridSizeWidth+1)).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
				}
				else if( simulation.tiles.get(tileNumber).getBuildingPosition() == 2 )
				{
					drawOutline( simulation, batch, atlas, (tileNumber+(gridSizeWidth-1)) );
					batch.draw( SquareTileRegionSelected, (-32 + simulation.tiles.get(tileNumber-1).getPosition().x), (-32 + simulation.tiles.get(tileNumber-1).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
					batch.draw( SquareTileRegionSelected, (-32 + simulation.tiles.get(tileNumber+gridSizeWidth).getPosition().x), (-32 + simulation.tiles.get(tileNumber+gridSizeWidth).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
					batch.draw( SquareTileRegionSelected, (-32 + simulation.tiles.get(tileNumber+(gridSizeWidth-1)).getPosition().x), (-32 + simulation.tiles.get(tileNumber+(gridSizeWidth-1)).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
				}
				else if( simulation.tiles.get(tileNumber).getBuildingPosition() == 3 )
				{
					drawOutline( simulation, batch, atlas, (tileNumber-1) );
					batch.draw( SquareTileRegionSelected, (-32 + simulation.tiles.get(tileNumber-1).getPosition().x), (-32 + simulation.tiles.get(tileNumber-1).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
					batch.draw( SquareTileRegionSelected, (-32 + simulation.tiles.get(tileNumber-gridSizeWidth).getPosition().x), (-32 + simulation.tiles.get(tileNumber-gridSizeWidth).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
					batch.draw( SquareTileRegionSelected, (-32 + simulation.tiles.get(tileNumber-(gridSizeWidth+1)).getPosition().x), (-32 + simulation.tiles.get(tileNumber-(gridSizeWidth+1)).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
				}
				
				
			}
		}
	}
	
	private void drawOutline(Simulation simulation, Batch batch, TextureAtlas atlas, int tileNumber)
	{
		//draw outline region for woodcutter
				TextureRegion SquareTileRegionSelected = atlas.findRegion("outlineFull2");
				
				if(!(tileNumber <= (gridSizeWidth*4)))
				{
					//top side
					batch.draw( SquareTileRegionSelected, (32 + simulation.tiles.get(tileNumber-(gridSizeWidth*4)).getPosition().x), (32 + simulation.tiles.get(tileNumber-(gridSizeWidth*4)).getPosition().y), 0, 0, 64, 64, 1, 1, 180, false);
					batch.draw( SquareTileRegionSelected, (32 + simulation.tiles.get(tileNumber-(gridSizeWidth*4)+1).getPosition().x), (32 + simulation.tiles.get(tileNumber-(gridSizeWidth*4)+1).getPosition().y), 0, 0, 64, 64, 1, 1, 180, false);
				}
				if(!(tileNumber >= (gridSizeWidth*(gridSizeHeight-3))))
				{
					//bottom side
					batch.draw( SquareTileRegionSelected, (-32 + simulation.tiles.get(tileNumber+(gridSizeWidth*3)).getPosition().x), (-32 + simulation.tiles.get(tileNumber+(gridSizeWidth*3)).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
					batch.draw( SquareTileRegionSelected, (-32 + simulation.tiles.get(tileNumber+(gridSizeWidth*3)+1).getPosition().x), (-32 + simulation.tiles.get(tileNumber+(gridSizeWidth*3)+1).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
				}
				
				if(!(((((tileNumber)%gridSizeWidth) == 0)) || ((((tileNumber-1)%gridSizeWidth) == 0)) || ((((tileNumber-2)%gridSizeWidth) == 0))))
				{
					batch.draw( SquareTileRegionSelected, (-32 + simulation.tiles.get(tileNumber-3).getPosition().x), (32 + simulation.tiles.get(tileNumber-3).getPosition().y), 0, 0, 64, 64, 1, 1, -90, false);
					batch.draw( SquareTileRegionSelected, (-32 + simulation.tiles.get((tileNumber-3)-gridSizeWidth).getPosition().x), (32 + simulation.tiles.get((tileNumber-3)-gridSizeWidth).getPosition().y), 0, 0, 64, 64, 1, 1, -90, false);
				}

				if(!((((tileNumber+4)%(gridSizeWidth)) == 0) || (((tileNumber+3)%(gridSizeWidth)) == 0) || (((tileNumber+2)%(gridSizeWidth)) == 0)))
				{	
					//right side
					batch.draw( SquareTileRegionSelected, (32 + simulation.tiles.get(tileNumber+4).getPosition().x), (-32 + simulation.tiles.get(tileNumber+4).getPosition().y), 0, 0, 64, 64, 1, 1, 90, false);
					batch.draw( SquareTileRegionSelected, (32 + simulation.tiles.get((tileNumber+4)-gridSizeWidth).getPosition().x), (-32 + simulation.tiles.get((tileNumber+4)-gridSizeWidth).getPosition().y), 0, 0, 64, 64, 1, 1, 90, false);
				}
						
				SquareTileRegionSelected = atlas.findRegion("outlineEdge2");
				if(!(tileNumber <= (gridSizeWidth*4)))
				{
					//top left and top right
					if(!(((tileNumber)%gridSizeWidth) == 0))
					{
						batch.draw( SquareTileRegionSelected, (-32 + simulation.tiles.get((tileNumber-1)-(gridSizeWidth*4)).getPosition().x), (32 + simulation.tiles.get((tileNumber-1)-(gridSizeWidth*4)).getPosition().y), 0, 0, 64, 64, 1, 1, -90, false);
					}

					if(!(((tileNumber+2)%(gridSizeWidth)) == 0))
					{	
						batch.draw( SquareTileRegionSelected, (32 + simulation.tiles.get((tileNumber+2)-(gridSizeWidth*4)).getPosition().x), (32 + simulation.tiles.get((tileNumber+2)-(gridSizeWidth*4)).getPosition().y), 0, 0, 64, 64, 1, 1, 180, false);
					}
					
				}
				if(!(tileNumber <= (gridSizeWidth*3)))
				{
					//top left and top right
					if(!((((tileNumber-1)%gridSizeWidth) == 0) || (((tileNumber)%gridSizeWidth) == 0)))
					{
						batch.draw( SquareTileRegionSelected, (-32 + simulation.tiles.get((tileNumber-2)-(gridSizeWidth*3)).getPosition().x), (32 + simulation.tiles.get((tileNumber-2)-(gridSizeWidth*3)).getPosition().y), 0, 0, 64, 64, 1, 1, -90, false);
					}
					
					if(!((((tileNumber+3)%(gridSizeWidth)) == 0) || (((tileNumber+2)%(gridSizeWidth)) == 0)))
					{	
						batch.draw( SquareTileRegionSelected, (32 + simulation.tiles.get((tileNumber+3)-(gridSizeWidth*3)).getPosition().x), (32 + simulation.tiles.get((tileNumber+3)-(gridSizeWidth*3)).getPosition().y), 0, 0, 64, 64, 1, 1, 180, false);
					}
				}
				if(!(tileNumber <= (gridSizeWidth*2)))
				{
					//top left and right
					if(!((((tileNumber-2)%gridSizeWidth) == 0) || (((tileNumber-1)%gridSizeWidth) == 0) || (((tileNumber)%gridSizeWidth) == 0)))
					{
						batch.draw( SquareTileRegionSelected, (-32 + simulation.tiles.get((tileNumber-3)-(gridSizeWidth*2)).getPosition().x), (32 + simulation.tiles.get((tileNumber-3)-(gridSizeWidth*2)).getPosition().y), 0, 0, 64, 64, 1, 1, -90, false);
					}
					if(!((((tileNumber+4)%(gridSizeWidth)) == 0) || (((tileNumber+3)%(gridSizeWidth)) == 0) || (((tileNumber+2)%(gridSizeWidth)) == 0)))
					{	
						batch.draw( SquareTileRegionSelected, (32 + simulation.tiles.get((tileNumber+4)-(gridSizeWidth*2)).getPosition().x), (32 + simulation.tiles.get((tileNumber+4)-(gridSizeWidth*2)).getPosition().y), 0, 0, 64, 64, 1, 1, 180, false);
					}
				}
				
				if(!(tileNumber >= (gridSizeWidth*(gridSizeHeight-3))))
				{
					//bottom left and right
					if(!(((tileNumber)%gridSizeWidth) == 0))
					{
						batch.draw( SquareTileRegionSelected, (-32 + simulation.tiles.get((tileNumber-1)+(gridSizeWidth*3)).getPosition().x), (-32 + simulation.tiles.get((tileNumber-1)+(gridSizeWidth*3)).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
					}
					if(!(((tileNumber+2)%(gridSizeWidth)) == 0))
					{	
						batch.draw( SquareTileRegionSelected, (32 + simulation.tiles.get((tileNumber+2)+(gridSizeWidth*3)).getPosition().x), (-32 + simulation.tiles.get((tileNumber+2)+(gridSizeWidth*3)).getPosition().y), 0, 0, 64, 64, 1, 1, 90, false);
					}
				}
				if(!(tileNumber >= (gridSizeWidth*(gridSizeHeight-2))))
				{
					//bottom left and right
					if(!((((tileNumber-1)%gridSizeWidth) == 0) || (((tileNumber)%gridSizeWidth) == 0)))
					{
						batch.draw( SquareTileRegionSelected, (-32 + simulation.tiles.get((tileNumber-2)+(gridSizeWidth*2)).getPosition().x), (-32 + simulation.tiles.get((tileNumber-2)+(gridSizeWidth*2)).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
					}
					if(!((((tileNumber+3)%(gridSizeWidth)) == 0) || (((tileNumber+2)%(gridSizeWidth)) == 0)))
					{	
						batch.draw( SquareTileRegionSelected, (32 + simulation.tiles.get((tileNumber+3)+(gridSizeWidth*2)).getPosition().x), (-32 + simulation.tiles.get((tileNumber+3)+(gridSizeWidth*2)).getPosition().y), 0, 0, 64, 64, 1, 1, 90, false);
					}
				}
				if(!(tileNumber >= (gridSizeWidth*(gridSizeHeight-1))))
				{
					//bottom left and right
					if(!((((tileNumber-2)%gridSizeWidth) == 0) || (((tileNumber-1)%gridSizeWidth) == 0) || (((tileNumber)%gridSizeWidth) == 0)))
					{
						batch.draw( SquareTileRegionSelected, (-32 + simulation.tiles.get((tileNumber-3)+(gridSizeWidth*1)).getPosition().x), (-32 + simulation.tiles.get((tileNumber-3)+(gridSizeWidth*1)).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
					}
					if(!((((tileNumber+4)%(gridSizeWidth)) == 0) || (((tileNumber+3)%(gridSizeWidth)) == 0) || (((tileNumber+2)%(gridSizeWidth)) == 0)))
					{	
						batch.draw( SquareTileRegionSelected, (32 + simulation.tiles.get((tileNumber+4)+(gridSizeWidth*1)).getPosition().x), (-32 + simulation.tiles.get((tileNumber+4)+(gridSizeWidth*1)).getPosition().y), 0, 0, 64, 64, 1, 1, 90, false);
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
		
		SquareTileRegionSelected = atlas.findRegion("farmbuilding2");
		batch.draw( SquareTileRegionSelected, (-32 + simulation.tiles.get(tileNumber).getPosition().x), (-32 + simulation.tiles.get(tileNumber).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
		if( simulation.tiles.get(tileNumber).getType().toString() == "water" )
		{
			SquareTileRegionSelected = atlas.findRegion("SquareRedSmall");
			batch.draw( SquareTileRegionSelected, (-32 + simulation.tiles.get(tileNumber).getPosition().x), (-32 + simulation.tiles.get(tileNumber).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
		}
		else
		{
			SquareTileRegionSelected = atlas.findRegion("SquareGreenSmall");
			batch.draw( SquareTileRegionSelected, (-32 + simulation.tiles.get(tileNumber).getPosition().x), (-32 + simulation.tiles.get(tileNumber).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
		}
		
		SquareTileRegionSelected = atlas.findRegion("farmbuilding1");
		batch.draw( SquareTileRegionSelected, (-32 + simulation.tiles.get(tileNumber+1).getPosition().x), (-32 + simulation.tiles.get(tileNumber+1).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
		if( simulation.tiles.get(tileNumber+1).getType().toString() == "water" )
		{
			SquareTileRegionSelected = atlas.findRegion("SquareRedSmall");
			batch.draw( SquareTileRegionSelected, (-32 + simulation.tiles.get(tileNumber+1).getPosition().x), (32 + simulation.tiles.get(tileNumber+1).getPosition().y), 0, 0, 64, 64, 1, 1, -90, false);
		}
		else
		{
			SquareTileRegionSelected = atlas.findRegion("SquareGreenSmall");
			batch.draw( SquareTileRegionSelected, (-32 + simulation.tiles.get(tileNumber+1).getPosition().x), (32 + simulation.tiles.get(tileNumber+1).getPosition().y), 0, 0, 64, 64, 1, 1, -90, false);
		}
		
		SquareTileRegionSelected = atlas.findRegion("farmbuilding3");
		batch.draw( SquareTileRegionSelected, (-32 + simulation.tiles.get((tileNumber-gridSizeWidth)).getPosition().x), (-32 + simulation.tiles.get((tileNumber-gridSizeWidth)).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
		if( simulation.tiles.get((tileNumber-gridSizeWidth)).getType().toString() == "water" )
		{
			SquareTileRegionSelected = atlas.findRegion("SquareRedSmall");
			batch.draw( SquareTileRegionSelected, (-32 + simulation.tiles.get((tileNumber-gridSizeWidth)).getPosition().x), (32 + simulation.tiles.get((tileNumber-gridSizeWidth)).getPosition().y), 0, 0, 64, 64, 1, 1, -90, false);
		}
		else
		{
			SquareTileRegionSelected = atlas.findRegion("SquareGreenSmall");
			batch.draw( SquareTileRegionSelected, (-32 + simulation.tiles.get((tileNumber-gridSizeWidth)).getPosition().x), (32 + simulation.tiles.get((tileNumber-gridSizeWidth)).getPosition().y), 0, 0, 64, 64, 1, 1, -90, false);
		}
		
		SquareTileRegionSelected = atlas.findRegion("farmbuilding4");
		batch.draw( SquareTileRegionSelected, (-32 + simulation.tiles.get((tileNumber-gridSizeWidth)+1).getPosition().x), (-32 + simulation.tiles.get((tileNumber-gridSizeWidth)+1).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
		if( simulation.tiles.get((tileNumber-gridSizeWidth)+1).getType().toString() == "water" )
		{
			SquareTileRegionSelected = atlas.findRegion("SquareRedSmall");
			batch.draw( SquareTileRegionSelected, (-32 + simulation.tiles.get((tileNumber-gridSizeWidth)+1).getPosition().x), (32 + simulation.tiles.get((tileNumber-gridSizeWidth)+1).getPosition().y), 0, 0, 64, 64, 1, 1, -90, false);
		}
		else
		{
			SquareTileRegionSelected = atlas.findRegion("SquareGreenSmall");
			batch.draw( SquareTileRegionSelected, (-32 + simulation.tiles.get((tileNumber-gridSizeWidth)+1).getPosition().x), (32 + simulation.tiles.get((tileNumber-gridSizeWidth)+1).getPosition().y), 0, 0, 64, 64, 1, 1, -90, false);
		}
	}
	
	public void drawWoodCutterBuild( Simulation simulation, Batch batch, TextureAtlas atlas, int tileNumber )
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
		
		SquareTileRegionSelected = atlas.findRegion("WoodCutterBuilding2");
		batch.draw( SquareTileRegionSelected, (-32 + simulation.tiles.get(tileNumber).getPosition().x), (-32 + simulation.tiles.get(tileNumber).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
		if( simulation.tiles.get(tileNumber).getType().toString() == "water" )
		{
			SquareTileRegionSelected = atlas.findRegion("SquareRedSmall");
			batch.draw( SquareTileRegionSelected, (-32 + simulation.tiles.get(tileNumber).getPosition().x), (-32 + simulation.tiles.get(tileNumber).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
		}
		else
		{
			SquareTileRegionSelected = atlas.findRegion("SquareGreenSmall");
			batch.draw( SquareTileRegionSelected, (-32 + simulation.tiles.get(tileNumber).getPosition().x), (-32 + simulation.tiles.get(tileNumber).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
		}
		
		SquareTileRegionSelected = atlas.findRegion("WoodCutterBuilding1");
		batch.draw( SquareTileRegionSelected, (-32 + simulation.tiles.get(tileNumber+1).getPosition().x), (-32 + simulation.tiles.get(tileNumber+1).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
		if( simulation.tiles.get(tileNumber+1).getType().toString() == "water" )
		{
			SquareTileRegionSelected = atlas.findRegion("SquareRedSmall");
			batch.draw( SquareTileRegionSelected, (-32 + simulation.tiles.get(tileNumber+1).getPosition().x), (32 + simulation.tiles.get(tileNumber+1).getPosition().y), 0, 0, 64, 64, 1, 1, -90, false);
		}
		else
		{
			SquareTileRegionSelected = atlas.findRegion("SquareGreenSmall");
			batch.draw( SquareTileRegionSelected, (-32 + simulation.tiles.get(tileNumber+1).getPosition().x), (32 + simulation.tiles.get(tileNumber+1).getPosition().y), 0, 0, 64, 64, 1, 1, -90, false);
		}
		
		SquareTileRegionSelected = atlas.findRegion("WoodCutterBuilding3");
		batch.draw( SquareTileRegionSelected, (-32 + simulation.tiles.get((tileNumber-gridSizeWidth)).getPosition().x), (-32 + simulation.tiles.get((tileNumber-gridSizeWidth)).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
		if( simulation.tiles.get((tileNumber-gridSizeWidth)).getType().toString() == "water" )
		{
			SquareTileRegionSelected = atlas.findRegion("SquareRedSmall");
			batch.draw( SquareTileRegionSelected, (-32 + simulation.tiles.get((tileNumber-gridSizeWidth)).getPosition().x), (32 + simulation.tiles.get((tileNumber-gridSizeWidth)).getPosition().y), 0, 0, 64, 64, 1, 1, -90, false);
		}
		else
		{
			SquareTileRegionSelected = atlas.findRegion("SquareGreenSmall");
			batch.draw( SquareTileRegionSelected, (-32 + simulation.tiles.get((tileNumber-gridSizeWidth)).getPosition().x), (32 + simulation.tiles.get((tileNumber-gridSizeWidth)).getPosition().y), 0, 0, 64, 64, 1, 1, -90, false);
		}
		
		SquareTileRegionSelected = atlas.findRegion("WoodCutterBuilding4");
		batch.draw( SquareTileRegionSelected, (-32 + simulation.tiles.get((tileNumber-gridSizeWidth)+1).getPosition().x), (-32 + simulation.tiles.get((tileNumber-gridSizeWidth)+1).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
		if( simulation.tiles.get((tileNumber-gridSizeWidth)+1).getType().toString() == "water" )
		{
			SquareTileRegionSelected = atlas.findRegion("SquareRedSmall");
			batch.draw( SquareTileRegionSelected, (-32 + simulation.tiles.get((tileNumber-gridSizeWidth)+1).getPosition().x), (32 + simulation.tiles.get((tileNumber-gridSizeWidth)+1).getPosition().y), 0, 0, 64, 64, 1, 1, -90, false);
		}
		else
		{
			SquareTileRegionSelected = atlas.findRegion("SquareGreenSmall");
			batch.draw( SquareTileRegionSelected, (-32 + simulation.tiles.get((tileNumber-gridSizeWidth)+1).getPosition().x), (32 + simulation.tiles.get((tileNumber-gridSizeWidth)+1).getPosition().y), 0, 0, 64, 64, 1, 1, -90, false);
		}
		

		//draw outline region for woodcutter
		SquareTileRegionSelected = atlas.findRegion("outlineFull2");
		
		if(!(tileNumber <= (gridSizeWidth*4)))
		{
			//top side
			batch.draw( SquareTileRegionSelected, (32 + simulation.tiles.get(tileNumber-(gridSizeWidth*4)).getPosition().x), (32 + simulation.tiles.get(tileNumber-(gridSizeWidth*4)).getPosition().y), 0, 0, 64, 64, 1, 1, 180, false);
			batch.draw( SquareTileRegionSelected, (32 + simulation.tiles.get(tileNumber-(gridSizeWidth*4)+1).getPosition().x), (32 + simulation.tiles.get(tileNumber-(gridSizeWidth*4)+1).getPosition().y), 0, 0, 64, 64, 1, 1, 180, false);
		}
		if(!(tileNumber >= (gridSizeWidth*(gridSizeHeight-3))))
		{
			//bottom side
			batch.draw( SquareTileRegionSelected, (-32 + simulation.tiles.get(tileNumber+(gridSizeWidth*3)).getPosition().x), (-32 + simulation.tiles.get(tileNumber+(gridSizeWidth*3)).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
			batch.draw( SquareTileRegionSelected, (-32 + simulation.tiles.get(tileNumber+(gridSizeWidth*3)+1).getPosition().x), (-32 + simulation.tiles.get(tileNumber+(gridSizeWidth*3)+1).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
		}
		
		if(!(((((tileNumber)%gridSizeWidth) == 0)) || ((((tileNumber-1)%gridSizeWidth) == 0)) || ((((tileNumber-2)%gridSizeWidth) == 0))))
		{
			batch.draw( SquareTileRegionSelected, (-32 + simulation.tiles.get(tileNumber-3).getPosition().x), (32 + simulation.tiles.get(tileNumber-3).getPosition().y), 0, 0, 64, 64, 1, 1, -90, false);
			batch.draw( SquareTileRegionSelected, (-32 + simulation.tiles.get((tileNumber-3)-gridSizeWidth).getPosition().x), (32 + simulation.tiles.get((tileNumber-3)-gridSizeWidth).getPosition().y), 0, 0, 64, 64, 1, 1, -90, false);
		}

		if(!((((tileNumber+4)%(gridSizeWidth)) == 0) || (((tileNumber+3)%(gridSizeWidth)) == 0) || (((tileNumber+2)%(gridSizeWidth)) == 0)))
		{	
			//right side
			batch.draw( SquareTileRegionSelected, (32 + simulation.tiles.get(tileNumber+4).getPosition().x), (-32 + simulation.tiles.get(tileNumber+4).getPosition().y), 0, 0, 64, 64, 1, 1, 90, false);
			batch.draw( SquareTileRegionSelected, (32 + simulation.tiles.get((tileNumber+4)-gridSizeWidth).getPosition().x), (-32 + simulation.tiles.get((tileNumber+4)-gridSizeWidth).getPosition().y), 0, 0, 64, 64, 1, 1, 90, false);
		}
				
		SquareTileRegionSelected = atlas.findRegion("outlineEdge2");
		if(!(tileNumber <= (gridSizeWidth*4)))
		{
			//top left and top right
			if(!(((tileNumber)%gridSizeWidth) == 0))
			{
				batch.draw( SquareTileRegionSelected, (-32 + simulation.tiles.get((tileNumber-1)-(gridSizeWidth*4)).getPosition().x), (32 + simulation.tiles.get((tileNumber-1)-(gridSizeWidth*4)).getPosition().y), 0, 0, 64, 64, 1, 1, -90, false);
			}

			if(!(((tileNumber+2)%(gridSizeWidth)) == 0))
			{	
				batch.draw( SquareTileRegionSelected, (32 + simulation.tiles.get((tileNumber+2)-(gridSizeWidth*4)).getPosition().x), (32 + simulation.tiles.get((tileNumber+2)-(gridSizeWidth*4)).getPosition().y), 0, 0, 64, 64, 1, 1, 180, false);
			}
			
		}
		if(!(tileNumber <= (gridSizeWidth*3)))
		{
			//top left and top right
			if(!((((tileNumber-1)%gridSizeWidth) == 0) || (((tileNumber)%gridSizeWidth) == 0)))
			{
				batch.draw( SquareTileRegionSelected, (-32 + simulation.tiles.get((tileNumber-2)-(gridSizeWidth*3)).getPosition().x), (32 + simulation.tiles.get((tileNumber-2)-(gridSizeWidth*3)).getPosition().y), 0, 0, 64, 64, 1, 1, -90, false);
			}
			
			if(!((((tileNumber+3)%(gridSizeWidth)) == 0) || (((tileNumber+2)%(gridSizeWidth)) == 0)))
			{	
				batch.draw( SquareTileRegionSelected, (32 + simulation.tiles.get((tileNumber+3)-(gridSizeWidth*3)).getPosition().x), (32 + simulation.tiles.get((tileNumber+3)-(gridSizeWidth*3)).getPosition().y), 0, 0, 64, 64, 1, 1, 180, false);
			}
		}
		if(!(tileNumber <= (gridSizeWidth*2)))
		{
			//top left and right
			if(!((((tileNumber-2)%gridSizeWidth) == 0) || (((tileNumber-1)%gridSizeWidth) == 0) || (((tileNumber)%gridSizeWidth) == 0)))
			{
				batch.draw( SquareTileRegionSelected, (-32 + simulation.tiles.get((tileNumber-3)-(gridSizeWidth*2)).getPosition().x), (32 + simulation.tiles.get((tileNumber-3)-(gridSizeWidth*2)).getPosition().y), 0, 0, 64, 64, 1, 1, -90, false);
			}
			if(!((((tileNumber+4)%(gridSizeWidth)) == 0) || (((tileNumber+3)%(gridSizeWidth)) == 0) || (((tileNumber+2)%(gridSizeWidth)) == 0)))
			{	
				batch.draw( SquareTileRegionSelected, (32 + simulation.tiles.get((tileNumber+4)-(gridSizeWidth*2)).getPosition().x), (32 + simulation.tiles.get((tileNumber+4)-(gridSizeWidth*2)).getPosition().y), 0, 0, 64, 64, 1, 1, 180, false);
			}
		}
		
		if(!(tileNumber >= (gridSizeWidth*(gridSizeHeight-3))))
		{
			//bottom left and right
			if(!(((tileNumber)%gridSizeWidth) == 0))
			{
				batch.draw( SquareTileRegionSelected, (-32 + simulation.tiles.get((tileNumber-1)+(gridSizeWidth*3)).getPosition().x), (-32 + simulation.tiles.get((tileNumber-1)+(gridSizeWidth*3)).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
			}
			if(!(((tileNumber+2)%(gridSizeWidth)) == 0))
			{	
				batch.draw( SquareTileRegionSelected, (32 + simulation.tiles.get((tileNumber+2)+(gridSizeWidth*3)).getPosition().x), (-32 + simulation.tiles.get((tileNumber+2)+(gridSizeWidth*3)).getPosition().y), 0, 0, 64, 64, 1, 1, 90, false);
			}
		}
		if(!(tileNumber >= (gridSizeWidth*(gridSizeHeight-2))))
		{
			//bottom left and right
			if(!((((tileNumber-1)%gridSizeWidth) == 0) || (((tileNumber)%gridSizeWidth) == 0)))
			{
				batch.draw( SquareTileRegionSelected, (-32 + simulation.tiles.get((tileNumber-2)+(gridSizeWidth*2)).getPosition().x), (-32 + simulation.tiles.get((tileNumber-2)+(gridSizeWidth*2)).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
			}
			if(!((((tileNumber+3)%(gridSizeWidth)) == 0) || (((tileNumber+2)%(gridSizeWidth)) == 0)))
			{	
				batch.draw( SquareTileRegionSelected, (32 + simulation.tiles.get((tileNumber+3)+(gridSizeWidth*2)).getPosition().x), (-32 + simulation.tiles.get((tileNumber+3)+(gridSizeWidth*2)).getPosition().y), 0, 0, 64, 64, 1, 1, 90, false);
			}
		}
		if(!(tileNumber >= (gridSizeWidth*(gridSizeHeight-1))))
		{
			//bottom left and right
			if(!((((tileNumber-2)%gridSizeWidth) == 0) || (((tileNumber-1)%gridSizeWidth) == 0) || (((tileNumber)%gridSizeWidth) == 0)))
			{
				batch.draw( SquareTileRegionSelected, (-32 + simulation.tiles.get((tileNumber-3)+(gridSizeWidth*1)).getPosition().x), (-32 + simulation.tiles.get((tileNumber-3)+(gridSizeWidth*1)).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
			}
			if(!((((tileNumber+4)%(gridSizeWidth)) == 0) || (((tileNumber+3)%(gridSizeWidth)) == 0) || (((tileNumber+2)%(gridSizeWidth)) == 0)))
			{	
				batch.draw( SquareTileRegionSelected, (32 + simulation.tiles.get((tileNumber+4)+(gridSizeWidth*1)).getPosition().x), (-32 + simulation.tiles.get((tileNumber+4)+(gridSizeWidth*1)).getPosition().y), 0, 0, 64, 64, 1, 1, 90, false);
			}
		}
	}
}
