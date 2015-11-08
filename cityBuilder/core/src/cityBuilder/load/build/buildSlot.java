package cityBuilder.load.build;

import cityBuilder.load.Item;

import com.badlogic.gdx.utils.Array;

public class buildSlot {

    private Item item;
    private int amount;

    private Array<buildSlotListener> slotListeners = new Array<buildSlotListener>();

    public buildSlot(Item item, int amount) 
    {
        this.item = item;
        this.amount = amount;
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

    public void addListener(buildSlotListener slotListener) {
        slotListeners.add(slotListener);
    }

    public void removeListener(buildSlotListener slotListener) {
        slotListeners.removeValue(slotListener, true);
    }

    private void notifyListeners() {
        for (buildSlotListener slotListener : slotListeners) {
            slotListener.hasChanged(this);
        }
    }

    public Item getItem() {
        return item;
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "Slot[" + item + ":" + amount + "]";
    }
    
}