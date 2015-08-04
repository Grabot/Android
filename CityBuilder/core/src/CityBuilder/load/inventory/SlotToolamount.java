package CityBuilder.load.inventory;

import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Window;

public class SlotToolamount extends Window implements SlotListener{

	private Skin skin;
    private Slot slot;
    
	public SlotToolamount( Slot slot, Skin skin )
	{
		super("", skin);
		this.skin = skin;
		this.slot = slot;
		hasChanged(slot);
        slot.addListener(this);
        setVisible(false);
	}

	@Override
	public void hasChanged(Slot slot) 
	{
		addSlotAmounts();
	}

	public void addSlotAmounts()
	{
		if (slot.isEmpty()) {
            setVisible(false);
            return;
        }
        // title displays the amount
        clear();
        Label label = new Label("" + slot.getAmount(), skin);
        add(label);
        pack();
        
      //see when the button is pressed
        setVisible(true);

        setPosition( slot.getPosition().x, slot.getPosition().y );
        toFront();
	}
	
	@Override
	public void clearLabels() 
	{
		super.setVisible(false);
	}
}
