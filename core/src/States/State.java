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
 * @author pawar5658
 */
public abstract class State {
    private OrthographicCamera cam;
    private Statemanager stateManager;
    
    public State(Statemanager sm){
        stateManager = sm;
        cam = new OrthographicCamera();
    }
    
    public abstract void render(SpriteBatch batch);
    public abstract void update(float deltaTime);
    public abstract void handleInput();
    public abstract void dispose();
    
    public Statemanager getStateManager(){
        return stateManager;
    }
    
    public OrthographicCamera getCamera(){
        return cam;
    }
    
    public void setCameraView(float width, float height){
        cam.setToOrtho(false, width, height);
        cam.update();
    }
    
    public void setCameraPosition(float x, float y){
        cam.position.x = x;
        cam.position.y = y;
        cam.update();
    }
    
     public Matrix4 getCombinedCamera(){
        return cam.combined;
    }
    
    public float getViewWidth(){
        return cam.viewportWidth;
    }
    
    public float getViewHeight(){
        return cam.viewportHeight;
    }
    
    public float getCameraX(){
        return cam.position.x;
    }
    
    public float getCameraY(){
        return cam.position.y;
    }
    
   
    
}
