/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package States;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.Stack;

/**
 *
 * @author pawar5658
 */
public class Statemanager {
    private Stack<State> states;
    
    public Statemanager(){
        states = new Stack<State>();
    }
    
    public void push(State s){
        states.push(s);
    }
    
    public void pop(){
        State s = states.pop();
        s.dispose();
    }
    
    public void set(State s){
        pop();
        push(s);
    }
    
    public void update(float deltaTime){
        states.peek().update(deltaTime);
    }
    
    public void render(SpriteBatch batch){
        states.peek().render(batch);
    }

    public void handleInput() {
        states.peek().handleInput();
    }
    
}
