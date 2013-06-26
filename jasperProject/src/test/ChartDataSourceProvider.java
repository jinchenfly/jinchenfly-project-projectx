package test;

import java.util.Vector;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRAbstractBeanDataSourceProvider;

public class ChartDataSourceProvider extends JRAbstractBeanDataSourceProvider {

	public ChartDataSourceProvider(Class arg0) {

	       super(arg0);

	       // TODO Auto-generated constructor stub

	    }

	 

	    public ChartDataSourceProvider() {

	       super(ChartDataBean.class);

	       // TODO Auto-generated constructor stub

	    }

	    public JRDataSource create(JasperReport arg0) throws JRException {

	       // TODO Auto-generated method stub

	       ChartDataSource ds=new ChartDataSource(getQueryResult());

	       return ds;

	    }

	 

	    public void dispose(JRDataSource arg0) throws JRException {

	       // TODO Auto-generated method stub

	 

	    }

	 

	    public static Vector<ChartDataBean> getQueryResult(){

	        Vector<ChartDataBean> vector = new Vector<ChartDataBean>();

	 

	        ChartDataBean result = new ChartDataBean();

	        result.setCategory("北京");

	        result.setSerieas("联通");

	        result.setValue(1500);

	        vector.addElement(result);

	        result = new ChartDataBean();

	        

	        result.setCategory("北京");

	        result.setSerieas("电信");

	        result.setValue(1600);

	        vector.addElement(result);

	        result = new ChartDataBean();

	        

	        result.setCategory("北京");

	        result.setSerieas("移动");

	        result.setValue(2000);

	        vector.addElement(result);

	        result = new ChartDataBean();

	        

	        result.setCategory("上海");

	        result.setSerieas("联通");

	        result.setValue(1900);

	        vector.addElement(result);

	        result = new ChartDataBean();

	        

	        result.setCategory("上海");

	        result.setSerieas("电信");

	        result.setValue(600);

	        vector.addElement(result);

	        result = new ChartDataBean();

	        

	        result.setCategory("上海");

	        result.setSerieas("移动");

	        result.setValue(1200);

	        vector.addElement(result);

	        result = new ChartDataBean();

	        

	        result.setCategory("天津");

	        result.setSerieas("联通");

	        result.setValue(900);

	        vector.addElement(result);

	        result = new ChartDataBean();

	        

	        result.setCategory("天津");

	        result.setSerieas("电信");

	        result.setValue(800);

	        vector.addElement(result);

	        result = new ChartDataBean();

	        

	        result.setCategory("天津");

	        result.setSerieas("移动");

	        result.setValue(1400);

	        vector.addElement(result);

	        return vector;

	    }

}
