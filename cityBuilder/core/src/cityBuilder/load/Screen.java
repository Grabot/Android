package cityBuilder.load;

import java.util.ArrayList;

import cityBuilder.objects.Citizen;

import com.badlogic.gdx.Application;

public interface Screen
{
	/**
	 * Called when the screen should update itself, e.g. continue a simulation etc.
	 *
	 */
	void update(float delta, float touchX, float touchY, float width, float height, boolean touched_down, boolean fast_press, boolean back_pressed, boolean down_pressed, boolean enter_pressed, boolean up_pressed, float distance);

	/**
	 * Called when a screen should render itself
	 * @param app
	 */
	void render(Application app);

	/**
	 * Called by GdxInvaders to check whether the screen is done.
	 *
	 * @return true when the screen is done, false otherwise
	 */
	boolean isDone();

	/**
	 * Cleans up all resources of the screen, e.g. meshes, textures etc.
	 */
	void dispose();

	int level();

	ArrayList<Citizen> citizens();
}