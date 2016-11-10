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
    public static int checkmove = 0;
    public static int move = 0;
    public static boolean checkroundmove = false;
    public static int checksec = 0;
    public static int sec = 0;
    public static boolean checkroundsec = false;
    
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
       	updateScore();
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
       	if(checksec == 50) {
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
    
    private void updateObstacleDirection(){
    	if(move%1 == 0 && checkroundmove == true){
//    	obstacle.setNextDirection(obstacle.CHECK_EDGE%4+1);
    		obstacle.setNextDirection(MathUtils.random(1, 4));
    		checkroundmove = false;
    	}
    }
    
    public boolean isStill(){
		return (!(Gdx.input.isKeyPressed(Keys.UP)) && !(Gdx.input.isKeyPressed(Keys.RIGHT)) && 
				!(Gdx.input.isKeyPressed(Keys.DOWN))&&!(Gdx.input.isKeyPressed(Keys.LEFT)) );
	}
}
