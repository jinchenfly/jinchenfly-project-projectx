package com.projectx.bean;

import com.projectx.base.Point;

public class Archer extends Person {
	public Archer(Point p) {
		super(p);
		MaxHP=100;
		range = 3;
		str = 10;
		mobility = 3;
		keepDistance = 3;
		HP = MaxHP;
	}
	
	
	
}
