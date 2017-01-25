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

    // Final width and height of the game 
    public static final int WIDTH = 450;
    public static final int HEIGHT = 600;
    // To draw different pictures 
    private SpriteBatch batch;
    // Manages the states 
    private Statemanager Statemanager;

    // Intitial Setup 
    @Override
    public void create() {
        batch = new SpriteBatch();
        // This colour clears the screen 
        Gdx.gl.glClearColor(2, 1, 1, 2);
        // Creating the State Manager 
        Statemanager = new Statemanager();
        // Creating the first Screen(MenuState) 
        State firstScreen = new MenuState(Statemanager);
        // Loading the First Screen 
        Statemanager.push(firstScreen);
    }

    // Loops the game 
    @Override
    public void render() {
        // This colour clears the scree
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        // Handle the input 
        Statemanager.handleInput();
        // Updating the game states 
        Statemanager.update(Gdx.graphics.getDeltaTime());
        // Drawing the Screen 
        Statemanager.render(batch);
    }

    // Section of the end game 
    @Override
    public void dispose() {
        // Dispose Batch 
        batch.dispose();

    }
}
