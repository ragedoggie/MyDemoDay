package com.misisonbit;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;

import com.misisonbit.states.MenuState;



public class MyGdxGame extends Game {

	public static int width = 800;
	public static int height = 480;


	
	@Override
	public void create () {

		Gdx.gl.glClearColor(114/255f, 175/255f, 56/255f, 1);
		this.setScreen(new MenuState(this));

	}



	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		super.render();
	}

	@Override
	public void dispose () {
		this.screen.dispose();
		}
}




