package CityBuilder.objects.attributes;

import CityBuilder.objects.Tile;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Iron 
{
	private Tile tile;
	
	private Texture SquareTileIron;
	private TextureRegion SquareTileRegionIron;

	public Iron( Tile tile )
	{
		this.tile = tile;
		SquareTileIron = new Texture( Gdx.files.internal( "images/resources/ironOreSmall.png" ));
		SquareTileRegionIron = new TextureRegion( SquareTileIron, 0, 0, SquareTileIron.getWidth(), SquareTileIron.getHeight() );		
	}
	
	public void draw( Batch batch )
	{
		batch.draw( SquareTileRegionIron, -SquareTileIron.getWidth()/2 + tile.getPosition().x , -SquareTileIron.getHeight()/2 + tile.getPosition().y, SquareTileIron.getWidth()/2, SquareTileIron.getHeight()/2, SquareTileIron.getWidth(), SquareTileIron.getHeight(), 1, 1, -90, false);
	}
}