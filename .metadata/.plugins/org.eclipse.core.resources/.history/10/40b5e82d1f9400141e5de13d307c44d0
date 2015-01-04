package onzichtbaar.net.greaterThanFive6.load;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.List.ListStyle;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane.ScrollPaneStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Slider.SliderStyle;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.TextField.TextFieldStyle;

public class Skin_Setup
{

	private ListStyle liststyle;
	private ScrollPaneStyle scrollpanestyle;
	
	private Skin skin;
	
	public Skin_Setup()
	{
		skin = new Skin();
	}
	
	public Skin set_skin()
	{
		//Generate a 1x1 white texture and store it in the skin named "white".
		Pixmap pixmap = new Pixmap(1, 1, Format.RGBA8888);
		pixmap.setColor(Color.WHITE);
		pixmap.fill();
		skin.add("white", new Texture(pixmap));
		
		skin.add( "default", new BitmapFont() );
				
		TextFieldStyle textfieldstyle = new TextFieldStyle();
		textfieldstyle.font = new BitmapFont();
		textfieldstyle.font.scale( 1f );
		textfieldstyle.fontColor = new Color( 1, 1, 1, 1 );
		skin.add( "default", textfieldstyle );
		
		LabelStyle labelstyle = new LabelStyle();
		labelstyle.font = new BitmapFont();
		labelstyle.fontColor = new Color( 1, 1, 1, 1);
		skin.add( "default", labelstyle);
		
		TextButtonStyle textButtonStyle = new TextButtonStyle();
		textButtonStyle.up = skin.newDrawable("white", Color.DARK_GRAY);
		textButtonStyle.down = skin.newDrawable("white", Color.BLUE);
		//textButtonStyle.checked = skin.newDrawable("white", Color.BLUE);
		textButtonStyle.font = skin.getFont("default");
		textButtonStyle.font.scale( 1f );
		skin.add("default", textButtonStyle);
		
		liststyle = new ListStyle();
		liststyle.font = new BitmapFont();
		liststyle.fontColorSelected = new Color( 1, 1, 1, 1 );
		liststyle.fontColorUnselected = new Color( 1, 1, 1, 1 );
		liststyle.selection = skin.newDrawable("white", Color.DARK_GRAY);
		
		scrollpanestyle = new ScrollPaneStyle();
		scrollpanestyle.hScrollKnob = skin.newDrawable( "white", Color.BLACK );
		scrollpanestyle.vScrollKnob = skin.newDrawable( "white", Color.GRAY );
		
		// Store the default libgdx font under the name "default".
		skin.add( "default", new BitmapFont() );
		skin.add( "default", liststyle );
		skin.add( "default", scrollpanestyle );
				
		return skin;
	}
	
}
