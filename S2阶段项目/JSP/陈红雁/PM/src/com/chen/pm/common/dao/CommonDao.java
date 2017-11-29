package com.chen.pm.common.dao;

import java.util.List;

public interface CommonDao {
	public int getCount(String tableName,List<String> wheres,List<String> values);
}

