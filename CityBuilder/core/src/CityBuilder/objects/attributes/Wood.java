package CityBuilder.objects.attributes;

import CityBuilder.objects.Tile;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
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
	
	public void draw( Batch batch, TextureAtlas atlas )
	{	
		TextureRegion SquareTileRegionGrass = atlas.findRegion("Grass");
		batch.draw( SquareTileRegionGrass, -32 + tile.getPosition().x , -32 + tile.getPosition().y, 32, 32, 64, 64, 1, 1, -90, false);
	
		TextureRegion SquareTileRegionTree = atlas.findRegion("pinetree");
		batch.draw( SquareTileRegionTree, -32 + tile.getPosition().x , -32 + tile.getPosition().y, 32, 32, 64, 64, 1, 1, -90, false);
	}
}