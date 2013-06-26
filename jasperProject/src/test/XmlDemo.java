package test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.StringWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * 
 * @author hongliang.dinghl DOM生成与解析XML文档
 */
public class XmlDemo {
	public Document document;
	private String fileName;
	private String xmlStr;
	public void init() {
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			this.document = builder.newDocument();
		} catch (ParserConfigurationException e) {
			System.out.println(e.getMessage());
		}
	}

	public void createXml() {
		Element root = this.document.createElement("datalist");
		this.document.appendChild(root);
		Element page1 = createChild(root,"page1");
		setParams(page1,new String[]{"A某某","B某某","2013年6月19日"});
//-------------------------------------------------------------------		
		Element page2 = createChild(root,"page2");
		Element page2table1 = createChild(page2,"table1");
		{
			Element row = createChild(page2table1,"row");
			setParams(row,new String[]{"胡敦煌","412728197898789878","C16788444"});
		}
		Element page2table2 = createChild(page2,"table2");
		{
			Element row = createChild(page2table2,"row");
			setParams(row,new String[]{"本人","姓名","412728198702183462","C16788444 C16788444"});
		}
		{
			Element row = createChild(page2table2,"row");
			setParams(row,new String[]{"与本人关系","姓名","证件号码","C16788444！"});
		}
		Element page2table3 = createChild(page2,"table3");
		Element groupnum = createChild(page2table3,"groupnum");
		setValue(groupnum,"1");
		{
			Element col = createChild(page2table3,"col");
			setParams(col,new String[]{"本人","8000","1000","1000","1000","8000","8000","1000","1000","1000","1000","1000","1000","1000","1000","1000","1000","1000","1000"});
		}
		{
			Element col = createChild(page2table3,"col");
			setParams(col,new String[]{"配偶","8000","1000","1000","1000","8000","8000","1000","1000","1000","1000","1000","1000","1000","1000","1000","1000","1000","1000"});
		}
		{
			Element col = createChild(page2table3,"col");
			setParams(col,new String[]{"子女","8000","1000","1000","1000","8000","8000","1000","1000","1000","1000","1000","1000","1000","1000","1000","1000","1000","1000"});
		}
		setParams(page2,new String[]{"张三","13816090890"});
//-------------------------------------------------------------------		
		Element page3 = createChild(root,"page3");
		setParams(page3,new String[]{"50%","300","\"全佑一生\"系列保险计划；","NM（新产品具体名称未知)；","友邦康悦重大疾病保险计划。","50%","300","\"全佑一生\"系列保险计划；","NM（新产品具体名称未知)；","友邦康悦重大疾病保险计划。","50%","300","\"全佑一生\"系列保险计划；","NM（新产品具体名称未知)；","友邦康悦重大疾病保险计划。","专家建议专家建议专家建议专家建议专家建议专家建议专家建议专家建议专家建议专家建议专家建议专家建议专家建议专家建议专家建议专家建议专家建议专家建议专家建议专家建议专家建议专家建议专家建议专家建议专家建议专家建议专家建议专家建议专家建议","张三","13816090890"});
//-------------------------------------------------------------------		
		Element page4 = createChild(root,"page4");
		Element page4table1 = createChild(page4,"table1");
		{
			Element row = createChild(page4table1,"row");
			setParams(row,new String[]{"C16788444","友邦附加重大疾病保险","88888","1111","2222","3333","4444","5555","6666","7777","8888","9999","11","22","33","44","55","66","77","88"});
		}
		{
			Element row = createChild(page4table1,"row");
			setParams(row,new String[]{"C16788444","重大疾病给付附加合同","88888","1111","2222","3333","4444","5555","6666","7777","8888","9999","11","22","33","44","55","66","77","88"});
		}
		setParams(page4,new String[]{"张三","13816090890"});
	}
	public Element createChild(Element e,String elementName){
		Element tempElement = this.document.createElement(elementName);
		e.appendChild(tempElement);
		return tempElement;
	}
	public void setValue(Element e,String value){
		e.appendChild(this.document.createTextNode(value));
	}
	public void setParams(Element e,String[] paramArray){
		for(int i=0;i<paramArray.length;i++){
			Element param = createChild(e,"param"+(i+1));
			setValue(param, paramArray[i]);
		}
	}
	public void parserXml(String fileName) {
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document document = db.parse(fileName);
			NodeList employees = document.getChildNodes();
			for (int i = 0; i < employees.getLength(); i++) {
				Node employee = employees.item(i);
				NodeList employeeInfo = employee.getChildNodes();
				for (int j = 0; j < employeeInfo.getLength(); j++) {
					Node node = employeeInfo.item(j);
					NodeList employeeMeta = node.getChildNodes();
					for (int k = 0; k < employeeMeta.getLength(); k++) {
						System.out.println(employeeMeta.item(k).getNodeName()
								+ ":" + employeeMeta.item(k).getTextContent());
					}
				}
			}
			System.out.println("解析完毕");
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (ParserConfigurationException e) {
			System.out.println(e.getMessage());
		} catch (SAXException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	public String getString(){
		TransformerFactory tf = TransformerFactory.newInstance();
		try {
			Transformer transformer = tf.newTransformer();
			DOMSource source = new DOMSource(document);
			//transformer.setOutputProperty(OutputKeys.ENCODING, "gb2312");
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			
			StringWriter sw = new StringWriter();
			StreamResult result = new StreamResult(sw);
			transformer.transform(source, result);
			return sw.toString();
		} catch (TransformerConfigurationException e) {
			System.out.println(e.getMessage());
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		} catch (TransformerException e) {
			System.out.println(e.getMessage());
		}
		return "";
	}
}
