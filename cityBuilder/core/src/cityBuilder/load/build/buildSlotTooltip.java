package cityBuilder.load.build;

import cityBuilder.load.Item;
import cityBuilder.load.inventory.Inventory;

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

		TextureAtlas icons = new TextureAtlas(Gdx.files.internal("icons/Output9.pack"));
		final TextureRegion logImage = icons.findRegion("woodClear");
		final TextureRegion stoneImage = icons.findRegion("stoneClear");
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
		if( slot.getItem() == Item.values()[2] ) {
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
		} else if( slot.getItem() == Item.values()[3] ) {
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
		} else if( slot.getItem() == Item.values()[13] ) {
			//woodcutter
			row().fill().expandX();
			clear();
			label = new Label("woodcutter \nResources required: \n", skin);

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
			buildButton.addListener(createListenerWoodcutter);
		} else if( slot.getItem() == Item.values()[0]) {
			//new warehouse test
			row().fill().expandX();
			clear();
			label = new Label("WareHouse \nResources required: \n", skin);

			logIcon.setBounds(logIcon.getX(), logIcon.getY(), logImage.getRegionWidth(), logImage.getRegionHeight());
			stoneIcon.setBounds(stoneIcon.getX(), stoneIcon.getY(), stoneImage.getRegionWidth(), stoneImage.getRegionHeight());

			add(label);
			row();
			add(logIcon);
			Label amountWood = new Label("x50", skin);
			add(amountWood);
			row();
			add(stoneIcon);
			Label amountStone = new Label("x20", skin);
			add( amountStone );
			row();

			buildButton = new TextButton( "Create", skin );
			buildButton.addListener(createListenerWareHouse);
		}  else if( slot.getItem() == Item.values()[6]) {
			// road
			row().fill().expandX();
			clear();
			label = new Label("ROAD! \nResources required: \n", skin);

			logIcon.setBounds(logIcon.getX(), logIcon.getY(), logImage.getRegionWidth(), logImage.getRegionHeight());
			stoneIcon.setBounds(stoneIcon.getX(), stoneIcon.getY(), stoneImage.getRegionWidth(), stoneImage.getRegionHeight());

			add(label);
			row();
			add(logIcon);
			Label amountWood = new Label("x50", skin);
			add(amountWood);
			row();
			add(stoneIcon);
			Label amountStone = new Label("x20", skin);
			add( amountStone );
			row();

			buildButton = new TextButton( "Create", skin );
			buildButton.addListener(createListenerRoad);
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
				inventory.addItem(inventory.firstEmtpySlot(), 2);
			}
			else
			{
				inventory.addItem(inventory.findResourceSlot("farm"), 2);
			}
		}
	};

	public ClickListener createListenerFisher = new ClickListener()
	{
		@Override
		public void clicked (InputEvent event, float x, float y)
		{
			if (inventory.checkInventoryTest("fisherMan") == -1 )
			{
				inventory.addItem(inventory.firstEmtpySlot(), 3);
			}
			else
			{
				inventory.addItem(inventory.findResourceSlot("fisherMan"), 3);
			}
		}
	};

	public ClickListener createListenerWoodcutter = new ClickListener()
	{
		@Override
		public void clicked (InputEvent event, float x, float y)
		{
			if (inventory.checkInventoryTest("woodCutter") == -1 )
			{
				inventory.addItem(inventory.firstEmtpySlot(), 13);
			}
			else
			{
				inventory.addItem(inventory.findResourceSlot("woodCutter"), 13);
			}
		}
	};

	public ClickListener createListenerWareHouse = new ClickListener() {
		@Override
		public void clicked (InputEvent event, float x, float y) {
			if (inventory.checkInventoryTest("brick") == -1) {
				inventory.addItem(inventory.firstEmtpySlot(), 0);
			} else {
				inventory.addItem(inventory.findResourceSlot("brick"), 0);
			}
		}
	};

	public ClickListener createListenerRoad = new ClickListener() {
		@Override
		public void clicked (InputEvent event, float x, float y) {
			if (inventory.checkInventoryTest("road") == -1) {
				inventory.addItem(inventory.firstEmtpySlot(), 6);
			} else {
				inventory.addItem(inventory.findResourceSlot("road"), 6);
			}
		}
	};

	@Override
	public void clearLabels()
	{
		super.setVisible(false);
	}

}