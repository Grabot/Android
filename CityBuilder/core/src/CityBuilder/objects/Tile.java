package CityBuilder.objects;

import CityBuilder.enums.TileType;
import CityBuilder.load.Vector;
import CityBuilder.objects.attributes.FarmTex;
import CityBuilder.objects.attributes.Grass;
import CityBuilder.objects.attributes.Iron;
import CityBuilder.objects.attributes.Shore;
import CityBuilder.objects.attributes.Stone;
import CityBuilder.objects.attributes.Water;
import CityBuilder.objects.attributes.Wood;
import CityBuilder.objects.attributes.WoodCutterTex;

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
	private FarmTex farmtex;
	private WoodCutterTex woodcuttertex;
	
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
		else if( type.toString().equals("iron") )
		{
			iron = new Iron( this, atlas );
		}
		else if( type.toString().equals("stone") )
		{
			stone = new Stone( this, atlas );
		}
		else if( type.toString().equals("wood") )
		{
			wood = new Wood( this, atlas );
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
		else if( type.toString().equals("iron") )
		{
			iron.draw( batch );
		}
		else if( type.toString().equals("stone") )
		{
			stone.draw( batch );
		}
		else if( type.toString().equals("wood") )
		{
			wood.draw( batch );
		}
		else if( type.toString().equals("shore") )
		{
			shore.draw( batch );
		}
	}
	
	public void drawFarm( Batch batch )
	{
		farmtex.draw( batch );
	}
	
	public void drawWoodCutter( Batch batch )
	{
		woodcuttertex.draw( batch );
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

	public void setOccupied(int occupied, int buildingPosition) {
		this.occupied = occupied;
		this.buildingPosition = buildingPosition;
		if( occupied == 1 )
		{
			farmtex = new FarmTex( this, buildingPosition, atlas );
		}
		else if( occupied == 2 )
		{
			woodcuttertex = new WoodCutterTex( this, buildingPosition, atlas );
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
