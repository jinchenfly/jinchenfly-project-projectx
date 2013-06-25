package com.projectx.factory;

public class GraphicFactory {
	public static GraphicOperator getGraphicOperator(){
		return new GraphicOperatorImpl();
	}
}
