package cityBuilder.gameScreen.buildings;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
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
	private TextureRegion woodCutterTexture;
	private TextureRegion SquareTileRegionAllowed;

	private Random random;

	private Tile woodcut;
	private boolean cutting;
	private Vector centerPosition;
	private float distanceWoodCutterToTree;
	private float distanceTreeToWoodCutter;
	private float woodcutTime;
	private float processTime;
	private int travelSpeed;
	private int amountOfLogs;
	private int doneProcessing;
	private int fullProcessing;
	private int restingPeriod;
	private int standardProcessing;
	private int standardWoodcutting;
	private int standardRestingPeriod;

	private int fullStock;

	BitmapFont font;

	public WoodCutter(int rotation, TextureAtlas atlas)
	{
		woodcutterTiles = new Tile[4];
		regionTiles = new Tile[48];
		this.rotation = rotation;
		woodCutterTexture = atlas.findRegion("farm");
		SquareTileRegionAllowed = atlas.findRegion("SquareGreenSmall");

		random = new Random();
		woodcut = null;
		standardProcessing = 3;
		standardWoodcutting = 3;
		standardRestingPeriod = 15;
		woodcutTime = standardWoodcutting;
		processTime = standardProcessing;
		restingPeriod = standardRestingPeriod;
		travelSpeed = 60;
		amountOfLogs = 0;
		doneProcessing = 0;
		fullProcessing = 0;
		fullStock = 600;

		font = new BitmapFont();
		font.getData().setScale(2);
	}

	@Override
	public void render(Batch batch, int position, float x, float y) {
		if( position == 0 ) {
			batch.draw( woodCutterTexture, x - 50, y + 55, 0, 0, 96, 180, 1, 1, -90, false);
		}
	}

	public void drawInformation( Batch batch ) {

		if (doneProcessing != 0) {
			font.draw(batch, "stock: " + amountOfLogs, centerPosition.x-32, centerPosition.y+120-(doneProcessing/5));
			doneProcessing -= 1;
		}

		if (amountOfLogs == 10 && fullStock == 0) {
			if (fullProcessing != 0) {
				font.draw(batch, "stock is full", centerPosition.x - 32, centerPosition.y + 120 - (fullProcessing / 5));
				fullProcessing -= 1;
			} else {
				fullStock = 600;
			}
		} else if (amountOfLogs == 10) {
			fullStock -= 1;
			if (fullStock == 0) {
				fullProcessing = 600;
			}
		}
	}

	public void update() {
		// If the woodcutter has 10 logs and they are not picked up, he will stop working.
		if (amountOfLogs != 10) {
			// after he's done working he first needs to rest.
			if (restingPeriod != 0) {
				// The cutting boolean indicates that the woodcutter is ready to work.
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
						woodcut = treeTiles.get(random.nextInt(treeTiles.size()));
						cutting = true;
						// We set a distance that the woodcutter has to travel.
						distanceWoodCutterToTree = centerPosition.distance(woodcut.getPosition());
						distanceTreeToWoodCutter = distanceWoodCutterToTree;
					}
				} else {
					if (distanceWoodCutterToTree <= 0) {
						distanceWoodCutterToTree = 0;
						// The woodcutter has arrived at the tree and can start cutting it down!
						if (woodcutTime == 0) {
							// We introduce a bit of randomness for how old the tree is when it is newly planted.
							woodcut.getWood().setLife(random.nextInt(300));
							// indicates the woodcutting is done and the processing begins
							woodcutTime = -1;
						} else if (woodcutTime > 0) {
							// it takes time to cut wood
							woodcutTime -= 1;
						} else {
							if (distanceTreeToWoodCutter <= 0) {
								// Here the woodcutter is back home and he can process the log.
								if (processTime == 0) {
									// The tree is fully processed and it can be picked up!
									amountOfLogs += 1;
									doneProcessing = 600;
									cutting = false;
									processTime = standardProcessing;
									woodcutTime = standardWoodcutting;
									restingPeriod = 8;
								} else {
									// it takes time to process the log.
									processTime -= 1;
								}
							} else {
								distanceTreeToWoodCutter -= travelSpeed;
							}
						}
					} else {
						distanceWoodCutterToTree -= travelSpeed;
					}
				}
			} else {
				restingPeriod -= 1;
			}
		}
	}

	@Override
	public void buildBuilding(Tile[][] tiles, int x, int y, int rotation) {
		tiles[x][y].setOccupiedWoodCutter(0, this);
		tiles[x + 1][y].setOccupiedWoodCutter(1, this);
		tiles[x + 1][y + 1].setOccupiedWoodCutter(2, this);
		tiles[x][y + 1].setOccupiedWoodCutter(3, this);

		woodcutterTiles[0] = tiles[x][y];
		woodcutterTiles[1] = tiles[x + 1][y];
		woodcutterTiles[2] = tiles[x + 1][y + 1];
		woodcutterTiles[3] = tiles[x][y + 1];

		centerPosition = new Vector(tiles[x][y].getPosition().x + 32, tiles[x][y].getPosition().y + 32);

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

	private void OutlineAvailability(Tile[][] tiles, int tileX, int tileY, int radius ) {
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
						Tile tile = tiles[x + (tileX - (radius * 2))][y + (tileY - (radius * 2))];
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

	public int getAmountOfLogs() {
		return amountOfLogs;
	}
}