package CityBuilder.load.inventory;

public enum Item {

	CRYSTAL_RED("redcrystal"), CRYSTAL_BLUE("bluecrystal"), CRYSTAL_GREEN("greencrystal"), CRYSTAL_YELLOW("yellowcrystal"), CRYSTAL_MAGENTA("magentacrystal"), CRYSTAL_CYAN(
			"cyancrystal"), CRYSTAL_ORANGE("orangecrystal"), CRYSTAL_VIOLET("violetcrystal"), TITANIUM("titanium"), PALLADIUM("palladium"), IRIDIUM("iridium"), RHODIUM("rhodium"), HULL(
			"hullbase"), CANNON("cannonbase"), RAY("raybase"), LAUNCHER("launcherbase"), DROID("droidbase"), MINE("dropperbase"), BATTERY("batterybase");

	private String textureRegion;

	private Item(String textureRegion) {
		this.textureRegion = textureRegion;
	}

	public String getTextureRegion() {
		return textureRegion;
	}

}