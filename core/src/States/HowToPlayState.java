/*
 * This class explains how to play as tank 1 and tank 2
 */
package States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.MyGdxGame;

/**
 *
 * @author kulla6503, pawar5658, dhila4674
 */
class HowToPlayState extends State {
    // Create instance variables
    // Instance variable for background
    private Texture bg;
    // Instance variable for how to play button
    private Texture ImageOfHowToPlayMenu;

    public HowToPlayState(Statemanager gsm) {
        // Call the state manager from the super class 
        super(gsm);
        // Set the camera view to be correct for the game
        setCameraView(MyGdxGame.WIDTH, MyGdxGame.HEIGHT);
        // Set the camera position to be correct for the game
        setCameraPosition(getViewWidth() / 2, getViewHeight() / 2);
        // Creates the texture of the background
        bg = new Texture("tankBackground.png");
        // Creates the texture of the how to play screen
        ImageOfHowToPlayMenu = new Texture("HowToPlayMenu.png");
    }

    /**
     * Method used to draw the images
     * @param batch
     */
    @Override
    public void render(SpriteBatch batch) {
        // Sets the camera position
        batch.setProjectionMatrix(getCombinedCamera());
        // Starts drawing all the images
        batch.begin();
        // Draws the background
        batch.draw(bg, 0, 0, getViewWidth(), getViewHeight());
        // Draws the instructions
        batch.draw(ImageOfHowToPlayMenu, 0, 0, getViewWidth(), getViewHeight());
        // Ends the drawing
        batch.end();
    }

    /**
     * The update is empty, nothing to update
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
            // Gets the mouse clicks
            Vector3 touch = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);
            // If the screen is clicked then return to the menu
            if (touch.x > 0 && touch.x < getViewWidth() && touch.y > 0 && touch.y < getViewHeight()) {
                // Calls the state manager to change the states
                Statemanager gsm = getStateManager();
                // Goes back to the menu state
                gsm.push(new MenuState(gsm));
            }
        }
    }
    /**
     * Method that disposes images
     */
    @Override
    public void dispose() {
        // Disposes the images in the state
        bg.dispose();
        ImageOfHowToPlayMenu.dispose();

    }
}
