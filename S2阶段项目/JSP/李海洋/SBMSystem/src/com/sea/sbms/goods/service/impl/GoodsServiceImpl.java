/**
 * 
 */
package com.sea.sbms.goods.service.impl;

import com.sea.sbms.goods.bean.Goods;
import com.sea.sbms.goods.dao.impl.GoodsDaoImpl;
import com.sea.sbms.goods.service.GoodsService;

/**
 * @author admin 2017年11月15日
 */
public class GoodsServiceImpl implements GoodsService {

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
