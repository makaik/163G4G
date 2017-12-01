package com.chen.pm.goods.service.impl;

import com.chen.pm.goods.bean.Goods;
import com.chen.pm.goods.dao.impl.GoodsDaoImpl;
import com.chen.pm.goods.service.GoodsService;

public class GoodsServiceImpl implements GoodsService{

	@Override
	public Goods getGoodsInfoByName(String goodsName) {
		// TODO Auto-generated method stub
		return new GoodsDaoImpl().getGoodsInfoByName(goodsName);
	}

	@Override
	public int updateGoods(int goodsNum, int goodsId) {
		// TODO Auto-generated method stub
		return new GoodsDaoImpl().updateGoods(goodsNum, goodsId);
	}


}

