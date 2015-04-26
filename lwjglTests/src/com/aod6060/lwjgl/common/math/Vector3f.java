package com.aod6060.lwjgl.common.math;

/**
 * This is an implementation of a 3D Vector
 * @author Fred
 *
 */
public class Vector3f {
	public float x;
	public float y;
	public float z;
	
	
	public Vector3f() {
		this.x = 0;
		this.y = 0;
		this.z = 0;
	}
	
	public Vector3f(float x, float y, float z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
}
