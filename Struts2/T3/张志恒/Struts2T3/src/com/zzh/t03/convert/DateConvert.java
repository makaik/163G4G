package com.zzh.t03.convert;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

public class DateConvert extends StrutsTypeConverter {

	@Override
	public Object convertFromString(Map arg0, String[] arg1, Class arg2) {
		// TODO 获取参数进行转换
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd");
		Date date = null;
		try {
			date = sdf.parse(arg1[0]);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			System.out.println("日期转换类型错误：" + e.getMessage()); 
		}
		return date;
	}

	@Override
	public String convertToString(Map arg0, Object arg1) {
		// TODO 转成字符串以供视图
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd");
		Date date = (Date) arg1;
		
		return sdf.format(date);
	}

}
