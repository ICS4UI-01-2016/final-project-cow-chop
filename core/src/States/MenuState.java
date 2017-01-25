/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.MyGdxGame;

/**
 *
 * @author kulla6503
 */
public class MenuState extends State {

    private Texture bg;
    //
    private Texture ImageOfplayButton;
    private Rectangle playbutton;
    // How To Play option instance variables
    private Texture ImageOfHowToPlayButton;
    private Rectangle HowToPlayButton;

    public MenuState(Statemanager gsm) {


        super(gsm);
        //
        bg = new Texture("tankBackground");
        //
        ImageOfplayButton = new Texture("playButton.png");
        // 
        playbutton = new Rectangle(419, 409, 176, 50);
        //
        ImageOfHowToPlayButton = new Texture("playButton.png");
        //
        HowToPlayButton = new Rectangle(110, 409, 175, 50);
        // 
        setCameraView(MyGdxGame.WIDTH, MyGdxGame.HEIGHT);
    }

    @Override
    public void render(SpriteBatch batch) {
        
        // Sets camera properly
        batch.setProjectionMatrix(getCombinedCamera());
        // Beginning the drawings
        batch.begin();
        // Drawing the rectangle behind the Play option
        batch.draw(ImageOfplayButton, playbutton.x, playbutton.y, playbutton.width, playbutton.height);
        // Drawing the rectangle behind the How To Play option
        batch.draw(ImageOfHowToPlayButton, HowToPlayButton.x, HowToPlayButton.y, HowToPlayButton.width, HowToPlayButton.height);
        // Drawing the background image
        batch.draw(bg, 0, 0, getViewWidth(), getViewHeight());
        batch.end();

    }

    @Override
    public void update(float deltaTime) {
        
    }

    @Override
    public void handleInput() {
        
        //Check if parameter is clicked on, to screen menu screens
        if (Gdx.input.justTouched()) {

            //get the mouse click/touch position
            Vector3 touch = new Vector3(Gdx.input.getX(), Gdx.input.getY(),0);
      
        
            
            // Check if button is pressed
            if(playbutton.contains(touch.x, touch.y)){
               
                Statemanager gsm = getStateManager();
                gsm.push(new PlayState(gsm));

            } else if (HowToPlayButton.contains(touch.x, touch.y)) {
              
                Statemanager gsm = getStateManager();
                gsm.push(new HowToPlayState(gsm));


            }
        }
       
    }

    @Override
    public void dispose() {
        // Dispose all the images used within this state
        bg.dispose();
        // Dispose of the buttons on menu 
        ImageOfHowToPlayButton.dispose();
        ImageOfplayButton.dispose();
    }
}
