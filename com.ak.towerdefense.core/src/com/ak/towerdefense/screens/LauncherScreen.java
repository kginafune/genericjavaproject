package com.ak.towerdefense.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Mesh;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.VertexAttribute;
import com.badlogic.gdx.graphics.VertexAttributes;
import com.badlogic.gdx.graphics.VertexAttributes.Usage;
import com.badlogic.gdx.math.Rectangle;

/**
 * The games launching screen. This will display any of the
 * games art logo's and pre-game notifications.
 *
 * @author aedon
 * @date Jan 24, 2012 9:41:22 PM
 * @version 0.0.1
 * 
 * Possible Improvements:
 * <pre>
 * * TODO
 * * import the launcher screen. (assets/images/screens)
 * </pre>
 */
public class LauncherScreen extends BaseGameScreen {
	/* Our debugging tag */
	public static final String TAG = "LauncherScreen";
	/* Our version number */
	private static final long serialVersionUID = 1L;
	
	private Texture					mTexture;
	private Mesh					mMesh;
	private Rectangle				mViewPort;
	private long					mDisplayTime		= 5000L;
	private long					mStartTime			= -1L;
	
	public LauncherScreen(Camera camera) {
		super(camera);
		mMesh = new Mesh(true, 4, 6,
                new VertexAttribute(VertexAttributes.Usage.Position, 3,"attr_Position"),
                new VertexAttribute(Usage.TextureCoordinates, 2, "attr_texCoords"));
		mTexture = new Texture(Gdx.files.internal("images/screen/game_launcher.png"));
		mMesh.setVertices(new float[] {
			-1, -1, 0, 0, 1,
			1, -1, 0, 1, 1,
			1, 1, 0, 1, 0,
			-1, 1, 0, 0, 0,
		});
		mMesh.setIndices(new short[] { 0, 1, 2, 3, 0 });
		
		mCamera = new OrthographicCamera(width, height);
		mCamera.position.set(width / 2, height / 2, 0);
		
		mViewPort = new Rectangle(0, 0, width, height);
	}
	
	@Override public void dispose() {
		mTexture.dispose();
		mMesh.dispose();
	}
	@Override public void render(float delta) {
		if (mStartTime == -1)
			mStartTime = System.currentTimeMillis();
		if (System.currentTimeMillis() - mStartTime > mDisplayTime)
			close();
		GL10 gl = Gdx.graphics.getGL10();
		
		gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		gl.glViewport((int)mViewPort.x, (int)mViewPort.y, (int)mViewPort.width, (int)mViewPort.height);
		
		mCamera.update();
		mCamera.apply(gl);
		mTexture.bind();
		
		mMesh.render(GL10.GL_TRIANGLES);
	}
	/**
	 * This method is only propagated on in a windowed version
	 * of the game (and pc version).
	 */
	@Override public void resize(int width, int height) {
		// NOT USED
		throw new UnsupportedOperationException("We are running " +
				"on Andorid and should never be really be called.");
	}
}
