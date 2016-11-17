package com.jakapong.gdx.game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.Timer.Task;
public class GameScreen extends ScreenAdapter{

    private CramTheBookGame cramTheBookGame;
    private Player player;
    private Obstacle obstacle;
    private Enemy enemy1;
    private Enemy enemy2;
    private Enemy enemy3;
    public static int checkmove = 0;
    public static int move = 0;
    public static boolean checkroundmove = false;
    public static int checksec = 0;
    public static int sec = 0;
    public static boolean checkroundsec = false;
    public static boolean checkDead = false;
    
    private int x;
    private int y;
    World world;
    WorldRenderer worldRenderer;
    
    public GameScreen(CramTheBookGame cramTheBookGame) {
        this.cramTheBookGame = cramTheBookGame;
        world = new World(cramTheBookGame);
        player = world.getPlayer();   
        obstacle = world.getObstacle();
        enemy1 = world.getEnemy1();
        enemy2 = world.getEnemy2();
        enemy3 = world.getEnemy3();
        worldRenderer = new WorldRenderer(cramTheBookGame, world);
    }
    
    @Override
    public void render (float delta) {
    	update(delta);
    	Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        worldRenderer.render(delta);
    }

    private void update(float delta){
    	updatePlayerDirection(); 	
       	updateObstacleDirection();
       	updateScore();
       	updateEnermy1Direction();
       	updateEnermy2Direction();
       	updateEnermy3Direction();
       	updateLifePoint();
       	world.update(delta);
       	checkmove++;
       	checksec++;
       	if(checkmove == 40) {
       		move++;
       		checkmove = 0;
       		checkroundmove = true;
       	}
       	if(move == 61) {
       		move =0;
       	}
       	if(checksec == 60) {
       		sec++;
       		checksec = 0;
       		checkroundsec = true;
       	}
       	if(sec == 61) {
       		
       		sec =0;
       	}
    }
    private void updatePlayerDirection() {
    	if (Gdx.input.isKeyPressed(Keys.UP)) {
    		player.setNextDirection(player.DIRECTION_UP);
       	}
    	if (Gdx.input.isKeyPressed(Keys.RIGHT)){
    		player.setNextDirection(player.DIRECTION_RIGHT);
    		//obstacle.move(obstacle.DIRECTION_RIGHT);
       	}
    	if (Gdx.input.isKeyPressed(Keys.LEFT)) {
    		player.setNextDirection(player.DIRECTION_LEFT);
       	}
       	if (Gdx.input.isKeyPressed(Keys.DOWN)) {
       		player.setNextDirection(player.DIRECTION_DOWN);
       	}
       	if(this.isStill()){
			player.setNextDirection(player.DIRECTION_STILL);
		}
    }
    
    private void updateScore(){
    	Vector2 posPlayer = player.getPosition();
    	Vector2 posObstacle = obstacle.getPosition();
    	
    	if (Gdx.input.isKeyPressed(Keys.SPACE) && ((posPlayer.x > posObstacle.x-100 && posPlayer.x < posObstacle.x+100) && (posPlayer.y > posObstacle.y-100 && posPlayer.y < posObstacle.y+100))) {
    		if(sec%1 == 0 && checkroundsec == true){
    				world.increaseScore();
    	    		checkroundsec = false;
    	    	}	
    	}
    }
    
