package com.simple;
import java.awt.BasicStroke;
import java.awt.Graphics2D;

import com.GUI.Jpanel;

public class Rectangle extends Shape {

	
	public void draw(Graphics2D g, int x, int y, int x1, int y1) {
		int i=p.use();	
		g.setStroke(new BasicStroke(i));
		Jpanel jp=new Jpanel();
		jp.n=4;
		jp.x=new int[]{x,x,x1,x1};
		jp.y=new int[]{y,y1,y1,y};
		jp.paintCompent(g);
	}

}

