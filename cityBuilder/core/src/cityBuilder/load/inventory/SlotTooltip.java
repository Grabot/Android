package cityBuilder.load.inventory;

import cityBuilder.gameScreen.GameScreen;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class SlotTooltip extends Window implements SlotListener
{
    private Skin skin;
    private Slot slot;
    private GameScreen game;

    public SlotTooltip(GameScreen game, Slot slot, Skin skin) {
        super("", skin);
        this.slot = slot;
        this.skin = skin;
        this.game = game;
        hasChanged(slot);
        slot.addListener(this);
        setVisible(false);
    }

    @Override
    public void hasChanged(Slot slot) {
        if (slot.isEmpty()) {
            setVisible(false);
            return;
        }

        // title displays the amount
        clear();
        Label label;
        if( slot.getItem().toString() == "farm" )
        {
            label = new Label("This is a motherfucking \n" + slot.getItem(), skin);
            add(label);
            row();
            TextButton buildFarm = new TextButton("Build", skin );
            buildFarm.addListener(buildFarmListener);
            add(buildFarm);
        }
        else if( slot.getItem().toString() == "woodcutter" )
        {
            label = new Label("This is a motherfucking \n" + slot.getItem(), skin);
            add(label);
            row();
            TextButton buildWoodCutter = new TextButton("Build", skin );
            buildWoodCutter.addListener(buildWoodCutterListener);
            add(buildWoodCutter);
        } else if( slot.getItem().toString() == "fishershut" ) {
            label = new Label("This is THE motherfucking \n" + slot.getItem(), skin);
            add(label);
            row();
            TextButton buildWarehouse = new TextButton("Build", skin );
            buildWarehouse.addListener(buildWarehouseListener);
            add(buildWarehouse);
        }
        pack();

    }

    public ClickListener buildWoodCutterListener = new ClickListener()
    {
        @Override
        public void clicked (InputEvent event, float x, float y)
        {
            game.BuildWoodCutter();
        }
    };

    public ClickListener buildFarmListener = new ClickListener()
    {
        @Override
        public void clicked (InputEvent event, float x, float y)
        {
            game.BuildFarm();
        }
    };

    public ClickListener buildWarehouseListener = new ClickListener()
    {
        @Override
        public void clicked (InputEvent event, float x, float y)
        {
            game.BuildWarehouse();
        }
    };

    @Override
    public void setVisible(boolean visible) {
        super.setVisible(visible);
        //the listener sets this to true in case the slot is hovered
        //however, we don't want that in case the slot is empty
        if (slot.isEmpty()) {
            super.setVisible(false);
        }
    }

    @Override
    public void clearLabels()
    {
        super.setVisible(false);
    }

}