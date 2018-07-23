package com.misisonbit.Character;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.misisonbit.Sprites.Animations;

public class Grasshopper extends Organisms{
    Vector2 position;
    Rectangle bounds;
    Circle range;
    Animations grasshopperAnim;
    Texture texture;



    public Grasshopper(float x, float y){
        super(x,y);
        position = new Vector2(x, y);
        texture = new Texture("grasshopper2.png");
        grasshopperAnim = new Animations(new TextureRegion(texture), 3, 0.5f,3,1);
        bounds = new Rectangle(position.x, position.y, grasshopperAnim.getFrame().getRegionWidth(), grasshopperAnim.getFrame().getRegionHeight());
        range = new Circle(position.x+bounds.getWidth()/2,position.y+bounds.getHeight()/2,100);
    }

    public void update(float dt){
        grasshopperAnim.update(dt);



    }

    public Vector2 getPosition(){
        return position;
    }

    public TextureRegion getTexture() {
        return grasshopperAnim.getFrame();
    }

    public Rectangle getBounds() {
        return bounds;
    }



    public Circle getRange() {
        return range;
    }



    public void dispose() {
        texture.dispose();
    }
}