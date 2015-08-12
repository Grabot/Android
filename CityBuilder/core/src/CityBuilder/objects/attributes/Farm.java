package CityBuilder.objects.attributes;

import CityBuilder.objects.Tile;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Farm 
{
	private Tile tile;
	
	public Farm( Tile tile )
	{
		this.tile = tile;
	}
	
	public void draw( Batch batch, TextureAtlas atlas, int corner )
	{
		TextureRegion SquareTileRegionFarm = atlas.findRegion("farmbuilding1"); 
		if( corner == 0 )
		{
			//bottom left
			SquareTileRegionFarm = atlas.findRegion("farmbuilding1");
		}
		else if( corner == 1 )
		{
			//top left
			SquareTileRegionFarm = atlas.findRegion("farmbuilding2");
		}
		else if( corner == 2 )
		{
			//top right
			SquareTileRegionFarm = atlas.findRegion("farmbuilding3");
		}
		else if( corner == 3 )
		{
			//bottom right
			SquareTileRegionFarm = atlas.findRegion("farmbuilding4");
		}
		batch.draw( SquareTileRegionFarm, -32 + tile.getPosition().x , -32 + tile.getPosition().y, 32, 32, 64, 64, 1, 1, -90, false);
	}
}