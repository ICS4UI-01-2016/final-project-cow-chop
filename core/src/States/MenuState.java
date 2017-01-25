/*
 * This class shows the first screen that appears when the game is run. 
 * The user has the option to play the game right away or see the controls.
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
 * @author kulla6503, pawar5658, dhila4674
 */
public class MenuState extends State {

    //Creates the background
    private Texture bg;
    //Make the button to start palying 
    private Texture playButton;
    // How To Play option instance variables
    private Texture HowToPlayButton;

    public MenuState(Statemanager gsm) {
        //sets the camera in one spot to show the game
        super(gsm);
        // Set the camera view to be correct for the game
        setCameraView(MyGdxGame.WIDTH, MyGdxGame.HEIGHT);
        // Set the camera position to be correct for the game
        setCameraPosition(getViewWidth() / 2, getViewHeight() / 2);
        // Makes the background of the menu screen
        bg = new Texture("tankBackground.png");
        // Makes the play button in the menu screen
        playButton = new Texture("playButton.png");
        // Makes the how to play button in the menu screen
        HowToPlayButton = new Texture("HowToPlayButton.png");

    }

    /**
     * Method used to draw the images
     *
     * @param batch
     */
    @Override
    public void render(SpriteBatch batch) {
        // Sets the camera position
        batch.setProjectionMatrix(getCombinedCamera());
        // Starts drawing all the images
        batch.begin();
        // Draw the height and width of the background
        batch.draw(bg, 0, 0, getViewWidth(), getViewHeight());
        // Draws the height and width of the how to play button
        batch.draw(HowToPlayButton, getViewWidth() / 2 - HowToPlayButton.getWidth() / 2, getViewHeight() / 2);
        // Draws the height and width of the play button
        batch.draw(playButton, getViewWidth() / 2 - 50, getViewHeight() / 2 - 100, 100, 50);
        // End drawings
        batch.end();
    }

    /**
     * The update is empty, nothing to update
     * @param deltaTime
     */
    @Override
    public void update(float deltaTime) {
    }

    /**
     * Method handle the users click
     */
    @Override
    public void handleInput() {
        if (Gdx.input.justTouched()) {
            // Gets the mouse click position
            Vector3 touch = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);
            // Checks if the button is pressed, gets the width of the play button 
            float playButtonX = getViewWidth() / 2 - playButton.getWidth() / 2;
            // Checks if the button is pressed, gets height of the play button
            float playButtonY = getViewHeight() / 2;
            // Checks if the button is pressed, gets width of the how to play button
            float HowToPlayButtonX = getViewWidth() / 2 - 100;
            // Checks if the button is pressed, gets height of the how to play button
            float HowToPlayButtonY = getViewHeight() / 2 - 130;

            // When the play button is clicked on, the screen is changed to the actual game(playstate)
            if (touch.x > playButtonX && touch.x < playButtonX + playButton.getWidth()
                    && touch.y > playButtonY && touch.y < playButtonY + playButton.getHeight()) {
                // The state manager is called in order to change the states 
                Statemanager gsm = getStateManager();
                // Created a new game state on top of the Menu state
                gsm.push(new PlayState(gsm));
            }

            // When the how to play button is clicked on, the screen is changed to the control screen(HowToPlayState)
            if (touch.x > HowToPlayButtonX && touch.x < HowToPlayButtonX + 200
                    && touch.y > HowToPlayButtonY && touch.y < HowToPlayButtonY + 100) {
                // The state manager is called in order to change the states
                Statemanager gsm = getStateManager();
                // Created a new how to play state on top of the Menu state
                gsm.push(new HowToPlayState(gsm));
            }
        }
    }

    /**
     * Method that disposes images
     */
    @Override
    public void dispose() {
        // Dispose all the images used within this state
        bg.dispose();
        // Dispose of the buttons on menu 
        HowToPlayButton.dispose();
        // Dispose the button for playing
        playButton.dispose();
    }
}
