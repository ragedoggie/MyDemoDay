package com.misisonbit.Character;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.misisonbit.Sprites.Animations;


public class Tree extends Organisms{

    Texture texture;
    Rectangle bounds;
    Animations treeAnim;
    Vector3 position;

    Grass grass;


    Sprite sprite;


    public Tree(float x , float y){
        super(x,y);



        position = new Vector3(x, y,0);
        texture = new Texture("tree.png");
        treeAnim = new Animations(new TextureRegion(texture), 4, 0.5f,2,2);
        bounds = new Rectangle(position.x,position.y,treeAnim.getFrame().getRegionWidth(),treeAnim.getFrame().getRegionHeight());
        sprite = new Sprite(texture);

    }

    public Rectangle getBounds() {
        return bounds;
    }

    public TextureRegion getTexture() {
        return treeAnim.getFrame();
    }

    public void update(float dt) {
        treeAnim.update(dt);

    }


    public Sprite getSprite() {
        return sprite;
    }


    public void dispose () {
        texture.dispose();
    }
}




