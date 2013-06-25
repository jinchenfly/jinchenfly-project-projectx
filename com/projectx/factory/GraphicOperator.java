package com.projectx.factory;

import com.projectx.base.Point;

public interface GraphicOperator {
	public abstract void setPointValue(Point p,String value);
	public void releasePoint(Point p);
}
