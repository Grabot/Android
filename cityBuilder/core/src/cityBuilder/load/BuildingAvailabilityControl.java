package cityBuilder.load;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

import cityBuilder.gameScreen.Simulation;
import cityBuilder.objects.Tile;

/**
 * Created by User on 11/5/2017.
 */

public class BuildingAvailabilityControl extends Data
{
    private TextureRegion SquareTileRegionFault;
    private TextureRegion SquareTileRegionAllowed;

    private TextureRegion SquareOutlineAvailable;

    private TextureRegion SquareOutlineFull;
    private TextureRegion SquareOutlineEdge;

    private String[][][] buildingAvailability;
    private TextureRegion[][] buildingRegion;

    public BuildingAvailabilityControl(TextureAtlas atlas) {

        SquareTileRegionFault = atlas.findRegion("SquareRedSmall");
        SquareTileRegionAllowed = atlas.findRegion("SquareGreenSmall");
        SquareOutlineFull = atlas.findRegion("outlineFull2");
        SquareOutlineEdge = atlas.findRegion("outlineEdge2");
        SquareOutlineAvailable = atlas.findRegion("SquareBlueSmall");

        buildingAvailability = new String[5][25][5];
        for( int i = 0; i < buildingAvailability.length; i++ )
        {
            for( int j = 0; j < buildingAvailability[i].length; j++ ) {
                for( int k = 0; k < buildingAvailability[i][j].length; k++ ) {
                    buildingAvailability[i][j][k] = "";
                }
            }
        }
        // 0 index is the farmhouse
        buildingAvailability[0][0][0] = "water";
        buildingAvailability[0][0][1] = "shore";
        buildingAvailability[0][1][0] = "water";
        buildingAvailability[0][1][1] = "shore";
        buildingAvailability[0][2][0] = "water";
        buildingAvailability[0][2][1] = "shore";
        buildingAvailability[0][3][0] = "water";
        buildingAvailability[0][3][1] = "shore";

        // 1 index is the warehouse
        buildingAvailability[1][0][0] = "water";
        buildingAvailability[1][1][0] = "water";
        buildingAvailability[1][2][0] = "water";
        buildingAvailability[1][2][1] = "shore";
        buildingAvailability[1][3][0] = "water";
        buildingAvailability[1][3][1] = "shore";
        buildingAvailability[1][4][0] = "water";
        buildingAvailability[1][4][1] = "shore";
        buildingAvailability[1][5][0] = "water";
        buildingAvailability[1][6][0] = "shore";
        buildingAvailability[1][6][1] = "grass";
        buildingAvailability[1][7][0] = "shore";
        buildingAvailability[1][7][1] = "grass";
        buildingAvailability[1][8][0] = "shore";
        buildingAvailability[1][8][1] = "grass";

        // 2 index is the woodcutter
        buildingAvailability[2][0][0] = "water";
        buildingAvailability[2][0][1] = "shore";
        buildingAvailability[2][1][0] = "water";
        buildingAvailability[2][1][1] = "shore";
        buildingAvailability[2][2][0] = "water";
        buildingAvailability[2][2][1] = "shore";
        buildingAvailability[2][3][0] = "water";
        buildingAvailability[2][3][1] = "shore";

        buildingRegion = new TextureRegion[5][10];
        // 0 index is the farmhouse
        buildingRegion[0][0] = atlas.findRegion("cubeLight");
        buildingRegion[0][1] = atlas.findRegion("cubeLight");
        buildingRegion[0][2] = atlas.findRegion("cubeLight");
        buildingRegion[0][3] = atlas.findRegion("cubeLight");

        // 1 index is the warehouse (graphics are placeholder anyway)
        buildingRegion[1][0] = atlas.findRegion("cubeLight");
        buildingRegion[1][1] = atlas.findRegion("cubeLight");
        buildingRegion[1][2] = atlas.findRegion("cubeLight");
        buildingRegion[1][3] = atlas.findRegion("cubeLight");
        buildingRegion[1][4] = atlas.findRegion("cubeLight");
        buildingRegion[1][5] = atlas.findRegion("cubeLight");
        buildingRegion[1][6] = atlas.findRegion("cubeLight");
        buildingRegion[1][7] = atlas.findRegion("cubeLight");
        buildingRegion[1][8] = atlas.findRegion("cubeLight");

        // 2 index is the woodcutter
        buildingRegion[2][0] = atlas.findRegion("cubeDark");
        buildingRegion[2][1] = atlas.findRegion("cubeDark");
        buildingRegion[2][2] = atlas.findRegion("cubeDark");
        buildingRegion[2][3] = atlas.findRegion("cubeDark");
    }

