package com.projectx.test;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Dao3 extends JFrame implements Runnable{

    private JPanel imagePanel;
    public ImageIcon background;

    public JPanel titlePanel;

    private int i = 31;//倒计时参数
    private  JLabel j3 = null;


    public Dao3(){

        init();
        Thread t = new Thread(this);
        t.start();

    }

    public void init(){

         background = new ImageIcon("D:/main.jpg");
            //background = new ImageIcon(this.getClass().getResource("/seatbg1.jpg"));// 背景图片
            JLabel label = new JLabel(background);// 把背景图片显示在一个标签里面
            // 把标签的大小位
            // 设置为图片刚好填充整个面板
            label.setBounds(0, 0, background.getIconWidth(), background.getIconHeight());
            // 把内容窗格转化为JPanel，否则不能用方法setOpaque()来使内容窗格透明

            
            imagePanel = (JPanel) this.getContentPane();
            imagePanel.setOpaque(false);
            // 内容窗格默认的布局管理器为BorderLayout
            imagePanel.setLayout(new GridBagLayout());


            final JButton jb1 = new JButton("1");
            jb1.setIcon(new ImageIcon(this.getClass().getResource("/1out.jpg")));
            jb1.addMouseListener(new MouseAdapter() {

                public void mouseEntered(MouseEvent e){
                   jb1.setIcon(new ImageIcon(this.getClass().getResource("/1on.jpg")));
                }

                public void mouseExited(MouseEvent e){
                   jb1.setIcon(new ImageIcon(this.getClass().getResource("/1out.jpg")));
                }
            });
           final JButton jb2 = new JButton("2");
            jb2.setIcon(new ImageIcon(this.getClass().getResource("/2out.jpg")));

                jb2.addMouseListener(new MouseAdapter() {

                public void mouseEntered(MouseEvent e){
                   jb2.setIcon(new ImageIcon(this.getClass().getResource("/2on.jpg")));
                }

                public void mouseExited(MouseEvent e){
                   jb2.setIcon(new ImageIcon(this.getClass().getResource("/2out.jpg")));
                }
            });
            final JButton jb3 = new JButton("3");
            jb3.setIcon(new ImageIcon(this.getClass().getResource("/3out.jpg")));

                 jb3.addMouseListener(new MouseAdapter() {

                public void mouseEntered(MouseEvent e){
                   jb3.setIcon(new ImageIcon(this.getClass().getResource("/3on.jpg")));
                }

                public void mouseExited(MouseEvent e){
                   jb3.setIcon(new ImageIcon(this.getClass().getResource("/3out.jpg")));
                }
            });
           final JButton jb4 = new JButton("4");
            jb4.setIcon(new ImageIcon(this.getClass().getResource("/4out.jpg")));

            jb4.addMouseListener(new MouseAdapter() {

                public void mouseEntered(MouseEvent e){
                   jb4.setIcon(new ImageIcon(this.getClass().getResource("/4on.jpg")));
                }

                public void mouseExited(MouseEvent e){
                   jb4.setIcon(new ImageIcon(this.getClass().getResource("/4out.jpg")));
                }
            });


           final JButton jb5 = new JButton("5");
            jb5.setIcon(new ImageIcon(this.getClass().getResource("/5out.jpg")));

            jb5.addMouseListener(new MouseAdapter() {

                public void mouseEntered(MouseEvent e){
                   jb5.setIcon(new ImageIcon(this.getClass().getResource("/5on.jpg")));
                }

                public void mouseExited(MouseEvent e){
                   jb5.setIcon(new ImageIcon(this.getClass().getResource("/5out.jpg")));
                }
            });

 

           final JButton jb6 = new JButton("6");
            jb6.setIcon(new ImageIcon(this.getClass().getResource("/6out.jpg")));

              jb6.addMouseListener(new MouseAdapter() {

                public void mouseEntered(MouseEvent e){
                   jb6.setIcon(new ImageIcon(this.getClass().getResource("/6on.jpg")));
                }

                public void mouseExited(MouseEvent e){
                   jb6.setIcon(new ImageIcon(this.getClass().getResource("/6out.jpg")));
                }
            });


           final JButton jb7 = new JButton("7");
            jb7.setIcon(new ImageIcon(this.getClass().getResource("/7out.jpg")));


               jb7.addMouseListener(new MouseAdapter() {

                public void mouseEntered(MouseEvent e){
                   jb7.setIcon(new ImageIcon(this.getClass().getResource("/7on.jpg")));
                }

                public void mouseExited(MouseEvent e){
                   jb7.setIcon(new ImageIcon(this.getClass().getResource("/7out.jpg")));
                }
            });

           final JButton jb8 = new JButton("8");
            jb8.setIcon(new ImageIcon(this.getClass().getResource("/8out.jpg")));


              jb8.addMouseListener(new MouseAdapter() {

                public void mouseEntered(MouseEvent e){
                   jb8.setIcon(new ImageIcon(this.getClass().getResource("/8on.jpg")));
                }

                public void mouseExited(MouseEvent e){
                   jb8.setIcon(new ImageIcon(this.getClass().getResource("/8out.jpg")));
                }
            });

           final JButton jb9 = new JButton("9");
            jb9.setIcon(new ImageIcon(this.getClass().getResource("/9out.jpg")));


              jb9.addMouseListener(new MouseAdapter() {

                public void mouseEntered(MouseEvent e){
                   jb9.setIcon(new ImageIcon(this.getClass().getResource("/9on.jpg")));
                }

                public void mouseExited(MouseEvent e){
                   jb9.setIcon(new ImageIcon(this.getClass().getResource("/9out.jpg")));
                }
            });


           final JButton jb0 = new JButton("0");
            jb0.setIcon(new ImageIcon(this.getClass().getResource("/0out.jpg")));

            jb0.addMouseListener(new MouseAdapter() {

                public void mouseEntered(MouseEvent e)
{
                   jb0.setIcon(new ImageIcon(this.getClass().getResource("/0on.jpg")));
                }

                public void mouseExited(MouseEvent e){
                   jb0.setIcon(new ImageIcon(this.getClass().getResource("/0out.jpg")));
                }
            });

           final JButton jb11 = new JButton("  ");
            jb11.setIcon(new ImageIcon(this.getClass().getResource("/delout.jpg")));
                jb11.addMouseListener(new MouseAdapter() {

                public void mouseEntered(MouseEvent e){
                   jb11.setIcon(new ImageIcon(this.getClass().getResource("/delon.jpg")));
                }

                public void mouseExited(MouseEvent e){
                   jb11.setIcon(new ImageIcon(this.getClass().getResource("/delout.jpg")));
                }
            });
 
           final JButton jb12 = new JButton("   ");
            jb12.setIcon(new ImageIcon(this.getClass().getResource("/clearout.jpg")));

              jb12.addMouseListener(new MouseAdapter() {

                public void mouseEntered(MouseEvent e){
                   jb12.setIcon(new ImageIcon(this.getClass().getResource("/clearon.jpg")));
                }

                public void mouseExited(MouseEvent e){
                   jb12.setIcon(new ImageIcon(this.getClass().getResource("/clearout.jpg")));
                }
            });


            JLabel j1 = new JLabel("机具验证码：");
            j1.setFont(new java.awt.Font("微软雅黑", 1, 18));

            final JTextField j2 = new JTextField(10);
            j2.setPreferredSize(new Dimension(80,32));
            j2.setFont(new java.awt.Font("微软雅黑", 1, 13));
            j3 = new JLabel();
             
            j3.setFont(new java.awt.Font("微软雅黑", 1, 13));
           

           jb12.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                i=31;
                j2.setText("");
            }
            });


         class myText implements ActionListener{

            @Override
            public void actionPerformed(ActionEvent e) {

                i=31;
                if(j2.getText().trim().length()<12){

                     j2.setText(j2.getText()+e.getActionCommand().toString());

                }
                 
            }

         }

         class delText implements ActionListener{

            @Override
            public void actionPerformed(ActionEvent e) {

              i=31;
              if(j2.getText().length()>0){

                  j2.setText(j2.getText().substring(0,j2.getText().length()-1));
                             
              }

            }

         }

          jb1.addActionListener(new myText());
           jb2.addActionListener(new myText());
            jb3.addActionListener(new myText());
             jb4.addActionListener(new myText());
              jb5.addActionListener(new myText());
               jb6.addActionListener(new myText());
                jb7.addActionListener(new myText());
                 jb8.addActionListener(new myText());
                  jb9.addActionListener(new myText());
                   jb0.addActionListener(new myText());
                    jb11.addActionListener(new delText());


            //可以控制位置。
           // bg.insets = new Insets(250, 650, 400, 350);
          // bg.fill = GridBagConstraints.HORIZONTAL; 

           GridBagConstraints gb = new GridBagConstraints();
            gb.gridx=0;
            gb.gridy=0;
            gb.gridwidth=1;
            imagePanel.add(j1,gb);

            gb.gridx=1;
            gb.gridy=0;
            gb.gridwidth=1;
            imagePanel.add(j2,gb);

            gb.gridx=2;
            gb.gridy=0;
            gb.gridwidth=1;
            imagePanel.add(j3,gb);


            gb.gridx=0;
            gb.gridy=1;
            gb.gridwidth=1;
            imagePanel.add(jb1,gb);

            gb.gridx=1;
            gb.gridy=1;
            imagePanel.add(jb2,gb);

            gb.gridx=2;
            gb.gridy=1;
            imagePanel.add(jb3,gb);

            gb.gridx=0;
            gb.gridy=2;
            imagePanel.add(jb4,gb);

            gb.gridx=1;
            gb.gridy=2;
            imagePanel.add(jb5,gb);

            gb.gridx=2;
            gb.gridy=2;
            imagePanel.add(jb6,gb);

            gb.gridx=0;
            gb.gridy=3;
            imagePanel.add(jb7,gb);

            gb.gridx=1;
            gb.gridy=3;
            imagePanel.add(jb8,gb);

            gb.gridx=2;
            gb.gridy=3;
            imagePanel.add(jb9,gb);

            gb.gridx=0;
            gb.gridy=4;
            imagePanel.add(jb0,gb);

            gb.gridx=1;
            gb.gridy=4;
            imagePanel.add(jb11,gb);

            gb.gridx=2;
            gb.gridy=4;
            imagePanel.add(jb12,gb);


            GridBagConstraints gb1 = new GridBagConstraints();
            gb1.gridx=0;
            gb1.gridy=6;
            // gb1.gridheight=2;
            //gridwidth默认占一个位置。
            gb1.gridwidth=1;

            //设置组件间的距离，位置。
            gb1.insets = new Insets(10, 0, 0, 0);
            JButton jj2= new JButton();
            jj2.setIcon(new ImageIcon(this.getClass().getResource("/quitout.jpg")));
            jj2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                 i=31;
                 System.out.println("退出本程序。。。启用新程序！");
                 if(!j2.getText().trim().equals("")){
                       if(j2.getText().trim().length()!=12){
                           JOptionPane.showMessageDialog(null, "请正确输入信息后，操作！", "警告框", JOptionPane.ERROR_MESSAGE);
                           return;
                       }
                 }else{
                     JOptionPane.showMessageDialog(null, "请输入信息后，操作！", "警告框", JOptionPane.ERROR_MESSAGE);
                     return;
                 }
                 System.out.println("验证信息："+j2.getText());
                  Dao3.this.dispose();
            }
            });
            imagePanel.add(jj2,gb1);


            gb.gridx=2;
            gb.gridy=6;
            gb.insets = new Insets(10, 0, 0, 0);
            JButton jj3= new JButton();
            jj3.setIcon(new ImageIcon(this.getClass().getResource("/quitout.jpg")));
            imagePanel.add(jj3,gb);


            this.getLayeredPane().setLayout(null);

            // 把背景图片添加到分层窗格的最底层作为背景
            this.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));

            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setSize(background.getIconWidth(), background.getIconHeight());
            this.setVisible(true);


    }


    public static void main(String[]args){


        new Dao3();
      
        
    }

    @Override
    public void run() {

          try{
             while(i>0){
             i--;
             if((i+"").length()!=2){
                j3.setText("<html>&nbsp;&nbsp;&nbsp;&nbsp;<font color='red' size='18'>"+i+"</font>秒后,系统退出！</html>");
             }else{
                j3.setText("<html><font color='red' size='18'>"+i+"</font>秒后,系统退出！</html>");
             }
             if(i==0){
                 this.dispose();
                 System.out.println("要退出系统。。。");
             }
             Thread.sleep(1000);
             }
          
          }catch(Exception e){
             e.printStackTrace();
          }
    }

}