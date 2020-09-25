package com.GUI;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.bridge.Brushpen;
import com.bridge.Pen;
import com.bridge.Pencil;
import com.decorate.DrawLine;
import com.decorate.DrawRectangle;
import com.decorate.DrawRoundness;
import com.decorate.DrawShape;
import com.decorate.DrawTrilateral;
import com.simple.Shape;
import com.simple.ShapeFactory;
public class MyFrame extends JFrame{
	static Panel drawPanel=new Panel();
	Shapedian dd1=null;
	DrawShape de1=null;
	Pen p1=new Pencil();
	static int x=0;
	static int y=0;
	static int x1=0;
	static int y1=0;
	static BufferedImage temp;
	static String name="";
	static String Path = "D:";
	static int flag=-1;
	Color color=Color.black;
	static boolean draw = false;
	static boolean dian = false;
	int dum;
	public MyFrame() {
		
		showPanel();
		showFrame();
		
	}
	public void showFrame() {
		this.setTitle("绘画");
		this.setLayout(null);
		this.setBounds(300, 100, 800, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	public void showPanel() {
		final JTextField jf1=new JTextField("图形");
		jf1.setHorizontalAlignment(JTextField.CENTER);
		jf1.setEditable(false);
		
		final JTextField jf2=new JTextField("装饰");
		jf2.setHorizontalAlignment(JTextField.CENTER);
		jf2.setEditable(false);
		
		final JTextField jf3=new JTextField("功能");
		jf3.setHorizontalAlignment(JTextField.CENTER);
		jf3.setEditable(false);
		
		final JButton jbx=new JButton("线条");
		jbx.setBackground(Color.white);
		jbx.setFocusPainted(false);
		
		final JButton jbj=new JButton("矩形");	
		jbj.setFocusPainted(false);
		jbj.setBackground(Color.white);
		

		final JButton jby=new JButton("圆形");
		jby.setFocusPainted(false);
		jby.setBackground(Color.white);
		
		final JButton jbs=new JButton("三角形");
		jbs.setFocusPainted(false);
		jbs.setBackground(Color.white);
		
		jbx.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(jbx.getBackground()==Color.white) {
				flag=0;
				jbx.setBackground(Color.orange);
				jbj.setEnabled(false);
				jby.setEnabled(false);
				jbs.setEnabled(false);
				name="线条";}
				else {
					flag=-1;
					jbx.setBackground(Color.white);
					jbj.setEnabled(true);
					jby.setEnabled(true);
					jbs.setEnabled(true);
					name="";
				}
			}
		});
		jbj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(jbj.getBackground()==Color.white) {
				flag=0;
				jbj.setBackground(Color.orange);
				jbx.setEnabled(false);
				jby.setEnabled(false);
				jbs.setEnabled(false);
				name="矩形";}
				else {
					flag=-1;
					jbj.setBackground(Color.white);
					jbx.setEnabled(true);
					jby.setEnabled(true);
					jbs.setEnabled(true);
					name="";
				}
			}
		});
		jby.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(jby.getBackground()==Color.white) {
				flag=0;
				jby.setBackground(Color.orange);
				jbx.setEnabled(false);
				jbj.setEnabled(false);
				jbs.setEnabled(false);
				name="圆形";}
				else {
					flag=-1;
					jby.setBackground(Color.white);
					jbx.setEnabled(true);
					jbj.setEnabled(true);
					jbs.setEnabled(true);
					name="";	
				}
			}
		});
		jbs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(jbs.getBackground()==Color.white) {
				flag=0;
				jbs.setBackground(Color.orange);
				jbx.setEnabled(false);
				jbj.setEnabled(false);
				jby.setEnabled(false);
				name="三角形";}
				else {
					flag=-1;
					jbs.setBackground(Color.white);
					jbx.setEnabled(true);
					jbj.setEnabled(true);
					jby.setEnabled(true);
					name="";
				}
			}
		});
		final JPanel jp1=new JPanel();
		jp1.setBorder(BorderFactory.createLineBorder(getForeground()));
		jp1.setBounds(10,10,200,120);
		jp1.setBackground(Color.white);
		jp1.setLayout(null);//
		jf1.setBounds(2, 2, 30, 20);
		jp1.add(jf1);//
		jbx.setBounds(10, 35, 80, 30);
		jp1.add(jbx);//
		jbj.setBounds(110, 35, 80, 30);
		jp1.add(jbj);//
		jby.setBounds(10, 70, 80, 30);
		jp1.add(jby);//
		jbs.setBounds(110, 70, 80, 30);
		jp1.add(jbs);//
		final JButton jzsbx=new JButton("线条");
		jzsbx.setFocusPainted(false);
		jzsbx.setBackground(Color.white);
		
		final JButton jzsbj=new JButton("矩形");	
		jzsbj.setFocusPainted(false);
		jzsbj.setBackground(Color.white);
		
		final JButton jzsby=new JButton("圆形");
		jzsby.setFocusPainted(false);
		jzsby.setBackground(Color.white);
		
		final JButton jzsbs=new JButton("三角形");
		jzsbs.setFocusPainted(false);
		jzsbs.setBackground(Color.white);
		jzsbx.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				flag=1;
				jzsbx.setBackground(Color.orange);
				jzsbj.setBackground(Color.white);
				jzsbs.setBackground(Color.white);
				jzsby.setBackground(Color.white);
			}
		});
		jzsbj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				flag=2;
				jzsbj.setBackground(Color.orange);
				jzsbx.setBackground(Color.white);
				jzsbs.setBackground(Color.white);
				jzsby.setBackground(Color.white);
			}
		});
		jzsby.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				flag=3;
				jzsby.setBackground(Color.orange);
				jzsbx.setBackground(Color.white);
				jzsbj.setBackground(Color.white);
				jzsbs.setBackground(Color.white);
			}
		});
		jzsbs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				flag=4;
				jzsbs.setBackground(Color.orange);
				jzsbx.setBackground(Color.white);
				jzsbj.setBackground(Color.white);
				jzsby.setBackground(Color.white);
			}
		});
		final JPanel jp2=new JPanel();
		jp2.setBorder(BorderFactory.createLineBorder(getForeground()));
		jp2.setBounds(10,140,200,120);
		jp2.setBackground(Color.white);
		jp2.setLayout(null);
		jf2.setBounds(2, 2, 30, 20);
		jp2.add(jf2);
		jzsbx.setBounds(10, 35, 80, 30);
		jp2.add(jzsbx);//
		jzsbj.setBounds(110, 35, 80, 30);
		jp2.add(jzsbj);//
		jzsby.setBounds(10, 70, 80, 30); 
		jp2.add(jzsby);//
		jzsbs.setBounds(110, 70, 80, 30);
		jp2.add(jzsbs);//
		final JButton j1=new JButton("铅笔");
		j1.setFocusPainted(false);
		j1.setBackground(Color.orange);
		final JButton j2=new JButton("毛笔");	
		j2.setFocusPainted(false);
		j2.setBackground(Color.white);
		j1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				j1.setBackground(Color.orange);
				j2.setBackground(Color.white);
				p1=new Pencil();
			}
		});
		j2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				j2.setBackground(Color.orange);
				j1.setBackground(Color.white);
				p1=new Brushpen();
			}
		});
		final JButton j3=new JButton("加粗");
		j3.setFocusPainted(false);
		j3.setBackground(Color.white);
		final JButton j4=new JButton("变细");
		j4.setFocusPainted(false);
		j4.setBackground(Color.white);
		j3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(dian==false) {
				j3.setBackground(Color.orange);
				j4.setBackground(Color.white);
				p1.Add();}
				if(dian==true) {
					dian=false;
					if(dd1!=null) {
						switch(dd1.getM()) {
						case 1:
							temp = new BufferedImage(drawPanel.getWidth(), drawPanel.getHeight(),BufferedImage.TYPE_INT_ARGB);
							Graphics2D g2d1 = temp.createGraphics();
							g2d1.setColor(dd1.getColor());
							de1=new DrawLine(de1);
							Pen ppPen=dd1.getPen();
							ppPen.Add();
							de1.setPen(ppPen);
							de1.draw(g2d1,dd1.getX(), dd1.getY(), 
									dd1.getX1(),dd1.getY1());
							drawPanel.Images.set(dum, temp);
							drawPanel.shapes.set(dum,new Shapedian(1,dd1.getX(), 
									dd1.getY(),dd1.getX1(),dd1.getY1(),
									dd1.getColor(),ppPen));
							break;
						case 2:
							temp = new BufferedImage(drawPanel.getWidth(), drawPanel.getHeight(),BufferedImage.TYPE_INT_ARGB);
							Graphics2D g2d2 = temp.createGraphics();
							g2d2.setColor(dd1.getColor());
							de1=new DrawRectangle(de1);
							Pen ppPen1=dd1.getPen();
							ppPen1.Add();
							de1.setPen(ppPen1);
							de1.draw(g2d2,dd1.getX(), dd1.getY(), 
									dd1.getX1(),dd1.getY1());
							drawPanel.Images.set(dum, temp);
							drawPanel.shapes.set(dum,new Shapedian(2,dd1.getX(), 
									dd1.getY(),dd1.getX1(),dd1.getY1(),
									dd1.getColor(),ppPen1));
							break;
						case 3:
							temp = new BufferedImage(drawPanel.getWidth(), drawPanel.getHeight(),BufferedImage.TYPE_INT_ARGB);
							Graphics2D g2d3 = temp.createGraphics();
							g2d3.setColor(dd1.getColor());
							de1=new DrawRoundness(de1);
							Pen ppPen2=dd1.getPen();
							ppPen2.Add();
							de1.setPen(ppPen2);
							de1.draw(g2d3,dd1.getX(), dd1.getY(), 
									dd1.getX1(),dd1.getY1());
							drawPanel.Images.set(dum, temp);
							drawPanel.shapes.set(dum,new Shapedian(3,dd1.getX(), 
									dd1.getY(),dd1.getX1(),dd1.getY1(),
									dd1.getColor(),ppPen2));
							break;
						case 4:
							temp = new BufferedImage(drawPanel.getWidth(), drawPanel.getHeight(),BufferedImage.TYPE_INT_ARGB);
							Graphics2D g2d4 = temp.createGraphics();
							g2d4.setColor(dd1.getColor());
							de1=new DrawTrilateral(de1);
							Pen ppPen3=dd1.getPen();
							ppPen3.Add();
							de1.setPen(ppPen3);
							de1.draw(g2d4,dd1.getX(), dd1.getY(), 
									dd1.getX1(),dd1.getY1());
							drawPanel.Images.set(dum, temp);
							drawPanel.shapes.set(dum,new Shapedian(4,dd1.getX(), 
									dd1.getY(),dd1.getX1(),dd1.getY1(),
									dd1.getColor(),ppPen3));
							break;
						}
						}
				}
			}
		});
		j4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(dian==false) {
				j4.setBackground(Color.orange);
				j3.setBackground(Color.white);
				p1.reduce();}
				if(dian==true) {
					dian=false;
					if(dd1!=null) {
						switch(dd1.getM()) {
						case 1:
							temp = new BufferedImage(drawPanel.getWidth(), drawPanel.getHeight(),BufferedImage.TYPE_INT_ARGB);
							Graphics2D g2d1 = temp.createGraphics();
							g2d1.setColor(dd1.getColor());
							de1=new DrawLine(de1);
							Pen ppPen=dd1.getPen();
							ppPen.reduce();
							de1.setPen(ppPen);
							de1.draw(g2d1,dd1.getX(), dd1.getY(), 
									dd1.getX1(),dd1.getY1());
							drawPanel.Images.set(dum, temp);
							drawPanel.shapes.set(dum,new Shapedian(1,dd1.getX(), 
									dd1.getY(),dd1.getX1(),dd1.getY1(),
									dd1.getColor(),ppPen));
							break;
						case 2:
							temp = new BufferedImage(drawPanel.getWidth(), drawPanel.getHeight(),BufferedImage.TYPE_INT_ARGB);
							Graphics2D g2d2 = temp.createGraphics();
							g2d2.setColor(dd1.getColor());
							de1=new DrawRectangle(de1);
							Pen ppPen1=dd1.getPen();
							ppPen1.reduce();
							de1.setPen(ppPen1);
							de1.draw(g2d2,dd1.getX(), dd1.getY(), 
									dd1.getX1(),dd1.getY1());
							drawPanel.Images.set(dum, temp);
							drawPanel.shapes.set(dum,new Shapedian(2,dd1.getX(), 
									dd1.getY(),dd1.getX1(),dd1.getY1(),
									dd1.getColor(),ppPen1));
							break;
						case 3:
							temp = new BufferedImage(drawPanel.getWidth(), drawPanel.getHeight(),BufferedImage.TYPE_INT_ARGB);
							Graphics2D g2d3 = temp.createGraphics();
							g2d3.setColor(dd1.getColor());
							de1=new DrawRoundness(de1);
							Pen ppPen2=dd1.getPen();
							ppPen2.reduce();
							de1.setPen(ppPen2);
							de1.draw(g2d3,dd1.getX(), dd1.getY(), 
									dd1.getX1(),dd1.getY1());
							drawPanel.Images.set(dum, temp);
							drawPanel.shapes.set(dum,new Shapedian(3,dd1.getX(), 
									dd1.getY(),dd1.getX1(),dd1.getY1(),
									dd1.getColor(),ppPen2));
							break;
						case 4:
							temp = new BufferedImage(drawPanel.getWidth(), drawPanel.getHeight(),BufferedImage.TYPE_INT_ARGB);
							Graphics2D g2d4 = temp.createGraphics();
							g2d4.setColor(dd1.getColor());
							de1=new DrawTrilateral(de1);
							Pen ppPen3=dd1.getPen();
							ppPen3.reduce();
							de1.setPen(ppPen3);
							de1.draw(g2d4,dd1.getX(), dd1.getY(), 
									dd1.getX1(),dd1.getY1());
							drawPanel.Images.set(dum, temp);
							drawPanel.shapes.set(dum,new Shapedian(4,dd1.getX(), 
									dd1.getY(),dd1.getX1(),dd1.getY1(),
									dd1.getColor(),ppPen3));
							break;
						}
					}
				}
			}
		});
		final JButton j5=new JButton("颜色");
		j5.setFocusPainted(false);
		j5.setBackground(Color.white);
		j5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(dian==false) {
				color=JColorChooser.showDialog(null,"选择颜色",j5.getForeground());
				j5.setBackground(color);}
				if(dian==true) {
				dian=false;
				Color	c1=JColorChooser.showDialog(null,"选择颜色",j5.getForeground());
				if(dd1!=null) {
					switch(dd1.getM()) {
					case 1:
						temp = new BufferedImage(drawPanel.getWidth(), drawPanel.getHeight(),BufferedImage.TYPE_INT_ARGB);
						Graphics2D g2d1 = temp.createGraphics();
						g2d1.setColor(c1);
						de1=new DrawLine(de1);
						de1.setPen(dd1.getPen());
						de1.draw(g2d1,dd1.getX(), dd1.getY(), 
								dd1.getX1(),dd1.getY1());
						drawPanel.Images.set(dum, temp);
						drawPanel.shapes.set(dum,new Shapedian(1,dd1.getX(), 
								dd1.getY(),dd1.getX1(),dd1.getY1(),
								c1,dd1.getPen()));
						break;
					case 2:
						temp = new BufferedImage(drawPanel.getWidth(), drawPanel.getHeight(),BufferedImage.TYPE_INT_ARGB);
						Graphics2D g2d2 = temp.createGraphics();
						g2d2.setColor(c1);
						de1=new DrawRectangle(de1);
						de1.setPen(dd1.getPen());
						de1.draw(g2d2,dd1.getX(), dd1.getY(), 
								dd1.getX1(),dd1.getY1());
						drawPanel.Images.set(dum, temp);
						drawPanel.shapes.set(dum,new Shapedian(2,dd1.getX(), 
								dd1.getY(),dd1.getX1(),dd1.getY1(),
								c1,dd1.getPen()));
						break;
					case 3:
						temp = new BufferedImage(drawPanel.getWidth(), drawPanel.getHeight(),BufferedImage.TYPE_INT_ARGB);
						Graphics2D g2d3 = temp.createGraphics();
						g2d3.setColor(c1);
						de1=new DrawRoundness(de1);
						de1.setPen(dd1.getPen());
						de1.draw(g2d3,dd1.getX(), dd1.getY(), 
								dd1.getX1(),dd1.getY1());
						drawPanel.Images.set(dum, temp);
						drawPanel.shapes.set(dum,new Shapedian(3,dd1.getX(), 
								dd1.getY(),dd1.getX1(),dd1.getY1(),
								c1,dd1.getPen()));
						break;
					case 4:
						temp = new BufferedImage(drawPanel.getWidth(), drawPanel.getHeight(),BufferedImage.TYPE_INT_ARGB);
						Graphics2D g2d4 = temp.createGraphics();
						g2d4.setColor(c1);
						de1=new DrawTrilateral(de1);
						de1.setPen(dd1.getPen());
						de1.draw(g2d4,dd1.getX(), dd1.getY(), 
								dd1.getX1(),dd1.getY1());
						drawPanel.Images.set(dum, temp);
						drawPanel.shapes.set(dum,new Shapedian(4,dd1.getX(), 
								dd1.getY(),dd1.getX1(),dd1.getY1(),
								c1,dd1.getPen()));
						break;
					}
					}
			}
				}
		});
		final JButton j6=new JButton("撤销");
		j6.setFocusPainted(false);
		j6.setBackground(Color.white);
		j6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				j6.setBackground(Color.orange);
				if(drawPanel.Images.size()>0){
					drawPanel.Images.remove(drawPanel.Images.size()-1);
					
					drawPanel.shapes.remove(drawPanel.shapes.size()-1);
					
				}else{
					JOptionPane.showMessageDialog(null, "不能再撤销啦!", "提示", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		final JButton j7=new JButton("重置");
		j7.setFocusPainted(false);
		j7.setBackground(Color.white);
		
		final JButton j8=new JButton("保存");
		j8.setFocusPainted(false);
		j8.setBackground(Color.white);
		j8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				j8.setBackground(Color.orange);
				JFileChooser jfc = new JFileChooser();
				jfc.setDialogTitle("路径选择");
				FileNameExtensionFilter filter = new FileNameExtensionFilter(
				        "PNG 文件", "png");
				jfc.setFileFilter(filter);
				jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);//只能选文件夹
				int re = jfc.showSaveDialog(drawPanel);
				if(re == JFileChooser.APPROVE_OPTION){//0
					Path = jfc.getSelectedFile().toPath().toString();//路径
					drawPanel.save(Path);
				}	
			}
		});
		JSlider j9 = new JSlider(-100,250,2);
		j9.setBackground(Color.white);
		j9.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				int sWidth = j9.getValue();
				dian=false;
				if(dd1!=null) {
					switch(dd1.getM()) {
					case 1:
						temp = new BufferedImage(drawPanel.getWidth(), drawPanel.getHeight(),BufferedImage.TYPE_INT_ARGB);
						Graphics2D g2d1 = temp.createGraphics();
						//g2d1.setStroke(new BasicStroke(sWidth));
						g2d1.setColor(dd1.getColor());
						de1=new DrawLine(de1);
						de1.setPen(dd1.getPen());
						de1.draw(g2d1,dd1.getX(), dd1.getY(), 
								dd1.getX1()+sWidth,dd1.getY1()+sWidth);
						drawPanel.Images.set(dum, temp);
						drawPanel.shapes.set(dum,new Shapedian(1,dd1.getX(), 
								dd1.getY(),dd1.getX1()+sWidth,dd1.getY1()+sWidth,
								dd1.getColor(),dd1.getPen()));
						break;
					case 2:
						temp = new BufferedImage(drawPanel.getWidth(), drawPanel.getHeight(),BufferedImage.TYPE_INT_ARGB);
						Graphics2D g2d2 = temp.createGraphics();
						g2d2.setColor(dd1.getColor());
						de1=new DrawRectangle(de1);
						de1.setPen(dd1.getPen());
						de1.draw(g2d2,dd1.getX(), dd1.getY(), 
								dd1.getX1()+sWidth,dd1.getY1()+sWidth);
						drawPanel.Images.set(dum, temp);
						drawPanel.shapes.set(dum,new Shapedian(2,dd1.getX(), dd1.getY(), 
								dd1.getX1()+sWidth,dd1.getY1()+sWidth
								,dd1.getColor(),dd1.getPen()));
						break;
					case 3:
						temp = new BufferedImage(drawPanel.getWidth(), drawPanel.getHeight(),BufferedImage.TYPE_INT_ARGB);
						Graphics2D g2d3 = temp.createGraphics();
						g2d3.setColor(dd1.getColor());
						de1=new DrawRoundness(de1);
						de1.setPen(dd1.getPen());
						de1.draw(g2d3,dd1.getX(), dd1.getY(), 
								dd1.getX1()+sWidth,dd1.getY1()+sWidth);
						drawPanel.Images.set(dum, temp);
						drawPanel.shapes.set(dum,new Shapedian(3,dd1.getX(), dd1.getY(), 
								dd1.getX1()+sWidth,dd1.getY1()+sWidth,
								dd1.getColor(),dd1.getPen()));
						break;
					case 4:
						temp = new BufferedImage(drawPanel.getWidth(), drawPanel.getHeight(),BufferedImage.TYPE_INT_ARGB);
						Graphics2D g2d4 = temp.createGraphics();
						g2d4.setColor(dd1.getColor());
						de1=new DrawTrilateral(de1);
						de1.setPen(dd1.getPen());
						de1.draw(g2d4,dd1.getX(), dd1.getY(), 
								dd1.getX1()+sWidth,dd1.getY1()+sWidth);
						drawPanel.Images.set(dum, temp);
						drawPanel.shapes.set(dum,new Shapedian(4,dd1.getX(), dd1.getY(), 
								dd1.getX1()+sWidth,dd1.getY1()+sWidth,
								dd1.getColor(),dd1.getPen()
								));
						break;
					}
					}
			}
		});
		final JPanel jp3=new JPanel();
		jp3.setBorder(BorderFactory.createLineBorder(getForeground()));
		jp3.setBounds(10,270,200,185);
		jp3.setBackground(Color.white);
		jp3.setLayout(null);
		jf3.setBounds(2, 2, 30, 20);
		jp3.add(jf3);
		final JTextField j91=new JTextField("小");
		jf1.setHorizontalAlignment(JTextField.CENTER);
		jf1.setEditable(false);
		final JTextField j92=new JTextField("大");
		jf1.setHorizontalAlignment(JTextField.CENTER);
		jf1.setEditable(false);
		j91.setBounds(40, 4, 18, 20);
		j92.setBounds(175, 4, 18, 20);
		j9.setBounds(60, 2,114, 25);
		jp3.add(j91);//
		jp3.add(j92);//
		jp3.add(j9);//
		j1.setBounds(10, 35, 80, 30);
		jp3.add(j1);//
		j2.setBounds(110, 35, 80, 30);
		jp3.add(j2);//
		j3.setBounds(10, 70, 80, 30); 
		jp3.add(j3);//
		j4.setBounds(110, 70, 80, 30);
		jp3.add(j4);//
		j5.setBounds(10, 105, 80, 30);
		jp3.add(j5);//
		j6.setBounds(110, 105, 80, 30);
		jp3.add(j6);//
		j7.setBounds(10, 140, 80, 30);
		jp3.add(j7);//
		j8.setBounds(110, 140, 80, 30);
		jp3.add(j8);//
		this.add(jp1);
		this.add(jp2);
		this.add(jp3);
		final JButton jopen=new JButton("打开");
		jopen.setBounds(5, 5,80, 25);
		jopen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jopen.setBackground(Color.orange);
				JFileChooser jfc = new JFileChooser();
				jfc.setDialogTitle("路径选择");
				FileNameExtensionFilter filter = new FileNameExtensionFilter(
				        "PNG 文件", "png");
				jfc.setFileFilter(filter);
				//jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);//只能选文件夹
				int re = jfc.showOpenDialog(drawPanel);
				if(re == JFileChooser.APPROVE_OPTION){//0
					Path = jfc.getSelectedFile().toPath().toString();//路径
					drawPanel.open(Path);
				}	
			}
		});
		drawPanel.add(jopen);
