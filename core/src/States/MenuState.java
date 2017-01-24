/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package States;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

/**
 *
 * @author kulla6503
 */
public class MenuState extends State{
    private Texture bg;
    //
    private Texture button;
    private Rectangle playButton;
    // How To Play option instance variables
    private Texture HowToPlayButton;
    private Rectangle HowToPlayButton;
  
    
    public MenuState(Statemanager gsm){
        super(gsm); bg = new Texture("bg.png");
        playButton = new Texture("playButton.png");
        setCameraView(FlappyBird.WIDTH, FlappyBird.HEIGHT);
        setCameraPosition(getViewWidth()/2, getViewHeight()/2);    }  
    
    
    @Override
    public void render(SpriteBatch batch) {  
        // Sets camera properly
        batch.setProjectionMatrix(getCombinedCamera());
        // Beginning the drawings
        batch.begin();
        // Drawing the rectangle behind the Play option
        batch.draw(picOfPlayButton, playButton.x, playButton.y, playButton.width, playButton.height);
        // Drawing the rectangle behind the How To Play option
        batch.draw(picOfHowToPlayButton, howToPlayButton.x, howToPlayButton.y, howToPlayButton.width, howToPlayButton.height);
        // Drawing the rectangle behind the description option
        batch.draw(picOfDescriptionButton, descriptionButton.x, descriptionButton.y, descriptionButton.width, descriptionButton.height);
        // Drawing the background image
        batch.draw(bg, 0, 0, getViewWidth(), getViewHeight());
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
