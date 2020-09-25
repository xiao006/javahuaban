package com.GUI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Panel extends JPanel{
	public ArrayList<BufferedImage> Images = new ArrayList<>();
	public ArrayList<Shapedian> shapes=new ArrayList<Shapedian>();
	private BufferedImage baseImage;
	private BufferedImage saveImage;
	private Graphics2D g2d;
	
	public Panel(){
		setBounds(225,10,540,440);
		setBorder(BorderFactory.createLineBorder(getForeground()));
		setBackground(Color.white);
		setLayout(null);
		setVisible(true);
		baseImage = new BufferedImage(getWidth(), getHeight(),BufferedImage.TYPE_INT_ARGB);
		g2d = (Graphics2D) baseImage.getGraphics();
	}

	public void paint(Graphics g) {
		//System.out.println("666");
		super.paint(g);
		for(int i=0;i<Images.size();i++){
			BufferedImage mi = Images.get(i);
			g.drawImage(mi,0, 0, this);
		}
		repaint();
	}
	public void imgAdd(BufferedImage img){
			Images.add(img);
			System.out.println("|imagesize:"+Images.size());
	}
	public void shapeAdd(Shapedian s) {
			shapes.add(s);
			System.out.println("|shapesize:"+shapes.size());
	}
	public void reset(){
		baseImage = new BufferedImage(getWidth(), getHeight(),BufferedImage.TYPE_INT_ARGB);
		g2d = (Graphics2D) baseImage.getGraphics();
		Images = new ArrayList<>();
		shapes = new ArrayList<Shapedian>();
	}
	public void open(String path) {
		BufferedImage openImage;
		File f = new File(path);
		System.out.println(path);
		try {
			openImage=ImageIO.read(f);
			if(openImage!=null) {
				reset();
				Images.add(openImage);
				shapes.add(new Shapedian());
			}else {
				System.out.println("打开失败");
			}
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	public void save(String Path){
		saveImage = new BufferedImage(getWidth(), getHeight(),BufferedImage.TYPE_INT_ARGB);
		Graphics2D g = (Graphics2D) saveImage.getGraphics(); 
		g.setColor(Color.white);
		//g.fillRect(0, 0,getWidth(), getHeight());
		//g.drawImage(baseImage, 0, 0,null);
		for(int i=0;i<Images.size();i++){
			BufferedImage mi = Images.get(i);
			g.drawImage(mi,0, 0, this);
		}
		if(!Path.endsWith(".png")) {
			Path=Path+".png";
		}
		File f = new File(Path);
		System.out.println(Path);
		try {
			ImageIO.write(saveImage, "png", f);
			if(f.exists()){
				JOptionPane.showMessageDialog(null, "保存成功", "", JOptionPane.INFORMATION_MESSAGE);
			}else{
				JOptionPane.showMessageDialog(null, "保存失败,请重试!", "", JOptionPane.INFORMATION_MESSAGE);
			}
		} catch (IOException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "保存失败,请重试!", "", JOptionPane.INFORMATION_MESSAGE);
		}
	}
}

