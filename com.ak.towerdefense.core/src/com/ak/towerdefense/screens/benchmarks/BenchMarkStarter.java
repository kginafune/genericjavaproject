package com.ak.towerdefense.screens.benchmarks;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;

public class BenchMarkStarter {
	/* Our debugging tag */
	public static final String TAG = "BenchMarkStarter";
	/* Our version number */
	private static final long serialVersionUID = 1L;
	
	public static void main(String... args) {
		new LwjglApplication(new ObjectLoader(), "Testo", 800, 640, false);
	}
}
