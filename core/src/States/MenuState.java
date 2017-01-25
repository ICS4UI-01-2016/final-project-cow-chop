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

    //
    private Texture bg;
    //
    private Texture playButton;
    // How To Play option instance variables
    private Texture HowToPlayButton;

    public MenuState(Statemanager gsm) {



        super(gsm);
        setCameraView(MyGdxGame.WIDTH, MyGdxGame.HEIGHT);
        setCameraPosition(getViewWidth() / 2, getViewHeight() / 2);


        bg = new Texture("tankBackground.png");
        playButton = new Texture("playButton.png");
        HowToPlayButton = new Texture("HowToPlayButton.png");

    }

    @Override
    public void render(SpriteBatch batch) {

        // 
        batch.setProjectionMatrix(getCombinedCamera());
        // start drawing stuff 
        batch.begin();
        // the getviewwidth and height commands are used to stretch the screen according to your screen (phone or pc)
        batch.draw(bg, 0, 0, getViewWidth(), getViewHeight());
        batch.draw(HowToPlayButton, getViewWidth() / 2 - HowToPlayButton.getWidth() / 2, getViewHeight() / 2);
        batch.draw(playButton, getViewWidth() / 2 - 50, getViewHeight() / 2 - 100, 100, 50);
        batch.end();

    }

    @Override
    public void update(float deltaTime) {
    }

    @Override
    public void handleInput() {


        if (Gdx.input.justTouched()) {
            // Get the mouse click/touch position
            Vector3 touch = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);
            
            // Checks if the button is pressed, gets the width and height of each button 
            float playButtonX = getViewWidth() / 2 - playButton.getWidth() / 2;
            // Checks if the button is pressed, gets height of the play button
            float playButtonY = getViewHeight() / 2;
            // Checks if the button is pressed, gets width of the play button
            float HowToPlayButtonX = getViewWidth() / 2 - 100;
            // Checks if the button is pressed, gets height of the play button
            float HowToPlayButtonY = getViewHeight() / 2 - 130;


            // When the play button is clicked on, the screen is changed to the the actual game(playstate)
            if (touch.x > playButtonX && touch.x < playButtonX + playButton.getWidth()
                    && touch.y > playButtonY && touch.y < playButtonY + playButton.getHeight()) {
                // The state manager is called inorder to change the states 
                Statemanager gsm = getStateManager();

                // Created a new game state on top of the game state
                gsm.push(new PlayState(gsm));

            }

            // 
            if (touch.x > HowToPlayButtonX && touch.x < HowToPlayButtonX + 200
                    && touch.y > HowToPlayButtonY && touch.y < HowToPlayButtonY + 100) {
                //
                Statemanager gsm = getStateManager();
                //
                gsm.push(new HowToPlayState(gsm));
            }



        }

    }

    @Override
    public void dispose() {
        // Dispose all the images used within this state
        bg.dispose();
        // Dispose of the buttons on menu 
        HowToPlayButton.dispose();
        // 
        playButton.dispose();
    }
}
