package com.projectx.bean;

import com.projectx.base.Point;

public class Assassion extends Person {

	public Assassion(Point p) {
		super(p);
		MaxHP = 100;
		range = 1;
		str = 13;
		dex = 15;
		agi = 20;
		mobility = 3;
		HP = MaxHP;
		luc = 10;
	}

}
