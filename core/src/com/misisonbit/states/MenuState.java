package com.misisonbit.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.misisonbit.Character.Grass;
import com.misisonbit.MyGdxGame;

import javax.xml.soap.Text;

public class MenuState extends State {
    private Texture screen;
    Grass grass;


    public MenuState(MyGdxGame game) {
        super(game);
        //screen = new Texture("fish.jpg");
        grass = new Grass(10, 10);

    }

    public void drawGame() {
        batch.begin();
        //font.draw(batch,this.getClass().toString(),100,100);
        font.getData().setScale(5,5);
        font.draw(batch,"Tap to start",Gdx.graphics.getWidth()/3,Gdx.graphics.getBackBufferHeight()/3);

        batch.end();
    }

    public void update(float dt) {
        handleInput();
        //grass.update(dt);

//        Gdx.gl.glClearColor(1,0,1,1);

    }

    public boolean handleInput(){
        if(Gdx.input.justTouched()){
            dispose();
            game.setScreen(new GameState(game));
            return true;
            }
            return false;
    }

}

