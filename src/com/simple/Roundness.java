package com.simple;

import java.awt.BasicStroke;
import java.awt.Graphics2D;

import com.GUI.Jpanel;

public class Roundness extends Shape {

	
	public void draw(Graphics2D g, int x, int y, int x1, int y1) {
		int i=p.use();	
		g.setStroke(new BasicStroke(i));
		Jpanel jp=new Jpanel();
		jp.x=new int[] {x<x1? x:x1,y<y1? y:y1,(x1-x)>0? (x1-x):(x-x1),(y1-y)>0? (y1-y):(y-y1)};
		jp.paintCompent1(g);
		
	}

}
