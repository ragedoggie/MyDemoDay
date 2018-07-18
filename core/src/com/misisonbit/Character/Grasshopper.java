package com.misisonbit.Character;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.misisonbit.Sprites.Animations;

public class Grasshopper {
    Vector3 position;
    Rectangle bounds;
    Animations grasshopperAnim;
    Texture texture;

    public Grasshopper(int x, int y){

        position = new Vector3(x, y, 0);
        texture = new Texture("grasshopper.png");
        bounds = new Rectangle(x, y, texture.getWidth(), texture.getHeight());
        grasshopperAnim = new Animations(new TextureRegion(texture), 4, 0.5f,2,2);
    }

    public void update(float dt){
        grasshopperAnim.update(dt);
    }
    public Vector3 getPosition(){
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