package com.aod6060.lwjgl;

import org.lwjgl.opengl.GL11;

import com.aod6060.lwjgl.common.window.Window;
import com.aod6060.lwjgl.common.window.WindowListener;


public class Runner implements WindowListener {
	public static void main(String[] args) {
		Window win = new Window();
		
		win.init("Hello, World", 800, 600, new Runner());
		
		win.mainLoop();
		
		win.release();
		
		
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		GL11.glClearColor(1.0f, 0.0f, 0.0f, 1.0f);
		
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
		
		
	}

	@Override
	public void release() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyHandler(int key, int scancode, int action,
			int mods) {
		// TODO Auto-generated method stub
		
	}
}
