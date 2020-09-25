package com.decorate;
import java.awt.Graphics2D;
import com.bridge.Pen;

public abstract class DrawShape {
	public Pen p;
	public void setPen(Pen p){
		this.p=p;
	}
	public abstract void draw(Graphics2D g, int x, int y, int x1, int y1);
}
