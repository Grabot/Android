package cityBuilder;

import java.util.ArrayList;

import cityBuilder.gameScreen.GameScreen;
import cityBuilder.load.Screen;
import cityBuilder.load.Vector;
import cityBuilder.objects.Citizen;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.FPSLogger;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;


public class Main implements ApplicationListener, InputProcessor
{

	public static final String LOG = Main.class.getSimpleName();

	private FPSLogger fpsLogger;

	private Screen screen;

	private float touchX1 = 999;
	private float touchY1 = 999;
	private float touchX2 = 999;
	private float touchY2 = 999;

	private float distance = 0;

	private float delta = 0;

	private boolean touched_down = false;

	private float width = 0;
	private float height = 0;
	private float just_touched = 0;

	private boolean fast_press = false;
	private boolean back_pressed = false;
	private boolean enter_pressed = false;
	private boolean down_pressed = false;
	private boolean up_pressed = false;

	private OrthographicCamera camera;
	private SpriteBatch batch;

	public static Stage stage;

	private InputMultiplexer inputMultiplexer = new InputMultiplexer();

	public ArrayList<Citizen> citizens = new ArrayList<Citizen>();

	private Citizen[] citizen = new Citizen[100];

	Viewport viewport;

	@Override
	public void create()
	{

		citizens.add(null);
		citizens.add( new Citizen( "Sander", 23, 100, "unemployed" ));
		citizens.add(new Citizen( "Izzy", 19, 100, "unemployed" ));
    	/*
    	 */
		float width = Gdx.graphics.getWidth();
		float height = Gdx.graphics.getHeight();

		fpsLogger = new FPSLogger();

		camera = new OrthographicCamera();
		camera.setToOrtho(false, width, height);
		camera.position.set( 2000, 0, 0.5f );

		batch = new SpriteBatch();

		stage = new Stage(new StretchViewport(1280, 720));

		inputMultiplexer.addProcessor( this );
		inputMultiplexer.addProcessor( stage );

		Gdx.input.setInputProcessor( inputMultiplexer );

		Gdx.input.setCatchBackKey(true);

		screen = new GameScreen( Gdx.app, camera, stage, batch, citizens );

		Gdx.app.log( Main.LOG, "Creating game" );
	}

	@Override
	public void resize(int width, int height)
	{
		this.width = width;
		this.height = height;
	}

	@Override
	public void dispose()
	{

	}

	@Override
	public void render()
	{
		//clear the screen with a dark blue color. The
		//arguments to glClearColor are the red, green
		//blue and alpha component in the range [0,1]
		//of the color to be used to clear the screen.
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);
		Gdx.gl.glViewport( 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

		//tell the camera to update its matrices.
		camera.update();

		//tell the SpriteBatch to render in the
		//coordinate system specified by the camera.
		batch.setProjectionMatrix(camera.combined);
		batch.begin();

		touch_update();

		Application app = Gdx.app;

		fpsLogger.log();

		screen.update( delta, touchX1, touchY1, width, height, touched_down, fast_press, back_pressed, down_pressed, enter_pressed, up_pressed, distance );

		enter_pressed = false;
		back_pressed = false;
		down_pressed = false;
		up_pressed = false;

		screen.render( app );

		if (screen.isDone( ))
		{
			// dispose the current screen
			System.out.println("level: " + screen.level() );
			screen.dispose();
			if( screen.level() == 0 )
			{
				screen = new GameScreen( Gdx.app, camera, stage, batch, screen.citizens() );
			}
		}

		batch.end();

		stage.act(Gdx.graphics.getDeltaTime());
		stage.draw();
		//stage.setCamera( camera );
	}

	private void touch_update()
	{
		Vector3 touchPos1 = new Vector3();
		Vector3 touchPos2 = new Vector3();

		if (Gdx.input.isTouched(0))
		{
			touchPos1.set(Gdx.input.getX(0), Gdx.input.getY(0), 0);

			touchX1 = touchPos1.x;
			touchY1 = touchPos1.y;

			if( Gdx.input.isTouched(1))
			{
				//2 fingers, so we assume an attempt at pinch zoom
				touchPos2.set( Gdx.input.getX(1), Gdx.input.getY(1), 0 );

				touchX2 = touchPos2.x;
				touchY2 = touchPos2.y;

				distance = new Vector( touchX1, touchY1 ).distance( new Vector( touchX2, touchY2 ));
			}
			else
			{
				just_touched += 1;
				distance = 0;
			}

			touched_down = true;
		}
		else
		{
			touched_down = false;
			if( (just_touched < 10) && (just_touched != 0) )
			{
				fast_press = true;
				just_touched = 0;
			}
			else
			{
				fast_press = false;
			}
			just_touched = 0;
			//touchX1 = 1200;
			//touchY1 = 1200;
		}

		delta = Gdx.graphics.getDeltaTime();

	}

	@Override
	public void pause()
	{

	}

	@Override
	public void resume()
	{

	}

	@Override
	public boolean keyDown(int keycode)
	{
		if( keycode == Keys.ESCAPE || keycode == Keys.BACK ||keycode == Keys.Q )
		{
			Gdx.app.exit();
			back_pressed = true;
		}

		if( keycode == Keys.ENTER )
		{
			System.out.println("camera x:" + camera.position.x + " y:" + camera.position.y);
			enter_pressed = true;
		}

		if( keycode == Keys.DOWN )
		{
			down_pressed = true;
		}

		if( keycode == Keys.UP )
		{
			up_pressed = true;
		}

		if( keycode == Keys.SPACE )
		{
			up_pressed = false;
			down_pressed = false;
		}
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}
}
