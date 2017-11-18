package cityBuilder.objects.attributes;

import cityBuilder.objects.Tile;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Grass
{
	private Tile tile;
	private TextureRegion SquareTileRegionGrass;

	public Grass( Tile tile, TextureAtlas atlas )
	{
		this.tile = tile;
		SquareTileRegionGrass = atlas.findRegion("grass");
	}

	public void draw( Batch batch )
	{
		batch.draw( SquareTileRegionGrass, -32 + tile.getPosition().x , -32 + tile.getPosition().y, 32, 32, 64, 64, 1, 1, -90, false);
	}
}
