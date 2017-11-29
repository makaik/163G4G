/**
 * 
 */
package com.sea.sbms.common.service;

import java.util.List;

public interface CommonService {

	public int getCount(String tableName, List<String> wheres,
			List<String> values);
}
