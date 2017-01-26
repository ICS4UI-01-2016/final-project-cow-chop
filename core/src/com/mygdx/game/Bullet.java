/*
 * This class creates the properties for bullet
 */
package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

/**
 *
 * @author pawar5658, kulla6503, dhila4674
 */
public class Bullet {

    // Private variables 
    // Creates the x position for the bullet
    private float bulletX;
    // Creates the y position for the bullet
    private float bulletY;
    // Creates the texture for the bullet
    private Texture bulletTexture;
    // Creates the bounds for the bullet
    private Rectangle bounds;
    // Allows the bullet to have velocity and go up the screen
    private float BULLET_VELOCITY_UP;
    // Allows the bullet to have velocity
    private double bulletvelocity;

    public Bullet(float x, float y) {
        // This makes the bullet and the speed
        // Allows bulletX to equal X
        bulletX = x;
        // Allows bulletY to equal Y
        bulletY = y;
        // Creates the texture for the bullet
        bulletTexture = new Texture("bullet3.png");
        // Sets the parameters for the rectangle
        bounds = new Rectangle(bulletX, bulletY, bulletTexture.getWidth(), bulletTexture.getHeight());
        // Creates the velocity for the bullet to go at different speeds
        bulletvelocity = 50 + Math.random() * 100;
        // Creates velocity for the bullet
        BULLET_VELOCITY_UP = (float) bulletvelocity;
    }

    /**
     * This updates the screen when anything changes in the game
     *
     * @param deltaTime
     */
    public void update(float deltaTime) {
        // Add the velocity to the bullet 
        bulletY += BULLET_VELOCITY_UP * deltaTime;
        // Update the bullet x and bullet y positions 
        bounds.setPosition(bulletX, bulletY);
    }

    public float getY() {
        // Returns the Y bounds while it moves
        return bulletY;
    }

    public Rectangle Bounds() {
        // Returns the bounds for the rectangle
        return bounds;
    }

    /**
     * Method used to draw the images
     *
     * @param batch
     */
    public void render(SpriteBatch batch) {
        // Draws the bullet 
        batch.draw(bulletTexture, bulletX, bulletY);
    }

    /**
     * Method that disposes images
     */
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
