package com.chen.pm.provider.service.impl;

import java.util.List;

import com.chen.pm.provider.bean.Provider;
import com.chen.pm.provider.dao.impl.ProviderDaoImpl;
import com.chen.pm.provider.service.ProviderService;

public class ProviderServiceImpl implements ProviderService{
	@Override
	public List<Provider> getProvider() {
		// TODO Auto-generated method stub
		return new ProviderDaoImpl().getProvider();
	}
}
