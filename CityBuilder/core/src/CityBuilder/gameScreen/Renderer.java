package CityBuilder.gameScreen;

import java.util.ArrayList;

import CityBuilder.enums.TileType;
import CityBuilder.load.Data;
import CityBuilder.load.DisplayInfoBox;
import CityBuilder.load.DrawTiles;
import CityBuilder.load.TouchInput;
import CityBuilder.objects.Citizen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class Renderer extends Data
{
	private  ArrayList<Citizen> citizens = new ArrayList<Citizen>();
	
	public static final String LOG = Renderer.class.getSimpleName();

	private DisplayInfoBox infoBoxDisplay;
	private TouchInput inputHandler;
	private DrawTiles drawTiles;
	
	private Stage stage;
	private OrthographicCamera camera;
	private SpriteBatch batch;
	
	private Skin skin;
	
	private int selectedTile = 1;
	private boolean hasWall = false;
	
	private float scaling_x = 0;
	private float scaling_y = 0;
	
	private Texture InfoBox;
	private Texture progressBar;
	private Texture progressBarFill;
	
	private TextButton woodButton;
	
	private TextField tileInfo;
	private TextField resourceInfo;
	private TextField levelText;
	private TextField resourceCitizens;
	private TextField resourceWood;
	private TextField resourceStone;
	private TextField resourceFood;
	private TextField resourceGold;
	
	private GameScreen game;
	
	private Image UserInterface;
	private Image MiningBar;
	private Image MiningBarFill;
	
	private Simulation simulation;
	
	private TextureRegion region;
	private TextureRegion progressRegion;
	private TextureRegion progressFillRegion;
	
	public Renderer( GameScreen game, OrthographicCamera camera, Stage stage, SpriteBatch batch, ArrayList<Citizen> citizens )
	{
		this.citizens = citizens;
		this.game = game;

		float width = Gdx.graphics.getWidth();
		float height = Gdx.graphics.getHeight();

		scaling_x = width/ScreenHeight;
		scaling_y = height/ScreenWidth;

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
		inputHandler.MapScroll();
		inputHandler.MapZoom();
		
		drawTiles.fillTiles( simulation, batch );
		
		int tileCounter = 0;
		boolean[] tileTouch = simulation.getTileTouch();
		for( int i = 0; i < simulation.tiles.size(); i++ )
		{
			if( tileTouch[i] )
			{
				if( simulation.tiles.get(i).isWall() )
				{
					woodButton.setText( "Remove wall" );
				}
				else
				{
					woodButton.setText( "Build wall" );
				}
				
				if( simulation.tiles.get(i).getColour() == available )
				{
					woodButton.setVisible( true );
				}
				else
				{
					woodButton.setVisible( false );
				}
				
				
				infoBoxDisplay.displayInfoBox(tileInfo, resourceInfo, simulation, i);
				drawTiles.drawSelected( simulation, batch, i );
				
				selectedTile = i;
				hasWall = simulation.tiles.get(i).isWall();
			}
			else
			{
				tileCounter ++;
			}
		}
		

		if( tileCounter == simulation.tiles.size())
		{
			//nothing selected
			infoBoxDisplay.displayInfoBox(tileInfo, resourceInfo, simulation, 0);
			woodButton.setVisible( false );
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
	}
	

	private void drawStage()
	{
		UserInterface = new Image(region);
		UserInterface.setBounds(880, 80, 400, 600);
		UserInterface.setVisible( true );
		
		MiningBar = new Image(progressRegion);
		MiningBar.setBounds(300, 200, 600, 30 );
		MiningBar.setVisible( false );
		
		MiningBarFill = new Image( progressFillRegion );
		MiningBarFill.setBounds(305, 205, 5, 20 );
		MiningBarFill.setVisible( false );
		
		skin = new Skin(Gdx.files.internal("data/uiskin.json"));

		tileInfo = new TextField( "", skin );
		tileInfo.setDisabled(true);
		tileInfo.setBounds( 1000, 530, 160, 20 );
		tileInfo.setVisible( false );
		
		resourceInfo = new TextField( "", skin );
		resourceInfo.setDisabled( true );
		resourceInfo.setBounds( 1000, 430, 160, 20 );
		resourceInfo.setVisible( false );
		
		levelText = new TextField( "Level 1", skin );
		levelText.setDisabled(true);
		levelText.setBounds(30, 680, 100, 20 );
		levelText.setVisible( true );
		
		resourceWood = new TextField( "Wood: ", skin );
		resourceStone = new TextField( "Stone: ", skin );
		resourceFood = new TextField( "Food: ", skin );
		resourceGold = new TextField( "Gold: ", skin );
		resourceCitizens = new TextField( "Citizens: ", skin );
		resourceWood.setDisabled( true );
		resourceStone.setDisabled( true );
		resourceFood.setDisabled( true );
		resourceGold.setDisabled( true );
		resourceCitizens.setDisabled( true );
		resourceWood.setBounds( 30, 650, 100, 20 );
		resourceStone.setBounds( 30, 620, 100, 20 );
		resourceFood.setBounds( 30, 590, 100, 20 );
		resourceGold.setBounds( 30, 560, 100, 20 );
		resourceCitizens.setBounds( 30,  530, 100, 20);
		resourceWood.setVisible( true );
		resourceStone.setVisible( true );
		resourceFood.setVisible( true );
		resourceGold.setVisible( true );
		resourceCitizens.setVisible( true );
		
		woodButton = new TextButton("Build Wall", skin );
		woodButton.setBounds(980, 220, 200, 50 );
		woodButton.setVisible( false );
		woodButton.addListener(woodButtonListener);
		
		stage.addActor( UserInterface);
		stage.addActor( MiningBar );
		stage.addActor( MiningBarFill );
		stage.addActor( tileInfo );
		stage.addActor( resourceInfo );
		stage.addActor( levelText );
		stage.addActor( resourceWood );
		stage.addActor( resourceStone );
		stage.addActor( resourceFood );
		stage.addActor( resourceGold );
		stage.addActor( resourceCitizens );
		stage.addActor( woodButton );
		
		resourceWood.setText( "Wood: " + game.Wood );
		resourceStone.setText( "Stone: " + game.Stone );
		resourceFood.setText( "Food: " + game.Food );
		resourceGold.setText( "Gold: " + game.Gold );
		resourceCitizens.setText( "Citizens: " + (citizens.size() - 1) );
	}
	
	public ClickListener woodButtonListener = new ClickListener() 
	{
		@Override
		public void clicked (InputEvent event, float x, float y) 
		{
			if( hasWall )
			{
				simulation.BuildWall( false, selectedTile );
			}
			else
			{
				simulation.BuildWall( true, selectedTile );
			}
			resourceWood.setText( "Wood: " + game.Wood );
			resourceStone.setText( "Stone: " + game.Stone );
		}
		
	};
	
	public ClickListener chopForestListener = new ClickListener() 
	{
		@Override
		public void clicked (InputEvent event, float x, float y) 
		{
			game.Wood += 50;
			resourceWood.setText( "Wood: " + game.Wood );
			simulation.tiles.get(selectedTile).setType( TileType.grass );
		}
		
	};
	
	public ClickListener chopStoneListener = new ClickListener() 
	{
		@Override
		public void clicked (InputEvent event, float x, float y) 
		{
			game.Stone += 200;
			resourceStone.setText( "Stone: " + game.Stone );
			simulation.tiles.get(selectedTile).setType( TileType.grass );
		}
		
	};
	
	public void dispose()
	{
		stage.clear();
	}
	
}