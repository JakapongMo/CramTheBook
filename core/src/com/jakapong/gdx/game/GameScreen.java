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
    
    private int x;
    private int y;
    World world;
    WorldRenderer worldRenderer;
    
    public GameScreen(CramTheBookGame cramTheBookGame) {
        this.cramTheBookGame = cramTheBookGame;
        world = new World(cramTheBookGame);
        player = world.getPlayer();   
        obstacle = world.getObstacle();
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
       	world.update(delta);
    	
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
    
    private void updateObstacleDirection(){
    	/*int  ran = MathUtils.random(0,100)
       	if (ran <25) {
       		obstacle.setNextDirection(obstacle.DIRECTION_UP);
       		//ran1();
       	} else if (ran<50) {
       		obstacle.setNextDirection(obstacle.DIRECTION_RIGHT);
       		//ran1();
       	} else if (ran<75) {
       		obstacle.setNextDirection(obstacle.DIRECTION_LEFT);
       		//ran1();
       	} else if (ran<101) {
       		obstacle.setNextDirection(obstacle.DIRECTION_DOWN);
       		//ran1();
       	}*/
    	float delay = 1; // seconds
    	Timer.schedule(new Task(){
    	    @Override
    	    public void run() {
    	        // Do your work
    	    }
    	}, delay);
    		obstacle.setNextDirection(obstacle.CHECK_EDGE%4+1);
    }
    private void delay5(){
    	Timer.schedule(new Task() {
    		//@Override
        	public void run() {
        	}
        }, 5);
    }
    public boolean isStill(){
		return (!(Gdx.input.isKeyPressed(Keys.UP)) && !(Gdx.input.isKeyPressed(Keys.RIGHT)) && 
				!(Gdx.input.isKeyPressed(Keys.DOWN))&&!(Gdx.input.isKeyPressed(Keys.LEFT)) );
	}
}
