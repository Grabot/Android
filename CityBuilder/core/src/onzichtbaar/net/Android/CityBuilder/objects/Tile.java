package onzichtbaar.net.Android.CityBuilder.objects;

import Enums.TileType;
import onzichtbaar.net.Android.CityBuilder.load.Vector;

public class Tile 
{
	private TileType type;
	private int colour;
	private int resources;
	private final Vector position = new Vector( );
	private boolean wall = false;
	
	public Tile( Vector position, TileType type, int colour, boolean wall, int resources )
    {
            this.position.set( position );
            this.type = type;
            this.colour = colour;
            this.wall = wall;
            this.resources = resources;
    }
	
	public void setAttributes( TileType type, int colour, boolean wall, int resources )
	{
		this.type = type;
		this.colour = colour;
		this.wall = wall;
		this.resources = resources;
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
