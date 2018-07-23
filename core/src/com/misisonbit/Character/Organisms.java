package com.misisonbit.Character;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector2;
import com.misisonbit.MyGdxGame;

public class Organisms {
    int speed;
    int health;
    int points;
    //Gdx.input.setInputProcessor(inputProcessor);
    int moveSpeed;
    protected Vector2 position;
    protected Vector2 velocity;
    public boolean isAlive;
   // public static boolean upPressed, downPressed, leftPressed, rightPressed = false;


    public Organisms(float x,float y) {
        velocity = new Vector2();
        position = new Vector2(x, y);
        isAlive =  true;

    }


    public void update(float dt) {


     //   if (MyGdxGame.isUpPressed()) {
     //       position.add(0, velocity.y);
//        }
       // }
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

