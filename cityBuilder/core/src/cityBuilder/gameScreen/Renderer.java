package cityBuilder.gameScreen;

import java.util.ArrayList;

import cityBuilder.load.BuildingAvailabilityControl;
import cityBuilder.load.Data;
import cityBuilder.load.DrawTiles;
import cityBuilder.load.TouchInput;
import cityBuilder.load.build.buildActor;
import cityBuilder.load.build.buildInventory;
import cityBuilder.load.inventory.Inventory;
import cityBuilder.load.inventory.InventoryActor;
import cityBuilder.load.tileInfo.tileInfo;
import cityBuilder.objects.Citizen;

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

public class Renderer extends Data
{
	private  ArrayList<Citizen> citizens = new ArrayList<Citizen>();

	public static final String LOG = Renderer.class.getSimpleName();

	private boolean initialClose = false;
	private boolean initialOpen = true;

	private TouchInput inputHandler;
	private DrawTiles drawTiles;

	private Stage stage;
	private OrthographicCamera camera;
	private SpriteBatch batch;

	private int selectedTile = -1;

	private boolean inventoryOn = false;

	private TextButton inventoryButton;
	private TextButton BuildBuildingButton;

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

	private boolean touchedBox = false;

	private BuildingAvailabilityControl buildingAvailabilityControl;

	public Renderer( GameScreen game, OrthographicCamera camera, Stage stage, SpriteBatch batch, TextureAtlas atlas, Inventory inventory, InventoryActor inventoryActor, buildInventory buildInv, buildActor builder, tileInfo tileinfo,  ArrayList<Citizen> citizens )
	{
		this.citizens = citizens;
		this.game = game;
		this.inventoryActor = inventoryActor;
		this.builder = builder;
		this.tileinfo = tileinfo;

		float width = Gdx.graphics.getWidth();
		float height = Gdx.graphics.getHeight();

		this.atlas = atlas;

		progressBar = new Texture( Gdx.files.internal( "data/progressBar.png" ));
		progressBarFill = new Texture( Gdx.files.internal( "data/progressBarFill.png" ));

		progressRegion = new TextureRegion( progressBar, 0, 0, progressBar.getWidth(), progressBar.getHeight() );
		progressFillRegion = new TextureRegion( progressBarFill, 0, 0, progressBarFill.getWidth(), progressBarFill.getHeight() );

		inputHandler = new TouchInput( camera, width, height );
		drawTiles = new DrawTiles(atlas);

		buildingAvailabilityControl = new BuildingAvailabilityControl(atlas);

		this.stage = stage;
		this.camera = camera;
		this.batch = batch;

		drawStage();
	}

