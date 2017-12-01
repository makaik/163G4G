package com.perfact.sbm.account.dao;

import java.util.List;

import com.perfact.sbm.common.bean.PageBean;
import com.perfact.sbm.goods.bean.Goods;

public interface AccountDao {
	
	public int deleteAccountById(int accountId);
	
	public int updateAccount(int acountId,int isPayed);
	
	public int addAccount(Goods goods, int providerId,int isPayed, int businessNum);
	
	public PageBean getAccount(PageBean pageBean);
	
	public int getCount(List<String> wheres,List<String> values);

	public PageBean getAccount(PageBean pageBean,List<String> wheres,List<String> values);
}
