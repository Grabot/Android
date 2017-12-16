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
import cityBuilder.objects.attributes.Warehouse2Tex;
import cityBuilder.objects.attributes.WarehouseTex;
import cityBuilder.objects.attributes.Water;
import cityBuilder.objects.attributes.Wood;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class Tile
{
	private TileType type;
	private int colour;
	private int resources;
	private final Vector position = new Vector( );
	private int occupied = 0;
	private int tilePosition = 0;
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

	public Tile( Vector position, TextureAtlas atlas )
	{
		this.position.set( position );
		this.atlas = atlas;
	}

	public void setAttributes( TileType type, int colour, int occupied, int resources, int tilePosition )
	{
		this.type = type;
		this.colour = colour;
		this.occupied = occupied;
		this.resources = resources;
		this.tilePosition = tilePosition;

		if( type.toString().equals("grass") )
		{
			grass = new Grass( this, atlas );
		}
		else if( type.toString().equals("water") )
		{
			water = new Water( this, tilePosition, atlas );
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

	public void drawFarm( Batch batch ) {
		farm.render( batch, buildingPosition, this.getPosition().x, this.getPosition().y );
	}

	public void drawWoodCutter( Batch batch ) {
		woodCutter.render( batch, buildingPosition, this.getPosition().x, this.getPosition().y );
	}

	public void drawWarehouse( Batch batch ) {
		warehouse.render( batch, 0, this.getPosition().x, this.getPosition().y );
	}

	public void drawRoads( Batch batch ) {
		road.render( batch, 0, this.getPosition().x, this.getPosition().y );
	}

	public void drawWoods( Batch batch )
	{
		wood.draw( batch );
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
		this.occupied = 6;
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
		this.occupied = 5;
		this.buildingPosition = buildingPosition;
		this.warehouse = warehouse;
	}

	public void setOccupied(int occupied, int buildingPosition, int rotation) {

		this.occupied = occupied;
		this.buildingPosition = buildingPosition;

		if( occupied == 3 ) {
			// woods
			wood = new Wood(this, buildingPosition, rotation, atlas);
		}

	}

	public Vector getPosition() {
		return position;
	}

	public int getBuildingPosition()
	{
		return buildingPosition;
	}
}
