package com.missionbit;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.missionbit.Character.Grasshopper;
import com.missionbit.Character.Rabbit;

import java.util.Random;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	com.missionbit.Character.Sun sun;
	Array<com.missionbit.Character.Sun> sunArray;
	int numSuns;
	Array<com.missionbit.Character.Grass> grassArray;
	com.missionbit.Character.Grass grass;
	Rabbit rabbit;
	Grasshopper grasshopper;
	com.missionbit.Character.Wolf wolf;
	private Music music;

	public void create () {
		batch = new SpriteBatch();
		music = Gdx.audio.newMusic(Gdx.files.internal("vsgame_0/Forest_Ambience.mp3"));
        music.setLooping(true); 
        music.setVolume(1f);
        music.play();
		sun = new com.missionbit.Character.Sun(50,50);
		grass = new com.missionbit.Character.Grass(100,100);
		rabbit = new Rabbit(150,200);
		grasshopper = new Grasshopper(500, 250);
		wolf = new com.missionbit.Character.Wolf(1000, 1000);
		sunArray = new Array<com.missionbit.Character.Sun>();
		grassArray = new Array<com.missionbit.Character.Grass>();
		numSuns = 10;

		


		Random rng = new Random();


		for (int a = 0; a < numSuns; a++){
			sunArray.add(new com.missionbit.Character.Sun(rng.nextInt(Gdx.graphics.getWidth()),rng.nextInt(Gdx.graphics.getHeight())));

		}

	}

	public void render () {
		Gdx.gl.glClearColor(140/255f, 193/255f, 48/255f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		sun.update(Gdx.graphics.getDeltaTime());
		grass.update(Gdx.graphics.getDeltaTime());
		rabbit.update(Gdx.graphics.getDeltaTime());
		grasshopper.update(Gdx.graphics.getDeltaTime());
		wolf.update(Gdx.graphics.getDeltaTime());

		for (int i = 0; i < numSuns; i++) {
			sunArray.get(i).update(Gdx.graphics.getDeltaTime());
		}

		batch.begin();
		batch.draw(grass.getTexture(),grass.getPosition().x,grass.getPosition().y);
		batch.draw(rabbit.getTexture(),rabbit.getPosition().x, rabbit.getPosition().y);
		batch.draw(sun.getTexture(),sun.getPosition().x,sun.getPosition().y);
		batch.draw(grasshopper.getTexture(), grasshopper.getPosition().x, grasshopper.getPosition().y);
		batch.draw(wolf.getTexture(), wolf.getPosition().x, wolf.getPosition().y);
		batch.end();
	}
	public void dispose () {
		batch.dispose();
		music.dispose();

		for (int p = 0; p < numSuns;p++) {
			sunArray.get(p).dispose();
        }
	}
}