package com.decorate;

import java.awt.Graphics2D;

public class Decorate extends DrawShape {
	private DrawShape dShape;
	public Decorate(DrawShape dShape) {
		this.dShape=dShape;
	}
	public void draw(Graphics2D g, int x, int y, int x1, int y1) {
		

	}

}
