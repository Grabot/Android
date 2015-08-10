package CityBuilder.load.build;

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
        row().fill().expandX();
        clear();
        Label label = new Label("Farm \nResources required: \n", skin);
        
        TextureAtlas icons = new TextureAtlas(Gdx.files.internal("icons/Inventory.atlas"));
        //TextureAtlas icons = Main.assets.get("icons/icons.atlas", TextureAtlas.class);
        final TextureRegion image = icons.findRegion("log_icon2");
        final Actor testImage = new Actor(){
            public void draw(Batch batch, float alpha){
                batch.draw(image, getX(), getY(), getOriginX(), getOriginY(), getWidth(), getHeight(), getScaleX(), getScaleY(), getRotation());
            }
        };
        testImage.setBounds(testImage.getX(), testImage.getY(), image.getRegionWidth(), image.getRegionHeight());
        final TextureRegion image2 = icons.findRegion("stone");
        final Actor testImage2 = new Actor(){
            public void draw(Batch batch, float alpha){
                batch.draw(image2, getX(), getY(), getOriginX(), getOriginY(), getWidth(), getHeight(), getScaleX(), getScaleY(), getRotation());
            }
        };
        testImage2.setBounds(testImage2.getX(), testImage2.getY(), image2.getRegionWidth(), image2.getRegionHeight());
        
        add(label);
        row();
        add(testImage);
        Label amountWood = new Label("x100", skin);
        add(amountWood);
        row();
        add(testImage2);
        Label amountStone = new Label("x50", skin);
        add( amountStone );
        row();
        
        TextButton buildButton = new TextButton( "Create", skin );
        buildButton.addListener(createListener);
        add(buildButton);
        pack();
	}

	public ClickListener createListener = new ClickListener() 
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
	
	@Override
	public void clearLabels() 
	{
		super.setVisible(false);
	}
    
}