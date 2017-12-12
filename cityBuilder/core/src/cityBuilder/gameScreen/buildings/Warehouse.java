package cityBuilder.gameScreen.buildings;

import com.badlogic.gdx.graphics.g2d.Batch;

import java.util.ArrayList;

import cityBuilder.load.Building;
import cityBuilder.load.Data;
import cityBuilder.objects.Tile;

/**
 * Created by User on 10/29/2017.
 */

public class Warehouse extends Data implements Building {

    Tile[] warehouseTiles;
    private int TileNumber = 0;

    public Warehouse(int TileNumber)
    {
        warehouseTiles = new Tile[6];
        this.TileNumber = TileNumber;
    }

    @Override
    public void render(Batch batch, int buildingPosition, float x, float y) {

    }

    public void update()
    {
    }

    @Override
    public void buildBuilding(ArrayList<Tile> tiles, int selectedTile, int rotation) {
        // Easy way to only set the correct tiles with the ratation
        if (rotation == 0) {
            tiles.get(selectedTile).setOccupied(5, 0, rotation);
            tiles.get(selectedTile + 1).setOccupied(5, 1, rotation);
            tiles.get(selectedTile - (gridSizeWidth - 1)).setOccupied(5, 2, rotation);
            tiles.get(selectedTile - (gridSizeWidth)).setOccupied(5, 3, rotation);
            tiles.get(selectedTile - (gridSizeWidth + 1)).setOccupied(5, 4, rotation);
            tiles.get(selectedTile - 1).setOccupied(5, 5, rotation);

            warehouseTiles[0] = tiles.get(selectedTile);
            warehouseTiles[1] = tiles.get(selectedTile + 1);
            warehouseTiles[2] = tiles.get(selectedTile - (gridSizeWidth - 1));
            warehouseTiles[3] = tiles.get(selectedTile - (gridSizeWidth));
            warehouseTiles[4] = tiles.get(selectedTile - (gridSizeWidth + 1));
            warehouseTiles[5] = tiles.get(selectedTile - 1);
        } else if (rotation == 1) {
            tiles.get(selectedTile).setOccupied(5, 0, rotation);
            tiles.get(selectedTile + 1).setOccupied(5, 1, rotation);
            tiles.get(selectedTile - (gridSizeWidth - 1)).setOccupied(5, 2, rotation);
            tiles.get(selectedTile - (gridSizeWidth)).setOccupied(5, 3, rotation);
            tiles.get(selectedTile+(gridSizeWidth)).setOccupied(5, 7, rotation);
            tiles.get(selectedTile+(gridSizeWidth+1)).setOccupied(5, 8, rotation);

            warehouseTiles[0] = tiles.get(selectedTile);
            warehouseTiles[1] = tiles.get(selectedTile + 1);
            warehouseTiles[2] = tiles.get(selectedTile - (gridSizeWidth - 1));
            warehouseTiles[3] = tiles.get(selectedTile - (gridSizeWidth));
            warehouseTiles[4] = tiles.get(selectedTile+(gridSizeWidth));
            warehouseTiles[5] = tiles.get(selectedTile+(gridSizeWidth+1));
        } else if (rotation == 2) {
            tiles.get(selectedTile).setOccupied(5, 0, rotation);
            tiles.get(selectedTile + 1).setOccupied(5, 1, rotation);
            tiles.get(selectedTile - 1).setOccupied(5, 5, rotation);
            tiles.get(selectedTile+(gridSizeWidth-1)).setOccupied(5, 6, rotation);
            tiles.get(selectedTile+(gridSizeWidth)).setOccupied(5, 7, rotation);
            tiles.get(selectedTile+(gridSizeWidth+1)).setOccupied(5, 8, rotation);

            warehouseTiles[0] = tiles.get(selectedTile);
            warehouseTiles[1] = tiles.get(selectedTile + 1);
            warehouseTiles[2] = tiles.get(selectedTile - 1);
            warehouseTiles[3] = tiles.get(selectedTile+(gridSizeWidth-1));
            warehouseTiles[4] = tiles.get(selectedTile+(gridSizeWidth));
            warehouseTiles[5] = tiles.get(selectedTile+(gridSizeWidth+1));
        } else if (rotation == 3) {
            tiles.get(selectedTile).setOccupied(5, 0, rotation);
            tiles.get(selectedTile - (gridSizeWidth)).setOccupied(5, 3, rotation);
            tiles.get(selectedTile - (gridSizeWidth + 1)).setOccupied(5, 4, rotation);
            tiles.get(selectedTile - 1).setOccupied(5, 5, rotation);
            tiles.get(selectedTile+(gridSizeWidth-1)).setOccupied(5, 6, rotation);
            tiles.get(selectedTile+(gridSizeWidth)).setOccupied(5, 7, rotation);

            warehouseTiles[0] = tiles.get(selectedTile);
            warehouseTiles[1] = tiles.get(selectedTile - (gridSizeWidth));
            warehouseTiles[2] = tiles.get(selectedTile - (gridSizeWidth + 1));
            warehouseTiles[3] = tiles.get(selectedTile - 1);
            warehouseTiles[4] = tiles.get(selectedTile+(gridSizeWidth-1));
            warehouseTiles[5] = tiles.get(selectedTile+(gridSizeWidth));
        }
    }

}
