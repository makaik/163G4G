package com.chen.pm.goods.service;

import com.chen.pm.goods.bean.Goods;

public interface GoodsService {
	public int updateGoods(int goodsNum, int goodsId);
	public Goods getGoodsInfoByName(String goodsName);

}
