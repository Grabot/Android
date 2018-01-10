package cityBuilder.gameScreen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button.ButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton.ImageButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

import java.util.ArrayList;

import cityBuilder.load.BuildingAvailabilityControl;
import cityBuilder.load.Data;
import cityBuilder.load.DrawTiles;
import cityBuilder.load.TouchInput;
import cityBuilder.load.Vector;
import cityBuilder.load.build.buildActor;
import cityBuilder.load.inventory.InventoryActor;
import cityBuilder.load.tileInfo.tileInfo;
import cityBuilder.objects.Citizen;
import cityBuilder.objects.Tile;

public class Renderer extends Data
{
	private ArrayList<Citizen> citizens = new ArrayList<Citizen>();
	private Tile[][] tiles;
	private ArrayList<Tile> roadSelected = new ArrayList<Tile>();
	private ArrayList<Tile> woodSelected = new ArrayList<Tile>();
	public static final String LOG = Renderer.class.getSimpleName();

	private boolean initialClose = false;
	private boolean initialOpen = true;

	private TouchInput inputHandler;
	private DrawTiles drawTiles;

	private Stage stage;
	private OrthographicCamera camera;
	private SpriteBatch batch;

	private int x = -1;
	private int y = -1;
	private int previousRoadX = -1;
	private int previousRoadY = -1;
	private int previousWoodX = -1;
	private int previousWoodY = -1;
	private int previousWarehouseX = -1;
	private int previousWarehouseY = -1;
	private boolean trueRoadSelectionPress = false;
	private boolean trueWoodSelectionPress = false;

	private boolean inventoryOn = false;

	private TextButton inventoryButton;
	private TextButton rotateMapLeftButton;
	private TextButton rotateMapRightButton;
	private TextButton buildBuildingButton;

	private TextButton buildingRotationButton;

	private Texture progressBar;
	private Texture progressBarFill;

	private GameScreen game;

	private Simulation simulation;
	private tileInfo tileinfo;

	private TextureRegion progressRegion;
	private TextureRegion progressFillRegion;

	private InventoryActor inventoryActor;
	private TextureAtlas atlas;
	private buildActor builder;

	private int rotation = 0;

	private BuildingAvailabilityControl buildingAvailabilityControl;

	public Renderer( GameScreen game, OrthographicCamera camera, Stage stage, SpriteBatch batch,
					 TextureAtlas atlas, InventoryActor inventoryActor, buildActor builder,
					 tileInfo tileinfo, ArrayList<Citizen> citizens, Tile[][] tiles)
	{
		this.citizens = citizens;
		this.game = game;
		this.inventoryActor = inventoryActor;
		this.builder = builder;
		this.tileinfo = tileinfo;
		this.tiles = tiles;

		this.atlas = atlas;

		progressBar = new Texture( Gdx.files.internal( "data/progressBar.png" ));
		progressBarFill = new Texture( Gdx.files.internal( "data/progressBarFill.png" ));

		progressRegion = new TextureRegion( progressBar, 0, 0, progressBar.getWidth(), progressBar.getHeight() );
		progressFillRegion = new TextureRegion( progressBarFill, 0, 0, progressBarFill.getWidth(), progressBarFill.getHeight() );

		inputHandler = new TouchInput( camera );
		drawTiles = new DrawTiles(atlas);

		buildingAvailabilityControl = new BuildingAvailabilityControl(atlas);

		this.stage = stage;
		this.camera = camera;
		this.batch = batch;

		drawStage();
	}

