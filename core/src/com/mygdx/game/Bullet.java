/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

/**
 *
 * @author pawar5658
 */
public class Bullet {

    // Private variables 
    private float bulletX;
    private float bulletY;
    private Texture bulletTexture;
    private Rectangle bounds;
    private float BULLET_VELOCITY_UP;
    private double bulletvelocity;

    
    public Bullet(float x, float y) {
        //  This makes the bullet and the speed
        bulletX = x;
        bulletY = y;
        bulletTexture = new Texture("bullet3.png");
        bounds = new Rectangle(bulletX, bulletY, bulletTexture.getWidth(), bulletTexture.getHeight());
        bulletvelocity = 50 + Math.random()* 100;
        BULLET_VELOCITY_UP = (float) bulletvelocity;
    }

    
    public void update(float deltaTime) {

        // Add the velocity to the bullet 
        bulletY += BULLET_VELOCITY_UP * deltaTime;

        // Update the bullet x and bullet y positions 
        bounds.setPosition(bulletX, bulletY);
    }
    

    public float getY() {
        // // returns the Y bounds while it moves
        return bulletY;
    }
    
    public Rectangle Bounds(){
        return bounds;
        
    }

    
    public void render(SpriteBatch batch) {
        // Draws the bullet 
        batch.draw(bulletTexture, bulletX, bulletY);
    }

     
    public void dispose() {
        // gets rid of the bullets off screen and when the game ends
        bulletTexture.dispose();
        
    }

    
    public boolean collides(Tanks2 tankg) {
        // This sets the collisions with the bullet that shoot from the red tank 
        // When it hits the green tank
         if (bounds.overlaps(tankg.getBounds())) {
            return true;
        }
        // if it doesn't hit the tank
        return false;
    }
    }

