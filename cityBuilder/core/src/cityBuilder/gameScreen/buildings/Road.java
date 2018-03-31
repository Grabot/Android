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
    private TextureRegion[] roads;
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
        roads = new TextureRegion[16];
        roads[0] = atlas.findRegion("roadNo");
        roads[1] = atlas.findRegion("roadSingle1");
        roads[2] = atlas.findRegion("roadSingle2");
        roads[3] = atlas.findRegion("roadSingle3");
        roads[4] = atlas.findRegion("roadSingle4");
        roads[5] = atlas.findRegion("roadDouble1");
        roads[6] = atlas.findRegion("roadDouble2");
        roads[7] = atlas.findRegion("roadDouble3");
        roads[8] = atlas.findRegion("roadDouble4");
        roads[9] = atlas.findRegion("roadDoubleForward1");
        roads[10] = atlas.findRegion("roadDoubleForward2");
        roads[11] = atlas.findRegion("roadTriple1");
        roads[12] = atlas.findRegion("roadTriple2");
        roads[13] = atlas.findRegion("roadTriple3");
        roads[14] = atlas.findRegion("roadTriple4");
        roads[15] = atlas.findRegion("roadQuadruppel");
        adjacentRoads = new Tile[4];
        adjacent = new boolean[4];
    }

    @Override
    public void render(Batch batch, int buildingPosition, float x, float y, int globalRotation) {
        if (!adjacent[0] && !adjacent[1] && !adjacent[2] && !adjacent[3]) {
            batch.draw(roads[0], x - 45, y - 23, 32, 32, 90, 48, 1, 1, 0, false);
        } else if (adjacent[0] && !adjacent[1] && !adjacent[2] && !adjacent[3]) {
            // if there is only 1 road tile to the right below of this one.
            batch.draw(roads[1], x - 45, y - 23, 32, 32, 90, 48, 1, 1, 0, false);
        } else if (!adjacent[0] && adjacent[1] && !adjacent[2] && !adjacent[3]) {
            batch.draw(roads[2], x - 45, y - 23, 32, 32, 90, 48, 1, 1, 0, false);
        } else if (!adjacent[0] && !adjacent[1] && adjacent[2] && !adjacent[3]) {
            batch.draw(roads[3], x - 45, y - 23, 32, 32, 90, 48, 1, 1, 0, false);
        } else if (!adjacent[0] && !adjacent[1] && !adjacent[2] && adjacent[3]) {
            batch.draw(roads[4], x - 45, y - 23, 32, 32, 90, 48, 1, 1, 0, false);
        } else if (adjacent[0] && adjacent[1] && !adjacent[2] && !adjacent[3]) {
            batch.draw(roads[5], x - 45, y - 23, 32, 32, 90, 48, 1, 1, 0, false);
        } else if (!adjacent[0] && adjacent[1] && adjacent[2] && !adjacent[3]) {
            batch.draw(roads[6], x - 45, y - 23, 32, 32, 90, 48, 1, 1, 0, false);
        } else if (!adjacent[0] && !adjacent[1] && adjacent[2] && adjacent[3]) {
            batch.draw(roads[7], x - 45, y - 23, 32, 32, 90, 48, 1, 1, 0, false);
        } else if (adjacent[0] && !adjacent[1] && !adjacent[2] && adjacent[3]) {
            batch.draw(roads[8], x - 45, y - 23, 32, 32, 90, 48, 1, 1, 0, false);
        } else if (adjacent[0] && !adjacent[1] && adjacent[2] && !adjacent[3]) {
            batch.draw(roads[9], x - 45, y - 23, 32, 32, 90, 48, 1, 1, 0, false);
        } else if (!adjacent[0] && adjacent[1] && !adjacent[2] && adjacent[3]) {
            batch.draw(roads[10], x - 45, y - 23, 32, 32, 90, 48, 1, 1, 0, false);
        } else if (adjacent[0] && adjacent[1] && adjacent[2] && !adjacent[3]) {
            batch.draw(roads[11], x - 45, y - 23, 32, 32, 90, 48, 1, 1, 0, false);
        } else if (!adjacent[0] && adjacent[1] && adjacent[2] && adjacent[3]) {
            batch.draw(roads[12], x - 45, y - 23, 32, 32, 90, 48, 1, 1, 0, false);
        } else if (adjacent[0] && !adjacent[1] && adjacent[2] && adjacent[3]) {
            batch.draw(roads[13], x - 45, y - 23, 32, 32, 90, 48, 1, 1, 0, false);
        } else if (adjacent[0] && adjacent[1] && !adjacent[2] && adjacent[3]) {
            batch.draw(roads[14], x - 45, y - 23, 32, 32, 90, 48, 1, 1, 0, false);
        } else if (adjacent[0] && adjacent[1] && adjacent[2] && adjacent[3]) {
            batch.draw(roads[15], x - 45, y - 23, 32, 32, 90, 48, 1, 1, 0, false);
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
