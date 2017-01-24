package com.mygdx.game;

import States.MenuState;
import States.PlayState;
import States.State;
import States.Statemanager;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MyGdxGame extends ApplicationAdapter {

    public static final int WIDTH = 450;
    public static final int HEIGHT = 600;
    private SpriteBatch batch;
    private Statemanager Statemanager;

    @Override
    public void create() {
        batch = new SpriteBatch();
        Gdx.gl.glClearColor(2, 1, 1, 2);
        // 
        Statemanager = new Statemanager();
        // 
        State firstScreen = new MenuState(Statemanager);
        // Loading the First Screen 
        Statemanager.push(firstScreen);
    }

    @Override
    public void render() {

        
        // 
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        // handle input
        Statemanager.handleInput();
        // update the game states
        Statemanager.update(Gdx.graphics.getDeltaTime());
        // draw the screen
        Statemanager.render(batch);
    }

   
    @Override
    public void dispose() {
        batch.dispose();

    }
}
