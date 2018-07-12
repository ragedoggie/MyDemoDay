package com.misisonbit.utils;

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
    private Rectangle leftHitbox,rightHitbox;
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


