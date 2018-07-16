package com.misisonbit.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.misisonbit.Character.Grass;
import com.misisonbit.Character.Organisms;
import com.misisonbit.MyGdxGame;
import com.misisonbit.utils.Controller;

public class GameState extends State {
    Grass grass;
    Controller controller;
    Organisms organisms;



    public GameState(MyGdxGame game) {
        super(game);
        grass = new Grass(100,100);
        controller = new Controller();
        organisms = new Organisms();

    }

    public void drawGame() {
        batch.begin();
        font.draw(batch,this.getClass().toString(),0,10);
        batch.draw(grass.getTexture(),100,100);
        controller.draw();
        batch.end();
    }

    public void update(float dt) {
        grass.update(Gdx.graphics.getDeltaTime());
        controller.update(organisms);

    }

    public void dispose() {
        batch.dispose();
    }

}
