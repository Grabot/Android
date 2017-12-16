package cityBuilder.load;

import java.util.ArrayList;

import cityBuilder.objects.Tile;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class TilesLoad extends Data {
	private Tile[][] tile = new Tile[gridSizeWidth][gridSizeHeight];

	public ArrayList<ArrayList<Tile>> tiles = new ArrayList<ArrayList<Tile>>();

	public TilesLoad(TextureAtlas atlas) {

		for (int x = 0; x < gridSizeWidth; x++) {
			for (int y = 0; y < gridSizeHeight; y++) {
				tile[x][y] = new Tile(new Vector((-tileStartWidth + (tileWidth * y)), (tileStartHeight - (tileHeight * x))), atlas);
			}
		}

		setAttributes attributes = new setAttributes(tile);
		attributes.attributes();

		for (int y = 0; y < gridSizeWidth; y++) {
			tiles.add(new ArrayList<Tile>());
			for (int x = 0; x < gridSizeHeight; x++) {
				tiles.get(y).add(attributes.getTile(x, y));
			}
		}
	}

	public ArrayList<ArrayList<Tile>> getTiles() {
		return tiles;
	}
}
