package com.aod6060.lwjgl.common.math;

public class Matrix2f {
	public static final int C = 2;
	public static final int R = 2;
	
	public float[] m;
	
	public Matrix2f() {
		m = new float[C*R];
		
		// Set it to zero Matrix2
		for(int i = 0; i < C * R; i++) {
			m[i] = 0;
		}
	}
}
