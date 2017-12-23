package cityBuilder.gameScreen.buildings;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.ArrayList;
import java.util.Random;

import cityBuilder.load.Building;
import cityBuilder.load.Data;
import cityBuilder.load.Vector;
import cityBuilder.objects.Tile;

public class WoodCutter extends Data implements Building {

	Tile[] woodcutterTiles;
	Tile[] regionTiles;
	private int rotation;
	private TextureRegion SquareTileRegionWoodCutterBottomLeft;
	private TextureRegion SquareTileRegionWoodCutterBottomRight;
	private TextureRegion SquareTileRegionWoodCutterTopLeft;
	private TextureRegion SquareTileRegionWoodCutterTopRight;
	private TextureRegion SquareTileRegionAllowed;

	private Random random;

	private Tile woodcut;
	private boolean cutting;
	private Vector centerPosition;
	private float distanceWoodCutterToTree;

	public WoodCutter(int rotation, TextureAtlas atlas)
	{
		woodcutterTiles = new Tile[4];
		regionTiles = new Tile[48];
		this.rotation = rotation;
		SquareTileRegionWoodCutterBottomLeft = atlas.findRegion("cubeDark");
		SquareTileRegionWoodCutterTopLeft = atlas.findRegion("cubeDark");
		SquareTileRegionWoodCutterTopRight = atlas.findRegion("cubeDark");
		SquareTileRegionWoodCutterBottomRight = atlas.findRegion("cubeDark");
		SquareTileRegionAllowed = atlas.findRegion("SquareGreenSmall");

		random = new Random();
		woodcut = null;
	}

	@Override
	public void render(Batch batch, int position, float x, float y) {
		if( position == 0 ) {
			//bottom left
			batch.draw( SquareTileRegionWoodCutterBottomLeft, -32 + x , -32 + y, 32, 32, 64, 64, 1, 1, -(90 * rotation), false);
		} else if( position == 1 ) {
			//top left
			batch.draw( SquareTileRegionWoodCutterTopLeft, -32 + x , -32 + y, 32, 32, 64, 64, 1, 1, -(90 * rotation), false);
		} else if( position == 2 ) {
			//top right
			batch.draw( SquareTileRegionWoodCutterTopRight, -32 + x , -32 + y, 32, 32, 64, 64, 1, 1, -(90 * rotation), false);
		} else if( position == 3 ) {
			//bottom right
			batch.draw( SquareTileRegionWoodCutterBottomRight, -32 + x , -32 + y, 32, 32, 64, 64, 1, 1, -(90 * rotation), false);
		}

		if (woodcut != null && cutting) {
			batch.draw( SquareTileRegionAllowed, -32 + woodcut.getPosition().x , -32 + woodcut.getPosition().y, 32, 32, 64, 64, 1, 1, -(90 * rotation), false);
		}
	}

	public void update() {
		if (!cutting) {
			ArrayList<Tile> treeTiles = new ArrayList<Tile>();
			for (Tile tile : regionTiles) {
				if (tile != null) {
					// Check if one of the region tiles is a wood tile.
					if (tile.getOccupied() == 3) {
						Wood wood = tile.getWood();
						if (wood.getLife() == 1000) {
							treeTiles.add(tile);
						}
					}
				}
			}

			if (treeTiles.size() != 0) {
				// if there are fully grown trees we want to cut one down.
				// just get the first one, not random but it will feel random for users.
				woodcut = treeTiles.get(0);
				cutting = true;
				distanceWoodCutterToTree = centerPosition.distance(woodcut.getPosition());
				System.out.println("distance: " + distanceWoodCutterToTree);
			}
		}
	}

	@Override
	public void buildBuilding(ArrayList<ArrayList<Tile>> tiles, int x, int y, int rotation) {
		tiles.get(x).get(y).setOccupiedWoodCutter(0, this);
		tiles.get(x + 1).get(y).setOccupiedWoodCutter(1, this);
		tiles.get(x + 1).get(y + 1).setOccupiedWoodCutter(2, this);
		tiles.get(x).get(y + 1).setOccupiedWoodCutter(3, this);

		woodcutterTiles[0] = tiles.get(x).get(y);
		woodcutterTiles[1] = tiles.get(x + 1).get(y);
		woodcutterTiles[2] = tiles.get(x + 1).get(y + 1);
		woodcutterTiles[3] = tiles.get(x).get(y + 1);

		centerPosition = new Vector(tiles.get(x).get(y).getPosition().x + 32, tiles.get(x).get(y).getPosition().y + 32);

		OutlineAvailability(tiles, x, y, 3);
		cutting = false;
	}

	private boolean[][] defineCircle(boolean[][] grid, int centerX, int centerY, int radius) {
		for (int x = 0; x < grid.length; x++ ) {
			for (int y = 0; y < grid[x].length; y++ ) {
				int a = x - centerX;
				int b = y - centerY;

				if (a*a+b*b <= radius*radius+1) {
					grid[x][y] = true;
				}
			}
		}
		return grid;
	}

	private void OutlineAvailability(ArrayList<ArrayList<Tile>> tiles, int tileX, int tileY, int radius ) {
		boolean[][] grid = new boolean[gridSizeWidth][gridSizeHeight];
		for (int x = 0; x < grid.length; x++ ) {
			for (int y = 0; y < grid[x].length; y++) {
				grid[x][y] = false;
			}
		}

		defineCircle(grid, radius*2, radius*2, radius);
		defineCircle(grid, radius*2+1, radius*2, radius);
		defineCircle(grid, radius*2, radius*2+1, radius);
		defineCircle(grid, radius*2+1, radius*2+1, radius);

		int index = 0;
		for (int x = 0; x < grid.length; x++ ) {
			for (int y = 0; y < grid[x].length; y++) {
				if (grid[x][y] ) {
					if ((((x+(tileX-(radius*2))) >= 0) && ((y+(tileY-(radius*2))) >= 0)) && (((x+(tileX-(radius*2))) < gridSizeWidth) && ((y+(tileY-(radius*2))) < gridSizeHeight))) {
						// We will set all available tiles for the Woodcutter, these are maximum 48.
						Tile tile = tiles.get(x + (tileX - (radius * 2))).get(y + (tileY - (radius * 2)));
						if (tile.getRegionOwned() && tile.getOccupied() != 2) {
							// If we don't own the region yet we can't chop wood there.
							regionTiles[index] = tile;
							index ++;
						}
					}
				}
			}
		}
	}

	public Tile[] getWoodCutterTiles() {
		return woodcutterTiles;
	}
}