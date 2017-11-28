package com.wce.nxte.Converter;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;


public class MyDateTypeConverter extends StrutsTypeConverter{
	
    public Object convertFromString(Map context, String[] values, Class toClass){
    	SimpleDateFormat sdf=new SimpleDateFormat("yyyy年-MM月-dd日");
    	
    	try{
    		Date v = sdf.parse(values[0]);
    		return v;
    	}catch(Exception e){
    		System.out.println("日期类型转换错误:"+e.getMessage());
    		return null;
    	}
    }
    
    public String concertToString(Map<?, ?> context,Object obj){
    	SimpleDateFormat sdf= new SimpleDateFormat("yyyy年-MM月-dd日");
    	Date v =(Date)obj;
    	return sdf.format(v);
    }
}
