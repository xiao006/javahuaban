package com.GUI;

import java.awt.Graphics2D;

public class Jpanel {
	public int n=0;
	public int x[]=null;
	public int y[]=null;
	public void paintCompent(Graphics2D g) {//?????
		
		g.drawPolygon(x,y,n);
		
	}
	public void paintCompent1(Graphics2D g) {//???
		
		g.drawOval(x[0],x[1],x[2],x[3]);
	}
	public void paintLine(Graphics2D g) {//???
		
		g.drawLine(x[0], y[0], x[1], y[1]);
	}
}