	public void render(Simulation simulation ) {
		this.simulation = simulation;
		inputHandler.variables( camera, simulation );

		drawTiles.fillTiles( batch, tiles );

		this.x = simulation.tileTouchX();
		this.y = simulation.tileTouchY();
		if( !inventoryOn ) {

			if (simulation.getBuildingFase()) {
				drawTiles.drawRegionOwned(batch, tiles);
			}

			if( simulation.getBuildingFarm() ) {
				buildingRotationButton.setVisible( true );
				inventoryButton.setVisible(false);
				if (validTile()) {
					// drawing control for the farm
					buildBuildingButton.setVisible(true);
					buildingAvailabilityControl.buildingControl(buildBuildingButton, batch, tiles[x][y], 0, 0);
					buildingAvailabilityControl.buildingControl(buildBuildingButton, batch, tiles[x + 1][y], 0, 1);
					buildingAvailabilityControl.buildingControl(buildBuildingButton, batch, tiles[x + 1][y + 1], 0, 2);
					buildingAvailabilityControl.buildingControl(buildBuildingButton, batch, tiles[x][y + 1], 0, 3);
				}
			} else if( simulation.getBuildingWoodCutter()) {
				buildingRotationButton.setVisible( true );
				inventoryButton.setVisible(false);
				if (validTile()) {

					buildingAvailabilityControl.OutlineAvailability(tiles, batch, x, y, 2, 3);
					buildBuildingButton.setVisible(true);
					buildingAvailabilityControl.buildingControl(buildBuildingButton, batch, tiles[x][y], 2, 0);
					buildingAvailabilityControl.buildingControl(buildBuildingButton, batch, tiles[x + 1][y], 2, 1);
					buildingAvailabilityControl.buildingControl(buildBuildingButton, batch, tiles[x + 1][y + 1], 2, 2);
					buildingAvailabilityControl.buildingControl(buildBuildingButton, batch, tiles[x][y + 1], 2, 3);
				}
			} else if( simulation.getBuildingWarehouse() ) {
				buildingRotationButton.setVisible( true );
				inventoryButton.setVisible(false);
				if (validTile()) {
					if (previousWarehouseX != x || previousWarehouseY != y) {
						previousWarehouseX = x;
						previousWarehouseY = y;
						// check all possible rotations, so 4 different possibilities.
						for (int i = 0; i < 4; i++) {
							boolean available = buildingAvailabilityControl.checkRotationPossibility(true, rotation, tiles[x][y], 0, 3);
							available = buildingAvailabilityControl.checkRotationPossibility(available, rotation, tiles[x + 1][y], 1, 3);
							available = buildingAvailabilityControl.checkRotationPossibility(available, rotation, tiles[x + 1][y + 1], 2, 3);
							available = buildingAvailabilityControl.checkRotationPossibility(available, rotation, tiles[x][y + 1], 3, 3);
							available = buildingAvailabilityControl.checkRotationPossibility(available, rotation, tiles[x - 1][y + 1], 4, 3);
							available = buildingAvailabilityControl.checkRotationPossibility(available, rotation, tiles[x - 1][y], 5, 3);
							available = buildingAvailabilityControl.checkRotationPossibility(available, rotation, tiles[x - 1][y - 1], 6, 3);
							available = buildingAvailabilityControl.checkRotationPossibility(available, rotation, tiles[x][y - 1], 7, 3);
							available = buildingAvailabilityControl.checkRotationPossibility(available, rotation, tiles[x + 1][y - 1], 8, 3);

							if (available) {
								break;
							}
							rotate();
						}
					}

					buildingAvailabilityControl.OutlineAvailability(tiles, batch, x, y, 1, 16);
					buildBuildingButton.setVisible(true);
					buildingAvailabilityControl.buildingControl(buildBuildingButton, batch, tiles[x][y], 3, 0);
					buildingAvailabilityControl.buildingControl(buildBuildingButton, batch, tiles[x + 1][y], 3, 1);
					buildingAvailabilityControl.buildingControl(buildBuildingButton, batch, tiles[x + 1][y + 1], 3, 2);
					buildingAvailabilityControl.buildingControl(buildBuildingButton, batch, tiles[x][y + 1], 3, 3);
					buildingAvailabilityControl.buildingControl(buildBuildingButton, batch, tiles[x - 1][y + 1], 3, 4);
					buildingAvailabilityControl.buildingControl(buildBuildingButton, batch, tiles[x - 1][y], 3, 5);
					buildingAvailabilityControl.buildingControl(buildBuildingButton, batch, tiles[x - 1][y - 1], 3, 6);
					buildingAvailabilityControl.buildingControl(buildBuildingButton, batch, tiles[x][y - 1], 3, 7);
					buildingAvailabilityControl.buildingControl(buildBuildingButton, batch, tiles[x + 1][y - 1], 3, 8);
				}
			} else if( simulation.getBuildingRoad()) {
				boolean remove = false;
				buildingRotationButton.setVisible( true );
				inventoryButton.setVisible(false);
				if (validTile()) {
					// ugly way to ensure that the selected tile is selected by the user. It will
					// give a single frame different tile selection. This will ignore that situation
					if (trueRoadSelectionPress) {
						if (previousRoadX != x || previousRoadY != y) {
							previousRoadX = x;
							previousRoadY = y;
							for (Tile tile : roadSelected) {
								if (tile == tiles[x][y]) {
									remove = true;
								}
							}
							if (remove) {
								roadSelected.remove(tiles[x][y]);
							} else {
								if (roadSelected.size() < simulation.getRoadSize()) {
									roadSelected.add(tiles[x][y]);
								}
							}
						}
					}
					trueRoadSelectionPress = true;
					buildBuildingButton.setVisible(true);
					for (Tile tile : roadSelected) {
						buildingAvailabilityControl.buildingControl(buildBuildingButton, batch, tile, 4, 0);
					}
				}

			} else if( simulation.getBuildingTree()) {
				boolean remove = false;
				buildingRotationButton.setVisible( true );
				inventoryButton.setVisible(false);
				if (validTile()) {
					// ugly way to ensure that the selected tile is selected by the user. It will
					// give a single frame different tile selection. This will ignore that situation
					if (trueWoodSelectionPress) {
						if (previousWoodX != x || previousWoodY != y) {
							previousWoodX = x;
							previousWoodY = y;
							for (Tile tile : woodSelected) {
								if (tile == tiles[x][y]) {
									remove = true;
								}
							}
							if (remove) {
								woodSelected.remove(tiles[x][y]);
							} else {
								if (woodSelected.size() < simulation.getWoodSize()) {
									System.out.println("test add");
									woodSelected.add(tiles[x][y]);
								}
							}
						}
					}
					trueWoodSelectionPress = true;
					buildBuildingButton.setVisible(true);
					for (Tile tile : woodSelected) {
						buildingAvailabilityControl.buildingControl(buildBuildingButton, batch, tile, 5, 0);
					}
				}
			} else {
				buildingRotationButton.setVisible( false );
				inventoryButton.setVisible(true);
				buildBuildingButton.setVisible( false );


				if(validTile()) {
					tileinfo.setText(x, y, tiles[x][y]);
					tileinfo.setPosition( (simulation.getTouchX() + 100), (720 - simulation.getTouchY()) );
					tileinfo.setVisible( true );
					drawTiles.drawSelected( buildingAvailabilityControl, tiles, batch, atlas, x, y );
				} else {
					tileinfo.setVisible( false );
				}

			}
			inputHandler.MapScroll(simulation.getBuildingRoad(), simulation.getBuildingTree());
			inputHandler.MapZoom();

			if (!simulation.getTouchedDown()) {
				trueRoadSelectionPress = false;
				trueWoodSelectionPress = false;
			}

			if( initialClose ) {
				initialClose = false;
				initialOpen = true;
				inventoryActor.clearLabels();
				builder.clearLabels();
				inventoryActor.setVisible( false );
				builder.setVisible(false);
			}
		} else {
			tileinfo.setVisible( false );

			if( simulation.getBuildingFarm() ) {
				inventoryOn = false;
			} else if( simulation.getBuildingWoodCutter() ) {
				inventoryOn = false;
			} else if( simulation.getBuildingWarehouse() ) {
				inventoryOn = false;
			} else if (simulation.getBuildingRoad()) {
				inventoryOn = false;
			} else if (simulation.getBuildingTree()) {
				inventoryOn = false;
			}

			if( initialOpen ) {
				initialOpen = false;
				initialClose = true;
				inventoryActor.setVisible( true );
				builder.setVisible( true );
				inventoryActor.addAmountLabels();
			}
		}

		drawTiles.drawBuildingInformation(batch, tiles);
	}


