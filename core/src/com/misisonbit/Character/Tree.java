package com.misisonbit.Character;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector3;
import com.misisonbit.Sprites.Animations;
import com.badlogic.gdx.math.Rectangle;



public class Tree extends Organisms{

    Texture texture;
    Rectangle bounds;
    Animations treeAnim;
    Vector3 position;



    public Tree(float x , float y){
        super(x,y);
        position = new Vector3(x, y,0);
        texture = new Texture("tree.png");
        treeAnim = new Animations(new TextureRegion(texture), 4, 0.5f,2,2);
        bounds = new Rectangle(x, y, treeAnim.getFrame().getRegionWidth(), treeAnim.getFrame().getRegionHeight());

    }

    public TextureRegion getTexture() {
        return treeAnim.getFrame();
    }

    public void update(float dt) {
        treeAnim.update(dt);

    }

    public Rectangle getBounds() {
        return bounds;
    }


    public void dispose () {
        texture.dispose();
    }
}




