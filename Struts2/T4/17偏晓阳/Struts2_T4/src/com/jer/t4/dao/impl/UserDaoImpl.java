package com.jer.t4.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.jer.t4.bean.User;
import com.jer.t4.dao.UserDao;
import com.jer.t4.utils.DBManage;

public class UserDaoImpl implements UserDao {
	private Connection con;
	private PreparedStatement ps;
	@Override
	public int add(User user) {
		// TODO Auto-generated method stub
		con = DBManage.getConnection();
		String sql = "insert into t_user (?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, user.getName());
			ps.setString(2, user.getPwd());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBManage.close(ps, con);
		}
		return 0;
	}

}
