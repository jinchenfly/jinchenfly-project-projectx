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
	protected List<Point> attackablePoint;
	protected int keepDistance;
	public Person(Point p){
		this.UnitMap = Map.getInstance();
		setPoint(getBirthPoint(p));
		if(getPoint() != null){
			this.UnitMap.setUnitX(getPoint(), this);
			//System.out.println("setPoint success?:"+flag);
		}
		this.MaxHP = 10;
		this.HP = MaxHP;
		this.str = 1;
		this.status = UnitStatus.Normal;
		this.Name = "Unit"+Map.getInstance().getCount();
		this.ID = Map.getInstance().getCount();
		this.defeatCount = 0;
		this.mobility = 1;
		this.keepDistance = 1;
		this.agi = 1;
		this.dex = 1;
		this.luc = 1;
		moveablePoint = new ArrayList<Point>();
		unitInRange = new ArrayList<UnitX>();
		attackablePoint = new ArrayList<Point>();
		UnitList.add(this);
		System.out.println(this.getClass().getName().substring(this.getClass().getName().lastIndexOf('.')+1)+" "+Name+" Created.Point "+(getPoint().x+1)+","+(getPoint().y+1));
	}
	@Override
	public boolean move(Point p) {
		if(!p.isInMap(UnitMap)){
			System.out.println("Point out of Map");
			return false;
		}
		if(UnitMap.setUnitX(p, this)){
			UnitMap.releaseUnitX(getPoint());
			setPoint(p);
			System.out.println(Name+" move to Point("+(getPoint().x+1)+","+(getPoint().y+1)+")");
			UnitMap.paintMap();
			getSearchArea();
			return true;
		}else{
			System.out.println("Unit exist.move failed."+Name+" stay at Point("+(getPoint().x+1)+","+(getPoint().y+1)+")");
		}
		
		return false;
	}
	public boolean getClose(Point p){
		getMoveablePoint();
		Point bestPoint = getNearestPoint(p, moveablePoint, this.keepDistance);
		if(bestPoint == null)
			return false;
		move(bestPoint);
		return true;
	}
	public boolean moveLeft(){
		return move(getPoint().addXY(-1, 0));
	}
	public boolean moveRight(){
		return move(getPoint().addXY(1, 0));
	}
	public boolean moveUp(){
		return move(getPoint().addXY(0, -1));
	}
	public boolean moveDown(){
		return move(getPoint().addXY(0, 1));
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
		if(offsetP.isInMap(UnitMap) && UnitMap.getUnitX(offsetP)==null){
			pTemp = offsetP;
		}
		return pTemp;
	}
	public void attack(UnitX person){
		int hitGap = this.dex-person.getAgi();
		int hitRate = BaseHit+hitGap*2;
		if(isHit(hitRate)){
			UnitStatus status = person.beDamaged(this);
			if(status == UnitStatus.Dead){
				this.defeatCount++;
			}
		}else{
			System.out.println(Name + " attacked "+person.Name+",but Missed");
		}
	}
	public boolean isHit(int hitRate){
		int random = (int)(Math.random()*100);
		if(random<=hitRate){
			return true;
		}else{
			return false;
		}
	}
	public UnitStatus beDamaged(UnitX attacker){
		int power = attacker.getStr()+attacker.getDefeatCount();
		int critical = BaseCritical + (attacker.getLuc()-luc)*3;
		boolean isCritical = isHit(critical);
		if(isCritical)
			power *= 2;
		this.HP-=power;
		System.out.println((isCritical?"Critical!":"")+Name+" lost "+power+" HP.Left HP="+HP);
		if(this.HP<=0){
			this.status = UnitStatus.Dead;
			UnitMap.releaseUnitX(getPoint());
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
				if(!tempPoint.isInMap(UnitMap)){
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
		List<Point> areaList = getSquareArea(getPoint(),range);
		unitInRange.clear();
		UnitX temp = null;
		for (Point point : areaList) {
			//System.out.println("("+point.toString()+")");
			if((temp=UnitMap.getUnitX(point))!=null && temp!=this){
				unitInRange.add(temp);
				System.out.println(temp.Name+" in range");
			}
		}
		return areaList;
	}
	public Point getNearestEnemyPoint() {
		Point nearestPoint = null;
		List<Point> pointList = UnitMap.getAllUnitPoint();
		for (Point point : pointList) {
			if(point == getPoint())
				continue;
			if(nearestPoint == null)
				nearestPoint = point;
			else{
				if(Point.getDistance(getPoint(), point)<
						Point.getDistance(getPoint(), nearestPoint)){
					nearestPoint = point;
				}
			}
		}
		return nearestPoint;
	}
	public void autoAction(){
		if(status==UnitStatus.Dead)
			return;
		getAttackablePoint();
		Point topThreatEnemyPoint = null;
		double topThreatValue = -1;
		double tempThreatValue = -1;
		for (Point point : attackablePoint) {
			UnitX unit = UnitMap.getUnitX(point);
			if(unit==null || unit == this)
				continue;
			
			tempThreatValue = unit.getThreat();
			System.out.println(unit.Name+"'s threat="+tempThreatValue);
			if(topThreatValue == -1 || topThreatValue < tempThreatValue){
				topThreatEnemyPoint = point;
				topThreatValue = tempThreatValue;
			}
		}
		Point targetPoint = null;
		if(topThreatEnemyPoint!=null)
			targetPoint = topThreatEnemyPoint;
		else{
			targetPoint = getNearestEnemyPoint();
		}
		if(targetPoint!=null){
			getClose(targetPoint);
		}
		//getSearchArea();
		if(!unitInRange.isEmpty()){
			if(topThreatEnemyPoint!=null){
				attack(UnitMap.getUnitX(topThreatEnemyPoint));
			}else{
				attack(unitInRange.get(0));
			}
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
	public void getMoveablePoint(){
		Point[] direction = new Point[]{new Point(1,0),new Point(-1,0),new Point(0,1),new Point(0,-1)};
		Point startPoint = getPoint();
		HashMap<Point,Integer> moveablePointMap = new HashMap<Point, Integer>();
		for(int x=0;x<direction.length;x++){
			recurGetMoveArea(moveablePointMap,direction,startPoint.add(direction[x]),this.mobility);
		}
		moveablePoint = new ArrayList<Point>(moveablePointMap.keySet());
	}
	public void printMoveArea(){
		UnitMap.paintMap(moveablePoint);
	}
	private void recurGetMoveArea(HashMap<Point,Integer> moveablePoint,Point[] direction,Point searchPoint,int mobility){
		if(!searchPoint.isInMap(UnitMap))
			return;
		MapPoint mapPoint = UnitMap.getMapPoint(searchPoint);
		if(mapPoint.block !=0){
			return;
		}
		if(UnitMap.getUnitX(searchPoint)!=null){
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
	
	public List<Point> getAttackablePoint(){
		attackablePoint.clear();
		List<Point> temp = null;
		for (Point point : moveablePoint) {
			temp = getSquareArea(point, range);
			for (Point point2 : temp) {
				if(!attackablePoint.contains(point2)){
					attackablePoint.add(point2);
				}
			}
		}
		return attackablePoint;
	}
	@Override
	protected void getUnitInRange() {
		List<Point> areaList = getSquareArea(getPoint(),range);
		unitInRange.clear();
		UnitX temp = null;
		for (Point point : areaList) {
			//System.out.println("("+point.toString()+")");
			if((temp=UnitMap.getUnitX(point))!=null && temp!=this){
				unitInRange.add(temp);
				System.out.println(temp.Name+" in range");
			}
		}
	}
	

}
