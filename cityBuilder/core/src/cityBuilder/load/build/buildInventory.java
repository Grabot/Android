package cityBuilder.load.build;

import cityBuilder.load.Item;

import com.badlogic.gdx.utils.Array;

public class buildInventory {

    private Array<buildSlot> slots;

    public buildInventory() {
        slots = new Array<buildSlot>(16);
    	for( int j = 0; j < 4; j++ )
    	{
    		for (int i = 0; i < 4; i++) 
    		{
            	buildSlot slot = new buildSlot(null, 0);
                slots.add(slot);
        	}
        }

    	slots.get(0).add(Item.values()[6], 1);
    	slots.get(1).add(Item.values()[10], 1);
    }
    
    public Array<buildSlot> getSlots() {
        return slots;
    }
    
}