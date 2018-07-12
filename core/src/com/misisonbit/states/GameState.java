package com.misisonbit.states;

import com.badlogic.gdx.graphics.Texture;
import com.misisonbit.MyGdxGame;

public class GameState extends State {


    public GameState(MyGdxGame game) {
        super(game);

    }

    public void drawGame() {
        batch.begin();
        font.draw(batch,this.getClass().toString(),0,10);
        batch.end();
    }

    public void update(float dt) {

    }

}
