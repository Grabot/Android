package CityBuilder.load;

import CityBuilder.gameScreen.Simulation;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class DrawTiles extends Data
{
	private Texture SquareTileSelected;
	
	private TextureRegion SquareTileRegionSelected;
	public DrawTiles()
	{	
		SquareTileSelected = new Texture( Gdx.files.internal( "images/SquareSelectedSmall.png" ));
		SquareTileRegionSelected = new TextureRegion( SquareTileSelected, 0, 0, SquareTileSelected.getWidth(), SquareTileSelected.getHeight() );
	}
	

	public void fillTiles( Simulation simulation, Batch batch )
	{
		for( int i = 0; i < simulation.tiles.size(); i++ )
		{
			simulation.tiles.get(i).drawTile( batch );
		}
	}
	
	public void drawSelected( Simulation simulation, Batch batch, int tileNumber )
	{
		batch.draw( SquareTileRegionSelected, (-SquareTileSelected.getWidth()/2 + simulation.tiles.get(tileNumber).getPosition().x), (-SquareTileSelected.getHeight()/2 + simulation.tiles.get(tileNumber).getPosition().y), 0, 0, SquareTileSelected.getWidth(), SquareTileSelected.getHeight(), 1, 1, 0, false);
	}

}
