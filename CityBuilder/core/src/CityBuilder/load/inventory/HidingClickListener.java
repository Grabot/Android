package CityBuilder.load.inventory;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

/**
 * Its only purpose is to hide a given actor on click.
 * 
 * @author Daniel Holderbaum
 */
public class HidingClickListener extends ClickListener {

	private Actor actor;

	public HidingClickListener(Actor actor) {
		this.actor = actor;
	}

	@Override
	public void clicked(InputEvent event, float x, float y) {
		actor.setVisible(false);
	}

}