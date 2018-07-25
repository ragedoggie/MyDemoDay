package com.misisonbit.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.misisonbit.Character.Grass;
import com.misisonbit.MyGdxGame;

public class MenuState extends State {
    ParticleEffect effect;
    Texture screen;
    Grass grass;
    Sound sound;


    public MenuState(MyGdxGame game) {
        super(game);
        sound = Gdx.audio.newSound(Gdx.files.internal("vsgame_0/steam hisses - Marker #1.wav"));
        effect = new ParticleEffect();
        effect.load(Gdx.files.internal("vsgame_0/Smoke"),Gdx.files.internal("vsgame_0"));
        effect.start();
        sound.play();
        effect.setPosition(460, 240);
        screen = new Texture("fish.jpg");
        grass = new Grass(10, 10);
    }

    public void drawGame() {
        batch.begin();
//        batch.draw(screen,0,-30, Gdx.graphics.getWidth() + 200,Gdx.graphics.getHeight() + 30);
//        font.draw(batch,this.getClass().toString(),100,100);
        font.getData().setScale(2,2);
        font.setColor(Color.GOLDENROD);
//        font.draw(batch,"Menustate",Gdx.graphics.getWidth()/2,Gdx.graphics.getHeight()/2);
        effect.draw(batch);
        batch.end();
    }

    public void update(float dt) {
        handleInput();
        effect.update(dt);

//        Gdx.gl.glClearColor(1,0,1,1);

    }

    private void handleInput(){
        if(Gdx.input.justTouched()){
            dispose();
            game.setScreen(new GameState(game));

            }

    }

}

