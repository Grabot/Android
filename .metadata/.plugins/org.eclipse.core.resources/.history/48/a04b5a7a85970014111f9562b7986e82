package onzichtbaar.net.Android.CityBuilder.load;

import onzichtbaar.net.Android.CityBuilder.gameScreen.Simulation;

import com.badlogic.gdx.scenes.scene2d.ui.TextField;

public class DisplayInfoBox extends Data
{
	
	public DisplayInfoBox()
	{
		
	}
	
	public void displayInfoBox( TextField tileInfo, Simulation simulation, int type )
	{
		if( simulation.tiles.get(type).type == grass )
		{
			tileInfo.setText( "grass" );
		}
		else if( simulation.tiles.get(type).type == wood )
		{
			tileInfo.setText( "wood" );
		}
		else if( simulation.tiles.get(type).type == town )
		{
			tileInfo.setText( "town" );
		}
		else if( simulation.tiles.get(type).type == sheep )
		{
			tileInfo.setText( "sheep" );
		}
		else if( simulation.tiles.get(type).type == desert )
		{
			tileInfo.setText( "desert" );
		}
		else if( simulation.tiles.get(type).type == dwayne )
		{
			tileInfo.setText( "dwayne" );
		}
		tileInfo.setVisible( true );
	}

}
