package com.jakapong.gdx.game;

import com.badlogic.gdx.math.Vector2;

public class Obstacle {
	
	public static final int DIRECTION_UP = 1;
    public static final int DIRECTION_RIGHT = 2;
    public static final int DIRECTION_DOWN = 3;
    public static final int DIRECTION_LEFT = 4;
    public static final int DIRECTION_STILL = 0;
    public static final int SPEED = 5;
    
	private static final int [][]DIR_OFFSETS = new int [][]{
		{0,0},
		{0,1},
		{1,0},
		{0,-1},
		{-1,0}
	};
	
	private Vector2 position;
	
	public void move(int dir){
		position.x += SPEED*DIR_OFFSETS[dir][0];
		position.y += SPEED*DIR_OFFSETS[dir][1];	
	}
	
	public Obstacle(int x, int y){
		position = new Vector2(x,y);
	}
	
	public Vector2 getPosition(){
		return position;
	}
	
	private int getRow() {
        return ((int)position.y) / 40; 
    }
 
    private int getColumn() {
        return ((int)position.x) / 40; 
    }
}
