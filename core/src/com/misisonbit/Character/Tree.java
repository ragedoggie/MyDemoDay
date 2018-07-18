package com.misisonbit.Character;

import com.badlogic.gdx.graphics.Texture;

public class Tree {

    Texture texture;

    public void Tree(int x , int y){
        texture = new Texture("tree.png");

    }

    public Texture getTexture() {
        return texture;
    }
}
