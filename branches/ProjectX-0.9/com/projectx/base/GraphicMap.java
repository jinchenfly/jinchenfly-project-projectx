package com.projectx.base;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class GraphicMap extends JFrame implements Runnable {
	public HashMap<Point,JLabel> labelList;
	private static GraphicMap instance;
	public static GraphicMap getInstance(){
		if(instance==null){
			System.out.println("Map not exist.Creating");
			instance = new GraphicMap();
		}
		return instance;
	}
	Map map;
	private JPanel imagePanel;
	private GraphicMap(){
		this.map = Map.getInstance();
		labelList = new HashMap<Point,JLabel>();
        init();
    }
    
	private void init() {
		imagePanel = (JPanel) this.getContentPane();
        //imagePanel.setOpaque(false);
        // 内容窗格默认的布局管理器为BorderLayout
        imagePanel.setLayout(new GridBagLayout());
        imagePanel.setBackground(Color.WHITE);
		for(int x=0;x<Map.maxX;x++){
			for(int y=0;y<Map.maxY;y++){
				GridBagConstraints gb = new GridBagConstraints();
	            gb.gridx=x;
	            gb.gridy=y;
	            gb.gridwidth=1;
	            //JPanel p1 = new JPanel();
	            //p1.setBorder(new TitledBorder("O"));
	            UnitX unit = map.getUnitX(new Point(x,y));
	            JLabel j1 = new JLabel(unit==null?" ":String.valueOf(unit.ID));
	            labelList.put(new Point(x,y), j1);
	            j1.setBorder(new TitledBorder(""));
	            //j1.setSize(10, 10);
	            gb.fill =GridBagConstraints.BOTH;
	            gb.weightx = 5;
	            gb.weighty = 5;
//	            gb.ipadx = 0;
//	            gb.ipady = 0;
	           
	            //j1.setFont(new java.awt.Font("微软雅黑", 1, 18));
	            imagePanel.add(j1,gb);
			}
		}
		this.setSize(205, 215);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocation(500, 300);
        this.setVisible(true);
        
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

}
