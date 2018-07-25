package com.misisonbit.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.math.Intersector;
import com.misisonbit.Character.Grass;
import com.misisonbit.Character.Grasshopper;
import com.misisonbit.Character.House;
import com.misisonbit.Character.Organisms;
import com.misisonbit.Character.Rabbit;
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
    //Tree tree;
    Array<Tree> treeArray;

    Array <Sun> sunArray;
    Random random;

    Grasshopper grasshopper;
    House house;

    ShapeRenderer shapeRenderer;

    public static int LVpoints = 0;
    public static int trophicLevel;

    Vector2 grassHopperPoint;


    public GameState(MyGdxGame game) {
        super(game);
        random = new Random();

        grassHopperPoint = new Vector2(random.nextInt(Gdx.graphics.getWidth()),random.nextInt(Gdx.graphics.getWidth()));

        treeArray = new Array<Tree>();
        for(int i = 0; i< 5; i++) {
            int x = random.nextInt(MyGdxGame.width);
            int y = random.nextInt(MyGdxGame.height);
            Tree t = new Tree(x,y);
            treeArray.add(t);

        }

        sunArray = new Array<Sun>();

        for(int i = 0; i < 80; i++) {
            int x = random.nextInt(MyGdxGame.width);
            int y = random.nextInt(MyGdxGame.height);
            Sun s = new Sun(x,y);
            sunArray.add(s);
        }

        grass = new Grass(300,100);
        //sunArray.add(sun);
        //tree = new Tree(600,100);
        grasshopper = new Grasshopper(500,50, grass);
        house = new House(800,430);




        controller = new Controller();
        organisms = new Organisms(0f,0f);

        musicDeath = Gdx.audio.newSound(Gdx.files.internal("vsgame_0/crunch.mp3" ));

        shapeRenderer = new ShapeRenderer();




    }

    public void drawGame() {
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        font.draw(batch,this.getClass().toString(),0,10);
        batch.draw(grass.getCurrentAnim().getFrame(), grass.getPosition().x, grass.getPosition().y);


        //batch.draw(tree.getTexture(),600,100);

        for(int i = 0; i < treeArray.size; i ++) {
            batch.draw(treeArray.get(i).getTexture(),treeArray.get(i).getPosition().x,treeArray.get(i).getPosition().y);
        }



        for (int i = 0; i < sunArray.size; i++) {
                batch.draw(sunArray.get(i).getTexture(), sunArray.get(i).getPosition().x, sunArray.get(i).getPosition().y);

        }


        batch.draw(grasshopper.getTexture(),grasshopper.getPosition().x,grasshopper.getPosition().y);
        batch.draw(house.getTexture(),800,430);


        batch.end();






        shapeRenderer.setProjectionMatrix(camera.combined);
        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
        //--------------shows hit box--------------

        shapeRenderer.rect(grass.getBounds().x,grass.getBounds().y,grass.getBounds().getWidth(),grass.getBounds().getHeight());

        for(Sun s : sunArray) {
            shapeRenderer.rect(s.getBounds().x, s.getBounds().y, s.getBounds().getWidth(), s.getBounds().getHeight());
        }

        for(Tree t : treeArray) {
            shapeRenderer.rect(t.getBounds().x,t.getBounds().y, t.getBounds().getWidth(),t.getBounds().getHeight());
        }

        //shapeRenderer.rect(tree.getPosition().x,tree.getPosition().y,tree.getTexture().getRegionWidth(),tree.getTexture().getRegionHeight());
        shapeRenderer.rect(grasshopper.getPosition().x,grasshopper.getPosition().y,grasshopper.getTexture().getRegionWidth(),grasshopper.getTexture().getRegionHeight());
        shapeRenderer.circle(grasshopper.getPosition().x+grasshopper.getBounds().getWidth()/2,grasshopper.getPosition().y+grasshopper.getBounds().getHeight()/2,grasshopper.getRange().radius);
        shapeRenderer.rect(house.getPosition().x,house.getPosition().y,house.getTexture().getRegionWidth(),house.getTexture().getRegionHeight());
        //-----------------------------------------
        shapeRenderer.end();
        controller.draw();

//        if(grass.getBounds().x < 0) {ls
//            grass.getPosition().x = 0;
//        }



    }
