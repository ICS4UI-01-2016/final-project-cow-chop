/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package States;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Maze;
import com.mygdx.game.Tanks;

/**
 *
 * @author kulla6503
 */
public class PlayState {
    private Maze[] rects;
    private Tanks tanks;
    
    
    public PlayState(Statemanager sm){
        
        
        rects = new Maze[20];
    }
    
    public void render(SpriteBatch batch){
        rects[20].render(batch);
    }
    
    public void update(float deltaTime){
        
    }
    
    public void handleinput(){
        
    }
     public void dispose(){
         
     }
            
}
