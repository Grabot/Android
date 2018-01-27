package cityBuilder.gameScreen.buildings;

import cityBuilder.load.Building;
import cityBuilder.objects.Tile;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.ArrayList;

public class Wood implements Building {
	private Tile tile;
	private int rotation;
	//private TextureRegion SquareTileRegionGrass;
	private TextureRegion SquareTileRegionTree0;
	private TextureRegion SquareTileRegionTree1;
	private TextureRegion SquareTileRegionTree2;
	private TextureRegion SquareTileRegionTree3;

	private int life;

	public Wood(Tile tile, int rotation, TextureAtlas atlas ) {
		this.rotation = rotation;
		// This can be null it will then later be filled when needed.
		this.tile = tile;
		//SquareTileRegionGrass = atlas.findRegion("Grass");
		SquareTileRegionTree0 = atlas.findRegion("treeTest4");
		SquareTileRegionTree1 = atlas.findRegion("treeTest3");
		SquareTileRegionTree2 = atlas.findRegion("treeTest2");
		SquareTileRegionTree3 = atlas.findRegion("treeTest");

		life = 1000;
	}

	@Override
	public void render(Batch batch, int buildingPosition, float x, float y) {
		// the more life the tree has, the bigger it is.
		if ( life <= 180) {
			batch.draw(SquareTileRegionTree0, -26 + tile.getPosition().x, 31 + tile.getPosition().y, 0, 0, 60, 60, 1, 1, -90, false);
		} else if ( life > 180 && life <= 360) {
			batch.draw(SquareTileRegionTree1, -29 + tile.getPosition().x, 36 + tile.getPosition().y, 0, 0, 60, 60, 1, 1, -90, false);
		} else if ( life > 360 && life <= 540) {
			batch.draw(SquareTileRegionTree2, -34 + tile.getPosition().x, 41 + tile.getPosition().y, 0, 0, 60, 60, 1, 1, -90, false);
		} else if ( life > 540 && life <= 720 ) {
			batch.draw(SquareTileRegionTree3, -40 + tile.getPosition().x, 45 + tile.getPosition().y, 0, 0, 60, 60, 1, 1, -90, false);
		} else if ( life > 720 && life <= 900) {
			batch.draw(SquareTileRegionTree3, -40 + tile.getPosition().x, 45 + tile.getPosition().y, 0, 0, 60, 60, 1, 1, -90, false);
		} else if ( life > 900) {
			batch.draw(SquareTileRegionTree3, -40 + tile.getPosition().x, 45 + tile.getPosition().y, 0, 0, 60, 60, 1, 1, -90, false);
		}
	}

	@Override
	public void update() {
		life+=1;
		// 1000 is the maximum.
		if (life > 1000) {
			life = 1000;
		}
	}

	@Override
	public void buildBuilding(Tile[][] tiles, int x, int y, int rotation) {
		tile = tiles[x][y];
		tile.setOccupiedWood(0, rotation, this);
	}

	public int getLife() {
		return life;
	}

	public void setLife(int life) {
		this.life = life;
	}
}