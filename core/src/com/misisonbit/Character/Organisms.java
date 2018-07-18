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
    protected Vector3 position;
    protected Vector3 velocity;
    public static boolean upPressed, downPressed, leftPressed, rightPressed = false;


    public Organisms() {
        velocity = new Vector3(10, 10, 0);

    }


    public void update(float dt) {
     //   if (MyGdxGame.isUpPressed()) {
     //       position.add(0, velocity.y);
//        }
       // }
      }

    public Vector3 getPosition() {
        return position;
    }

    public void setPosition(Vector3 position) {
        this.position = position;
    }
}

