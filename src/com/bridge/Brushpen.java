package com.bridge;


public class Brushpen implements Pen {
	private int x=15;
	public Brushpen() {
		
	}
	public Brushpen(Pen p) {
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
		return new Brushpen(this);
	}
	
}
