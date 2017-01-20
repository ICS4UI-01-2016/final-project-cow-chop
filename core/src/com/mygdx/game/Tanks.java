/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

/**
 *
 * @author kulla6503
 */
public class Tanks {
    private Texture tankg;
    private Texture tankr;
    private final float Accelerate = 25;
    private Vector3 velocity;
    private Vector3 position;
    private Rectangle bounds;
    
    public Tanks (int x, int y, int tank){
        position = new Vector3(x,y,0);
        velocity = new Vector3(Accelerate,0,0);
        if(tank == 1){
        tankg = new Texture("tank5.png");
        }
        if(tank == 2){
        tankr = new Texture("tank6.png");
        }
        
    }
   

    public void Accelerate(){
        
    }
    
   
}
