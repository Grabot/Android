package CityBuilder.load.inventory;

public enum Item {
	
	LogResource("logsResource"), 
	planksResource("planksResource"),
	stoneResource("stoneResource"),
	brickResource("brickResource"),
	ironOreResource("ironOreResource"),
	ironIngotResource("ironIngotResource");

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