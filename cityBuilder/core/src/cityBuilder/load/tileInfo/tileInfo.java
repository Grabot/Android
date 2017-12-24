package cityBuilder.load.tileInfo;

import cityBuilder.gameScreen.Simulation;
import cityBuilder.gameScreen.buildings.WoodCutter;
import cityBuilder.objects.Tile;

import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Window;

public class tileInfo extends Window {

	private Skin skin;
	private boolean create = false;
	private int compareX = -1;
	private int compareY = -1;

	public tileInfo(String title, Skin skin)
	{
		super(title, skin);
		this.skin = skin;
	}

	public void setText(int x, int y, Tile tile)
	{
		if( create && ((x != compareX) || (y != compareY))) {
			create = false;
			this.clear();
		}

		if( !create ) {
			compareX = x;
			compareY = y;
			int building = tile.getOccupied();
			String type = tile.getType().toString();
			Label label = null;
			if( building == 0 ) {
				label = new Label( "dit is " + type, skin );
			} else if( building == 1 ) {
				//farm
				label = new Label( "dit is een farm", skin );
			} else if( building == 2 ) {
				//woodcutter
				WoodCutter woodCutter = tile.getWoodCutter();
				label = new Label( "woodcutter \nstock: " + woodCutter.getAmountOfLogs(), skin );
				label.setSize(50, 20);
			} else if( building == 3 ) {
				//wood
				label = new Label( "dit is een bos", skin );
				TextButton button = new TextButton("text", skin );
				add(button);
			} else if( building == 4 ) {
				// warehouse
				label = new Label( "dit is de warehouse", skin );
			} else if( building == 5 ) {
				// warehouse 2!
				label = new Label("dit is ook een warehouse" , skin );
			} else if( building == 6 ) {
				// de weg
				label = new Label( "dit is een weg", skin );
			}
			add(label);
			create = true;
		}


	}
}
