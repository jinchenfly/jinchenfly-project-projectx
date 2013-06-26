package com.iptest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.NetworkInterface;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.Enumeration;

public class CatchWeb {
	/**
	 * 获取网站源码
	 * 
	 * @param basePath
	 * @param childPath
	 * @return
	 * @throws SocketTimeoutException
	 */
	public String getWebSource(String basePath, String childPath) {
		StringBuffer sb = new StringBuffer("");
		try {
			URL url = new URL(basePath + childPath);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			//con.setDoOutput(true);
			//con.setFollowRedirects(true);
			//con.setInstanceFollowRedirects(false);
			con.setConnectTimeout(20000);
			con.connect();
			BufferedReader br = new BufferedReader(new InputStreamReader(
					con.getInputStream()));
			String s = "";
			while ((s = br.readLine()) != null) {
				sb.append(s + "\r\n");
			}
			System.out.println(sb.toString());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sb.toString();
	}

	/********************* 匹配信息的方法 **********************/
	public String getCity(String source) {
		if (source != null) {
			source = source.substring(source.indexOf("来自"),
					source.indexOf("<br/>"));
		}
		return source;
	}

	public String getIP(String source) {
		if (source != null) {
			source = source.substring(source.indexOf("[") + 1,
					source.indexOf("]"));
		}
		return source;
	}

}