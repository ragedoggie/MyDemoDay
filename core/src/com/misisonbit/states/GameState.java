package com.misisonbit.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.Array;
import com.misisonbit.Character.Grass;
import com.misisonbit.Character.Organisms;
import com.misisonbit.Character.Sun;
import com.misisonbit.Character.Tree;
import com.misisonbit.MyGdxGame;
import com.misisonbit.utils.Controller;


import java.awt.Rectangle;
import java.util.Random;

public class GameState extends State {
    Sound musicDeath;
    Grass grass;
    //Sun sun;
    Controller controller;
    Organisms organisms;
    Tree tree;
    Array <Sun> sunArray;
    int sunNum;
    Random random;


    ShapeRenderer shapeRenderer;


    public GameState(MyGdxGame game) {
        super(game);
        random = new Random();
        sunArray = new Array<Sun>();

        for(int i = 0; i < 20; i++) {
            int x = random.nextInt(MyGdxGame.width);
            int y = random.nextInt(MyGdxGame.height);
            Sun s = new Sun(x,y);
            sunArray.add(s);
        }

        grass = new Grass(300,100);
        //sunArray.add(sun);
        tree = new Tree(600,100);

        controller = new Controller();
        organisms = new Organisms(0f,0f);

        musicDeath = Gdx.audio.newSound(Gdx.files.internal("vsgame_0/crunch.mp3" ));

        shapeRenderer = new ShapeRenderer();

    }

    public void drawGame() {
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        font.draw(batch,this.getClass().toString(),0,10);
        batch.draw(grass.getTexture(), grass.getPosition().x, grass.getPosition().y);

        batch.draw(tree.getTexture(),600,100);


        for (int i = 0; i < sunArray.size; i++) {
                batch.draw(sunArray.get(i).getTexture(), sunArray.get(i).getPosition().x, sunArray.get(i).getPosition().y);

        }

        batch.end();

        shapeRenderer.setProjectionMatrix(camera.combined);
        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
        //--------------shows hit box--------------

        shapeRenderer.rect(grass.getBounds().x,grass.getBounds().y,grass.getBounds().getWidth(),grass.getBounds().getHeight());

        for(Sun s : sunArray) {
            shapeRenderer.rect(s.getBounds().x, s.getBounds().y, s.getBounds().getWidth(), s.getBounds().getHeight());
        }
        //-----------------------------------------
        shapeRenderer.end();
        controller.draw();
    }

    public void update(float dt) {

        controller.update(grass);
        grass.update(Gdx.graphics.getDeltaTime());
        tree.update(Gdx.graphics.getDeltaTime());



        for (int i = 0; i < sunArray.size; i++) {
            sunArray.get(i).update(dt);
            if(grass.getBounds().overlaps(sunArray.get(i).getBounds())) {
                sunArray.removeValue(sunArray.get(i),true);
            }
        }
        collide();
        //handleInput();



    }

    public void collide(){
        //if(grass.getBounds().overlaps(sun.getBounds()) && sun.isAlive){
         //   musicDeath.play();
            //sun.isAlive = false;
        }

        //sun.getBounds().setPosition(sun.getPosition().x,sun.getPosition().y);
       //


    //}



    public void dispose() {
        batch.dispose();
        shapeRenderer.dispose();
        musicDeath.dispose();
        //sun.dispose();
        grass.dispose();
    }

}
