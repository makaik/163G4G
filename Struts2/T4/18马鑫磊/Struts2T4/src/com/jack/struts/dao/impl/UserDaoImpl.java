package com.jack.struts.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import com.jack.struts.bean.User;
import com.jack.struts.dao.UserDao;
import com.jack.struts.utils.DBManager;

public class UserDaoImpl implements UserDao {
private Connection con =null;
private  PreparedStatement ps=null;
	@Override
	public int addUser(User user) {
		// TODO Auto-generated method stub
		
		try {
			con=DBManager.getConnection();
			String sql ="insert into tb_user values(?,?,?,?,?)";
			ps=con.prepareStatement(sql);
			ps.setString(1, user.getName());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getBirthday());
			ps.setInt(4, user.getSex());
			ps.setString(5, user.getIsable());
			System.out.println(sql);
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