    private void updateLifePoint(){
    	Vector2 posPlayer = player.getPosition();
    	Vector2 posEnemy1 = enemy1.getPosition();
    	Vector2 posEnemy2 = enemy2.getPosition();
    	Vector2 posEnemy3 = enemy3.getPosition();
    	update_Dead();
    	
    	is_Touching(posPlayer.x, posPlayer.y,posEnemy1.x, posEnemy1.y);
    	is_Touching(posPlayer.x, posPlayer.y,posEnemy2.x, posEnemy2.y);
    	is_Touching(posPlayer.x, posPlayer.y,posEnemy3.x, posEnemy3.y);
  
//    	if ((posPlayer.x > posEnemy2.x-100 && posPlayer.x < posEnemy2.x+100) && (posPlayer.y > posEnemy2.y-100 && posPlayer.y < posEnemy2.y+100)) {
//    		if(sec%2 == 0 && checkroundsec == true){
//    				world.decreaseScore();
//    	    		checkroundsec = false;
//    	
//    	    	}	
//    	}
//    	
//    	if ((posPlayer.x > posEnemy3.x-100 && posPlayer.x < posEnemy3.x+100) && (posPlayer.y > posEnemy3.y-100 && posPlayer.y < posEnemy3.y+100)) {
//    		if(sec%2 == 0 && checkroundsec == true){
//    				world.decreaseScore();
//    	    		checkroundsec = false;
//    	
//    	    	}	
//    	}
    }
    
    public  void is_Touching(float posPlayer_x, float posPlayer_y, float posEnemy_x, float posEnemy_y) {
    	if ((posPlayer_x > posEnemy_x-100 && posPlayer_x < posEnemy_x+100) && (posPlayer_y > posEnemy_y-100 && posPlayer_y < posEnemy_y+100)) {
    		if(sec%2 == 0 && checkroundsec == true){
    				world.decreaseScore();
    	    		checkroundsec = false;
    	
    	    	}	
    	}
    }
    
    private void updateObstacleDirection(){
    	if(move%1 == 0 && checkroundmove == true){
//    	obstacle.setNextDirection(obstacle.CHECK_EDGE%4+1);
    		obstacle.setNextDirection(MathUtils.random(1, 4));
    		checkroundmove = false;
    	}
    }
    
    private void updateEnermy1Direction() {
    	enemy1.move(enemy1.DIRECTION_LEFT);
    	Vector2 posEnemy1 = enemy1.getPosition();
    	if(posEnemy1.x < -100) {
    		enemy1.setPosition(MathUtils.random(MathUtils.random(1400, 1500)),MathUtils.random(60, 800));
    	}
    	increaseSpeedEnemy(enemy1);
    		
    }
    
    private void updateEnermy2Direction() {
		enemy2.move(enemy2.DIRECTION_RIGHT);
		Vector2 posEnemy2 = enemy2.getPosition();
		if(posEnemy2.x > 1500) {
			enemy2.setPosition(-600,MathUtils.random(60, 800));
		}
		increaseSpeedEnemy(enemy2);
		
    }
    
    private void updateEnermy3Direction() {
		enemy3.move(enemy3.DIRECTION_LEFT);
		Vector2 posEnemy3 = enemy3.getPosition();
		if(posEnemy3.x < -100) {
			enemy3.setPosition(MathUtils.random(1400, 1500),MathUtils.random(60, 800));
		}
		increaseSpeedEnemy(enemy3);
		
	}
    
    public void update_Dead(){
    	if(world.getLifePoint() <= 0) {
    		checkDead = true;
     	}
    }
    
    public void increaseSpeedEnemy(Enemy enemy) {
    	if(world.getScore() > 10 && world.getScore() < 20) {
			enemy.SPEED = 10;
		}
		
    	else if(world.getScore() > 20 && world.getScore() < 30) {
			enemy.SPEED = 15;
		}
		
    	else if(world.getScore() > 30 && world.getScore() < 40) {
			enemy.SPEED = 17;
		}
    	
    	else if(world.getScore() > 40) {
			enemy.SPEED = 20;
		}
		
		
    }
    public boolean isStill(){
		return (!(Gdx.input.isKeyPressed(Keys.UP)) && !(Gdx.input.isKeyPressed(Keys.RIGHT)) && 
				!(Gdx.input.isKeyPressed(Keys.DOWN))&&!(Gdx.input.isKeyPressed(Keys.LEFT)) );
	}
}
