package onzichtbaar.net.Android.CityBuilder.load;

import onzichtbaar.net.Android.CityBuilder.gameScreen.Simulation;

import com.badlogic.gdx.scenes.scene2d.ui.TextField;

public class DisplayInfoBox extends Data
{
	
	public DisplayInfoBox()
	{
	}
	
	public void displayInfoBox( TextField tileInfo, TextField resourceInfo, Simulation simulation, int type )
	{
		tileInfo.setText( type + "simulation.tiles.get(type).type" );
		if( simulation.tiles.get(type).type == grass )
		{
			tileInfo.setText( type + " grass" );
		}
		else if( simulation.tiles.get(type).type == wood )
		{
			tileInfo.setText( type + " wood" );
		}
		else if( simulation.tiles.get(type).type == town )
		{
			tileInfo.setText( type + " town" );
		}
		else if( simulation.tiles.get(type).type == sheep )
		{
			tileInfo.setText( type + " sheep" );
		}
		else if( simulation.tiles.get(type).type == desert )
		{
			tileInfo.setText( type + " desert" );
		}
		else if( simulation.tiles.get(type).type == dwayne )
		{
			tileInfo.setText( type + " dwayne" );
		}
		else if( simulation.tiles.get(type).type == iron )
		{
			tileInfo.setText( type + " iron" );
		}
		else if( simulation.tiles.get(type).type == gold )
		{
			tileInfo.setText( type + " gold" );
		}
		else if( simulation.tiles.get(type).type == water )
		{
			tileInfo.setText( type + " water" );
		}
		else if( simulation.tiles.get(type).type == coal )
		{
			tileInfo.setText( type + " coal" );
		}
		else
		{
			tileInfo.setText( "nothing selected" );
		}
		tileInfo.setVisible( true );
		
		resourceInfo.setText( "resources: " + simulation.tiles.get(type).resources );
		resourceInfo.setVisible( true );
	}

}
