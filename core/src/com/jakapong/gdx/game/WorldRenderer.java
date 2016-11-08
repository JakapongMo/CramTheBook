package com.jakapong.gdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
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
	public static final int BLOCK_SIZE = 40;
	public static final int PLAYER_SIZE = 80;
	private BitmapFont font;
	private BitmapFont time;
	public static int checksec = 0;
    public static int sec = 0;
    public static boolean checkroundsec = false;
	
	private MapRenderer mapRenderer;
	
	public WorldRenderer(CramTheBookGame cramTheBookGame, World world){
		this.cramTheBookGame = cramTheBookGame;
		batch = cramTheBookGame.batch;
		this.world = world;
		playerImg = new Texture("boy.png");
		obstacleImg = new Texture("obstacle-1.png");
		//bgImg = new Texture("backgroud-2.jpg");
		font = new BitmapFont();
		time = new BitmapFont();
		
		mapRenderer = new MapRenderer(cramTheBookGame.batch, world.getMapWorld());
		
	}
	@Override
	public void render(float delta){
		checksec++;
		if(checksec == 90) {
       		sec++;
       		checksec = 0;
       		checkroundsec = true;
       	}
       	if(sec == 61) {
       		
       		sec =0;
       	}
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
		if (sec%1 == 0 && checkroundsec == true) {
			font.draw(batch, "TIME: " + sec, 1000, 870);
		}
		
		font.draw(batch, "SCORE: " + world.getScore(), 1000, 850);
		batch.end();
		
	}
}