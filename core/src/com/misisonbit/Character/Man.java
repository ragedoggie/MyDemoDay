package com.misisonbit.Character;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.misisonbit.Sprites.Animations;

public class Man extends Organisms {

    static final int GRAVITY = 0;
    static final int MOVEMENT = 100;
    Vector3 position;
    Rectangle bounds;
    Animations manAnim;
    Texture texture;

    //Sound ray;



    public Man(int x, int y){

        position = new Vector3(x, y, 0);
        texture = new Texture("Man.png");
        bounds = new Rectangle(x, y, texture.getWidth() / 3, texture.getHeight() / 3);
        manAnim = new Animations(new TextureRegion(texture), 3, 0.5f,3,3);

        //ray = Gdx.audio.newSound(Gdx.files.internal("sfx_wing.ogg"));

    }

    public void update(float dt){
        manAnim.update(dt);


    }


    public Vector3 getPosition() {
        return position;
    }

    public TextureRegion getTexture() {
        return manAnim.getFrame();
    }



    public Rectangle getBounds() {
        return bounds;
    }

    public void dispose() {
        texture.dispose();
        //flap.dispose();
    }
}
