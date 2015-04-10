package Load;

import tile.TileType;
import GameScreen.Simulation;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;

public class DrawTiles extends Data
{
	private DisplayInfoBox infoBoxDisplay;
	
	private Texture SquareTileGrass;
	private Texture SquareTileGold;
	private Texture SquareTileWater;
	private Texture SquareTileIron;
	private Texture SquareTileCoal;
	private Texture SquareTileDirt;
	private Texture SquareTileForest;
	private Texture SquareTileSelected;
	private Texture SquareUnavailable;
	private Texture SquareTileDwayne;
	private Texture SquareTileWallFull;
	private Texture SquareTileWallTriple;
	private Texture SquareTileWallDouble;
	private Texture SquareTileWallCorner;
	private Texture SquareTileWallSides;
	private Texture SquareTileWallSingle;
	private Texture SquareTileHouse;
	private Texture InfoBox;
	
	private TextureRegion SquareTileRegionSelected;
	private TextureRegion SquareTileRegionUnavailable;
	private TextureRegion SquareTileRegionWallFull;
	private TextureRegion SquareTileRegionWallTriple;
	private TextureRegion SquareTileRegionWallDouble;
	private TextureRegion SquareTileRegionWallCorner;
	private TextureRegion SquareTileRegionWallSides;
	private TextureRegion SquareTileRegionWallSingle;
	private TextureRegion SquareTileRegionHouse;
	private TextureRegion SquareTileRegionGold;
	private TextureRegion SquareTileRegionIron;
	private TextureRegion SquareTileRegionCoal;
	private TextureRegion SquareTileRegionWater;
	private TextureRegion SquareTileRegionGrass;
	private TextureRegion SquareTileRegionDirt;
	private TextureRegion SquareTileRegionWood;
	private TextureRegion SquareTileRegionDwayne;
	private TextureRegion region;
	
	private boolean[] tileTouch = new boolean[105];
	
	private int rotate = 0;
	