	private void drawStage() {
		Skin skin = new Skin(Gdx.files.internal("data/uiskin.json"));

		inventoryButton = new TextButton( "inventory", skin );
		inventoryButton.setDisabled( false );
		inventoryButton.setBounds( 1150, 30, 100, 100);
		inventoryButton.setVisible( true );

		rotateMapLeftButton = new TextButton( "Rotate map left", skin);
		rotateMapLeftButton.setDisabled( false );
		rotateMapLeftButton.setBounds(20, 550, 100, 100);
		rotateMapLeftButton.setVisible(true);

		rotateMapRightButton = new TextButton( "Rotate map right", skin);
		rotateMapRightButton.setDisabled( false );
		rotateMapRightButton.setBounds(130, 550, 100, 100);
		rotateMapRightButton.setVisible(true);

		buildBuildingButton = new TextButton( "Build Farm", skin );
		buildBuildingButton.setDisabled( false );
		buildBuildingButton.setBounds( 1000,  300, 200, 30 );
		buildBuildingButton.setVisible( false );

		buildingRotationButton = new TextButton("Rotate" , skin );
		buildingRotationButton.setDisabled( false );
		buildingRotationButton.setBounds(1150, 500, 100, 100);
		buildingRotationButton.setVisible( false );

		TextureAtlas icons = new TextureAtlas(Gdx.files.internal("icons/Output10.atlas"));
		TextureRegion image;
		image = icons.findRegion("empty");
		ImageButtonStyle style = new ImageButtonStyle(skin.get(ButtonStyle.class));
		style.imageUp = new TextureRegionDrawable(image);
		style.imageDown = new TextureRegionDrawable(image);

		stage.addActor( inventoryButton );
		stage.addActor(rotateMapLeftButton);
		stage.addActor(rotateMapRightButton);
		stage.addActor( inventoryActor );
		stage.addActor(buildBuildingButton);
		stage.addActor( buildingRotationButton );
		stage.addActor( builder );
		stage.addActor( tileinfo );

		inventoryButton.addListener( InventoryListener );
		rotateMapLeftButton.addListener(rotateMapLeftListener);
		rotateMapRightButton.addListener(rotateMapRightListener);
		buildBuildingButton.addListener( buildBuildingListener );
		buildingRotationButton.addListener( buildingRotationListener );
	}

