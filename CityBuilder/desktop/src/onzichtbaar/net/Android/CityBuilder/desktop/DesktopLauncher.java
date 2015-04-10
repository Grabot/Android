package onzichtbaar.net.Android.CityBuilder.desktop;

import CityBuilder.Main;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		
		config.title = "City Builder";
		config.width = 1280;
		config.height = 720;

		new LwjglApplication(new Main(), config);
	}
}
