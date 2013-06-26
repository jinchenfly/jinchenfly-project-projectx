package test;

import java.util.Vector;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;



public class ChartDataSource implements JRDataSource {

	 private int m_nldx;

	 

	    private Vector<ChartDataBean> v;

	   

	    public ChartDataSource(){

	    this(new Vector<ChartDataBean>());

	    }

	    public ChartDataSource(Vector<ChartDataBean> v){

	    this.m_nldx=-1;

	    this.v=v;

	    }

	    public Object getFieldValue(JRField arg0) throws JRException {

	       Object o = null;

	 

	        String sName = arg0.getName();

	 

	        ChartDataBean resultset = v.elementAt(m_nldx);

	 

	        if(resultset == null)

	               return null;

	 

	        if(sName.equals("serieas"))

	               o =resultset.getSerieas();

	        else if(sName.equals("category"))

	               o = resultset.getCategory();

	        else if(sName.equals("value"))

	            o = resultset.getValue();

	        return o;

	    }

	 

	    public boolean next() throws JRException {

	       // TODO Auto-generated method stub

	       m_nldx ++;

	        return (m_nldx < v.size());

	    }


}
