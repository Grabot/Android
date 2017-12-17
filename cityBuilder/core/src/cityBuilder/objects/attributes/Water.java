package cityBuilder.objects.attributes;

import cityBuilder.objects.Tile;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Water
{
	private Tile tile;
	private TextureRegion SquareTileRegionWater;

	public Water( Tile tile, TextureAtlas atlas  )
	{
		this.tile = tile;
		SquareTileRegionWater = atlas.findRegion("water");
	}

	public void draw( Batch batch )
	{
		batch.draw( SquareTileRegionWater, -32 + tile.getPosition().x , -32 + tile.getPosition().y, 32, 32, 64, 64, 1, 1, -90, false);
	}
}