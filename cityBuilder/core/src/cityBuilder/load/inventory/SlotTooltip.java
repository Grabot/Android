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
        if( slot.getItem().toString().equals("farm")) {
            label = new Label("This is a motherfucking \n" + slot.getItem(), skin);
            add(label);
            row();
            TextButton buildFarm = new TextButton("Build", skin );
            buildFarm.addListener(buildFarmListener);
            add(buildFarm);
        } else if( slot.getItem().toString().equals("woodCutter")) {
            label = new Label("This is a motherfucking \n" + slot.getItem(), skin);
            add(label);
            row();
            TextButton buildWoodCutter = new TextButton("Build", skin );
            buildWoodCutter.addListener(buildWoodCutterListener);
            add(buildWoodCutter);
        } else if( slot.getItem().toString().equals("fisherMan")) {
            label = new Label("This is THE motherfucking \n" + slot.getItem(), skin);
            add(label);
            row();
            TextButton buildWarehouse = new TextButton("Build", skin );
            buildWarehouse.addListener(buildWarehouseListener);
            add(buildWarehouse);
        } else if( slot.getItem().toString().equals("brick")) {
            label = new Label("This is another motherfucking \n" + slot.getItem(), skin);
            add(label);
            row();
            TextButton buildWarehouse2 = new TextButton("Build", skin );
            buildWarehouse2.addListener(buildWarehouse2Listener);
            add(buildWarehouse2);
        } else if( slot.getItem().toString().equals("road")) {
            label = new Label("This is ROOAADD! \n" + slot.getItem(), skin);
            add(label);
            row();
            TextButton buildRoad = new TextButton("Build", skin );
            buildRoad.addListener(buildRoadListener);
            add(buildRoad);
        } else if( slot.getItem().toString().equals("treeSeed")) {
            label = new Label("Build a tree seed! \n" + slot.getItem(), skin);
            add(label);
            row();
            TextButton buildRoad = new TextButton("Build", skin );
            buildRoad.addListener(buildTreeListener);
            add(buildRoad);
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

    public ClickListener buildWarehouse2Listener = new ClickListener() {
        @Override
        public void clicked (InputEvent event, float x, float y) {
            game.buildWarehouse2();
        }
    };

    public ClickListener buildRoadListener = new ClickListener() {
        @Override
        public void clicked (InputEvent event, float x, float y){
            game.buildRoad();
        }
    };

    public ClickListener buildTreeListener = new ClickListener() {
        @Override
        public void clicked(InputEvent event, float x, float y) {
            game.buildTree();
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