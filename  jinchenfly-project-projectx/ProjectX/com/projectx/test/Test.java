package com.projectx.test;



import com.projectx.base.GraphicMap;
import com.projectx.base.Map;
import com.projectx.base.Point;
import com.projectx.bean.Archer;
import com.projectx.bean.Assassion;
import com.projectx.bean.Person;
import com.projectx.bean.Saber;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Person p1 = new Person(Point.random(10, 10));
		Person p2 = new Person(Point.random(10, 10));
//		MapPoint point = Map.getInstance().getMapPoint(new Point(4,5));
//		point.block = 1;
//		p1.moveDown();
//		p1.moveRight();
//		p1.moveRight();
//		while(p2.getStatus()!=UnitStatus.Dead){
//			p1.attack(p2);
//		}
		
		Archer p3 = new Archer(Point.random(10, 10));
//		p3.getMoveablePoint();
//		List<Point> attack = p3.getAttackablePoint();
//		Map.getInstance().paintMap(attack);
		//p3.mobility++;
		//p3.printMoveArea();
		Saber p4 = new Saber(Point.random(10, 10));
		Assassion p5 = new Assassion(Point.random(10, 10));

//		Map.getInstance().paintMap();
		GraphicMap gMap = GraphicMap.getInstance();
		Thread t = new Thread(gMap);
		t.start();
		try {
			while(Map.getInstance().getCount()>1){
				p3.autoAction();
				Thread.sleep(1000);
				p4.autoAction();
				Thread.sleep(1000);
				p5.autoAction();
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
