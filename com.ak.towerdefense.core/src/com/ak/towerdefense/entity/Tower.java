package com.ak.towerdefense.entity;

/**
 * The base class for all towers in the game. A tower is
 * the primary entity in the Tower Defense game. It (usually)
 * blocks the path of a {@link Monstie} and forces it through
 * a maze that the user build using multiple towers placed
 * roughly adjacent to each other.
 * <br>
 * How a tower works is simple; it waits for a {@link Monstie} 
 * to enter its attack range and proceeds to fire upon it until
 * dead. Some towers have abilities that affect it's effect on
 * the game world (and by association, {@link Monstie}s. 
 *
 * @author aedon
 * @date Jan 26, 2012 3:11:42 PM
 * @version 0.0.1
 * 
 * Possible Improvements:
 * <pre>
 * * TODO
 * </pre>
 */
public class Tower extends Entity {
	/* Our debugging tag */
	public static final String TAG = "Tower";
	/* Our version number */
	private static final long serialVersionUID = 1L;
}
