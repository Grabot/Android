package tile;


public class ResourceTile extends Tile {

	private int amount;
	
	public ResourceTile(TileType type, int amount) {
		super(type, true);
		
		this.amount = amount;
	}

	public int getResouce(int value) {
		value = value > amount ? amount : value;
		amount -= value;
		
		return value;
	}
	
}
