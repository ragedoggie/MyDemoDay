package com.misisonbit.Character;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.misisonbit.Sprites.Animations;

import java.util.Random;

import static com.badlogic.gdx.math.MathUtils.random;

import static com.misisonbit.states.GameState.LVpoints;


public class Grasshopper extends Organisms{
    Vector2 position;
    Rectangle bounds;
    Circle range;
    Sprite grasshopperSprite;
    Animations grasshopperAnim;
    Animations rabbitAnim2;
    Animations grassAnim2;
    Texture texture;
    Texture texture2;

    Vector2 target;
 //   Random rng;

    Organisms player;


    public Grasshopper(float x, float y, Organisms p){
        super(x,y);

        player = p;

        position = new Vector2(x, y);
        texture = new Texture("grasshopper2.png");
        grasshopperAnim = new Animations(new TextureRegion(texture), 3, 0.5f,3,1);
        bounds = new Rectangle(position.x, position.y, grasshopperAnim.getFrame().getRegionWidth(), grasshopperAnim.getFrame().getRegionHeight());
        range = new Circle(position.x+bounds.getWidth()/2,position.y+bounds.getHeight()/2,150);

    //    rng = new Random();

    //    target = new Vector2(rng.nextInt(Gdx.graphics.getWidth()),rng.nextInt(Gdx.graphics.getHeight()));


    }

    public void update(float dt){
        grasshopperAnim.update(dt);
        //moveBoi();


    }

    public Vector2 getPosition(){
        return position;
    }

    public TextureRegion getTexture() {
        return grasshopperAnim.getFrame();
    }

    public Rectangle getBounds() {
        return bounds;
    }

//    public void moveBoi(){

//        if(!range.contains(player.getPosition())) {
//            if (bounds.contains(target)) {
//                target.set(rng.nextInt(Gdx.graphics.getWidth()), rng.nextInt(Gdx.graphics.getHeight()));
//            } else {
//                if (position.x < target.x) {
//                    position.x += 1.2;
//                } else {
//                    position.x -= 1.2;
//                }
//
//                if (position.y < target.y) {
//                    position.y += 1.2;
//                } else {
//                    position.x -= 1.2;
//                }
//            }
//        }
//
//    }


    public Circle getRange() {
        return range;
    }



    public void dispose() {
        texture.dispose();
    }
}