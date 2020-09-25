package com.simple;
import java.awt.Graphics2D;

import com.decorate.DrawShape;

public abstract class Shape extends DrawShape{
	public abstract void draw(Graphics2D g,int x,int y,int x1,int y1);
}
