/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.Bullet;
import com.mygdx.game.Maze;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.Tanks;
import com.mygdx.game.Tanks2;
import java.awt.Graphics;
import java.util.Iterator;

/**
 *
 * @author kulla6503
 */
public class PlayState extends State {

    private Tanks tankr;
    private Tanks2 tankg;
    private Texture bg;
    private Array<Bullet> bullet;

    public PlayState(Statemanager sm) {
        super(sm);
        bullet = new Array<Bullet>();
        tankr = new Tanks(225,15);
        tankg = new Tanks2(225, 530);
        bg = new Texture("Background.png");



    }

    @Override
    public void render(SpriteBatch batch) {
        // Getting the camera 
        
        batch.begin();

        // Draw background of game 
        batch.draw(bg, getCameraX() - getViewWidth() / 2, getCameraY() - getViewHeight() / 2, MyGdxGame.WIDTH, MyGdxGame.HEIGHT);

        // Draw tanks 
        tankr.render(batch);
        tankg.render(batch);
    
            batch.end();
        }
    
    
    @Override
    public void update(float deltaTime) {
        tankr.update(deltaTime);
        // Updating the bullets 
        for (int i = 0; i < bullet.size; i++) {
            bullet.get(i).update(deltaTime);
        }
    }

    @Override
    public void dispose() {
        bg.dispose();
        tankr.dispose();


    }

    @Override
    public void handleInput() {
        //
        if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            //
            tankr.Accelerate();
        }
        //
        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            //
            tankr.Deccelerate();
        }

//
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            //
            tankg.Accelerate();
        }
        //
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            //
            tankg.Deccelerate();
        }
    }
}
