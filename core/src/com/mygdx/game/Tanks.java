/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

/**
 *
 * @author kulla6503
 */
public class Tanks {
    private Texture tankr;
    private float Accelerate = 2;
    private float deccelerate = 2;
    private Vector3 position;
    private Rectangle bounds;
    
    public Tanks (int x, int y){
        position = new Vector3(x,y,0);
        tankr = new Texture("tank6.png");
        bounds = new Rectangle(position.x, position.y, tankr.getWidth(), tankr.getHeight());
        
        
    } 
    public void render(SpriteBatch batch){
        batch.draw(tankr, position.x, position.y);
    }
    
   public void update(float deltaTime){
       bounds.setPosition(position.x, position.y);
       
   }
    public float getX(){
        return position.x;
        
    } 
    
    public float getY(){
        return position.y;
    }
 
    public Rectangle getBounds(){
        return bounds;
    }
    public void dispose(){
        tankr.dispose();
    }
    public float Accelerate(){
        return position.x = position.x + Accelerate;
    }
    public float Deccelerate(){
        return position.x = position.x - deccelerate;
    }
    
   
}
