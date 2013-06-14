package com.projectx.bean;

import com.projectx.base.Point;

public class Saber extends Person {
	public Saber(Point p) {
		super(p);
		MaxHP = 100;
		range = 1;
		str = 15;
		movement = 2;
		HP = MaxHP;
	}

}
