package cityBuilder.load;

import java.util.ArrayList;

import cityBuilder.objects.Tile;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class TilesLoad extends Data {
	private Tile[][] tile = new Tile[gridSizeWidth][gridSizeHeight];

	public ArrayList<ArrayList<Tile>> tiles1 = new ArrayList<ArrayList<Tile>>();
	public ArrayList<ArrayList<Tile>> tiles2 = new ArrayList<ArrayList<Tile>>();
	public ArrayList<ArrayList<Tile>> tiles3 = new ArrayList<ArrayList<Tile>>();
	public ArrayList<ArrayList<Tile>> tiles4 = new ArrayList<ArrayList<Tile>>();

	public TilesLoad(TextureAtlas atlas) {

		for (int x = 0; x < gridSizeWidth; x++) {
			ArrayList<Tile> mapLine = new ArrayList<Tile>();
			for (int y = 0; y < gridSizeHeight; y++) {
				tile[x][y] = new Tile(new Vector(
						(x*43)+(y*43), // x
						(y*21)-(x*21)), // y
						atlas);
				mapLine.add(tile[x][y]);
			}
			tiles1.add(mapLine);
		}

		for (int y = 0; y < gridSizeWidth; y++) {
			ArrayList<Tile> mapLine2 = new ArrayList<Tile>();
			for (int x = 0; x < gridSizeHeight; x++) {
				tile[x][y] = new Tile(new Vector(
						(x*43)+(y*43), // x
						(y*21)-(x*21)), // y
						atlas);
				mapLine2.add(tile[x][y]);
			}
			tiles2.add(mapLine2);
		}

		for (int x = gridSizeWidth-1; x >= 0; x--) {
			ArrayList<Tile> mapLine3 = new ArrayList<Tile>();
			for (int y = gridSizeHeight-1; y >= 0; y--) {
				tile[x][y] = new Tile(new Vector(
						(x*43)+(y*43), // x
						(y*21)-(x*21)), // y
						atlas);
				mapLine3.add(tile[x][y]);
			}
			tiles3.add(mapLine3);
		}

		setAttributes attributes = new setAttributes();
		attributes.attributes(tiles1);
		attributes.attributes(tiles2);
		attributes.attributes(tiles3);

		for (int x = 0; x < gridSizeWidth; x++ ) {
			for (int y = 0; y < gridSizeHeight-1; y++ ) {
				tiles1.get(x).get(y).setX(x);
				tiles1.get(x).get(y).setY(y);
			}
		}

		// create the rotation possibility, we will do this by creating 4 double tile arrays.
		// second rotation, for now we
//		for (int x = 0; x < gridSizeWidth; x++ ) {
//			for (int y = 0; y < gridSizeHeight - 1; y++) {
//			}
//		}
	}

	public ArrayList<ArrayList<Tile>> getTiles() {
		return tiles1;
	}

	public ArrayList<ArrayList<Tile>> getTiles2() {
		return tiles2;
	}

	public ArrayList<ArrayList<Tile>> getTiles3() {
		return tiles3;
	}
}
