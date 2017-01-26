/*
 * This class allows the player(s) to play the game
 */
package States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.Bullet;
import com.mygdx.game.Bullet2;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.Tanks;
import com.mygdx.game.Tanks2;
import java.util.Iterator;

/**
 *
 * @author pawar5658, kulla6503, dhila4674
 */
public class PlayState extends State {

    // Creates the first tank
    private Tanks tankr;
    // Creates the second tank
    private Tanks2 tankg;
    // Creates the background texture
    private Texture bg;
    // Creates the array for bullets
    private Array<Bullet> bullet;
    // Creates the array for bullets2
    private Array<Bullet2> bullet2;

    public PlayState(Statemanager sm) {
        // Super the Statemanager class
        super(sm);
        // Makes the bullet class a new array
        bullet = new Array<Bullet>();
        // Makes the bullet2 class a new array
        bullet2 = new Array<Bullet2>();
        // Makes the tankr a new tank
        tankr = new Tanks(225, 15);
        // Makes the tankg a new tank
        tankg = new Tanks2(225, 530);
        // Makes the background a new texture in the class
        bg = new Texture("Background.png");
    }

    /**
     * Method used to draw the images
     *
     * @param batch
     */
    @Override
    public void render(SpriteBatch batch) {
        batch.begin();
        // Draw background of game 
        batch.draw(bg, getCameraX() - getViewWidth() / 2, getCameraY() - getViewHeight() / 2, MyGdxGame.WIDTH, MyGdxGame.HEIGHT);
        // Draw tanks 
        tankr.render(batch);
        tankg.render(batch);
        // This will render each bullet in the bullet class
        for (int i = 0; i < bullet.size; i++) {
            bullet.get(i).render(batch);
        }
        // This will render each bullet in the bullet2 class
        for (int i = 0; i < bullet2.size; i++) {
            bullet2.get(i).render(batch);
        }
        // End the renderings
        batch.end();
    }

    /**
     * This updates the class every time something updates in the game
     *
     * @param deltaTime
     */
    @Override
    public void update(float deltaTime) {
        // Updates tankr
        tankr.update(deltaTime);
        // Updates tankg
        tankg.update(deltaTime);
        // Updating the bullets so they move
        for (int i = 0; i < bullet.size; i++) {
            bullet.get(i).update(deltaTime);
        }
        for (int i = 0; i < bullet2.size; i++) {
            bullet2.get(i).update(deltaTime);
        }
        // This is to check if the bullet has gone off screen
        Iterator<Bullet> rs = bullet.iterator();
        while (rs.hasNext()) {
            Bullet up = rs.next();
            if (up.getY() > 600) {
                rs.remove();
                // This checks to see if a bullet collided with a tank 
            } else if (up.collides(tankg)) {
                Statemanager gsm = getStateManager();
                gsm.pop();
                System.out.println("RED WINS");
            }
        }
        // This is to check if the bullet has gone off screen
        Iterator<Bullet2> gs = bullet2.iterator();
        while (gs.hasNext()) {
            Bullet2 down = gs.next();
            if (down.getY() < 0) {
                gs.remove();
                // This checks to see if a bullet collided with a tank
            } else if (down.collides(tankr)) {
                Statemanager gsm = getStateManager();
                gsm.pop();
                System.out.println("GREEN WINS");
            }
        }
    }

    /**
     * Method that disposes images
     */
    @Override
    public void dispose() {
        // Disposes the images 
        // Disposes the background
        bg.dispose();
        // Disposes tankr
        tankr.dispose();
        // Disposes tankg
        tankg.dispose();
    }

    /**
     * \
     * Method handle the users click
     */
    @Override
    public void handleInput() {
        // If the D key is pressed, tankr will accelerate
        if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            tankr.Accelerate();
        }
        // If the A key is pressed, tankr will deccelerate
        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            tankr.Deccelerate();
        }
        // If the right arrow key key is pressed, tankg will accelerate
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            tankg.Accelerate();
        }
        // If the left arrow key key is pressed, tankr will deccelerate
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            tankg.Deccelerate();
        }
        // If the W key is pressed, tankr will shoot a bullet
        if (Gdx.input.isKeyJustPressed(Input.Keys.W)) {
            bullet.add(new Bullet(tankr.getX() + 7, tankr.getY() + 45));
        }
        // If the up arrow key key is pressed, tankg will shoot a bullet
        if (Gdx.input.isKeyJustPressed(Input.Keys.UP)) {
            bullet2.add(new Bullet2(tankg.getX() + 10, tankg.getY() - 7));
        }
    }
}
