package com.misisonbit.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.misisonbit.Character.Grass;
import com.misisonbit.MyGdxGame;

public class MenuState extends State {
    Texture screen;
    Grass grass;


    public MenuState(MyGdxGame game) {
        super(game);
        screen = new Texture("fish.jpg");
        grass = new Grass(10, 10);
    }

    public void drawGame() {
        batch.begin();
        batch.draw(screen,0,-30, Gdx.graphics.getWidth() + 200,Gdx.graphics.getHeight() + 30);
        font.draw(batch,this.getClass().toString(),100,100);
        font.getData().setScale(2,2);
        font.setColor(Color.GOLDENROD);
        font.draw(batch,"Menustate",Gdx.graphics.getWidth()/2,Gdx.graphics.getHeight()/2);
        batch.end();
    }

    public void update(float dt) {
        handleInput();

//        Gdx.gl.glClearColor(1,0,1,1);

    }

    private void handleInput(){
        if(Gdx.input.justTouched()){
            dispose();
            game.setScreen(new GameState(game));

            }

    }

}

