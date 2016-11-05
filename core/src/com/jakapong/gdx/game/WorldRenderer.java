package com.jakapong.gdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class WorldRenderer extends ScreenAdapter{

	CramTheBookGame cramTheBookGame;
	World world;
	SpriteBatch batch;
	Texture playerImg;
	Texture obstacleImg;
	//Texture bgImg;
	Player player;
	Obstacle obstacle;
	private MapRenderer mapRenderer;
	
	public WorldRenderer(CramTheBookGame cramTheBookGame, World world){
		this.cramTheBookGame = cramTheBookGame;
		batch = cramTheBookGame.batch;
		this.world = world;
		playerImg = new Texture("boy.png");
		obstacleImg = new Texture("obstacle-1.png");
		//bgImg = new Texture("backgroud-2.jpg");
		
		mapRenderer = new MapRenderer(cramTheBookGame.batch, world.getMapWorld());
		
	}
	@Override
	public void render(float delta){
		mapRenderer.render();
		player = world.getPlayer();
		obstacle = world.getObstacle();
		SpriteBatch batch = cramTheBookGame.batch;
		Vector2 posPlayer = player.getPosition();
		Vector2 posObstacle = obstacle.getPosition();
		batch.begin();
		//batch.draw(bgImg,0,0);
		batch.draw(obstacleImg,posObstacle.x,posObstacle.y);
		batch.draw(playerImg,posPlayer.x,posPlayer.y);
		
		batch.end();
		
	}
}