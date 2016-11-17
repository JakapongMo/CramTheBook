package com.jakapong.gdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.Timer.Task;

public class WorldRenderer extends ScreenAdapter{

	CramTheBookGame cramTheBookGame;
	World world;
	SpriteBatch batch;
	Texture playerImg;
	Texture enemy1Img;
	Texture enemy2Img;
	Texture enemy3Img;
	Texture obstacleImg;
	Texture GAMEOVERImg;
	//Texture bgImg;
	Player player;
	Obstacle obstacle;
	Enemy enemy1;
	Enemy enemy2;
	Enemy enemy3;
	public static final int BLOCK_SIZE = 40;
	public static final int PLAYER_SIZE = 80;
	private BitmapFont font;
	private BitmapFont time;
	public static int checksec = 0;
    public static int sec = 0;
    public static int min =0;
    
    public static boolean checkroundsec = false;
	
	private MapRenderer mapRenderer;
	
	public WorldRenderer(CramTheBookGame cramTheBookGame, World world){
		this.cramTheBookGame = cramTheBookGame;
		batch = cramTheBookGame.batch;
		this.world = world;
		playerImg = new Texture("boy.png");
		obstacleImg = new Texture("book.png");
		enemy1Img = new Texture("LINE.png");
		enemy2Img = new Texture("LINE.png");
		enemy3Img = new Texture("twitter.png");
		GAMEOVERImg = new Texture("gameover.jpg");
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
       	if(sec == 60) {
       		
       		sec = 0;
       		min++;
       	}
		mapRenderer.render();
		player = world.getPlayer();
		obstacle = world.getObstacle();
		enemy1 = world.getEnemy1();
		enemy2 = world.getEnemy2();
		enemy3 = world.getEnemy3();
		SpriteBatch batch = cramTheBookGame.batch;
		Vector2 posPlayer = player.getPosition();
		Vector2 posObstacle = obstacle.getPosition();
		Vector2 posEnemy1 = enemy1.getPosition();
		Vector2 posEnemy2 = enemy2.getPosition();
		Vector2 posEnemy3 = enemy3.getPosition();
		batch.begin();
		
		//batch.draw(bgImg,0,0);
		batch.draw(obstacleImg,posObstacle.x,posObstacle.y);
		batch.draw(enemy1Img,posEnemy1.x,posEnemy1.y);
		batch.draw(enemy2Img,posEnemy2.x,posEnemy2.y);
		batch.draw(enemy3Img,posEnemy3.x,posEnemy3.y);
		batch.draw(playerImg,posPlayer.x,posPlayer.y);
		drawTime();
		
		font.draw(batch, "KNOWLEDGE: " + world.getScore(), 1000, 850);
		font.draw(batch, "LIFEPOINT: " + world.getLifePoint(), 88, 850);
		if (GameScreen.checkDead) {
			batch.draw(GAMEOVERImg,0,0);
		}
		batch.end();
	}
	private void drawTime(){
		if (sec%1 == 0 && checkroundsec == true) {
			font.draw(batch, "TIME: " + min + " : " +sec, 1000, 870);
			checkroundsec = false;
		}
		
	}
}