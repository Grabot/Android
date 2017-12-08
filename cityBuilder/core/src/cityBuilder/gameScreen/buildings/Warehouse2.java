package cityBuilder.gameScreen.buildings;

import java.util.ArrayList;

import cityBuilder.load.Data;
import cityBuilder.objects.Tile;

public class Warehouse2 extends Data {

    private int TileNumber = 0;
    Tile[] warehouse2Tiles;

    public Warehouse2(int TileNumber )
    {
        warehouse2Tiles = new Tile[6];
        this.TileNumber = TileNumber;
    }

    public void update()
    {
    }

    public void buildWarehouse2(ArrayList<Tile> tiles, int selectedTile, int rotation) {

        // Easy way to only set the correct tiles with the ratation
        if (rotation == 0) {
            tiles.get(selectedTile).setOccupied(5, 0, rotation);
            tiles.get(selectedTile + 1).setOccupied(5, 1, rotation);
            tiles.get(selectedTile - (gridSizeWidth - 1)).setOccupied(5, 2, rotation);
            tiles.get(selectedTile - (gridSizeWidth)).setOccupied(5, 3, rotation);
            tiles.get(selectedTile - (gridSizeWidth + 1)).setOccupied(5, 4, rotation);
            tiles.get(selectedTile - 1).setOccupied(5, 5, rotation);

            warehouse2Tiles[0] = tiles.get(selectedTile);
            warehouse2Tiles[1] = tiles.get(selectedTile + 1);
            warehouse2Tiles[2] = tiles.get(selectedTile - (gridSizeWidth - 1));
            warehouse2Tiles[3] = tiles.get(selectedTile - (gridSizeWidth));
            warehouse2Tiles[4] = tiles.get(selectedTile - (gridSizeWidth + 1));
            warehouse2Tiles[5] = tiles.get(selectedTile - 1);
        } else if (rotation == 1) {
            tiles.get(selectedTile).setOccupied(5, 0, rotation);
            tiles.get(selectedTile + 1).setOccupied(5, 1, rotation);
            tiles.get(selectedTile - (gridSizeWidth - 1)).setOccupied(5, 2, rotation);
            tiles.get(selectedTile - (gridSizeWidth)).setOccupied(5, 3, rotation);
            tiles.get(selectedTile+(gridSizeWidth)).setOccupied(5, 7, rotation);
            tiles.get(selectedTile+(gridSizeWidth+1)).setOccupied(5, 8, rotation);

            warehouse2Tiles[0] = tiles.get(selectedTile);
            warehouse2Tiles[1] = tiles.get(selectedTile + 1);
            warehouse2Tiles[2] = tiles.get(selectedTile - (gridSizeWidth - 1));
            warehouse2Tiles[3] = tiles.get(selectedTile - (gridSizeWidth));
            warehouse2Tiles[4] = tiles.get(selectedTile+(gridSizeWidth));
            warehouse2Tiles[5] = tiles.get(selectedTile+(gridSizeWidth+1));
        } else if (rotation == 2) {
            tiles.get(selectedTile).setOccupied(5, 0, rotation);
            tiles.get(selectedTile + 1).setOccupied(5, 1, rotation);
            tiles.get(selectedTile - 1).setOccupied(5, 5, rotation);
            tiles.get(selectedTile+(gridSizeWidth-1)).setOccupied(5, 6, rotation);
            tiles.get(selectedTile+(gridSizeWidth)).setOccupied(5, 7, rotation);
            tiles.get(selectedTile+(gridSizeWidth+1)).setOccupied(5, 8, rotation);

            warehouse2Tiles[0] = tiles.get(selectedTile);
            warehouse2Tiles[1] = tiles.get(selectedTile + 1);
            warehouse2Tiles[2] = tiles.get(selectedTile - 1);
            warehouse2Tiles[3] = tiles.get(selectedTile+(gridSizeWidth-1));
            warehouse2Tiles[4] = tiles.get(selectedTile+(gridSizeWidth));
            warehouse2Tiles[5] = tiles.get(selectedTile+(gridSizeWidth+1));
        } else if (rotation == 3) {
            tiles.get(selectedTile).setOccupied(5, 0, rotation);
            tiles.get(selectedTile - (gridSizeWidth)).setOccupied(5, 3, rotation);
            tiles.get(selectedTile - (gridSizeWidth + 1)).setOccupied(5, 4, rotation);
            tiles.get(selectedTile - 1).setOccupied(5, 5, rotation);
            tiles.get(selectedTile+(gridSizeWidth-1)).setOccupied(5, 6, rotation);
            tiles.get(selectedTile+(gridSizeWidth)).setOccupied(5, 7, rotation);

            warehouse2Tiles[0] = tiles.get(selectedTile);
            warehouse2Tiles[1] = tiles.get(selectedTile - (gridSizeWidth));
            warehouse2Tiles[2] = tiles.get(selectedTile - (gridSizeWidth + 1));
            warehouse2Tiles[3] = tiles.get(selectedTile - 1);
            warehouse2Tiles[4] = tiles.get(selectedTile+(gridSizeWidth-1));
            warehouse2Tiles[5] = tiles.get(selectedTile+(gridSizeWidth));
        }
    }
}
