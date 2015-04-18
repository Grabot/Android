package tile;


public class ResourceTile extends Tile {

	private int startAmount;
	private int currentAmount;
	
	public ResourceTile(TileType type, int amount) {
		super(type);
		
		this.isResource = true;
		
		this.startAmount = amount;
		this.currentAmount = amount;
	}
	
	public int getStartAmount() {
		return startAmount;
	}

	public int getResouce(int value) {
		value = value > currentAmount ? currentAmount : value;
		currentAmount -= value;
		
		return value;
	}

		
}
