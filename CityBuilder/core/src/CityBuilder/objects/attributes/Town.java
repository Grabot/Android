package CityBuilder.objects.attributes;

import CityBuilder.objects.Tile;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
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
	
	public void draw( Batch batch, TextureAtlas atlas )
	{
		TextureRegion SquareTileRegionGrass = atlas.findRegion("Grass");
		batch.draw( SquareTileRegionGrass, -32 + tile.getPosition().x , -32 + tile.getPosition().y, 32, 32, 64, 64, 1, 1, -90, false);
		
		TextureRegion SquareTileRegionTown = atlas.findRegion("HouseBrown");
		batch.draw( SquareTileRegionTown, -32 + tile.getPosition().x , -32 + tile.getPosition().y, 32, 32, 64, 64, 1, 1, -90, false);
	}
}
