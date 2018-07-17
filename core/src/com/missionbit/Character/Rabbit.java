package com.missionbit.Character;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.missionbit.Sprites.Animations;

public class Rabbit extends com.missionbit.Character.Organisms {

    static final int GRAVITY = 0;
    static final int MOVEMENT = 100;
    Vector3 position;
    Rectangle bounds;
    Animations rabbitAnim;
    Texture texture;
    Sound sound;
    private OrthographicCamera cam;



    public Rabbit(int x, int y){

        position = new Vector3(x, y, 0);
        texture = new Texture("Rabbit.png");
        bounds = new Rectangle(x, y, texture.getWidth() / 3, texture.getHeight() / 3);
        rabbitAnim = new Animations(new TextureRegion(texture), 4, 0.5f,2,2);
        sound = Gdx.audio.newSound(Gdx.files.internal("vsgame_0/jump_02.wav"));
        cam = new OrthographicCamera();
        cam.setToOrtho(false, 800, 480);


    }
    private void handleInput(){
        if(Gdx.input.justTouched()){
            Vector3 touch = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);
            cam.unproject(touch);
            System.out.println(touch.x);
            System.out.println(touch.y);
            if(getBounds().contains(touch.x, touch.y)){
                sound.play(0.2f);
            }
        }
    }

    public void update(float dt){
        handleInput();
        rabbitAnim.update(dt);
    }

    public Vector3 getPosition() {
        return position;
    }

    public TextureRegion getTexture() {
        return rabbitAnim.getFrame();
    }



    public Rectangle getBounds() {
        return bounds;
    }

    public void dispose() {
        texture.dispose();
    }
}


