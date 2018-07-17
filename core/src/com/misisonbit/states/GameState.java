package com.misisonbit.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Array;
import com.misisonbit.Character.Grass;
import com.misisonbit.Character.Sun;
import com.misisonbit.MyGdxGame;

import java.util.Random;

public class GameState extends State {
    Grass grass;
    Sun sun;

    Random random;
    int ranIntx;
    int ranInty;
    Array<Integer> ranNumx;
    Array<Integer> ranNumY;

    int numSun;


    public GameState(MyGdxGame game) {
        super(game);
        //sun = new Sun(sun.getPosition().x,sun.getPosition().y);
        numSun = 10;
        sun = new Sun(30,30);

        ranNumx = new Array<Integer>();
        ranNumY = new Array<Integer>();

        random = new Random();




    }

    public void drawGame() {
        batch.begin();
        font.draw(batch,this.getClass().toString(),0,10);
        batch.draw(sun.getTexture(),sun.getPosition().x,sun.getPosition().y);


        batch.end();
    }

    public void update(float dt) {
        sun.update(Gdx.graphics.getDeltaTime());
        clickHandler();
    }


    public void clickHandler(){
        if(Gdx.input.justTouched()){
            if(sun.getPosition().x>Gdx.graphics.getWidth()){
               sun.getPosition().x=0;
            }else
            sun.getPosition().x+=100;
        }

        }

    }


