package onzichtbaar.net.greaterThanFive6.townScreen;

import java.util.ArrayList;

import onzichtbaar.net.greaterThanFive6.objects.Citizen;

import com.badlogic.gdx.Gdx;

public class Simulation 
{
		private float emma = 0;
		private float watson = 0;

		private float width = 0;
		private float height = 0;

		private float touchX = 0;
		private float touchY = 0;
		private float distance = 0;
		private boolean touched_down = false;
        private boolean back_pressed = false;
        private boolean fast_press = false;
        private boolean down_pressed = false;
        private boolean up_pressed = false;
        private boolean enter_pressed = false;
        
        float touch_distance_x = 999;
        float touch_distance_y = 999;
        
        public ArrayList<Citizen> citizens = new ArrayList<Citizen>();
		
		public static final String LOG = Simulation.class.getSimpleName();
                
        private TownScreen game;
        
        public Simulation( TownScreen game, ArrayList<Citizen> citizens )
        {
        		this.citizens = citizens;
        		this.game = game;
                populate( );
        }
        
        public void populate( )
        {
        	Gdx.app.log( Simulation.LOG, "Town Screen populated" );
        }
        
        public void variables( float touchX, float touchY, float width, float height, boolean touched_down, boolean fast_press, boolean back_pressed, boolean down_pressed, boolean enter_pressed, boolean up_pressed, float distance ) 
        {
    		this.width = width;
    		this.height = height;
    		
    		this.touchX = touchX;
    		this.touchY = touchY;
    		
    		this.touched_down = touched_down;
    		this.back_pressed = back_pressed;
    		this.fast_press = fast_press;
    		this.down_pressed = down_pressed;
    		this.up_pressed = up_pressed;
    		this.distance = distance;
    		this.enter_pressed = enter_pressed;
        }

        public void update( float delta )
        {
        }
        
        public void CitizenOperator( String name )
        {
        }
        
        public boolean enterPressed()
        {
        	return enter_pressed;
        }
}
