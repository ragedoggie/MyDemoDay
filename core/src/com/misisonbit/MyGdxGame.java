package com.misisonbit;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.misisonbit.Character.Grass;
import com.misisonbit.Character.Grasshopper;
import com.misisonbit.Character.Man;
import com.misisonbit.Character.Organisms;
import com.misisonbit.Character.Rabbit;
import com.misisonbit.Character.Sun;

import java.awt.event.InputEvent;
import java.awt.event.KeyListener;
import java.awt.im.spi.InputMethod;
import java.util.Random;

public class MyGdxGame extends ApplicationAdapter {
    SpriteBatch batch;
    Texture img;
    Sun sun;
    Array<Sun> sunArray;
    int numSuns;
    Array<Grass> grassArray;
    Grass grass;
    Grasshopper grasshopper;
    Rabbit rabbit;
    Man man;
    private static boolean upPressed, downPressed, leftPressed, rightPressed = false;
    Organisms organisms;


    @Override
    public void create() {
        batch = new SpriteBatch();
        sun = new Sun(50, 50);
        grass = new Grass(100, 100);
        grasshopper = new Grasshopper(200, 200);
        sunArray = new Array<Sun>();
        grassArray = new Array<Grass>();
        rabbit = new Rabbit(300, 300);
        man = new Man(0, 250);
        organisms = new Organisms();
        Gdx.input.setInputProcessor(new InputAdapter() {
            @Override
            public boolean keyDown(int keycode) {
                if(keycode == Input.Keys.UP){
                    upPressed = true;
                }
                return true;
            }

            @Override
            public boolean keyUp(int keycode) {
                if(keycode == Input.Keys.UP){
                    upPressed = false;
                }
                return true;
            }
        });
        numSuns = 10;


        Random rng = new Random();


        for (int a = 0; a < numSuns; a++) {
            sunArray.add(new Sun(rng.nextInt(Gdx.graphics.getWidth()), rng.nextInt(Gdx.graphics.getHeight())));

        }
    }


    @Override
    public void render() {
        Gdx.gl.glClearColor(140 / 255f, 193 / 255f, 48 / 255f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        sun.update(Gdx.graphics.getDeltaTime());
        grass.update(Gdx.graphics.getDeltaTime());
        rabbit.update(Gdx.graphics.getDeltaTime());
        grasshopper.update(Gdx.graphics.getDeltaTime());
        man.update(Gdx.graphics.getDeltaTime());
        organisms.update(Gdx.graphics.getDeltaTime());

        for (int i = 0; i < numSuns; i++) {
            sunArray.get(i).update(Gdx.graphics.getDeltaTime());
        }

        batch.begin();
        batch.draw(grass.getTexture(), 100, 100);
        batch.draw(grasshopper.getTexture(), 100, 100);
        batch.draw(sun.getTexture(), 50, 50);
        batch.draw(rabbit.getTexture(), 300, 300);
        batch.draw(man.getTexture(), 0, 250);
        //batch.draw(img, 0, 0);
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();

        for (int p = 0; p < numSuns; p++) {
            sunArray.get(p).dispose();
        }

    }

    public static boolean isUpPressed() {
        return upPressed;
    }

    public static boolean isDownPressed() {
        return downPressed;
    }

    public boolean isLeftPressed() {
        return leftPressed;
    }

    public boolean isRightPressed() {
        return rightPressed;
    }
}
