package com.perfact.sbm.goods.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.tomcat.util.digester.RuleSet;

import com.perfact.sbm.goods.bean.Goods;
import com.perfact.sbm.goods.dao.GoodsDao;
import com.perfact.sbm.utils.DBManager;

public class GoodsDaoImpl implements GoodsDao {
	private Connection con = null;
	private PreparedStatement ps = null;
	@Override
	public int updateGoods(int goodsNum, int goodsId) {
		// TODO Auto-generated method stub
		con = DBManager.getConnection();
		String sql = "update tb_goods set goodsNum = ? where goodsId = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, goodsNum);
			ps.setInt(2, goodsId);
			return ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBManager.cloes(ps, con);
		}
		return 0;
	}

	@Override
	public Goods getGoodsInfoByName(String goodsName) {
		// TODO Auto-generated method stub
		Goods goods = null;
		con = DBManager.getConnection();
		String sql = "select * from tb_goods where goodsName = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, goodsName);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()){
				goods = new Goods(
						rs.getInt("goodsId"), 
						goodsName, 
						rs.getInt("goodsNum"), 
						rs.getFloat("goodsPrice"),
						rs.getString("goodsUnit"),
						rs.getString("goodsIntro"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBManager.cloes(ps, con);
		}
		
		return goods;
	}

}
