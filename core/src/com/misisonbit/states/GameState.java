package com.misisonbit.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;
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
import java.util.Timer;


public class GameState extends State {
    ParticleEffect effect;
    Sound musicDeath;
    Sound levelUp;
    Grass grass;
    //Sun sun;
    Controller controller;
    Organisms organisms;
    //Tree tree;
    Music music;
    Array<Tree> treeArray;

    Array<Sun> sunArray;

    boolean biotic;

    Random random;

    Grasshopper grasshopper;
    House house;

    ShapeRenderer shapeRenderer;

    Vector2 target;

    public static int LVpoints = 0;
    public static int trophicLevel;

    Vector2 grassHopperPoint;
    boolean inTree;
    boolean respawning;

    public static boolean Uwin;

    //-----------------------show or hide white boxes-----------------------\\  \\-------\\
    boolean debugg = true;                                              //  //       //
//-----------------------show or hide white boxes-----------------------\\  \\-------\\
    public void create() {
        music = Gdx.audio.newMusic(Gdx.files.internal("Forest_Ambience.mp3"));
        music.setLooping(true);
        music.setVolume(1f);
        music.play();
    }

    public GameState(MyGdxGame game) {
        super(game);
        random = new Random();
        /*effect = new ParticleEffect();
        effect.load(Gdx.files.internal("vsgame_0/Smoke"),Gdx.files.internal("vsgame_0"));
        effect.start();
        effect.setPosition(460, 240);*/

        grassHopperPoint = new Vector2(random.nextInt(Gdx.graphics.getWidth()), random.nextInt(Gdx.graphics.getWidth()));

        treeArray = new Array<Tree>();
        for (int i = 0; i < 5; i++) {
            int x = random.nextInt(MyGdxGame.width);
            int y = random.nextInt(MyGdxGame.height);
            Tree t = new Tree(x, y);
            treeArray.add(t);

        }

        sunArray = new Array<Sun>();

        //sun num here
        for (int i = 0; i < 10; i++) {
            int x = random.nextInt(MyGdxGame.width);
            int y = random.nextInt(MyGdxGame.height);
            Sun s = new Sun(x, y);
            sunArray.add(s);
        }

        grass = new Grass(300, 100);
        //sunArray.add(sun);
        //tree = new Tree(600,100);
        grasshopper = new Grasshopper(500, 50, grass);
        house = new House(800, 430);


        controller = new Controller();
        organisms = new Organisms(0f, 0f);

        musicDeath = Gdx.audio.newSound(Gdx.files.internal("vsgame_0/crunch.mp3"));
        levelUp = Gdx.audio.newSound(Gdx.files.internal("vsgame_0/chipquest.wav" ));

        shapeRenderer = new ShapeRenderer();

        inTree = false;

        target = new Vector2();
        target.set(random.nextInt(Gdx.graphics.getWidth()), random.nextInt(Gdx.graphics.getHeight()));

        biotic = true;
        Uwin = false;
        respawning = false;

        LVpoints = 0;
        trophicLevel = 1;

    }

