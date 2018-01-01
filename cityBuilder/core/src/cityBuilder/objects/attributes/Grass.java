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
		SquareTileRegionGrass = atlas.findRegion("grassIso");
	}

	public void draw( Batch batch )
	{
		batch.draw( SquareTileRegionGrass, -45 + tile.getPosition().x , -23 + tile.getPosition().y, 32, 32, 90, 46, 1, 1, 0, false);
	}
}
