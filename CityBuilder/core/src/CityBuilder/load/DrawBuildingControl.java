package CityBuilder.load;

import CityBuilder.gameScreen.Simulation;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class DrawBuildingControl extends Data
{
	private TextureRegion SquareTileRegionFault;
	private TextureRegion SquareTileRegionAllowed;
	private TextureRegion SquareFarmBottomLeft;
	private TextureRegion SquareFarmBottomRight;
	private TextureRegion SquareFarmTopLeft;
	private TextureRegion SquareFarmTopRight;
	private TextureRegion SquareWoodCutterBottomLeft;
	private TextureRegion SquareWoodCutterBottomRight;
	private TextureRegion SquareWoodCutterTopLeft;
	private TextureRegion SquareWoodCutterTopRight;
	private TextureRegion SquareOutlineFull;
	private TextureRegion SquareOutlineEdge;
	
	public DrawBuildingControl(TextureAtlas atlas)
	{
		SquareTileRegionFault = atlas.findRegion("SquareRedSmall");
		SquareTileRegionAllowed = atlas.findRegion("SquareGreenSmall");
		
		SquareFarmBottomLeft = atlas.findRegion("farmbuilding2");
		SquareFarmBottomRight = atlas.findRegion("farmbuilding1");
		SquareFarmTopLeft = atlas.findRegion("farmbuilding3");
		SquareFarmTopRight = atlas.findRegion("farmbuilding4");
		
		SquareWoodCutterBottomLeft = atlas.findRegion("WoodCutterBuilding2");
		SquareWoodCutterBottomRight = atlas.findRegion("WoodCutterBuilding1");
		SquareWoodCutterTopLeft = atlas.findRegion("WoodCutterBuilding3");
		SquareWoodCutterTopRight = atlas.findRegion("WoodCutterBuilding4");
		
		SquareOutlineFull = atlas.findRegion("outlineFull2");
		SquareOutlineEdge = atlas.findRegion("outlineEdge2");
	}
	
	public void drawFarmBuild(Simulation simulation, Batch batch, int tileNumber)
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
		
		String type1 = simulation.tiles.get(tileNumber).getType().toString();
		String type2 = simulation.tiles.get(tileNumber+1).getType().toString();
		String type3 = simulation.tiles.get((tileNumber-gridSizeWidth)).getType().toString();
		String type4 = simulation.tiles.get((tileNumber-gridSizeWidth)+1).getType().toString();
		
		batch.draw( SquareFarmBottomLeft, (-32 + simulation.tiles.get(tileNumber).getPosition().x), (-32 + simulation.tiles.get(tileNumber).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
		if((type1 == "water") || (type1 == "shore"))
		{
			batch.draw( SquareTileRegionFault, (-32 + simulation.tiles.get(tileNumber).getPosition().x), (-32 + simulation.tiles.get(tileNumber).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
		}
		else
		{
			batch.draw( SquareTileRegionAllowed, (-32 + simulation.tiles.get(tileNumber).getPosition().x), (-32 + simulation.tiles.get(tileNumber).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
		}
		
		batch.draw( SquareFarmBottomRight, (-32 + simulation.tiles.get(tileNumber+1).getPosition().x), (-32 + simulation.tiles.get(tileNumber+1).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
		if((type2 == "water") || (type2 == "shore"))
		{
			batch.draw( SquareTileRegionFault, (-32 + simulation.tiles.get(tileNumber+1).getPosition().x), (32 + simulation.tiles.get(tileNumber+1).getPosition().y), 0, 0, 64, 64, 1, 1, -90, false);
		}
		else
		{
			batch.draw( SquareTileRegionAllowed, (-32 + simulation.tiles.get(tileNumber+1).getPosition().x), (32 + simulation.tiles.get(tileNumber+1).getPosition().y), 0, 0, 64, 64, 1, 1, -90, false);
		}
		
		batch.draw( SquareFarmTopLeft, (-32 + simulation.tiles.get((tileNumber-gridSizeWidth)).getPosition().x), (-32 + simulation.tiles.get((tileNumber-gridSizeWidth)).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
		if((type3 == "water") || (type3 == "shore"))
		{
			batch.draw( SquareTileRegionFault, (-32 + simulation.tiles.get((tileNumber-gridSizeWidth)).getPosition().x), (32 + simulation.tiles.get((tileNumber-gridSizeWidth)).getPosition().y), 0, 0, 64, 64, 1, 1, -90, false);
		}
		else
		{
			batch.draw( SquareTileRegionAllowed, (-32 + simulation.tiles.get((tileNumber-gridSizeWidth)).getPosition().x), (32 + simulation.tiles.get((tileNumber-gridSizeWidth)).getPosition().y), 0, 0, 64, 64, 1, 1, -90, false);
		}
		
		batch.draw( SquareFarmTopRight, (-32 + simulation.tiles.get((tileNumber-gridSizeWidth)+1).getPosition().x), (-32 + simulation.tiles.get((tileNumber-gridSizeWidth)+1).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
		if((type4 == "water") || (type4 == "shore"))
		{
			batch.draw( SquareTileRegionFault, (-32 + simulation.tiles.get((tileNumber-gridSizeWidth)+1).getPosition().x), (32 + simulation.tiles.get((tileNumber-gridSizeWidth)+1).getPosition().y), 0, 0, 64, 64, 1, 1, -90, false);
		}
		else
		{
			batch.draw( SquareTileRegionAllowed, (-32 + simulation.tiles.get((tileNumber-gridSizeWidth)+1).getPosition().x), (32 + simulation.tiles.get((tileNumber-gridSizeWidth)+1).getPosition().y), 0, 0, 64, 64, 1, 1, -90, false);
		}
	}
	
	public void drawWoodCutterBuild( Simulation simulation, Batch batch, int tileNumber )
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
		
		String type1 = simulation.tiles.get(tileNumber).getType().toString();
		String type2 = simulation.tiles.get(tileNumber+1).getType().toString();
		String type3 = simulation.tiles.get((tileNumber-gridSizeWidth)).getType().toString();
		String type4 = simulation.tiles.get((tileNumber-gridSizeWidth)+1).getType().toString();
		
		batch.draw( SquareWoodCutterBottomLeft, (-32 + simulation.tiles.get(tileNumber).getPosition().x), (-32 + simulation.tiles.get(tileNumber).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
		if((type1 == "water") || (type1 == "shore"))
		{
			batch.draw( SquareTileRegionFault, (-32 + simulation.tiles.get(tileNumber).getPosition().x), (-32 + simulation.tiles.get(tileNumber).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
		}
		else
		{
			batch.draw( SquareTileRegionAllowed, (-32 + simulation.tiles.get(tileNumber).getPosition().x), (-32 + simulation.tiles.get(tileNumber).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
		}
		
		batch.draw( SquareWoodCutterBottomRight, (-32 + simulation.tiles.get(tileNumber+1).getPosition().x), (-32 + simulation.tiles.get(tileNumber+1).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
		if((type2 == "water") || (type2 == "shore"))
		{
			batch.draw( SquareTileRegionFault, (-32 + simulation.tiles.get(tileNumber+1).getPosition().x), (32 + simulation.tiles.get(tileNumber+1).getPosition().y), 0, 0, 64, 64, 1, 1, -90, false);
		}
		else
		{
			batch.draw( SquareTileRegionAllowed, (-32 + simulation.tiles.get(tileNumber+1).getPosition().x), (32 + simulation.tiles.get(tileNumber+1).getPosition().y), 0, 0, 64, 64, 1, 1, -90, false);
		}
		
		batch.draw( SquareWoodCutterTopLeft, (-32 + simulation.tiles.get((tileNumber-gridSizeWidth)).getPosition().x), (-32 + simulation.tiles.get((tileNumber-gridSizeWidth)).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
		if((type3 == "water") || (type3 == "shore"))
		{
			batch.draw( SquareTileRegionFault, (-32 + simulation.tiles.get((tileNumber-gridSizeWidth)).getPosition().x), (32 + simulation.tiles.get((tileNumber-gridSizeWidth)).getPosition().y), 0, 0, 64, 64, 1, 1, -90, false);
		}
		else
		{
			batch.draw( SquareTileRegionAllowed, (-32 + simulation.tiles.get((tileNumber-gridSizeWidth)).getPosition().x), (32 + simulation.tiles.get((tileNumber-gridSizeWidth)).getPosition().y), 0, 0, 64, 64, 1, 1, -90, false);
		}
		
		batch.draw( SquareWoodCutterTopRight, (-32 + simulation.tiles.get((tileNumber-gridSizeWidth)+1).getPosition().x), (-32 + simulation.tiles.get((tileNumber-gridSizeWidth)+1).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
		if((type4 == "water") || (type4 == "shore"))
		{
			batch.draw( SquareTileRegionFault, (-32 + simulation.tiles.get((tileNumber-gridSizeWidth)+1).getPosition().x), (32 + simulation.tiles.get((tileNumber-gridSizeWidth)+1).getPosition().y), 0, 0, 64, 64, 1, 1, -90, false);
		}
		else
		{
			batch.draw( SquareTileRegionAllowed, (-32 + simulation.tiles.get((tileNumber-gridSizeWidth)+1).getPosition().x), (32 + simulation.tiles.get((tileNumber-gridSizeWidth)+1).getPosition().y), 0, 0, 64, 64, 1, 1, -90, false);
		}
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
