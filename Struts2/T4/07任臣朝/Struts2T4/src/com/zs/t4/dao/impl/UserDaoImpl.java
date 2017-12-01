package com.zs.t4.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.zs.t4.bean.User;
import com.zs.t4.dao.UserDao;
import com.zs.t4.util.DBManager;


public class UserDaoImpl implements UserDao {
	private Connection con;
	private PreparedStatement ps;
	@Override
	public int add(User user){
		con =DBManager.getConnection();
		String sql="insert into t_user values(?,?,?,?)";
	
			try {
				ps = con.prepareStatement(sql);
				ps.setString(1, user.getName());
				ps.setString(2, user.getPwd());
				ps.setString(3, user.getDate());
				ps.setInt(4, user.getSex());
				
				return ps.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return 0;
	}
}
