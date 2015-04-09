package CityBuilder.objects.attributes;

import CityBuilder.objects.Tile;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Water 
{
	private Tile tile;
	
	private Texture SquareTileWater;
	private TextureRegion SquareTileRegionWater;

	public Water( Tile tile )
	{
		this.tile = tile;
		SquareTileWater = new Texture( Gdx.files.internal( "images/resources/water.png" ));
		SquareTileRegionWater = new TextureRegion( SquareTileWater, 0, 0, SquareTileWater.getWidth(), SquareTileWater.getHeight() );		
	}
	
	public void draw( Batch batch )
	{
		batch.draw( SquareTileRegionWater, -SquareTileWater.getWidth()/2 + tile.getPosition().x , -SquareTileWater.getHeight()/2 + tile.getPosition().y, SquareTileWater.getWidth()/2, SquareTileWater.getHeight()/2, SquareTileWater.getWidth(), SquareTileWater.getHeight(), 1, 1, -90, false);
	}
}