package com.projectx.base;


public abstract class UnitX {
	protected Point point;
	protected int HP;
	public String Name;
	protected Map map;
	protected int str;
	public enum UnitStatus{Normal,Dead}
	protected UnitStatus status;
	protected int defeatCount;
	public abstract boolean move(Point p);
	public abstract UnitStatus beDamaged(int power);
	
}
