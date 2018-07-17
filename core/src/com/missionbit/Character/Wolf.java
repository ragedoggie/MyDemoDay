package com.missionbit.Character;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.missionbit.Sprites.Animations;

public class Wolf extends Organisms {
    Vector3 position;
    Rectangle bounds;
    Animations wolfAnim;
    Texture texture;
    Sound sound;
    private OrthographicCamera cam;


    public Wolf(int x, int y) {

        position = new Vector3(x = 750, y = 200, 0);
        texture = new Texture("Wolf.png");
        bounds = new Rectangle(x, y, texture.getWidth() / 3, texture.getHeight() / 3);
        wolfAnim = new Animations(new TextureRegion(texture), 8, 0.5f, 3, 3);
        sound = Gdx.audio.newSound(Gdx.files.internal("vsgame_0/dog_barking.wav"));
        cam = new OrthographicCamera();
        cam.setToOrtho(false, 900, 480);
    }
    private void handleInput(){
        if(Gdx.input.justTouched()){
            Vector3 touch = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);
            cam.unproject(touch);
            System.out.println(touch.x);
            System.out.println(touch.y);
            if(getBounds().contains(touch.x, touch.y)){
                sound.play(1f);
            }
        }
    }

    public void update(float dt) {
        handleInput();
        wolfAnim.update(dt);

    }


    public Vector3 getPosition() {
        return position;
    }

    public TextureRegion getTexture() {
        return wolfAnim.getFrame();
    }


    public Rectangle getBounds() {
        return bounds;
    }

    public void dispose() {
        texture.dispose();
    }
}