package com.misisonbit;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.misisonbit.Character.Sun;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	Sun sun;

	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
		sun = new Sun(50,50);

	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(140/255f, 193/255f, 48/255f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		sun.update(Gdx.graphics.getDeltaTime());
		batch.begin();
		batch.draw(sun.getTexture(),50,50);
		//batch.draw(img, 0, 0);
		batch.end();

	}

	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}


}
