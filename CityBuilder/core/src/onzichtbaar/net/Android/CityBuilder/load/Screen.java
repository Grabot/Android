package onzichtbaar.net.Android.CityBuilder.load;

import java.util.ArrayList;

import onzichtbaar.net.Android.CityBuilder.objects.Citizen;

import com.badlogic.gdx.Application;

public interface Screen
{
	  /**
	   * Called when the screen should update itself, e.g. continue a simulation etc.
	   * 
	   */
	  public void update ( float delta, float touchX, float touchY, float width, float height, boolean touched_down, boolean fast_press, boolean back_pressed, boolean down_pressed, boolean enter_pressed, boolean up_pressed, float distance );

	  /**
	   * Called when a screen should render itself
	   * @param app
	   */
	  public void render (Application app);

	  /**
	   * Called by GdxInvaders to check whether the screen is done.
	   * 
	   * @return true when the screen is done, false otherwise
	   */
	  public boolean isDone ();

	  /**
	   * Cleans up all resources of the screen, e.g. meshes, textures etc.
	   */
	  public void dispose ();
	  
	  public int level ();
	  
	  public ArrayList<Citizen> citizens ();
}