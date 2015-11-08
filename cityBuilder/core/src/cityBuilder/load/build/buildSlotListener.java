package cityBuilder.load.build;

public interface buildSlotListener {

    /**
    * Will be called whenever the slot has changed.
    */
    void hasChanged(buildSlot slot);
    
    void clearLabels();
}