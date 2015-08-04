package CityBuilder.load.inventory;

import java.util.ArrayList;

import CityBuilder.load.build.buildInventory;

import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.badlogic.gdx.scenes.scene2d.utils.DragAndDrop;

public class InventoryActor extends Window {

	//make a list with the actors, 
	//the only way I could remove the labels after closing the inventory
	private ArrayList<SlotActor> slotActors = new ArrayList<SlotActor>();
	
    public InventoryActor(Inventory inventory, buildInventory buildInv, DragAndDrop dragAndDrop, Skin skin) {
        super("", skin);

        //add an "X" button to the top right of the window, and make it hide the inventory
        //TextButton closeButton = new TextButton("X", skin);
        //getButtonTable().add(closeButton).height(getPadTop());

        // basic layout
        row().fill().expandX();

        //run through all slots and create SlotActors for each
        int i = 0;
        for (Slot slot : inventory.getSlots()) 
        {
            SlotActor slotActor = new SlotActor(skin, slot, this);

            // this can be ignored for now and will be explained in part III
            dragAndDrop.addSource(new SlotSource(slotActor));
            dragAndDrop.addTarget(new SlotTarget(slotActor));
            
            this.setScaleX(1.5f);
            this.setScaleY(1.5f);
            
            add(slotActor);
            //create a dummy slotActor list purely for removing labels afterwards
            slotActors.add(slotActor);
            
            i++;
            // every 8 cells, we are going to jump to a new row
            if (i % 6 == 0) 
            {
                row();
            }
        }
        
        pack();

        // it is hidden by default
        setVisible(false);
    }
    
    /**
     * clear out all the labels with the actor list
     */
    public void clearLabels()
    {
    	for( int i = 0; i < slotActors.size(); i++ )
    	{
        	slotActors.get(i).clearLabels();
    	}
    }
    
    
    public void addAmountLabels()
    {
    	for( int i = 0; i < slotActors.size(); i++ )
    	{
        	slotActors.get(i).addAmounts();
    	}
    }
    
}