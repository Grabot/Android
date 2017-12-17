package cityBuilder.gameScreen.buildings;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.ArrayList;

import cityBuilder.load.Building;
import cityBuilder.load.Data;
import cityBuilder.objects.Tile;

public class Warehouse extends Data implements Building {

    Tile[] warehouseTiles;
    private int rotation = 0;

    private TextureRegion buildingRegionDark;
    private TextureRegion buildingRegionLight;

    public Warehouse(int rotation, TextureAtlas atlas)
    {
        warehouseTiles = new Tile[9];
        this.rotation = rotation;

        buildingRegionDark = atlas.findRegion("cubeDark");
        buildingRegionLight = atlas.findRegion("cubeLight");
    }

    @Override
    public void render(Batch bitch, int buildingPosition, float x, float y) {
        // Very ugly and easy way to solve this issue.
        if (buildingPosition == 0 && rotation == 0) {
            bitch.draw(buildingRegionDark, -32 + x, -32 + y, 32, 32, 64, 64, 1, 1, -(90 * rotation), false);
        } else if(buildingPosition == 1 && rotation == 0) {
            bitch.draw(buildingRegionDark, -32 + x, -32 + y, 32, 32, 64, 64, 1, 1, -(90 * rotation), false);
        } else if(buildingPosition == 2 && rotation == 0) {
            bitch.draw(buildingRegionLight, -32 + x, -32 + y, 32, 32, 64, 64, 1, 1, -(90 * rotation), false);
        } else if(buildingPosition == 3 && rotation == 0) {
            bitch.draw(buildingRegionDark, -32 + x, -32 + y, 32, 32, 64, 64, 1, 1, -(90 * rotation), false);
        } else if(buildingPosition == 4 && rotation == 0) {
            bitch.draw(buildingRegionDark, -32 + x, -32 + y, 32, 32, 64, 64, 1, 1, -(90 * rotation), false);
        } else if(buildingPosition == 5 && rotation == 0) {
            bitch.draw(buildingRegionDark, -32 + x, -32 + y, 32, 32, 64, 64, 1, 1, -(90 * rotation), false);
        } else if(buildingPosition == 6 && rotation == 0) {
            bitch.draw(buildingRegionDark, -32 + x, -32 + y, 32, 32, 64, 64, 1, 1, -(90 * rotation), false);
        } else if(buildingPosition == 7 && rotation == 0) {
            bitch.draw(buildingRegionDark, -32 + x, -32 + y, 32, 32, 64, 64, 1, 1, -(90 * rotation), false);
        } else if(buildingPosition == 8 && rotation == 0) {
            bitch.draw(buildingRegionDark, -32 + x, -32 + y, 32, 32, 64, 64, 1, 1, -(90 * rotation), false);
        } else if (buildingPosition == 0 && rotation == 1) {
            bitch.draw(buildingRegionDark, -32 + x, -32 + y, 32, 32, 64, 64, 1, 1, -(90 * rotation), false);
        } else if(buildingPosition == 1 && rotation == 1) {
            bitch.draw(buildingRegionDark, -32 + x, -32 + y, 32, 32, 64, 64, 1, 1, -(90 * rotation), false);
        } else if(buildingPosition == 2 && rotation == 1) {
            bitch.draw(buildingRegionDark, -32 + x, -32 + y, 32, 32, 64, 64, 1, 1, -(90 * rotation), false);
        } else if(buildingPosition == 3 && rotation == 1) {
            bitch.draw(buildingRegionDark, -32 + x, -32 + y, 32, 32, 64, 64, 1, 1, -(90 * rotation), false);
        } else if(buildingPosition == 4 && rotation == 1) {
            bitch.draw(buildingRegionDark, -32 + x, -32 + y, 32, 32, 64, 64, 1, 1, -(90 * rotation), false);
        } else if(buildingPosition == 5 && rotation == 1) {
            bitch.draw(buildingRegionDark, -32 + x, -32 + y, 32, 32, 64, 64, 1, 1, -(90 * rotation), false);
        } else if(buildingPosition == 6 && rotation == 1) {
            bitch.draw(buildingRegionDark, -32 + x, -32 + y, 32, 32, 64, 64, 1, 1, -(90 * rotation), false);
        } else if(buildingPosition == 7 && rotation == 1) {
            bitch.draw(buildingRegionDark, -32 + x, -32 + y, 32, 32, 64, 64, 1, 1, -(90 * rotation), false);
        } else if(buildingPosition == 8 && rotation == 1) {
            bitch.draw(buildingRegionLight, -32 + x, -32 + y, 32, 32, 64, 64, 1, 1, -(90 * rotation), false);
        } else if (buildingPosition == 0 && rotation == 2) {
            bitch.draw(buildingRegionDark, -32 + x, -32 + y, 32, 32, 64, 64, 1, 1, -(90 * rotation), false);
        } else if(buildingPosition == 1 && rotation == 2) {
            bitch.draw(buildingRegionDark, -32 + x, -32 + y, 32, 32, 64, 64, 1, 1, -(90 * rotation), false);
        } else if(buildingPosition == 2 && rotation == 2) {
            bitch.draw(buildingRegionDark, -32 + x, -32 + y, 32, 32, 64, 64, 1, 1, -(90 * rotation), false);
        } else if(buildingPosition == 3 && rotation == 2) {
            bitch.draw(buildingRegionDark, -32 + x, -32 + y, 32, 32, 64, 64, 1, 1, -(90 * rotation), false);
        } else if(buildingPosition == 4 && rotation == 2) {
            bitch.draw(buildingRegionDark, -32 + x, -32 + y, 32, 32, 64, 64, 1, 1, -(90 * rotation), false);
        } else if(buildingPosition == 5 && rotation == 2) {
            bitch.draw(buildingRegionDark, -32 + x, -32 + y, 32, 32, 64, 64, 1, 1, -(90 * rotation), false);
        } else if(buildingPosition == 6 && rotation == 2) {
            bitch.draw(buildingRegionLight, -32 + x, -32 + y, 32, 32, 64, 64, 1, 1, -(90 * rotation), false);
        } else if(buildingPosition == 7 && rotation == 2) {
            bitch.draw(buildingRegionDark, -32 + x, -32 + y, 32, 32, 64, 64, 1, 1, -(90 * rotation), false);
        } else if(buildingPosition == 8 && rotation == 2) {
            bitch.draw(buildingRegionDark, -32 + x, -32 + y, 32, 32, 64, 64, 1, 1, -(90 * rotation), false);
        } else if (buildingPosition == 0 && rotation == 3) {
            bitch.draw(buildingRegionDark, -32 + x, -32 + y, 32, 32, 64, 64, 1, 1, -(90 * rotation), false);
        } else if(buildingPosition == 1 && rotation == 3) {
            bitch.draw(buildingRegionDark, -32 + x, -32 + y, 32, 32, 64, 64, 1, 1, -(90 * rotation), false);
        } else if(buildingPosition == 2 && rotation == 3) {
            bitch.draw(buildingRegionDark, -32 + x, -32 + y, 32, 32, 64, 64, 1, 1, -(90 * rotation), false);
        } else if(buildingPosition == 3 && rotation == 3) {
            bitch.draw(buildingRegionDark, -32 + x, -32 + y, 32, 32, 64, 64, 1, 1, -(90 * rotation), false);
        } else if(buildingPosition == 4 && rotation == 3) {
            bitch.draw(buildingRegionLight, -32 + x, -32 + y, 32, 32, 64, 64, 1, 1, -(90 * rotation), false);
        } else if(buildingPosition == 5 && rotation == 3) {
            bitch.draw(buildingRegionDark, -32 + x, -32 + y, 32, 32, 64, 64, 1, 1, -(90 * rotation), false);
        } else if(buildingPosition == 6 && rotation == 3) {
            bitch.draw(buildingRegionDark, -32 + x, -32 + y, 32, 32, 64, 64, 1, 1, -(90 * rotation), false);
        } else if(buildingPosition == 7 && rotation == 3) {
            bitch.draw(buildingRegionDark, -32 + x, -32 + y, 32, 32, 64, 64, 1, 1, -(90 * rotation), false);
        } else if(buildingPosition == 8 && rotation == 3) {
            bitch.draw(buildingRegionDark, -32 + x, -32 + y, 32, 32, 64, 64, 1, 1, -(90 * rotation), false);
        }
    }

