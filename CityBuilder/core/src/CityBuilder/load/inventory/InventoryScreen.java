package CityBuilder.load.inventory;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.DragAndDrop;

/**
 * @author Daniel Holderbaum
 */
public class InventoryScreen implements Screen {

	private InventoryActor inventoryActor;

	public static Stage stage;

	@Override
	public void show() {
		stage = new Stage();
		Gdx.input.setInputProcessor(stage);

		Skin skin = new Skin(Gdx.files.internal("skins/uiskin.json"));
        //Skin skin = Main.assets.get("skins/uiskin.json", Skin.class);
		DragAndDrop dragAndDrop = new DragAndDrop();
		inventoryActor = new InventoryActor(new Inventory(), dragAndDrop, skin);
		stage.addActor(inventoryActor);
	}
	
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0.2f, 0.2f, 0.2f, 0f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);

		if (Gdx.input.isKeyPressed(Input.Keys.ANY_KEY)) {
			inventoryActor.setVisible(true);
		}

		stage.act(delta);
		stage.draw();
	}

	@Override
	public void resize(int width, int height) {
		stage.getViewport().update(width, height, true);
	}

	@Override
	public void pause() {
		// NOOP
	}

	@Override
	public void hide() {
		Gdx.input.setInputProcessor(null);
		dispose();
	}

	@Override
	public void dispose() {
		stage.dispose();
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

}