package cityBuilder.gameScreen.buildings;


import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.ArrayList;

import cityBuilder.load.Building;
import cityBuilder.objects.Tile;

public class Road implements Building {

    private Tile[] adjacentRoads;
    private boolean[] adjacent;
    private Tile roadTile;
    private TextureRegion roadNo;
    private TextureRegion roadSingle;
    private TextureRegion roadDouble;
    private TextureRegion roadTriple;
    private TextureRegion roadDoubleForward;
    private TextureRegion roadQuadruppel;
    private int rotation;

    public Road(int rotation, TextureAtlas atlas) {
        this.rotation = rotation;
        roadNo = atlas.findRegion("roadNo");
        roadSingle = atlas.findRegion("roadSingle");
        roadDouble = atlas.findRegion("roadDouble");
        roadTriple = atlas.findRegion("roadTriple");
        roadDoubleForward = atlas.findRegion("roadDoubleForward");
        roadQuadruppel = atlas.findRegion("roadQuadruppel");
        adjacentRoads = new Tile[4];
        adjacent = new boolean[4];
    }

    @Override
    public void render(Batch batch, int buildingPosition, float x, float y, int globalRotation) {
        if (adjacent[0] && adjacent[1] && adjacent[2] && adjacent[3]) {
            batch.draw( roadQuadruppel, -32 + x , -32 + y, 32, 32, 64, 64, 1, 1, 0, false);
        } else if (!adjacent[0] && adjacent[1] && adjacent[2] && adjacent[3]) {
            batch.draw( roadTriple, -32 + x , -32 + y, 32, 32, 64, 64, 1, 1, 270, false);
        } else if (adjacent[0] && !adjacent[1] && adjacent[2] && adjacent[3]) {
            batch.draw( roadTriple, -32 + x , -32 + y, 32, 32, 64, 64, 1, 1, 0, false);
        } else if (adjacent[0] && adjacent[1] && !adjacent[2] && adjacent[3]) {
            batch.draw( roadTriple, -32 + x , -32 + y, 32, 32, 64, 64, 1, 1,90, false);
        } else if (adjacent[0] && adjacent[1] && adjacent[2] && !adjacent[3]) {
            batch.draw( roadTriple, -32 + x , -32 + y, 32, 32, 64, 64, 1, 1, 180, false);
        } else if (!adjacent[0] && !adjacent[1] && adjacent[2] && adjacent[3]) {
            batch.draw( roadDouble, -32 + x , -32 + y, 32, 32, 64, 64, 1, 1, 270, false);
        } else if (adjacent[0] && !adjacent[1] && !adjacent[2] && adjacent[3]) {
            batch.draw( roadDouble, -32 + x , -32 + y, 32, 32, 64, 64, 1, 1, 0, false);
        } else if (adjacent[0] && adjacent[1] && !adjacent[2] && !adjacent[3]) {
            batch.draw( roadDouble, -32 + x , -32 + y, 32, 32, 64, 64, 1, 1, 90, false);
        } else if (!adjacent[0] && adjacent[1] && adjacent[2] && !adjacent[3]) {
            batch.draw( roadDouble, -32 + x , -32 + y, 32, 32, 64, 64, 1, 1, 180, false);
        } else if (!adjacent[0] && adjacent[1] && !adjacent[2] && adjacent[3]) {
            batch.draw( roadDoubleForward, -32 + x , -32 + y, 32, 32, 64, 64, 1, 1, 90, false);
        } else if (adjacent[0] && !adjacent[1] && adjacent[2] && !adjacent[3]) {
            batch.draw( roadDoubleForward, -32 + x , -32 + y, 32, 32, 64, 64, 1, 1, 0, false);
        } else if (adjacent[0] && !adjacent[1] && !adjacent[2] && !adjacent[3]) {
            batch.draw( roadSingle, -32 + x , -32 + y, 32, 32, 64, 64, 1, 1, 0, false);
        } else if (!adjacent[0] && adjacent[1] && !adjacent[2] && !adjacent[3]) {
            batch.draw( roadSingle, -32 + x , -32 + y, 32, 32, 64, 64, 1, 1, 90, false);
        } else if (!adjacent[0] && !adjacent[1] && adjacent[2] && !adjacent[3]) {
            batch.draw( roadSingle, -32 + x , -32 + y, 32, 32, 64, 64, 1, 1, 180, false);
        } else if (!adjacent[0] && !adjacent[1] && !adjacent[2] && adjacent[3]) {
            batch.draw( roadSingle, -32 + x , -32 + y, 32, 32, 64, 64, 1, 1, 270, false);
        } else if (!adjacent[0] && !adjacent[1] && !adjacent[2] && !adjacent[3]) {
            batch.draw(roadNo, -32 + x, -32 + y, 32, 32, 64, 64, 1, 1, 0, false);
        }
    }

    @Override
    public void update() {

    }

    @Override
    public void buildBuilding(Tile[][] tiles, int x, int y, int rotation) {
        adjacentRoads[0] = tiles[x + 1][y];
        adjacentRoads[1] = tiles[x][y + 1];
        adjacentRoads[2] = tiles[x - 1][y];
        adjacentRoads[3] = tiles[x][y - 1];

        roadTile = tiles[x][y];
        roadTile.setOccupiedRoad(0, this);
    }

    public Tile[] getAdjacentRoads() {
        return adjacentRoads;
    }

    public Tile getRoadTile() {
        return roadTile;
    }

    public void setAdjacent(int index, boolean occupied) {
        adjacent[index] = occupied;
    }
}
