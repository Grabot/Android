package cityBuilder.load;


import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

import cityBuilder.enums.TileType;
import cityBuilder.gameScreen.buildings.Wood;
import cityBuilder.objects.Tile;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class setAttributes extends Data
{
	FileHandle layout;
	BufferedReader br;

	public setAttributes() {
	}

	public void setAttributesTileArray(Tile[][] tiles, TextureAtlas atlas) {
		for( int x = 0; x < gridSizeWidth; x++ ) {
			for( int y = 0; y < gridSizeHeight; y++ ) {
				tiles[x][y].setAttributes( TileType.grass, available, 0, 2000, 0 );
			}
		}

		layout = Gdx.files.internal("mapLayout/IsoAnno4.csv");
		br = new BufferedReader(layout.reader());

		String line = null;
		try {
			line = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}

		int height = 0;
		while( line != null ) {
			String[] items = line.split(",");
			for (int width = 0; width < items.length; width++) {
				if (Integer.parseInt(items[width]) == 2) {
					tiles[height][width].setAttributes( TileType.grass, available, 0, 2000, 0 );
				} else if (Integer.parseInt(items[width]) == 8) {
					tiles[height][width].setAttributes( TileType.water, available, 0, 2000, 0 );
				} else if (Integer.parseInt(items[width]) == 5) {
					tiles[height][width].setAttributes( TileType.grass, available, 0, 2000, 0 );
					Wood wood = new Wood(null, 0, atlas);
					wood.buildBuilding(tiles, tiles[height][width].getX(), tiles[height][width].getY(), 0);
					tiles[height][width].getWood().setLife(1000);
				}
			}

			try {
				line = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			height++;
		}
	}
}
