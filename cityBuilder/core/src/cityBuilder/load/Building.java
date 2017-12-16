package cityBuilder.load;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.graphics.g2d.Batch;

import java.util.ArrayList;

import cityBuilder.objects.Tile;

public interface Building {

    void render( Batch batch, int buildingPosition, float x, float y );

    void update();

    void buildBuilding(ArrayList<ArrayList<Tile>> tiles, int x, int y, int rotation);
}
