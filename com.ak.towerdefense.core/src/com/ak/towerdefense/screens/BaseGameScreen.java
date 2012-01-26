package com.ak.towerdefense.screens;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Camera;

/**
 * Defines the base foundation for all of the cameras in
 * the game.
 *
 * @author aedon
 * @date Jan 24, 2012 10:23:52 PM
 * @version 0.0.1
 * 
 * Possible Improvements:
 * <pre>
 * * TODO
 * </pre>
 */
public class BaseGameScreen implements Screen {
	/* Our debugging tag */
	public static final String TAG = "GameScreen";

	/**
	 * The camera that will actually allow the user to 
	 * see something.
	 */
	protected final Camera 			mCamera;
	
	
	/**
	 * Creates a new screen.
	 * @param camera The camera to have the screen display
	 * to.
	 */
	public BaseGameScreen(Camera camera) {
		mCamera = camera;
	}


	@Override public void dispose() {
	}

	@Override public void hide() {
	}

	@Override public void pause() {
	}

	@Override public void render(float delta) {
	}

	@Override public void resize(int width, int height) {
	}

	@Override public void resume() {
	}

	@Override public void show() {
	}
}
