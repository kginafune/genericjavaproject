package com.ak.towerdefense;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;

/**
 * The launcher that will allow the game application to launch
 * from a PC or laptop. This is primarily used for debugging
 * and quick access to the game with out the need of an android
 * device (just for you Kevin ^_^). 
 *
 * @author aedon
 * @date Jan 24, 2012 9:13:06 PM
 * @version 0.0.1
 * 
 * Possible Improvements:
 * <pre>
 * </pre>
 */
public class DesktopLauncher {
	/* Our debugging tag */
	public static final String TAG = "DesktopLauncher";
	
	/**
	 * The entry for the desktop version of the game. Unimportant
	 * for the actual market release.
	 * @param args Nil. Passing arguments to this method is
	 * unimportant at this point.
	 */
	public static void main(String... args) {
		/*
		 * Create a new Game Application that will run on the
		 * desktop. This game will be be labeled and sized to
		 * the given (arguments 2-4).  
		 */
		new LwjglApplication(new GameApplication(), "Testo",
				800, 640, false);
	}
}
