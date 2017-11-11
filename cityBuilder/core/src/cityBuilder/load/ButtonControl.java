package cityBuilder.load;

import cityBuilder.gameScreen.Simulation;

import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

public class ButtonControl extends Data
{

	public ButtonControl()
	{

	}

	public void controlButtonWoodCutter( Simulation simulation, TextButton BuildBuildingButton, int selectedTile )
	{
		if( selectedTile >= gridSizeWidth )
		{
			String type1 = simulation.tiles.get(selectedTile).getType().toString();
			String type2 = simulation.tiles.get(selectedTile+1).getType().toString();
			String type3 = simulation.tiles.get(selectedTile-(gridSizeWidth)).getType().toString();
			String type4 = simulation.tiles.get(selectedTile-(gridSizeWidth-1)).getType().toString();
			if(((type1 == "water") || (type1 == "shore")) || ((type2 == "water") || (type2 == "shore")) || ((type3 == "water") || (type3 == "shore")) || ((type4 == "water") || (type4 == "shore")))
			{
				BuildBuildingButton.setVisible( false );
			}
			else
			{
				BuildBuildingButton.setVisible( true );
			}
			BuildBuildingButton.setText("Build WoodCutter");
		}
		else
		{
			BuildBuildingButton.setVisible( false );
		}

	}

	public void controlButtonFarm( Simulation simulation, TextButton BuildBuildingButton, int selectedTile )
	{
		if( selectedTile >= gridSizeWidth )
		{
			String type1 = simulation.tiles.get(selectedTile).getType().toString();
			String type2 = simulation.tiles.get(selectedTile+1).getType().toString();
			String type3 = simulation.tiles.get(selectedTile-(gridSizeWidth)).getType().toString();
			String type4 = simulation.tiles.get(selectedTile-(gridSizeWidth-1)).getType().toString();
			if(((type1 == "water") || (type1 == "shore")) || ((type2 == "water") || (type2 == "shore")) || ((type3 == "water") || (type3 == "shore")) || ((type4 == "water") || (type4 == "shore")))
			{
				BuildBuildingButton.setVisible( false );
			}
			else
			{
				BuildBuildingButton.setVisible( true );
			}
			BuildBuildingButton.setText("Build Farm");
		}
		else
		{
			BuildBuildingButton.setVisible( false );
		}

	}


	public void controlButtonWarehouse( Simulation simulation, TextButton BuildBuildingButton, int selectedTile )
	{
		if( selectedTile >= gridSizeWidth )
		{

			String type1 = simulation.tiles.get((selectedTile-gridSizeWidth)-1).getType().toString();
			String type2 = simulation.tiles.get((selectedTile-gridSizeWidth)).getType().toString();
			String type3 = simulation.tiles.get((selectedTile-gridSizeWidth)+1).getType().toString();
			String type4 = simulation.tiles.get(selectedTile-1).getType().toString();
			String type5 = simulation.tiles.get(selectedTile).getType().toString();
			String type6 = simulation.tiles.get(selectedTile+1).getType().toString();
			String type7 = simulation.tiles.get((selectedTile+gridSizeWidth)-1).getType().toString();
			String type8 = simulation.tiles.get((selectedTile+gridSizeWidth)).getType().toString();
			String type9 = simulation.tiles.get((selectedTile+gridSizeWidth)+1).getType().toString();

			if(((type1 == "water") || (type1 == "shore"))
					|| ((type2 == "water") || (type2 == "shore"))
					|| ((type3 == "water") || (type3 == "shore"))
					|| (type4 == "water")
					|| (type5 == "water")
					|| (type6 == "water")
					|| (type7 != "water")
					|| (type8 != "water")
					|| (type9 != "water")){
				BuildBuildingButton.setVisible( false );
			} else {
				BuildBuildingButton.setVisible( true );
			}
			BuildBuildingButton.setText("Build Warehouse");
		}
		else
		{
			BuildBuildingButton.setVisible( false );
		}

	}

}
