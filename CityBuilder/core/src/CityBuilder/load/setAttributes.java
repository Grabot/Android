package CityBuilder.load;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import CityBuilder.enums.TileType;
import CityBuilder.objects.Tile;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.scenes.scene2d.ui.List;

public class setAttributes extends Data
{
	private Tile[][] tile = new Tile[24][24];
	FileHandle layout;
	BufferedReader br;
	
	public setAttributes(Tile[][] tile)
	{
		this.tile = tile;
		//this.tile = tile;
	}
	
	public void attributes()
	{
		
		layout = Gdx.files.internal("mapLayout/layoutTiles.csv");
		br = new BufferedReader(layout.reader());
		
		Iterator<String> mapLines = br.lines().iterator();
		
		int height = 0;
		while( mapLines.hasNext() )
		{
			String line = mapLines.next().toString();
			String [] items = line.split(",");
			for( int width = 0; width < items.length; width++ )
			{
				if( Integer.parseInt(items[width]) == 15 )
				{
					tile[height][width].setAttributes( TileType.grass, available, 0, 2000 );
				}
				else if( Integer.parseInt(items[width]) == 20 )
				{
					tile[height][width].setAttributes( TileType.water, available, 0, 2000 );
				}
			}
			height++;
		}
	}
	
	public Tile getTile( int i, int j )
	{
		return tile[i][j];
	}
}
