package com.simple;

public class ShapeFactory {
	public static Shape produce(String name) {
		if(name.equals("线条")) {
			return new Line();
		}
		if(name.equals("矩形")) {
			return new Rectangle();
		}
		if(name.equals("圆形")) {
			return new Roundness();
		}
		if(name.equals("三角形")) {
			return new Trilateral();
		}
		else return null;
	}
}
