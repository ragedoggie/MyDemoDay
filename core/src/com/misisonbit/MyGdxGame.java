package com.misisonbit;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.misisonbit.Character.Grass;
import com.misisonbit.Character.Sun;
import com.misisonbit.states.MenuState;

import java.util.Random;

public class MyGdxGame extends Game {
	public static int width = 800;
	public static int height = 480;


	
	@Override
	public void create () {
		Gdx.gl.glClearColor(140/255f, 193/255f, 48/255f, 1);
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




