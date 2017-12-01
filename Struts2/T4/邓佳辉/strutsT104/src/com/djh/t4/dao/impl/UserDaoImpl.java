package com.djh.t4.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.djh.t4.bean.User;
import com.djh.t4.dao.UserDao;
import com.djh.t4.util.DBManager;

public class UserDaoImpl implements UserDao{
	private Connection con;
	private PreparedStatement ps;
	@Override
	public int add(User user) {
		con=DBManager.getConnection();
		String sql = "insert into tb_user values(?,?,?,?)";
			try {
				ps=con.prepareStatement(sql);
				ps.setString(1, user.getUname());
				ps.setString(2, user.getPswd());
				ps.setString(3, user.getEdu());
				ps.setString(4, user.getSex());
				return ps.executeUpdate();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				DBManager.close(ps,con);
			}
		return 0;
	}
	
	
}
