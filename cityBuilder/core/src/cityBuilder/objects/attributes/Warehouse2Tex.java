package cityBuilder.objects.attributes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.io.BufferedReader;
import java.io.IOException;

import cityBuilder.objects.Tile;

public class Warehouse2Tex {
    private Tile tile;
    private int position;
    private int rotation;
    private TextureRegion buildingRegion;

    public Warehouse2Tex(Tile tile, int position, int rotation, TextureAtlas atlas ) {
        this.tile = tile;
        this.position = position;
        this.rotation = rotation;

        // Very ugly and easy way to solve this issue.
        if (position == 0 && rotation == 0) {

            buildingRegion = atlas.findRegion("cubeDark");
        } else if(position == 1 && rotation == 0) {
            buildingRegion = atlas.findRegion("cubeDark");
        } else if(position == 2 && rotation == 0) {
            buildingRegion = atlas.findRegion("cubeLight");
        } else if(position == 3 && rotation == 0) {
            buildingRegion = atlas.findRegion("cubeDark");
        } else if(position == 4 && rotation == 0) {
            buildingRegion = atlas.findRegion("cubeDark");
        } else if(position == 5 && rotation == 0) {
            buildingRegion = atlas.findRegion("cubeDark");
        } else if(position == 6 && rotation == 0) {
            buildingRegion = atlas.findRegion("cubeDark");
        } else if(position == 7 && rotation == 0) {
            buildingRegion = atlas.findRegion("cubeDark");
        } else if(position == 8 && rotation == 0) {
            buildingRegion = atlas.findRegion("cubeDark");
        } else if (position == 0 && rotation == 1) {
            buildingRegion = atlas.findRegion("cubeDark");
        } else if(position == 1 && rotation == 1) {
            buildingRegion = atlas.findRegion("cubeDark");
        } else if(position == 2 && rotation == 1) {
            buildingRegion = atlas.findRegion("cubeDark");
        } else if(position == 3 && rotation == 1) {
            buildingRegion = atlas.findRegion("cubeDark");
        } else if(position == 4 && rotation == 1) {
            buildingRegion = atlas.findRegion("cubeDark");
        } else if(position == 5 && rotation == 1) {
            buildingRegion = atlas.findRegion("cubeDark");
        } else if(position == 6 && rotation == 1) {
            buildingRegion = atlas.findRegion("cubeDark");
        } else if(position == 7 && rotation == 1) {
            buildingRegion = atlas.findRegion("cubeDark");
        } else if(position == 8 && rotation == 1) {
            buildingRegion = atlas.findRegion("cubeLight");
        } else if (position == 0 && rotation == 2) {
            buildingRegion = atlas.findRegion("cubeDark");
        } else if(position == 1 && rotation == 2) {
            buildingRegion = atlas.findRegion("cubeDark");
        } else if(position == 2 && rotation == 2) {
            buildingRegion = atlas.findRegion("cubeDark");
        } else if(position == 3 && rotation == 2) {
            buildingRegion = atlas.findRegion("cubeDark");
        } else if(position == 4 && rotation == 2) {
            buildingRegion = atlas.findRegion("cubeDark");
        } else if(position == 5 && rotation == 2) {
            buildingRegion = atlas.findRegion("cubeDark");
        } else if(position == 6 && rotation == 2) {
            buildingRegion = atlas.findRegion("cubeLight");
        } else if(position == 7 && rotation == 2) {
            buildingRegion = atlas.findRegion("cubeDark");
        } else if(position == 8 && rotation == 2) {
            buildingRegion = atlas.findRegion("cubeDark");
        } else if (position == 0 && rotation == 3) {
            buildingRegion = atlas.findRegion("cubeDark");
        } else if(position == 1 && rotation == 3) {
            buildingRegion = atlas.findRegion("cubeDark");
        } else if(position == 2 && rotation == 3) {
            buildingRegion = atlas.findRegion("cubeDark");
        } else if(position == 3 && rotation == 3) {
            buildingRegion = atlas.findRegion("cubeDark");
        } else if(position == 4 && rotation == 3) {
            buildingRegion = atlas.findRegion("cubeLight");
        } else if(position == 5 && rotation == 3) {
            buildingRegion = atlas.findRegion("cubeDark");
        } else if(position == 6 && rotation == 3) {
            buildingRegion = atlas.findRegion("cubeDark");
        } else if(position == 7 && rotation == 3) {
            buildingRegion = atlas.findRegion("cubeDark");
        } else if(position == 8 && rotation == 3) {
            buildingRegion = atlas.findRegion("cubeDark");
        }
    }

    public void draw( Batch batch ) {
        batch.draw(buildingRegion, -32 + tile.getPosition().x, -32 + tile.getPosition().y, 32, 32, 64, 64, 1, 1, -(90 * rotation), false);
    }
}
