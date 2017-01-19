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
    private Texture tank1;
    private Texture tank2;
    private final int WIDTH = MyGdxGame.WIDTH;
    private final int HEIGHT = MyGdxGame.HEIGHT;
    private Texture bg;
    
    
    public PlayState(Statemanager sm){ 
        super(sm);
        bg = new Texture("Background.png");
        tank1 = new Texture ("tank3..png");
        tank2 = new Texture ("tank4.png");
        
    }
    
    @Override
    public void render(SpriteBatch batch){    
       batch.begin();
        batch.draw(bg, getViewWidth(), getViewHeight()); 
        batch.draw(tank1, 20, 25);
        batch.draw(tank2, 525, 530);
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
