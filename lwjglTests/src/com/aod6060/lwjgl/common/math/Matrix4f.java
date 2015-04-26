package com.aod6060.lwjgl.common.math;

public class Matrix4f {
	public static final int C = 4;
	public static final int R = 4;
	
	public float[] m;
	
	public Matrix4f() {
		m = new float[C*R];
		
		// Set it to zero Matrix2
		for(int i = 0; i < C * R; i++) {
			m[i] = 0;
		}
	}
}
