package cityBuilder.gameScreen.buildings;

import java.util.ArrayList;

import cityBuilder.objects.Tile;

/**
 * Created by User on 12/4/2017.
 */

public class Warehouse2 {
    public ArrayList<Tile> tiles = new ArrayList<Tile>();
    private int TileNumber = 0;

    public Warehouse2(int TileNumber, ArrayList<Tile> tiles )
    {
        this.tiles = tiles;
        this.TileNumber = TileNumber;
    }

    public void update()
    {
    }
}
