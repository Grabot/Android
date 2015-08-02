package CityBuilder.load.inventory;

public enum Item {
	
	wood("logsResource"), 
	planks("planksResource"),
	stone("stoneResource"),
	brick("brickResource"),
	iron("ironOreResource"),
	ironIngot("ironIngotResource");

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