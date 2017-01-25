/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.MyGdxGame;

/**
 *
 * @author kulla6503
 */
class HowToPlayState extends State {

    private Texture bg;
    private Texture ImageOfHowToPlayMenu; 

    public HowToPlayState(Statemanager gsm) {

        super(gsm);
        setCameraView(MyGdxGame.WIDTH, MyGdxGame.HEIGHT);
        setCameraPosition(getViewWidth() / 2, getViewHeight() / 2);

        bg = new Texture("tankBackground");
        ImageOfHowToPlayMenu = new Texture("ImageOfHowToPlayMenu.png");
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.setProjectionMatrix(getCombinedCamera());
        batch.begin();

        batch.draw(bg, 0, 0, getViewWidth(), getViewHeight());

        batch.end();
    }

    @Override
    public void update(float deltaTime) {
    }

    @Override
    public void handleInput() {
        if (Gdx.input.justTouched()) {
            Vector3 touch = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);

            if (touch.x > 0 && touch.x < getViewWidth() && touch.y > 0 && touch.y < getViewHeight()) {
                Statemanager gsm = getStateManager();
                gsm.push(new HowToPlayState(gsm));
            }
        }
    }

    @Override
    public void dispose() {
        bg.dispose();
    }
}
