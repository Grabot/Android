package onzichtbaar.net.Android.CityBuilder.objects;

import onzichtbaar.net.Android.CityBuilder.load.Vector;

public class Tile 
{
	public int type;
	public int colour;
	public int resources;
	public final Vector position = new Vector( );
	public boolean wall = false;
	
	public Tile( Vector position, int type, int colour, boolean wall, int resources )
    {
            this.position.set( position );
            this.type = type;
            this.colour = colour;
            this.wall = wall;
            this.resources = resources;
    }
	
	public void setType( int type )
	{
		this.type = type;
	}
	
	public void setColour( int colour )
	{
		this.colour = colour;
	}
	
	public void setResources( int resources )
	{
		this.resources = resources;
	}
	
	public void setWall( boolean wall )
	{
		this.wall = wall;
	}
	
	public void setAttributes( int type, int colour, boolean wall, int resources )
	{
		this.type = type;
		this.colour = colour;
		this.wall = wall;
		this.resources = resources;
	}

}
