package CityBuilder.objects.attributes;

import CityBuilder.objects.Tile;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Town 
{
	private Tile tile;
	
	private Texture SquareTileTown;
	private TextureRegion SquareTileRegionTown;

	private Texture SquareTileGrass;
	private TextureRegion SquareTileRegionGrass;
	
	public Town( Tile tile )
	{
		this.tile = tile;
		SquareTileTown = new Texture( Gdx.files.internal( "images/HouseBrown.png" ));
		SquareTileRegionTown = new TextureRegion( SquareTileTown, 0, 0, SquareTileTown.getWidth(), SquareTileTown.getHeight() );		
		SquareTileGrass = new Texture( Gdx.files.internal( "images/Grass.png" ));
		SquareTileRegionGrass = new TextureRegion( SquareTileGrass, 0, 0, SquareTileGrass.getWidth(), SquareTileGrass.getHeight() );		
	
	}
	
	public void draw( Batch batch )
	{
		batch.draw( SquareTileRegionGrass, -SquareTileGrass.getWidth()/2 + tile.getPosition().x , -SquareTileGrass.getHeight()/2 + tile.getPosition().y, SquareTileGrass.getWidth()/2, SquareTileGrass.getHeight()/2, SquareTileGrass.getWidth(), SquareTileGrass.getHeight(), 1, 1, -90, false);
		
		batch.draw( SquareTileRegionTown, -SquareTileTown.getWidth()/2 + tile.getPosition().x , -SquareTileTown.getHeight()/2 + tile.getPosition().y, SquareTileTown.getWidth()/2, SquareTileTown.getHeight()/2, SquareTileTown.getWidth(), SquareTileTown.getHeight(), 1, 1, -90, false);
	}
}
