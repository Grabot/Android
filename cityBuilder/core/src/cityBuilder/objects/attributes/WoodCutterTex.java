package cityBuilder.objects.attributes;

import cityBuilder.objects.Tile;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class WoodCutterTex {
	private Tile tile;
	private int position;
	private int rotation;
	private TextureRegion SquareTileRegionWoodCutterBottomLeft;
	private TextureRegion SquareTileRegionWoodCutterBottomRight;
	private TextureRegion SquareTileRegionWoodCutterTopLeft;
	private TextureRegion SquareTileRegionWoodCutterTopRight;

	public WoodCutterTex( Tile tile, int position, int rotation, TextureAtlas atlas ) {
		this.tile = tile;
		this.position = position;
		this.rotation = rotation;
		SquareTileRegionWoodCutterBottomLeft = atlas.findRegion("cubeDark");
		SquareTileRegionWoodCutterTopLeft = atlas.findRegion("cubeDark");
		SquareTileRegionWoodCutterTopRight = atlas.findRegion("cubeDark");
		SquareTileRegionWoodCutterBottomRight = atlas.findRegion("cubeDark");
	}

	public void draw( Batch batch ) {
		if( position == 0 ) {
			//bottom left
			batch.draw( SquareTileRegionWoodCutterBottomLeft, -32 + tile.getPosition().x , -32 + tile.getPosition().y, 32, 32, 64, 64, 1, 1, -(90 * rotation), false);
		} else if( position == 1 ) {
			//top left	
			batch.draw( SquareTileRegionWoodCutterTopLeft, -32 + tile.getPosition().x , -32 + tile.getPosition().y, 32, 32, 64, 64, 1, 1, -(90 * rotation), false);
		} else if( position == 2 ) {
			//top right	
			batch.draw( SquareTileRegionWoodCutterTopRight, -32 + tile.getPosition().x , -32 + tile.getPosition().y, 32, 32, 64, 64, 1, 1, -(90 * rotation), false);
		} else if( position == 3 ) {
			//bottom right	
			batch.draw( SquareTileRegionWoodCutterBottomRight, -32 + tile.getPosition().x , -32 + tile.getPosition().y, 32, 32, 64, 64, 1, 1, -(90 * rotation), false);
		}
	}
}