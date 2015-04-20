package tile;

import java.util.ArrayList;
import java.util.List;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class LayeredSprite extends Sprite {

	private List<Sprite> layers = new ArrayList<Sprite>();
	
	public LayeredSprite(Sprite sprite) {
		super();
		this.layers.add(sprite);
	}

	@Override
	public void setPosition(float x, float y) {
		for(Sprite layer : layers) {
			layer.setPosition(x, y);
		}
	}
	
	@Override
	public void draw(Batch batch) {
		for(Sprite layer : layers) {
			layer.draw(batch);
		}
	}

	@Override
	public void setSize(float width, float height) {
		for(Sprite layer : layers) {
			layer.setSize(width, height);
		}
	}
	
	public int size() {
		return layers.size();
	}

	public boolean isEmpty() {
		return layers.isEmpty();
	}

	public boolean contains(Object o) {
		return contains(o);
	}

	public boolean add(Sprite e) {
		return layers.add(e);
	}

	public boolean remove(Object o) {
		return layers.remove(o);
	}

	public void clear() {
		layers.clear();
	}

	public Sprite get(int index) {
		return layers.get(index);
	}

	public void add(int index, Sprite element) {
		layers.add(index, element);
	}

	public Sprite remove(int index) {
		return layers.remove(index);
	}

}
