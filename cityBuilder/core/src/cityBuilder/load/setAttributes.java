package cityBuilder.load;


import java.io.BufferedReader;
import java.io.IOException;

import cityBuilder.enums.TileType;
import cityBuilder.objects.Tile;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;

public class setAttributes extends Data
{
	private Tile[][] tile = new Tile[24][24];
	FileHandle layout;
	BufferedReader br;

	public setAttributes(Tile[][] tile)
	{
		this.tile = tile;
	}

	public void attributes()
	{

		for( int i = 0; i < gridSizeWidth; i++ )
		{
			for( int j = 0; j < gridSizeHeight; j++ )
			{
				tile[i][j].setAttributes( TileType.grass, available, 0, 2000, 0 );
			}
		}

		layout = Gdx.files.internal("mapLayout/layoutTiles2.csv");
		br = new BufferedReader(layout.reader());

		String line = null;
		try
		{
			line = br.readLine();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}

		int height = 0;
		while( line != null )
		{
			String [] items = line.split(",");
			for( int width = 0; width < items.length; width++ )
			{
				if( Integer.parseInt(items[width]) == 15 )
				{
					tile[height][width].setAttributes( TileType.grass, available, 0, 2000, 0 );
				}
				else if( Integer.parseInt(items[width]) == 20 )
				{
					tile[height][width].setAttributes( TileType.water, available, 0, 2000, 0 );
				}
				else if( Integer.parseInt(items[width]) >= 23 && Integer.parseInt(items[width]) <= 34 )
				{
					tile[height][width].setAttributes( TileType.shore, available, 0, 2000, Integer.parseInt(items[width]) );
				}
				else
				{
					tile[height][width].setAttributes( TileType.grass, available, 0, 2000, 12 );
					tile[height][width].setOccupied(3, 0, 0);
				}
			}

			try
			{
				line = br.readLine();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
			height++;
		}

	}

	public Tile getTile( int i, int j )
	{
		return tile[i][j];
	}
}
