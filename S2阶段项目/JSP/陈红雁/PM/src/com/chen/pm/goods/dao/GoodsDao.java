package com.chen.pm.goods.dao;

import com.chen.pm.goods.bean.Goods;

public interface GoodsDao {
	public int updateGoods(int goodsNum, int goodsId);
	public Goods getGoodsInfoByName(String goodsName);

}
