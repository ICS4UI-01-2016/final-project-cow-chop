/*
 * This class creates the properties for the green tank
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
    // Allows the tank to have a texture

    private Texture tankg;
    // Allows the tank to accelerate
    private float Accelerate = 2;
    // Allows the tank to deccelerate
    private float deccelerate = 2;
    // Creates a rectangle for the tank for bounds
    private Rectangle bounds;
    // Allows the tank to hold a position
    private Vector3 position;

    public Tanks2(int x, int y) {
        // sets the tank into the game
        position = new Vector3(x, y, 0);
        // Creates the texture for the tank
        tankg = new Texture("Tank5.png");
        // Creates the parameters for the tank
        bounds = new Rectangle(position.x, position.y, tankg.getWidth(), tankg.getHeight());
        // Sets the x.position of the tank to x
        position.x = x;
        // Sets the y.position of the tank to y
        position.y = y;
    }

    public void render(SpriteBatch batch) {
        // Draws the green tank
        batch.draw(tankg, position.x, position.y);
    }

    public void update(float deltaTime) {
        // Updating the certain bounds of tankX
        bounds.setPosition(position.x, position.y);
    }

    public float getX() {
        // Returns the x position of the tank
        return position.x;
    }

    public float getY() {
        // Returns the y position of the tank
        return position.y;
    }

    public Rectangle getBounds() {
        //This return the hit boxes
        return bounds;
    }

    public float Accelerate() {
        //this runs the speed of the tank with the x position to move right
        return position.x = position.x + Accelerate;
    }

    public float Deccelerate() {
        // this runs the speed of the tank with the x position to move left
        return position.x = position.x - deccelerate;
    }

    public void dispose() {
        //this gets rid of tank when the game ends
        tankg.dispose();
    }
}
