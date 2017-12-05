package cityBuilder.load.inventory;

import cityBuilder.Main;
import cityBuilder.gameScreen.GameScreen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class SlotActor extends ImageButton implements SlotListener {

    private Slot slot;

    private Skin skin;
    private SlotTooltip tooltip;
    private SlotToolamount toolamount;

    public SlotActor(GameScreen game, Skin skin, Slot slot, InventoryActor actor) {
        super(createStyle(skin, slot));
        this.slot = slot;
        this.skin = skin;

        // this actor has to be notified when the slot itself changes
        // ignore this for now, it will be explained in part IV
        tooltip = new SlotTooltip(game, slot, skin);
        toolamount = new SlotToolamount(slot, skin);
        Main.stage.addActor(tooltip);
        Main.stage.addActor(toolamount);
        addListener(new TooltipListener(tooltip, actor));
        addListener(new ToolamountListener(toolamount));

        slot.addListener(this);
    }

    /**
     * This will create a new style for our image button, with the correct image for the item type.
     */
    private static ImageButtonStyle createStyle(Skin skin, Slot slot) {
        TextureAtlas icons = new TextureAtlas(Gdx.files.internal("icons/Output9.pack"));
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
    public void hasChanged(Slot slot) {
        // when the slot changes, we switch the icon via a new style
        setStyle(createStyle(skin, slot));
    }

    public Slot getSlot() {
        return slot;
    }

    @Override
    public void clearLabels()
    {
        tooltip.clearLabels();
        toolamount.clearLabels();
    }

    public void addAmounts()
    {
        toolamount.addSlotAmounts();
    }

}