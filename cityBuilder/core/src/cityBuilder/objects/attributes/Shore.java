package cityBuilder.objects.attributes;

import cityBuilder.objects.Tile;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Shore 
{
	private Tile tile;
	private int tilePosition;
	private TextureRegion SquareTileRegionShoreEdge;
	private TextureRegion SquareTileRegionShoreEdgeSmall;
	private TextureRegion SquareTileRegionShoreFull;
	
	public Shore( Tile tile, int tilePosition, TextureAtlas atlas )
	{
		this.tile = tile;
		this.tilePosition = tilePosition;
		SquareTileRegionShoreEdge = atlas.findRegion("edgeToWaterEdge");
		SquareTileRegionShoreEdgeSmall = atlas.findRegion("edgeToWaterEdgeSmall");
		SquareTileRegionShoreFull = atlas.findRegion("edgeToWaterFull");
	}
	
	public void draw( Batch batch )
	{
		if( tilePosition == 23 )
		{
			batch.draw( SquareTileRegionShoreEdge, -32 + tile.getPosition().x , -32 + tile.getPosition().y, 32, 32, 64, 64, 1, 1, -90, false);
		}
		else if( tilePosition == 26 )
		{
			batch.draw( SquareTileRegionShoreEdge, -32 + tile.getPosition().x , -32 + tile.getPosition().y, 32, 32, 64, 64, 1, 1, 0, false);
		}
		else if( tilePosition == 25 )
		{
			batch.draw( SquareTileRegionShoreEdge, -32 + tile.getPosition().x , -32 + tile.getPosition().y, 32, 32, 64, 64, 1, 1, 90, false);
		}
		else if( tilePosition == 24 )
		{
			batch.draw( SquareTileRegionShoreEdge, -32 + tile.getPosition().x , -32 + tile.getPosition().y, 32, 32, 64, 64, 1, 1, 180, false);
		}
		else if( tilePosition == 28 )
		{
			batch.draw( SquareTileRegionShoreEdgeSmall, -32 + tile.getPosition().x , -32 + tile.getPosition().y, 32, 32, 64, 64, 1, 1, 0, false);
		}
		else if( tilePosition == 27 )
		{
			batch.draw( SquareTileRegionShoreEdgeSmall, -32 + tile.getPosition().x , -32 + tile.getPosition().y, 32, 32, 64, 64, 1, 1, 90, false);
		}
		else if( tilePosition == 30 )
		{
			batch.draw( SquareTileRegionShoreEdgeSmall, -32 + tile.getPosition().x , -32 + tile.getPosition().y, 32, 32, 64, 64, 1, 1, 180, false);
		}
		else if( tilePosition == 29 )
		{
			batch.draw( SquareTileRegionShoreEdgeSmall, -32 + tile.getPosition().x , -32 + tile.getPosition().y, 32, 32, 64, 64, 1, 1, -90, false);
		}
		else if( tilePosition == 34 )
		{
			batch.draw( SquareTileRegionShoreFull, -32 + tile.getPosition().x , -32 + tile.getPosition().y, 32, 32, 64, 64, 1, 1, 0, false);
		}
		else if( tilePosition == 33 )
		{
			batch.draw( SquareTileRegionShoreFull, -32 + tile.getPosition().x , -32 + tile.getPosition().y, 32, 32, 64, 64, 1, 1, 90, false);
		}
		else if( tilePosition == 32 )
		{
			batch.draw( SquareTileRegionShoreFull, -32 + tile.getPosition().x , -32 + tile.getPosition().y, 32, 32, 64, 64, 1, 1, 180, false);
		}
		else if( tilePosition == 31 )
		{
			batch.draw( SquareTileRegionShoreFull, -32 + tile.getPosition().x , -32 + tile.getPosition().y, 32, 32, 64, 64, 1, 1, -90, false);
		}
	}
}
