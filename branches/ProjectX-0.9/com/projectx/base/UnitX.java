package com.projectx.base;

import java.util.ArrayList;
import java.util.List;


public abstract class UnitX {
	private Point point;
	protected int HP;
	protected int MaxHP;
	public String Name;
	protected Map UnitMap;
	protected int str;
	public enum UnitStatus{Normal,Dead}
	protected UnitStatus status;
	protected int defeatCount;
	public int ID;
	public int mobility;
	protected int agi;
	protected int dex;
	protected int luc;
	public static final int BaseHit = 80;
	public static final int BaseCritical = 10;
	public int getHP() {
		return HP;
	}
	public void setHP(int hP) {
		HP = hP;
	}
	public int getMaxHP() {
		return MaxHP;
	}
	public void setMaxHP(int maxHP) {
		MaxHP = maxHP;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public UnitStatus getStatus() {
		return status;
	}
	public void setStatus(UnitStatus status) {
		this.status = status;
	}
	public int getMobility() {
		return mobility;
	}
	public void setMobility(int mobility) {
		this.mobility = mobility;
	}
	public int getStr() {
		return str;
	}
	public void setStr(int str) {
		this.str = str;
	}
	public int getDefeatCount() {
		return defeatCount;
	}
	public void setDefeatCount(int defeatCount) {
		this.defeatCount = defeatCount;
	}
	public int getAgi() {
		return agi;
	}
	public void setAgi(int agi) {
		this.agi = agi;
	}
	public int getDex() {
		return dex;
	}
	public void setDex(int dex) {
		this.dex = dex;
	}
	public int getLuc() {
		return luc;
	}
	public void setLuc(int luc) {
		this.luc = luc;
	}
	public abstract boolean move(Point p);
	public static List<UnitX> UnitList = new ArrayList<UnitX>();
	public abstract UnitStatus beDamaged(UnitX person);
	protected void setPoint(Point p){
		this.point = p;
		//getUnitInRange();
	}
	protected Point getPoint(){
		return this.point;
	}
	protected abstract void getUnitInRange();
	public double getThreat(){
		double threat = 0;
		if(HP>=MaxHP*0.5){
			threat+= MaxHP-HP;
		}else{
			threat+= MaxHP*0.5+(MaxHP*0.5-HP)*2;
		}
		threat+=str*5;
		threat+=(50-MaxHP)*0.5;
		return threat;
	}
}
