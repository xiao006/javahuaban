package com.decorate;

import java.awt.BasicStroke;
import java.awt.Graphics2D;

import com.GUI.Jpanel;


public class DrawTrilateral extends Decorate{
	public DrawTrilateral(DrawShape dShape) {
		super(dShape);
	}

	public void draw(Graphics2D g, int x, int y, int x1, int y1) {
		int i=p.use();	
		g.setStroke(new BasicStroke(i));
		Jpanel jp=new Jpanel();
		jp.n=3;
		jp.x=new int[] {x,x1,x};
		jp.y=new int[] {y,y1,y1};
		jp.paintCompent(g);

	}
}
