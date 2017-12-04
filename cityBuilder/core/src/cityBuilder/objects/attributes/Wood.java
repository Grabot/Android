package cityBuilder.objects.attributes;

import cityBuilder.objects.Tile;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Wood {
	private Tile tile;
	private int position;
	private int rotation;
	//private TextureRegion SquareTileRegionGrass;
	private TextureRegion SquareTileRegionTree;

	public Wood( Tile tile, int position, int rotation, TextureAtlas atlas ) {
		this.tile = tile;
		this.position = position;
		this.rotation = rotation;
		//SquareTileRegionGrass = atlas.findRegion("Grass");
		SquareTileRegionTree = atlas.findRegion("pinetree");
	}

	public void draw( Batch batch ) {
		//batch.draw( SquareTileRegionGrass, -32 + tile.getPosition().x , -32 + tile.getPosition().y, 32, 32, 64, 64, 1, 1, -90, false);
		batch.draw( SquareTileRegionTree, -32 + tile.getPosition().x , -32 + tile.getPosition().y, 32, 32, 64, 64, 1, 1, -(90 * rotation), false);
	}
}