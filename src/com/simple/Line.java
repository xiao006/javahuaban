package com.simple;

import java.awt.BasicStroke;
import java.awt.Graphics2D;

import com.GUI.Jpanel;

public class Line extends Shape {

	
	public void draw(Graphics2D g, int x, int y, int x1, int y1) {
		int i=p.use();	
		g.setStroke(new BasicStroke(i));
		Jpanel jp=new Jpanel();
		jp.n=2;
		jp.x=new int[] {x,x1};
		jp.y=new int[] {y,y1};
		jp.paintLine(g);
	}

}
