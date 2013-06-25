package com.projectx.bean;

import com.projectx.base.Point;

public class Saber extends Person {
	public Saber(Point p) {
		super(p);
		MaxHP = 100;
		range = 1;
		str = 15;
		dex = 10;
		agi = 5;
		mobility = 2;
		HP = MaxHP;
		luc = 3;
	}

}
