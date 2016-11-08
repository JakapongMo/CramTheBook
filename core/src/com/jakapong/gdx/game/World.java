package com.jakapong.gdx.game;

public class World {
	private CramTheBookGame cramTheBookGame;
	private Player player;
	private Obstacle obstacle;
	private MapWorld mapWorld;
	private int score = 0;
	
	World(CramTheBookGame cramTheBookGame){
		this.cramTheBookGame =cramTheBookGame;
		
		player = new Player(60,60, this);
		obstacle = new Obstacle(200,200, this);
		mapWorld = new MapWorld();
	}
	public int getScore(){
		return score;
	}
	
	public void increaseScore(){
		score +=1;
	}
	
	Player getPlayer(){
		return player;
	}
	Obstacle getObstacle(){
		return obstacle;
	}

    MapWorld getMapWorld() {
        return mapWorld;
    }
    
	public void update(float delta) {
		player.update();
		obstacle.update();
	}
}