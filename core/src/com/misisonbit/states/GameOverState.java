package com.misisonbit.states;

import com.badlogic.gdx.Gdx;
import com.misisonbit.MyGdxGame;


public class GameOverState extends State{

    public GameOverState(MyGdxGame game){
        super(game);

    }

    public void drawGame(){
        font.setColor(0,0,2,8);
        font.draw(batch,"Sorry Try Again", Gdx.graphics.getWidth()/2,Gdx.graphics.getHeight()/2);

    }

    public void update(float dt){

    }
}

