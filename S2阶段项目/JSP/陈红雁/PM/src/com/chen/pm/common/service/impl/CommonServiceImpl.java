package com.chen.pm.common.service.impl;

import java.util.List;

import com.chen.pm.common.dao.impl.CommonDaoImpl;
import com.chen.pm.common.service.CommonService;

public class CommonServiceImpl implements CommonService{
	@Override
	public int getCount(String tableName, List<String> wheres, List<String> values) {
		return new CommonDaoImpl().getCount(tableName, wheres, values);
	}
}
