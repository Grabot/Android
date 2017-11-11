package cityBuilder.load;

import cityBuilder.gameScreen.Simulation;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class DrawSelectionControl extends Data
{

	private TextureRegion SquareTileRegionSelected;
	private TextureRegion SquareOutlineFull;
	private TextureRegion SquareOutlineEdge;

	public DrawSelectionControl(TextureAtlas atlas)
	{
		SquareTileRegionSelected = atlas.findRegion("SquareGreySmall");
		SquareOutlineFull = atlas.findRegion("outlineFull2");
		SquareOutlineEdge = atlas.findRegion("outlineEdge2");
	}

	public void drawWarehouseSelected(Simulation simulation, Batch batch, int tileNumber) {
		//batch.draw(SquareTileRegionSelected, (-32 + simulation.tiles.get(tileNumber).getPosition().x), (-32 + simulation.tiles.get(tileNumber).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
		if (simulation.tiles.get(tileNumber).getBuildingPosition() == 0) {
			batch.draw(SquareTileRegionSelected, (-32 + simulation.tiles.get(tileNumber).getPosition().x), (-32 + simulation.tiles.get(tileNumber).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
			batch.draw(SquareTileRegionSelected, (-32 + simulation.tiles.get(tileNumber-1).getPosition().x), (-32 + simulation.tiles.get(tileNumber-1).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
			batch.draw(SquareTileRegionSelected, (-32 + simulation.tiles.get(tileNumber-2).getPosition().x), (-32 + simulation.tiles.get(tileNumber-2).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
			batch.draw( SquareTileRegionSelected, (-32 + simulation.tiles.get(tileNumber+gridSizeWidth).getPosition().x), (-32 + simulation.tiles.get(tileNumber+gridSizeWidth).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
			batch.draw( SquareTileRegionSelected, (-32 + simulation.tiles.get(tileNumber+gridSizeWidth-1).getPosition().x), (-32 + simulation.tiles.get(tileNumber+gridSizeWidth-1).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
			batch.draw( SquareTileRegionSelected, (-32 + simulation.tiles.get(tileNumber+gridSizeWidth-2).getPosition().x), (-32 + simulation.tiles.get(tileNumber+gridSizeWidth-2).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
			batch.draw( SquareTileRegionSelected, (-32 + simulation.tiles.get(tileNumber+(2*gridSizeWidth)).getPosition().x), (-32 + simulation.tiles.get(tileNumber+(2*gridSizeWidth)).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
			batch.draw( SquareTileRegionSelected, (-32 + simulation.tiles.get(tileNumber+(2*gridSizeWidth)-1).getPosition().x), (-32 + simulation.tiles.get(tileNumber+(2*gridSizeWidth)-1).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
			batch.draw( SquareTileRegionSelected, (-32 + simulation.tiles.get(tileNumber+(2*gridSizeWidth)-2).getPosition().x), (-32 + simulation.tiles.get(tileNumber+(2*gridSizeWidth)-2).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
		} else if (simulation.tiles.get(tileNumber).getBuildingPosition() == 1) {
			batch.draw(SquareTileRegionSelected, (-32 + simulation.tiles.get(tileNumber+1).getPosition().x), (-32 + simulation.tiles.get(tileNumber+1).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
			batch.draw(SquareTileRegionSelected, (-32 + simulation.tiles.get(tileNumber).getPosition().x), (-32 + simulation.tiles.get(tileNumber).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
			batch.draw(SquareTileRegionSelected, (-32 + simulation.tiles.get(tileNumber-1).getPosition().x), (-32 + simulation.tiles.get(tileNumber-1).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
			batch.draw( SquareTileRegionSelected, (-32 + simulation.tiles.get(tileNumber+gridSizeWidth+1).getPosition().x), (-32 + simulation.tiles.get(tileNumber+gridSizeWidth+1).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
			batch.draw( SquareTileRegionSelected, (-32 + simulation.tiles.get(tileNumber+gridSizeWidth).getPosition().x), (-32 + simulation.tiles.get(tileNumber+gridSizeWidth).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
			batch.draw( SquareTileRegionSelected, (-32 + simulation.tiles.get(tileNumber+gridSizeWidth-1).getPosition().x), (-32 + simulation.tiles.get(tileNumber+gridSizeWidth-1).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
			batch.draw( SquareTileRegionSelected, (-32 + simulation.tiles.get(tileNumber+(2*gridSizeWidth)+1).getPosition().x), (-32 + simulation.tiles.get(tileNumber+(2*gridSizeWidth)+1).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
			batch.draw( SquareTileRegionSelected, (-32 + simulation.tiles.get(tileNumber+(2*gridSizeWidth)).getPosition().x), (-32 + simulation.tiles.get(tileNumber+(2*gridSizeWidth)).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
			batch.draw( SquareTileRegionSelected, (-32 + simulation.tiles.get(tileNumber+(2*gridSizeWidth)-1).getPosition().x), (-32 + simulation.tiles.get(tileNumber+(2*gridSizeWidth)-1).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
		} else if (simulation.tiles.get(tileNumber).getBuildingPosition() == 2) {
			batch.draw(SquareTileRegionSelected, (-32 + simulation.tiles.get(tileNumber).getPosition().x), (-32 + simulation.tiles.get(tileNumber).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
			batch.draw(SquareTileRegionSelected, (-32 + simulation.tiles.get(tileNumber+1).getPosition().x), (-32 + simulation.tiles.get(tileNumber+1).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
			batch.draw(SquareTileRegionSelected, (-32 + simulation.tiles.get(tileNumber+2).getPosition().x), (-32 + simulation.tiles.get(tileNumber+2).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
			batch.draw( SquareTileRegionSelected, (-32 + simulation.tiles.get(tileNumber+gridSizeWidth).getPosition().x), (-32 + simulation.tiles.get(tileNumber+gridSizeWidth).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
			batch.draw( SquareTileRegionSelected, (-32 + simulation.tiles.get(tileNumber+gridSizeWidth+1).getPosition().x), (-32 + simulation.tiles.get(tileNumber+gridSizeWidth+1).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
			batch.draw( SquareTileRegionSelected, (-32 + simulation.tiles.get(tileNumber+gridSizeWidth+2).getPosition().x), (-32 + simulation.tiles.get(tileNumber+gridSizeWidth+2).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
			batch.draw( SquareTileRegionSelected, (-32 + simulation.tiles.get(tileNumber+(2*gridSizeWidth)).getPosition().x), (-32 + simulation.tiles.get(tileNumber+(2*gridSizeWidth)).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
			batch.draw( SquareTileRegionSelected, (-32 + simulation.tiles.get(tileNumber+(2*gridSizeWidth)+1).getPosition().x), (-32 + simulation.tiles.get(tileNumber+(2*gridSizeWidth)+1).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
			batch.draw( SquareTileRegionSelected, (-32 + simulation.tiles.get(tileNumber+(2*gridSizeWidth)+2).getPosition().x), (-32 + simulation.tiles.get(tileNumber+(2*gridSizeWidth)+2).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
		} else if (simulation.tiles.get(tileNumber).getBuildingPosition() == 3) {
			batch.draw( SquareTileRegionSelected, (-32 + simulation.tiles.get(tileNumber-gridSizeWidth).getPosition().x), (-32 + simulation.tiles.get(tileNumber-gridSizeWidth).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
			batch.draw( SquareTileRegionSelected, (-32 + simulation.tiles.get(tileNumber-gridSizeWidth+1).getPosition().x), (-32 + simulation.tiles.get(tileNumber-gridSizeWidth+1).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
			batch.draw( SquareTileRegionSelected, (-32 + simulation.tiles.get(tileNumber-gridSizeWidth+2).getPosition().x), (-32 + simulation.tiles.get(tileNumber-gridSizeWidth+2).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
			batch.draw(SquareTileRegionSelected, (-32 + simulation.tiles.get(tileNumber).getPosition().x), (-32 + simulation.tiles.get(tileNumber).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
			batch.draw(SquareTileRegionSelected, (-32 + simulation.tiles.get(tileNumber+1).getPosition().x), (-32 + simulation.tiles.get(tileNumber+1).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
			batch.draw(SquareTileRegionSelected, (-32 + simulation.tiles.get(tileNumber+2).getPosition().x), (-32 + simulation.tiles.get(tileNumber+2).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
			batch.draw( SquareTileRegionSelected, (-32 + simulation.tiles.get(tileNumber+gridSizeWidth).getPosition().x), (-32 + simulation.tiles.get(tileNumber+gridSizeWidth).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
			batch.draw( SquareTileRegionSelected, (-32 + simulation.tiles.get(tileNumber+gridSizeWidth+1).getPosition().x), (-32 + simulation.tiles.get(tileNumber+gridSizeWidth+1).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
			batch.draw( SquareTileRegionSelected, (-32 + simulation.tiles.get(tileNumber+gridSizeWidth+2).getPosition().x), (-32 + simulation.tiles.get(tileNumber+gridSizeWidth+2).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
		} else if (simulation.tiles.get(tileNumber).getBuildingPosition() == 4) {
			batch.draw( SquareTileRegionSelected, (-32 + simulation.tiles.get(tileNumber-gridSizeWidth-1).getPosition().x), (-32 + simulation.tiles.get(tileNumber-gridSizeWidth-1).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
			batch.draw( SquareTileRegionSelected, (-32 + simulation.tiles.get(tileNumber-gridSizeWidth).getPosition().x), (-32 + simulation.tiles.get(tileNumber-gridSizeWidth).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
			batch.draw( SquareTileRegionSelected, (-32 + simulation.tiles.get(tileNumber-gridSizeWidth+1).getPosition().x), (-32 + simulation.tiles.get(tileNumber-gridSizeWidth+1).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
			batch.draw(SquareTileRegionSelected, (-32 + simulation.tiles.get(tileNumber-1).getPosition().x), (-32 + simulation.tiles.get(tileNumber-1).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
			batch.draw(SquareTileRegionSelected, (-32 + simulation.tiles.get(tileNumber).getPosition().x), (-32 + simulation.tiles.get(tileNumber).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
			batch.draw(SquareTileRegionSelected, (-32 + simulation.tiles.get(tileNumber+1).getPosition().x), (-32 + simulation.tiles.get(tileNumber+1).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
			batch.draw( SquareTileRegionSelected, (-32 + simulation.tiles.get(tileNumber+gridSizeWidth-1).getPosition().x), (-32 + simulation.tiles.get(tileNumber+gridSizeWidth-1).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
			batch.draw( SquareTileRegionSelected, (-32 + simulation.tiles.get(tileNumber+gridSizeWidth).getPosition().x), (-32 + simulation.tiles.get(tileNumber+gridSizeWidth).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
			batch.draw( SquareTileRegionSelected, (-32 + simulation.tiles.get(tileNumber+gridSizeWidth+1).getPosition().x), (-32 + simulation.tiles.get(tileNumber+gridSizeWidth+1).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
		} else if (simulation.tiles.get(tileNumber).getBuildingPosition() == 5) {
			batch.draw( SquareTileRegionSelected, (-32 + simulation.tiles.get(tileNumber-gridSizeWidth-2).getPosition().x), (-32 + simulation.tiles.get(tileNumber-gridSizeWidth-2).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
			batch.draw( SquareTileRegionSelected, (-32 + simulation.tiles.get(tileNumber-gridSizeWidth-1).getPosition().x), (-32 + simulation.tiles.get(tileNumber-gridSizeWidth-1).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
			batch.draw( SquareTileRegionSelected, (-32 + simulation.tiles.get(tileNumber-gridSizeWidth).getPosition().x), (-32 + simulation.tiles.get(tileNumber-gridSizeWidth).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
			batch.draw(SquareTileRegionSelected, (-32 + simulation.tiles.get(tileNumber-2).getPosition().x), (-32 + simulation.tiles.get(tileNumber-2).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
			batch.draw(SquareTileRegionSelected, (-32 + simulation.tiles.get(tileNumber-1).getPosition().x), (-32 + simulation.tiles.get(tileNumber-1).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
			batch.draw(SquareTileRegionSelected, (-32 + simulation.tiles.get(tileNumber).getPosition().x), (-32 + simulation.tiles.get(tileNumber).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
			batch.draw( SquareTileRegionSelected, (-32 + simulation.tiles.get(tileNumber+gridSizeWidth-2).getPosition().x), (-32 + simulation.tiles.get(tileNumber+gridSizeWidth-2).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
			batch.draw( SquareTileRegionSelected, (-32 + simulation.tiles.get(tileNumber+gridSizeWidth-1).getPosition().x), (-32 + simulation.tiles.get(tileNumber+gridSizeWidth-1).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
			batch.draw( SquareTileRegionSelected, (-32 + simulation.tiles.get(tileNumber+gridSizeWidth).getPosition().x), (-32 + simulation.tiles.get(tileNumber+gridSizeWidth).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
		} else if (simulation.tiles.get(tileNumber).getBuildingPosition() == 6) {
			batch.draw( SquareTileRegionSelected, (-32 + simulation.tiles.get(tileNumber-(2*gridSizeWidth)).getPosition().x), (-32 + simulation.tiles.get(tileNumber-(2*gridSizeWidth)).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
			batch.draw( SquareTileRegionSelected, (-32 + simulation.tiles.get(tileNumber-(2*gridSizeWidth)+1).getPosition().x), (-32 + simulation.tiles.get(tileNumber-(2*gridSizeWidth)+1).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
			batch.draw( SquareTileRegionSelected, (-32 + simulation.tiles.get(tileNumber-(2*gridSizeWidth)+2).getPosition().x), (-32 + simulation.tiles.get(tileNumber-(2*gridSizeWidth)+2).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
			batch.draw( SquareTileRegionSelected, (-32 + simulation.tiles.get(tileNumber-gridSizeWidth).getPosition().x), (-32 + simulation.tiles.get(tileNumber-gridSizeWidth).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
			batch.draw( SquareTileRegionSelected, (-32 + simulation.tiles.get(tileNumber-gridSizeWidth+1).getPosition().x), (-32 + simulation.tiles.get(tileNumber-gridSizeWidth+1).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
			batch.draw( SquareTileRegionSelected, (-32 + simulation.tiles.get(tileNumber-gridSizeWidth+2).getPosition().x), (-32 + simulation.tiles.get(tileNumber-gridSizeWidth+2).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
			batch.draw(SquareTileRegionSelected, (-32 + simulation.tiles.get(tileNumber).getPosition().x), (-32 + simulation.tiles.get(tileNumber).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
			batch.draw(SquareTileRegionSelected, (-32 + simulation.tiles.get(tileNumber+1).getPosition().x), (-32 + simulation.tiles.get(tileNumber+1).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
			batch.draw(SquareTileRegionSelected, (-32 + simulation.tiles.get(tileNumber+2).getPosition().x), (-32 + simulation.tiles.get(tileNumber+2).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
		} else if (simulation.tiles.get(tileNumber).getBuildingPosition() == 7) {
			batch.draw(SquareTileRegionSelected, (-32 + simulation.tiles.get(tileNumber - (2 * gridSizeWidth) - 1).getPosition().x), (-32 + simulation.tiles.get(tileNumber - (2 * gridSizeWidth) - 1).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
			batch.draw(SquareTileRegionSelected, (-32 + simulation.tiles.get(tileNumber - (2 * gridSizeWidth)).getPosition().x), (-32 + simulation.tiles.get(tileNumber - (2 * gridSizeWidth)).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
			batch.draw(SquareTileRegionSelected, (-32 + simulation.tiles.get(tileNumber - (2 * gridSizeWidth) + 1).getPosition().x), (-32 + simulation.tiles.get(tileNumber - (2 * gridSizeWidth) + 1).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
			batch.draw(SquareTileRegionSelected, (-32 + simulation.tiles.get(tileNumber - gridSizeWidth - 1).getPosition().x), (-32 + simulation.tiles.get(tileNumber - gridSizeWidth - 1).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
			batch.draw(SquareTileRegionSelected, (-32 + simulation.tiles.get(tileNumber - gridSizeWidth).getPosition().x), (-32 + simulation.tiles.get(tileNumber - gridSizeWidth).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
			batch.draw(SquareTileRegionSelected, (-32 + simulation.tiles.get(tileNumber - gridSizeWidth + 1).getPosition().x), (-32 + simulation.tiles.get(tileNumber - gridSizeWidth + 1).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
			batch.draw(SquareTileRegionSelected, (-32 + simulation.tiles.get(tileNumber - 1).getPosition().x), (-32 + simulation.tiles.get(tileNumber - 1).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
			batch.draw(SquareTileRegionSelected, (-32 + simulation.tiles.get(tileNumber).getPosition().x), (-32 + simulation.tiles.get(tileNumber).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
			batch.draw(SquareTileRegionSelected, (-32 + simulation.tiles.get(tileNumber + 1).getPosition().x), (-32 + simulation.tiles.get(tileNumber + 1).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
		} else if (simulation.tiles.get(tileNumber).getBuildingPosition() == 8) {
			batch.draw(SquareTileRegionSelected, (-32 + simulation.tiles.get(tileNumber - (2 * gridSizeWidth) - 2).getPosition().x), (-32 + simulation.tiles.get(tileNumber - (2 * gridSizeWidth) - 2).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
			batch.draw(SquareTileRegionSelected, (-32 + simulation.tiles.get(tileNumber - (2 * gridSizeWidth) - 1).getPosition().x), (-32 + simulation.tiles.get(tileNumber - (2 * gridSizeWidth) - 1).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
			batch.draw(SquareTileRegionSelected, (-32 + simulation.tiles.get(tileNumber - (2 * gridSizeWidth)).getPosition().x), (-32 + simulation.tiles.get(tileNumber - (2 * gridSizeWidth)).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
			batch.draw(SquareTileRegionSelected, (-32 + simulation.tiles.get(tileNumber - gridSizeWidth - 2).getPosition().x), (-32 + simulation.tiles.get(tileNumber - gridSizeWidth - 2).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
			batch.draw(SquareTileRegionSelected, (-32 + simulation.tiles.get(tileNumber - gridSizeWidth - 1).getPosition().x), (-32 + simulation.tiles.get(tileNumber - gridSizeWidth - 1).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
			batch.draw(SquareTileRegionSelected, (-32 + simulation.tiles.get(tileNumber - gridSizeWidth).getPosition().x), (-32 + simulation.tiles.get(tileNumber - gridSizeWidth).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
			batch.draw(SquareTileRegionSelected, (-32 + simulation.tiles.get(tileNumber - 2).getPosition().x), (-32 + simulation.tiles.get(tileNumber - 2).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
			batch.draw(SquareTileRegionSelected, (-32 + simulation.tiles.get(tileNumber - 1).getPosition().x), (-32 + simulation.tiles.get(tileNumber - 1).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
			batch.draw(SquareTileRegionSelected, (-32 + simulation.tiles.get(tileNumber).getPosition().x), (-32 + simulation.tiles.get(tileNumber).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
		}
	}

	public void drawFarmSelected(Simulation simulation, Batch batch, int tileNumber)
	{
		//farm, select all farm tiles of the farm. Check the tiles next to it.
		batch.draw( SquareTileRegionSelected, (-32 + simulation.tiles.get(tileNumber).getPosition().x), (-32 + simulation.tiles.get(tileNumber).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
		if( simulation.tiles.get(tileNumber).getBuildingPosition() == 0 )
		{
			batch.draw( SquareTileRegionSelected, (-32 + simulation.tiles.get(tileNumber+1).getPosition().x), (-32 + simulation.tiles.get(tileNumber+1).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
			batch.draw( SquareTileRegionSelected, (-32 + simulation.tiles.get(tileNumber-gridSizeWidth).getPosition().x), (-32 + simulation.tiles.get(tileNumber-gridSizeWidth).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
			batch.draw( SquareTileRegionSelected, (-32 + simulation.tiles.get(tileNumber-(gridSizeWidth-1)).getPosition().x), (-32 + simulation.tiles.get(tileNumber-(gridSizeWidth-1)).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
		}
		else if( simulation.tiles.get(tileNumber).getBuildingPosition() == 1 )
		{
			batch.draw( SquareTileRegionSelected, (-32 + simulation.tiles.get(tileNumber+1).getPosition().x), (-32 + simulation.tiles.get(tileNumber+1).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
			batch.draw( SquareTileRegionSelected, (-32 + simulation.tiles.get(tileNumber+gridSizeWidth).getPosition().x), (-32 + simulation.tiles.get(tileNumber+gridSizeWidth).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
			batch.draw( SquareTileRegionSelected, (-32 + simulation.tiles.get(tileNumber+(gridSizeWidth+1)).getPosition().x), (-32 + simulation.tiles.get(tileNumber+(gridSizeWidth+1)).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
		}
		else if( simulation.tiles.get(tileNumber).getBuildingPosition() == 2 )
		{
			batch.draw( SquareTileRegionSelected, (-32 + simulation.tiles.get(tileNumber-1).getPosition().x), (-32 + simulation.tiles.get(tileNumber-1).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
			batch.draw( SquareTileRegionSelected, (-32 + simulation.tiles.get(tileNumber+gridSizeWidth).getPosition().x), (-32 + simulation.tiles.get(tileNumber+gridSizeWidth).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
			batch.draw( SquareTileRegionSelected, (-32 + simulation.tiles.get(tileNumber+(gridSizeWidth-1)).getPosition().x), (-32 + simulation.tiles.get(tileNumber+(gridSizeWidth-1)).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
		}
		else if( simulation.tiles.get(tileNumber).getBuildingPosition() == 3 )
		{
			batch.draw( SquareTileRegionSelected, (-32 + simulation.tiles.get(tileNumber-1).getPosition().x), (-32 + simulation.tiles.get(tileNumber-1).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
			batch.draw( SquareTileRegionSelected, (-32 + simulation.tiles.get(tileNumber-gridSizeWidth).getPosition().x), (-32 + simulation.tiles.get(tileNumber-gridSizeWidth).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
			batch.draw( SquareTileRegionSelected, (-32 + simulation.tiles.get(tileNumber-(gridSizeWidth+1)).getPosition().x), (-32 + simulation.tiles.get(tileNumber-(gridSizeWidth+1)).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
		}
	}

	public void drawWoodCutterSelected(Simulation simulation, Batch batch, int tileNumber)
	{
		//woodcutter, select all woodcutter tiles of the farm.
		batch.draw( SquareTileRegionSelected, (-32 + simulation.tiles.get(tileNumber).getPosition().x), (-32 + simulation.tiles.get(tileNumber).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
		if( simulation.tiles.get(tileNumber).getBuildingPosition() == 0 )
		{
			drawOutlineWoodCutter( simulation, batch, tileNumber );
			batch.draw( SquareTileRegionSelected, (-32 + simulation.tiles.get(tileNumber+1).getPosition().x), (-32 + simulation.tiles.get(tileNumber+1).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
			batch.draw( SquareTileRegionSelected, (-32 + simulation.tiles.get(tileNumber-gridSizeWidth).getPosition().x), (-32 + simulation.tiles.get(tileNumber-gridSizeWidth).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
			batch.draw( SquareTileRegionSelected, (-32 + simulation.tiles.get(tileNumber-(gridSizeWidth-1)).getPosition().x), (-32 + simulation.tiles.get(tileNumber-(gridSizeWidth-1)).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
		}
		else if( simulation.tiles.get(tileNumber).getBuildingPosition() == 1 )
		{
			drawOutlineWoodCutter( simulation, batch, (tileNumber+gridSizeWidth) );
			batch.draw( SquareTileRegionSelected, (-32 + simulation.tiles.get(tileNumber+1).getPosition().x), (-32 + simulation.tiles.get(tileNumber+1).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
			batch.draw( SquareTileRegionSelected, (-32 + simulation.tiles.get(tileNumber+gridSizeWidth).getPosition().x), (-32 + simulation.tiles.get(tileNumber+gridSizeWidth).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
			batch.draw( SquareTileRegionSelected, (-32 + simulation.tiles.get(tileNumber+(gridSizeWidth+1)).getPosition().x), (-32 + simulation.tiles.get(tileNumber+(gridSizeWidth+1)).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
		}
		else if( simulation.tiles.get(tileNumber).getBuildingPosition() == 2 )
		{
			drawOutlineWoodCutter( simulation, batch, (tileNumber+(gridSizeWidth-1)) );
			batch.draw( SquareTileRegionSelected, (-32 + simulation.tiles.get(tileNumber-1).getPosition().x), (-32 + simulation.tiles.get(tileNumber-1).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
			batch.draw( SquareTileRegionSelected, (-32 + simulation.tiles.get(tileNumber+gridSizeWidth).getPosition().x), (-32 + simulation.tiles.get(tileNumber+gridSizeWidth).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
			batch.draw( SquareTileRegionSelected, (-32 + simulation.tiles.get(tileNumber+(gridSizeWidth-1)).getPosition().x), (-32 + simulation.tiles.get(tileNumber+(gridSizeWidth-1)).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
		}
		else if( simulation.tiles.get(tileNumber).getBuildingPosition() == 3 )
		{
			drawOutlineWoodCutter( simulation, batch, (tileNumber-1) );
			batch.draw( SquareTileRegionSelected, (-32 + simulation.tiles.get(tileNumber-1).getPosition().x), (-32 + simulation.tiles.get(tileNumber-1).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
			batch.draw( SquareTileRegionSelected, (-32 + simulation.tiles.get(tileNumber-gridSizeWidth).getPosition().x), (-32 + simulation.tiles.get(tileNumber-gridSizeWidth).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
			batch.draw( SquareTileRegionSelected, (-32 + simulation.tiles.get(tileNumber-(gridSizeWidth+1)).getPosition().x), (-32 + simulation.tiles.get(tileNumber-(gridSizeWidth+1)).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
		}
	}

	private void drawOutlineWoodCutter(Simulation simulation, Batch batch, int tileNumber)
	{
		//draw outline region for woodcutter
		if(!(tileNumber <= (gridSizeWidth*4)))
		{
			//top side
			batch.draw( SquareOutlineFull, (32 + simulation.tiles.get(tileNumber-(gridSizeWidth*4)).getPosition().x), (32 + simulation.tiles.get(tileNumber-(gridSizeWidth*4)).getPosition().y), 0, 0, 64, 64, 1, 1, 180, false);
			batch.draw( SquareOutlineFull, (32 + simulation.tiles.get(tileNumber-(gridSizeWidth*4)+1).getPosition().x), (32 + simulation.tiles.get(tileNumber-(gridSizeWidth*4)+1).getPosition().y), 0, 0, 64, 64, 1, 1, 180, false);
		}
		if(!(tileNumber >= (gridSizeWidth*(gridSizeHeight-3))))
		{
			//bottom side
			batch.draw( SquareOutlineFull, (-32 + simulation.tiles.get(tileNumber+(gridSizeWidth*3)).getPosition().x), (-32 + simulation.tiles.get(tileNumber+(gridSizeWidth*3)).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
			batch.draw( SquareOutlineFull, (-32 + simulation.tiles.get(tileNumber+(gridSizeWidth*3)+1).getPosition().x), (-32 + simulation.tiles.get(tileNumber+(gridSizeWidth*3)+1).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
		}

		if(!(((((tileNumber)%gridSizeWidth) == 0)) || ((((tileNumber-1)%gridSizeWidth) == 0)) || ((((tileNumber-2)%gridSizeWidth) == 0))))
		{
			batch.draw( SquareOutlineFull, (-32 + simulation.tiles.get(tileNumber-3).getPosition().x), (32 + simulation.tiles.get(tileNumber-3).getPosition().y), 0, 0, 64, 64, 1, 1, -90, false);
			batch.draw( SquareOutlineFull, (-32 + simulation.tiles.get((tileNumber-3)-gridSizeWidth).getPosition().x), (32 + simulation.tiles.get((tileNumber-3)-gridSizeWidth).getPosition().y), 0, 0, 64, 64, 1, 1, -90, false);
		}

		if(!((((tileNumber+4)%(gridSizeWidth)) == 0) || (((tileNumber+3)%(gridSizeWidth)) == 0) || (((tileNumber+2)%(gridSizeWidth)) == 0)))
		{
			//right side
			batch.draw( SquareOutlineFull, (32 + simulation.tiles.get(tileNumber+4).getPosition().x), (-32 + simulation.tiles.get(tileNumber+4).getPosition().y), 0, 0, 64, 64, 1, 1, 90, false);
			batch.draw( SquareOutlineFull, (32 + simulation.tiles.get((tileNumber+4)-gridSizeWidth).getPosition().x), (-32 + simulation.tiles.get((tileNumber+4)-gridSizeWidth).getPosition().y), 0, 0, 64, 64, 1, 1, 90, false);
		}

		if(!(tileNumber <= (gridSizeWidth*4)))
		{
			//top left and top right
			if(!(((tileNumber)%gridSizeWidth) == 0))
			{
				batch.draw( SquareOutlineEdge, (-32 + simulation.tiles.get((tileNumber-1)-(gridSizeWidth*4)).getPosition().x), (32 + simulation.tiles.get((tileNumber-1)-(gridSizeWidth*4)).getPosition().y), 0, 0, 64, 64, 1, 1, -90, false);
			}

			if(!(((tileNumber+2)%(gridSizeWidth)) == 0))
			{
				batch.draw( SquareOutlineEdge, (32 + simulation.tiles.get((tileNumber+2)-(gridSizeWidth*4)).getPosition().x), (32 + simulation.tiles.get((tileNumber+2)-(gridSizeWidth*4)).getPosition().y), 0, 0, 64, 64, 1, 1, 180, false);
			}

		}
		if(!(tileNumber <= (gridSizeWidth*3)))
		{
			//top left and top right
			if(!((((tileNumber-1)%gridSizeWidth) == 0) || (((tileNumber)%gridSizeWidth) == 0)))
			{
				batch.draw( SquareOutlineEdge, (-32 + simulation.tiles.get((tileNumber-2)-(gridSizeWidth*3)).getPosition().x), (32 + simulation.tiles.get((tileNumber-2)-(gridSizeWidth*3)).getPosition().y), 0, 0, 64, 64, 1, 1, -90, false);
			}

			if(!((((tileNumber+3)%(gridSizeWidth)) == 0) || (((tileNumber+2)%(gridSizeWidth)) == 0)))
			{
				batch.draw( SquareOutlineEdge, (32 + simulation.tiles.get((tileNumber+3)-(gridSizeWidth*3)).getPosition().x), (32 + simulation.tiles.get((tileNumber+3)-(gridSizeWidth*3)).getPosition().y), 0, 0, 64, 64, 1, 1, 180, false);
			}
		}
		if(!(tileNumber <= (gridSizeWidth*2)))
		{
			//top left and right
			if(!((((tileNumber-2)%gridSizeWidth) == 0) || (((tileNumber-1)%gridSizeWidth) == 0) || (((tileNumber)%gridSizeWidth) == 0)))
			{
				batch.draw( SquareOutlineEdge, (-32 + simulation.tiles.get((tileNumber-3)-(gridSizeWidth*2)).getPosition().x), (32 + simulation.tiles.get((tileNumber-3)-(gridSizeWidth*2)).getPosition().y), 0, 0, 64, 64, 1, 1, -90, false);
			}
			if(!((((tileNumber+4)%(gridSizeWidth)) == 0) || (((tileNumber+3)%(gridSizeWidth)) == 0) || (((tileNumber+2)%(gridSizeWidth)) == 0)))
			{
				batch.draw( SquareOutlineEdge, (32 + simulation.tiles.get((tileNumber+4)-(gridSizeWidth*2)).getPosition().x), (32 + simulation.tiles.get((tileNumber+4)-(gridSizeWidth*2)).getPosition().y), 0, 0, 64, 64, 1, 1, 180, false);
			}
		}

		if(!(tileNumber >= (gridSizeWidth*(gridSizeHeight-3))))
		{
			//bottom left and right
			if(!(((tileNumber)%gridSizeWidth) == 0))
			{
				batch.draw( SquareOutlineEdge, (-32 + simulation.tiles.get((tileNumber-1)+(gridSizeWidth*3)).getPosition().x), (-32 + simulation.tiles.get((tileNumber-1)+(gridSizeWidth*3)).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
			}
			if(!(((tileNumber+2)%(gridSizeWidth)) == 0))
			{
				batch.draw( SquareOutlineEdge, (32 + simulation.tiles.get((tileNumber+2)+(gridSizeWidth*3)).getPosition().x), (-32 + simulation.tiles.get((tileNumber+2)+(gridSizeWidth*3)).getPosition().y), 0, 0, 64, 64, 1, 1, 90, false);
			}
		}
		if(!(tileNumber >= (gridSizeWidth*(gridSizeHeight-2))))
		{
			//bottom left and right
			if(!((((tileNumber-1)%gridSizeWidth) == 0) || (((tileNumber)%gridSizeWidth) == 0)))
			{
				batch.draw( SquareOutlineEdge, (-32 + simulation.tiles.get((tileNumber-2)+(gridSizeWidth*2)).getPosition().x), (-32 + simulation.tiles.get((tileNumber-2)+(gridSizeWidth*2)).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
			}
			if(!((((tileNumber+3)%(gridSizeWidth)) == 0) || (((tileNumber+2)%(gridSizeWidth)) == 0)))
			{
				batch.draw( SquareOutlineEdge, (32 + simulation.tiles.get((tileNumber+3)+(gridSizeWidth*2)).getPosition().x), (-32 + simulation.tiles.get((tileNumber+3)+(gridSizeWidth*2)).getPosition().y), 0, 0, 64, 64, 1, 1, 90, false);
			}
		}
		if(!(tileNumber >= (gridSizeWidth*(gridSizeHeight-1))))
		{
			//bottom left and right
			if(!((((tileNumber-2)%gridSizeWidth) == 0) || (((tileNumber-1)%gridSizeWidth) == 0) || (((tileNumber)%gridSizeWidth) == 0)))
			{
				batch.draw( SquareOutlineEdge, (-32 + simulation.tiles.get((tileNumber-3)+(gridSizeWidth*1)).getPosition().x), (-32 + simulation.tiles.get((tileNumber-3)+(gridSizeWidth*1)).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
			}
			if(!((((tileNumber+4)%(gridSizeWidth)) == 0) || (((tileNumber+3)%(gridSizeWidth)) == 0) || (((tileNumber+2)%(gridSizeWidth)) == 0)))
			{
				batch.draw( SquareOutlineEdge, (32 + simulation.tiles.get((tileNumber+4)+(gridSizeWidth*1)).getPosition().x), (-32 + simulation.tiles.get((tileNumber+4)+(gridSizeWidth*1)).getPosition().y), 0, 0, 64, 64, 1, 1, 90, false);
			}
		}
	}

	public void drawWoodSelected(Simulation simulation, Batch batch, int tileNumber)
	{
		batch.draw( SquareTileRegionSelected, (-32 + simulation.tiles.get(tileNumber).getPosition().x), (-32 + simulation.tiles.get(tileNumber).getPosition().y), 0, 0, 64, 64, 1, 1, 0, false);
	}
}
