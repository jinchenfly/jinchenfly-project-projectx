package com.iptest;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CatchWeb catchWeb = new CatchWeb();
		/**************** JFrame设置 *******************/
//		JFrame jf = new JFrame("获取IP");
//		JPanel jp = new JPanel();
//		JLabel label = new JLabel();
//		label.setFont(new Font("微软雅黑", Font.LAYOUT_LEFT_TO_RIGHT, 12));
//		jp.add(label);
//		jf.add(jp);
//		jf.setVisible(true);
//		jf.setBounds(400, 200, 200, 80);
//		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		/**************** 连接设置 *******************/
//		String basePath = "http://www.ip138.com/";
//		String ipurl = "ip2city.asp";
//		String cityurl = "ips.asp";
		String basePath = "http://iframe.ip138.com/";
		String ipurl = "ic.asp";
		String cityurl = "ips.asp";
		String ip = null;
		String city = null;
		try {
			System.out.println("连接中...");
			ip = catchWeb.getIP(catchWeb.getWebSource(basePath, ipurl));
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (ip != null) {
			System.out.println("您的IP是:"+ip);
		}
		
		String emailTemplate = ip;
		Mail.sendHtmlMail(emailTemplate);
	}

}
