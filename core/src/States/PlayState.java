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
    private Tanks tanks;
    private final int WIDTH = MyGdxGame.WIDTH;
    private final int HEIGHT = MyGdxGame.HEIGHT;
    private Texture bg;
    
    
    public PlayState(Statemanager sm){
        
        super(sm);
        
        bg = new Texture("Background.png");
        
    }
    
    @Override
    public void render(SpriteBatch batch){
      
        
       batch.begin();
        
        batch.draw(bg, getViewWidth(), getViewHeight());
        
        
                
        batch.end();
    }
    
    @Override
    public void update(float deltaTime){
        
    }
    
    
    @Override
     public void dispose(){
         
     }

    @Override
    public void handleInput() {
        
    }
            
}
