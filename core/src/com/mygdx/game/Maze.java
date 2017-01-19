/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game;



import java.awt.Rectangle;

/**
 *
 * @author kulla6503
 */
public class Maze {
    private int WIDTH = MyGdxGame.WIDTH;
    private int HEIGHT = MyGdxGame.HEIGHT;
    Rectangle walls[] = new Rectangle[16];
    
    
   public void Maze(){
       walls[0] = new Rectangle(525, 85, 70, 20);
       walls[1] = new Rectangle(380, 5, 20, 100);
       walls[2] = new Rectangle(5, 495, 70, 20);
       walls[3] = new Rectangle(225, 495, 20, 100);
       walls[4] = new Rectangle(75, 100, 25, 50);
       walls[5] = new Rectangle(350, 425, 20, 105);
       walls[6] = new Rectangle(500, 200, 25, 130);
       walls[7] = new Rectangle(475, 405, 125, 20);  
       walls[8] = new Rectangle(250, 275, 175, 20);
       walls[9] = new Rectangle(125, 250, 20, 180);
       walls[10] = new Rectangle(200, 365, 105, 20);
       walls[11] = new Rectangle(300, 175, 20, 100);
       walls[12] = new Rectangle(75, 150, 100, 25);
       walls[13] = new Rectangle(5, 325, 120, 20);
       walls[14] = new Rectangle(175, 70, 25, 105);
       walls[15] = new Rectangle(370, 510, 80, 20);
       
   }
    
    public void dispose(){
        
    }
                        
}
