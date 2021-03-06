package cityBuilder.load.inventory;

public interface SlotListener {

    /**
     * Will be called whenever the slot has changed.
     */
    void hasChanged(Slot slot);

    void clearLabels();

}