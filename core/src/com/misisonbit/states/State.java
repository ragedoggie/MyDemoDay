package com.misisonbit.states;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.misisonbit.MyGdxGame;

public abstract class State implements Screen{
    final MyGdxGame game;
    public OrthographicCamera camera;
    SpriteBatch batch;

    BitmapFont font;

    State(MyGdxGame game){
        //game declared on top = game that this method take in
        this.game = game;
        camera = new OrthographicCamera();
        batch = new SpriteBatch();
        camera.setToOrtho(false, MyGdxGame.width,MyGdxGame.height );
        font = new BitmapFont();
        font.setColor(Color.WHITE);

    }

    abstract void update(float dt);
    abstract void drawGame();


    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        camera.update();
        batch.setProjectionMatrix(camera.combined);
        update(delta);
        drawGame();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
    font.dispose();
    }
}
