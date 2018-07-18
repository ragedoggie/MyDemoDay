package com.misisonbit.Character;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector3;
import com.misisonbit.Sprites.Animations;

import java.awt.Rectangle;

public class Tree {

    Texture texture;
    Rectangle bounds;
    Animations treeAim;
    Vector3 vectocity;
    Vector3 position;


    public void Tree(int x , int y){
        position = new Vector3(x,y,0);
        texture = new Texture("tree.png");

    }

    public Texture getTexture() {
        return texture;
    }
}

