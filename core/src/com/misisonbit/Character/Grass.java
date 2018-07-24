package com.misisonbit.Character;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.misisonbit.Sprites.Animations;

import static com.badlogic.gdx.scenes.scene2d.InputEvent.Type.keyDown;
import static com.misisonbit.states.GameState.LVpoints;

public class Grass extends Organisms {



    Rectangle bounds;

    Animations currentAnim;
    Animations grassAnim;
    Animations grassAnim2;
    //Texture sprite;
    Sprite grassSprite;

    Texture texture;
    Texture texture2;


    private static boolean upPressed, downPressed, leftPressed, rightPressed = false;


    public Grass(float x, float y){
        super(x,y);
        //sprite = new Texture("grass2.png");
        texture = new Texture("grass2.png");
        texture2 = new Texture("grasshopper2.png");
        grassSprite = new Sprite(texture);

        grassAnim = new Animations(new TextureRegion(texture), 3, 0.8f,2,2);
        grassAnim2 = new Animations(new TextureRegion(texture2), 3, 0.5f,3,1);

        bounds = new Rectangle(x, y, grassAnim.getFrame().getRegionWidth(), grassAnim.getFrame().getRegionHeight());
        offset = new Vector2(getTexture().getRegionWidth(),getTexture().getRegionHeight());
    }

    public boolean keyDown(int keycode) {
        if(keycode == Input.Keys.UP){
            upPressed = true;
        }

        return true;
    }
    public boolean keyUp(int keycode) {
        if(keycode == Input.Keys.UP){
            upPressed = false;
        }
        return true;
    }


    public void update(float dt){
        super.update(dt);

        bounds.setPosition(position.x, position.y);

        if(LVpoints>2){
            grassSprite.setTexture(texture);
            currentAnim = grassAnim;
            grassAnim.update(dt);
        }else if(LVpoints<2){
            grassSprite.setTexture(texture2);
            currentAnim = grassAnim2;
            grassAnim2.update(dt);


        }
        }






    public TextureRegion getTexture() {
        return grassAnim.getFrame();
    }

    public Rectangle getBounds() {
        return bounds;
    }

    public Sprite getGrassSprite() {
        return grassSprite;
    }

    public void dispose() {
        texture.dispose();

    }
}