	public ClickListener InventoryListener = new ClickListener() {
		@Override
		public void clicked (InputEvent event, float x, float y) {
			inventoryOn = !inventoryOn;
		}
	};

	public ClickListener rotateMapLeftListener = new ClickListener() {
		@Override
		public void clicked(InputEvent event, float x, float y) {
			Vector[][] locations = new Vector[tiles.length][tiles.length];
			for( int i = 0; i < tiles.length; i++ ) {
				for( int j = 0; j < tiles.length; j++ ) {
					locations[i][j] = new Vector(tiles[i][j].getPosition());
				}
			}
			for( int i = 0; i < tiles.length; i++ ) {
				for (int j = 0; j < tiles.length; j++) {
					tiles[i][j].setPosition(locations[j][tiles.length - i - 1]);
				}
			}
			// easy hack for opposite rotation.
			rotate();
			rotate();
			rotate();
			simulation.globalRotate();
			simulation.globalRotate();
			simulation.globalRotate();
		}
	};

	public ClickListener rotateMapRightListener = new ClickListener() {
		@Override
		public void clicked(InputEvent event, float x, float y) {
			Vector[][] locations = new Vector[tiles.length][tiles.length];
			for( int i = 0; i < tiles.length; i++ ) {
				for( int j = 0; j < tiles.length; j++ ) {
					locations[i][j] = new Vector(tiles[i][j].getPosition());
				}
			}
			for( int i = 0; i < tiles.length; i++ ) {
				for (int j = 0; j < tiles.length; j++) {
					tiles[i][j].setPosition(locations[tiles.length - j - 1][i]);
				}
			}
			rotate();
			simulation.globalRotate();
		}
	};

	public ClickListener buildBuildingListener = new ClickListener() {
		@Override
		public void clicked (InputEvent event, float xPress, float yPress) {
			if( simulation.getBuildingFarm() ) {
				simulation.BuildingConfirmation(0, rotation, x, y);
			} else if( simulation.getBuildingWarehouse() ) {
				simulation.BuildingConfirmation(1, rotation, x, y);
			} else if( simulation.getBuildingWoodCutter() ) {
				simulation.BuildingConfirmation(2, rotation, x, y);
			}else if( simulation.getBuildingRoad()) {
				simulation.BuildingConfirmationRoad(rotation, roadSelected);
				roadSelected.clear();
			} else if (simulation.getBuildingTree()) {
				simulation.buildingConfirmationWood(rotation, woodSelected);
				woodSelected.clear();
			}
			inventoryActor.clearLabels();
		}
	};

	public ClickListener buildingRotationListener = new ClickListener() {
		@Override
		public void clicked (InputEvent event, float x, float y) {
			rotate();
		}
	};

	private void rotate() {
		rotation ++;
		// We have 4 degrees of rotation 0, 1, 2 and 3 if it's 4 we want it to be 0
		if (rotation == 4) {
			rotation = 0;
		}

		buildingAvailabilityControl.rotationControl(rotation);
	}

	public void dispose()
	{
		stage.clear();
	}

	private boolean validTile() {
		// return ((x >= 0 && y >= 0) && ( x < gridSizeWidth && y < gridSizeHeight));
		return ((x >= 0 && y >= 0) && ( x < gridSizeWidth && y < gridSizeHeight));
	}
}