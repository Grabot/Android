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
    public void buildBuilding(Tile[][] tiles, int x, int y, int rotation) {
        // Easy way to only set the correct tiles with the ratation
        if (rotation == 0) {
            tiles[x][y].setOccupiedWarehouse(0, this);
            tiles[x + 1][y].setOccupiedWarehouse(1, this);
            tiles[x + 1][y + 1].setOccupiedWarehouse(2, this);
            tiles[x][y + 1].setOccupiedWarehouse(3, this);
            tiles[x - 1][y + 1].setOccupiedWarehouse(4, this);
            tiles[x - 1][y].setOccupiedWarehouse(5, this);

            warehouseTiles[0] = tiles[x][y];
            warehouseTiles[1] = tiles[x + 1][y];
            warehouseTiles[2] = tiles[x + 1][y + 1];
            warehouseTiles[3] = tiles[x][y + 1];
            warehouseTiles[4] = tiles[x - 1][y + 1];
            warehouseTiles[5] = tiles[x - 1][y];
        } else if (rotation == 1) {
            tiles[x][y].setOccupiedWarehouse(0, this);
            tiles[x + 1][y].setOccupiedWarehouse(1, this);
            tiles[x + 1][y + 1].setOccupiedWarehouse(2, this);
            tiles[x][y + 1].setOccupiedWarehouse(3, this);
            tiles[x][y - 1].setOccupiedWarehouse(7, this);
            tiles[x + 1][y - 1].setOccupiedWarehouse(8, this);

            warehouseTiles[0] = tiles[x][y];
            warehouseTiles[1] = tiles[x + 1][y];
            warehouseTiles[2] = tiles[x + 1][y + 1];
            warehouseTiles[3] = tiles[x][y + 1];
            warehouseTiles[4] = tiles[x][y - 1];
            warehouseTiles[5] = tiles[x + 1][y - 1];
        } else if (rotation == 2) {
            tiles[x][y].setOccupiedWarehouse(0, this);
            tiles[x + 1][y].setOccupiedWarehouse(1, this);
            tiles[x - 1][y].setOccupiedWarehouse(5, this);
            tiles[x - 1][y - 1].setOccupiedWarehouse(6, this);
            tiles[x][y - 1].setOccupiedWarehouse(7, this);
            tiles[x + 1][y - 1].setOccupiedWarehouse(8, this);

            warehouseTiles[0] = tiles[x][y];
            warehouseTiles[1] = tiles[x + 1][y];
            warehouseTiles[2] = tiles[x - 1][y];
            warehouseTiles[3] = tiles[x - 1][y -1];
            warehouseTiles[4] = tiles[x][y - 1];
            warehouseTiles[5] = tiles[x + 1][y - 1];
        } else if (rotation == 3) {
            tiles[x][y].setOccupiedWarehouse(0, this);
            tiles[x][y + 1].setOccupiedWarehouse(3, this);
            tiles[x - 1][y + 1].setOccupiedWarehouse(4, this);
            tiles[x - 1][y].setOccupiedWarehouse(5, this);
            tiles[x - 1][y - 1].setOccupiedWarehouse(6, this);
            tiles[x][y - 1].setOccupiedWarehouse(7, this);

            warehouseTiles[0] = tiles[x][y];
            warehouseTiles[1] = tiles[x][y + 1];
            warehouseTiles[2] = tiles[x - 1][y + 1];
            warehouseTiles[3] = tiles[x - 1][y];
            warehouseTiles[4] = tiles[x - 1][y - 1];
            warehouseTiles[5] = tiles[x][y - 1];
        }

        OutlineAvailability(tiles, x, y, 16);
    }

    private boolean[][] defineCircle(boolean[][] grid, int centerX, int centerY, int radius) {
        for (int x = 0; x < grid.length; x++ ) {
            for (int y = 0; y < grid[x].length; y++ ) {
                int a = x - centerX;
                int b = y - centerY;

                if (a*a+b*b <= radius*radius+1) {
                    grid[x][y] = true;
                }
            }
        }
        return grid;
    }

    private void OutlineAvailability(Tile[][] tiles, int tileX, int tileY, int radius ) {
        boolean[][] grid = new boolean[gridSizeWidth][gridSizeHeight];
        for (int x = 0; x < grid.length; x++ ) {
            for (int y = 0; y < grid[x].length; y++) {
                grid[x][y] = false;
            }
        }

        defineCircle(grid, radius*2-1, radius*2-1, radius);
        defineCircle(grid, radius*2+1, radius*2-1, radius);
        defineCircle(grid, radius*2-1, radius*2+1, radius);
        defineCircle(grid, radius*2+1, radius*2+1, radius);

        for (int x = 0; x < grid.length; x++ ) {
            for (int y = 0; y < grid[x].length; y++) {
                if (grid[x][y] ) {
                    if ((((x+(tileX-(radius*2))) >= 0) && ((y+(tileY-(radius*2))) >= 0)) && (((x+(tileX-(radius*2))) < gridSizeWidth) && ((y+(tileY-(radius*2))) < gridSizeHeight))) {
                        tiles[x + (tileX - (radius * 2))][y + (tileY - (radius * 2))].setRegionOwned(true);
                    }
                }
            }
        }
    }

    public Tile[] getWarehouseTiles() {
        return warehouseTiles;
    }
}