    public void update()
    {
    }

    @Override
    public void buildBuilding(ArrayList<ArrayList<Tile>> tiles, int x, int y, int rotation) {
        // Easy way to only set the correct tiles with the ratation
        if (rotation == 0) {
            tiles.get(x).get(y).setOccupiedWarehouse(0, this);
            tiles.get(x + 1).get(y).setOccupiedWarehouse(1, this);
            tiles.get(x + 1).get(y + 1).setOccupiedWarehouse(2, this);
            tiles.get(x).get(y + 1).setOccupiedWarehouse(3, this);
            tiles.get(x - 1).get(y + 1).setOccupiedWarehouse(4, this);
            tiles.get(x - 1).get(y).setOccupiedWarehouse(5, this);

            warehouseTiles[0] = tiles.get(x).get(y);
            warehouseTiles[1] = tiles.get(x + 1).get(y);
            warehouseTiles[2] = tiles.get(x + 1).get(y + 1);
            warehouseTiles[3] = tiles.get(x).get(y + 1);
            warehouseTiles[4] = tiles.get(x - 1).get(y + 1);
            warehouseTiles[5] = tiles.get(x - 1).get(y);
        } else if (rotation == 1) {
            tiles.get(x).get(y).setOccupiedWarehouse(0, this);
            tiles.get(x + 1).get(y).setOccupiedWarehouse(1, this);
            tiles.get(x + 1).get(y + 1).setOccupiedWarehouse(2, this);
            tiles.get(x).get(y + 1).setOccupiedWarehouse(3, this);
            tiles.get(x).get(y - 1).setOccupiedWarehouse(7, this);
            tiles.get(x + 1).get(y - 1).setOccupiedWarehouse(8, this);

            warehouseTiles[0] = tiles.get(x).get(y);
            warehouseTiles[1] = tiles.get(x + 1).get(y);
            warehouseTiles[2] = tiles.get(x + 1).get(y + 1);
            warehouseTiles[3] = tiles.get(x).get(y + 1);
            warehouseTiles[4] = tiles.get(x).get(y - 1);
            warehouseTiles[5] = tiles.get(x + 1).get(y - 1);
        } else if (rotation == 2) {
            tiles.get(x).get(y).setOccupiedWarehouse(0, this);
            tiles.get(x + 1).get(y).setOccupiedWarehouse(1, this);
            tiles.get(x - 1).get(y).setOccupiedWarehouse(5, this);
            tiles.get(x - 1).get(y - 1).setOccupiedWarehouse(6, this);
            tiles.get(x).get(y - 1).setOccupiedWarehouse(7, this);
            tiles.get(x + 1).get(y - 1).setOccupiedWarehouse(8, this);

            warehouseTiles[0] = tiles.get(x).get(y);
            warehouseTiles[1] = tiles.get(x + 1).get(y);
            warehouseTiles[2] = tiles.get(x - 1).get(y);
            warehouseTiles[3] = tiles.get(x - 1).get(y -1);
            warehouseTiles[4] = tiles.get(x).get(y - 1);
            warehouseTiles[5] = tiles.get(x + 1).get(y - 1);
        } else if (rotation == 3) {
            tiles.get(x).get(y).setOccupiedWarehouse(0, this);
            tiles.get(x).get(y + 1).setOccupiedWarehouse(3, this);
            tiles.get(x - 1).get(y + 1).setOccupiedWarehouse(4, this);
            tiles.get(x - 1).get(y).setOccupiedWarehouse(5, this);
            tiles.get(x - 1).get(y - 1).setOccupiedWarehouse(6, this);
            tiles.get(x).get(y - 1).setOccupiedWarehouse(7, this);

            warehouseTiles[0] = tiles.get(x).get(y);
            warehouseTiles[1] = tiles.get(x).get(y + 1);
            warehouseTiles[2] = tiles.get(x - 1).get(y + 1);
            warehouseTiles[3] = tiles.get(x - 1).get(y);
            warehouseTiles[4] = tiles.get(x - 1).get(y - 1);
            warehouseTiles[5] = tiles.get(x).get(y - 1);
        }
    }

    public Tile[] getWarehouseTiles() {
        return warehouseTiles;
    }
}
