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
		/**************** JFrame���� *******************/
//		JFrame jf = new JFrame("��ȡIP");
//		JPanel jp = new JPanel();
//		JLabel label = new JLabel();
//		label.setFont(new Font("΢���ź�", Font.LAYOUT_LEFT_TO_RIGHT, 12));
//		jp.add(label);
//		jf.add(jp);
//		jf.setVisible(true);
//		jf.setBounds(400, 200, 200, 80);
//		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		/**************** �������� *******************/
//		String basePath = "http://www.ip138.com/";
//		String ipurl = "ip2city.asp";
//		String cityurl = "ips.asp";
		String basePath = "http://iframe.ip138.com/";
		String ipurl = "ic.asp";
		String cityurl = "ips.asp";
		String ip = null;
		String city = null;
		try {
			System.out.println("������...");
			ip = catchWeb.getIP(catchWeb.getWebSource(basePath, ipurl));
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (ip != null) {
			System.out.println("����IP��:"+ip);
		}
		
		String emailTemplate = ip;
		Mail.sendHtmlMail(emailTemplate);
	}

}
