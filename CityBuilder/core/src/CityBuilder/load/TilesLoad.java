package CityBuilder.load;

import java.util.ArrayList;

import CityBuilder.objects.Tile;

import com.badlogic.gdx.graphics.g2d.Batch;

public class TilesLoad extends Data
{
	private Tile[] tile = new Tile[60001];
	public ArrayList<Tile> tiles = new ArrayList<Tile>();
	
	public TilesLoad()
	{
		tile[0] = new Tile( new Vector( 0, 0 ));
		int x = 0;
		int y = 0;
		for( int i = 1; i < (numberOfTiles + 1); i++ )
		{
			tile[i] = new Tile( new Vector((-tileStartWidth + (tileWidth * x)), (tileStartHeight - (tileHeight * y))));
			
			if( (i % gridSizeWidth) == 0 )
			{
				x = x - gridSizeWidth;
				y++;
			}
			
			x++;
		}

		setAttributes attributes = new setAttributes(tile);
		attributes.attributes();
		//tile = attributes.attributes();
		
		for( int i = 0; i < (numberOfTiles + 1); i++ )
		{
			tiles.add( attributes.getTile(i) );
		}
	}

	public ArrayList<Tile> getTiles()
	{
		return tiles;
	}
}
