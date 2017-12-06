package cityBuilder.objects.attributes;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import cityBuilder.objects.Tile;

/**
 * Created by User on 12/6/2017.
 */

public class RoadTex {

    private Tile tile;
    private int tilePosition;
    private TextureRegion SquareTileRegionRoad;

    private int rotation;

    public RoadTex( Tile tile, int tilePosition, int rotation, TextureAtlas atlas  ) {
        this.tile = tile;
        this.tilePosition = tilePosition;
        this.rotation = rotation;
        SquareTileRegionRoad = atlas.findRegion("roadNo");
    }

    public void draw( Batch batch ) {
        batch.draw( SquareTileRegionRoad, -32 + tile.getPosition().x , -32 + tile.getPosition().y, 32, 32, 64, 64, 1, 1, -(90*rotation), false);
    }
}
