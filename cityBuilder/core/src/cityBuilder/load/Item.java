package cityBuilder.load;

public enum Item {

	brick("brick"),					// 0
	empty("empty"), 				// 1
	farm("farm"),					// 2
	fisherMan("fisherMan"),			// 3
	iron("iron"),					// 4
	ironOre("ironOre"),				// 5
	road("road"), 					// 6
	roadClear("roadClear"),			// 7
	stone("stone"),					// 8
	stoneClear("stoneClear"),		// 9
	wood("wood"),					// 10
	woodBoard("woodBoard"),			// 11
	woodClear("woodClear"),			// 12
	woodCutter("woodCutter"),		// 13
	treeSeed("treeSeed");			// 14

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