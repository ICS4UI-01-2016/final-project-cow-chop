package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MyGdxGame extends ApplicationAdapter {
	public static final int WIDTH = 600;
        public static final int HEIGHT = 600;
    
        private SpriteBatch batch;
	
	
	@Override
	public void create () {
		batch = new SpriteBatch();
	        Gdx.gl.glClearColor(2, 1, 1, 2);
	}

	@Override
	public void render () {
		
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	
	}
}
