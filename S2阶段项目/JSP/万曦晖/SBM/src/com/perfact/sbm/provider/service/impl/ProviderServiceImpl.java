package com.perfact.sbm.provider.service.impl;

import java.util.List;

import com.perfact.sbm.provider.bean.Provider;
import com.perfact.sbm.provider.dao.impl.ProviderDaoImpl;
import com.perfact.sbm.provider.service.ProviderService;

public class ProviderServiceImpl implements ProviderService {

	@Override
	public List<Provider> getProvider() {
		// TODO Auto-generated method stub
		return new ProviderDaoImpl().getProvider();
	}

}
