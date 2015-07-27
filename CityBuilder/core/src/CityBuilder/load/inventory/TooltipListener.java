package CityBuilder.load.inventory;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;

public class TooltipListener extends InputListener
{
    private Actor tooltip;

    private Vector2 position = new Vector2();
    private Vector2 tmp = new Vector2();
    private Vector2 offset = new Vector2(10, 10);

    public TooltipListener(Actor tooltip) {
        this.tooltip = tooltip;
    }

    @Override
    public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
 		//see when the button is pressed
        tooltip.setVisible(true);
        tmp.set(x, y);
        event.getListenerActor().localToStageCoordinates(tmp);
        tooltip.setPosition(tmp.x + position.x + offset.x, tmp.y + position.y + offset.y);
        tooltip.toFront();
        return false;
 	}

    @Override
    public void exit(InputEvent event, float x, float y, int pointer, Actor toActor) {
        tooltip.setVisible(false);
    }

    /**
     * The offset of the tooltip from the touch position. It should not be
     * positive as the tooltip will flicker otherwise.
     */
    public void setOffset(float offsetX, float offsetY) {
        offset.set(offsetX, offsetY);
    }

}