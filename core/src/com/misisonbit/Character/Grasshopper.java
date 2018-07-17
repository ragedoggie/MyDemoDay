package com.misisonbit.Character;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.misisonbit.Sprites.Animations;

public class Grasshopper {
    static final int GRAVITY = 0;
    static final int MOVEMENT = 100;
    Vector3 position;
    Rectangle bounds;
    Animations grasshopperAnim;
    Texture texture;

    //Sound ray;



    public Grasshopper(int x, int y){

        position = new Vector3(x, y, 0);
        texture = new Texture("grasshopper.png");
        bounds = new Rectangle(x, y, texture.getWidth() / 3, texture.getHeight() / 3);
        grasshopperAnim = new Animations(new TextureRegion(texture), 2, 0.5f,2,2);

        //ray = Gdx.audio.newSound(Gdx.files.internal("sfx_wing.ogg"));

    }

    public void update(float dt){
        grasshopperAnim.update(dt);


    }


    public Vector3 getPosition() {
        return position;
    }

    public TextureRegion getTexture() {
        return grasshopperAnim.getFrame();
    }



    public Rectangle getBounds() {
        return bounds;
    }

    public void dispose() {
        texture.dispose();
    }
}
