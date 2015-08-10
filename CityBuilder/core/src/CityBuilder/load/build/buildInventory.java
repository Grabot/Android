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
            	//10 is the starting pos, 70 is the slot width, and 7 is the padding
            	buildSlot slot = new buildSlot(null, 0);
                slots.add(slot);
        	}
        }

    	slots.get(0).add(Item.values()[6], 1);
    	/*
    	//here you can add random item for testing purposes
        //create some random items
 		for (Slot slot : slots) {
 			slot.add(Item.values()[MathUtils.random(0,5)], 1);
 		}

        //create a few random empty slots
        for (int i = 0; i < 10; i++) {
            Slot randomSlot = slots.get(MathUtils.random(0, slots.size - 1));
            randomSlot.take(randomSlot.getAmount());
        }
        */
    }
    
    public Array<buildSlot> getSlots() {
        return slots;
    }
    
}