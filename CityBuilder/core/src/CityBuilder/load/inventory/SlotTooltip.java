package CityBuilder.load.inventory;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class SlotTooltip extends Window implements SlotListener
{
	private Skin skin;
    private Slot slot;
    
    public SlotTooltip(Slot slot, Skin skin) {
        super("", skin);
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
        setTitle("");
        clear();
        Label label;
        if( slot.getItem().toString() == "farm" )
        {
            label = new Label("This is a motherfucking \n" + slot.getItem(), skin);
            add(label);
            row();
            TextButton buildFarm = new TextButton("Build", skin );
            buildFarm.addListener(buildListener);
            add(buildFarm);
        }
        else
        {
            label = new Label("This is \n" + slot.getItem(), skin);
            add(label);
        }
        pack();
       
    }

    public ClickListener buildListener = new ClickListener() 
	{
		@Override
		public void clicked (InputEvent event, float x, float y) 
		{
			//the user selected to place a building.
		}
	};
	
    @Override
    public void setVisible(boolean visible) {
        super.setVisible(visible);
        //the listener sets this to true in case the slot is hovered
        //however, we don't want that in case the slot is empty
        if (slot.isEmpty()) {
            super.setVisible(false);
        }
    }
    
    @Override
    public void clearLabels()
    {
    	super.setVisible(false);
    }
    
}