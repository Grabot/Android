package cityBuilder.load.inventory;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.utils.DragAndDrop.Payload;
import com.badlogic.gdx.scenes.scene2d.utils.DragAndDrop.Source;
import com.badlogic.gdx.scenes.scene2d.utils.DragAndDrop.Target;

public class SlotTarget extends Target
{
    private Slot targetSlot;

    public SlotTarget(SlotActor actor) {
        super(actor);
        targetSlot = actor.getSlot();
        getActor().setColor(Color.LIGHT_GRAY);
    }

    @Override
    public boolean drag(Source source, Payload payload, float x, float y, int pointer) {
        Slot payloadSlot = (Slot) payload.getObject();

        // in case we drag something over this target, we highlight it a bit
        getActor().setColor(Color.WHITE);

        // returning true means that this is a valid target
        return true;
    }

    @Override
    public void drop(Source source, Payload payload, float x, float y, int pointer) {
        // we already handle all of this in dragStop in the Source
    }

    @Override
    public void reset(Source source, Payload payload) {
        getActor().setColor(Color.LIGHT_GRAY);
    }

}
