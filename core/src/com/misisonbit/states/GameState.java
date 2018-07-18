package com.misisonbit.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.misisonbit.Character.Grass;
import com.misisonbit.Character.Grasshopper;
import com.misisonbit.Character.Organisms;
import com.misisonbit.Character.Rabbit;
import com.misisonbit.Character.Sun;
import com.misisonbit.MyGdxGame;
import com.misisonbit.utils.Controller;

public class GameState extends State {
    Grass grass;
    Sun sun;
    Grasshopper grasshopper;
    Controller controller;
    Organisms organisms;
    Rabbit rabbit;

    ShapeRenderer shapeRenderer;

    public GameState(MyGdxGame game) {
        super(game);
        grass = new Grass(300,100);
        sun = new Sun(350,100);
        grasshopper = new Grasshopper(250, 200);
        rabbit = new Rabbit(350, 200);
        controller = new Controller();
        organisms = new Organisms();
        shapeRenderer = new ShapeRenderer();
    }

    public void drawGame() {
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        font.draw(batch,this.getClass().toString(),0,10);
        batch.draw(grass.getTexture(), grass.getPosition().x, grass.getPosition().y);
        batch.draw(sun.getTexture(),sun.getPosition().x,sun.getPosition().y);
        batch.draw(grasshopper.getTexture(), grasshopper.getPosition().x, grasshopper.getPosition().y);
        batch.draw(rabbit.getTexture(),rabbit.getPosition().x,rabbit.getPosition().y);
        batch.end();

        shapeRenderer.setProjectionMatrix(camera.combined);
        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
        shapeRenderer.rect(grass.getPosition().x,grass.getPosition().y,grass.getBounds().getWidth(),grass.getBounds().getHeight());
        shapeRenderer.rect(sun.getPosition().x,sun.getPosition().y,grass.getBounds().getWidth(),grass.getBounds().getHeight());
        shapeRenderer.end();
        controller.draw();
    }

    public void update(float dt) {
        grass.update(Gdx.graphics.getDeltaTime());
        controller.update(organisms);
        sun.update(Gdx.graphics.getDeltaTime());
        collide();
    }

    public void collide(){
    }

    public void dispose() {
        batch.dispose();
        shapeRenderer.dispose();
    }
}