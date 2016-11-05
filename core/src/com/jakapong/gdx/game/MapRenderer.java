package com.jakapong.gdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MapRenderer {
	 private MapWorld mapWorld;
	 private SpriteBatch batch;
	 private Texture wallImage;
	
	 public MapRenderer(SpriteBatch batch, MapWorld mapWorld) {
	     this.mapWorld = mapWorld;
	     this.batch = batch;
	     
	     wallImage = new Texture("dot.png");
	 }
	 
	 public void render() {
		 batch.begin();
	        for(int r = 0; r < mapWorld.getHeight(); r++) {
	            for(int c = 0; c < mapWorld.getWidth(); c++) {
	                int x = c * 40;
	                int y = CramTheBookGame.HEIGHT - (r * 40) - 40;
	 
	                if(mapWorld.hasWallAt(r, c)) {
	                    batch.draw(wallImage, x, y);
	                }
	            }
	        }
	        batch.end();
	 }
}
