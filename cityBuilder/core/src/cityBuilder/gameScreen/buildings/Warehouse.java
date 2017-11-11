package cityBuilder.gameScreen.buildings;

import java.util.ArrayList;

import cityBuilder.load.Data;
import cityBuilder.objects.Tile;

/**
 * Created by User on 10/29/2017.
 */

public class Warehouse extends Data {

    public ArrayList<Tile> tiles = new ArrayList<Tile>();
    private int TileNumber = 0;

    public Warehouse(int TileNumber, ArrayList<Tile> tiles )
    {
        this.tiles = tiles;
        this.TileNumber = TileNumber;
    }

    public void update()
    {
    }

}
