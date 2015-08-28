package cityBuilder.load.inventory;

import cityBuilder.load.Item;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

public class Slot {

    private Item item;
    private int amount;
    
    Vector2 pos;

    private Array<SlotListener> slotListeners = new Array<SlotListener>();

    public Slot(Item item, int amount, Vector2 pos) 
    {
        this.item = item;
        this.amount = amount;
        this.pos = pos;
    }

    public boolean isEmpty() {
        return item == null || amount <= 0;
    }

    public boolean add(Item item, int amount) {
        if (this.item == item || this.item == null) {
            this.item = item;
            this.amount += amount;
            notifyListeners();
            return true;
        }

        return false;
    }

    public boolean take(int amount) {
        if (this.amount >= amount) {
            this.amount -= amount;
            if (this.amount == 0) {
                item = null;
            }
            notifyListeners();
            return true;
        }

        return false;
    }

    public void addListener(SlotListener slotListener) {
        slotListeners.add(slotListener);
    }

    public void removeListener(SlotListener slotListener) {
        slotListeners.removeValue(slotListener, true);
    }

    private void notifyListeners() {
        for (SlotListener slotListener : slotListeners) {
            slotListener.hasChanged(this);
        }
    }

    public Item getItem() {
        return item;
    }

    public int getAmount() {
        return amount;
    }
    
    public Vector2 getPosition()
    {
    	return pos;
    }

    @Override
    public String toString() {
        return "Slot[" + item + ":" + amount + "]";
    }
    
    public void clearLabels()
    {
    	for (SlotListener slotListener : slotListeners) {
            slotListener.clearLabels();
        }
    }
}