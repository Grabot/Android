package cityBuilder.load;

import cityBuilder.gameScreen.Simulation;
import cityBuilder.objects.Tile;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.ArrayList;

public class DrawSelectionControl extends Data
{

	private TextureRegion SquareTileRegionSelected;

	public DrawSelectionControl(TextureAtlas atlas)
	{
		SquareTileRegionSelected = atlas.findRegion("SquareGreySmall");
	}

	public void drawWarehouseSelected(BuildingAvailabilityControl buildingAvailabilityControl, ArrayList<ArrayList<Tile>> tiles, Batch batch, int x, int y) {
		buildingAvailabilityControl.OutlineAvailability(tiles, batch, x, y, 1, tiles.get(x).get(y).getBuildingPosition(), 16);
//		if (tiles.get(tileNumber).getBuildingPosition() == 0) {
//			batch.draw(SquareTileRegionSelected, (-32 + tiles.get(tileNumber).getPosition().x), (-32 + tiles.get(tileNumber).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
//			batch.draw(SquareTileRegionSelected, (-32 + tiles.get(tileNumber+1).getPosition().x), (-32 + tiles.get(tileNumber+1).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
//			batch.draw(SquareTileRegionSelected, (-32 + tiles.get((tileNumber-gridSizeWidth)+1).getPosition().x), (-32 + tiles.get((tileNumber-gridSizeWidth)+1).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
//			batch.draw(SquareTileRegionSelected, (-32 + tiles.get(tileNumber-gridSizeWidth).getPosition().x), (-32 + tiles.get(tileNumber-gridSizeWidth).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
//			batch.draw(SquareTileRegionSelected, (-32 + tiles.get((tileNumber-gridSizeWidth)-1).getPosition().x), (-32 + tiles.get((tileNumber-gridSizeWidth)-1).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
//			batch.draw(SquareTileRegionSelected, (-32 + tiles.get(tileNumber-1).getPosition().x), (-32 + tiles.get(tileNumber-1).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
//			batch.draw(SquareTileRegionSelected, (-32 + tiles.get((tileNumber+gridSizeWidth)-1).getPosition().x), (-32 + tiles.get((tileNumber+gridSizeWidth)-1).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
//			batch.draw(SquareTileRegionSelected, (-32 + tiles.get(tileNumber+gridSizeWidth).getPosition().x), (-32 + tiles.get(tileNumber+gridSizeWidth).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
//			batch.draw(SquareTileRegionSelected, (-32 + tiles.get((tileNumber+gridSizeWidth)+1).getPosition().x), (-32 + tiles.get((tileNumber+gridSizeWidth)+1).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
//		} else if (tiles.get(tileNumber).getBuildingPosition() == 1) {
//			batch.draw(SquareTileRegionSelected, (-32 + tiles.get(tileNumber).getPosition().x), (-32 + tiles.get(tileNumber).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
//			batch.draw(SquareTileRegionSelected, (-32 + tiles.get(tileNumber-2).getPosition().x), (-32 + tiles.get(tileNumber-2).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
//			batch.draw(SquareTileRegionSelected, (-32 + tiles.get((tileNumber-gridSizeWidth)-2).getPosition().x), (-32 + tiles.get((tileNumber-gridSizeWidth)-2).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
//			batch.draw(SquareTileRegionSelected, (-32 + tiles.get(tileNumber-gridSizeWidth).getPosition().x), (-32 + tiles.get(tileNumber-gridSizeWidth).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
//			batch.draw(SquareTileRegionSelected, (-32 + tiles.get((tileNumber-gridSizeWidth)-1).getPosition().x), (-32 + tiles.get((tileNumber-gridSizeWidth)-1).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
//			batch.draw(SquareTileRegionSelected, (-32 + tiles.get(tileNumber-1).getPosition().x), (-32 + tiles.get(tileNumber-1).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
//			batch.draw(SquareTileRegionSelected, (-32 + tiles.get((tileNumber+gridSizeWidth)-1).getPosition().x), (-32 + tiles.get((tileNumber+gridSizeWidth)-1).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
//			batch.draw(SquareTileRegionSelected, (-32 + tiles.get(tileNumber+gridSizeWidth).getPosition().x), (-32 + tiles.get(tileNumber+gridSizeWidth).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
//			batch.draw(SquareTileRegionSelected, (-32 + tiles.get((tileNumber+gridSizeWidth)-2).getPosition().x), (-32 + tiles.get((tileNumber+gridSizeWidth)-2).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
//		} else if (tiles.get(tileNumber).getBuildingPosition() == 2) {
//			batch.draw(SquareTileRegionSelected, (-32 + tiles.get(tileNumber).getPosition().x), (-32 + tiles.get(tileNumber).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
//			batch.draw(SquareTileRegionSelected, (-32 + tiles.get(tileNumber-2).getPosition().x), (-32 + tiles.get(tileNumber-2).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
//			batch.draw(SquareTileRegionSelected, (-32 + tiles.get((tileNumber+gridSizeWidth)-2).getPosition().x), (-32 + tiles.get((tileNumber+gridSizeWidth)-2).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
//			batch.draw(SquareTileRegionSelected, (-32 + tiles.get(tileNumber+gridSizeWidth).getPosition().x), (-32 + tiles.get(tileNumber+gridSizeWidth).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
//			batch.draw(SquareTileRegionSelected, (-32 + tiles.get((tileNumber+gridSizeWidth)-1).getPosition().x), (-32 + tiles.get((tileNumber+gridSizeWidth)-1).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
//			batch.draw(SquareTileRegionSelected, (-32 + tiles.get(tileNumber-1).getPosition().x), (-32 + tiles.get(tileNumber-1).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
//			batch.draw(SquareTileRegionSelected, (-32 + tiles.get((tileNumber+(2*gridSizeWidth))-1).getPosition().x), (-32 + tiles.get((tileNumber+(2*gridSizeWidth))-1).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
//			batch.draw(SquareTileRegionSelected, (-32 + tiles.get(tileNumber+(2*gridSizeWidth)).getPosition().x), (-32 + tiles.get(tileNumber+(2*gridSizeWidth)).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
//			batch.draw(SquareTileRegionSelected, (-32 + tiles.get((tileNumber+(2*gridSizeWidth))-2).getPosition().x), (-32 + tiles.get((tileNumber+(2*gridSizeWidth))-2).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
//		} else if (tiles.get(tileNumber).getBuildingPosition() == 3) {
//			batch.draw(SquareTileRegionSelected, (-32 + tiles.get(tileNumber).getPosition().x), (-32 + tiles.get(tileNumber).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
//			batch.draw(SquareTileRegionSelected, (-32 + tiles.get(tileNumber+1).getPosition().x), (-32 + tiles.get(tileNumber+1).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
//			batch.draw(SquareTileRegionSelected, (-32 + tiles.get((tileNumber+gridSizeWidth)+1).getPosition().x), (-32 + tiles.get((tileNumber+gridSizeWidth)+1).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
//			batch.draw(SquareTileRegionSelected, (-32 + tiles.get(tileNumber+gridSizeWidth).getPosition().x), (-32 + tiles.get(tileNumber+gridSizeWidth).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
//			batch.draw(SquareTileRegionSelected, (-32 + tiles.get((tileNumber+gridSizeWidth)-1).getPosition().x), (-32 + tiles.get((tileNumber+gridSizeWidth)-1).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
//			batch.draw(SquareTileRegionSelected, (-32 + tiles.get(tileNumber-1).getPosition().x), (-32 + tiles.get(tileNumber-1).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
//			batch.draw(SquareTileRegionSelected, (-32 + tiles.get((tileNumber+(2*gridSizeWidth))-1).getPosition().x), (-32 + tiles.get((tileNumber+(2*gridSizeWidth))-1).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
//			batch.draw(SquareTileRegionSelected, (-32 + tiles.get(tileNumber+(2*gridSizeWidth)).getPosition().x), (-32 + tiles.get(tileNumber+(2*gridSizeWidth)).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
//			batch.draw(SquareTileRegionSelected, (-32 + tiles.get((tileNumber+(2*gridSizeWidth))+1).getPosition().x), (-32 + tiles.get((tileNumber+(2*gridSizeWidth))+1).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
//		} else if (tiles.get(tileNumber).getBuildingPosition() == 4) {
//			batch.draw(SquareTileRegionSelected, (-32 + tiles.get(tileNumber).getPosition().x), (-32 + tiles.get(tileNumber).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
//			batch.draw(SquareTileRegionSelected, (-32 + tiles.get(tileNumber+1).getPosition().x), (-32 + tiles.get(tileNumber+1).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
//			batch.draw(SquareTileRegionSelected, (-32 + tiles.get((tileNumber+gridSizeWidth)+1).getPosition().x), (-32 + tiles.get((tileNumber+gridSizeWidth)+1).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
//			batch.draw(SquareTileRegionSelected, (-32 + tiles.get(tileNumber+gridSizeWidth).getPosition().x), (-32 + tiles.get(tileNumber+gridSizeWidth).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
//			batch.draw(SquareTileRegionSelected, (-32 + tiles.get((tileNumber+gridSizeWidth)+2).getPosition().x), (-32 + tiles.get((tileNumber+gridSizeWidth)+2).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
//			batch.draw(SquareTileRegionSelected, (-32 + tiles.get(tileNumber+2).getPosition().x), (-32 + tiles.get(tileNumber+2).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
//			batch.draw(SquareTileRegionSelected, (-32 + tiles.get((tileNumber+(2*gridSizeWidth))+2).getPosition().x), (-32 + tiles.get((tileNumber+(2*gridSizeWidth))+2).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
//			batch.draw(SquareTileRegionSelected, (-32 + tiles.get(tileNumber+(2*gridSizeWidth)).getPosition().x), (-32 + tiles.get(tileNumber+(2*gridSizeWidth)).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
//			batch.draw(SquareTileRegionSelected, (-32 + tiles.get((tileNumber+(2*gridSizeWidth))+1).getPosition().x), (-32 + tiles.get((tileNumber+(2*gridSizeWidth))+1).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
//		} else if (tiles.get(tileNumber).getBuildingPosition() == 5) {
//			batch.draw(SquareTileRegionSelected, (-32 + tiles.get(tileNumber).getPosition().x), (-32 + tiles.get(tileNumber).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
//			batch.draw(SquareTileRegionSelected, (-32 + tiles.get(tileNumber+1).getPosition().x), (-32 + tiles.get(tileNumber+1).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
//			batch.draw(SquareTileRegionSelected, (-32 + tiles.get((tileNumber-gridSizeWidth)+1).getPosition().x), (-32 + tiles.get((tileNumber-gridSizeWidth)+1).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
//			batch.draw(SquareTileRegionSelected, (-32 + tiles.get(tileNumber-gridSizeWidth).getPosition().x), (-32 + tiles.get(tileNumber-gridSizeWidth).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
//			batch.draw(SquareTileRegionSelected, (-32 + tiles.get((tileNumber-gridSizeWidth)+2).getPosition().x), (-32 + tiles.get((tileNumber-gridSizeWidth)+2).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
//			batch.draw(SquareTileRegionSelected, (-32 + tiles.get(tileNumber+2).getPosition().x), (-32 + tiles.get(tileNumber+2).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
//			batch.draw(SquareTileRegionSelected, (-32 + tiles.get((tileNumber+gridSizeWidth)+2).getPosition().x), (-32 + tiles.get((tileNumber+gridSizeWidth)+2).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
//			batch.draw(SquareTileRegionSelected, (-32 + tiles.get(tileNumber+gridSizeWidth).getPosition().x), (-32 + tiles.get(tileNumber+gridSizeWidth).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
//			batch.draw(SquareTileRegionSelected, (-32 + tiles.get((tileNumber+gridSizeWidth)+1).getPosition().x), (-32 + tiles.get((tileNumber+gridSizeWidth)+1).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
//		} else if (tiles.get(tileNumber).getBuildingPosition() == 6) {
//			batch.draw(SquareTileRegionSelected, (-32 + tiles.get(tileNumber).getPosition().x), (-32 + tiles.get(tileNumber).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
//			batch.draw(SquareTileRegionSelected, (-32 + tiles.get(tileNumber+1).getPosition().x), (-32 + tiles.get(tileNumber+1).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
//			batch.draw(SquareTileRegionSelected, (-32 + tiles.get((tileNumber-gridSizeWidth)+1).getPosition().x), (-32 + tiles.get((tileNumber-gridSizeWidth)+1).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
//			batch.draw(SquareTileRegionSelected, (-32 + tiles.get(tileNumber-gridSizeWidth).getPosition().x), (-32 + tiles.get(tileNumber-gridSizeWidth).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
//			batch.draw(SquareTileRegionSelected, (-32 + tiles.get((tileNumber-gridSizeWidth)+2).getPosition().x), (-32 + tiles.get((tileNumber-gridSizeWidth)+2).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
//			batch.draw(SquareTileRegionSelected, (-32 + tiles.get(tileNumber+2).getPosition().x), (-32 + tiles.get(tileNumber+2).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
//			batch.draw(SquareTileRegionSelected, (-32 + tiles.get((tileNumber-(2*gridSizeWidth))+2).getPosition().x), (-32 + tiles.get((tileNumber-(2*gridSizeWidth))+2).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
//			batch.draw(SquareTileRegionSelected, (-32 + tiles.get(tileNumber-(2*gridSizeWidth)).getPosition().x), (-32 + tiles.get(tileNumber-(2*gridSizeWidth)).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
//			batch.draw(SquareTileRegionSelected, (-32 + tiles.get((tileNumber-(2*gridSizeWidth))+1).getPosition().x), (-32 + tiles.get((tileNumber-(2*gridSizeWidth))+1).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
//		} else if (tiles.get(tileNumber).getBuildingPosition() == 7) {
//			batch.draw(SquareTileRegionSelected, (-32 + tiles.get(tileNumber).getPosition().x), (-32 + tiles.get(tileNumber).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
//			batch.draw(SquareTileRegionSelected, (-32 + tiles.get(tileNumber+1).getPosition().x), (-32 + tiles.get(tileNumber+1).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
//			batch.draw(SquareTileRegionSelected, (-32 + tiles.get((tileNumber-gridSizeWidth)+1).getPosition().x), (-32 + tiles.get((tileNumber-gridSizeWidth)+1).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
//			batch.draw(SquareTileRegionSelected, (-32 + tiles.get(tileNumber-gridSizeWidth).getPosition().x), (-32 + tiles.get(tileNumber-gridSizeWidth).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
//			batch.draw(SquareTileRegionSelected, (-32 + tiles.get((tileNumber-gridSizeWidth)-1).getPosition().x), (-32 + tiles.get((tileNumber-gridSizeWidth)-1).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
//			batch.draw(SquareTileRegionSelected, (-32 + tiles.get(tileNumber-1).getPosition().x), (-32 + tiles.get(tileNumber-1).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
//			batch.draw(SquareTileRegionSelected, (-32 + tiles.get((tileNumber-(2*gridSizeWidth))-1).getPosition().x), (-32 + tiles.get((tileNumber-(2*gridSizeWidth))-1).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
//			batch.draw(SquareTileRegionSelected, (-32 + tiles.get(tileNumber-(2*gridSizeWidth)).getPosition().x), (-32 + tiles.get(tileNumber-(2*gridSizeWidth)).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
//			batch.draw(SquareTileRegionSelected, (-32 + tiles.get((tileNumber-(2*gridSizeWidth))+1).getPosition().x), (-32 + tiles.get((tileNumber-(2*gridSizeWidth))+1).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
//		} else if (tiles.get(tileNumber).getBuildingPosition() == 8) {
//			batch.draw(SquareTileRegionSelected, (-32 + tiles.get(tileNumber - (2 * gridSizeWidth) - 2).getPosition().x), (-32 + tiles.get(tileNumber - (2 * gridSizeWidth) - 2).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
//			batch.draw(SquareTileRegionSelected, (-32 + tiles.get(tileNumber - (2 * gridSizeWidth) - 1).getPosition().x), (-32 + tiles.get(tileNumber - (2 * gridSizeWidth) - 1).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
//			batch.draw(SquareTileRegionSelected, (-32 + tiles.get(tileNumber - (2 * gridSizeWidth)).getPosition().x), (-32 + tiles.get(tileNumber - (2 * gridSizeWidth)).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
//			batch.draw(SquareTileRegionSelected, (-32 + tiles.get(tileNumber - gridSizeWidth - 2).getPosition().x), (-32 + tiles.get(tileNumber - gridSizeWidth - 2).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
//			batch.draw(SquareTileRegionSelected, (-32 + tiles.get(tileNumber - gridSizeWidth - 1).getPosition().x), (-32 + tiles.get(tileNumber - gridSizeWidth - 1).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
//			batch.draw(SquareTileRegionSelected, (-32 + tiles.get(tileNumber - gridSizeWidth).getPosition().x), (-32 + tiles.get(tileNumber - gridSizeWidth).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
//			batch.draw(SquareTileRegionSelected, (-32 + tiles.get(tileNumber - 2).getPosition().x), (-32 + tiles.get(tileNumber - 2).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
//			batch.draw(SquareTileRegionSelected, (-32 + tiles.get(tileNumber - 1).getPosition().x), (-32 + tiles.get(tileNumber - 1).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
//			batch.draw(SquareTileRegionSelected, (-32 + tiles.get(tileNumber).getPosition().x), (-32 + tiles.get(tileNumber).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
//		}
	}

