package com.perfact.sbm.account.service;

import java.util.List;

import com.perfact.sbm.common.bean.PageBean;
import com.perfact.sbm.goods.bean.Goods;




public interface AccountService {
	
	public int deleteAccountById(int accountId);
	
	public int updateAccount(int accountId, int isPayed);
	
	public int addAccount(Goods goods, int providerId,int isPayed, int businessNum);
	
	public PageBean getAccount(PageBean pageBean);
	
	public int getCount(List<String> wheres,List<String> values);
	
	public PageBean getAccount(PageBean pageBean,List<String> wheres, List<String> values);
}
