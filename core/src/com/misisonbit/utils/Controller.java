
package com.misisonbit.utils;
/*

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.Array;
import com.misisonbit.Character.Organisms;

import java.awt.Rectangle;




public class Controller implements InputProcessor{
    private OrthographicCamera camera; // We need this to unproject our coordinates
    private Array<Image> buttons;
    //private Rectangle leftHitbox,rightHitbox;
    private boolean leftPressed, rightPressed, upPressed, downPressed;



    @Override
    public boolean keyDown(int keycode) {
        if(keycode == 83) {
            downPressed = true;
        }
        return true;
    }

    @Override
    public boolean keyUp(int keycode) {
        if(keycode == Input.Keys.W) {
            upPressed = true;
        }
        return true;
    }

    public boolean keyRight(int keycode) {
        if(keycode == Input.Keys.D) {
            rightPressed = true;
        }
        return true;
    }
    public boolean keyLeft(int keycode) {
        if(keycode == Input.Keys.A) {
            leftPressed = true;
        }
        return true;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }

    public boolean isLeftPressed() { return leftPressed;
    }

    public boolean isRightPressed() {
        return rightPressed;
    }

    public boolean isUpPressed() {
        return upPressed;
    }

    public boolean isDownPressed() {
        return downPressed;
    }
}

*/



import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Touchpad;
import com.badlogic.gdx.scenes.scene2d.ui.Touchpad.TouchpadStyle;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.misisonbit.Character.Organisms;

/**
 * Created by Kat on 7/10/16.
 */
public class Controller {
    public Touchpad touchpad;
    private TouchpadStyle touchpadStyle;
    private Skin touchpadSkin;
    private Drawable touchBackground;
    private Drawable touchKnob;

    private Stage stage;
    private float spriteSpeed;

    public Controller() {
        //Create a touchpad skin
        touchpadSkin = new Skin();
        //Set background image
        touchpadSkin.add("touchBackground", new Texture("touchBackground.png"));
        //Set knob image
        touchpadSkin.add("touchKnob", new Texture("touchKnob.png"));

        //Create TouchPad Style
        touchpadStyle = new TouchpadStyle();
        //Create Drawable's from TouchPad skin
        touchBackground = touchpadSkin.getDrawable("touchBackground");
        touchKnob = touchpadSkin.getDrawable("touchKnob");
        //Apply the Drawables to the TouchPad Style
        touchpadStyle.background = touchBackground;
        touchpadStyle.knob = touchKnob;

        //Create new TouchPad with the created style
        touchpad = new Touchpad(10, touchpadStyle);
        //setBounds(x,y,width,height)
        touchpad.setBounds(50, 50, 130, 130);

        // Create stage and add touchpad
        stage = new Stage();
        stage.addActor(touchpad);
        Gdx.input.setInputProcessor(stage);

        // Set speed of sprite movement
        spriteSpeed = 5;
    }

    // update sprite position based on joystick movement
    public void update(Organisms organisms) {
      organisms.setVelocity(touchpad.getKnobPercentX()*2,touchpad.getKnobPercentY()*2);
    }

    public void draw() {
        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();
    }
}