//update============================================================================================
    public void update(float dt) {

        //System.out.println("grass x: "+grass.getPosition().x+" grass y: "+grass.getPosition().y);


        controller.update(grass);
        grass.update(Gdx.graphics.getDeltaTime());
        //tree.update(Gdx.graphics.getDeltaTime());

        for (int i = 0; i < treeArray.size; i ++) {
            treeArray.get(i).update(dt);
        }

        grasshopper.update(Gdx.graphics.getDeltaTime());
        house.update(Gdx.graphics.getDeltaTime());


        collide();



        for (int i = 0; i < sunArray.size; i++) {
            sunArray.get(i).update(dt);
            if (grass.getBounds().overlaps(sunArray.get(i).getBounds())) {
                sunArray.removeValue(sunArray.get(i), true);

                LVpoints++;
                System.out.println(LVpoints);

//                if(LVpoints >= 2){
//
//                }


                musicDeath.play();
            }


        }
        //handleInput();
    }

    public void collide() {

        for(int i = 0;i<treeArray.size;i++) {
            if (treeArray.get(i).getBounds().contains(grass.getBounds())){
                System.out.println("but i love emilia");



            }else if (Intersector.overlaps(grasshopper.getRange(), grass.getBounds())) {
                System.out.println("remilia");
            }
        }
//        if(grass.getBounds().overlaps(grasshopper.getBounds())){
//            System.out.println("who's rem");
//        }
//        if (grass.getBounds().overlaps(house.getBounds())){
//            System.out.println("testing house");
//        }




        //---------notice the grasshopper----------





//not go out of screen kinda
        if(grasshopper.getPosition().x >= Gdx.graphics.getWidth()){
            grasshopper.getPosition().x-=10;
        }else if(grasshopper.getPosition().x <= 0){
            grasshopper.getPosition().x+=10;

        }

        if(grasshopper.getPosition().y >= Gdx.graphics.getHeight()){

        }else if(grasshopper.getPosition().y <= 0){

        }

        if(Intersector.overlaps(grasshopper.getRange(),grass.getBounds())){
            grasshopper.getBounds().setPosition(grasshopper.getPosition().x, grasshopper.getPosition().y);
            grasshopper.getRange().setPosition(grasshopper.getPosition().x,grasshopper.getPosition().y);


            switch (trophicLevel) {
                case 0:
                    if (grasshopper.getPosition().x >= grass.getPosition().x) {
                        grasshopper.getPosition().x -= 1.2;
                    } else {
                        grasshopper.getPosition().x += 1.2;
                    }

                    if (grasshopper.getPosition().y >= grass.getPosition().y) {
                        grasshopper.getPosition().y -= 1.2;
                    } else {
                        grasshopper.getPosition().y += 1.2;
                    }
                    break;

                case 1:

                    if(random.nextBoolean()==true){
                        grasshopper.getPosition().x+=1.5;
                    }else{
                        grasshopper.getPosition().x-=1.5;
                    }

                    if(random.nextBoolean()==true){
                        grasshopper.getPosition().y+=1.5;
                    }else{
                        grasshopper.getPosition().y-=1.5;
                    }

                    break;

                case 2:
                    if(grasshopper.getPosition().x<Gdx.graphics.getWidth() && grasshopper.getPosition().x>0) {
                        if (grasshopper.getPosition().x >= grass.getPosition().x) {
                            grasshopper.getPosition().x += 1.2;
                        } else {
                            grasshopper.getPosition().x -= 1.2;
                        }
                    }

                    if(grasshopper.getPosition().y<Gdx.graphics.getWidth() && grasshopper.getPosition().y>0) {
                        if (grasshopper.getPosition().y >= grass.getPosition().y) {
                            grasshopper.getPosition().y += 1.2;
                        } else {
                            grasshopper.getPosition().y -= 1.2;
                        }
                    }
                    break;
                default:

            }
        }else{





        }
        //import Intersector library





    }

        //if(grass.getBounds().overlaps(sun.getBounds()) && sun.isAlive){
         //   musicDeath.play();
            //sun.isAlive = false;
        //}

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
