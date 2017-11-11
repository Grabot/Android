package cityBuilder.objects.attributes;

import cityBuilder.objects.Tile;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Water
{
	private Tile tile;
	private int tilePosition;
	private TextureRegion SquareTileRegionWater;

	public Water( Tile tile, int tilePosition, TextureAtlas atlas  )
	{
		this.tile = tile;
		this.tilePosition = tilePosition;
		SquareTileRegionWater = atlas.findRegion("water");
	}

	public void draw( Batch batch )
	{
		batch.draw( SquareTileRegionWater, -32 + tile.getPosition().x , -32 + tile.getPosition().y, 32, 32, 64, 64, 1, 1, -90, false);
	}
}