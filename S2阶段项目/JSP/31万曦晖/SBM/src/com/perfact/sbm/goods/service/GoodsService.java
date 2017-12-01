package com.perfact.sbm.goods.service;

import com.perfact.sbm.goods.bean.Goods;

public interface GoodsService {
	public int updateGoods(int goodsNum, int goodsId);

	public Goods getGoodsInfoByName(String goodsName);

}
