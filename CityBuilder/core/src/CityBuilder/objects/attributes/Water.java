package CityBuilder.objects.attributes;

import CityBuilder.objects.Tile;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Water 
{
	private Tile tile;
	
	public Water( Tile tile )
	{
		this.tile = tile;
	}
	
	public void draw( Batch batch, TextureAtlas atlas )
	{
		TextureRegion SquareTileRegionWater = atlas.findRegion("water");
		batch.draw( SquareTileRegionWater, -32 + tile.getPosition().x , -32 + tile.getPosition().y, 32, 32, 64, 64, 1, 1, -90, false);
	}
}