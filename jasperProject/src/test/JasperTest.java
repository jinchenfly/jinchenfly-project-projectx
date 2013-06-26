package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Vector;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JRParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.query.JRXPathQueryExecuterFactory;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.engine.util.JRXmlUtils;

import org.w3c.dom.Document;

public class JasperTest {
	public static void main(String[] args){
		XmlDemo xmlStr = getXmlDemo();
		System.out.println(xmlStr.getString());
		TestISPReport(xmlStr.document);
	}
	public static void Test1(){
		try {
			String policyJasperName = null;
			
//			policyJasperName = "test_report_1.jasper";
			//policyJasperName = "1.jasper";
			String jasperName = "Untitled_report_2";
			policyJasperName = jasperName+".jasper";
			
		
			String jasperPath = "D:\\jasper\\" + policyJasperName;
		
			//			java.net.URL url = servletContext.getResource(policyJasperName);
			//			System.out.println("url.getFile():"+url.getFile());
			//			String reportPath = (url.getFile().split(policyJasperName))[0];
			InputStream jasperInputStream =
				new FileInputStream(jasperPath);
				
				
				
			if (jasperInputStream == null) {
				System.out.println(
					"***jasperInputStream is null in printPolicy(),jasperPath="
						+ jasperPath);
			} else {
				System.out.println(
					"***jasperInputStream is NOT null in printPolicy(),jasperPath="
						+ jasperPath);
			}


			//OutputStream os = response.getOutputStream();
			OutputStream os = new FileOutputStream("D:\\"+jasperName+".pdf");
			List jasperPrintList = new ArrayList();
			
			JasperReport jasperReport;

			//jasperReport = (JasperReport) JRLoader.loadObject(jasperInputStream);
			jasperReport = (JasperReport) JRLoader.loadObject(new File(jasperPath));
			Map params = new HashMap();
//			params.put(JRXPathQueryExecuterFactory.XML_DATE_PATTERN, "yyyy-MM-dd");
//			params.put(JRXPathQueryExecuterFactory.XML_NUMBER_PATTERN, "#,##0.##");
//			params.put(JRXPathQueryExecuterFactory.XML_LOCALE, Locale.CHINESE);
//			params.put(JRParameter.REPORT_LOCALE, Locale.CHINA);
//			params.put("SUBREPORT_DIR", "/report/");
//			params.put("TextTest2", "测试");
//			params.put("ImageTest", "D:\\chop-colour-gd.gif");
//			Document document = null;
			JasperPrint jasperPrint = null;

			Vector<ChartDataBean> source = ChartDataSourceProvider.getQueryResult();
			
			
			jasperPrint = JasperFillManager.fillReport(jasperReport, params,new ChartDataSource(source));

			//JasperExportManager.exportReportToPdfFile(jasperPrint,"D://testpdf.pdf");

			jasperPrintList.add(jasperPrint);


			JRPdfExporter exporter = new JRPdfExporter();
			//Map fontsMap = new HashMap();
			//fontsMap.put(new FontKey("黑体X", false, false), new PdfFont("/report/simhei.ttf",  "Identity-H", false, false, false));
			//fontsMap.put(new FontKey("新字", false, false), new PdfFont("d:\\eTA\\property\\simhei.ttf",  "Identity-H", false, false, false));
			//fontsMap.put(new FontKey("新字", false, false), new PdfFont("d:\\eTA\\property\\EUDC.TTF",  "Identity-H", false, false, false));
			//exporter.setParameter(JRExporterParameter.FONT_MAP, fontsMap);		
			exporter.setParameter(
				JRExporterParameter.JASPER_PRINT_LIST,
				jasperPrintList);
			exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, os);

			exporter.exportReport();
			os.flush();
			os.close();
		} catch (JRException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void Test2(){
		try {
			String policyJasperName = null;
			
//			policyJasperName = "test_report_1.jasper";
			//policyJasperName = "1.jasper";
			String jasperName = "report1";
			policyJasperName = jasperName+".jasper";
			String XML_FILE_NAME = "D:\\NameList.xml";
		
			String jasperPath = "D:\\jasper\\" + policyJasperName;
		
			//			java.net.URL url = servletContext.getResource(policyJasperName);
			//			System.out.println("url.getFile():"+url.getFile());
			//			String reportPath = (url.getFile().split(policyJasperName))[0];
			InputStream jasperInputStream =
				new FileInputStream(jasperPath);
				
				
				
			if (jasperInputStream == null) {
				System.out.println(
					"***jasperInputStream is null in printPolicy(),jasperPath="
						+ jasperPath);
			} else {
				System.out.println(
					"***jasperInputStream is NOT null in printPolicy(),jasperPath="
						+ jasperPath);
			}


			//OutputStream os = response.getOutputStream();
			OutputStream os = new FileOutputStream("D:\\"+jasperName+".pdf");
			List jasperPrintList = new ArrayList();
			
			JasperReport jasperReport;

			//jasperReport = (JasperReport) JRLoader.loadObject(jasperInputStream);
			jasperReport = (JasperReport) JRLoader.loadObject(new File(jasperPath));
			Map params = new HashMap();
//			params.put(JRXPathQueryExecuterFactory.XML_DATE_PATTERN, "yyyy-MM-dd");
//			params.put(JRXPathQueryExecuterFactory.XML_NUMBER_PATTERN, "#,##0.##");
//			params.put(JRXPathQueryExecuterFactory.XML_LOCALE, Locale.CHINESE);
//			params.put(JRParameter.REPORT_LOCALE, Locale.CHINA);
			params.put("SUBREPORT_DIR", "D:\\jasper\\");
//			params.put("TextTest2", "测试");
//			params.put("ImageTest", "D:\\chop-colour-gd.gif");
//			Document document = null;
			JasperPrint jasperPrint = null;

			//Vector<ChartDataBean> source = ChartDataSourceProvider.getQueryResult();
			params.put("title", "xml data source");
            Document document = JRXmlUtils.parse(JRLoader.getLocationInputStream(XML_FILE_NAME));
            params.put(JRXPathQueryExecuterFactory.PARAMETER_XML_DATA_DOCUMENT,
                    document);
			
			jasperPrint = JasperFillManager.fillReport(jasperReport, params);

			//JasperExportManager.exportReportToPdfFile(jasperPrint,"D://testpdf.pdf");

			jasperPrintList.add(jasperPrint);


			JRPdfExporter exporter = new JRPdfExporter();
			//Map fontsMap = new HashMap();
			//fontsMap.put(new FontKey("黑体X", false, false), new PdfFont("/report/simhei.ttf",  "Identity-H", false, false, false));
			//fontsMap.put(new FontKey("新字", false, false), new PdfFont("d:\\eTA\\property\\simhei.ttf",  "Identity-H", false, false, false));
			//fontsMap.put(new FontKey("新字", false, false), new PdfFont("d:\\eTA\\property\\EUDC.TTF",  "Identity-H", false, false, false));
			//exporter.setParameter(JRExporterParameter.FONT_MAP, fontsMap);		
			exporter.setParameter(
				JRExporterParameter.JASPER_PRINT_LIST,
				jasperPrintList);
			exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, os);

			exporter.exportReport();
			os.flush();
			os.close();
		} catch (JRException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void TestJDBC(){
		try {
			String policyJasperName = null;
			
//			policyJasperName = "test_report_1.jasper";
			//policyJasperName = "1.jasper";
			String jasperName = "sqlserverSource";
			policyJasperName = jasperName+".jasper";
			//String XML_FILE_NAME = "D:\\NameList.xml";
		
			String jasperPath = "D:\\jasper\\" + policyJasperName;
		
			//			java.net.URL url = servletContext.getResource(policyJasperName);
			//			System.out.println("url.getFile():"+url.getFile());
			//			String reportPath = (url.getFile().split(policyJasperName))[0];
			InputStream jasperInputStream =
				new FileInputStream(jasperPath);
				
				
				
			if (jasperInputStream == null) {
				System.out.println(
					"***jasperInputStream is null in printPolicy(),jasperPath="
						+ jasperPath);
			} else {
				System.out.println(
					"***jasperInputStream is NOT null in printPolicy(),jasperPath="
						+ jasperPath);
			}


			//OutputStream os = response.getOutputStream();
			OutputStream os = new FileOutputStream("D:\\"+jasperName+".pdf");
			List jasperPrintList = new ArrayList();
			
			JasperReport jasperReport;

			//jasperReport = (JasperReport) JRLoader.loadObject(jasperInputStream);
			jasperReport = (JasperReport) JRLoader.loadObject(new File(jasperPath));
			Map params = new HashMap();
//			params.put(JRXPathQueryExecuterFactory.XML_DATE_PATTERN, "yyyy-MM-dd");
//			params.put(JRXPathQueryExecuterFactory.XML_NUMBER_PATTERN, "#,##0.##");
//			params.put(JRXPathQueryExecuterFactory.XML_LOCALE, Locale.CHINESE);
//			params.put(JRParameter.REPORT_LOCALE, Locale.CHINA);
			params.put("SUBREPORT_DIR", "D:\\jasper\\");
//			params.put("TextTest2", "测试");
//			params.put("ImageTest", "D:\\chop-colour-gd.gif");
//			Document document = null;
			JasperPrint jasperPrint = null;

			//Vector<ChartDataBean> source = ChartDataSourceProvider.getQueryResult();
//			params.put("title", "xml data source");
//            Document document = JRXmlUtils.parse(JRLoader.getLocationInputStream(XML_FILE_NAME));
//            params.put(JRXPathQueryExecuterFactory.PARAMETER_XML_DATA_DOCUMENT,
//                    document);
			
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String url = "jdbc:sqlserver://chot3r8csts02;DataBaseName=ETA" ;    
		    String username = "devplogin2" ;   
		    String password = "devplogin" ;   
		    Connection con = DriverManager.getConnection(url , username , password ) ;   
			//params.put("Connection2", con);
			jasperPrint = JasperFillManager.fillReport(jasperReport, params,con);

			//JasperExportManager.exportReportToPdfFile(jasperPrint,"D://testpdf.pdf");

			jasperPrintList.add(jasperPrint);


			JRPdfExporter exporter = new JRPdfExporter();
			//Map fontsMap = new HashMap();
			//fontsMap.put(new FontKey("黑体X", false, false), new PdfFont("/report/simhei.ttf",  "Identity-H", false, false, false));
			//fontsMap.put(new FontKey("新字", false, false), new PdfFont("d:\\eTA\\property\\simhei.ttf",  "Identity-H", false, false, false));
			//fontsMap.put(new FontKey("新字", false, false), new PdfFont("d:\\eTA\\property\\EUDC.TTF",  "Identity-H", false, false, false));
			//exporter.setParameter(JRExporterParameter.FONT_MAP, fontsMap);		
			exporter.setParameter(
				JRExporterParameter.JASPER_PRINT_LIST,
				jasperPrintList);
			exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, os);

			exporter.exportReport();
			os.flush();
			os.close();
		} catch (JRException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO 自动生成 catch 块
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO 自动生成 catch 块
			e.printStackTrace();
		}
	}
	public static void TestISPReport(Document document){
		InputStream jasperInputStream = null;
		try {
			String policyJasperName = null;
			
			String jasperName = "ispreport";
			//String jasperName = "ispreport_subreport1";
			policyJasperName = jasperName+".jasper";
			String XML_FILE_NAME = "D:\\jasper\\ispsource.xml";
			String jasperPath = "D:\\jasper\\" + policyJasperName;
		
			jasperInputStream =
				new FileInputStream(jasperPath);

			//OutputStream os = response.getOutputStream();
			OutputStream os = new FileOutputStream("D:\\"+jasperName+".pdf");
			List jasperPrintList = new ArrayList();
			
			JasperReport jasperReport;

			//jasperReport = (JasperReport) JRLoader.loadObject(jasperInputStream);
			jasperReport = (JasperReport) JRLoader.loadObject(new File(jasperPath));
			Map params = new HashMap();
			params.put(JRXPathQueryExecuterFactory.XML_LOCALE, Locale.CHINESE);
			params.put(JRParameter.REPORT_LOCALE, Locale.CHINA);
			params.put("SUBREPORT_DIR", "D:\\jasper\\");
			JasperPrint jasperPrint = null;

			params.put("ImagePath", "D:\\isp\\branches\\isp_ui\\src\\static\\images\\");
			params.put("title", "xml data source");
            //Document document = JRXmlUtils.parse(JRLoader.getLocationInputStream(XML_FILE_NAME));
            params.put(JRXPathQueryExecuterFactory.PARAMETER_XML_DATA_DOCUMENT,
                    document);
			jasperPrint = JasperFillManager.fillReport(jasperReport, params);

			//JasperExportManager.exportReportToPdfFile(jasperPrint,"D://testpdf.pdf");

			jasperPrintList.add(jasperPrint);

			JRPdfExporter exporter = new JRPdfExporter();
			exporter.setParameter(
				JRExporterParameter.JASPER_PRINT_LIST,
				jasperPrintList);
			exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, os);

			exporter.exportReport();
			os.flush();
			os.close();
		} catch (JRException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				if(jasperInputStream!=null){
					jasperInputStream.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	public static XmlDemo getXmlDemo(){
		XmlDemo xml = new XmlDemo();
		xml.init();
		xml.createXml();
		return xml;
	}
}
