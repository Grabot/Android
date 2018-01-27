package cityBuilder.gameScreen.buildings;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.ArrayList;

import cityBuilder.load.Building;
import cityBuilder.load.Data;
import cityBuilder.objects.Tile;

public class Farm extends Data implements Building {

	private Tile[] farmTiles;
	private int rotation;
	private TextureRegion[] farmTexture;

	public Farm(int rotation, TextureAtlas atlas)
	{
		farmTiles = new Tile[4];
		this.rotation = rotation;
		farmTexture = new TextureRegion[4];
		farmTexture[0] = atlas.findRegion("farm1");
		farmTexture[1] = atlas.findRegion("farm2");
		farmTexture[2] = atlas.findRegion("farm3");
		farmTexture[3] = atlas.findRegion("farm4");
	}

	@Override
	public void render(Batch batch, int position, float x, float y) {
		if( position == 0 ) {
			// 1 texture is used to draw the whole farm. Make sure you don't draw it 4 times.
			batch.draw(farmTexture[rotation], x-50, y+55, 0, 0, 96, 180, 1, 1, -90, false);
		}
	}

	public void update()
	{
		//get the farm foods, think it's wrong
		farmTiles[0].setResources(farmTiles[0].getResources() - 1);
		farmTiles[1].setResources(farmTiles[1].getResources() - 1);
		farmTiles[2].setResources(farmTiles[2].getResources() - 1);
		farmTiles[3].setResources(farmTiles[3].getResources() - 1);
	}

	@Override
	public void buildBuilding(Tile[][] tiles, int x, int y, int rotation) {
		// set the correct tiles and save the farm tiles so that it can be used for update functionality
		tiles[x][y].setOccupiedFarm(0, this);
		tiles[x + 1][y].setOccupiedFarm(1, this);
		tiles[x + 1][y + 1].setOccupiedFarm(2, this);
		tiles[x][y + 1].setOccupiedFarm(3, this);

		farmTiles[0] = tiles[x][y];
		farmTiles[1] = tiles[x + 1][y];
		farmTiles[2] = tiles[x + 1][y + 1];
		farmTiles[3] = tiles[x][y + 1];
	}

	public Tile[] getFarmTiles() {
		return farmTiles;
	}
}
