package CityBuilder.load.inventory;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.utils.DragAndDrop.Payload;
import com.badlogic.gdx.scenes.scene2d.utils.DragAndDrop.Source;
import com.badlogic.gdx.scenes.scene2d.utils.DragAndDrop.Target;

/**
 * @author Daniel Holderbaum
 */
public class SlotTarget extends Target {

	public SlotTarget(SlotActor actor) {
		super(actor);
		getActor().setColor(Color.LIGHT_GRAY);
	}

	@Override
	public boolean drag(Source source, Payload payload, float x, float y, int pointer) {
		// if (targetSlot.getItem() == payloadSlot.getItem() ||
		// targetSlot.getItem() == null) {
		getActor().setColor(Color.WHITE);
		return true;
		// } else {
		// getActor().setColor(Color.DARK_GRAY);
		// return false;
		// }
	}

	@Override
	public void drop(Source source, Payload payload, float x, float y, int pointer) {
	}

	@Override
	public void reset(Source source, Payload payload) {
		getActor().setColor(Color.LIGHT_GRAY);
	}

}