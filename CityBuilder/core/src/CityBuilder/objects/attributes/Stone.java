package CityBuilder.objects.attributes;

import CityBuilder.objects.Tile;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Stone 
{
	private Tile tile;
	
	private Texture SquareTileStone;
	private TextureRegion SquareTileRegionStone;
	
	private Texture SquareTileGrass;
	private TextureRegion SquareTileRegionGrass;

	public Stone( Tile tile )
	{
		this.tile = tile;
		SquareTileStone = new Texture( Gdx.files.internal( "images/Rock3.png" ));
		SquareTileRegionStone = new TextureRegion( SquareTileStone, 0, 0, SquareTileStone.getWidth(), SquareTileStone.getHeight() );		
		SquareTileGrass = new Texture( Gdx.files.internal( "images/Grass.png" ));
		SquareTileRegionGrass = new TextureRegion( SquareTileGrass, 0, 0, SquareTileGrass.getWidth(), SquareTileGrass.getHeight() );		
	
	}
	
	public void draw( Batch batch, TextureAtlas atlas )
	{
		TextureRegion SquareTileRegionGrass = atlas.findRegion("Grass");
		batch.draw( SquareTileRegionGrass, -32 + tile.getPosition().x , -32 + tile.getPosition().y, 32, 32, 64, 64, 1, 1, -90, false);
		
		TextureRegion SquareTileRegionStone = atlas.findRegion("goldOreSmall");
		batch.draw( SquareTileRegionStone, -32 + tile.getPosition().x , -32 + tile.getPosition().y, 32, 32, 64, 64, 1, 1, -90, false);
	}
}