j7.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				j7.setBackground(Color.orange);
				if(drawPanel.Images.size()>0){
					drawPanel.reset();
				}
				x=0;	y=0;	x1=0;	y1=0;	name="";	flag=-1;
				color=Color.black;	draw = false; p1=new Pencil();dd1=null;
				dian=false;de1=null;
				jbx.setEnabled(true);jbj.setEnabled(true);
				jby.setEnabled(true);jbs.setEnabled(true);
				jbs.setBackground(Color.white);jbx.setBackground(Color.white);
				jbj.setBackground(Color.white);jby.setBackground(Color.white);
				jzsbs.setBackground(Color.white);jzsbx.setBackground(Color.white);
				jzsbj.setBackground(Color.white);jzsby.setBackground(Color.white);
				j1.setBackground(Color.orange);j2.setBackground(Color.white);
				j3.setBackground(Color.white);j4.setBackground(Color.white);
				j5.setBackground(Color.white);j6.setBackground(Color.white);
				j7.setBackground(Color.white);j8.setBackground(Color.white);
				jopen.setBackground(Color.white);
			}
		});
		drawPanel.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				//System.out.println("Pressed:x:"+e.getX()+":y:"+e.getY());
				if(!draw&&dian==false&&flag!=-1) {
					System.out.println("绘画开始");
					draw=true;
					x=e.getX();
					y=e.getY();
					x1=e.getX();
					y1=e.getY();
					drawPanel.imgAdd(new BufferedImage(drawPanel.getWidth(),drawPanel.getHeight() ,BufferedImage.TYPE_INT_ARGB));
					drawPanel.shapeAdd(new Shapedian(0,x, y, x1, y1,color,p1));
				}
				if(!draw&&dian==true&&flag==-1) {
					System.out.println("选取开始");
				}
			}
			public void mouseReleased(MouseEvent e) {
				//System.out.println("Released:"+drawPanel.Images.size());
				if(draw&&dian==false&&flag!=-1){	
					System.out.println("绘画结束");
					draw = false;
					flag=-1;
					jzsbx.setBackground(Color.white);//
					jzsbj.setBackground(Color.white);
					jzsby.setBackground(Color.white);
					jzsbs.setBackground(Color.white);
				}
				if(dian&&!draw) {
					System.out.println("选取结束");
					dian=false;
				}
			}
			public void mouseClicked(MouseEvent e) {
				if(dian==false&&flag==-1) {
				System.out.println("点击成功");
				x=e.getX();
				y=e.getY();
				dian=true;
				boolean m=false;
				for(int i=0;i<drawPanel.shapes.size();i++) {
					if(drawPanel.shapes.get(i).getM()==1) {//线条
						int xi=drawPanel.shapes.get(i).getX();
						int yi=drawPanel.shapes.get(i).getY();
						int xj=drawPanel.shapes.get(i).getX1();
						int yj=drawPanel.shapes.get(i).getY1();
						int i1=xi>xj? xi:xj;
						int i2=yi>yj? yi:yj;
						int i3=xi<xj? xi:xj;
						int i4=yi<yj? yi:yj;
						double k=(double)(xj-xi)/(yj-yi);
						if((Math.abs(x-k*y-xi+k*yi)/Math.sqrt(k*k+1)<=8)&&x>=i3&&x<=i1&&y<=i2&&y>=i4) {
							m=true;
							dd1=new Shapedian(drawPanel.shapes.get(i));
							dum=i;
							break;	
						}
					}
					if(drawPanel.shapes.get(i).getM()==2) {//矩形
						int xi=drawPanel.shapes.get(i).getX()<drawPanel.shapes.get(i).getX1()? drawPanel.shapes.get(i).getX():drawPanel.shapes.get(i).getX1();
						int yi=drawPanel.shapes.get(i).getY()<drawPanel.shapes.get(i).getY1()? drawPanel.shapes.get(i).getY():drawPanel.shapes.get(i).getY1();
						int xj=drawPanel.shapes.get(i).getX()>drawPanel.shapes.get(i).getX1()? drawPanel.shapes.get(i).getX():drawPanel.shapes.get(i).getX1();
						int yj=drawPanel.shapes.get(i).getY()>drawPanel.shapes.get(i).getY1()? drawPanel.shapes.get(i).getY():drawPanel.shapes.get(i).getY1();
						if(x>=xi&&x<=xj&&y<=yj&&y>=yi ) {
							m=true;
							dd1=new Shapedian(drawPanel.shapes.get(i));
							dum=i;
							break;	
						}
					}
					if(drawPanel.shapes.get(i).getM()==3) {//圆形
						int xi=drawPanel.shapes.get(i).getX()<drawPanel.shapes.get(i).getX1()? drawPanel.shapes.get(i).getX():drawPanel.shapes.get(i).getX1();
						int yi=drawPanel.shapes.get(i).getY()<drawPanel.shapes.get(i).getY1()? drawPanel.shapes.get(i).getY():drawPanel.shapes.get(i).getY1();
						int xj=drawPanel.shapes.get(i).getX()>drawPanel.shapes.get(i).getX1()? drawPanel.shapes.get(i).getX():drawPanel.shapes.get(i).getX1();
						int yj=drawPanel.shapes.get(i).getY()>drawPanel.shapes.get(i).getY1()? drawPanel.shapes.get(i).getY():drawPanel.shapes.get(i).getY1();
						if(x>=xi&&x<=xj&&y<=yj&&y>=yi ) {
							m=true;
							dd1=new Shapedian(drawPanel.shapes.get(i));
							dum=i;
							break;	
						}
					}
					if(drawPanel.shapes.get(i).getM()==4) {//三角形
						int xi=drawPanel.shapes.get(i).getX();
						int yi=drawPanel.shapes.get(i).getY();
						int xj=drawPanel.shapes.get(i).getX1();
						int yj=drawPanel.shapes.get(i).getY1();
						double k=(double)(xj-xi)/(yj-yi);					
						int d1=Math.abs(y-yj);
						int d2=Math.abs(x-xi);
						int d3=(int) (Math.abs(x-k*y-xi+k*yi)/Math.sqrt(k*k+1));		
						int d=(int) Math.sqrt((yj-yi)*(yj-yi)+(xj-xi)*(xj-xi));
						if((d1*Math.abs(xi-xj))+(d2*Math.abs(yi-yj))+(d*d3)<=(Math.abs(yi-yj)*Math.abs(xi-xj))) {
							m=true;
							dd1=new Shapedian(drawPanel.shapes.get(i));
							dum=i;
							break;	
						}
					}
				}
				if(m==false) {
					dd1=null;
					dum=-1;
					dian=false;
					JOptionPane.showMessageDialog(null, "请确认点击位置", "", JOptionPane.INFORMATION_MESSAGE);
				}
				}
			}
			
				});
	drawPanel.addMouseMotionListener(new MouseMotionListener() {

		public void mouseMoved(MouseEvent e) {
		}
		
		public void mouseDragged(MouseEvent e) {
			if(draw&&dian==false) {
				System.out.println("开始绘画");
			switch(flag) {
			case 0:
				int m=0;
				if(name.equals("线条")) {
					m=1;
				}
				if(name.equals("矩形")) {
					m=2;
				}
				if(name.equals("圆形")) {
					m=3;
				}
				if(name.equals("三角形")) {
					m=4;
				}
				temp = new BufferedImage(drawPanel.getWidth(), drawPanel.getHeight(),BufferedImage.TYPE_INT_ARGB);
				Graphics2D g2d = temp.createGraphics();
				g2d.setColor(color);
				Shape s1= ShapeFactory.produce(name);
				Pen pen=p1.kel();
				s1.setPen(pen);
				s1.draw(g2d, x, y, e.getX(), e.getY());
				if(drawPanel.Images.size()>0){
					drawPanel.Images.remove(drawPanel.Images.size()-1);
					}
				drawPanel.imgAdd(temp);
				if(drawPanel.shapes.size()>0){
					drawPanel.shapes.remove(drawPanel.shapes.size()-1);
					}
				drawPanel.shapeAdd(new Shapedian(m,x, y, e.getX(), e.getY(),color,pen));
				break;
			case 1:
				temp = new BufferedImage(drawPanel.getWidth(), drawPanel.getHeight(),BufferedImage.TYPE_INT_ARGB);
				Graphics2D g2d1 = temp.createGraphics();
				g2d1.setColor(color);
				de1=new DrawLine(de1);
				Pen pen1=p1.kel();
				de1.setPen(pen1);
				de1.draw(g2d1, x, y, e.getX(), e.getY());
				if(drawPanel.Images.size()>0){
					drawPanel.Images.remove(drawPanel.Images.size()-1);
					}
				drawPanel.imgAdd(temp);
				if(drawPanel.shapes.size()>0){
					drawPanel.shapes.remove(drawPanel.shapes.size()-1);
					}
				drawPanel.shapeAdd(new Shapedian(1,x, y, e.getX(), e.getY(),color,pen1));
				break;
			case 2:
				temp = new BufferedImage(drawPanel.getWidth(), drawPanel.getHeight(),BufferedImage.TYPE_INT_ARGB);
				Graphics2D g2d2 = temp.createGraphics();
				g2d2.setColor(color);
				de1=new DrawRectangle(de1);
				Pen pen2=p1.kel();
				de1.setPen(pen2);
				de1.draw(g2d2, x, y, e.getX(), e.getY());
				if(drawPanel.Images.size()>0){
					drawPanel.Images.remove(drawPanel.Images.size()-1);
					}
				drawPanel.imgAdd(temp);
				if(drawPanel.shapes.size()>0){
					drawPanel.shapes.remove(drawPanel.shapes.size()-1);
					}
				drawPanel.shapeAdd(new Shapedian(2,x, y, e.getX(), e.getY(),color,pen2));
				break;
			case 3:
				temp = new BufferedImage(drawPanel.getWidth(), drawPanel.getHeight(),BufferedImage.TYPE_INT_ARGB);
				Graphics2D g2d3 = temp.createGraphics();
				g2d3.setColor(color);
				de1=new DrawRoundness(de1);
				Pen pen3=p1.kel();
				de1.setPen(pen3);
				de1.draw(g2d3, x, y, e.getX(), e.getY());
				if(drawPanel.Images.size()>0){
					drawPanel.Images.remove(drawPanel.Images.size()-1);
					}
				drawPanel.imgAdd(temp);
				if(drawPanel.shapes.size()>0){
					drawPanel.shapes.remove(drawPanel.shapes.size()-1);
					}
				drawPanel.shapeAdd(new Shapedian(3,x, y, e.getX(), e.getY(),color,pen3));
				break;
			case 4:
				temp = new BufferedImage(drawPanel.getWidth(), drawPanel.getHeight(),BufferedImage.TYPE_INT_ARGB);
				Graphics2D g2d4 = temp.createGraphics();
				g2d4.setColor(color);
				de1=new DrawTrilateral(de1);
				Pen pen4=p1.kel();
				de1.setPen(pen4);
				de1.draw(g2d4, x, y, e.getX(), e.getY());
				if(drawPanel.Images.size()>0){
					drawPanel.Images.remove(drawPanel.Images.size()-1);
					}
				drawPanel.imgAdd(temp);
				if(drawPanel.shapes.size()>0){
					drawPanel.shapes.remove(drawPanel.shapes.size()-1);
					}
				drawPanel.shapeAdd(new Shapedian(4,x, y, e.getX(), e.getY(),color,pen4));
				break;
			default:
				JOptionPane.showMessageDialog(null, "请选择图形", "提示", JOptionPane.INFORMATION_MESSAGE);
				break;
		}
			}
			if(dian&&draw==false) {
				System.out.println("开始移动");
				x1=e.getX();
				y1=e.getY();
				switch(dd1.getM()) {
				case 1:
					temp = new BufferedImage(drawPanel.getWidth(), drawPanel.getHeight(),BufferedImage.TYPE_INT_ARGB);
					Graphics2D g2d1 = temp.createGraphics();
					//g2d1.setStroke(new BasicStroke(sWidth));
					g2d1.setColor(dd1.getColor());
					de1=new DrawLine(de1);
					de1.setPen(dd1.getPen());
					de1.draw(g2d1,dd1.getX()+(x1-x), dd1.getY()+(y1-y), 
							dd1.getX1()+(x1-x), dd1.getY1()+(y1-y));
					drawPanel.Images.set(dum, temp);
					drawPanel.shapes.set(dum,new Shapedian(1,dd1.getX()+(x1-x), 
							dd1.getY()+(y1-y), dd1.getX1()+(x1-x), dd1.getY1()+(y1-y),
							dd1.getColor(),dd1.getPen()));
					break;
				case 2:
					temp = new BufferedImage(drawPanel.getWidth(), drawPanel.getHeight(),BufferedImage.TYPE_INT_ARGB);
					Graphics2D g2d2 = temp.createGraphics();
					//g2d2.setStroke(new BasicStroke(sWidth));
					g2d2.setColor(dd1.getColor());
					de1=new DrawRectangle(de1);
					de1.setPen(dd1.getPen());
					de1.draw(g2d2,dd1.getX()+(x1-x), dd1.getY()+(y1-y), 
							dd1.getX1()+(x1-x), dd1.getY1()+(y1-y));
					drawPanel.Images.set(dum, temp);
					drawPanel.shapes.set(dum,new Shapedian(2,dd1.getX()+(x1-x),
							dd1.getY()+(y1-y), dd1.getX1()+(x1-x), dd1.getY1()+(y1-y)
							,dd1.getColor(),dd1.getPen()));
					break;
				case 3:
					temp = new BufferedImage(drawPanel.getWidth(), drawPanel.getHeight(),BufferedImage.TYPE_INT_ARGB);
					Graphics2D g2d3 = temp.createGraphics();
					//g2d3.setStroke(new BasicStroke(sWidth));
					g2d3.setColor(dd1.getColor());
					de1=new DrawRoundness(de1);
					de1.setPen(dd1.getPen());
					de1.draw(g2d3,dd1.getX()+(x1-x), dd1.getY()+(y1-y),
							dd1.getX1()+(x1-x), dd1.getY1()+(y1-y));
					drawPanel.Images.set(dum, temp);
					drawPanel.shapes.set(dum,new Shapedian(3,dd1.getX()+(x1-x),
							dd1.getY()+(y1-y), dd1.getX1()+(x1-x), 
							dd1.getY1()+(y1-y),
							dd1.getColor(),dd1.getPen()));
					break;
				case 4:
					temp = new BufferedImage(drawPanel.getWidth(), drawPanel.getHeight(),BufferedImage.TYPE_INT_ARGB);
					Graphics2D g2d4 = temp.createGraphics();
					//g2d4.setStroke(new BasicStroke(sWidth));
					g2d4.setColor(dd1.getColor());
					de1=new DrawTrilateral(de1);
					de1.setPen(dd1.getPen());
					de1.draw(g2d4,dd1.getX()+(x1-x), dd1.getY()+(y1-y),
							dd1.getX1()+(x1-x), dd1.getY1()+(y1-y));
					drawPanel.Images.set(dum, temp);
					drawPanel.shapes.set(dum,new Shapedian(4,dd1.getX()+(x1-x),
							dd1.getY()+(y1-y), dd1.getX1()+(x1-x), dd1.getY1()+(y1-y),
							dd1.getColor(),dd1.getPen()
							));
					break;
				}
			}
			else {
				
			}
		}
	});
		this.add(drawPanel);
	}

}
