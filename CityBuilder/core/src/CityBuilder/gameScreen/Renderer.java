package CityBuilder.gameScreen;

import java.util.ArrayList;

import CityBuilder.load.Data;
import CityBuilder.load.DisplayInfoBox;
import CityBuilder.load.DrawTiles;
import CityBuilder.load.TouchInput;
import CityBuilder.load.build.buildActor;
import CityBuilder.load.build.buildInventory;
import CityBuilder.load.inventory.Inventory;
import CityBuilder.load.inventory.InventoryActor;
import CityBuilder.objects.Citizen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button.ButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton.ImageButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class Renderer extends Data
{
	private  ArrayList<Citizen> citizens = new ArrayList<Citizen>();
	
	public static final String LOG = Renderer.class.getSimpleName();

	private boolean initialClose = false;
	private boolean initialOpen = true;
	
	private DisplayInfoBox infoBoxDisplay;
	private TouchInput inputHandler;
	private DrawTiles drawTiles;
	
	private Stage stage;
	private OrthographicCamera camera;
	private SpriteBatch batch;
	
	private int selectedTile = -1;
	
	private boolean inventoryOn = false;
	
	private TextButton inventoryButton;
	
	private Texture InfoBox;
	private Texture progressBar;
	private Texture progressBarFill;
	
	private TextField tileInfo;
	private TextField resourceInfo;
	
	private GameScreen game;
	
	private Image UserInterface;
	private Image MiningBar;
	private Image MiningBarFill;
	
	private Simulation simulation;
	
	private TextureRegion region;
	private TextureRegion progressRegion;
	private TextureRegion progressFillRegion;
	
	private InventoryActor inventoryActor;
	private TextureAtlas atlas;
	private Inventory inventory;
	private buildInventory buildInv;
	private buildActor builder;
	
	public Renderer( GameScreen game, OrthographicCamera camera, Stage stage, SpriteBatch batch, Inventory inventory, InventoryActor inventoryActor, buildInventory buildInv, buildActor builder,  ArrayList<Citizen> citizens )
	{
		this.citizens = citizens;
		this.game = game;
		this.inventory = inventory;
		this.inventoryActor = inventoryActor;
		this.buildInv = buildInv;
		this.builder = builder;
		
		float width = Gdx.graphics.getWidth();
		float height = Gdx.graphics.getHeight();

		atlas = new TextureAtlas(Gdx.files.internal("TextureAtlas/InitialPack.pack"));

		InfoBox = new Texture( Gdx.files.internal( "images/UITest.png" ));
		progressBar = new Texture( Gdx.files.internal( "data/progressBar.png" ));
		progressBarFill = new Texture( Gdx.files.internal( "data/progressBarFill.png" ));
		
		region = new TextureRegion(InfoBox, 0, 0, InfoBox.getWidth(), InfoBox.getHeight());
		progressRegion = new TextureRegion( progressBar, 0, 0, progressBar.getWidth(), progressBar.getHeight() );
		progressFillRegion = new TextureRegion( progressBarFill, 0, 0, progressBarFill.getWidth(), progressBarFill.getHeight() );

		infoBoxDisplay = new DisplayInfoBox();
		inputHandler = new TouchInput( camera, width, height );
		drawTiles = new DrawTiles();
		
		this.stage = stage;
		this.camera = camera;
		this.batch = batch;
		
		drawStage();
	}
	
	public void DrawImages( Simulation simulation )
	{
		this.simulation = simulation;
		inputHandler.variables( camera, simulation );
		
		drawTiles.fillTiles( simulation, batch, atlas );
		
		if( !inventoryOn )
		{			
			UserInterface.setVisible(true);
			inputHandler.MapScroll();
			inputHandler.MapZoom();
			
			this.selectedTile = simulation.TileTouch();
			
			if( selectedTile >= 0 && selectedTile < numberOfTiles )
			{
				infoBoxDisplay.displayInfoBox(tileInfo, resourceInfo, simulation, selectedTile);
				drawTiles.drawSelected( simulation, batch, atlas, selectedTile );
			}
			
			if( simulation.getMining() )
			{
				MiningBar.setVisible( true );
				MiningBarFill.setVisible( true );
				MiningBarFill.setBounds(305, 205, (0 + simulation.getMiningProgress()), 20 );
			}
			else
			{
				MiningBar.setVisible( false );
				MiningBarFill.setVisible( false );
			}
			
			if( initialClose )
			{
				initialClose = false;
				initialOpen = true;
				inventoryActor.clearLabels();
				inventoryActor.setVisible( false );
			}
		}
		else
		{
			if( initialOpen )
			{
				initialOpen = false;
				initialClose = true;
				UserInterface.setVisible( false );
				tileInfo.setVisible( false );
				resourceInfo.setVisible( false );
				inventoryActor.setVisible( true );
				inventoryActor.addAmountLabels();
			}
		}
	}
	

	private void drawStage()
	{
		Skin skin = new Skin(Gdx.files.internal("data/uiskin.json"));
		
		UserInterface = new Image(region);
		UserInterface.setBounds(880, 80, 400, 600);
		UserInterface.setVisible( true );
		
		MiningBar = new Image(progressRegion);
		MiningBar.setBounds(300, 200, 600, 30 );
		MiningBar.setVisible( false );
		
		MiningBarFill = new Image( progressFillRegion );
		MiningBarFill.setBounds(305, 205, 5, 20 );
		MiningBarFill.setVisible( false );
		
		tileInfo = new TextField( "", skin );
		tileInfo.setDisabled(true);
		tileInfo.setBounds( 1000, 530, 160, 20 );
		tileInfo.setVisible( false );
		
		inventoryButton = new TextButton( "inventory", skin );
		inventoryButton.setDisabled( false );
		inventoryButton.setBounds( 1150, 30, 100, 100);
		inventoryButton.setVisible( true );
		
		TextureAtlas icons = new TextureAtlas(Gdx.files.internal("icons/Inventory.atlas"));
		TextureRegion image;
		image = icons.findRegion("empty");
		ImageButtonStyle style = new ImageButtonStyle(skin.get(ButtonStyle.class));
        style.imageUp = new TextureRegionDrawable(image);
        style.imageDown = new TextureRegionDrawable(image);
        
		resourceInfo = new TextField( "", skin );
		resourceInfo.setDisabled( true );
		resourceInfo.setBounds( 1000, 430, 160, 20 );
		resourceInfo.setVisible( false );
		
		stage.addActor( UserInterface);
		stage.addActor( MiningBar );
		stage.addActor( MiningBarFill );
		stage.addActor( tileInfo );
		stage.addActor( resourceInfo );
		stage.addActor( inventoryButton );
		stage.addActor( inventoryActor );
		stage.addActor( builder );

		inventoryButton.addListener( InventoryListener );
	}
	
	public ClickListener InventoryListener = new ClickListener() 
	{
		@Override
		public void clicked (InputEvent event, float x, float y) 
		{
			inventoryOn = !inventoryOn;
		}
	};
	
	public void dispose()
	{
		stage.clear();
	}
	
}