	public void DrawImages( Simulation simulation )
	{
		this.simulation = simulation;
		inputHandler.variables( camera, simulation );

		drawTiles.fillTiles( buildingAvailabilityControl, simulation, batch );

		if( !inventoryOn ) {
			if( simulation.getBuildingFarm() ) {
				inventoryButton.setVisible(false);
				this.selectedTile = simulation.TileTouch();
				if( selectedTile >= 0 && selectedTile < numberOfTiles ) {
					// drawing control for the farm
					buildingAvailabilityControl.buildingAvailability(batch, simulation.tiles.get(selectedTile), 0, 0);
					buildingAvailabilityControl.buildingAvailability(batch, simulation.tiles.get(selectedTile+1), 0, 1);
					buildingAvailabilityControl.buildingAvailability(batch,  simulation.tiles.get((selectedTile-gridSizeWidth)+1), 0, 2);
					buildingAvailabilityControl.buildingAvailability(batch,  simulation.tiles.get(selectedTile-gridSizeWidth), 0, 3);

					// button control for the farm, it's size is 4.
					BuildBuildingButton.setVisible(true);
					buildingAvailabilityControl.buttonAvailability(BuildBuildingButton, simulation.tiles.get(selectedTile), 0, 0);
					buildingAvailabilityControl.buttonAvailability(BuildBuildingButton, simulation.tiles.get(selectedTile+1), 0, 1);
					buildingAvailabilityControl.buttonAvailability(BuildBuildingButton, simulation.tiles.get((selectedTile-gridSizeWidth)+1), 0, 2);
					buildingAvailabilityControl.buttonAvailability(BuildBuildingButton, simulation.tiles.get(selectedTile-gridSizeWidth), 0, 3);
				}
			} else if( simulation.getBuildingWoodCutter() ) {
				inventoryButton.setVisible(false);
				this.selectedTile = simulation.TileTouch();
				if( selectedTile >= 0 && selectedTile < numberOfTiles )	{
					buildingAvailabilityControl.OutlineAvailability( simulation, batch, selectedTile, 2, 0, 3 );

					buildingAvailabilityControl.buildingAvailability(batch, simulation.tiles.get(selectedTile), 2, 0);
					buildingAvailabilityControl.buildingAvailability(batch, simulation.tiles.get(selectedTile+1), 2, 1);
					buildingAvailabilityControl.buildingAvailability(batch,  simulation.tiles.get((selectedTile-gridSizeWidth)+1), 2, 2);
					buildingAvailabilityControl.buildingAvailability(batch,  simulation.tiles.get(selectedTile-gridSizeWidth), 2, 3);

					BuildBuildingButton.setVisible(true);
					buildingAvailabilityControl.buttonAvailability(BuildBuildingButton, simulation.tiles.get(selectedTile), 2, 0);
					buildingAvailabilityControl.buttonAvailability(BuildBuildingButton, simulation.tiles.get(selectedTile+1), 2, 1);
					buildingAvailabilityControl.buttonAvailability(BuildBuildingButton, simulation.tiles.get((selectedTile-gridSizeWidth)+1), 2, 2);
					buildingAvailabilityControl.buttonAvailability(BuildBuildingButton, simulation.tiles.get(selectedTile-gridSizeWidth), 2, 3);
				}
			} else if( simulation.getBuildingWarehouse() ) {
				inventoryButton.setVisible(false);
				this.selectedTile = simulation.TileTouch();
				if( selectedTile >= 0 && selectedTile < numberOfTiles )	{
					buildingAvailabilityControl.OutlineAvailability( simulation, batch, selectedTile, 1, 0, 16  );

					buildingAvailabilityControl.buildingAvailability(batch, simulation.tiles.get(selectedTile), 1, 0);
					buildingAvailabilityControl.buildingAvailability(batch, simulation.tiles.get(selectedTile+1), 1, 1);
					buildingAvailabilityControl.buildingAvailability(batch, simulation.tiles.get((selectedTile-gridSizeWidth)-1), 1, 2);
					buildingAvailabilityControl.buildingAvailability(batch, simulation.tiles.get(selectedTile-gridSizeWidth), 1, 3);
					buildingAvailabilityControl.buildingAvailability(batch, simulation.tiles.get((selectedTile-gridSizeWidth)+1), 1, 4);
					buildingAvailabilityControl.buildingAvailability(batch, simulation.tiles.get(selectedTile-1), 1, 5);
					buildingAvailabilityControl.buildingAvailability(batch, simulation.tiles.get((selectedTile+gridSizeWidth)-1), 1, 6);
					buildingAvailabilityControl.buildingAvailability(batch, simulation.tiles.get((selectedTile+gridSizeWidth)), 1, 7);
					buildingAvailabilityControl.buildingAvailability(batch, simulation.tiles.get((selectedTile+gridSizeWidth)+1), 1, 8);

					BuildBuildingButton.setVisible(true);
					buildingAvailabilityControl.buttonAvailability(BuildBuildingButton, simulation.tiles.get(selectedTile), 1, 0);
					buildingAvailabilityControl.buttonAvailability(BuildBuildingButton, simulation.tiles.get(selectedTile+1), 1, 1);
					buildingAvailabilityControl.buttonAvailability(BuildBuildingButton, simulation.tiles.get((selectedTile-gridSizeWidth)+1), 1, 2);
					buildingAvailabilityControl.buttonAvailability(BuildBuildingButton, simulation.tiles.get(selectedTile-gridSizeWidth), 1, 3);
					buildingAvailabilityControl.buttonAvailability(BuildBuildingButton, simulation.tiles.get((selectedTile-gridSizeWidth)-1), 1, 4);
					buildingAvailabilityControl.buttonAvailability(BuildBuildingButton, simulation.tiles.get(selectedTile-1), 1, 5);
					buildingAvailabilityControl.buttonAvailability(BuildBuildingButton, simulation.tiles.get((selectedTile+gridSizeWidth)-1), 1, 6);
					buildingAvailabilityControl.buttonAvailability(BuildBuildingButton, simulation.tiles.get((selectedTile+gridSizeWidth)), 1, 7);
					buildingAvailabilityControl.buttonAvailability(BuildBuildingButton, simulation.tiles.get((selectedTile+gridSizeWidth)+1), 1, 8);
				}
			} else {
				inventoryButton.setVisible(true);
				BuildBuildingButton.setVisible( false );
				touchedBox = simulation.touchedInfobox(tileinfo.getX(), tileinfo.getY(), tileinfo.getWidth(), tileinfo.getHeight());
				this.selectedTile = simulation.TileTouch();

				if( (selectedTile >= 0) && (selectedTile < numberOfTiles) ) {
					if(!touchedBox) {
						tileinfo.setText(selectedTile, simulation);
						tileinfo.setPosition( (simulation.getTouchX() + 100), (720 - simulation.getTouchY()) );
						tileinfo.setVisible( true );
						drawTiles.drawSelected( buildingAvailabilityControl, simulation, batch, atlas, selectedTile );
					}
				} else {
					tileinfo.setVisible( false );
				}

			}
			inputHandler.MapScroll();
			inputHandler.MapZoom();

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
			}

			if( initialOpen ) {
				initialOpen = false;
				initialClose = true;
				inventoryActor.setVisible( true );
				builder.setVisible( true );
				inventoryActor.addAmountLabels();
			}
		}
	}


	private void drawStage()
	{
		Skin skin = new Skin(Gdx.files.internal("data/uiskin.json"));

		inventoryButton = new TextButton( "inventory", skin );
		inventoryButton.setDisabled( false );
		inventoryButton.setBounds( 1150, 30, 100, 100);
		inventoryButton.setVisible( true );

		BuildBuildingButton = new TextButton( "Build Farm", skin );
		BuildBuildingButton.setDisabled( false );
		BuildBuildingButton.setBounds( 1000,  300, 200, 30 );
		BuildBuildingButton.setVisible( false );

		TextureAtlas icons = new TextureAtlas(Gdx.files.internal("icons/Inventory.atlas"));
		TextureRegion image;
		image = icons.findRegion("empty");
		ImageButtonStyle style = new ImageButtonStyle(skin.get(ButtonStyle.class));
		style.imageUp = new TextureRegionDrawable(image);
		style.imageDown = new TextureRegionDrawable(image);

		stage.addActor( inventoryButton );
		stage.addActor( inventoryActor );
		stage.addActor( BuildBuildingButton );
		stage.addActor( builder );
		stage.addActor( tileinfo );

		inventoryButton.addListener( InventoryListener );
		BuildBuildingButton.addListener( buildBuildingListener );
	}

	public ClickListener InventoryListener = new ClickListener() {
		@Override
		public void clicked (InputEvent event, float x, float y) {
			inventoryOn = !inventoryOn;
		}
	};

	public ClickListener buildBuildingListener = new ClickListener() {
		@Override
		public void clicked (InputEvent event, float x, float y) {
			if( simulation.getBuildingFarm() ) {
				simulation.BuildingConfirmation(0, selectedTile);
				inventoryActor.clearLabels();
			} else if( simulation.getBuildingWarehouse() ) {
				simulation.BuildingConfirmation(1, selectedTile);
				inventoryActor.clearLabels();
			} else if( simulation.getBuildingWoodCutter() ) {
				simulation.BuildingConfirmation(2, selectedTile);
				inventoryActor.clearLabels();
			}
		}
	};

	public void dispose()
	{
		stage.clear();
	}

}