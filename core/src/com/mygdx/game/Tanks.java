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
    private Rectangle bounds;
    private Vector3 position;

    public Tanks(int x, int y) {
        // sets the tank into the game
        position = new Vector3(x,y,0); 
        tankr = new Texture ("Tank6.png"); 
        bounds = new Rectangle(position.x,position.y,tankr.getWidth(),tankr.getHeight());
        position.x = x;
        position.y = y;
    }
    
    // Draws the red tank
    public void render(SpriteBatch batch) {
        batch.draw(tankr, position.x, position.y);
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
    
    // Updates the hit box of the tank
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
        tankr.dispose();
    }
}

