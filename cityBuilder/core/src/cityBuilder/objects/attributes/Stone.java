package cityBuilder.objects.attributes;

import cityBuilder.objects.Tile;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Stone 
{
	private Tile tile;
	private TextureRegion SquareTileRegionGrass;
	private TextureRegion SquareTileRegionStone;
	
	public Stone( Tile tile, TextureAtlas atlas)
	{
		this.tile = tile;
		SquareTileRegionGrass = atlas.findRegion("Grass");
		SquareTileRegionStone = atlas.findRegion("goldOreSmall");
	}
	
	public void draw( Batch batch )
	{
		batch.draw( SquareTileRegionGrass, -32 + tile.getPosition().x , -32 + tile.getPosition().y, 32, 32, 64, 64, 1, 1, -90, false);
		batch.draw( SquareTileRegionStone, -32 + tile.getPosition().x , -32 + tile.getPosition().y, 32, 32, 64, 64, 1, 1, -90, false);
	}
}