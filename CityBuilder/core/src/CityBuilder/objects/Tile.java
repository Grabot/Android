package CityBuilder.objects;

import CityBuilder.enums.TileType;
import CityBuilder.load.Vector;
import CityBuilder.objects.attributes.Grass;
import CityBuilder.objects.attributes.Iron;
import CityBuilder.objects.attributes.Stone;
import CityBuilder.objects.attributes.Town;
import CityBuilder.objects.attributes.Water;
import CityBuilder.objects.attributes.Wood;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class Tile 
{
	private TileType type;
	private int colour;
	private int resources;
	private final Vector position = new Vector( );
	private boolean wall = false;
	
	private Grass grass;
	private Water water;
	private Iron iron;
	private Stone stone;
	private Wood wood;
	private Town town;
	
	public Tile( Vector position )
    {
            this.position.set( position );
    }
	
	public void setAttributes( TileType type, int colour, boolean wall, int resources )
	{
		this.type = type;
		this.colour = colour;
		this.wall = wall;
		this.resources = resources;
		
		if( type.toString().equals("grass") )
		{
			grass = new Grass( this );
		}
		else if( type.toString().equals("water") )
		{
			water = new Water( this );
		}
		else if( type.toString().equals("iron") )
		{
			iron = new Iron( this );
		}
		else if( type.toString().equals("stone") )
		{
			stone = new Stone( this );
		}
		else if( type.toString().equals("wood") )
		{
			wood = new Wood( this );
		}
		else if( type.toString().equals("town") )
		{
			town = new Town( this );
		}
	}
	
	public void drawTile( Batch batch, TextureAtlas atlas )
	{
		if( type.toString().equals("grass") )
		{
			grass.draw( batch, atlas );
		}
		else if( type.toString().equals("water") )
		{
			water.draw( batch, atlas );
		}
		else if( type.toString().equals("iron") )
		{
			iron.draw( batch, atlas );
		}
		else if( type.toString().equals("stone") )
		{
			stone.draw( batch, atlas );
		}
		else if( type.toString().equals("wood") )
		{
			wood.draw( batch, atlas );
		}
		else if( type.toString().equals("town") )
		{
			town.draw( batch, atlas );
		}
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

	public boolean isWall() {
		return wall;
	}

	public void setWall(boolean wall) {
		this.wall = wall;
	}

	public Vector getPosition() {
		return position;
	}

	
}