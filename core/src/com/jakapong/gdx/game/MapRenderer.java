package com.jakapong.gdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MapRenderer {
	 private MapWorld mapWorld;
	 private SpriteBatch batch;
	 private Texture wallImage;
	 private Texture t1Image;
	 private Texture t2Image;
	 private Texture t3Image;
	 private Texture t4Image;
	 private Texture blockImage;
	
	 public MapRenderer(SpriteBatch batch, MapWorld mapWorld) {
	     this.mapWorld = mapWorld;
	     this.batch = batch;
	     
	     wallImage = new Texture("grayblock.jpg");
	     t1Image = new Texture("image-1.jpg");
	     t2Image = new Texture("image-2.jpg");
	     t3Image = new Texture("image-3.jpg");
	     t4Image = new Texture("image-4.jpg");
	     blockImage = new Texture("block.jpg");
	 }
	 
	 public void render() {
		 batch.begin();
	        for(int r = 0; r < mapWorld.getHeight(); r++) {
	            for(int c = 0; c < mapWorld.getWidth(); c++) {
	                int x = c * 40;
	                int y = CramTheBookGame.HEIGHT - (r * 40) - 40;
	 
	                if (mapWorld.hasWallAt(r, c)) {
	                    batch.draw(wallImage, x, y);
	                }
	                if (mapWorld.hasDAt(r, c)) {
	                	batch.draw(wallImage, x, y);
	                }
	                if( mapWorld.hasT1At(r, c)) {
	                	batch.draw(t1Image, x, y);
	                }
	                if( mapWorld.hasT2At(r, c)) {
	                	batch.draw(t2Image, x, y);
	                }
	                if( mapWorld.hasT3At(r, c)) {
	                	batch.draw(t3Image, x, y);
	                }
	                if( mapWorld.hasT4At(r, c)) {
	                	batch.draw(t4Image, x, y);
	                }
	                
	                if( mapWorld.hasBlockAt(r, c)) {
	                	batch.draw(blockImage, x, y);
	                }
	            }
	        }
	        batch.end();
	 }
}
