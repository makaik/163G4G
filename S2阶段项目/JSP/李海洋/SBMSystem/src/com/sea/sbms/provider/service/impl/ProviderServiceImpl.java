/**
 * 
 */
package com.sea.sbms.provider.service.impl;

import java.util.List;

import com.sea.sbms.common.bean.PageBean;
import com.sea.sbms.provider.bean.Provider;
import com.sea.sbms.provider.dao.impl.ProviderDaoImpl;
import com.sea.sbms.provider.service.ProviderService;

public class ProviderServiceImpl implements ProviderService {

	@Override
	public List<Provider> getProvider() {
		return new ProviderDaoImpl().getProvider();
	}

	@Override
	public PageBean allProvider(int p) {
		return new ProviderDaoImpl().allProvider(p);
	}

	@Override
	public int deleteProvider(int providerId) {
		return new ProviderDaoImpl().deleteProvider(providerId);
	}

	@Override
	public int updateProvider(Provider provider, int providerId) {
		// TODO Auto-generated method stub
		return new ProviderDaoImpl().updateProvider(provider, providerId);
	}

	@Override
	public int addProvider(Provider provider) {
		return new ProviderDaoImpl().addProvider(provider);
	}

}
