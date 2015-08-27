package CityBuilder.objects.attributes;

import CityBuilder.objects.Tile;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Shore 
{
	private Tile tile;
	private int tilePosition;
	
	public Shore( Tile tile, int tilePosition )
	{
		this.tile = tile;
		this.tilePosition = tilePosition;
	}
	
	public void draw( Batch batch, TextureAtlas atlas )
	{
		TextureRegion SquareTileRegionShoreEdge;
		if( tilePosition == 23 )
		{
			SquareTileRegionShoreEdge = atlas.findRegion("edgeToWaterEdge");
			batch.draw( SquareTileRegionShoreEdge, -32 + tile.getPosition().x , -32 + tile.getPosition().y, 32, 32, 64, 64, 1, 1, -90, false);
		}
		else if( tilePosition == 26 )
		{
			SquareTileRegionShoreEdge = atlas.findRegion("edgeToWaterEdge");
			batch.draw( SquareTileRegionShoreEdge, -32 + tile.getPosition().x , -32 + tile.getPosition().y, 32, 32, 64, 64, 1, 1, 0, false);
		}
		else if( tilePosition == 25 )
		{
			SquareTileRegionShoreEdge = atlas.findRegion("edgeToWaterEdge");
			batch.draw( SquareTileRegionShoreEdge, -32 + tile.getPosition().x , -32 + tile.getPosition().y, 32, 32, 64, 64, 1, 1, 90, false);
		}
		else if( tilePosition == 24 )
		{
			SquareTileRegionShoreEdge = atlas.findRegion("edgeToWaterEdge");
			batch.draw( SquareTileRegionShoreEdge, -32 + tile.getPosition().x , -32 + tile.getPosition().y, 32, 32, 64, 64, 1, 1, 180, false);
		}
		else if( tilePosition == 28 )
		{
			SquareTileRegionShoreEdge = atlas.findRegion("edgeToWaterEdgeSmall");
			batch.draw( SquareTileRegionShoreEdge, -32 + tile.getPosition().x , -32 + tile.getPosition().y, 32, 32, 64, 64, 1, 1, 0, false);
		}
		else if( tilePosition == 27 )
		{
			SquareTileRegionShoreEdge = atlas.findRegion("edgeToWaterEdgeSmall");
			batch.draw( SquareTileRegionShoreEdge, -32 + tile.getPosition().x , -32 + tile.getPosition().y, 32, 32, 64, 64, 1, 1, 90, false);
		}
		else if( tilePosition == 30 )
		{
			SquareTileRegionShoreEdge = atlas.findRegion("edgeToWaterEdgeSmall");
			batch.draw( SquareTileRegionShoreEdge, -32 + tile.getPosition().x , -32 + tile.getPosition().y, 32, 32, 64, 64, 1, 1, 180, false);
		}
		else if( tilePosition == 29 )
		{
			SquareTileRegionShoreEdge = atlas.findRegion("edgeToWaterEdgeSmall");
			batch.draw( SquareTileRegionShoreEdge, -32 + tile.getPosition().x , -32 + tile.getPosition().y, 32, 32, 64, 64, 1, 1, -90, false);
		}
		else if( tilePosition == 34 )
		{
			SquareTileRegionShoreEdge = atlas.findRegion("edgeToWaterFull");
			batch.draw( SquareTileRegionShoreEdge, -32 + tile.getPosition().x , -32 + tile.getPosition().y, 32, 32, 64, 64, 1, 1, 0, false);
		}
		else if( tilePosition == 33 )
		{
			SquareTileRegionShoreEdge = atlas.findRegion("edgeToWaterFull");
			batch.draw( SquareTileRegionShoreEdge, -32 + tile.getPosition().x , -32 + tile.getPosition().y, 32, 32, 64, 64, 1, 1, 90, false);
		}
		else if( tilePosition == 32 )
		{
			SquareTileRegionShoreEdge = atlas.findRegion("edgeToWaterFull");
			batch.draw( SquareTileRegionShoreEdge, -32 + tile.getPosition().x , -32 + tile.getPosition().y, 32, 32, 64, 64, 1, 1, 180, false);
		}
		else if( tilePosition == 31 )
		{
			SquareTileRegionShoreEdge = atlas.findRegion("edgeToWaterFull");
			batch.draw( SquareTileRegionShoreEdge, -32 + tile.getPosition().x , -32 + tile.getPosition().y, 32, 32, 64, 64, 1, 1, -90, false);
		}
	}
}
