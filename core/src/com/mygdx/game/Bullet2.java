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
public class Bullet2 {

    // Private variables 
    private float bulletX;
    private float bulletY;
    private Texture bulletTexture;
    private Rectangle bounds;
    private float BULLET_VELOCITY_UP;
    private double bulletvelocity;

    // This is the class the makes the bullet and the speed
    public Bullet2(float x, float y) {
        bulletX = x;
        bulletY = y;
        bulletTexture = new Texture("bullet3.png");
        bounds = new Rectangle(bulletX, bulletY, bulletTexture.getWidth(), bulletTexture.getHeight());
        bulletvelocity = 50 + Math.random()* 100;
        BULLET_VELOCITY_UP = (float) bulletvelocity;
    }

   
    public void update(float deltaTime) {

        // Add the velocity to the bullet 
        bulletY -= BULLET_VELOCITY_UP * deltaTime;

        // Update the bullet x and bullet y positions 
        bounds.setPosition(bulletX, bulletY);
    }
   

    public float getY() {
        // returns the Y bounds while it moves
        return bulletY;
    }

    // 
    public void render(SpriteBatch batch) {
        // Draws the bullet
        batch.draw(bulletTexture, bulletX, bulletY);
    }

   
    public void dispose() {
        // Get rid of the bullets when they are off screen and the game is closed
        bulletTexture.dispose();
    }

   
    public boolean collides(Tanks tankr) {
        // this sets the collisions with the red tank wif it hits
        if (bounds.overlaps(tankr.getBounds())) {
            return true;
        }
       // this is if it doesn't it the tank
        return false;
    
    }
}
