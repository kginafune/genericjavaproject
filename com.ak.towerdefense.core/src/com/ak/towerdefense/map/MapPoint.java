package com.ak.towerdefense.map;

/**
 * Represents a single spot in the game grid.
 *
 * @author aedon
 * @date Jan 26, 2012 3:21:10 PM
 * @version
 * 
 * Possible Improvements:
 * <pre>
 * * TODO
 * * Add distance finding method.
 * * Add adjacent calculations.
 * * Add get all adjacent points.
 * * Add path finding?
 * </pre>
 */
public class MapPoint {
	/* Our debugging tag */
	public static final String TAG = "MapPoint";
	/* Our version number */
	private static final long serialVersionUID = 1L;
	
	/**
	 * The game map the point is a part of.
	 */
	private final GameMap mMap;
	/**
	 * The 0 based position along the map's x axis.
	 */
	public int mX;
	/**
	 * The 0 based position along the map's y axis.
	 */
	public int mY;
	
	/**
	 * Creates a new immutable point (reference) to the
	 * game map.
	 * @param x The 0 based location along the x axis.
	 * @param y The 0 based location along the y axis.
	 */
	public MapPoint(GameMap map, int x, int y) {
		mMap = map;
		mX = x;
		mY = y;
	}
}