	public DrawTiles()
	{		
		infoBoxDisplay = new DisplayInfoBox();
		
		SquareUnavailable = new Texture( Gdx.files.internal( "images/SquareGreySmall.png" ));
		SquareTileGrass = new Texture( Gdx.files.internal( "images/Grass.png" ));
		SquareTileGold = new Texture( Gdx.files.internal( "images/resources/goldOreSmall.png" ));
		SquareTileWater = new Texture( Gdx.files.internal( "images/resources/water.png" ));
		SquareTileIron = new Texture( Gdx.files.internal( "images/resources/ironOreSmall.png" ));
		SquareTileCoal = new Texture( Gdx.files.internal( "images/resources/coalOreSmall.png" ));
		SquareTileDirt =  new Texture( Gdx.files.internal( "images/dirt.png" ));
		SquareTileForest = new Texture( Gdx.files.internal( "images/pinetree.png" ));
		SquareTileSelected = new Texture( Gdx.files.internal( "images/SquareSelectedSmall.png" ));
		SquareTileDwayne = new Texture( Gdx.files.internal( "images/Rock3.png" ));
		SquareTileWallFull = new Texture( Gdx.files.internal( "images/Village-wall1.png" ));
		SquareTileWallTriple = new Texture( Gdx.files.internal( "images/muur-noord2.png" ));
		SquareTileWallDouble = new Texture( Gdx.files.internal( "images/muur-hoek-linksboven.png" ));
		SquareTileWallCorner = new Texture( Gdx.files.internal( "images/muur-corner.png" ));
		SquareTileWallSides = new Texture( Gdx.files.internal( "images/muur-sides.png" ));
		SquareTileWallSingle = new Texture( Gdx.files.internal( "images/muur-single.png" ));
		SquareTileHouse = new Texture( Gdx.files.internal( "images/HouseBrown.png" ));
		InfoBox = new Texture( Gdx.files.internal( "images/UITest.png" ));
		
		SquareTileRegionSelected = new TextureRegion( SquareTileSelected, 0, 0, SquareTileSelected.getWidth(), SquareTileSelected.getHeight() );
		SquareTileRegionWallFull = new TextureRegion( SquareTileWallFull, 0, 0, SquareTileWallFull.getWidth(), SquareTileWallFull.getHeight() );
		SquareTileRegionWallTriple = new TextureRegion( SquareTileWallTriple, 0, 0, SquareTileWallTriple.getWidth(), SquareTileWallTriple.getHeight() );
		SquareTileRegionWallDouble = new TextureRegion( SquareTileWallDouble, 0, 0, SquareTileWallDouble.getWidth(), SquareTileWallDouble.getHeight() );
		SquareTileRegionWallCorner = new TextureRegion( SquareTileWallCorner, 0, 0, SquareTileWallCorner.getWidth(), SquareTileWallCorner.getHeight() );
		SquareTileRegionWallSides = new TextureRegion( SquareTileWallSides, 0, 0, SquareTileWallSides.getWidth(), SquareTileWallSides.getHeight() );
		SquareTileRegionWallSingle = new TextureRegion( SquareTileWallSingle, 0, 0, SquareTileWallSingle.getWidth(), SquareTileWallSingle.getHeight() );
		SquareTileRegionHouse = new TextureRegion( SquareTileHouse, 0, 0, SquareTileHouse.getWidth(), SquareTileHouse.getHeight() );
		SquareTileRegionGrass = new TextureRegion( SquareTileGrass, 0, 0, SquareTileGrass.getWidth(), SquareTileGrass.getHeight() );
		SquareTileRegionGold = new TextureRegion( SquareTileGold, 0, 0, SquareTileGold.getWidth(), SquareTileGold.getHeight() );
		SquareTileRegionCoal = new TextureRegion( SquareTileCoal, 0, 0, SquareTileCoal.getWidth(), SquareTileCoal.getHeight() );
		SquareTileRegionIron = new TextureRegion( SquareTileIron, 0, 0, SquareTileIron.getWidth(), SquareTileIron.getHeight() );
		SquareTileRegionWater = new TextureRegion( SquareTileWater, 0, 0, SquareTileWater.getWidth(), SquareTileWater.getHeight() );
		SquareTileRegionDirt = new TextureRegion( SquareTileDirt, 0, 0, SquareTileDirt.getWidth(), SquareTileDirt.getHeight() );
		SquareTileRegionWood = new TextureRegion( SquareTileForest, 0, 0, SquareTileForest.getWidth(), SquareTileForest.getHeight() );
		SquareTileRegionDwayne = new TextureRegion( SquareTileDwayne, 0, 0, SquareTileDwayne.getWidth(), SquareTileDwayne.getHeight() );
		
		region = new TextureRegion(InfoBox, 0, 0, InfoBox.getWidth(), InfoBox.getHeight());
	}
	

	public void fillTiles( Simulation simulation, Batch batch )
	{
		//tileTouch = simulation.getTileTouch();
		
		for( int i = 1; i < (numberOfTiles + 1); i++ )
		{
			batch.draw( SquareTileRegionGrass, -SquareTileGrass.getWidth()/2 + 0, -SquareTileGrass.getHeight()/2 + 0, SquareTileGrass.getWidth()/2, SquareTileGrass.getHeight()/2, SquareTileGrass.getWidth(), SquareTileGrass.getHeight(), 1, 1, -90, false);
		
			
		}
	}
	
	public void drawSelected( Simulation simulation, Batch batch, int tileNumber )
	{
		//batch.draw( SquareTileRegionSelected, (-SquareTileSelected.getWidth()/2 + simulation.tiles.get(tileNumber).getPosition().x), (-SquareTileSelected.getHeight()/2 + simulation.tiles.get(tileNumber).getPosition().y), 0, 0, SquareTileSelected.getWidth(), SquareTileSelected.getHeight(), 1, 1, 0, false);
	}

}
