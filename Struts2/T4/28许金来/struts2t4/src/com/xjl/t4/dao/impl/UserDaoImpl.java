package com.xjl.t4.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.xjl.t4.bean.User;
import com.xjl.t4.dao.UserDao;
import com.xjl.t4.utils.DBManager;

public class UserDaoImpl implements UserDao {

	private Connection con;
	private PreparedStatement ps;
	@Override
	public int add(User user) {
		// TODO Auto-generated method stub
		con = DBManager.getConnection();
		String sql = "insert into t_user values (?,?,?,?)";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, user.getUname());
			ps.setString(2, user.getUpwd());
			ps.setString(3, user.getEdu());
			ps.setInt(4, user.getSex());
			return ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBManager.close(ps, con);
			
		}
		
		return 0;
	}

}