    public void drawGame() {
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        font.draw(batch, this.getClass().toString(), 0, 10);
        //point
        font.draw(batch, "Points = "+LVpoints, MyGdxGame.width-75, 10);

        batch.draw(grass.getCurrentAnim().getFrame(), grass.getPosition().x, grass.getPosition().y);


        //batch.draw(tree.getTexture(),600,100);

        for (int i = 0; i < treeArray.size; i++) {
            batch.draw(treeArray.get(i).getTexture(), treeArray.get(i).getPosition().x, treeArray.get(i).getPosition().y);
        }


        for (int i = 0; i < sunArray.size; i++) {
            batch.draw(sunArray.get(i).getTexture(), sunArray.get(i).getPosition().x, sunArray.get(i).getPosition().y);

        }


if(biotic) {
    batch.draw(grasshopper.getTexture(), grasshopper.getPosition().x, grasshopper.getPosition().y);
}
        batch.draw(house.getTexture(), 800, 430);
        //effect.draw(batch);


        batch.end();


        if (debugg == true) {
            shapeRenderer.setProjectionMatrix(camera.combined);
            shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
            //--------------shows hit box--------------

            shapeRenderer.rect(grass.getBounds().x, grass.getBounds().y, grass.getBounds().getWidth(), grass.getBounds().getHeight());

            for (Sun s : sunArray) {
                shapeRenderer.rect(s.getBounds().x, s.getBounds().y, s.getBounds().getWidth(), s.getBounds().getHeight());
            }

            for (Tree t : treeArray) {
                shapeRenderer.rect(t.getBounds().x, t.getBounds().y, t.getBounds().getWidth(), t.getBounds().getHeight());
            }

            //shapeRenderer.rect(tree.getPosition().x,tree.getPosition().y,tree.getTexture().getRegionWidth(),tree.getTexture().getRegionHeight());
            if(biotic){
            shapeRenderer.rect(grasshopper.getPosition().x, grasshopper.getPosition().y, grasshopper.getTexture().getRegionWidth(), grasshopper.getTexture().getRegionHeight());
            shapeRenderer.circle(grasshopper.getPosition().x + grasshopper.getBounds().getWidth() / 2, grasshopper.getPosition().y + grasshopper.getBounds().getHeight() / 2, grasshopper.getRange().radius);
            }
            shapeRenderer.rect(house.getPosition().x, house.getPosition().y, house.getTexture().getRegionWidth(), house.getTexture().getRegionHeight());
            //-----------------------------------------
            shapeRenderer.end();
        }
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

        for (int i = 0; i < treeArray.size; i++) {
            treeArray.get(i).update(dt);
        }


        grasshopper.update(Gdx.graphics.getDeltaTime());
        house.update(Gdx.graphics.getDeltaTime());
        //effect.update(dt);




        for (int i = 0; i < sunArray.size; i++) {
            sunArray.get(i).update(dt);

            if (grass.getBounds().overlaps(sunArray.get(i).getBounds())) {
                sunArray.removeValue(sunArray.get(i), true);
                //effect.setPosition(grass.getPosition().x, grass.getPosition().y);
               // effect.start();
                int x = random.nextInt(MyGdxGame.width);
                int y = random.nextInt(MyGdxGame.height);
                Sun s = new Sun(x, y);
                sunArray.add(s);


                LVpoints++;
                if(LVpoints == 10 || LVpoints == 20){
                    levelUp.play(0.3f);
                    System.out.println("rem:0");
                }
                System.out.println(LVpoints);

                musicDeath.play();

            }else if(grasshopper.getBounds().overlaps(sunArray.get(i).getBounds())) {
                    sunArray.removeValue(sunArray.get(i), true);
                    int x = random.nextInt(MyGdxGame.width);
                    int y = random.nextInt(MyGdxGame.height);
                    Sun s = new Sun(x, y);
                    sunArray.add(s);

                musicDeath.play();

            }


        }
        collide();
//---------------------eatingBoi----------------------------------
        if(biotic){
        if(grass.getBounds().overlaps(grasshopper.getBounds())) {
            System.out.println("who's rem?");

            if (trophicLevel == 0) {
                musicDeath.play();
                this.dispose();
                game.setScreen(new GameOverState(game));
            } else if (trophicLevel == 2) {
                biotic = false;
                LVpoints+=10;
                musicDeath.play();

            }
        }
        }


        //undyingBoi();

    }

