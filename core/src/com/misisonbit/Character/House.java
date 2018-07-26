package com.misisonbit.Character;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.misisonbit.Sprites.Animations;

public class House extends Organisms{
    Texture texture;
    Animations houseAnim;
    Rectangle bounds;
    Vector3 position;


    public House(float x, float y){
        super(x,y);

        position = new Vector3(x,y,0);
        texture = new Texture("house2.png");
        houseAnim = new Animations(new TextureRegion(texture), 4, 0.5f,2,2);
        bounds = new Rectangle(position.x,position.y,houseAnim.getFrame().getRegionWidth(),houseAnim.getFrame().getRegionHeight());


    }

    public TextureRegion getTexture(){
        return houseAnim.getFrame();

    }

    public Rectangle getBounds() {
        return bounds;
    }

    public void update(float dt){
        houseAnim.update(dt);


    }

    public void dispose() {
        texture.dispose();
    }

}
