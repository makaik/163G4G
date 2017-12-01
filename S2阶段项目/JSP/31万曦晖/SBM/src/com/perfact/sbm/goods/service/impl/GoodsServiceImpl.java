package com.perfact.sbm.goods.service.impl;


import com.perfact.sbm.goods.bean.Goods;
import com.perfact.sbm.goods.dao.impl.GoodsDaoImpl;
import com.perfact.sbm.goods.service.GoodsService;

public class GoodsServiceImpl implements GoodsService {
	@Override
	public int updateGoods(int goodsNum, int goodsId) {
		// TODO Auto-generated method stub
		return new GoodsDaoImpl().updateGoods(goodsNum, goodsId);
	}

	@Override
	public Goods getGoodsInfoByName(String goodsName) {
		// TODO Auto-generated method stub
		return new GoodsDaoImpl().getGoodsInfoByName(goodsName);
	}

}
