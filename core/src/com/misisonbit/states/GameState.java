package com.misisonbit.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.misisonbit.Character.Grass;
import com.misisonbit.Character.Organisms;
import com.misisonbit.Character.Sun;
import com.misisonbit.Character.Tree;
import com.misisonbit.MyGdxGame;
import com.misisonbit.utils.Controller;

import java.awt.Rectangle;

public class GameState extends State {
    Grass grass;
    Sun sun;
    Controller controller;
    Organisms organisms;
    Tree tree;

    ShapeRenderer shapeRenderer;


    public GameState(MyGdxGame game) {
        super(game);
        grass = new Grass(300,100);
        sun = new Sun(350,100);
        tree = new Tree(600,100);

        controller = new Controller();
        organisms = new Organisms(0f,0f);

        shapeRenderer = new ShapeRenderer();

    }

    public void drawGame() {
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        font.draw(batch,this.getClass().toString(),0,10);
        batch.draw(grass.getTexture(), grass.getPosition().x, grass.getPosition().y);
        batch.draw(sun.getTexture(),sun.getPosition().x,sun.getPosition().y);
        batch.draw(tree.getTexture(),600,100);
        batch.end();

        shapeRenderer.setProjectionMatrix(camera.combined);
        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
        //--------------shows hit box--------------
        shapeRenderer.rect(grass.getPosition().x,grass.getPosition().y,grass.getBounds().getWidth(),grass.getBounds().getHeight());
        shapeRenderer.rect(sun.getPosition().x,sun.getPosition().y,sun.getBounds().getWidth(),sun.getBounds().getHeight());
        //-----------------------------------------
        shapeRenderer.end();
        controller.draw();
    }

    public void update(float dt) {
        grass.update(Gdx.graphics.getDeltaTime());
        controller.update(grass);
        sun.update(Gdx.graphics.getDeltaTime());
        tree.update(Gdx.graphics.getDeltaTime());
        collide();



    }

    public void collide(){
        if(grass.getBounds().overlaps(sun.getBounds())){
            System.out.println("rem best girl");
        }

        sun.getBounds().setPosition(sun.getPosition().x,sun.getPosition().y);
        grass.getBounds().setPosition(grass.getPosition().x,grass.getPosition().y);
    }

    public void dispose() {
        batch.dispose();
        shapeRenderer.dispose();
    }
}