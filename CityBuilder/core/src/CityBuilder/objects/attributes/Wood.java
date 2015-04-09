package CityBuilder.objects.attributes;

import CityBuilder.objects.Tile;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Wood 
{
	private Tile tile;
	
	private Texture SquareTileWood;
	private TextureRegion SquareTileRegionWood;
	
	private Texture SquareTileGrass;
	private TextureRegion SquareTileRegionGrass;

	public Wood( Tile tile )
	{
		this.tile = tile;
		SquareTileWood = new Texture( Gdx.files.internal( "images/pinetree.png" ));
		SquareTileRegionWood = new TextureRegion( SquareTileWood, 0, 0, SquareTileWood.getWidth(), SquareTileWood.getHeight() );		
		SquareTileGrass = new Texture( Gdx.files.internal( "images/Grass.png" ));
		SquareTileRegionGrass = new TextureRegion( SquareTileGrass, 0, 0, SquareTileGrass.getWidth(), SquareTileGrass.getHeight() );		
	}
	
	public void draw( Batch batch )
	{	
		batch.draw( SquareTileRegionGrass, -SquareTileGrass.getWidth()/2 + tile.getPosition().x , -SquareTileGrass.getHeight()/2 + tile.getPosition().y, SquareTileGrass.getWidth()/2, SquareTileGrass.getHeight()/2, SquareTileGrass.getWidth(), SquareTileGrass.getHeight(), 1, 1, -90, false);
	
		batch.draw( SquareTileRegionWood, -SquareTileWood.getWidth()/2 + tile.getPosition().x , -SquareTileWood.getHeight()/2 + tile.getPosition().y, SquareTileWood.getWidth()/2, SquareTileWood.getHeight()/2, SquareTileWood.getWidth(), SquareTileWood.getHeight(), 1, 1, -90, false);
	}
}