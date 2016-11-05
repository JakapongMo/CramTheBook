package com.jakapong.gdx.game;

public class MapWorld {
	 private String[] MAP = new String [] {
	            "##############################",
	            "#d...........................#",
	            "#d...........................#",
	            "#d...........................#",
	            "#d...........................#",
	            "#d...........................#",
	            "#d...........................#",
	            "#d...........................#",
	            "#d...........................#",
	            "#d...........................#",
	            "#d...........................#",
	            "#d...........................#",
	            "#d...........................#",
	            "#d...........................#",
	            "#d...........................#",
	            "#d...........................#",
	            "#d...........................#",
	            "#d...........................#",
	            "#d...........................#",
	            "#d...........................#",
	            "#d...........................#",
	            "#dddddddddddddddddddddddddddd#",
	            "##############################"
	    };
	 private int height;
	 private int width;
	 
	 public MapWorld() {
		 height = MAP.length;
		 width = MAP[0].length();
	 }
	 
	 public int getHeight() {
		 return height;
	 
	 }
	 
	 public int getWidth() {
		 return width;
	 }
	 
	 public boolean hasWallAt(int r, int c) {
	     return MAP[r].charAt(c) == '#';
	 }
	 
	 public boolean hasDAt(int r, int c) {
	     return MAP[r].charAt(c) == 'd';
	 }

}
