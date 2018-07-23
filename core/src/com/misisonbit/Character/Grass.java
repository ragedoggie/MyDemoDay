package com.misisonbit.Character;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.misisonbit.Sprites.Animations;

import static com.badlogic.gdx.scenes.scene2d.InputEvent.Type.keyDown;

public class Grass extends Organisms {


    Rectangle bounds;
    Animations grassAnim;
    Texture sprite;
    private static boolean upPressed, downPressed, leftPressed, rightPressed = false;

    public Grass(float x, float y){
        super(x,y);
        sprite = new Texture("grass2.png");
        grassAnim = new Animations(new TextureRegion(sprite), 3, 0.8f,2,2);
        bounds = new Rectangle(x, y, grassAnim.getFrame().getRegionWidth(), grassAnim.getFrame().getRegionHeight());
    }

    public boolean keyDown(int keycode) {
        if(keycode == Input.Keys.UP){
            upPressed = true;
        }

        return true;
    }
    public boolean keyUp(int keycode) {
        if(keycode == Input.Keys.UP){
            upPressed = false;
        }
        return true;
    }

    public void update(float dt){
        super.update(dt);
        grassAnim.update(dt);
        bounds.setPosition(position.x, position.y);
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