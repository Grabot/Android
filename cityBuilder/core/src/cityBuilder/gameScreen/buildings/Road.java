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
    private int rotation;
    private int roadIndex;

    public Road(int rotation, TextureAtlas atlas) {
        this.rotation = rotation;
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
        roadIndex = 0;
    }

    @Override
    public void render(Batch batch, int buildingPosition, float x, float y, int globalRotation) {
        batch.draw(roads[roadIndex], x - 45, y - 23, 32, 32, 90, 48, 1, 1, 0, false);
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

    public void setRoadIndex(int globalRotation) {
        if (!adjacent[0] && !adjacent[1] && !adjacent[2] && !adjacent[3]) {
            roadIndex = 0;
        } else if (adjacent[0] && !adjacent[1] && !adjacent[2] && !adjacent[3]) {
            if (globalRotation == 0) {
                roadIndex = 1;
            } else if (globalRotation == 1) {
                roadIndex = 2;
            } else if (globalRotation == 2) {
                roadIndex = 3;
            } else {
                roadIndex = 4;
            }
        } else if (!adjacent[0] && adjacent[1] && !adjacent[2] && !adjacent[3]) {
            if (globalRotation == 0) {
                roadIndex = 2;
            } else if (globalRotation == 1) {
                roadIndex = 3;
            } else if (globalRotation == 2) {
                roadIndex = 4;
            } else {
                roadIndex = 1;
            }
        } else if (!adjacent[0] && !adjacent[1] && adjacent[2] && !adjacent[3]) {
            if (globalRotation == 0) {
                roadIndex = 3;
            } else if (globalRotation == 1) {
                roadIndex = 4;
            } else if (globalRotation == 2) {
                roadIndex = 1;
            } else {
                roadIndex = 2;
            }
        } else if (!adjacent[0] && !adjacent[1] && !adjacent[2] && adjacent[3]) {
            if (globalRotation == 0) {
                roadIndex = 4;
            } else if (globalRotation == 1) {
                roadIndex = 1;
            } else if (globalRotation == 2) {
                roadIndex = 2;
            } else {
                roadIndex = 3;
            }
        } else if (adjacent[0] && adjacent[1] && !adjacent[2] && !adjacent[3]) {
            if (globalRotation == 0) {
                roadIndex = 5;
            } else if (globalRotation == 1) {
                roadIndex = 6;
            } else if (globalRotation == 2) {
                roadIndex = 7;
            } else {
                roadIndex = 8;
            }
        } else if (!adjacent[0] && adjacent[1] && adjacent[2] && !adjacent[3]) {
            if (globalRotation == 0) {
                roadIndex = 6;
            } else if (globalRotation == 1) {
                roadIndex = 7;
            } else if (globalRotation == 2) {
                roadIndex = 8;
            } else {
                roadIndex = 5;
            }
        } else if (!adjacent[0] && !adjacent[1] && adjacent[2] && adjacent[3]) {
            if (globalRotation == 0) {
                roadIndex = 7;
            } else if (globalRotation == 1) {
                roadIndex = 8;
            } else if (globalRotation == 2) {
                roadIndex = 5;
            } else {
                roadIndex = 6;
            }
        } else if (adjacent[0] && !adjacent[1] && !adjacent[2] && adjacent[3]) {
            if (globalRotation == 0) {
                roadIndex = 8;
            } else if (globalRotation == 1) {
                roadIndex = 5;
            } else if (globalRotation == 2) {
                roadIndex = 6;
            } else {
                roadIndex = 7;
            }
        } else if (adjacent[0] && !adjacent[1] && adjacent[2] && !adjacent[3]) {
            if (globalRotation == 0 || globalRotation == 2) {
                roadIndex = 9;
            } else {
                roadIndex = 10;
            }
        } else if (!adjacent[0] && adjacent[1] && !adjacent[2] && adjacent[3]) {
            if (globalRotation == 0 || globalRotation == 2) {
                roadIndex = 10;
            } else {
                roadIndex = 9;
            }
        } else if (adjacent[0] && adjacent[1] && adjacent[2] && !adjacent[3]) {
            if (globalRotation == 0) {
                roadIndex = 11;
            } else if (globalRotation == 1) {
                roadIndex = 12;
            } else if (globalRotation == 2) {
                roadIndex = 13;
            } else {
                roadIndex = 14;
            }
        } else if (!adjacent[0] && adjacent[1] && adjacent[2] && adjacent[3]) {
            if (globalRotation == 0) {
                roadIndex = 12;
            } else if (globalRotation == 1) {
                roadIndex = 13;
            } else if (globalRotation == 2) {
                roadIndex = 14;
            } else {
                roadIndex = 11;
            }
        } else if (adjacent[0] && !adjacent[1] && adjacent[2] && adjacent[3]) {
            if (globalRotation == 0) {
                roadIndex = 13;
            } else if (globalRotation == 1) {
                roadIndex = 14;
            } else if (globalRotation == 2) {
                roadIndex = 11;
            } else {
                roadIndex = 12;
            }
        } else if (adjacent[0] && adjacent[1] && !adjacent[2] && adjacent[3]) {
            if (globalRotation == 0) {
                roadIndex = 14;
            } else if (globalRotation == 1) {
                roadIndex = 11;
            } else if (globalRotation == 2) {
                roadIndex = 12;
            } else {
                roadIndex = 13;
            }
        } else if (adjacent[0] && adjacent[1] && adjacent[2] && adjacent[3]) {
            roadIndex = 15;
        }
    }
}
