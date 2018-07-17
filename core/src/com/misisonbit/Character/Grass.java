package com.misisonbit.Character;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.misisonbit.MyGdxGame;
import com.misisonbit.Sprites.Animations;

public class Grass extends Organisms {

    static final int GRAVITY = 0;
    static final int MOVEMENT = 100;
    Vector3 position;
    Rectangle bounds;
    Animations grassAnim;
    Texture sprite;


    //Sound ray;


    public Grass(int x, int y){
        position = new Vector3(x, y, 0);
        sprite = new Texture("Grass.png");
        bounds = new Rectangle(x, y, sprite.getWidth() / 3, sprite.getHeight() / 3);
        grassAnim = new Animations(new TextureRegion(sprite), 10, 0.8f,10,1);

        //ray = Gdx.audio.newSound(Gdx.files.internal("sfx_wing.ogg"));

    }


    public void update(float dt){
        grassAnim.update(dt);

    }



    public Vector3 getPosition() {
        return position;
    }

    public TextureRegion getTexture() {
        return grassAnim.getFrame();
    }



    public Rectangle getBounds() {
        return bounds;
    }

    public void dispose() {
        sprite.dispose();
    }
}

