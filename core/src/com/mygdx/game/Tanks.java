/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
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
    private boolean turnleft;
    private boolean turnright;
    private float rotation;
    private float spX;
    private float spY;
    private float velocity;
    private Vector3 position;
    private Rectangle bounds;
    
    public Tanks (int x, int y, float spin, int inix, int iniy){
        position = new Vector3(x,y,0);
        tankr = new Texture("tank6.png");
        position.x = inix;
        position.y = iniy;
        bounds = new Rectangle(position.x, position.y,tankr.getWidth(), tankr.getHeight());
        
    } 
    public void render(SpriteBatch batch){
        batch.draw(tankr, position.x, position.y);
        
    }
    
   public void update(float deltaTime){
       
       bounds.setPosition(position.x, position.y);
      
       if(turnleft){
       rotation += 4f * (Math.abs(velocity) / 1.2) ;
      
      
       
       if(turnright){
       rotation -= 4f * (Math.abs(velocity) / 1.2) ;
       }
       
       }
        while (rotation > 360) {
            rotation = rotation - 360;
        }
        while (rotation < 0) {
            rotation = rotation + 360;
        }  
               
        
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
    
    public void turnRight(boolean turnRight){
       turnright = turnRight;
       
    }
    
   public void turnLeft(boolean turnLeft){
       turnleft = turnLeft;
   }
   public float getspX(){
       return spX + velocity;
   }
   
   public float getspY(){
       return spY + velocity;
   }
}
