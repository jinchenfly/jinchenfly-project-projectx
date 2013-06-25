package com.projectx.base;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.projectx.factory.GraphicFactory;
import com.projectx.factory.GraphicOperator;

public class Map {
	private static Map instance;
	private GraphicOperator op;
	public static Map getInstance(){
		if(instance==null){
			System.out.println("Map not exist.Creating");
			instance = new Map();
			instance.op = GraphicFactory.getGraphicOperator();
		}
		return instance;
	}
	public static final int maxX = 10;
	public static final int maxY = 10;
	private HashMap<Point,UnitX> map;
	private HashMap<Point,MapPoint> mapPointProps;
	public Map(){
		map = new HashMap<Point,UnitX>();
		mapPointProps = new HashMap<Point,MapPoint>();
		for(int x=0;x<maxX;x++){
			for(int y=0;y<maxY;y++){
				MapPoint point = new MapPoint(x, y);
				mapPointProps.put(new Point(x,y),point);
			}
		}
	}
	public UnitX getUnitX(Point p){
		if(map.containsKey(p)){
			return map.get(p);
		}
		return null;
	}
	public Boolean setUnitX(Point p,UnitX u){
		if(!map.containsKey(p)){
			map.put(p,u);
			op.setPointValue(p, String.valueOf(u.ID));
			return true;
		}
		return false;
	}
	public void releaseUnitX(Point p){
		if(map.containsKey(p)){
			map.remove(p);
		}
		op.releasePoint(p);
	}
	public int getCount(){
		return map.size();
	}
	public void paintMap(){
//		System.out.print("   ");
//		for(int x=1;x<=10;x++){
//			System.out.print(x+" ");
//		}
//		System.out.println();
//		for(int y=0;y<maxY;y++){
//			System.out.print((y+1)+" ");
//			if(y<9)
//				System.out.print(" ");
//			for(int x=0;x<maxX;x++){
//				if(map.containsKey(new Point(x,y))){
//					System.out.print(map.get(new Point(x,y)).ID+" ");
//				}else{
//					System.out.print("O ");
//				}
//			}
//			System.out.println("");
//		}
		paintMap(null);
	}
	public void paintMap(List<Point> spPointList){
		System.out.print("   ");
		for(int x=1;x<=10;x++){
			System.out.print(x+" ");
		}
		System.out.println();
		for(int y=0;y<maxY;y++){
			System.out.print((y+1)+" ");
			if(y<9)
				System.out.print(" ");
			for(int x=0;x<maxX;x++){
				MapPoint mapPoint = getMapPoint(new Point(x,y));
				if(mapPoint.block!=0){
					System.out.print("B ");
				}
				else if(map.containsKey(new Point(x,y))){
					System.out.print(map.get(new Point(x,y)).ID+" ");
				}else{
					if(spPointList!=null && spPointList.contains(new Point(x,y))){
						System.out.print("M ");
					}else{
						System.out.print("O ");
					}
				}
			}
			System.out.println("");
		}
	}
	public List<Point> getAllUnitPoint(){
		//Iterator it = map.keySet().iterator();
		List<Point> pointList = new ArrayList<Point>(map.keySet());
		return pointList;
	}
	public MapPoint getMapPoint(Point p){
		return mapPointProps.get(p);
	}
}
