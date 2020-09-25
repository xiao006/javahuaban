package com.simple;

public class ShapeFactory {
	public static Shape produce(String name) {
		if(name.equals("����")) {
			return new Line();
		}
		if(name.equals("����")) {
			return new Rectangle();
		}
		if(name.equals("Բ��")) {
			return new Roundness();
		}
		if(name.equals("������")) {
			return new Trilateral();
		}
		else return null;
	}
}
