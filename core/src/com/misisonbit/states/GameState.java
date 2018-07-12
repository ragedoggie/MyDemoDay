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
        sun = new Sun(100 , 100);
        numSun = 30;

        ranNumx = new Array<Integer>();
        ranNumY = new Array<Integer>();

        random = new Random();

        for(int i = 0;i<numSun;i++){
            ranNumx.add(ranIntx = random.nextInt(Gdx.graphics.getWidth()));
            ranNumY.add(ranIntx = random.nextInt(Gdx.graphics.getHeight()));
        }

    }

    public void drawGame() {
        batch.begin();
        font.draw(batch,this.getClass().toString(),0,10);

        for(int i = 0;i<numSun;i++) {
            batch.draw(sun.getTexture(),ranNumx.get(i),ranNumY.get(i));
        }

        batch.end();
    }

    public void update(float dt) {
        sun.update(Gdx.graphics.getDeltaTime());
    }

}
