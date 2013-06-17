package com.projectx.base;

public class Point {
	public int x;
	public int y;

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	public Point addXY(int offsetX,int offsetY){
		return new Point(x+offsetX,y+offsetY);
	}
	public Point add(Point p){
		return new Point(x+p.x,y+p.y);
	}
	public boolean isInMap(Map map){
		if(x>=0 && y>=0 && x<Map.maxX && y<Map.maxY){
			return true;
		}
		return false;
	}
	@Override
	public String toString() {
		return x+","+y;
	}

	@Override
	public int hashCode() {
		return this.toString().hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Point)) 
			return false; 
		Point p = (Point)obj; 
		return p.x == x && p.y == y; 
	}
	public Point(int x,int y){
		this.x = x;
		this.y = y;
	}
	public static int getDistance(Point p1,Point p2){
		return Math.abs(p2.x-p1.x)+Math.abs(p2.y-p1.y);
	}
	public static Point random(int maxX,int maxY){
		int x = (int)(Math.random()*maxX);
		int y = (int)(Math.random()*maxY);
		return new Point(x,y);
	}
}
