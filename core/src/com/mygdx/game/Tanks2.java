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
 * @author pawar5658
 */
public class Tanks2 {
    
   private Texture tankg;
    private float Accelerate = 2;
    private float deccelerate = 2; 
    private Rectangle bounds;
    private Vector3 position;

    public Tanks2(int x, int y) {
        position = new Vector3(x,y,0); 
        // 
        tankg = new Texture ("Tank5.png"); 
        // 
        bounds = new Rectangle(position.x,position.y,tankg.getWidth(),tankg.getHeight());
        position.x = x;
        position.y = y;
    }
    
   //
    public void render(SpriteBatch batch) {
        batch.draw(tankg, position.x, position.y);
    }
    
     public void update(float deltaTime) {
        // Updating the certain bounds of tankX
        bounds.setPosition(position.x, position.y);
    } 
    

    public float getX() {
        return position.x;
    }
    
    public float getY() {
        return position.y;
    }

    public Rectangle getBounds() {
        return bounds;
    }
    
     public float Accelerate(){
        return position.x = position.x + Accelerate;
    }
     
    // 
    public float Deccelerate(){
        return position.x = position.x - deccelerate;
    } 

   
    //
    public void dispose() {
        tankg.dispose();
    }
    
}
