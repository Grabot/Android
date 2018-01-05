package cityBuilder.load;

import java.util.ArrayList;

import cityBuilder.objects.Tile;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class TilesLoad extends Data {
	private Tile[][] tileArray = new Tile[gridSizeWidth][gridSizeHeight];

	public ArrayList<ArrayList<Tile>> tiles = new ArrayList<ArrayList<Tile>>();
	public ArrayList<ArrayList<Tile>> tiles2 = new ArrayList<ArrayList<Tile>>();

	public TilesLoad(TextureAtlas atlas) {

		for (int x = 0; x < gridSizeWidth; x++) {
			ArrayList<Tile> mapLine = new ArrayList<Tile>();
			for (int y = 0; y < gridSizeHeight; y++) {
				tileArray[x][y] = new Tile(new Vector(
						(x*43)+(y*43),  // x
						(y*21)-(x*21)), // y
						atlas);
				mapLine.add(tileArray[x][y]);
			}
			tiles.add(mapLine);
		}


		setAttributes attributes = new setAttributes();
		attributes.attributes(tiles);
		attributes.attributesTileArray(tileArray);

		for (int x = 0; x < gridSizeWidth; x++ ) {
			for (int y = 0; y < gridSizeHeight-1; y++ ) {
				tiles.get(x).get(y).setX(x);
				tiles.get(x).get(y).setY(y);
				tileArray[x][y].setX(x);
				tileArray[x][y].setY(y);
			}
		}
	}

	public ArrayList<ArrayList<Tile>> getTiles() {
		return tiles;
	}

	public Tile[][] getTileArray() {
		return tileArray;
	}
}
