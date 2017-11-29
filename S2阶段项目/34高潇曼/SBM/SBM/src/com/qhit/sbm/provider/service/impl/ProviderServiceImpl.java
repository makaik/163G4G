/**
 * 
 */
package com.qhit.sbm.provider.service.impl;

import java.util.List;

import com.qhit.sbm.provider.bean.Provider;
import com.qhit.sbm.provider.dao.impl.ProviderDaoImpl;
import com.qhit.sbm.provider.service.ProviderService;

/**
 * @author admin
 * 2017年11月11日
 */
public class ProviderServiceImpl implements ProviderService {

	@Override
	public List<Provider> getProvider() {
		// TODO Auto-generated method stub
		return new ProviderDaoImpl().getProvider();
	}

	@Override
	public int addprovider(Provider provider) {
		// TODO Auto-generated method stub
		return new ProviderDaoImpl().addprovider(provider);
	}

}
