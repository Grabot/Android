package cityBuilder.objects.attributes;

import cityBuilder.objects.Tile;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class FarmTex
{
	private Tile tile;
	private int position = 0;
	private TextureRegion SquareTileRegionFarmBottomLeft;
	private TextureRegion SquareTileRegionFarmBottomRight;
	private TextureRegion SquareTileRegionFarmTopLeft;
	private TextureRegion SquareTileRegionFarmTopRight;
	
	public FarmTex( Tile tile, int position, TextureAtlas atlas )
	{
		this.tile = tile;
		this.position = position;
		SquareTileRegionFarmBottomLeft = atlas.findRegion("farmbuilding1"); 
		SquareTileRegionFarmTopLeft = atlas.findRegion("farmbuilding2"); 
		SquareTileRegionFarmTopRight = atlas.findRegion("farmbuilding3"); 
		SquareTileRegionFarmBottomRight = atlas.findRegion("farmbuilding4"); 
	}
	
	public void draw( Batch batch )
	{
		if( position == 0 )
		{
			//bottom left
			batch.draw( SquareTileRegionFarmBottomLeft, -32 + tile.getPosition().x , -32 + tile.getPosition().y, 32, 32, 64, 64, 1, 1, -90, false);
		}
		else if( position == 1 )
		{
			//top left	
			batch.draw( SquareTileRegionFarmTopLeft, -32 + tile.getPosition().x , -32 + tile.getPosition().y, 32, 32, 64, 64, 1, 1, -90, false);
		}
		else if( position == 2 )
		{
			//top right	
			batch.draw( SquareTileRegionFarmTopRight, -32 + tile.getPosition().x , -32 + tile.getPosition().y, 32, 32, 64, 64, 1, 1, -90, false);
		}
		else if( position == 3 )
		{
			//bottom right	
			batch.draw( SquareTileRegionFarmBottomRight, -32 + tile.getPosition().x , -32 + tile.getPosition().y, 32, 32, 64, 64, 1, 1, -90, false);
		}
	}
}