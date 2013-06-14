package com.projectx.test;



import com.projectx.base.Map;
import com.projectx.base.MapPoint;
import com.projectx.base.Point;
import com.projectx.bean.Archer;
import com.projectx.bean.Person;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Person p1 = new Person(new Point(0,0));
		Person p2 = new Person(new Point(2,1));
		MapPoint point = Map.getInstance().getMapPoint(new Point(4,5));
		point.block = 1;
//		p1.moveDown();
//		p1.moveRight();
//		p1.moveRight();
//		while(p2.getStatus()!=UnitStatus.Dead){
//			p1.attack(p2);
//		}
		Archer p3 = new Archer(new Point(5,5));
		//p3.mobility++;
		p3.printMoveArea();
//		Saber p4 = new Saber(new Point(0,9));
//		while(Map.getInstance().getCount()>1){
//			p3.autoAction();
//			p4.autoAction();
//		}

//		HashMap map = new HashMap();
//		Point po1 = new Point(0,0);
//		Point po2 = new Point(0,0);
//		System.out.println(po1.equals(po2));
//		System.out.println(po1 == po2);
//		map.put(po1, "1");
//		System.out.println(map.containsKey(po2));
		
//		System.out.println(po1.equals(po2));
		
	}

}
