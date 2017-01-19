/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game;


import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author kulla6503
 */
public class Maze {
    private int WIDTH = MyGdxGame.WIDTH;
    private int HEIGHT = MyGdxGame.HEIGHT;
    private Texture mazePicture; 
    public Maze(int x, int y){ 
    
   
    mazePicture = new Texture("Background.png");
    
    }
    
    
    public void PaintComponent(Graphics g){
        g.clearRect(0,0,WIDTH,HEIGHT);
    }
    
    public void render(SpriteBatch batch){
        batch.begin();
        
        
        batch.end();
    }
    
    public void dispose(){
        
    }
                        
}
