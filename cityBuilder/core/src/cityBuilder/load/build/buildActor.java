package cityBuilder.load.build;

import java.util.ArrayList;

import cityBuilder.load.inventory.Inventory;

import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Window;

public class buildActor extends Window {

    private ArrayList<buildSlotActor> slotActors = new ArrayList<buildSlotActor>();

    public buildActor(Inventory inventory, buildInventory buildInv, String title, Skin skin)
    {
        super("", skin);

        // basic layout
        row().fill().expandX();

        //run through all slots and create SlotActors for each
        int i = 0;
        for (buildSlot slot : buildInv.getSlots())
        {
            buildSlotActor slotActor = new buildSlotActor(inventory, skin, slot, this);

            this.setScaleX(1.7f);
            this.setScaleY(1.7f);

            add(slotActor);
            slotActors.add(slotActor);

            i++;
            // every 4 cells, we are going to jump to a new row
            if (i % 4 == 0)
            {
                row();
            }
        }

        pack();
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

}
