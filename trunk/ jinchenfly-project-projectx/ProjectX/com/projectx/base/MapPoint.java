package com.projectx.base;

public class MapPoint extends Point {
	public int block;
	public int decrease;
	public MapPoint(int x, int y) {
		super(x, y);
		block = 0;
		decrease = 1;
	}

}
