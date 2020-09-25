package com.bridge;
public class Pencil implements Pen {
	private int x=3;
	public Pencil() {
		
	}
	public Pencil(Pen p) {
		this.x=p.use();
	}
	public int use() {
		return x;
	}
	public void Add() {
		this.x++;
	}
	public void reduce() {
		if(x>1) {
		this.x--;}
	}
	public Pen kel() {
		return new Pencil(this);
	}
}
