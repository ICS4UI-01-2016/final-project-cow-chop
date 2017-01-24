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
        bg = new Texture("");
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
        // Get the mouse click/touch position of the user
        Vector3 touch = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);

        // 
        if (touch.x >= HowToPlayButton.x && touch.x <= HowToPlayButton.x + HowToPlayButton.width
                && touch.y >= HowToPlayButton.y && touch.y <= HowToPlayButton.y + HowToPlayButton.height) {
            // 
            Statemanager gsm = getStateManager();



        }

        // If the "Play" button is clicked on, change the screen to Choose Player Amount screen
        if (touch.x >= playbutton.x && touch.x <= playbutton.x + playbutton.width
                && touch.y >= playbutton.y && touch.y <= playbutton.y + playbutton.height) {
            // Call the state manager in order to change states!
            Statemanager gsm = getStateManager();

        }
    }

    @Override
    public void dispose() {
        // Dispose all the images used within this state
        bg.dispose();

        ImageOfHowToPlayButton.dispose();
        ImageOfplayButton.dispose();
    }
}
