package com.projectx.bean;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.projectx.base.Map;
import com.projectx.base.MapPoint;
import com.projectx.base.Point;
import com.projectx.base.UnitX;

public class Person extends UnitX {
	public int range;
	protected List<UnitX> unitInRange;
	protected List<Point> moveablePoint;
	protected int keepDistance;
	public Person(Point p){
		this.map = Map.getInstance();
		this.point = getBirthPoint(p);
		if(point != null){
			boolean flag = map.setUnitX(point, this);
			//System.out.println("setPoint success?:"+flag);
		}
		this.MaxHP = 50;
		this.HP = MaxHP;
		this.str = 10;
		this.status = UnitStatus.Normal;
		this.Name = "Unit"+Map.getInstance().getCount();
		this.ID = Map.getInstance().getCount();
		this.defeatCount = 0;
		this.mobility = 1;
		this.keepDistance = 1;
		moveablePoint = new ArrayList<Point>();
		unitInRange = new ArrayList<UnitX>();
		System.out.println(this.getClass().getName().substring(this.getClass().getName().lastIndexOf('.')+1)+" "+Name+" Created.Point "+(point.x+1)+","+(point.y+1));
	}
	@Override
	public boolean move(Point p) {
		if(!p.isInMap(map)){
			System.out.println("Point out of Map");
			return false;
		}
		if(map.setUnitX(p, this)){
			map.releaseUnitX(point);
			point = p;
			System.out.println(Name+" move to Point("+(point.x+1)+","+(point.y+1)+")");
			map.paintMap();
			getSearchArea();
			return true;
		}else{
			System.out.println("Unit exist.move failed."+Name+" stay at Point("+(point.x+1)+","+(point.y+1)+")");
		}
		
		return false;
	}
	public boolean getClose(Point p){
		List<Point> moveablePoint = getMoveablePoint();
		Point bestPoint = getNearestPoint(p, moveablePoint, this.keepDistance);
		if(bestPoint == null)
			return false;
		move(bestPoint);
		return true;
//		if(Math.abs(p.x-this.point.x)>Math.abs(p.y-this.point.y)){
//			if(p.x>this.point.x){
//				return moveRight();
//			}else{
//				return moveLeft();
//			}
//		}else{
//			if(p.y>this.point.y){
//				return moveDown();
//			}else{
//				return moveUp();
//			}
//		}
	}
	public boolean moveLeft(){
		return move(point.addXY(-1, 0));
	}
	public boolean moveRight(){
		return move(point.addXY(1, 0));
	}
	public boolean moveUp(){
		return move(point.addXY(0, -1));
	}
	public boolean moveDown(){
		return move(point.addXY(0, 1));
	}
	private Point getBirthPoint(Point p){
		return getBirthPoint(p,0,0,10);
	}
	private Point getBirthPoint(Point p,int offsetX,int offsetY,int depth){
		Point pTemp = null;
		pTemp = checkPoint(p,offsetX,offsetY);
		if(pTemp!=null)
			return pTemp; 
		int type = 0;
		while(pTemp==null && Math.abs(offsetX)<=depth && Math.abs(offsetY)<=depth){
			switch(type){
				case 0:{
					offsetX+=1;
					type=1;
					break;
					}
				case 1:{
					offsetY+=1;
					if(Math.abs(offsetY) == Math.abs(offsetX)){
						type=2;
					}
					break;
				}
				case 2:{
					offsetX-=1;
					if(Math.abs(offsetY) == Math.abs(offsetX)){
						type=3;
					}
					break;
				}
				case 3:{
					offsetY-=1;
					if(Math.abs(offsetY) == Math.abs(offsetX)){
						type=4;
					}
					break;
				}
				case 4:{
					offsetX+=1;
					if(Math.abs(offsetY)+1 == Math.abs(offsetX)){
						type=1;
					}
					break;
				}
			}
			pTemp = checkPoint(p,offsetX,offsetY);
		}
		return pTemp;
	}
	private Point checkPoint(Point p,int offsetX,int offsetY){
		Point pTemp = null;
		Point offsetP = p.addXY(offsetX, offsetY);
		if(offsetP.isInMap(map) && map.getUnitX(offsetP)==null){
			pTemp = offsetP;
		}
		return pTemp;
	}
	public void attack(UnitX person){
		UnitStatus status = person.beDamaged(str+this.defeatCount);
		if(status == UnitStatus.Dead){
			this.defeatCount++;
		}
	}
	
