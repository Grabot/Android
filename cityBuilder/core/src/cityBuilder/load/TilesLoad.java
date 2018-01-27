package cityBuilder.load;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import cityBuilder.objects.Tile;

public class TilesLoad extends Data {
	private Tile[][] tileArray = new Tile[gridSizeWidth][gridSizeHeight];

	public TilesLoad(TextureAtlas atlas) {

		for (int x = 0; x < gridSizeWidth; x++) {
			for (int y = 0; y < gridSizeHeight; y++) {
				tileArray[x][y] = new Tile(new Vector(
						(x*43)+(y*43),  // x
						(y*21)-(x*21)), // y
						atlas);
				tileArray[x][y].setX(x);
				tileArray[x][y].setY(y);
			}
		}

		setAttributes setAttributes = new setAttributes();
		setAttributes.setAttributesTileArray(tileArray, atlas);
	}

	public Tile[][] getTileArray() {
		return tileArray;
	}
}
