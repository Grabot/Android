package cityBuilder.load;

import cityBuilder.gameScreen.Simulation;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.MathUtils;

public class TouchInput
{
	private float firstX = 0;
	private float firstY = 0;

	private float touchX = 1700;
	private float touchY = 1700;

	private float offsetX = 0;
	private float offsetY = 0;

	private boolean firstPress = true;
	private boolean firstPinch = true;

	private boolean touchedDown = false;

	private float firstDistance = 0;
	private float zoomSpeed = 0;

	private float currentX = 0;
	private float currentY = 0;
	private float currentZoom = 1f;

	private boolean touchSideRight = false;
	private boolean touchSideLeft = false;
	private boolean touchUp = false;
	private boolean touchBottom = false;

	private boolean down_pressed = false;
	private boolean up_pressed = false;
	private boolean scrolling = false;

	private float distance = 0;

	private OrthographicCamera camera;
	private Simulation simulation;

	private float width = 0;
	private float height = 0;

	private int mapSizeWidth = (25*64);
	private int mapSizeHeight = (25*64);

	private int overShootX = 2000;
	private int overShootY = 500;

	private boolean roadTouched = false;

	public TouchInput( OrthographicCamera camera, float width, float height )
	{
		this.width = width;
		this.height = height;

		currentX = camera.position.x;
		currentY = camera.position.y;
		camera.zoom = 2.0f;
		currentZoom = camera.zoom;
	}

	public void variables( OrthographicCamera camera, Simulation simulation )
	{
		this.camera = camera;
		this.simulation = simulation;

		this.touchedDown = simulation.getTouchedDown();
		this.touchX = simulation.getTouchX();
		this.touchY = simulation.getTouchY();
		this.down_pressed = simulation.getDown();
		this.up_pressed = simulation.getUp();
		this.distance = simulation.getDistance();
	}

	public void MapScroll(boolean buildingRoad)
	{

		if( touchedDown && firstPress )
		{
			firstPress = false;
			firstX = touchX;
			firstY = touchY;
		}
		else if( touchedDown && !firstPress )
		{
			if (!buildingRoad) {
				offsetX = ((firstX - touchX) * currentZoom);
				offsetX = MathUtils.clamp(offsetX, (((((width / 2) * currentZoom) - 32) - currentX) - (overShootX * currentZoom)), (((((640 * currentZoom) - 32) - currentX) + mapSizeWidth - (width * currentZoom))) + (overShootX * currentZoom));

				offsetY = ((firstY - touchY) * currentZoom);
				offsetY = MathUtils.clamp(offsetY, -((((mapSizeHeight - ((height / 2) * currentZoom)) - currentY) - 32) + (overShootY * currentZoom)), (-(((((height / 2) * currentZoom) - 32) - currentY)) + (overShootY * currentZoom)));

				if (Math.sqrt((offsetX * offsetX + offsetY * offsetY)) >= 20) {
					scrolling = true;
				}
			}
		}

		if( !touchedDown )
		{
			firstPress = true;
			currentX = (currentX + offsetX);
			currentY = (currentY - offsetY);
			offsetX = 0;
			offsetY = 0;
			scrolling = false;

			if( touchSideRight )
			{
				currentX = -280;
				touchSideRight = false;
			}
			else if( touchSideLeft )
			{
				currentX = 280;
				touchSideLeft = false;
			}

			if( touchUp )
			{
				currentY = -150;
				touchUp = false;
			}
			else if( touchBottom )
			{
				currentY = 150;
				touchBottom = false;
			}
		}
		simulation.isScrolling( scrolling );
	}

	public void MapZoom()
	{
		if( distance != 0 )
		{
			if( touchedDown && firstPinch )
			{
				firstPinch = false;

				firstDistance = distance;
			}
		}
		else
		{
			firstPinch = true;
		}


		if( touchedDown && !firstPinch )
		{

			zoomSpeed = firstDistance - distance;

			Gdx.app.log( "Zoomtest", "zoomSpeed: " + zoomSpeed );

			if( camera.zoom <= 0.1 && zoomSpeed <= 0 )
			{
				currentZoom = 0.1f;
				zoomSpeed = 0;
			}
			else if( camera.zoom >= 4 && zoomSpeed > 0)
			{
				currentZoom = 4f;
				zoomSpeed = 0;
			}
			else
			{
				camera.zoom = (currentZoom + (zoomSpeed/1000));
			}
		}

		if( !touchedDown )
		{
			currentZoom = (currentZoom + (zoomSpeed/1000));
			zoomSpeed = 0;
			firstPinch = true;
		}

		if( down_pressed )
		{
			currentZoom += 0.1;
		}
		else if( up_pressed )
		{
			currentZoom -= 0.1;
		}


		currentZoom = MathUtils.clamp( currentZoom, 0.1f, 4f );
		camera.zoom = currentZoom;
		//camera.zoom = MathUtils.clamp(camera.zoom, 0.1f, 1.2f);

		camera.position.x = (currentX + offsetX);
		camera.position.y = (currentY - offsetY);

		simulation.updateScroll( camera.position.x, camera.position.y, camera.zoom );
	}
}
