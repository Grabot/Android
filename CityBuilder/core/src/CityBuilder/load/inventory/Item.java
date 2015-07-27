package CityBuilder.load.inventory;

public enum Item {
	
	CRYSTAL_RED("purple"), 
	CRYSTAL_BLUE("woodSlot");

    private String textureRegion;

    private Item(String textureRegion) {
        this.textureRegion = textureRegion;
    }

    public String getTextureRegion() {
        return textureRegion;
    }
}