package com.misisonbit.states;

import com.badlogic.gdx.graphics.Texture;
import com.misisonbit.MyGdxGame;

public class MenuState extends State{
    private Texture screen;

    public MenuState(MyGdxGame game){
        super(game);
        screen = new Texture("fish.jpg");
    }

    public void drawGame(){

    }

    public void update(float dt){

    }

}

