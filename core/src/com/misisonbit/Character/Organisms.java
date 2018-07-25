package com.misisonbit.Character;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.misisonbit.MyGdxGame;
import com.misisonbit.Sprites.Animations;

public class Organisms {
    int speed;
    int health;
    int points;
    //Gdx.input.setInputProcessor(inputProcessor);
    int moveSpeed;
    protected Vector2 position;
    protected Vector2 velocity;
    public boolean isAlive;
    ShapeRenderer bounds;
    Vector2 offset;
    Animations currentAnim;
   // public static boolean upPressed, downPressed, leftPressed, rightPressed = false;


    public Organisms(float x,float y) {
        velocity = new Vector2();
        position = new Vector2(x, y);
        isAlive =  true;
        bounds = new ShapeRenderer();
        offset = new Vector2();

    }


    public void update(float dt) {


        //all of the screen boundary
        if (position.x < 0) {
            position.x = 0;
        }

        if (position.x > MyGdxGame.width - offset.x) {
            position.x = MyGdxGame.width - offset.x;
        }
        if (position.y < 0) {
            position.y = 0;
        }
        if (position.y > MyGdxGame.height - offset.y) {
            position.y = MyGdxGame.height - offset.y;
        }


//        if (MyGdxGame.isUpPressed()) {
//            position.add(0, velocity.y);
//        }

        position.add(velocity);
    }

    public Vector2 getPosition() {
        return position;
    }

    public void setPosition(Vector2 position) {
        this.position = position;
    }

    public void setVelocity(float x, float y) {
        velocity.set(x,y);
    }


}

