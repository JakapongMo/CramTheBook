package com.jakapong.gdx.game;

public class World {
	private CramTheBookGame cramTheBookGame;
	private Player player;
	
	World(CramTheBookGame cramTheBookGame){
		this.cramTheBookGame =cramTheBookGame;
		
		player = new Player(100,100);
	}
	Player getPlayer(){
		return player;
	}
	public static int GetRandom(int number)
	{
		int ran=(int)(Math.random()*number)+0;
		return ran;
	}
}