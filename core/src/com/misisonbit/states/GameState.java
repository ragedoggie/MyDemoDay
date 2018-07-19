package com.misisonbit.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Intersector;
import com.misisonbit.Character.Grass;
import com.misisonbit.Character.Grasshopper;
import com.misisonbit.Character.Organisms;
import com.misisonbit.Character.Sun;
import com.misisonbit.Character.Tree;
import com.misisonbit.MyGdxGame;
import com.misisonbit.utils.Controller;

import java.awt.Rectangle;


public class GameState extends State {
    Sound musicDeath;
    Grass grass;
    Sun sun;
    Controller controller;
    Organisms organisms;
    Tree tree;
    Grasshopper grasshopper;

    ShapeRenderer shapeRenderer;


    public GameState(MyGdxGame game) {
        super(game);
        grass = new Grass(300,100);
        sun = new Sun(350,100);
        tree = new Tree(600,100);
        grasshopper = new Grasshopper(500,50);

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
        if (sun.isAlive == true) {
            batch.draw(sun.getTexture(), sun.getPosition().x, sun.getPosition().y);
        }
        batch.draw(tree.getTexture(),600,100);
        batch.draw(grasshopper.getTexture(),500,50);
        batch.end();

        shapeRenderer.setProjectionMatrix(camera.combined);
        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
        //--------------shows hit box--------------

        shapeRenderer.rect(grass.getPosition().x,grass.getPosition().y,grass.getBounds().getWidth(),grass.getBounds().getHeight());
        if(sun.isAlive == true) {
            shapeRenderer.rect(sun.getPosition().x, sun.getPosition().y, sun.getBounds().getWidth(), sun.getBounds().getHeight());
        }
        shapeRenderer.rect(sun.getPosition().x,sun.getPosition().y,sun.getBounds().getWidth(),sun.getBounds().getHeight());
        shapeRenderer.rect(tree.getPosition().x,tree.getPosition().y,tree.getTexture().getRegionWidth(),tree.getTexture().getRegionHeight());
        shapeRenderer.rect(grasshopper.getPosition().x,grasshopper.getPosition().y,grasshopper.getTexture().getRegionWidth(),grasshopper.getTexture().getRegionHeight());
        shapeRenderer.circle(grasshopper.getPosition().x+grasshopper.getBounds().getWidth()/2,grasshopper.getPosition().y+grasshopper.getBounds().getHeight()/2,grasshopper.getRange().radius);
        //-----------------------------------------
        shapeRenderer.end();
        controller.draw();
    }

    public void update(float dt) {
        grass.update(Gdx.graphics.getDeltaTime());
        controller.update(grass);
        if(sun.isAlive == true) {
            sun.update(Gdx.graphics.getDeltaTime());
        }
        tree.update(Gdx.graphics.getDeltaTime());
        grasshopper.update(Gdx.graphics.getDeltaTime());
        collide();



    }

    public void collide(){
        if(grass.getBounds().overlaps(sun.getBounds()) && sun.isAlive){
            musicDeath.play();
            sun.isAlive = false;
            System.out.println("rem best girl");
        }
        if(tree.getBounds().contains(grass.getBounds())){
            System.out.println("but i love emilia");
        }else if (Intersector.overlaps(grasshopper.getRange(),grass.getBounds())){
            System.out.println("remilia");
        }
        if(grass.getBounds().overlaps(grasshopper.getBounds())){
            System.out.println("who's rem");
        }





        /*if(Intersector.overlaps(grasshopper.getRange(),grass.getBounds())){
            System.out.println("remilia");
        }*/
        //import Intersector library


        sun.getBounds().setPosition(sun.getPosition().x,sun.getPosition().y);
        grass.getBounds().setPosition(grass.getPosition().x,grass.getPosition().y);


    }






    public void dispose() {
        batch.dispose();
        shapeRenderer.dispose();
        musicDeath.dispose();
        sun.dispose();
        grass.dispose();
    }

}
