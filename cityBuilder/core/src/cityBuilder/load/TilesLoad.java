package cityBuilder.load;

import java.util.ArrayList;

import cityBuilder.objects.Tile;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class TilesLoad extends Data {
	private Tile[][] tile = new Tile[gridSizeWidth][gridSizeHeight];

	public ArrayList<ArrayList<Tile>> tiles = new ArrayList<ArrayList<Tile>>();

	public TilesLoad(TextureAtlas atlas) {

		for (int x = 0; x < gridSizeWidth; x++) {
			ArrayList<Tile> mapLine = new ArrayList<Tile>();
			for (int y = 0; y < gridSizeHeight; y++) {
				tile[x][y] = new Tile(new Vector((tileHeight * x), (tileWidth * y)), atlas);
				mapLine.add(tile[x][y]);
			}
			tiles.add(mapLine);
		}

		setAttributes attributes = new setAttributes();
		attributes.attributes(tiles);

		for (int x = 0; x < gridSizeWidth; x++ ) {
			for (int y = 0; y < gridSizeHeight-1; y++ ) {
				tiles.get(x).get(y).setX(x);
				tiles.get(x).get(y).setY(y);
			}
		}
	}

	public ArrayList<ArrayList<Tile>> getTiles() {
		return tiles;
	}
}
