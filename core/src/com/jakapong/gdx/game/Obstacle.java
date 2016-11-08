package com.jakapong.gdx.game;

import com.badlogic.gdx.math.Vector2;

public class Obstacle {
	
	private int currentDirection;
	private int nextDirection;
	World world;
	public static final int DIRECTION_UP = 1;
    public static final int DIRECTION_RIGHT = 2;
    public static final int DIRECTION_DOWN = 3;
    public static final int DIRECTION_LEFT = 4;
    public static final int DIRECTION_STILL = 0;
    public static final int SPEED = 5;
    public static int CHECK_EDGE = 0;
    
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
	
	public Obstacle(int x, int y, World world){
		position = new Vector2(x,y);
		position = new Vector2(x,y);
		currentDirection = DIRECTION_STILL;
		nextDirection = DIRECTION_STILL;
		this.world = world;
	}
	
	public void setNextDirection(int dir){
		nextDirection = dir;
	}
	
	public void update(){
		if (canMoveInDirection(nextDirection)) {
			currentDirection = nextDirection;
		
		}else{
			currentDirection=DIRECTION_STILL;
			CHECK_EDGE++;
		}
		position.x +=SPEED*DIR_OFFSETS[currentDirection][0];
		position.y +=SPEED*DIR_OFFSETS[currentDirection][1];
	}
	private boolean canMoveInDirection(int dir){
		MapWorld mapWorld = world.getMapWorld();
		int newRow = (int)getRow()+ DIR_OFFSETS[nextDirection][1];
		int newCol = (int)getColumn()+ DIR_OFFSETS[nextDirection][0];
		if(mapWorld.hasWallAt(newRow, newCol)){
			return false;
		}
		return true;
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
