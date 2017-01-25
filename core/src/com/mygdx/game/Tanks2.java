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
 * @author pawar5658, kulla6503, dhila4674
 */
public class Tanks2 {
    
   private Texture tankg;
    private float Accelerate = 2;
    private float deccelerate = 2; 
    private Rectangle bounds;
    private Vector3 position;

    public Tanks2(int x, int y) {
        // sets the tank into the game
        position = new Vector3(x,y,0); 
        tankg = new Texture ("Tank5.png"); 
        bounds = new Rectangle(position.x,position.y,tankg.getWidth(),tankg.getHeight());
        position.x = x;
        position.y = y;
    }
    
   // Draws the green tank
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

    //This return the hit boxes
    public Rectangle getBounds() {
        return bounds;
    }
    //this runs the speed of the tank with the x position to move right 
     public float Accelerate(){
        return position.x = position.x + Accelerate;
    }
     
    // this runs the speed of the tank with the x position to move left
    public float Deccelerate(){
        return position.x = position.x - deccelerate;
    } 

   
    //this gets rid of tank when the game ends
    public void dispose() {
        tankg.dispose();
    }
    
}
