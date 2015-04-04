package onzichtbaar.net.Android.CityBuilder.load;

import onzichtbaar.net.Android.CityBuilder.gameScreen.Simulation;

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
		tileTouch = simulation.getTileTouch();
		
		for( int i = 1; i < (numberOfTiles + 1); i++ )
		{
			batch.draw( SquareTileRegionGrass, -SquareTileGrass.getWidth()/2 + simulation.tiles.get(i).position.x, -SquareTileGrass.getHeight()/2 + simulation.tiles.get(i).position.y, SquareTileGrass.getWidth()/2, SquareTileGrass.getHeight()/2, SquareTileGrass.getWidth(), SquareTileGrass.getHeight(), 1, 1, -90, false);
		
			if( simulation.tiles.get(i).type == town )
			{
				batch.draw( SquareTileRegionHouse, -SquareTileHouse.getWidth()/2 + simulation.tiles.get(i).position.x, -SquareTileHouse.getHeight()/2 + simulation.tiles.get(i).position.y, SquareTileHouse.getWidth()/2, SquareTileHouse.getHeight()/2, SquareTileHouse.getWidth(), SquareTileHouse.getHeight(), 1, 1, -90, false);
			}
			else if( simulation.tiles.get(i).type == grass )
			{
			}
			else if( simulation.tiles.get(i).type == desert )
			{
				batch.draw( SquareTileRegionDirt, -SquareTileDirt.getWidth()/2 + simulation.tiles.get(i).position.x, -SquareTileDirt.getHeight()/2 + simulation.tiles.get(i).position.y, SquareTileDirt.getWidth()/2, SquareTileDirt.getHeight()/2, SquareTileDirt.getWidth(), SquareTileDirt.getHeight(), 1, 1, -90, false);
			}
			else if( simulation.tiles.get(i).type == wood )
			{
				batch.draw( SquareTileRegionWood, -SquareTileForest.getWidth()/2 + simulation.tiles.get(i).position.x, -SquareTileForest.getHeight()/2 + simulation.tiles.get(i).position.y, SquareTileForest.getWidth()/2, SquareTileForest.getHeight()/2, SquareTileForest.getWidth(), SquareTileForest.getHeight(), 1, 1, -90, false);
			}
			else if( simulation.tiles.get(i).type == dwayne )
			{
				batch.draw( SquareTileRegionDwayne, -SquareTileDwayne.getWidth()/2 + simulation.tiles.get(i).position.x, -SquareTileDwayne.getHeight()/2 + simulation.tiles.get(i).position.y, SquareTileDwayne.getWidth()/2, SquareTileDwayne.getHeight()/2, SquareTileDwayne.getWidth(), SquareTileDwayne.getHeight(), 1, 1, -90, false);
			}
			else if( simulation.tiles.get(i).type == gold )
			{
				batch.draw( SquareTileRegionGold, -SquareTileGold.getWidth()/2 + simulation.tiles.get(i).position.x, -SquareTileGold.getHeight()/2 + simulation.tiles.get(i).position.y, SquareTileGold.getWidth()/2, SquareTileGold.getHeight()/2, SquareTileGold.getWidth(), SquareTileGold.getHeight(), 1, 1, -90, false);
			}
			else if( simulation.tiles.get(i).type == water )
			{
				batch.draw( SquareTileRegionWater, -SquareTileWater.getWidth()/2 + simulation.tiles.get(i).position.x, -SquareTileWater.getHeight()/2 + simulation.tiles.get(i).position.y, SquareTileWater.getWidth()/2, SquareTileWater.getHeight()/2, SquareTileWater.getWidth(), SquareTileWater.getHeight(), 1, 1, -90, false);
			}
			else if( simulation.tiles.get(i).type == iron )
			{
				batch.draw( SquareTileRegionIron, -SquareTileIron.getWidth()/2 + simulation.tiles.get(i).position.x, -SquareTileIron.getHeight()/2 + simulation.tiles.get(i).position.y, SquareTileIron.getWidth()/2, SquareTileIron.getHeight()/2, SquareTileIron.getWidth(), SquareTileIron.getHeight(), 1, 1, -90, false);
			}
			else if( simulation.tiles.get(i).type == coal )
			{
				batch.draw( SquareTileRegionCoal, -SquareTileCoal.getWidth()/2 + simulation.tiles.get(i).position.x, -SquareTileCoal.getHeight()/2 + simulation.tiles.get(i).position.y, SquareTileCoal.getWidth()/2, SquareTileCoal.getHeight()/2, SquareTileCoal.getWidth(), SquareTileCoal.getHeight(), 1, 1, -90, false);
			}
			
			if( simulation.tiles.get(i).colour == available )
			{
			}
			else if( simulation.tiles.get(i).colour == unavailable )
			{
				SquareTileRegionUnavailable = new TextureRegion( SquareUnavailable, 0, 0, SquareUnavailable.getWidth(), SquareUnavailable.getHeight() );
				batch.draw( SquareTileRegionUnavailable, -SquareUnavailable.getWidth()/2 + simulation.tiles.get(i).position.x, -SquareUnavailable.getHeight()/2 + simulation.tiles.get(i).position.y, SquareUnavailable.getWidth()/2, SquareUnavailable.getHeight()/2, SquareUnavailable.getWidth(), SquareUnavailable.getHeight(), 1, 1, -90, false);
			}
			
			if( simulation.tiles.get(i).wall )
			{
				boolean wallTop = false;
				boolean wallLeft = false;
				boolean wallRight = false;
				boolean wallBottom = false;
				boolean wallTopLeft = false;
				boolean wallTopRight = false;
				boolean wallBottomLeft = false;
				boolean wallBottomRight = false;
				
				if( simulation.tiles.get(i - gridSizeWidth).wall )
				{
					wallTop = true;
				}
				
				if( simulation.tiles.get(i-(gridSizeWidth+1)).wall )
				{
					wallTopLeft = true;
				}
				
				if( simulation.tiles.get(i-(gridSizeWidth-1)).wall )
				{
					wallTopRight = true;
				}

				if( simulation.tiles.get(i - 1).wall )
				{
					wallLeft = true;
				}

				if( simulation.tiles.get(i + 1).wall )
				{
					wallRight = true;
				}
				
				if( simulation.tiles.get(i + gridSizeWidth).wall )
				{
					wallBottom = true;
				}
				
				if( simulation.tiles.get(i + (gridSizeWidth-1)).wall )
				{
					wallBottomLeft = true;
				}
				
				if( simulation.tiles.get(i + (gridSizeWidth+1)).wall )
				{
					wallBottomRight = true;
				}
				
				if( !wallTop && !wallLeft && !wallRight && !wallBottom )
				{	
					//no wall around it
					batch.draw( SquareTileRegionWallFull, -SquareTileWallFull.getWidth()/2 + simulation.tiles.get(i).position.x, -SquareTileWallFull.getHeight()/2 + simulation.tiles.get(i).position.y, 0, 0, SquareTileWallFull.getWidth(), SquareTileWallFull.getHeight(), 1, 1, 0, false);
				}
				else if( wallTop && !wallLeft && !wallRight && !wallBottom )
				{
					//only wall above
					batch.draw( SquareTileRegionWallTriple, -SquareTileWallTriple.getWidth()/2 + simulation.tiles.get(i).position.x, -SquareTileWallTriple.getHeight()/2 + simulation.tiles.get(i).position.y, SquareTileWallTriple.getWidth()/2, SquareTileWallTriple.getHeight()/2, SquareTileWallTriple.getWidth(), SquareTileWallTriple.getHeight(), 1, 1, 90, false);
				}
				else if( !wallTop && !wallLeft && !wallRight && wallBottom )
				{
					//only wall below
					batch.draw( SquareTileRegionWallTriple, -SquareTileWallTriple.getWidth()/2 + simulation.tiles.get(i).position.x, -SquareTileWallTriple.getHeight()/2 + simulation.tiles.get(i).position.y, SquareTileWallTriple.getWidth()/2, SquareTileWallTriple.getHeight()/2, SquareTileWallTriple.getWidth(), SquareTileWallTriple.getHeight(), 1, 1, -90, false);
				}
				else if( !wallTop && wallLeft && !wallRight && !wallBottom )
				{
					//only wall to the left
					batch.draw( SquareTileRegionWallTriple, -SquareTileWallTriple.getWidth()/2 + simulation.tiles.get(i).position.x, -SquareTileWallTriple.getHeight()/2 + simulation.tiles.get(i).position.y, SquareTileWallTriple.getWidth()/2, SquareTileWallTriple.getHeight()/2, SquareTileWallTriple.getWidth(), SquareTileWallTriple.getHeight(), 1, 1, 180, false);
				}
				else if( !wallTop && !wallLeft && wallRight && !wallBottom )
				{
					//only wall to the right
					batch.draw( SquareTileRegionWallTriple, -SquareTileWallTriple.getWidth()/2 + simulation.tiles.get(i).position.x, -SquareTileWallTriple.getHeight()/2 + simulation.tiles.get(i).position.y, SquareTileWallTriple.getWidth()/2, SquareTileWallTriple.getHeight()/2, SquareTileWallTriple.getWidth(), SquareTileWallTriple.getHeight(), 1, 1, 0, false);
				}
				else if( wallTop && wallLeft && !wallRight && !wallBottom )
				{
					//wall to the top and the left
					if( !wallTopLeft )
					{
						batch.draw( SquareTileRegionWallCorner, -SquareTileWallCorner.getWidth()/2 + simulation.tiles.get(i).position.x, -SquareTileWallCorner.getHeight()/2 + simulation.tiles.get(i).position.y, SquareTileWallCorner.getWidth()/2, SquareTileWallCorner.getHeight()/2, SquareTileWallCorner.getWidth(), SquareTileWallCorner.getHeight(), 1, 1, 90, false);
					}
					batch.draw( SquareTileRegionWallDouble, -SquareTileWallDouble.getWidth()/2 + simulation.tiles.get(i).position.x, -SquareTileWallDouble.getHeight()/2 + simulation.tiles.get(i).position.y, SquareTileWallDouble.getWidth()/2, SquareTileWallDouble.getHeight()/2, SquareTileWallDouble.getWidth(), SquareTileWallDouble.getHeight(), 1, 1, 90, false);
				}
				else if( wallTop && !wallLeft && wallRight && !wallBottom )
				{
					//wall to the top and the right
					if( !wallTopRight )
					{
						batch.draw( SquareTileRegionWallCorner, -SquareTileWallCorner.getWidth()/2 + simulation.tiles.get(i).position.x, -SquareTileWallCorner.getHeight()/2 + simulation.tiles.get(i).position.y, SquareTileWallCorner.getWidth()/2, SquareTileWallCorner.getHeight()/2, SquareTileWallCorner.getWidth(), SquareTileWallCorner.getHeight(), 1, 1, 0, false);
					}
					batch.draw( SquareTileRegionWallDouble, -SquareTileWallDouble.getWidth()/2 + simulation.tiles.get(i).position.x, -SquareTileWallDouble.getHeight()/2 + simulation.tiles.get(i).position.y, SquareTileWallDouble.getWidth()/2, SquareTileWallDouble.getHeight()/2, SquareTileWallDouble.getWidth(), SquareTileWallDouble.getHeight(), 1, 1, 0, false);
				}
				else if( wallTop && !wallLeft && !wallRight && wallBottom )
				{
					//wall to the top and the bottom
					batch.draw( SquareTileRegionWallSides, -SquareTileWallSides.getWidth()/2 + simulation.tiles.get(i).position.x, -SquareTileWallSides.getHeight()/2 + simulation.tiles.get(i).position.y, SquareTileWallSides.getWidth()/2, SquareTileWallSides.getHeight()/2, SquareTileWallSides.getWidth(), SquareTileWallSides.getHeight(), 1, 1, 90, false);
				}
				else if( !wallTop && wallLeft && wallRight && !wallBottom )
				{
					//wall to the left and the right
					batch.draw( SquareTileRegionWallSides, -SquareTileWallSides.getWidth()/2 + simulation.tiles.get(i).position.x, -SquareTileWallSides.getHeight()/2 + simulation.tiles.get(i).position.y, SquareTileWallSides.getWidth()/2, SquareTileWallSides.getHeight()/2, SquareTileWallSides.getWidth(), SquareTileWallSides.getHeight(), 1, 1, 0, false);
				}
				else if( !wallTop && wallLeft && !wallRight && wallBottom )
				{
					//wall to the left and the bottom
					if( !wallBottomLeft )
					{
						batch.draw( SquareTileRegionWallCorner, -SquareTileWallCorner.getWidth()/2 + simulation.tiles.get(i).position.x, -SquareTileWallCorner.getHeight()/2 + simulation.tiles.get(i).position.y, SquareTileWallCorner.getWidth()/2, SquareTileWallCorner.getHeight()/2, SquareTileWallCorner.getWidth(), SquareTileWallCorner.getHeight(), 1, 1, 180, false);
					}
					batch.draw( SquareTileRegionWallDouble, -SquareTileWallDouble.getWidth()/2 + simulation.tiles.get(i).position.x, -SquareTileWallDouble.getHeight()/2 + simulation.tiles.get(i).position.y, SquareTileWallDouble.getWidth()/2, SquareTileWallDouble.getHeight()/2, SquareTileWallDouble.getWidth(), SquareTileWallDouble.getHeight(), 1, 1, 180, false);
				}
				else if( !wallTop && !wallLeft && wallRight && wallBottom )
				{
					//wall to the right and the bottom
					if( !wallBottomRight )
					{
						batch.draw( SquareTileRegionWallCorner, -SquareTileWallCorner.getWidth()/2 + simulation.tiles.get(i).position.x, -SquareTileWallCorner.getHeight()/2 + simulation.tiles.get(i).position.y, SquareTileWallCorner.getWidth()/2, SquareTileWallCorner.getHeight()/2, SquareTileWallCorner.getWidth(), SquareTileWallCorner.getHeight(), 1, 1, -90, false);
					}
					batch.draw( SquareTileRegionWallDouble, -SquareTileWallDouble.getWidth()/2 + simulation.tiles.get(i).position.x, -SquareTileWallDouble.getHeight()/2 + simulation.tiles.get(i).position.y, SquareTileWallDouble.getWidth()/2, SquareTileWallDouble.getHeight()/2, SquareTileWallDouble.getWidth(), SquareTileWallDouble.getHeight(), 1, 1, -90, false);
				}
				else if( wallTop && wallLeft && wallRight && !wallBottom )
				{
					//wall to the top, to the left and to the right
					if( !wallTopLeft )
					{
						batch.draw( SquareTileRegionWallCorner, -SquareTileWallCorner.getWidth()/2 + simulation.tiles.get(i).position.x, -SquareTileWallCorner.getHeight()/2 + simulation.tiles.get(i).position.y, SquareTileWallCorner.getWidth()/2, SquareTileWallCorner.getHeight()/2, SquareTileWallCorner.getWidth(), SquareTileWallCorner.getHeight(), 1, 1, 90, false);
					}
					if( !wallTopRight )
					{
						batch.draw( SquareTileRegionWallCorner, -SquareTileWallCorner.getWidth()/2 + simulation.tiles.get(i).position.x, -SquareTileWallCorner.getHeight()/2 + simulation.tiles.get(i).position.y, SquareTileWallCorner.getWidth()/2, SquareTileWallCorner.getHeight()/2, SquareTileWallCorner.getWidth(), SquareTileWallCorner.getHeight(), 1, 1, 0, false);
					}
					batch.draw( SquareTileRegionWallSingle, -SquareTileWallSingle.getWidth()/2 + simulation.tiles.get(i).position.x, -SquareTileWallSingle.getHeight()/2 + simulation.tiles.get(i).position.y, SquareTileWallSingle.getWidth()/2, SquareTileWallSingle.getHeight()/2, SquareTileWallSingle.getWidth(), SquareTileWallSingle.getHeight(), 1, 1, 0, false);
				}
				else if( wallTop && wallLeft && !wallRight && wallBottom )
				{
					//wall to the top, to the left and to the bottom
					if( !wallTopLeft )
					{
						batch.draw( SquareTileRegionWallCorner, -SquareTileWallCorner.getWidth()/2 + simulation.tiles.get(i).position.x, -SquareTileWallCorner.getHeight()/2 + simulation.tiles.get(i).position.y, SquareTileWallCorner.getWidth()/2, SquareTileWallCorner.getHeight()/2, SquareTileWallCorner.getWidth(), SquareTileWallCorner.getHeight(), 1, 1, 90, false);
					}
					if( !wallBottomLeft )
					{
						batch.draw( SquareTileRegionWallCorner, -SquareTileWallCorner.getWidth()/2 + simulation.tiles.get(i).position.x, -SquareTileWallCorner.getHeight()/2 + simulation.tiles.get(i).position.y, SquareTileWallCorner.getWidth()/2, SquareTileWallCorner.getHeight()/2, SquareTileWallCorner.getWidth(), SquareTileWallCorner.getHeight(), 1, 1, 180, false);
					}
					batch.draw( SquareTileRegionWallSingle, -SquareTileWallSingle.getWidth()/2 + simulation.tiles.get(i).position.x, -SquareTileWallSingle.getHeight()/2 + simulation.tiles.get(i).position.y, SquareTileWallSingle.getWidth()/2, SquareTileWallSingle.getHeight()/2, SquareTileWallSingle.getWidth(), SquareTileWallSingle.getHeight(), 1, 1, 90, false);
				}
				else if( !wallTop && wallLeft && wallRight && wallBottom )
				{
					//wall to the top, to the left and to the right
					if( !wallBottomRight )
					{
						batch.draw( SquareTileRegionWallCorner, -SquareTileWallCorner.getWidth()/2 + simulation.tiles.get(i).position.x, -SquareTileWallCorner.getHeight()/2 + simulation.tiles.get(i).position.y, SquareTileWallCorner.getWidth()/2, SquareTileWallCorner.getHeight()/2, SquareTileWallCorner.getWidth(), SquareTileWallCorner.getHeight(), 1, 1, -90, false);
					}
					if( !wallBottomLeft )
					{
						batch.draw( SquareTileRegionWallCorner, -SquareTileWallCorner.getWidth()/2 + simulation.tiles.get(i).position.x, -SquareTileWallCorner.getHeight()/2 + simulation.tiles.get(i).position.y, SquareTileWallCorner.getWidth()/2, SquareTileWallCorner.getHeight()/2, SquareTileWallCorner.getWidth(), SquareTileWallCorner.getHeight(), 1, 1, 180, false);
					}
					batch.draw( SquareTileRegionWallSingle, -SquareTileWallSingle.getWidth()/2 + simulation.tiles.get(i).position.x, -SquareTileWallSingle.getHeight()/2 + simulation.tiles.get(i).position.y, SquareTileWallSingle.getWidth()/2, SquareTileWallSingle.getHeight()/2, SquareTileWallSingle.getWidth(), SquareTileWallSingle.getHeight(), 1, 1, 180, false);
				}
				else if( wallTop && !wallLeft && wallRight && wallBottom )
				{
					//wall to the top, to the right and to the bottom
					if( !wallTopRight )
					{
						batch.draw( SquareTileRegionWallCorner, -SquareTileWallCorner.getWidth()/2 + simulation.tiles.get(i).position.x, -SquareTileWallCorner.getHeight()/2 + simulation.tiles.get(i).position.y, SquareTileWallCorner.getWidth()/2, SquareTileWallCorner.getHeight()/2, SquareTileWallCorner.getWidth(), SquareTileWallCorner.getHeight(), 1, 1, 0, false);
					}
					if( !wallBottomRight )
					{
						batch.draw( SquareTileRegionWallCorner, -SquareTileWallCorner.getWidth()/2 + simulation.tiles.get(i).position.x, -SquareTileWallCorner.getHeight()/2 + simulation.tiles.get(i).position.y, SquareTileWallCorner.getWidth()/2, SquareTileWallCorner.getHeight()/2, SquareTileWallCorner.getWidth(), SquareTileWallCorner.getHeight(), 1, 1, -90, false);
					}
					batch.draw( SquareTileRegionWallSingle, -SquareTileWallSingle.getWidth()/2 + simulation.tiles.get(i).position.x, -SquareTileWallSingle.getHeight()/2 + simulation.tiles.get(i).position.y, SquareTileWallSingle.getWidth()/2, SquareTileWallSingle.getHeight()/2, SquareTileWallSingle.getWidth(), SquareTileWallSingle.getHeight(), 1, 1, -90, false);
				}
				else if( wallTop && wallLeft && wallRight && wallBottom )
				{
					if( !wallTopLeft )
					{
						batch.draw( SquareTileRegionWallCorner, -SquareTileWallCorner.getWidth()/2 + simulation.tiles.get(i).position.x, -SquareTileWallCorner.getHeight()/2 + simulation.tiles.get(i).position.y, SquareTileWallCorner.getWidth()/2, SquareTileWallCorner.getHeight()/2, SquareTileWallCorner.getWidth(), SquareTileWallCorner.getHeight(), 1, 1, 90, false);
					}
					if( !wallTopRight )
					{
						batch.draw( SquareTileRegionWallCorner, -SquareTileWallCorner.getWidth()/2 + simulation.tiles.get(i).position.x, -SquareTileWallCorner.getHeight()/2 + simulation.tiles.get(i).position.y, SquareTileWallCorner.getWidth()/2, SquareTileWallCorner.getHeight()/2, SquareTileWallCorner.getWidth(), SquareTileWallCorner.getHeight(), 1, 1, 0, false);
					}
					if( !wallBottomLeft )
					{
						batch.draw( SquareTileRegionWallCorner, -SquareTileWallCorner.getWidth()/2 + simulation.tiles.get(i).position.x, -SquareTileWallCorner.getHeight()/2 + simulation.tiles.get(i).position.y, SquareTileWallCorner.getWidth()/2, SquareTileWallCorner.getHeight()/2, SquareTileWallCorner.getWidth(), SquareTileWallCorner.getHeight(), 1, 1, 180, false);
					}
					if( !wallBottomRight )
					{
						batch.draw( SquareTileRegionWallCorner, -SquareTileWallCorner.getWidth()/2 + simulation.tiles.get(i).position.x, -SquareTileWallCorner.getHeight()/2 + simulation.tiles.get(i).position.y, SquareTileWallCorner.getWidth()/2, SquareTileWallCorner.getHeight()/2, SquareTileWallCorner.getWidth(), SquareTileWallCorner.getHeight(), 1, 1, -90, false);
					}
					//walls everywhere
				}
				else
				{
					batch.draw( SquareTileRegionWallFull, -SquareTileWallFull.getWidth()/2 + simulation.tiles.get(i).position.x, -SquareTileWallFull.getHeight()/2 + simulation.tiles.get(i).position.y, SquareTileWallFull.getWidth()/2, SquareTileWallFull.getHeight()/2, SquareTileWallFull.getWidth(), SquareTileWallFull.getHeight(), 1, 1, 0, false);
				}
			}
		}
	}
	
	public void drawSelected( Simulation simulation, Batch batch, int tileNumber )
	{
		batch.draw( SquareTileRegionSelected, (-SquareTileSelected.getWidth()/2 + simulation.tiles.get(tileNumber).position.x), (-SquareTileSelected.getHeight()/2 + simulation.tiles.get(tileNumber).position.y), 0, 0, SquareTileSelected.getWidth(), SquareTileSelected.getHeight(), 1, 1, 0, false);
	}

}