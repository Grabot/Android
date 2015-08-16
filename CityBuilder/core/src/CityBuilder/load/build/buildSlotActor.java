package CityBuilder.load.build;

import CityBuilder.Main;
import CityBuilder.load.Item;
import CityBuilder.load.inventory.Inventory;
import CityBuilder.load.inventory.InventoryActor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class buildSlotActor extends ImageButton implements buildSlotListener
{
	
	private buildSlotTooltip tooltip;
	
	public buildSlotActor(Inventory inventory, Skin skin, buildSlot slot, buildActor actor) 
	{
        super(createStyle(skin, slot));
        
        tooltip = new buildSlotTooltip(inventory, slot, skin);
        Main.stage.addActor(tooltip);
        addListener(new buildTooltipListener(tooltip, actor));
        slot.addListener(this);
	}
	
	/**
     * This will create a new style for our image button, with the correct image for the item type.
     */
    private static ImageButtonStyle createStyle(Skin skin, buildSlot slot) {
    	TextureAtlas icons = new TextureAtlas(Gdx.files.internal("icons/Output7.pack"));
        //TextureAtlas icons = Main.assets.get("icons/icons.atlas", TextureAtlas.class);
        TextureRegion image;
        if (slot.getItem() != null) {
            image = icons.findRegion(slot.getItem().getTextureRegion());
        } else {
            // we have a special "empty" region in our atlas file, which is just black
            image = icons.findRegion("empty");
        }

        ImageButtonStyle style = new ImageButtonStyle(skin.get(ButtonStyle.class));
        style.imageUp = new TextureRegionDrawable(image);
        style.imageDown = new TextureRegionDrawable(image);
        
        return style;
    }

	@Override
	public void hasChanged(buildSlot slot) {		
	}

	@Override
	public void clearLabels() 
	{
		tooltip.clearLabels();
	}
    
}