package com.sea.test.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

public class DateConverter extends StrutsTypeConverter {

	@Override
	public Object convertFromString(Map arg0, String[] arg1, Class arg2) {
		// 请求中获取参数进行转换
		System.out.println("日期类型转换");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
		try {
			Date date = sdf.parse(arg1[0]);
			return date;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			System.out.println("日期类型转换错误"+e.getMessage());
			return null;
		}
	}

	@Override
	public String convertToString(Map arg0, Object arg1) {
		// 转换成字符串返回结果
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
		Date date = (Date) arg1;
		return sdf.format(date);
	}

}
