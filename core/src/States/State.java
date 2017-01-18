/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package States;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 *
 * @author pawar5658
 */
public abstract class State {
    private Statemanager Statemanager;
    
    public State(Statemanager sm){
        Statemanager = sm;
    }
    public abstract void render(SpriteBatch batch);
    public abstract void update(float deltaTime);
    public abstract void handleInput();
    public abstract void dispose();
    
    
    public Statemanager getStateManager(){
        return Statemanager;
    }
}
