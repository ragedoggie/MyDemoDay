package com.missionbit.Character;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.missionbit.Sprites.Animations;

public class Grass extends Organisms {
    Vector3 position;
    Rectangle bounds;
    Animations grassAnim;
    Texture sprite;
    Sound sound;
    private OrthographicCamera cam;


    public Grass(int x, int y){
        position = new Vector3(x, y, 0);
        sprite = new Texture("Grass.png");
        bounds = new Rectangle(x, y, sprite.getWidth() / 1, sprite.getHeight() / 1);
        grassAnim = new Animations(new TextureRegion(sprite), 10, 0.8f,10,1);
        sound = Gdx.audio.newSound(Gdx.files.internal("vsgame_0/short wind sound.wav"));
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
