package cityBuilder.load;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

import java.io.BufferedReader;
import java.io.IOException;

import cityBuilder.gameScreen.Simulation;
import cityBuilder.objects.Tile;

/**
 * Created by User on 11/5/2017.
 */

public class BuildingAvailabilityControl extends Data
{
    private int rotation = 0;
    private int rotationX = -1;
    private int rotationY = -1;

    private TextureRegion SquareTileRegionFault;
    private TextureRegion SquareTileRegionAllowed;
    private TextureRegion SquareOutlineAvailable;

    private String[][][][] buildingAvailability;
    private TextureRegion[][][] buildingRegion;

    public BuildingAvailabilityControl(TextureAtlas atlas) {
        SquareTileRegionFault = atlas.findRegion("SquareRedSmall");
        SquareTileRegionAllowed = atlas.findRegion("SquareGreenSmall");
        SquareOutlineAvailable = atlas.findRegion("SquareBlueSmall");

        // Read the availability of the buildings from a file and store all the data in a multi dimensional array
        FileHandle buildingRestrictions = Gdx.files.internal("buildingData/buildingAvailability.csv");
        BufferedReader br = new BufferedReader(buildingRestrictions.reader());

        buildingAvailability = new String[5][25][5][4];
        String line = "";
        int index = 0;
        try {
            line = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        while( line != null ) {
            String[] buildings = line.split(",");
            try {
                line = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }

            for (int i = 0; i < buildings.length; i++ ) {
                String tileAvailability = buildings[i];
                String[] rotate = tileAvailability.split("#");
                for (int k = 0; k < rotate.length; k++ ) {
                    String[] singleTile = rotate[k].split("; ");
                    for ( int j = 0; j < singleTile.length; j++ ) {
                        buildingAvailability[i][index][j][k] = singleTile[j];
                    }
                }
            }
            index++;
        }

        // Read the texture data from a file, similar to the availability done above here.
        FileHandle buildingTextureRotate = Gdx.files.internal("buildingData/buildingTexture.csv");
        br = new BufferedReader(buildingTextureRotate.reader());

        buildingRegion = new TextureRegion[5][10][4];
        // Re-use previous made variables
        line = "";
        index = 0;
        try {
            line = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        while( line != null ) {
            String[] textures = line.split(",");
            try {
                line = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }

            for (int i = 0; i < textures.length; i++ ) {
                String tileTexture = textures[i];
                String[] singleTile = tileTexture.split("; ");
                for (int j = 0; j < singleTile.length; j++ ) {
                    if (singleTile.equals("")) {
                        buildingRegion[i][index][j] = null;
                    } else {
                        buildingRegion[i][index][j] = atlas.findRegion(singleTile[j]);
                    }
                }
            }
            index++;
        }
    }

    public void buildingAvailability(Batch batch, Tile buildingTile, int building, int buildingPosition) {
        if (buildingRegion[building][buildingPosition][rotation] != null ) {
            batch.draw(buildingRegion[building][buildingPosition][rotation], ((32 * rotationX) + buildingTile.getPosition().x), ((32 * rotationY) + buildingTile.getPosition().y), 0, 0, 64, 64, 1, 1, -(90 * rotation), false);

            if (generalAvailability(buildingTile, building, buildingPosition)) {
                batch.draw(SquareTileRegionFault, (-32 + buildingTile.getPosition().x), (-32 + buildingTile.getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
            } else {
                batch.draw(SquareTileRegionAllowed, (-32 + buildingTile.getPosition().x), (-32 + buildingTile.getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
            }
        }
    }

    public void buttonAvailability(TextButton BuildBuildingButton, Tile buildingTile, int building, int buildingPosition) {

        // We don't need the texture here, but if the texture is null then this tile should not be checked
        if (buildingRegion[building][buildingPosition][rotation] != null ) {
            if (generalAvailability(buildingTile, building, buildingPosition)) {
                BuildBuildingButton.setVisible(false);
            }
        }
    }

    private boolean generalAvailability(Tile buildingTile, int building, int buildingPosition) {

        if (buildingTile.getType().toString().equals(buildingAvailability[building][buildingPosition][0][rotation])
                || buildingTile.getType().toString().equals(buildingAvailability[building][buildingPosition][1][rotation])
                || buildingTile.getType().toString().equals(buildingAvailability[building][buildingPosition][2][rotation])
                || buildingTile.getType().toString().equals(buildingAvailability[building][buildingPosition][3][rotation])
                || buildingTile.getType().toString().equals(buildingAvailability[building][buildingPosition][4][rotation])) {
            return true;
        }
        return false;
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

    public void OutlineAvailability(Simulation simulation, Batch batch, int tileX, int tileY, int building, int buildingPosition, int radius )
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
                    Tile tile = simulation.tiles.get(x).get(y);
                    batch.draw(SquareOutlineAvailable, (-32 + tile.getPosition().x), (-32 + tile.getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);

                }
            }
        }
    }

    public void rotationControl(int rotation) {
        this.rotation = rotation;

        // When a building is rotated we want to identify the correct begin point to draw.
        if (rotation == 0) {
            rotationX = -1;
            rotationY = -1;
        } else if (rotation == 1) {
            rotationX = -1;
            rotationY = 1;
        } else if (rotation == 2) {
            rotationX = 1;
            rotationY = 1;
        } else if (rotation == 3) {
            rotationX = 1;
            rotationY = -1;
        }
    }

    public void buildingControl(TextButton BuildBuildingButton, Batch batch, Tile buildingTile, int building, int buildingPosition) {
        buildingAvailability(batch, buildingTile, building, buildingPosition);
        buttonAvailability(BuildBuildingButton, buildingTile, building, buildingPosition);
    }

    public boolean checkRotationPossibility(boolean available, int rotation, Tile buildingTile, int buildingPosition, int building) {
        int testRotation = rotation;
        // With this way, we can have rotation above 4, we will change it to be the correct rotation with the simple check.
        if( rotation >= 4 ) {
            testRotation = rotation%4;
        }

        // We don't need the texture here, but if the texture is null then this tile should not be checked
        if (buildingRegion[building][buildingPosition][testRotation] != null ) {
            if (generalAvailability(buildingTile, building, buildingPosition)) {
                available = false;
            }
        }
        return available;
    }
}
