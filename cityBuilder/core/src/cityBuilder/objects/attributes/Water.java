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
		SquareTileRegionWater = atlas.findRegion("waterIso");
	}

	public void draw( Batch batch )
	{
		batch.draw( SquareTileRegionWater, -45 + tile.getPosition().x , -24 + tile.getPosition().y, 32, 32, 90, 46, 1, 1, 0, false);
	}
}