package cityBuilder.gameScreen.buildings;


import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.ArrayList;

import cityBuilder.load.Building;
import cityBuilder.objects.Tile;

public class Road implements Building {

    private TextureRegion SquareTileRegionRoad;
    private float x;
    private float y;
    private int rotation;

    public Road(float x, float y, int rotation, Tile[] otherTiles, TextureAtlas atlas) {
        this.x = x;
        this.y = y;
        this.rotation = rotation;
        if (otherTiles[0].getOccupied() == 6 ) {
            SquareTileRegionRoad = atlas.findRegion("roadSingle");
        } else {
            SquareTileRegionRoad = atlas.findRegion("roadNo");
        }
    }

    @Override
    public void render(Batch batch) {
        batch.draw( SquareTileRegionRoad, -32 + x , -32 + y, 32, 32, 64, 64, 1, 1, -(90*rotation), false);
    }

    @Override
    public void update() {

    }

    @Override
    public void buildBuilding(ArrayList<Tile> tiles, int selectedTile, int rotation) {

    }
}
