package tile;


public class Tile {
	private TileType type;
	private boolean isResource;

	public Tile(TileType type) {
		this.setType(type);
		this.isResource = false;
	}
	
	public Tile(TileType type, boolean isResource) {
		this.setType(type);
		this.isResource = isResource;
	}

	public TileType getType() {
		return type;
	}

	public void setType(TileType type) {
		this.type = type;
	}
	
	public boolean isResource() {
		return isResource;
	}

}