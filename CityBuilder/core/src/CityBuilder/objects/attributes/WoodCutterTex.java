package CityBuilder.objects.attributes;

import CityBuilder.objects.Tile;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class WoodCutterTex
{
	private Tile tile;
	private int position = 0;
	private TextureRegion SquareTileRegionWoodCutterBottomLeft;
	private TextureRegion SquareTileRegionWoodCutterBottomRight;
	private TextureRegion SquareTileRegionWoodCutterTopLeft;
	private TextureRegion SquareTileRegionWoodCutterTopRight;
	
	public WoodCutterTex( Tile tile, int position, TextureAtlas atlas )
	{
		this.tile = tile;
		this.position = position;
		SquareTileRegionWoodCutterBottomLeft = atlas.findRegion("WoodCutterBuilding1"); 
		SquareTileRegionWoodCutterTopLeft = atlas.findRegion("WoodCutterBuilding2"); 
		SquareTileRegionWoodCutterTopRight = atlas.findRegion("WoodCutterBuilding3"); 
		SquareTileRegionWoodCutterBottomRight = atlas.findRegion("WoodCutterBuilding4"); 
	}
	
	public void draw( Batch batch )
	{
		if( position == 0 )
		{
			//bottom left
			batch.draw( SquareTileRegionWoodCutterBottomLeft, -32 + tile.getPosition().x , -32 + tile.getPosition().y, 32, 32, 64, 64, 1, 1, -90, false);
		}
		else if( position == 1 )
		{
			//top left	
			batch.draw( SquareTileRegionWoodCutterTopLeft, -32 + tile.getPosition().x , -32 + tile.getPosition().y, 32, 32, 64, 64, 1, 1, -90, false);
		}
		else if( position == 2 )
		{
			//top right	
			batch.draw( SquareTileRegionWoodCutterTopRight, -32 + tile.getPosition().x , -32 + tile.getPosition().y, 32, 32, 64, 64, 1, 1, -90, false);
		}
		else if( position == 3 )
		{
			//bottom right	
			batch.draw( SquareTileRegionWoodCutterBottomRight, -32 + tile.getPosition().x , -32 + tile.getPosition().y, 32, 32, 64, 64, 1, 1, -90, false);
		}
	}
}