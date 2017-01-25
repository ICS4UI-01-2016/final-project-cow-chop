/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
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
 * @author kulla6503
 */
public class PlayState extends State {

    private Tanks tankr;
    private Tanks2 tankg;
    private Texture bg;
    private Array<Bullet> bullet;
    private Array<Bullet2> bullet2;

    public PlayState(Statemanager sm) {
        super(sm);
        bullet = new Array<Bullet>();
        bullet2 = new Array<Bullet2>();
        tankr = new Tanks(225, 15);
        tankg = new Tanks2(225, 530);
        bg = new Texture("Background.png");
    }

    @Override
    public void render(SpriteBatch batch) {


        batch.begin();

        // Draw background of game 
        batch.draw(bg, getCameraX() - getViewWidth() / 2, getCameraY() - getViewHeight() / 2, MyGdxGame.WIDTH, MyGdxGame.HEIGHT);

        // Draw tanks 
        tankr.render(batch);
        tankg.render(batch);

        for (int i = 0; i < bullet.size; i++) {
            bullet.get(i).render(batch);
        }
        for (int i = 0; i < bullet2.size; i++) {
            bullet2.get(i).render(batch);
        }
        batch.end();
    }

    @Override
    public void update(float deltaTime) {
        tankr.update(deltaTime);
        tankg.update(deltaTime);
        // Updating the bullets so they move
        for (int i = 0; i < bullet.size; i++) {
            bullet.get(i).update(deltaTime);
        }
        for (int i = 0; i < bullet2.size; i++) {
            bullet2.get(i).update(deltaTime);
        }

        Iterator<Bullet> rs = bullet.iterator();
        while (rs.hasNext()) {
            Bullet up = rs.next();
            if (up.getY() > 600) {
                rs.remove();
            } else if (up.collides(tankg)) {
                Statemanager gsm = getStateManager();
                gsm.pop();
                System.out.println("RED WINS");
            }
        }
            Iterator<Bullet2> gs = bullet2.iterator();
            while (gs.hasNext()) {
                Bullet2 down = gs.next();
                if (down.getY() > 600) {
                    gs.remove();
                } else if (down.collides(tankr)) {
                    Statemanager gsm = getStateManager();
                    gsm.pop();
                    System.out.println("GREEN WINS");
                }
            }
        
    }

        @Override
        public void dispose
        
            () {
        bg.dispose();
            tankr.dispose();
            tankg.dispose();

        }

        @Override
        public void handleInput
        
            () {
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
            if (Gdx.input.isKeyJustPressed(Input.Keys.W)) {
                bullet.add(new Bullet(tankr.getX() + 7, tankr.getY() + 45));
            }
            if (Gdx.input.isKeyJustPressed(Input.Keys.UP)) {
                bullet2.add(new Bullet2(tankg.getX() + 10, tankg.getY() - 7));
            }

        }




    }
