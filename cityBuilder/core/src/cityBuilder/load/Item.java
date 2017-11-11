package cityBuilder.load;

public enum Item {

	wood("logsResource"), //0
	planks("planksResource"), //1
	stone("stoneResource"), //2
	brick("brickResource"), //3
	iron("ironOreResource"), //4
	ironIngot("ironIngotResource"), //5
	farm("farmResource"), //6
	woodIcon("log_icon2"), //7
	stonIcon("stone"), //8
	fishershut("fishermanResource"), //9
	woodcutter("woodcutterResource"); //10

	private String textureRegion;

	Item(String textureRegion)
	{
		this.textureRegion = textureRegion;
	}

	public String getTextureRegion()
	{
		return textureRegion;
	}
}