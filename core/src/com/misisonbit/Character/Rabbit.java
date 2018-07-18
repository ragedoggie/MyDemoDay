package com.misisonbit.Character;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.misisonbit.Character.Organisms;
import com.misisonbit.MyGdxGame;
import com.misisonbit.Sprites.Animations;

    public class Rabbit extends Organisms {
        static final int GRAVITY = 0;
        static final int MOVEMENT = 100;
        Vector3 position;
        Rectangle bounds;
        Animations rabbitAnim;
        Texture texture;

    public Rabbit(int x, int y){
        position = new Vector3(x, y, 0);
        texture = new Texture("Rabbit.png");
        bounds = new Rectangle(x, y, texture.getWidth() / 3, texture.getHeight() / 3);
        rabbitAnim = new Animations(new TextureRegion(texture), 4, 0.5f,2,2);

        //ray = Gdx.audio.newSound(Gdx.files.internal("sfx_wing.ogg"));

    }

    public void update(float dt){
        rabbitAnim.update(dt);
    }
    public Vector3 getPosition(){
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