package CityBuilder.load.build;

import CityBuilder.load.Item;

import com.badlogic.gdx.math.MathUtils;
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

    	slots.get(0).add(Item.values()[9], 1);
    	slots.get(1).add(Item.values()[6], 1);
    }
    
    public Array<buildSlot> getSlots() {
        return slots;
    }
    
}