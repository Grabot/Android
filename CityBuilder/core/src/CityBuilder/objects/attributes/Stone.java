package CityBuilder.objects.attributes;

import CityBuilder.objects.Tile;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
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
	
	public void draw( Batch batch )
	{
		batch.draw( SquareTileRegionGrass, -SquareTileGrass.getWidth()/2 + tile.getPosition().x , -SquareTileGrass.getHeight()/2 + tile.getPosition().y, SquareTileGrass.getWidth()/2, SquareTileGrass.getHeight()/2, SquareTileGrass.getWidth(), SquareTileGrass.getHeight(), 1, 1, -90, false);
		
		batch.draw( SquareTileRegionStone, -SquareTileStone.getWidth()/2 + tile.getPosition().x , -SquareTileStone.getHeight()/2 + tile.getPosition().y, SquareTileStone.getWidth()/2, SquareTileStone.getHeight()/2, SquareTileStone.getWidth(), SquareTileStone.getHeight(), 1, 1, -90, false);
	}
}