package com.jakapong.gdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.jakapong.gdx.game.CramTheBookGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width=CramTheBookGame.WIDTH;
		config.height=CramTheBookGame.HEIGHT;
		config.foregroundFPS = 60;
		new LwjglApplication(new CramTheBookGame(), config);
	}
}
