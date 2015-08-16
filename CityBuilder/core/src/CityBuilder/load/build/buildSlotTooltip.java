package CityBuilder.load.build;

import CityBuilder.load.Item;
import CityBuilder.load.inventory.Inventory;
import CityBuilder.load.inventory.InventoryActor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class buildSlotTooltip extends Window implements buildSlotListener
{
	private Skin skin;
    private buildSlot slot;
    private Inventory inventory;
    
    public buildSlotTooltip(Inventory inventory, buildSlot slot, Skin skin) {
        super("", skin);
        this.slot = slot;
        this.skin = skin;
        this.inventory = inventory;
        hasChanged(slot);
        slot.addListener(this);
        setVisible(false);
    }

    @Override
    public void setVisible(boolean visible) {
        super.setVisible(visible);
        
        if (slot.isEmpty()) {
            super.setVisible(false);
        }
        
    }
    
	@Override
	public void hasChanged(buildSlot slot) {
		if (slot.isEmpty()) {
            setVisible(false);
            return;
		}
        // title displays the amount
        // basic layout

        TextureAtlas icons = new TextureAtlas(Gdx.files.internal("icons/Output6.pack"));
        final TextureRegion logImage = icons.findRegion("log_icon2");
        final TextureRegion stoneImage = icons.findRegion("stone");
        final Actor logIcon = new Actor(){
            public void draw(Batch batch, float alpha){
                batch.draw(logImage, getX(), getY(), getOriginX(), getOriginY(), getWidth(), getHeight(), getScaleX(), getScaleY(), getRotation());
            }
        };
        final Actor stoneIcon = new Actor(){
            public void draw(Batch batch, float alpha){
                batch.draw(stoneImage, getX(), getY(), getOriginX(), getOriginY(), getWidth(), getHeight(), getScaleX(), getScaleY(), getRotation());
            }
        };
        
		TextButton buildButton = null;
		Label label = null;
		if( slot.getItem() == Item.values()[6] )
		{
			//farm
			row().fill().expandX();
	        clear();
	        label = new Label("Farm \nResources required: \n", skin);

	        logIcon.setBounds(logIcon.getX(), logIcon.getY(), logImage.getRegionWidth(), logImage.getRegionHeight());
	        stoneIcon.setBounds(stoneIcon.getX(), stoneIcon.getY(), stoneImage.getRegionWidth(), stoneImage.getRegionHeight());
	        add(label);
	        row();
	        add(logIcon);
	        Label amountWood = new Label("x100", skin);
	        add(amountWood);
	        row();
	        add(stoneIcon);
	        Label amountStone = new Label("x50", skin);
	        add( amountStone );
	        row();
	        buildButton = new TextButton( "Create", skin );
	        buildButton.addListener(createListenerFarm);
		}
		else if( slot.getItem() == Item.values()[9] )
		{
			//fisher
			row().fill().expandX();
	        clear();
	        label = new Label("fisherman's hut \nResources required: \n", skin);
	        
	        logIcon.setBounds(logIcon.getX(), logIcon.getY(), logImage.getRegionWidth(), logImage.getRegionHeight());
	        stoneIcon.setBounds(stoneIcon.getX(), stoneIcon.getY(), stoneImage.getRegionWidth(), stoneImage.getRegionHeight());
	       
	        add(label);
	        row();
	        add(logIcon);
	        Label amountWood = new Label("x100", skin);
	        add(amountWood);
	        row();
	        add(stoneIcon);
	        Label amountStone = new Label("x50", skin);
	        add( amountStone );
	        row();
	       
	        buildButton = new TextButton( "Create", skin );
	        buildButton.addListener(createListenerFisher);
		}
        add(buildButton);
        pack();
	}

	public ClickListener createListenerFarm = new ClickListener() 
	{
		@Override
		public void clicked (InputEvent event, float x, float y) 
		{
			if (inventory.checkInventoryTest("farm") == -1 )
			{
				inventory.addItem(inventory.firstEmtpySlot(), 6);
			}
			else
			{
				inventory.addItem(inventory.findResourceSlot("farm"), 6);
			}
		}
	};
	
	public ClickListener createListenerFisher = new ClickListener() 
	{
		@Override
		public void clicked (InputEvent event, float x, float y) 
		{
			if (inventory.checkInventoryTest("fishershut") == -1 )
			{
				inventory.addItem(inventory.firstEmtpySlot(), 9);
			}
			else
			{
				inventory.addItem(inventory.findResourceSlot("fishershut"), 9);
			}
		}
	};
	
	@Override
	public void clearLabels() 
	{
		super.setVisible(false);
	}
    
}