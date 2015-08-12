package CityBuilder.load;

import CityBuilder.enums.TileType;
import CityBuilder.gameScreen.Simulation;

import com.badlogic.gdx.scenes.scene2d.ui.TextField;

public class DisplayInfoBox extends Data
{
	
	public DisplayInfoBox()
	{
	}
	
	public void displayInfoBox( TextField tileInfo, TextField resourceInfo, Simulation simulation, int type )
	{
		if ( simulation.tiles.get(type).getOccupied() != 0 )
		{
			if ( simulation.tiles.get(type).getOccupied() == 1 )
			{
				tileInfo.setText("motherfucking Farm!" );
				int resources = 0;
				if(simulation.tiles.get(type).getType() == TileType.grass )
				{
					resources = resources + (simulation.tiles.get(type).getResources());
				}
				if( simulation.tiles.get(type+1).getOccupied() == 1 )
				{
					if(simulation.tiles.get(type+1).getType() == TileType.grass )
					{
						resources = resources + (simulation.tiles.get(type+1).getResources());
					}
				}
				if( simulation.tiles.get(type - 1).getOccupied() == 1 )
				{
					if(simulation.tiles.get(type - 1).getType() == TileType.grass)
					{
						resources = resources + (simulation.tiles.get(type-1).getResources());
					}
				}
				if( simulation.tiles.get(type-gridSizeWidth).getOccupied() == 1 )
				{
					if(simulation.tiles.get(type-gridSizeWidth).getType() == TileType.grass)
					{
						resources = resources + (simulation.tiles.get(type-gridSizeWidth).getResources());
					}
				}
				if( simulation.tiles.get(type+gridSizeWidth).getOccupied() == 1 )
				{
					if(simulation.tiles.get(type+gridSizeWidth).getType() == TileType.grass )
					{
						resources = resources + (simulation.tiles.get(type+gridSizeWidth).getResources());
					}
				}
				if( simulation.tiles.get(type-(gridSizeWidth + 1)).getOccupied() == 1 )
				{
					if(simulation.tiles.get(type-(gridSizeWidth + 1)).getType() == TileType.grass)
					{
						resources = resources + (simulation.tiles.get(type-(gridSizeWidth + 1)).getResources());
					}
				}
				if( simulation.tiles.get(type+(gridSizeWidth + 1)).getOccupied() == 1 )
				{
					if(simulation.tiles.get(type+(gridSizeWidth + 1)).getType() == TileType.grass )
					{
						resources = resources + (simulation.tiles.get(type+(gridSizeWidth + 1)).getResources());
					}
				}
				if( simulation.tiles.get(type-(gridSizeWidth - 1)).getOccupied() == 1 )
				{
					if(simulation.tiles.get(type-(gridSizeWidth - 1)).getType() == TileType.grass)
					{
						resources = resources + (simulation.tiles.get(type-(gridSizeWidth - 1)).getResources());
					}
				}
				if( simulation.tiles.get(type+(gridSizeWidth - 1)).getOccupied() == 1 )
				{
					if(simulation.tiles.get(type+(gridSizeWidth - 1)).getType() == TileType.grass)
					{
						resources = resources + (simulation.tiles.get(type+(gridSizeWidth - 1)).getResources());
					}
				}
				resourceInfo.setText( "resources: " + resources );
			}
		}
		else
		{
			if( simulation.tiles.get(type).getType() == TileType.grass )
			{
				tileInfo.setText( type + " grass" );
			}
			else if( simulation.tiles.get(type).getType() == TileType.wood )
			{
				tileInfo.setText( type + " wood" );
			}
			else if( simulation.tiles.get(type).getType() == TileType.town )
			{
				tileInfo.setText( type + " town" );
			}
			else if( simulation.tiles.get(type).getType() == TileType.sheep )
			{
				tileInfo.setText( type + " sheep" );
			}
			else if( simulation.tiles.get(type).getType() == TileType.desert )
			{
				tileInfo.setText( type + " desert" );
			}
			else if( simulation.tiles.get(type).getType() == TileType.stone )
			{
				tileInfo.setText( type + " stone" );
			}
			else if( simulation.tiles.get(type).getType() == TileType.iron )
			{
				tileInfo.setText( type + " iron" );
			}
			else if( simulation.tiles.get(type).getType() == TileType.gold )
			{
				tileInfo.setText( type + " gold" );
			}
			else if( simulation.tiles.get(type).getType() == TileType.water )
			{
				tileInfo.setText( type + " water" );
			}
			else if( simulation.tiles.get(type).getType() == TileType.coal )
			{
				tileInfo.setText( type + " coal" );
			}
			else
			{
				tileInfo.setText( "nothing selected" );
			}
			resourceInfo.setText( "resources: " + simulation.tiles.get(type).getResources() );
		}
		tileInfo.setVisible( true );
		
		resourceInfo.setVisible( true );
	}
	
	public void displayBuildFarm( TextField tileInfo, TextField resourceInfo, Simulation simulation, int type )
	{
		tileInfo.setText( "plx build farm" );
		tileInfo.setVisible( true );
		resourceInfo.setText( "Build Farm" );
		resourceInfo.setVisible( true );
	}

}
