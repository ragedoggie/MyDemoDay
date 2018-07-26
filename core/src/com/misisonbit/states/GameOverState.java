package com.misisonbit.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.misisonbit.MyGdxGame;

import static com.misisonbit.states.GameState.Uwin;


public class GameOverState extends State{

    Texture itsOver;
    Texture win;


    public GameOverState(MyGdxGame game){
        super(game);
        win = new Texture("grassEnd.png");
        itsOver = new Texture("GrasshopperEnd.png");


    }

    public void drawGame(){
        if(Uwin == false){
            font.setColor(Color.GOLDENROD);
            batch.begin();
            font.getData().setScale(5,5);
            font.draw(batch,"Sorry Try Again.\nclick to try again.", Gdx.graphics.getWidth()/3,Gdx.graphics.getHeight()/2);
            batch.draw(itsOver, Gdx.graphics.getWidth()/3,Gdx.graphics.getHeight()/2);

            batch.end();
        }else{
            font.setColor(Color.GOLDENROD);
            batch.begin();
            font.getData().setScale(5,5);
            font.draw(batch,"You win.\nclick to play again.", Gdx.graphics.getWidth()/3,Gdx.graphics.getHeight()/2);
            batch.draw(win, Gdx.graphics.getWidth()/3,Gdx.graphics.getHeight()/2);

            batch.end();

        }
    }

    public void update(float dt){
        drawGame();
        clickHandler();
    }

    public void clickHandler(){
        if (Gdx.input.justTouched()) {
            game.setScreen(new MenuState(game));
            //dispose();
        }
    }


    @Override
    public void dispose() {
        super.dispose();
        batch.dispose();
        font.dispose();
        win.dispose();
        itsOver.dispose();

    }
}

