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
    // Create instance variables

    private Stack<State> states;

    /**
     * Method to construct the state manager
     */
    public Statemanager() {
        states = new Stack<State>();
    }

    /**
     * Method to move between states (pushing)
     * @param s
     */
    public void push(State s) {
        states.push(s);
    }

    /**
     * Method to move between states (popping)
     */
    public void pop() {
        State s = states.pop();
        s.dispose();
    }

    /**
     * Method to set states
     * @param s
     */
    public void set(State s) {
        pop();
        push(s);
    }

    /**
     * Method that updates the states
     * @param deltaTime
     */
    public void update(float deltaTime) {
        states.peek().update(deltaTime);
    }

    /**
     * Method that renders the states
     * @param batch
     */
    public void render(SpriteBatch batch) {
        states.peek().render(batch);
    }

    /**
     * Method that handles the input of the states
     */
    public void handleInput() {
        states.peek().handleInput();
    }
}
