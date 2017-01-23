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
    private final float Accelerate = 25;
    private Vector3 position;
    private Rectangle bounds;
    
    public Tanks2 (int x, int y){
        position = new Vector3(x,y,0);
        tankg = new Texture("tank5.png");
        bounds = new Rectangle(position.x, position.y, tankg.getWidth(), tankg.getHeight());
    } 
    
    public void render(SpriteBatch batch){
        batch.draw(tankg, position.x, position.y);
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
        tankg.dispose();
    }
    
    public float Accelerate(){
        return Accelerate;
    }
    
}
