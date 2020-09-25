package com.GUI;

import java.awt.Color;

import com.bridge.Pen;

public class Shapedian {
	private int m;
	private int x;
	private int y;
	private int x1;
	private int y1;
	private Color color;
	private Pen pen;
	public Shapedian() {
		
	}
	public Shapedian(int m,int x,int y,int x1,int y1,Color color,Pen pen) {
		this.x=x;
		this.y=y;
		this.x1=x1;
		this.y1=y1;
		this.m=m;
		this.color=color;
		this.pen=pen;
	}
	public Shapedian(Shapedian s1) {
		this.x=s1.getX();
		this.y=s1.getY();
		this.x1=s1.getX1();
		this.y1=s1.getY1();
		this.m=s1.getM();
		this.color=s1.getColor();
		this.pen=s1.getPen();
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getX1() {
		return x1;
	}
	public void setX1(int x1) {
		this.x1 = x1;
	}
	public int getY1() {
		return y1;
	}
	public void setY1(int y1) {
		this.y1 = y1;
	}
	public int getM() {
		return m;
	}
	public void setM(int m) {
		this.m = m;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public Pen getPen() {
		return pen;
	}
	public void setPen(Pen pen) {
		this.pen = pen;
	}
}
