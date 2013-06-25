package com.projectx.factory;

import javax.swing.JLabel;

import com.projectx.base.GraphicMap;
import com.projectx.base.Point;

public class GraphicOperatorImpl implements GraphicOperator {
	GraphicMap gMap;
	public GraphicOperatorImpl(){
		this.gMap = GraphicMap.getInstance();
	}
	@Override
	public void setPointValue(Point p, String value) {
		JLabel p1 = gMap.labelList.get(p);
		if(p1!=null){
			p1.setText(value);
		}
	}
	@Override
	public void releasePoint(Point p) {
		JLabel p1 = gMap.labelList.get(p);
		if(p1!=null){
			p1.setText(" ");
		}
	}

}
