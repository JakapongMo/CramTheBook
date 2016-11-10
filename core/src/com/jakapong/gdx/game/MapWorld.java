package com.jakapong.gdx.game;

public class MapWorld {
	 private String[] MAP = new String [] {
	            "##############################",
	            "#B...........................#",
	            "#B...........................#",
	            "#B....12............12.......#",
	            "#B....34............34.......#",
	            "#B..........BB...............#",
	            "#B...........................#",
	            "#B....12............12.......#",
	            "#B....34............34.......#",
	            "#B...........................#",
	            "#B...........................#",
	            "#B....12....BB......12.......#",
	            "#B....34............34.......#",
	            "#B...........................#",
	            "#B...........................#",
	            "#B....12............12.......#",
	            "#B....34............34.......#",
	            "#B..........BB...............#",
	            "#B...........................#",
	            "#B...........................#",
	            "#B...........................#",
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
	 
	 public boolean hasT1At(int r, int c) {
	     return MAP[r].charAt(c) == '1';
	 }
	 
	 public boolean hasT2At(int r, int c) {
	     return MAP[r].charAt(c) == '2';
	 }
	 
	 public boolean hasT3At(int r, int c) {
	     return MAP[r].charAt(c) == '3';
	 }
	 
	 public boolean hasT4At(int r, int c) {
	     return MAP[r].charAt(c) == '4';
	 }
	 
	 public boolean hasBlockAt(int r, int c) {
	     return MAP[r].charAt(c) == 'B';
	 }
}