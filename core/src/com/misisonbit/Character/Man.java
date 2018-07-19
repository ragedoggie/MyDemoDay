package com.misisonbit.Character;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.misisonbit.Sprites.Animations;

public class Man extends Organisms {
    Vector3 position;
    Rectangle bounds;
    Animations manAnim;
    Texture texture;

    public Man(float x, float y){
        super(x,y);
        position = new Vector3(x, y,0);
        texture = new Texture("man.png");
        bounds = new Rectangle(x, y, texture.getWidth() / 3, texture.getHeight() / 3);
        manAnim = new Animations(new TextureRegion(texture), 3, 0.5f,3,3);
    }

    public void update(float dt){
        manAnim.update(dt);
    }

    public TextureRegion getTexture() {
        return manAnim.getFrame();
    }

    public Rectangle getBounds() {
        return bounds;
    }

    public void dispose() {
        texture.dispose();
    }
}