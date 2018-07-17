package com.misisonbit.Character;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.misisonbit.MyGdxGame;

public class Organisms {
    int speed;
    int health;
    int points;
    //Gdx.input.setInputProcessor(inputProcessor);
    int moveSpeed;
    int objWidth;
    int objHeight;
    protected Vector2 position;
    //protected Vector2 velocity;
    public static boolean upPressed, downPressed, leftPressed, rightPressed = false;



    public Organisms(float x, float y) {

        position = new Vector2(x,y);

        //velocity = new Vector2(10, 10);

    }


    public void update(float dt) {

      }

    public Vector2 getPosition() {
        return position;
    }

    public void setPosition(Vector2 position) {
        this.position = position;
    }
}

