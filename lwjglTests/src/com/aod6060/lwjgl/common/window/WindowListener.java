package com.aod6060.lwjgl.common.window;


/**
 * This interface is the main way for the window to listen 
 * to user requests.
 * @author Fred
 *
 */
public interface WindowListener {
	
	/**
	 * This method is used to initialize the window
	 * @param Window win
	 */
	public void init();
	
	/**
	 * This method is used to update the window
	 * @param Window win
	 */
	public void update();
	
	/**
	 * This method is used to release the window
	 * @param Window win
	 */
	public void release();
	
	/**
	 * This method is used to handle key callback
	 * @param Window win
	 * @param int key
	 * @param int scancode
	 * @param int action
	 * @param int mods
	 */
	public void keyHandler(int key, int scancode, int action, int mods);
}
