package CityBuilder.gameScreen;

import java.util.ArrayList;

import CityBuilder.load.Data;
import CityBuilder.load.build.buildActor;
import CityBuilder.load.build.buildInventory;
import CityBuilder.load.inventory.Inventory;
import CityBuilder.load.inventory.InventoryActor;
import CityBuilder.objects.Citizen;
import CityBuilder.objects.Tile;

import com.badlogic.gdx.Gdx;

public class Simulation extends Data {
	private Citizen[] citizen = new Citizen[100];

	public ArrayList<Tile> tiles = new ArrayList<Tile>();

	private ArrayList<Citizen> citizens = new ArrayList<Citizen>();

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

	private boolean[] farmTiles = new boolean[626];
	private boolean BuildingFarm = false;
	
	private int selectedTile = -1;

	float touch_distance_x = 999;
	float touch_distance_y = 999;

	private boolean MiningSequence = false;

	public static final String LOG = Simulation.class.getSimpleName();

	private GameScreen game;
	
	private Inventory inventory;
	private InventoryActor inventoryActor;

	public Simulation(GameScreen game, Inventory inventory, InventoryActor inventoryActor, buildInventory builder, buildActor actor, ArrayList<Citizen> citizens, ArrayList<Tile> tiles ) {
		this.tiles = tiles;
		this.game = game;
		this.citizens = citizens;
		this.inventory = inventory;
		this.inventoryActor = inventoryActor;

		populate();
	}

	public void populate() {
		for( int i = 0; i < farmTiles.length; i++ )
		{
			farmTiles[i] = false;
		}
		Gdx.app.log(Simulation.LOG, "Game Screen populated");
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
	}
	
	public void BuildFarm()
	{
		BuildingFarm = true;
	}
	
	public void FarmBuildingConfirmation( int selectedTile )
	{
		System.out.println("Build Farm on tile: " + selectedTile );
		tiles.get(selectedTile).setOccupied(1);
		tiles.get(selectedTile+1).setOccupied(1);
		tiles.get(selectedTile-gridSizeWidth).setOccupied(1);
		tiles.get(selectedTile-(gridSizeWidth-1)).setOccupied(1);
		
		BuildingFarm = false;
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

	private void checkTouch() 
	{
		//no touch detection in the panel sections
		if( !(touchX > 950 ))
		{
			touch_distance_x = ((touchX - (ScreenWidth / 2)) * cameraZ + cameraX);
			touch_distance_y = (((touchY - (ScreenHeight / 2)) * cameraZ - cameraY) * -1);
		}
	}

	public int TileTouch()
	{
		int tileX = Math.round((touch_distance_x)/64);
		int tileY = Math.round((touch_distance_y)/64);
		tileY = ((tileY-24)*-1);
		
		if (touched_down) 
		{
			selectedTile = ((tileY*25)+tileX);
			if (pressed >= 20) 
			{
				if (!scrolling) 
				{
					MiningSequence = true;
					miningProgress += 5;

					if (miningProgress >= 585) 
					{
						addResources();
						miningProgress = 0;
					}
				}
			}
			
			if( scrolling )
			{
				pressed = 0;
				selectedTile = -1;
				miningProgress = 0;
				MiningSequence = false;
			}

			pressed++;
		}
		else
		{
			miningProgress = 0;
			MiningSequence = false;
			pressed = 0;
		}
		
		return selectedTile;
	}
	
	private void addResources()
	{
		tiles.get(selectedTile).setResources(tiles.get(selectedTile).getResources() - 1);
		if (inventory.checkInventoryTest(tiles.get(selectedTile).getType().toString()) == -1 )
		{
			if( tiles.get(selectedTile).getType().toString() == "wood" )
			{
				inventory.addItem(inventory.firstEmtpySlot(), 0);
			}
			else if( tiles.get(selectedTile).getType().toString() == "stone" )
			{
				inventory.addItem(inventory.firstEmtpySlot(), 2);
			}
			else if( tiles.get(selectedTile).getType().toString() == "iron" )
			{
				inventory.addItem(inventory.firstEmtpySlot(), 4);
			}
		}
		else
		{
			if( tiles.get(selectedTile).getType().toString() == "wood" )
			{
				inventory.addItem(inventory.findResourceSlot("wood"), 0);
			}
			else if( tiles.get(selectedTile).getType().toString() == "stone" )
			{
				inventory.addItem(inventory.findResourceSlot("stone"), 2);
			}
			else if( tiles.get(selectedTile).getType().toString() == "iron" )
			{
				inventory.addItem(inventory.findResourceSlot("iron"), 4);
			}
		}
		
		inventoryActor.clearLabels();
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

	public boolean getMining() {
		return MiningSequence;
	}

	public int getMiningProgress() {
		return miningProgress;
	}
	
	public boolean getBuildingFarm()
	{
		return BuildingFarm;
	}
}
