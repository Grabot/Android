package CityBuilder.load.inventory;

import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.badlogic.gdx.scenes.scene2d.utils.DragAndDrop;

public class InventoryActor extends Window {

    public InventoryActor(Inventory inventory, DragAndDrop dragAndDrop, Skin skin) {
        super("Inventory", skin);

        // add an "X" button to the top right of the window, and make it hide the inventory
        //TextButton closeButton = new TextButton("X", skin);
        //getButtonTable().add(closeButton).height(getPadTop());

        // basic layout
        setPosition(700, 300);
        row().fill().expandX();

        // run through all slots and create SlotActors for each
        int i = 0;
        for (Slot slot : inventory.getSlots()) 
        {
            SlotActor slotActor = new SlotActor(skin, slot);

            // this can be ignored for now and will be explained in part III
            dragAndDrop.addSource(new SlotSource(slotActor));
            dragAndDrop.addTarget(new SlotTarget(slotActor));
            
            add(slotActor);

            i++;
            // every 5 cells, we are going to jump to a new row
            if (i % 8 == 0) 
            {
                row();
            }
        }

        pack();

        // it is hidden by default
        setVisible(false);
    }
}