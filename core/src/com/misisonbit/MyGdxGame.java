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
//	public SpriteBatch batch;
//	Texture img;
//	Sun sun;
//	Array<Sun> sunArray;
//	int numSuns;
//	Array<Grass> grassArray;
//	Grass grass;
	public static int width = 800;
	public static int height = 480;


	
	@Override
	public void create () {
		//batch = new SpriteBatch();
//		sun = new Sun(50,50);
//		grass = new Grass(100,100);
		//sunArray = new Array<Sun>();
		//grassArray = new Array<Grass>();
		Gdx.gl.glClearColor(140/255f, 193/255f, 48/255f, 1);

		//numSuns = 10;


//		Random rng = new Random();


		/*for (int a = 0; a < numSuns; a++){
			sunArray.add(new Sun(rng.nextInt(Gdx.graphics.getWidth()),rng.nextInt(Gdx.graphics.getHeight())));

		}*/

		this.setScreen(new MenuState(this));

	}



	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		super.render();
		//sun.update(Gdx.graphics.getDeltaTime());
		//grass.update(Gdx.graphics.getDeltaTime());

		/*for (int i = 0; i < numSuns; i++) {
			sunArray.get(i).update(Gdx.graphics.getDeltaTime());
		}*/
	}

	@Override
	public void dispose () {
		this.screen.dispose();
//		for (int p = 0; p < numSuns;p++) {
//			sunArray.get(p).dispose();
		}

	}



