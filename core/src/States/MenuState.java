/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package States;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 *
 * @author kulla6503
 */
public class MenuState extends State{

  
    
    public MenuState(Statemanager gsm){
        super(gsm);
    }  
    
    
    @Override
    public void render(SpriteBatch batch) {
        batch.begin();
        
        batch.end();
    }

    @Override
    public void update(float deltaTime) {
        
    }

    @Override
    public void handleInput() {
        
    }

    @Override
    public void dispose() {
        
    }
    
    
}
