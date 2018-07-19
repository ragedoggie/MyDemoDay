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
        Vector2 position;
        Rectangle bounds;
        Animations rabbitAnim;
        Texture texture;

    public Rabbit(float x, float y){
        super(x,y);
        position = new Vector2(x, y);
        texture = new Texture("Rabbit.png");
        bounds = new Rectangle(x, y, texture.getWidth() / 3, texture.getHeight() / 3);
        rabbitAnim = new Animations(new TextureRegion(texture), 2, .3f,2,2);
    }

    public void update(float dt){
        rabbitAnim.update(dt);
    }

    public Vector2 getPosition(){
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
