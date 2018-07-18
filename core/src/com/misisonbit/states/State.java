package com.misisonbit.states;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.misisonbit.MyGdxGame;

import java.util.Random;

public abstract class State implements Screen{
    final MyGdxGame game;
    public OrthographicCamera camera;
    SpriteBatch batch;
    BitmapFont font;
    Random random;

    State(MyGdxGame game){
        this.game = game;
        camera = new OrthographicCamera();
        batch = new SpriteBatch();
        camera.setToOrtho(false, MyGdxGame.width,MyGdxGame.height );
        font = new BitmapFont();
        font.setColor(Color.WHITE);

        random = new Random();
    }

    abstract void update(float dt);
    abstract void drawGame();

    public void show() {
    }
    public void render(float delta) {
        camera.update();
        batch.setProjectionMatrix(camera.combined);
        update(delta);
        drawGame();
    }
    public void resize(int width, int height) {
    }
    public void pause() {
    }
    public void resume() {
    }
    public void hide() {
    }
    public void dispose() {
    font.dispose();
    }
}
