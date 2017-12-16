package cityBuilder.gameScreen.buildings;


import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.ArrayList;

import cityBuilder.load.Building;
import cityBuilder.objects.Tile;

public class Road implements Building {

    private TextureRegion SquareTileRegionRoad;
    private int rotation;

    public Road(int rotation, TextureAtlas atlas) {
        this.rotation = rotation;
    }

    @Override
    public void render(Batch batch, int buildingPosition, float x, float y) {
        batch.draw( SquareTileRegionRoad, -32 + x , -32 + y, 32, 32, 64, 64, 1, 1, -(90*rotation), false);
    }

    @Override
    public void update() {

    }

    @Override
    public void buildBuilding(ArrayList<ArrayList<Tile>> tiles, int x, int y, int rotation) {
        // not usefull for roads.
    }
}
