package CityBuilder.load.inventory;

import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Window;

public class SlotTooltip extends Window implements SlotListener
{
	 private Skin skin;

	    private Slot slot;

	    public SlotTooltip(Slot slot, Skin skin) {
	        super("Tooltip...", skin);
	        this.slot = slot;
	        this.skin = skin;
	        hasChanged(slot);
	        slot.addListener(this);
	        setVisible(false);
	    }

	    @Override
	    public void hasChanged(Slot slot) {
	        if (slot.isEmpty()) {
	            setVisible(false);
	            return;
	        }

	        // title displays the amount
	        setTitle(slot.getAmount() + "x " + slot.getItem());
	        clear();
	        Label label = new Label("Super awesome description of " + slot.getItem(), skin);
	        add(label);
	        pack();
	    }

	    @Override
	    public void setVisible(boolean visible) {
	        super.setVisible(visible);
	        //the listener sets this to true in case the slot is hovered
	        //however, we don't want that in case the slot is empty
	        if (slot.isEmpty()) {
	            super.setVisible(false);
	        }
	    }
	    

	}