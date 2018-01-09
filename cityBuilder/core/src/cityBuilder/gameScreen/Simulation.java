package cityBuilder.gameScreen;

import java.util.ArrayList;

import cityBuilder.gameScreen.buildings.Farm;
import cityBuilder.gameScreen.buildings.Road;
import cityBuilder.gameScreen.buildings.Warehouse;
import cityBuilder.gameScreen.buildings.WoodCutter;
import cityBuilder.load.Data;
import cityBuilder.load.Item;
import cityBuilder.load.Vector;
import cityBuilder.load.build.buildActor;
import cityBuilder.load.build.buildInventory;
import cityBuilder.load.inventory.Inventory;
import cityBuilder.load.inventory.InventoryActor;
import cityBuilder.objects.Citizen;
import cityBuilder.objects.Tile;
import cityBuilder.gameScreen.buildings.Wood;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class Simulation extends Data {
	private Citizen[] citizen = new Citizen[100];

	public Tile[][] tiles;

	private ArrayList<Citizen> citizens = new ArrayList<Citizen>();
	private ArrayList<Farm> farms = new ArrayList<Farm>();
	private ArrayList<WoodCutter> woodcutters = new ArrayList<WoodCutter>();
	private ArrayList<Warehouse> warehouses = new ArrayList<Warehouse>();
	private ArrayList<Road> roads = new ArrayList<Road>();
	private ArrayList<Wood> woods = new ArrayList<Wood>();

	private float width = 0;
	private float height = 0;

	private float touchX = 0;
	private float touchY = 0;

	private float cameraX = 0;
	private float cameraY = 0;
	private float cameraZ = 1;

	private float distance = 0;

	private int pressed = 0;

	private boolean infoboxTouch = false;
	private boolean touched_down = false;
	private boolean back_pressed = false;
	private boolean fast_press = false;
	private boolean down_pressed = false;
	private boolean up_pressed = false;
	private boolean scrolling = false;
	private int globalRotation = 0;

	private boolean buildingFarm = false;
	private boolean buildingWoodCutter = false;
	private boolean buildingWareHouse = false;
	private boolean buildingRoad = false;
	private boolean buildingTree = false;

	float touch_distance_x = 999;
	float touch_distance_y = 999;
	float sec = 0.0f;

	public static final String LOG = Simulation.class.getSimpleName();

	private GameScreen game;

	private Inventory inventory;
	private InventoryActor inventoryActor;
	private TextureAtlas atlas;

	public Simulation(GameScreen game, Inventory inventory, InventoryActor inventoryActor,
					  buildInventory builder, buildActor actor, ArrayList<Citizen> citizens,
					  Tile[][] tiles, TextureAtlas atlas ) {
		this.tiles = tiles;
		this.game = game;
		this.citizens = citizens;
		this.inventory = inventory;
		this.inventoryActor = inventoryActor;
		this.atlas = atlas;
		globalRotation = 0;
		populate();
	}

	public void populate() {
		for ( int x = 0; x < tiles.length; x++ ) {
			for (int y = 0; y < tiles[x].length; y++ ) {
				if (tiles[x][y].getOccupied() == 3 ) {
					woods.add(tiles[x][y].getWood());
				}
			}
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

		//every second updates
		sec = (sec + delta);
		if( sec >= 1.00000f ) {
			updateBuildings();
			sec = (sec - 1.00000f);
		}
	}

	private void updateBuildings() {
		for( int i = 0; i < farms.size(); i++ ) {
			farms.get(i).update();
		}

		for( int i = 0; i < woodcutters.size(); i++ ) {
			woodcutters.get(i).update();
		}

		for( int i = 0; i < warehouses.size(); i++ ) {
			warehouses.get(i).update();
		}

		for( int i = 0; i < woods.size(); i++ ) {
			woods.get(i).update();
		}
	}

	public void BuildFarm() {
		buildingFarm = true;
	}

	public void BuildWoodCutter()
	{
		buildingWoodCutter = true;
	}

	public void BuildWarehouse() {
		buildingWareHouse = true;
	}

	public void buildRoad() {
		buildingRoad = true;
	}

	public void buildTree() {
		buildingTree = true;
	}

	public void BuildingConfirmation( int building, int rotation, int x, int y )
	{
		//set all tiles that occupy the farm

		if( building == 0 ) {
			Farm farm = new Farm(rotation, atlas);
			farm.buildBuilding(tiles, x, y, rotation);
			farms.add(farm);
			inventory.takeItem( "farm" );
			buildingFarm = false;
		} else if( building == 1 ) {
			Warehouse warehouse = new Warehouse(rotation, atlas);
			warehouse.buildBuilding(tiles, x, y, rotation);
			inventory.takeItem( "fisherMan" );
			warehouses.add(warehouse);
			buildingWareHouse = false;
		} else if( building == 2 ) {
			WoodCutter woodcutter = new WoodCutter(rotation, atlas);
			woodcutter.buildBuilding(tiles, x, y, rotation);
			inventory.takeItem( "woodCutter" );
			woodcutters.add(woodcutter);
			buildingWoodCutter = false;
		} else if( building == 3) {

			Wood wood = new Wood(null, rotation, atlas);
			wood.buildBuilding(tiles, x, y, rotation);

			inventory.takeItem("treeSeed");
			woods.add(wood);
			// this is a tree.
			buildingTree = false;
		}
	}

	public void buildingConfirmationWood(int rotation, ArrayList<Tile> woodSelected) {
		for (Tile tile : woodSelected) {
			Wood wood = new Wood(null, rotation, atlas);
			wood.buildBuilding(tiles, tile.getX(), tile.getY(), rotation);
			woods.add(wood);
			inventory.takeItem("treeSeed");
		}
		buildingTree = false;
	}

	public void BuildingConfirmationRoad( int rotation, ArrayList<Tile> roadSelected ) {
		for (Tile tile : roadSelected) {
			Road road = new Road(rotation, atlas);
			road.buildBuilding(tiles, tile.getX(), tile.getY(), rotation);
			roads.add(road);
			// build road
			inventory.takeItem("road");
		}
		checkRoads();
		buildingRoad = false;
	}

	private void checkRoads() {
		// this is called after a road is placed, it will check all roads and if there are adjacent
		for (Road road : roads) {
			Tile[] adjacentRoads = road.getAdjacentRoads();
			for (int i = 0; i < adjacentRoads.length; i++ ) {
				if (adjacentRoads[i].getOccupied() == 5) {
					road.setAdjacent(i, true);
				} else {
					road.setAdjacent(i, false);
				}
			}
		}
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
		touch_distance_x = ((touchX - (ScreenWidth / 2)) * cameraZ + cameraX);
		touch_distance_y = (((touchY - (ScreenHeight / 2)) * cameraZ - cameraY) * -1);
	}

	public int tileTouchX() {
		int x = Math.round((touch_distance_x)/43);
		int y = Math.round((touch_distance_y)/21);
		int tileX = ((x - y) / 2);
		int tileY = y+((x-y)/2);
		if (globalRotation == 0) {
			return tileX;
		} else if (globalRotation == 1) {
			return tileY;
		}  else if (globalRotation == 2) {
			return tiles.length - tileX - 1;
		} else if (globalRotation == 3) {
			return (tiles.length - tileY - 1);
		} else {
			return 0;
		}
	}

	public int tileTouchY() {
		int x = Math.round((touch_distance_x)/43);
		int y = Math.round((touch_distance_y)/21);
		int tileX = ((x - y) / 2);
		int tileY = y+((x-y)/2);
		if (globalRotation == 0) {
			return tileY;
		} else if (globalRotation == 1) {
			return (tiles.length - tileX - 1);
		} else if (globalRotation == 2) {
			return tiles.length - tileY - 1;
		} else if (globalRotation == 3) {
			return tileX;
		} else {
			return 0;
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

	public boolean getBuildingFarm()
	{
		return buildingFarm;
	}

	public boolean getBuildingWoodCutter()
	{
		return buildingWoodCutter;
	}

	public boolean getBuildingWarehouse() {
		return buildingWareHouse;
	}

	public boolean getBuildingRoad() {
		return buildingRoad;
	}

	public boolean getBuildingTree() {
		return buildingTree;
	}

	public boolean getBuildingFase() {
		return buildingRoad || buildingWareHouse || buildingFarm || buildingWoodCutter || buildingTree;
	}

	public int getRoadSize() {
		return inventory.checkInventory(Item.road);
	}

	public int getWoodSize() {
		return inventory.checkInventory(Item.treeSeed);
	}

	public void globalRotate() {
		globalRotation++;
		if (globalRotation == 4) {
			globalRotation = 0;
		}
	}
}
