package com.aod6060.lwjgl.common.window;

import java.nio.ByteBuffer;

import org.lwjgl.glfw.Callbacks;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWErrorCallback;
import org.lwjgl.glfw.GLFWKeyCallback;
import org.lwjgl.glfw.GLFWvidmode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GLContext;

import com.aod6060.lwjgl.common.Constants;

/**
 * This class is a wrapper for glfw. It contains 
 * all of the window realated stuff that I need 
 * for each of my projects. Once other windowing 
 * kits are avaliable I'll redo this class so it 
 * can use.
 * @author Fred
 *
 */
public class Window {
	// glfw error callback
	private GLFWErrorCallback errorCallback;
	private GLFWKeyCallback keyCallback;
	
	private String caption;
	private long window;
	private int width;
	private int height;
	
	private WindowListener listener = null;
	
	//private Window instance = null;
	/**
	 * This initializes the window for test projects.
	 * @param String cap
	 * @param int width
	 * @param int height
	 * @param WindowListener listener
	 */
	public void init(String cap, int width, int height, WindowListener listener) {
		this.caption = cap;
		this.width = width;
		this.height = height;
		this.listener = listener;
		
		GLFW.glfwSetErrorCallback(this.errorCallback = Callbacks.errorCallbackPrint(System.err));
		
		if(GLFW.glfwInit() != GL11.GL_TRUE) {
			throw new IllegalStateException("Unable to initialize glfw.");
		}
		
		GLFW.glfwWindowHint(GLFW.GLFW_VISIBLE, GL11.GL_FALSE);
		GLFW.glfwWindowHint(GLFW.GLFW_RESIZABLE, GL11.GL_FALSE);
		this.window = GLFW.glfwCreateWindow(this.width, this.height, this.caption, Constants.NULL, Constants.NULL);
		GLFW.glfwSetKeyCallback(this.window, keyCallback = new GLFWKeyCallback() {

			@Override
			public void invoke(long window, int key, int scancode, int action,
					int mods) {
				
				if(key == GLFW.GLFW_KEY_ESCAPE && action == GLFW.GLFW_RELEASE) {
					//GLFW.glfwSetWindowShouldClose(window, GL11.GL_TRUE);
					//instance.close();
					close();
				}
				
				if(getListener() != null) {
					getListener().keyHandler(key, scancode, action, mods);
				}
				
			}
			
		});
		
		
		ByteBuffer vidmode = GLFW.glfwGetVideoMode(GLFW.glfwGetPrimaryMonitor());
		
		GLFW.glfwSetWindowPos(
				this.window, 
				(GLFWvidmode.width(vidmode) - this.width) / 2, 
				(GLFWvidmode.height(vidmode) - this.height) / 2);
		
		GLFW.glfwMakeContextCurrent(this.window);
		GLFW.glfwSwapInterval(1);
		GLFW.glfwShowWindow(window);
		
		if(this.listener != null) {
			this.listener.init();
		}
	}
	
	/**
	 * This is the mainLoop for the window
	 */
	public void mainLoop() {
		
		GLContext.createFromCurrent();
		
		while(GLFW.glfwWindowShouldClose(this.window) == GL11.GL_FALSE) {
			if(this.listener != null) {
				this.listener.update();
			}
			
			GLFW.glfwSwapBuffers(window);
			
			GLFW.glfwPollEvents();
		}
	}
	
	/**
	 * This releases everything in the window
	 */
	public void release() {
		if(this.listener != null) {
			this.listener.release();
			this.listener = null;
		}
		GLFW.glfwDestroyWindow(this.window);
		keyCallback.release();
		GLFW.glfwTerminate();
		errorCallback.release();
	}
	
	/**
	 * This returns the ErrorCallback that the window is using
	 * @return GLFWErrorCallback
	 */
	public GLFWErrorCallback getErrorCallback() {
		return errorCallback;
	}
	
	/**
	 * This returns the KeyCallback for the window
	 * @return GLFWKeyCallback
	 */
	public GLFWKeyCallback getKeyCallback() {
		return keyCallback;
	}
	
	/**
	 * This returns the id for the window
	 * @return long
	 */
	public long getWindow() {
		return window;
	}
	
	/**
	 * This returns the width of the window
	 * @return int
	 */
	public int getWidth() {
		return width;
	}
	
	/**
	 * This returns the height of the window
	 * @return int
	 */
	public int getHeight() {
		return height;
	}
	
	/**
	 * This method closes the application
	 */
	public void close() {
		GLFW.glfwSetWindowShouldClose(this.window, GL11.GL_TRUE);
	}
	
	/**
	 * This returns the window listener
	 * @return WindowListener
	 */
	public WindowListener getListener() {
		return this.listener;
	}
}
