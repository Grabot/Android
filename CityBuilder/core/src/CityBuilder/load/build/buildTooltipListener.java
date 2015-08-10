package CityBuilder.load.build;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;

public class buildTooltipListener extends InputListener
{
    private Actor tooltip;
    private buildActor actor;

    private Vector2 position = new Vector2();
    private Vector2 tmp = new Vector2();
    private Vector2 offset = new Vector2(0, 50);

    public buildTooltipListener(Actor tooltip, buildActor actor) {
        this.tooltip = tooltip;
        this.actor = actor;
    }

    @Override
    public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
 		//see when the button is pressed
    	actor.clearLabels();
        tooltip.setVisible(true);
        tmp.set(x, y);
        event.getListenerActor().localToStageCoordinates(tmp);
        tooltip.setPosition(tmp.x, tmp.y);
        tooltip.toFront();
        return false;
 	}
    
    /**
     * The offset of the tooltip from the touch position. It should not be
     * positive as the tooltip will flicker otherwise.
     */
    public void setOffset(float offsetX, float offsetY) {
        offset.set(offsetX, offsetY);
    }

}