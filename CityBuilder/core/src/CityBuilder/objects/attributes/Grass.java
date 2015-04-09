package CityBuilder.objects.attributes;

import CityBuilder.objects.Tile;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Grass 
{
	private Tile tile;
	
	private Texture SquareTileGrass;
	private TextureRegion SquareTileRegionGrass;

	public Grass( Tile tile )
	{
		this.tile = tile;
		SquareTileGrass = new Texture( Gdx.files.internal( "images/Grass.png" ));
		SquareTileRegionGrass = new TextureRegion( SquareTileGrass, 0, 0, SquareTileGrass.getWidth(), SquareTileGrass.getHeight() );		
	}
	
	public void draw( Batch batch )
	{
		batch.draw( SquareTileRegionGrass, -SquareTileGrass.getWidth()/2 + tile.getPosition().x , -SquareTileGrass.getHeight()/2 + tile.getPosition().y, SquareTileGrass.getWidth()/2, SquareTileGrass.getHeight()/2, SquareTileGrass.getWidth(), SquareTileGrass.getHeight(), 1, 1, -90, false);
	}
}
