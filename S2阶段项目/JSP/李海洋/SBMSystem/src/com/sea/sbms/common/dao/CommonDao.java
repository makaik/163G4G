package com.sea.sbms.common.dao;

import java.util.List;

public interface CommonDao {

	public int getCount(String tableName, List<String> wheres,
			List<String> values);

}
