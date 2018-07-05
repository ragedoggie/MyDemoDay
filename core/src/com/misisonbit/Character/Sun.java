package com.misisonbit.Character;


import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.misisonbit.Sprites.Animations;


public class Sun {

    static final int GRAVITY = 0;
    static final int MOVEMENT = 100;
    Vector3 position;
    Rectangle bounds;
    Animations sunAnim;
    Texture texture;
    //Sound ray;



    public Sun(int x, int y){

        position = new Vector3(x, y, 0);
        texture = new Texture("Sun.png");
        bounds = new Rectangle(x, y, texture.getWidth() / 3, texture.getHeight() / 3);
        sunAnim = new Animations(new TextureRegion(texture), 2, 0.5f,2,1);
        //ray = Gdx.audio.newSound(Gdx.files.internal("sfx_wing.ogg"));

    }

    public void update(float dt){
        sunAnim.update(dt);

        }


    public Vector3 getPosition() {
        return position;
    }

    public TextureRegion getTexture() {
        return sunAnim.getFrame();
    }



    public Rectangle getBounds() {
        return bounds;
    }

    public void dispose() {
        texture.dispose();
        //flap.dispose();
    }
}






/*


public class Sun {

     Sprite sun1;
     Sprite sun2;

    public Sun(){
        Texture frame1 = new Texture("Sun1.png");
        Texture frame2 = new Texture("Sun2.png");
        Animation suns;
        sun1 = new Sprite(frame1);
        sun2 = new Sprite(frame2);


        suns = new Animation(0.05f, new TextureRegion(sun1), new TextureRegion(sun2));
        suns.setPlayMode(Animation.PlayMode.LOOP);

    }


}


*/
