package CityBuilder.load.inventory;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

public class Inventory {

    private Array<Slot> slots;

    public Inventory() {
        slots = new Array<Slot>(72);
    	for( int j = 0; j < 9; j++ )
    	{
    		for (int i = 0; i < 8; i++) 
    		{
            	//10 is the starting pos, 70 is the slot width, and 7 is the padding
            	Slot slot = new Slot(null, 0, new Vector2((58+(i*(70+7))), (592 - (j*72))));
                slots.add(slot);
        	}
        }

        // create some random items
 		for (Slot slot : slots) {
 			slot.add(Item.values()[MathUtils.random(0,1)], 1);
 		}

        // create a few random empty slots
        for (int i = 0; i < 20; i++) {
            Slot randomSlot = slots.get(MathUtils.random(0, slots.size - 1));
            randomSlot.take(randomSlot.getAmount());
        }
        
    }
    
    public void addItem( int slotNumber, int item )
    {
    	if( item == 0 )
    	{
    		slots.get(slotNumber).add(Item.values()[0], 1 );
    	}
    }

    public int checkInventory(Item item) {
        int amount = 0;

        for (Slot slot : slots) {
            if (slot.getItem() == item) {
                amount += slot.getAmount();
            }
        }
        return amount;
    }

    public boolean store(Item item, int amount) {
        // first check for a slot with the same item type
        Slot itemSlot = firstSlotWithItem(item);
        if (itemSlot != null) {
            itemSlot.add(item, amount);
            return true;
        } else {
            // now check for an available empty slot
            Slot emptySlot = firstSlotWithItem(null);
            if (emptySlot != null) {
                emptySlot.add(item, amount);
                return true;
            }
        }

        // no slot to add
        return false;
    }

    public Array<Slot> getSlots() {
        return slots;
    }

    private Slot firstSlotWithItem(Item item) {
        for (Slot slot : slots) {
            if (slot.getItem() == item) {
                return slot;
            }
        }

        return null;
    }
    
}