package cityBuilder.load;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import cityBuilder.objects.Tile;

/**
 * Created by User on 11/5/2017.
 */

public class BuildingAvailabilityControl
{
    private TextureRegion SquareTileRegionFault;
    private TextureRegion SquareTileRegionAllowed;

    private String[][][] buildingAvailability;
    private TextureRegion[][] buildingRegion;

    public BuildingAvailabilityControl(TextureAtlas atlas) {

        SquareTileRegionFault = atlas.findRegion("SquareRedSmall");
        SquareTileRegionAllowed = atlas.findRegion("SquareGreenSmall");
        buildingAvailability = new String[5][25][5];
        for( int i = 0; i < buildingAvailability.length; i++ )
        {
            for( int j = 0; j < buildingAvailability[i].length; j++ ) {
                for( int k = 0; k < buildingAvailability[i][j].length; k++ ) {
                    buildingAvailability[i][j][k] = "";
                }
            }
        }
        buildingAvailability[0][0][0] = "water";
        buildingAvailability[0][0][1] = "shore";
        buildingAvailability[0][1][0] = "water";
        buildingAvailability[0][1][1] = "shore";
        buildingAvailability[0][2][0] = "water";
        buildingAvailability[0][2][1] = "shore";
        buildingAvailability[0][3][0] = "water";
        buildingAvailability[0][3][1] = "shore";

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

        buildingAvailability[2][0][0] = "water";
        buildingAvailability[2][0][1] = "shore";
        buildingAvailability[2][1][0] = "water";
        buildingAvailability[2][1][1] = "shore";
        buildingAvailability[2][2][0] = "water";
        buildingAvailability[2][2][1] = "shore";
        buildingAvailability[2][3][0] = "water";
        buildingAvailability[2][3][1] = "shore";

        buildingRegion = new TextureRegion[5][10];
        buildingRegion[0][0] = atlas.findRegion("farmbuilding2");
        buildingRegion[0][1] = atlas.findRegion("farmbuilding1");
        buildingRegion[0][2] = atlas.findRegion("farmbuilding4");
        buildingRegion[0][3] = atlas.findRegion("farmbuilding3");

        buildingRegion[1][0] = atlas.findRegion("farmbuilding3");
        buildingRegion[1][1] = atlas.findRegion("farmbuilding3");
        buildingRegion[1][2] = atlas.findRegion("farmbuilding3");
        buildingRegion[1][3] = atlas.findRegion("farmbuilding3");
        buildingRegion[1][4] = atlas.findRegion("farmbuilding3");
        buildingRegion[1][5] = atlas.findRegion("farmbuilding3");
        buildingRegion[1][6] = atlas.findRegion("farmbuilding3");
        buildingRegion[1][7] = atlas.findRegion("farmbuilding3");
        buildingRegion[1][8] = atlas.findRegion("farmbuilding3");

        buildingRegion[2][0] = atlas.findRegion("WoodCutterBuilding2");
        buildingRegion[2][1] = atlas.findRegion("WoodCutterBuilding1");
        buildingRegion[2][2] = atlas.findRegion("WoodCutterBuilding4");
        buildingRegion[2][3] = atlas.findRegion("WoodCutterBuilding3");
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
}
