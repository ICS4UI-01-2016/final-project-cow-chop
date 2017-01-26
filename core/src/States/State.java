/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package States;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Matrix4;

/**
 *
 * @author pawar5658, kulla6503, dhila4674
 */
public abstract class State {
    private OrthographicCamera cam;
    private Statemanager stateManager;
    
    public State(Statemanager sm){
        stateManager = sm;
        cam = new OrthographicCamera();
    }
    // Create the abstract method for a state
    public abstract void render(SpriteBatch batch);
    // Create the abstract method for a state
    public abstract void update(float deltaTime);
    // Create the abstract method for a state
    public abstract void handleInput();
    // Create the abstract method for a state
    public abstract void dispose();
    /**
     * State manager is returned 
     * @return state manager
     */
    public Statemanager getStateManager(){
        return stateManager;
    }
    /**
     * orthographic cameraReturn is returned 
     * @return the camera
     */
    public OrthographicCamera getCamera(){
        return cam;
    }
    /**
     * Camera's current view is set 
     *
     * @param width the width of the camera
     * @param height the heigh of the camera
     */
    public void setCameraView(float width, float height){
        cam.setToOrtho(false, width, height);
        cam.update();
    }
     /**
     * Camera's current position is set 
     *
     * @param x the x value of the camera
     * @param y the y value of the camera
     */
    public void setCameraPosition(float x, float y){
        cam.position.x = x;
        cam.position.y = y;
        cam.update();
    }
    /**
     * Return the combined camera
     * @return the combined camera
     */
     public Matrix4 getCombinedCamera(){
        return cam.combined;
    }
    /**
     * Get the camera's view width
     *
     * @return the camera's view width
     */
    public float getViewWidth(){
        return cam.viewportWidth;
    }
    
    /**
     * Get the camera's view height
     * @return the camera's view height
     */
    public float getViewHeight(){
        return cam.viewportHeight;
    }
    
    /**
     * Get the camera's x position
     * @return the camera's x position
     */
    public float getCameraX(){
        return cam.position.x;
    }
    
    /**
     * Get the camera's y position 
     * @return the camera's y position
     */
    public float getCameraY(){
        return cam.position.y;
    }
    
   
    
}
