package cityBuilder.load;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

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
    private TextureRegion[] farmTexture;
    private TextureRegion[] woodCutterTexture;
    private TextureRegion[] wareHouseTexture;
    private TextureRegion treeTexture;

    private String[][][][] buildingAvailability;
    private TextureRegion[][][] buildingRegion;

    public BuildingAvailabilityControl(TextureAtlas atlas) {
        SquareTileRegionFault = atlas.findRegion("notAllowedIso");
        SquareTileRegionAllowed = atlas.findRegion("allowedIso");
        SquareOutlineAvailable = atlas.findRegion("regionIso");
        farmTexture = new TextureRegion[4];
        farmTexture[0] = atlas.findRegion("farm1");
        farmTexture[1] = atlas.findRegion("farm2");
        farmTexture[2] = atlas.findRegion("farm3");
        farmTexture[3] = atlas.findRegion("farm4");
        woodCutterTexture = new TextureRegion[4];
        woodCutterTexture[0] = atlas.findRegion("woodCutter1");
        woodCutterTexture[1] = atlas.findRegion("woodCutter2");
        woodCutterTexture[2] = atlas.findRegion("woodCutter3");
        woodCutterTexture[3] = atlas.findRegion("woodCutter4");
        wareHouseTexture = new TextureRegion[4];
        wareHouseTexture[0] = atlas.findRegion("warehouse2");
        wareHouseTexture[1] = atlas.findRegion("warehouse3");
        wareHouseTexture[2] = atlas.findRegion("warehouse4");
        wareHouseTexture[3] = atlas.findRegion("warehouse1");
        treeTexture = atlas.findRegion("treeTest");

        // Read the availability of the buildings from a file and store all the data in a multi dimensional array
        FileHandle buildingRestrictions = Gdx.files.internal("buildingData/buildingAvailability.csv");
        BufferedReader br = new BufferedReader(buildingRestrictions.reader());

        buildingAvailability = new String[6][25][5][4];
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

        buildingRegion = new TextureRegion[6][10][4];
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

    public void buildingAvailability(Batch bitch, Tile buildingTile, int building, int buildingPosition) {
        // First draw the texture of the building itself.
        if (building == 0 && buildingPosition == 0) {
            bitch.draw(farmTexture[rotation],(buildingTile.getPosition().x - 50), (buildingTile.getPosition().y + 55), 0, 0, 96, 180, 1, 1, -90, false);
        } else if (building == 2 && buildingPosition == 0) {
            bitch.draw(woodCutterTexture[rotation],(buildingTile.getPosition().x - 50), (buildingTile.getPosition().y + 55), 0, 0, 96, 180, 1, 1, -90, false);
        } else if (building == 3 && buildingPosition == 0) {
            bitch.draw(wareHouseTexture[rotation],(buildingTile.getPosition().x - 50), (buildingTile.getPosition().y + 55), 0, 0, 96, 180, 1, 1, -90, false);
        }  else if (building == 5) {
            bitch.draw(treeTexture, (buildingTile.getPosition().x - 40), (buildingTile.getPosition().y + 45), 0, 0, 60, 60, 1, 1, -90, false);
        }

        // Then draw if it is allowed to place it or not with red or green overlay.
        if (building == 3) {
            if (rotation == 0 && buildingPosition == 0
                    || rotation == 0 && buildingPosition == 1
                    || rotation == 0 && buildingPosition == 2
                    || rotation == 0 && buildingPosition == 3
                    || rotation == 0 && buildingPosition == 4
                    || rotation == 0 && buildingPosition == 5
                    || rotation == 1 && buildingPosition == 0
                    || rotation == 1 && buildingPosition == 1
                    || rotation == 1 && buildingPosition == 2
                    || rotation == 1 && buildingPosition == 3
                    || rotation == 1 && buildingPosition == 7
                    || rotation == 1 && buildingPosition == 8
                    || rotation == 2 && buildingPosition == 0
                    || rotation == 2 && buildingPosition == 1
                    || rotation == 2 && buildingPosition == 5
                    || rotation == 2 && buildingPosition == 6
                    || rotation == 2 && buildingPosition == 7
                    || rotation == 2 && buildingPosition == 8
                    || rotation == 3 && buildingPosition == 0
                    || rotation == 3 && buildingPosition == 3
                    || rotation == 3 && buildingPosition == 4
                    || rotation == 3 && buildingPosition == 5
                    || rotation == 3 && buildingPosition == 6
                    || rotation == 3 && buildingPosition == 7)
            if (generalAvailability(buildingTile, building, buildingPosition)) {
                bitch.draw(SquareTileRegionFault, (-45 + buildingTile.getPosition().x), (-23 + buildingTile.getPosition().y), 0, 0, 90, 46, 1, 1, 0, false);
            } else {
                bitch.draw(SquareTileRegionAllowed, (-45 + buildingTile.getPosition().x), (-23 + buildingTile.getPosition().y), 0, 0, 90, 46, 1, 1, 0, false);
            }
        } else {
            if (generalAvailability(buildingTile, building, buildingPosition)
                    || !buildingTile.getRegionOwned()) {
                bitch.draw(SquareTileRegionFault, (-45 + buildingTile.getPosition().x), (-23 + buildingTile.getPosition().y), 0, 0, 90, 46, 1, 1, 0, false);
            } else {
                bitch.draw(SquareTileRegionAllowed, (-45 + buildingTile.getPosition().x), (-23 + buildingTile.getPosition().y), 0, 0, 90, 46, 1, 1, 0, false);
            }
        }
    }

    public void buttonAvailability(TextButton BuildBuildingButton, Tile buildingTile, int building, int buildingPosition) {

        // We don't need the texture here, but if the texture is null then this tile should not be checked
        if (building == 3) {
            if (buildingRegion[building][buildingPosition][rotation] != null) {
                if (generalAvailability(buildingTile, building, buildingPosition)) {
                    BuildBuildingButton.setVisible(false);
                }
            }
        } else {
            if (buildingRegion[building][buildingPosition][rotation] != null) {
                if (generalAvailability(buildingTile, building, buildingPosition)
                        || !buildingTile.getRegionOwned()) {
                    BuildBuildingButton.setVisible(false);
                }
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

    public void OutlineAvailability(Tile[][] tiles, Batch batch, int tileX, int tileY, int building, int radius ) {
        boolean[][] grid = new boolean[gridSizeWidth][gridSizeHeight];
        for (int x = 0; x < grid.length; x++ ) {
            for (int y = 0; y < grid[x].length; y++) {
                grid[x][y] = false;
            }
        }

        if (building == 1) {
            defineCircle(grid, radius*2-1, radius*2-1, radius);
            defineCircle(grid, radius*2+1, radius*2-1, radius);
            defineCircle(grid, radius*2-1, radius*2+1, radius);
            defineCircle(grid, radius*2+1, radius*2+1, radius);
        }

        if (building == 2) {
            defineCircle(grid, radius*2, radius*2, radius);
            defineCircle(grid, radius*2+1, radius*2, radius);
            defineCircle(grid, radius*2, radius*2+1, radius);
            defineCircle(grid, radius*2+1, radius*2+1, radius);
        }

        for (int x = 0; x < grid.length; x++ ) {
            for (int y = 0; y < grid[x].length; y++) {
                if (grid[x][y] ) {
                    if ((((x+(tileX-(radius*2))) >= 0) && ((y+(tileY-(radius*2))) >= 0)) && (((x+(tileX-(radius*2))) < gridSizeWidth) && ((y+(tileY-(radius*2))) < gridSizeHeight))) {
                        Tile tile = tiles[x + (tileX - (radius * 2))][y + (tileY - (radius * 2))];
                        // if it's a warehouse we want to see the range that we will gain (building == 1)
                        // if it's a woodcutter we want the range to not include the regions that are not owned yet
                        if ((building == 2 && tile.getRegionOwned()) || building == 1) {
                            batch.draw(SquareOutlineAvailable, (-45 + tile.getPosition().x), (-23 + tile.getPosition().y), 0, 0, 90, 46, 1, 1, 0, false);
                        }
                    }
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
