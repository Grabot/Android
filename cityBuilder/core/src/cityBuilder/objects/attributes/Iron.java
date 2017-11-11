package cityBuilder.objects.attributes;

import cityBuilder.objects.Tile;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Iron
{
	private Tile tile;
	private TextureRegion SquareTileRegionIron;
	public Iron( Tile tile, TextureAtlas atlas )
	{
		this.tile = tile;
		SquareTileRegionIron = atlas.findRegion("ironOreSmall");
	}

	public void draw( Batch batch )
	{
		batch.draw( SquareTileRegionIron, -32 + tile.getPosition().x , -32 + tile.getPosition().y, 32, 32, 64, 64, 1, 1, -90, false);
	}
}