package utils;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.Array;
import com.misisonbit.Character.Organisms;

import java.awt.Rectangle;

import static java.awt.Event.DOWN;
import static java.awt.Event.UP;
import static javax.swing.JSplitPane.LEFT;
import static javax.swing.JSplitPane.RIGHT;


public class Controller implements InputProcessor{
    private OrthographicCamera camera; // We need this to unproject our coordinates
    private Array<Image> buttons;
    private Rectangle leftHitbox,rightHitbox;
    private boolean leftPressed, rightPressed, jumpPressed, jumpPressed, attackPressed;


    class TouchInfo {
        public float touchX = 0;
        public float touchY = 0;
        public boolean touched = false;
    }


    /*     if ( == ) {
        if ( == UP) {
            this.y = this.y - this.ySpeed;
        }
        if ( == DOWN) {
            this.y = this.y + this.ySpeed;
        }
        if ( == LEFT) {
            this.x = this.x - this.xSpeed;
        }
        if ( == RIGHT) {
            this.x = this.x + this.xSpeed;
        }
    }
}
*/



    @Override
    public boolean keyDown(int keycode) {
        if(keycode == 83) {
            Organisms.y = Organisms.y - Organisms.ySpeed;
            return true;
        }
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
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
}
