package CityBuilder.load;

public enum Item {
	
	wood("logsResource"), 
	planks("planksResource"),
	stone("stoneResource"),
	brick("brickResource"),
	iron("ironOreResource"),
	ironIngot("ironIngotResource"),
	farm("farmResource"),
	woodIcon("log_icon2"),
	stonIcon("stone");

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