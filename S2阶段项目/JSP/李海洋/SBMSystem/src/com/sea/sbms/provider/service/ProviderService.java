package com.sea.sbms.provider.service;

import java.util.List;

import com.sea.sbms.common.bean.PageBean;
import com.sea.sbms.provider.bean.Provider;

public interface ProviderService {

	public List<Provider> getProvider();
	
	public PageBean allProvider(int p);

	public int deleteProvider(int providerId);

	public int updateProvider(Provider provider,int providerId);
	
	public int addProvider(Provider provider);
}