    //-----------------------collide begins here-----------------------
    public void collide() {
        boolean temp = false;
        for (int i = 0; i < treeArray.size; i++) {
            if (treeArray.get(i).getBounds().contains(grass.getBounds())) {
                System.out.println("but i love emilia");
                //treeArray.get(i).getSprite().
                temp = true;
            } else {
                if (!temp) {
                    inTree = false;
                }
            }

            if (temp) {
                inTree = true;
            }
        }


        //the grass hopper eating part===================================      ===============
//        if(grass.getBounds().overlaps(grasshopper.getBounds())){
//            System.out.println("who's rem");
//            musicDeath.play();
//
//            game.setScreen(new GameOverState(game));
//            musicDeath.stop();
//            dispose();
//
//
//        }

//------------house--------------
        if (grass.getBounds().overlaps(house.getBounds())){
            System.out.println("testing house");
            if(LVpoints>=100){
                Uwin = true;
                this.dispose();
                game.setScreen(new GameOverState(game));
            }else{

            }
       }


        //---------notice the grasshopper----------
        if (biotic) {

//not go out of screen kinda

            if (grasshopper.getPosition().x >= MyGdxGame.width) {
                grasshopper.getPosition().x -= 10;
            } else if (grasshopper.getPosition().x <= 0) {
                grasshopper.getPosition().x += 10;

            }

            if (grasshopper.getPosition().y >= MyGdxGame.height) {
                grasshopper.getPosition().y -= 10;
            } else if (grasshopper.getPosition().y <= 0) {
                grasshopper.getPosition().y += 10;

            }

//-----------------hiding----------------
            if (!inTree) {
                if (Intersector.overlaps(grasshopper.getRange(), grass.getBounds())) {
                    grasshopper.getBounds().setPosition(grasshopper.getPosition().x, grasshopper.getPosition().y);
                    grasshopper.getRange().setPosition(grasshopper.getPosition().x, grasshopper.getPosition().y);

//reaction====================================
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

                            if (random.nextBoolean() == true) {
                                grasshopper.getPosition().x += 1.5;
                            } else {
                                grasshopper.getPosition().x -= 1.5;
                            }

                            if (random.nextBoolean() == true) {
                                grasshopper.getPosition().y += 1.5;
                            } else {
                                grasshopper.getPosition().y -= 1.5;
                            }

                            break;

                        case 2:
                            if (grasshopper.getPosition().x < MyGdxGame.width && grasshopper.getPosition().x > 0) {
                                if (grasshopper.getPosition().x >= grass.getPosition().x) {
                                    grasshopper.getPosition().x += 1.2;
                                } else {
                                    grasshopper.getPosition().x -= 1.2;
                                }
                            }

                            if (grasshopper.getPosition().y < MyGdxGame.height && grasshopper.getPosition().y > 0) {
                                if (grasshopper.getPosition().y >= grass.getPosition().y) {
                                    grasshopper.getPosition().y += 1.2;
                                } else {
                                    grasshopper.getPosition().y -= 1.2;
                                }
                            }
                            break;
                        default:

                    }
                } else {
                    moveBoi();

                }
            } else {
                moveBoi();
            }
        }
    }

    //if(grass.getBounds().overlaps(sun.getBounds()) && sun.isAlive){
    //   musicDeath.play();
    //sun.isAlive = false;
    //}

    //sun.getBounds().setPosition(sun.getPosition().x,sun.getPosition().y);
    //


    //}

    public void moveBoi() {
        grasshopper.getBounds().setPosition(grasshopper.getPosition().x, grasshopper.getPosition().y);
        grasshopper.getRange().setPosition(grasshopper.getPosition().x, grasshopper.getPosition().y);

        if (!grasshopper.getRange().contains(target)) {
            if (grasshopper.getPosition().x > target.x) {
                grasshopper.getPosition().x -= 1.2;
            } else {
                grasshopper.getPosition().x += 1.2;
            }

            if (grasshopper.getPosition().y > target.y) {
                grasshopper.getPosition().y -= 1.2;
            } else {
                grasshopper.getPosition().y += 1.2;
            }


        } else {
            target.set(random.nextInt(Gdx.graphics.getWidth()), random.nextInt(Gdx.graphics.getHeight()));
        }

    }

    void undyingBoi(){
        if(!biotic && !respawning){
            respawning = true;
        }
        if(respawning){

            new java.util.Timer().schedule(
                    new java.util.TimerTask() {
                        @Override
                        public void run() {
                            System.out.println("my brain trembles");
                            biotic = true;
                            respawning = false;
                        }
                    },
                    5000
            );

        }
    }
//=--=-=-=-=-=-=-=-=-=-dispose-=-=-=-=-===-=-=-=-=-=-=-=-=-=-=-=-=dispose-=-=-=-=-=-=-=---=-=-===-=-=-=-=-=-=-dispose-=-=-=\\

    public void dispose() {
        super.dispose();
        musicDeath.dispose();
        for (Sun sun : sunArray) {
            sun.dispose();
        }
        house.dispose();
        for (Tree tree: treeArray) {
            tree.dispose();
        }
        levelUp.dispose();

        grasshopper.dispose();
        grass.dispose();
    }

}
