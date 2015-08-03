package CityBuilder.gameScreen;

import java.util.ArrayList;

import CityBuilder.load.Screen;
import CityBuilder.load.TilesLoad;
import CityBuilder.load.build.buildActor;
import CityBuilder.load.build.buildInventory;
import CityBuilder.load.inventory.Inventory;
import CityBuilder.load.inventory.InventoryActor;
import CityBuilder.objects.Citizen;
import CityBuilder.objects.Tile;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.DragAndDrop;

public class GameScreen implements Screen
{

	public ArrayList<Tile> tiles = new ArrayList<Tile>();
	
	public static final String LOG = Simulation.class.getSimpleName();
	
	private Simulation simulation;
	private Renderer renderer;
	
	private boolean game_finished = false;
	
	private ArrayList<Citizen> citizens = new ArrayList<Citizen>();
	
	int level;
	
	public int Wood = 0;
	public int Stone = 0;
	public int Food = 0;
	public int Gold = 0;
	
	private TilesLoad tileLoad;
	private Inventory inventory;
	private InventoryActor inventoryActor;
	private buildActor builder;
	
	public GameScreen( Application app, OrthographicCamera camera, Stage stage, SpriteBatch batch, ArrayList<Citizen> citizens )
	{
		this.citizens = citizens;
		Gdx.app.log( LOG, "Creating opening screen" );

		Skin inventorySkin = new Skin(Gdx.files.internal("skins/inventoryTest/uiskin.json"));
		
		inventory = new Inventory();
		DragAndDrop dragAndDrop = new DragAndDrop();
		inventoryActor = new InventoryActor(inventory, dragAndDrop, inventorySkin);
		inventoryActor.setPosition(10, 10);
		inventoryActor.setMovable( false );
		
		buildInventory buildInv = new buildInventory();
		builder = new buildActor(buildInv, "build", inventorySkin);
		builder.setPosition(700, 10);
		builder.setMovable( false );
		builder.setVisible( false );
		
		//map layout
		tileLoad = new TilesLoad();
		tiles = tileLoad.getTiles();
		
		simulation = new Simulation( this, inventory, inventoryActor, buildInv, builder, citizens, tiles );
		renderer = new Renderer( this, camera, stage, batch, inventory, inventoryActor, buildInv, builder, citizens );
	}

	@Override
	public void update(float delta, float touchX, float touchY, float width, float height, boolean touched_down, boolean fast_press, boolean back_pressed, boolean down_pressed, boolean enter_pressed, boolean up_pressed, float distance ) 
	{
		simulation.update( delta );
		simulation.variables( touchX, touchY, width, height, touched_down, fast_press, back_pressed, down_pressed, up_pressed, distance );
	}

	@Override
	public void dispose()
	{
		renderer.dispose();
	}

	public void Game_Finished( int level, ArrayList<Citizen> citizens )
	{
		game_finished = true;
		this.level = level;
		this.citizens = citizens;
	}

	@Override
	public boolean isDone()
	{
		return game_finished;
	}


	@Override
	public int level()
	{
		return level;
	}

	@Override
	public void render( Application app )
	{
		 renderer.DrawImages( simulation );
	}

	@Override
	public ArrayList<Citizen> citizens()
	{
		return citizens;
	}

}