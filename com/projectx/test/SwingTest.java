package com.projectx.test;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class SwingTest extends JFrame implements Runnable {
	private JPanel imagePanel;
    //public ImageIcon background;

    public JPanel titlePanel;

    //private int i = 31;//倒计时参数
    //private  JLabel j3 = null;
	
    public SwingTest(){

        init();
        Thread t = new Thread(this);
        t.start();

    }
    
	private void init() {
		imagePanel = (JPanel) this.getContentPane();
        //imagePanel.setOpaque(false);
        // 内容窗格默认的布局管理器为BorderLayout
        imagePanel.setLayout(new GridBagLayout());
        imagePanel.setBackground(Color.WHITE);
		for(int x=0;x<10;x++){
			for(int y=0;y<10;y++){
				GridBagConstraints gb = new GridBagConstraints();
	            gb.gridx=x;
	            gb.gridy=y;
	            gb.gridwidth=1;
	            //JPanel p1 = new JPanel();
	            //p1.setBorder(new TitledBorder("O"));
	            JLabel j1 = new JLabel("O");
	            j1.setBorder(new TitledBorder(""));
	            //j1.setSize(10, 10);
	            gb.fill =GridBagConstraints.CENTER;
	            gb.weightx = 5;
	            gb.weighty = 5;
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
	public static void main(String[]args){


        new SwingTest();
      
        
    }
}
