package onzichtbaar.net.Android.CityBuilder.load;

public class Vector 
{
        public float x, y;
        
        public Vector( float x, float y )
        {
                this.x = x;
                this.y = y;
        }
        
        public Vector( )
        {
                x = y = 0;
        }
        
        public Vector( Vector v )
        {
                set( v );
        }
        
        public void set( Vector v )
        {
                this.x = v.x;
                this.y = v.y;
        }
        
        public Vector add( Vector v )
        {
                this.x += v.x;
                this.y += v.y;
                return this;
        }
        
        public Vector sub( Vector v )
        {
                this.x -= v.x;
                this.y -= v.y;
                return this;
        }

        public void set(float x, float y )
        {       
                this.x = x;
                this.y = y;
        }

        public float distance(Vector v) 
        {       
                float a = v.x - x;
                float b = v.y - y;
                
                return (float)Math.sqrt( a * a + b * b );
        }
}
