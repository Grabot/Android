package cityBuilder.gameScreen.buildings;

import java.util.ArrayList;

import cityBuilder.objects.Tile;

/**
 * Created by User on 12/5/2017.
 */

public class Road {
    public ArrayList<Tile> tiles = new ArrayList<Tile>();
    private int TileNumber = 0;

    public Road( int TileNumber, ArrayList<Tile> tiles )
    {
        this.tiles = tiles;
        this.TileNumber = TileNumber;
    }

    public void update()
    {
    }
}
