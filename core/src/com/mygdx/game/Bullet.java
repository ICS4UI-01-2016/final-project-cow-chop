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
    private final float BULLET_VELOCITY_UP = 150;

    // 
    public Bullet(float x, float y) {
        // 
        bulletX = x;
        bulletY = y;
        bulletTexture = new Texture("");
        bounds = new Rectangle(bulletX, bulletY, bulletTexture.getWidth(), bulletTexture.getHeight());

    }

    // 
    public void update(float deltaTime) {

        // Add the velocity to the bullet 
        bulletY += BULLET_VELOCITY_UP * deltaTime;

        // Update the bullet x and bullet y positions 
        bounds.setPosition(bulletX, bulletY);
    }
    //

    public float getY() {
        // 
        return bulletY;
    }

    // 
    public void render(SpriteBatch batch) {
        // 
        batch.draw(bulletTexture, bulletX, bulletY);
    }

    // 
    public void dispose() {
        // 
        bulletTexture.dispose();
    }

    // 
    public boolean collides(Tanks2 surround) {
        // 
        if (bounds.overlaps(surround.getBounds())) {
            return true;
        }

        return false;
    }
}
