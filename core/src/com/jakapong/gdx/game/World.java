package com.jakapong.gdx.game;

public class World {
	private CramTheBookGame cramTheBookGame;
	private Player player;
	private Obstacle obstacle;
	private MapWorld mapWorld;
	private Enemy enemy1;
	private Enemy enemy2;
	private Enemy enemy3;
	private int score = 0;
	private int lifepoint = 3;
	
	World(CramTheBookGame cramTheBookGame){
		this.cramTheBookGame =cramTheBookGame;
		
		player = new Player(70,70, this);
		obstacle = new Obstacle(200,200, this);
		enemy1 = new Enemy(1000,600, this);
		enemy2 = new Enemy(1200,600, this);
		enemy3 = new Enemy(1400,600, this);
		mapWorld = new MapWorld();
		
	}
	public int getScore(){
		return score;
	}
	
	public int getLifePoint(){
		return lifepoint;
	}
	
	public void decreaseScore(){
		lifepoint -= 1;
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
	
	Enemy getEnemy1(){
		return enemy1;
	}
	
	Enemy getEnemy2(){
		return enemy2;
	}
	
	Enemy getEnemy3(){
		return enemy3;
	}

    MapWorld getMapWorld() {
        return mapWorld;
    }
    
	public void update(float delta) {
		player.update();
		obstacle.update();
	}
}