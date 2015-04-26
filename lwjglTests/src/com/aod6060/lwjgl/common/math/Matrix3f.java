package com.aod6060.lwjgl.common.math;

public class Matrix3f {
	public static final int C = 3;
	public static final int R = 3;
	
	public float[] m;
	
	public Matrix3f() {
		m = new float[C*R];
		
		// Set it to zero Matrix2
		for(int i = 0; i < C * R; i++) {
			m[i] = 0;
		}
	}
}