	public void drawFarmSelected(ArrayList<ArrayList<Tile>> tiles, Batch batch, int x, int y)
	{
		//farm, select all farm tiles of the farm. Check the tiles next to it.
		batch.draw( SquareTileRegionSelected, (-32 + tiles.get(x).get(y).getPosition().x), (-32 + tiles.get(x).get(y).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
		if( tiles.get(x).get(y).getBuildingPosition() == 0 ) {
			batch.draw( SquareTileRegionSelected, (-32 + tiles.get(x + 1).get(y).getPosition().x), (-32 + tiles.get(x + 1).get(y).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
			batch.draw( SquareTileRegionSelected, (-32 + tiles.get(x + 1).get(y + 1).getPosition().x), (-32 + tiles.get(x + 1).get(y + 1).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
			batch.draw( SquareTileRegionSelected, (-32 + tiles.get(x).get(y + 1).getPosition().x), (-32 + tiles.get(x).get(y + 1).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
		} else if( tiles.get(x).get(y).getBuildingPosition() == 1 ) {
			batch.draw( SquareTileRegionSelected, (-32 + tiles.get(x - 1).get(y).getPosition().x), (-32 + tiles.get(x - 1).get(y).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
			batch.draw( SquareTileRegionSelected, (-32 + tiles.get(x - 1).get(y + 1).getPosition().x), (-32 + tiles.get(x - 1).get(y + 1).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
			batch.draw( SquareTileRegionSelected, (-32 + tiles.get(x).get(y + 1).getPosition().x), (-32 + tiles.get(x).get(y + 1).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
		} else if( tiles.get(x).get(y).getBuildingPosition() == 2 ) {
			batch.draw( SquareTileRegionSelected, (-32 + tiles.get(x - 1).get(y).getPosition().x), (-32 + tiles.get(x - 1).get(y).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
			batch.draw( SquareTileRegionSelected, (-32 + tiles.get(x - 1).get(y - 1).getPosition().x), (-32 + tiles.get(x - 1).get(y - 1).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
			batch.draw( SquareTileRegionSelected, (-32 + tiles.get(x).get(y - 1).getPosition().x), (-32 + tiles.get(x).get(y - 1).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
		} else if( tiles.get(x).get(y).getBuildingPosition() == 3 ) {
			batch.draw( SquareTileRegionSelected, (-32 + tiles.get(x + 1).get(y).getPosition().x), (-32 + tiles.get(x + 1).get(y).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
			batch.draw( SquareTileRegionSelected, (-32 + tiles.get(x + 1).get(y - 1).getPosition().x), (-32 + tiles.get(x + 1).get(y - 1).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
			batch.draw( SquareTileRegionSelected, (-32 + tiles.get(x).get(y - 1).getPosition().x), (-32 + tiles.get(x).get(y - 1).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
		}
	}

	public void drawWoodCutterSelected(BuildingAvailabilityControl buildingAvailabilityControl, ArrayList<ArrayList<Tile>> tiles, Batch batch, int x, int y) {
		//woodcutter, select all woodcutter tiles of the farm.
		buildingAvailabilityControl.OutlineAvailability(tiles, batch, x, y, 2, tiles.get(x).get(y).getBuildingPosition(), 3);
		batch.draw( SquareTileRegionSelected, (-32 + tiles.get(x).get(y).getPosition().x), (-32 + tiles.get(x).get(y).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
		if( tiles.get(x).get(y).getBuildingPosition() == 0 ) {
			batch.draw( SquareTileRegionSelected, (-32 + tiles.get(x).get(y - 1).getPosition().x), (-32 + tiles.get(x).get(y - 1).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
			batch.draw( SquareTileRegionSelected, (-32 + tiles.get(x + 1).get(y - 1).getPosition().x), (-32 + tiles.get(x + 1).get(y - 1).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
			batch.draw( SquareTileRegionSelected, (-32 + tiles.get(x + 1).get(y).getPosition().x), (-32 + tiles.get(x + 1).get(y).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
		} else if( tiles.get(x).get(y).getBuildingPosition() == 1 ) {
//			batch.draw( SquareTileRegionSelected, (-32 + tiles.get(tileNumber+1).getPosition().x), (-32 + tiles.get(tileNumber+1).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
//			batch.draw( SquareTileRegionSelected, (-32 + tiles.get(tileNumber+gridSizeWidth).getPosition().x), (-32 + tiles.get(tileNumber+gridSizeWidth).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
//			batch.draw( SquareTileRegionSelected, (-32 + tiles.get(tileNumber+(gridSizeWidth+1)).getPosition().x), (-32 + tiles.get(tileNumber+(gridSizeWidth+1)).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
		} else if( tiles.get(x).get(y).getBuildingPosition() == 2 ) {
//			batch.draw( SquareTileRegionSelected, (-32 + tiles.get(tileNumber-1).getPosition().x), (-32 + tiles.get(tileNumber-1).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
//			batch.draw( SquareTileRegionSelected, (-32 + tiles.get(tileNumber+gridSizeWidth).getPosition().x), (-32 + tiles.get(tileNumber+gridSizeWidth).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
//			batch.draw( SquareTileRegionSelected, (-32 + tiles.get(tileNumber+(gridSizeWidth-1)).getPosition().x), (-32 + tiles.get(tileNumber+(gridSizeWidth-1)).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
		} else if( tiles.get(x).get(y).getBuildingPosition() == 3 ) {
//			batch.draw( SquareTileRegionSelected, (-32 + tiles.get(tileNumber-1).getPosition().x), (-32 + tiles.get(tileNumber-1).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
//			batch.draw( SquareTileRegionSelected, (-32 + tiles.get(tileNumber-gridSizeWidth).getPosition().x), (-32 + tiles.get(tileNumber-gridSizeWidth).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
//			batch.draw( SquareTileRegionSelected, (-32 + tiles.get(tileNumber-(gridSizeWidth+1)).getPosition().x), (-32 + tiles.get(tileNumber-(gridSizeWidth+1)).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
		}
	}

	public void drawWoodSelected(ArrayList<ArrayList<Tile>> tiles, Batch batch, int x, int y) {
		batch.draw( SquareTileRegionSelected, (-32 + tiles.get(x).get(y).getPosition().x), (-32 + tiles.get(x).get(y).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
	}
}
