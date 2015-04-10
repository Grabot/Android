package GameScreen;

import java.util.ArrayList;

import object.Citizen;
import object.Vector;
import tile.Tile;
import Levels.Level;
import Levels.Level1;
import Load.Data;

import com.badlogic.gdx.Gdx;

public class Simulation extends Data {
	private Citizen[] citizen = new Citizen[100];


	private ArrayList<Citizen> citizens = new ArrayList<Citizen>();

	private Level level;

	private float emma = 0;
	private float watson = 0;

	private float width = 0;
	private float height = 0;

	private float touchX = 0;
	private float touchY = 0;

	private float cameraX = 0;
	private float cameraY = 0;
	private float cameraZ = 1;

	private float distance = 0;

	private int pressed = 0;
	private int miningProgress = 0;

	private boolean touched_down = false;
	private boolean back_pressed = false;
	private boolean fast_press = false;
	private boolean down_pressed = false;
	private boolean up_pressed = false;
	private boolean scrolling = false;

	private boolean tileTouched = false;
	private boolean touchedBox = true;

	float touch_distance_x = 999;
	float touch_distance_y = 999;

	private boolean MiningSequence = false;

	public static final String LOG = Simulation.class.getSimpleName();

	private GameScreen game;

	public Simulation(GameScreen game, ArrayList<Citizen> citizens) {
		this.game = game;
		this.citizens = citizens;

		level = new Level1();
	}

	

	public void variables(float touchX, float touchY, float width, float height, boolean touched_down, boolean fast_press, boolean back_pressed, boolean down_pressed, boolean up_pressed, float distance) {
		this.width = width;
		this.height = height;

		this.touchX = touchX;
		this.touchY = touchY;

		this.touched_down = touched_down;
		this.back_pressed = back_pressed;
		this.fast_press = fast_press;
		this.down_pressed = down_pressed;
		this.up_pressed = up_pressed;
		this.distance = distance;
	}

	public void update(float delta) {
		checkTouch();
		//TileTouch();
	}

	public void updateScroll(float cameraX, float cameraY, float cameraZ) {
		this.cameraX = cameraX;
		this.cameraY = cameraY;
		this.cameraZ = cameraZ;
	}

	public void isScrolling(boolean scrolling) {
		this.scrolling = scrolling;
	}

	public void endGame(int i) {
		game.Game_Finished(i, citizens);
	}

	private void checkTouch() {
		touch_distance_x = ((touchX - (ScreenWidth / 2)) * cameraZ + cameraX);
		touch_distance_y = (((touchY - (ScreenHeight / 2)) * cameraZ - cameraY) * -1);
	}

	public void BuildWall(boolean build, int selectedTile) {
		if (build) {
			if (game.Wood >= 50 && game.Stone >= 100) {
				game.Wood = game.Wood - 50;
				game.Stone = game.Stone - 100;
			} else {
				// not enough resources
			}
		} else if (!build) {
			game.Wood = game.Wood + 50;
			game.Stone = game.Stone + 100;
		}
	}

	/*
	private void TileTouch() {

		if (tileTouched) {
			if (touched_down) {
				pressed++;

				if (pressed >= 20) {
					if (!scrolling) {
						MiningSequence = true;
						miningProgress += 5;

						if (miningProgress >= 585) {
							for (int i = 1; i < tiles.size(); i++) {
								if (tileSelected[i]) {
									tiles.get(i).setResources(tiles.get(i).getResources() - 1);
								}
							}
							System.out.println("done mining");
							miningProgress = 0;
						}
					}
				} else {
					miningProgress = 0;
					MiningSequence = false;
				}

				for (int i = 1; i < tiles.size(); i++) {
					tileSelected[i] = false;

				}
				tileTouched = false;
			}
		}

		if (fast_press) {
			for (int k = 1; k < tiles.size(); k++) {
				if ((tiles.get(k).getPosition().distance(new Vector(touch_distance_x, touch_distance_y)) < ((tileWidth / 2) + 1)) && !tileTouched) {
					tileSelected[k] = true;
					tileTouched = true;
				}
			}
		}

		if (!touched_down) {
			miningProgress = 0;
			pressed = 0;
			MiningSequence = false;
		}
	}

	public boolean getTouchedDown() {
		return touched_down;
	}

	public float getTouchX() {
		return touchX;
	}

	public float getTouchY() {
		return touchY;
	}

	public boolean getDown() {
		return down_pressed;
	}

	public boolean getUp() {
		return up_pressed;
	}

	public float getDistance() {
		return distance;
	}

	public boolean[] getTileTouch() {
		return tileSelected;
	}

	public boolean getMining() {
		return MiningSequence;
	}

	public int getMiningProgress() {
		return miningProgress;
	}
	
	*/
}