	public UnitStatus beDamaged(int power){
		this.HP-=power;
		System.out.println(Name+" lost "+power+" HP.Left HP="+HP);
		if(this.HP<=0){
			this.status = UnitStatus.Dead;
			map.releaseUnitX(this.point);
			System.out.println(Name+" is defeated");
		}
		return this.status;
	}
	public UnitStatus getStatus(){
		return status;
	}
	public List<Point> getSquareArea(Point p,int r){
		int startX = p.x-r;
		int startY = p.y-r;
		int endX = p.x+r;
		int endY = p.y+r;
		Point tempPoint = null;
		List<Point> areaList = new ArrayList<Point>();
		for(int x=startX;x<=endX;x++){
			for(int y=startY;y<=endY;y++){
				tempPoint = new Point(x,y);
				if(!tempPoint.isInMap(map)){
					continue;
				}
				if((Math.abs(y-p.y)+Math.abs(x-p.x))<=r){
					areaList.add(new Point(x,y));
				}
			}
		}
		return areaList;
	}
	public List<Point> getSearchArea(){
//		int startX = point.x-range;
//		int startY = point.y-range;
//		int endX = point.x+range;
//		int endY = point.y+range;
//		List<Point> areaList = new ArrayList<Point>();
//		for(int x=startX;x<=endX;x++){
//			for(int y=startY;y<=endY;y++){
//				if((Math.abs(y-point.y)+Math.abs(x-point.x))<=range){
//					areaList.add(new Point(x,y));
//				}
//			}
//		}
		List<Point> areaList = getSquareArea(point,range);
		unitInRange.clear();
		UnitX temp = null;
		for (Point point : areaList) {
			//System.out.println("("+point.toString()+")");
			if((temp=map.getUnitX(point))!=null && temp!=this){
				unitInRange.add(temp);
				System.out.println(temp.Name+" in range");
			}
		}
		return areaList;
	}
	public Point getNearestEnemyPoint() {
		Point nearestPoint = null;
		List<Point> pointList = map.getAllUnitPoint();
		for (Point point : pointList) {
			if(point == this.point)
				continue;
			if(nearestPoint == null)
				nearestPoint = point;
			else{
				if(Point.getDistance(this.point, point)<
						Point.getDistance(this.point, nearestPoint)){
					nearestPoint = point;
				}
			}
		}
		return nearestPoint;
	}
	public void autoAction(){
//		getSearchArea();
//		if(!unitInRange.isEmpty()){
//			attack(unitInRange.get(0));
//		}
//		else{
//			Point nearestPoint = getNearestEnemyPoint();
//			if(nearestPoint!=null){
//				getClose(nearestPoint);
//			}
//		}
		if(status==UnitStatus.Dead)
			return;
		Point nearestPoint = getNearestEnemyPoint();
		if(nearestPoint!=null){
			getClose(nearestPoint);
		}
		//getSearchArea();
		if(!unitInRange.isEmpty()){
			attack(unitInRange.get(0));
		}
	}
//	public List<Point> getMoveablePoint(){
//		List<Point> moveablePoint = getSquareArea(point,mobility);
//		for (int x=moveablePoint.size()-1;x>=0;x--) {
//			if(map.getUnitX(moveablePoint.get(x))!=null){
//				moveablePoint.remove(x);
//			}
//		}
//		return moveablePoint;
//	}
	public List<Point> getMoveablePoint(){
		Point[] direction = new Point[]{new Point(1,0),new Point(-1,0),new Point(0,1),new Point(0,-1)};
		Point startPoint = this.point;
		HashMap<Point,Integer> moveablePointMap = new HashMap<Point, Integer>();
		for(int x=0;x<direction.length;x++){
			recurGetMoveArea(moveablePointMap,direction,startPoint.add(direction[x]),this.mobility);
		}
		List<Point> moveablePoint = new ArrayList<Point>(moveablePointMap.keySet());
//		for (int x=moveablePoint.size()-1;x>=0;x--) {
//			if(map.getUnitX(moveablePoint.get(x))!=null){
//				moveablePoint.remove(x);
//			}
//		}
		return moveablePoint;
	}
	public void printMoveArea(){
		List<Point> moveablePoint = getMoveablePoint();
		map.paintMap(moveablePoint);
	}
	private void recurGetMoveArea(HashMap<Point,Integer> moveablePoint,Point[] direction,Point searchPoint,int mobility){
		if(!searchPoint.isInMap(map))
			return;
		MapPoint mapPoint = map.getMapPoint(searchPoint);
		if(mapPoint.block !=0){
			return;
		}
		if(map.getUnitX(searchPoint)!=null){
			return;
		}
		int leftMobility = mobility - mapPoint.decrease;
		if(leftMobility<0){
			return;
		}else{
			if(moveablePoint.containsKey(searchPoint)){
				if(leftMobility>moveablePoint.get(searchPoint)){
					moveablePoint.remove(searchPoint);
					moveablePoint.put(searchPoint, leftMobility);
					for(int x=0;x<direction.length;x++){
						recurGetMoveArea(moveablePoint,direction,searchPoint.add(direction[x]),leftMobility);
					}
				}else{
					return;
				}
			}else{
				moveablePoint.put(searchPoint, leftMobility);
				for(int x=0;x<direction.length;x++){
					recurGetMoveArea(moveablePoint,direction,searchPoint.add(direction[x]),leftMobility);
				}
			}
			
		}
	}
	public Point getNearestPoint(Point targetPoint,List<Point> moveablePoint,int keepDistance){
		Point bestPoint = null;
		int bestDistance = -1;
		int tempDistance = -1;
		for (Point point : moveablePoint) {
			
			tempDistance = Point.getDistance(point, targetPoint);
			if(bestDistance == -1 || tempDistance<bestDistance){
				bestDistance = tempDistance;
				bestPoint = point;
			}
			if(tempDistance == keepDistance){
				return point;
			}
		}
		return bestPoint;
	}
	public double getThreat(){
		double threat = 0;
		if(HP>=MaxHP*0.5){
			threat+= MaxHP-HP;
		}else{
			threat+= MaxHP*0.5+(MaxHP*0.5-HP)*2;
		}
		threat+=str*5;
		return threat;
	}
	
}
