package com.sea.sbms.provider.dao;

import java.util.List;

import com.sea.sbms.common.bean.PageBean;
import com.sea.sbms.provider.bean.Provider;

public interface ProviderDao {

	public List<Provider> getProvider();
	//单表查询分页
	public PageBean allProvider(int p);
	
	public int deleteProvider(int providerId);
	
	public int updateProvider(Provider provider,int providerId);
	
	public int addProvider(Provider provider);
}
