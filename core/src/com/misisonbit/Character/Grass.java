package com.misisonbit.Character;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.misisonbit.MyGdxGame;
import com.misisonbit.Sprites.Animations;

import static com.badlogic.gdx.scenes.scene2d.InputEvent.Type.keyDown;

public class Grass extends Organisms {

    static final int GRAVITY = 0;
    static final int MOVEMENT = 100;
    Rectangle bounds;
    Animations grassAnim;
    Texture sprite;
    private static boolean upPressed, downPressed, leftPressed, rightPressed = false;

    //Sound ray;


    public Grass(float x, float y){
        position = new Vector2(x, y);
        sprite = new Texture("Grass2.png");

        grassAnim = new Animations(new TextureRegion(sprite), 3, 0.4f,2,2);
        bounds = new Rectangle(position.x, position.y, grassAnim.getFrame().getRegionWidth(), grassAnim.getFrame().getRegionHeight() );
        //ray = Gdx.audio.newSound(Gdx.files.internal("sfx_wing.ogg"));

    }



    public void update(float dt){
        grassAnim.update(dt);


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

