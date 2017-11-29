package com.zzh.t04.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.zzh.t04.bean.User;
import com.zzh.t04.dao.UserDao;
import com.zzh.t04.util.DBManager;

public class UserDaoImpl implements UserDao {
	Connection con;
	PreparedStatement ps;

	@Override
		
		public int add(User user) {
			con = DBManager.getConnection();
			String sql = "insert into t_user values (?,?,?,?,?,?)";
			try {
				ps = con.prepareStatement(sql);
				ps.setString(1, user.getName());
				ps.setString(2, user.getPassword());
				ps.setString(3, user.getBirthday());
				ps.setString(4, user.getSex());
				ps.setString(5, user.getLove());
				ps.setString(6, user.getActive());
				return ps.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				DBManager.close(ps,con);
			}
			return 0;
		}
	
}
