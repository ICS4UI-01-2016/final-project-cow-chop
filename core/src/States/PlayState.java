/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package States;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Matrix4;
import com.mygdx.game.Maze;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.Tanks;
import java.awt.Graphics;

/**
 *
 * @author kulla6503
 */
public class PlayState extends State{
    private Tanks tankr;
  
    private int WIDTH = MyGdxGame.WIDTH;
    private int HEIGHT = MyGdxGame.HEIGHT;
    private Texture bg;
    
    
    public PlayState(Statemanager sm){ 
        super(sm);
        bg = new Texture("Background.png");
        
        tankr = new Tanks(35, 50);
       
    }
    
    @Override
    public void render(SpriteBatch batch){    
       batch.begin();
        batch.draw(bg, getViewWidth(), getViewHeight()*-1); 
        tankr.render(batch);
       
        batch.end();
    }
    
    @Override
    public void update(float deltaTime){
        tankr.update(deltaTime);
        
        
    }
    
    
    @Override
     public void dispose(){
         bg.dispose();
         tankr.dispose();
         
         
     }

    @Override
    public void handleInput() {
        
    }
            
}
