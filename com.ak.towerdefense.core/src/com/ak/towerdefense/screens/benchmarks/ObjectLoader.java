package com.ak.towerdefense.screens.benchmarks;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Mesh;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g3d.loaders.ModelLoaderOld;

public class ObjectLoader implements ApplicationListener, InputProcessor {
	/* Our debugging tag */
	public static final String TAG = "ObjectLoader";
	/* Our version number */
	private static final long serialVersionUID = 1L;
	PerspectiveCamera camera;
	Mesh torus;
	Texture cat;
	
	float viewAngle;
	float touchStartX;
	float touchStartY;
	
	float[] lightColor = {1, 1, 1, 0};
    float[] lightPosition = {2, 5, 10, 0};

	
	@Override public void create() {
		torus = ModelLoaderOld.loadObj(Gdx.files.internal("assets/models/torus.obj").read());
		cat = new Texture(Gdx.files.internal("assets/images/cheshire-cat-icon.png"), true);
		cat.setFilter(TextureFilter.MipMap, TextureFilter.Linear);
		
		camera = new PerspectiveCamera(45, 4, 4);
		camera.position.set(3, 3, 3);
		camera.direction.set(-1, -1, -1);
		Gdx.input.setInputProcessor(this);
	}
	@Override
	public void dispose() {
	}
	@Override
	public void pause() {
	}
	@Override public void render() {
		 GL10 gl = Gdx.graphics.getGL10();

         gl.glViewport(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
         gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);
         gl.glEnable(GL10.GL_DEPTH_TEST);
         gl.glEnable(GL10.GL_LIGHTING);
         gl.glEnable(GL10.GL_COLOR_MATERIAL);
         gl.glEnable(GL10.GL_TEXTURE_2D);

         camera.update();
         gl.glMatrixMode(GL10.GL_PROJECTION);
         gl.glLoadIdentity();
         
         gl.glLoadMatrixf(camera.projection.val, 0);
         gl.glMatrixMode(GL10.GL_MODELVIEW);
         gl.glLoadMatrixf(camera.view.val, 0);

         gl.glEnable(GL10.GL_LIGHT0);
         gl.glLightfv(GL10.GL_LIGHT0, GL10.GL_DIFFUSE, lightColor, 0);
         gl.glLightfv(GL10.GL_LIGHT0, GL10.GL_POSITION, lightPosition, 0);

         gl.glRotatef(viewAngle, 0, 0, 1);

         cat.bind();
         torus.render(GL10.GL_TRIANGLES);
         
	}
	@Override
	public void resize(int width, int height) {
	}
	@Override
	public void resume() {
	}
	@Override
	public boolean keyDown(int keycode) {
		return false;
	}
	@Override
	public boolean keyTyped(char character) {
		return false;
	}
	@Override
	public boolean keyUp(int keycode) {
		return false;
	}
	@Override
	public boolean scrolled(int amount) {
		return false;
	}
	@Override
	public boolean touchDown(int x, int y, int pointer, int button) {
		touchStartX = x;
		return false;
	}
	@Override
	public boolean touchDragged(int x, int y, int pointer) {
		viewAngle += (x - touchStartX);
		touchStartX = x;
		return false;
	}
	@Override
	public boolean touchMoved(int x, int y) {
		return false;
	}
	@Override
	public boolean touchUp(int x, int y, int pointer, int button) {
		return false;
	}
}
