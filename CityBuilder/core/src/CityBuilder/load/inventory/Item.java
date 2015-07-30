package CityBuilder.load.inventory;

public enum Item {
	
	WoodWithPurple("purple"), 
	NormalWood("woodSlot");

    private String textureRegion;

    private Item(String textureRegion) 
    {
        this.textureRegion = textureRegion;
    }

    public String getTextureRegion() 
    {
        return textureRegion;
    }
}