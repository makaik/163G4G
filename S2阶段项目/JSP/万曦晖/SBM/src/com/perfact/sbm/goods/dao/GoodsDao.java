package com.perfact.sbm.goods.dao;

import com.perfact.sbm.goods.bean.Goods;

public interface GoodsDao {
	public int updateGoods(int goodsNum, int goodsId);

	public Goods getGoodsInfoByName(String goodsName);

}