    public void buildingAvailability(Batch batch, Tile buildingTile, int building, int buildingPosition) {
        batch.draw( buildingRegion[building][buildingPosition], (-32 + buildingTile.getPosition().x), (-32 + buildingTile.getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);

        if(buildingTile.getType().toString() == buildingAvailability[building][buildingPosition][0]
                || buildingTile.getType().toString() == buildingAvailability[building][buildingPosition][1]
                || buildingTile.getType().toString() == buildingAvailability[building][buildingPosition][2]
                || buildingTile.getType().toString() == buildingAvailability[building][buildingPosition][3]
                || buildingTile.getType().toString() == buildingAvailability[building][buildingPosition][4]) {
            batch.draw( SquareTileRegionFault, (-32 + buildingTile.getPosition().x), (-32 + buildingTile.getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
        } else {
            batch.draw( SquareTileRegionAllowed, (-32 + buildingTile.getPosition().x), (-32 + buildingTile.getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
        }
    }

    public void buttonAvailability(TextButton BuildBuildingButton, Tile buildingTile, int building, int buildingPosition) {

        if(buildingTile.getType().toString() == buildingAvailability[building][buildingPosition][0]
                || buildingTile.getType().toString() == buildingAvailability[building][buildingPosition][1]
                || buildingTile.getType().toString() == buildingAvailability[building][buildingPosition][2]
                || buildingTile.getType().toString() == buildingAvailability[building][buildingPosition][3]
                || buildingTile.getType().toString() == buildingAvailability[building][buildingPosition][4]) {
            BuildBuildingButton.setVisible(false);
        }
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

    public void OutlineAvailability(Simulation simulation, Batch batch, int tileNumber, int building, int buildingPosition, int radius )
    {
        boolean[][] grid = new boolean[radius*2 + 8][radius*2 + 8];
        for (int x = 0; x < grid.length; x++ ) {
            for (int y = 0; y < grid[x].length; y++) {
                grid[x][y] = false;
            }
        }

        if (building == 1 && buildingPosition == 0) {
            defineCircle(grid, radius + 2, radius + 3, radius);
            defineCircle(grid, radius + 4, radius + 3, radius);
            defineCircle(grid, radius + 2, radius + 5, radius);
            defineCircle(grid, radius + 4, radius + 5, radius);
        } else if (building == 1 && buildingPosition == 1) {
            defineCircle(grid, radius + 1, radius + 3, radius);
            defineCircle(grid, radius + 3, radius + 3, radius);
            defineCircle(grid, radius + 1, radius + 5, radius);
            defineCircle(grid, radius + 3, radius + 5, radius);
        } else if (building == 1 && buildingPosition == 2) {
            defineCircle(grid, radius + 1, radius + 4, radius);
            defineCircle(grid, radius + 3, radius + 4, radius);
            defineCircle(grid, radius + 1, radius + 6, radius);
            defineCircle(grid, radius + 3, radius + 6, radius);
        } else if (building == 1 && buildingPosition == 3) {
            defineCircle(grid, radius + 2, radius + 4, radius);
            defineCircle(grid, radius + 4, radius + 4, radius);
            defineCircle(grid, radius + 2, radius + 6, radius);
            defineCircle(grid, radius + 4, radius + 6, radius);
        } else if (building == 1 && buildingPosition == 4) {
            defineCircle(grid, radius + 3, radius + 4, radius);
            defineCircle(grid, radius + 5, radius + 4, radius);
            defineCircle(grid, radius + 3, radius + 6, radius);
            defineCircle(grid, radius + 5, radius + 6, radius);
        } else if (building == 1 && buildingPosition == 5) {
            defineCircle(grid, radius + 3, radius + 3, radius);
            defineCircle(grid, radius + 5, radius + 3, radius);
            defineCircle(grid, radius + 3, radius + 5, radius);
            defineCircle(grid, radius + 5, radius + 5, radius);
        } else if (building == 1 && buildingPosition == 6) {
            defineCircle(grid, radius + 3, radius + 2, radius);
            defineCircle(grid, radius + 5, radius + 2, radius);
            defineCircle(grid, radius + 3, radius + 4, radius);
            defineCircle(grid, radius + 5, radius + 4, radius);
        } else if (building == 1 && buildingPosition == 7) {
            defineCircle(grid, radius + 2, radius + 2, radius);
            defineCircle(grid, radius + 4, radius + 2, radius);
            defineCircle(grid, radius + 2, radius + 4, radius);
            defineCircle(grid, radius + 4, radius + 4, radius);
        } else if (building == 1 && buildingPosition == 8) {
            defineCircle(grid, radius + 1, radius + 2, radius);
            defineCircle(grid, radius + 3, radius + 2, radius);
            defineCircle(grid, radius + 1, radius + 4, radius);
            defineCircle(grid, radius + 3, radius + 4, radius);
        }

        if (building == 2 && buildingPosition == 0) {
            defineCircle(grid, radius + 3, radius + 3, radius);
            defineCircle(grid, radius + 4, radius + 3, radius);
            defineCircle(grid, radius + 3, radius + 4, radius);
            defineCircle(grid, radius + 4, radius + 4, radius);
        } else if (building == 2 && buildingPosition == 1) {
            defineCircle(grid, radius + 3, radius + 5, radius);
            defineCircle(grid, radius + 4, radius + 5, radius);
            defineCircle(grid, radius + 3, radius + 4, radius);
            defineCircle(grid, radius + 4, radius + 4, radius);
        } else if (building == 2 && buildingPosition == 2) {
            defineCircle(grid, radius + 2, radius + 4, radius);
            defineCircle(grid, radius + 3, radius + 4, radius);
            defineCircle(grid, radius + 2, radius + 5, radius);
            defineCircle(grid, radius + 3, radius + 5, radius);
        } else if (building == 2 && buildingPosition == 3) {
            defineCircle(grid, radius + 2, radius + 3, radius);
            defineCircle(grid, radius + 3, radius + 3, radius);
            defineCircle(grid, radius + 2, radius + 4, radius);
            defineCircle(grid, radius + 3, radius + 4, radius);
        }

        for (int x = 0; x < grid.length; x++ ) {
            for (int y = 0; y < grid[x].length; y++) {
                if (grid[x][y] ) {
                    int tilePosNumber = tileNumber + x + (y * gridSizeHeight) - (radius + 3) - ((radius + 4) * gridSizeHeight);
                    if (tilePosNumber < 0) {
                        tilePosNumber = 0;
                    } else if (tilePosNumber >= 2500) {
                        tilePosNumber = 2499;
                    }
                    Tile tile = simulation.tiles.get(tilePosNumber);
                    batch.draw(SquareOutlineAvailable, (-32 + tile.getPosition().x), (-32 + tile.getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);

                }
            }
        }
    }
}
