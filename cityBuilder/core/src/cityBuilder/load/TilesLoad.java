package cityBuilder.load;

import java.util.ArrayList;

import cityBuilder.objects.Tile;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class TilesLoad extends Data
{
	private Tile[][] tile = new Tile[gridSizeWidth][gridSizeHeight];

	public ArrayList<Tile> tiles = new ArrayList<Tile>();
	public ArrayList<ArrayList<Tile>> tiles2D = new ArrayList<ArrayList<Tile>>();

	public TilesLoad(TextureAtlas atlas)
	{

		for( int x = 0; x < gridSizeWidth; x++ )
		{
			tiles2D.add(new ArrayList<Tile>());
			for( int y = 0; y < gridSizeHeight; y++ )
			{
				tile[x][y] = new Tile( new Vector((-tileStartWidth + (tileWidth * y)), (tileStartHeight - (tileHeight * x))), atlas);
				tile[x][y].setName("(" + x + "," + y + ")");
				tiles2D.get(x).add(tile[x][y]);
			}
		}

		setAttributes attributes = new setAttributes(tile);
		attributes.attributes();

		for( int x = 0; x < gridSizeWidth; x++ )
		{
			for( int y = 0; y < gridSizeHeight; y++ )
			{
				System.out.print("; " + tiles2D.get(x).get(y).getName());
				tiles.add( attributes.getTile(x, y) );
			}
			System.out.println("");
		}
	}

	public ArrayList<Tile> getTiles()
	{
		return tiles;
	}
}
