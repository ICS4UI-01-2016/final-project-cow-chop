/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.awt.Graphics;

/**
 *
 * @author kulla6503
 */
public class Maze {
   
    private int WIDTH = MyGdxGame.WIDTH;
    private int HEIGHT = MyGdxGame.HEIGHT;
    
    public void PaintComponent(Graphics g){
        g.clearRect(0,0,WIDTH,HEIGHT);
    }
    
    public void render(SpriteBatch batch){
        
    }
    
    public void dispose(){
        
    }
                        
}
