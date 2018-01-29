package cityBuilder.objects;

import cityBuilder.enums.TileType;
import cityBuilder.gameScreen.buildings.Farm;
import cityBuilder.gameScreen.buildings.Road;
import cityBuilder.gameScreen.buildings.Warehouse;
import cityBuilder.gameScreen.buildings.WoodCutter;
import cityBuilder.load.Vector;
import cityBuilder.objects.attributes.Grass;
import cityBuilder.objects.attributes.Iron;
import cityBuilder.objects.attributes.Shore;
import cityBuilder.objects.attributes.Stone;
import cityBuilder.objects.attributes.Water;
import cityBuilder.gameScreen.buildings.Wood;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.Random;

public class Tile
{
	private TileType type;
	private int colour;
	private int resources;
	private final Vector position = new Vector( );
	private int occupied = 0;
	private int x;
	private int y;
	private int buildingPosition = -1;

	private Grass grass;
	private Water water;
	private Shore shore;
	private Iron iron;
	private Stone stone;
	private Wood wood;
	private Farm farm;
	private WoodCutter woodCutter;
	private Warehouse warehouse;
	private Road road;
	private TextureAtlas atlas;

	private boolean regionOwned;

	private TextureRegion SquareGreySmall2;

	private Random random;

	public Tile( Vector position, TextureAtlas atlas ) {
		this.position.set( position );
		this.atlas = atlas;
		random = new Random();
		regionOwned = true;

		SquareGreySmall2 = atlas.findRegion("selectedIso");
	}

	public void setAttributes( TileType type, int colour, int occupied, int resources, int tilePosition )
	{
		this.type = type;
		this.colour = colour;
		this.occupied = occupied;
		this.resources = resources;

		if( type.toString().equals("grass") )
		{
			grass = new Grass( this, atlas );
		}
		else if( type.toString().equals("water") )
		{
			water = new Water( this, atlas );
		}
		else if( type.toString().equals("shore") )
		{
			shore = new Shore( this, tilePosition, atlas );
		}
	}

	public void drawTile( Batch batch )
	{
		if( type.toString().equals("grass") )
		{
			grass.draw( batch );
		}
		else if( type.toString().equals("water") )
		{
			water.draw( batch );
		}
		else if( type.toString().equals("shore") )
		{
			shore.draw( batch );
		}
	}

	public void drawRegionOwned( Batch bitch ) {
		if (!regionOwned) {
			bitch.draw(SquareGreySmall2, -32 + this.getPosition().x , -32 + this.getPosition().y, 32, 32, 64, 64, 1, 1, -90, false);
		}
	}

	public void drawWoods( Batch batch, int globalRotation ) {
		wood.render( batch, buildingPosition, this.getPosition().x, this.getPosition().y, globalRotation );
	}

	public void drawFarm( Batch batch, int globalRotation ) {
		farm.render( batch, buildingPosition, this.getPosition().x, this.getPosition().y, globalRotation );
	}

	public void drawWoodCutter( Batch batch, int globalRotation ) {
		woodCutter.render( batch, buildingPosition, this.getPosition().x, this.getPosition().y, globalRotation );
	}

	public void drawWarehouse( Batch batch, int globalRotation ) {
		warehouse.render( batch, buildingPosition, this.getPosition().x, this.getPosition().y, globalRotation );
	}

	public void drawRoads( Batch batch, int globalRotation ) {
		road.render( batch, 0, this.getPosition().x, this.getPosition().y, globalRotation );
	}

	public TileType getType() {
		return type;
	}

	public void setType(TileType type) {
		this.type = type;
	}

	public int getColour() {
		return colour;
	}

	public void setColour(int colour) {
		this.colour = colour;
	}

	public int getResources() {
		return resources;
	}

	public void setResources(int resources) {
		this.resources = resources;
	}

	public int getOccupied() {
		return occupied;
	}

	public void setOccupiedRoad(int buildingPosition, Road road) {
		this.occupied = 5;
		this.buildingPosition = buildingPosition;
		this.road = road;
	}

	public void setOccupiedFarm(int buildingPosition, Farm farm) {
		this.occupied = 1;
		this.buildingPosition = buildingPosition;
		this.farm = farm;
	}

	public void setOccupiedWoodCutter(int buildingPosition, WoodCutter woodCutter) {
		this.occupied = 2;
		this.buildingPosition = buildingPosition;
		this.woodCutter = woodCutter;
	}

	public void setOccupiedWarehouse(int buildingPosition, Warehouse warehouse) {
		this.occupied = 4;
		this.buildingPosition = buildingPosition;
		this.warehouse = warehouse;
	}

	public void setOccupiedWood(int buildingPosition, int rotation, Wood wood) {
		this.occupied = 3;
		this.buildingPosition = buildingPosition;
		this.wood = wood;
		this.wood.setLife(random.nextInt(100));
	}

	public void setOccupied(int occupied, int buildingPosition, int rotation) {

		this.occupied = occupied;
		this.buildingPosition = buildingPosition;

		if( occupied == 3 ) {
			// woods
			wood = new Wood(this, rotation, atlas);
		}

	}

	public Vector getPosition() {
		return position;
	}

	public void setPosition(Vector position) {
		this.position.set( position );
	}

	public void setBuildingPosition(int buildingPosition) {
		this.buildingPosition = buildingPosition;
	}

	public int getBuildingPosition()
	{
		return buildingPosition;
	}

	public Wood getWood() {
		return wood;
	}

	public Warehouse getWarehouse() {
		return warehouse;
	}

	public Farm getFarm() {
		return farm;
	}

	public WoodCutter getWoodCutter() {
		return woodCutter;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getX() {
		return x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getY() {
		return y;
	}

	public boolean getRegionOwned() {
		return regionOwned;
	}

	public void setRegionOwned(boolean regionOwned) {
		this.regionOwned = regionOwned;
	}

	public Tile getTile() {
		return this;
	}
}
