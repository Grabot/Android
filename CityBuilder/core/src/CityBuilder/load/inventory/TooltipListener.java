package CityBuilder.load.inventory;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;

public class TooltipListener extends InputListener
{
    private Actor tooltip;
    private InventoryActor actor;

    private Vector2 position = new Vector2();
    private Vector2 tmp = new Vector2();
    private Vector2 offset = new Vector2(0, 50);

    public TooltipListener(Actor tooltip, InventoryActor actor) {
        this.tooltip = tooltip;
        this.actor = actor;
    }

    @Override
    public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
 		//see when the button is pressed
    	actor.addAmountLabels();
        tooltip.setVisible(true);
        tmp.set(x, y);
        event.getListenerActor().localToStageCoordinates(tmp);
        if(tmp.x + offset.x + tooltip.getWidth() >= 640)
        {
        	tmp.x = (640-tooltip.getWidth() );
        }
        if( tmp.y > 500 )
        {
        	offset.y = -100;
        }
        tooltip.setPosition(tmp.x, tmp.y + offset.y);
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