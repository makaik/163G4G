package com.perfact.sbm.user.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.perfact.sbm.user.bean.User;
import com.perfact.sbm.user.dao.UserDao;
import com.perfact.sbm.utils.DBManager;

public class UserDaoImpl implements UserDao {
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	private User user = null;
	
	public User doLogin(String userName, String userPassword) {
		// TODO Auto-generated method stub
		con = DBManager.getConnection();
		String sql = "select * from tb_user where userName = ? and userPassword = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, userName);
			ps.setString(2, userPassword);
			rs = ps.executeQuery();
			if(rs.next()){
				user = new User(
						rs.getInt("userId"),
						userName, 
						userPassword,
						rs.getString("userSex"), 
						rs.getInt("userAge"), 
						rs.getString("telephone"),
						rs.getString("address"), 
						rs.getString("pic"), 
						rs.getInt("type"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBManager.cloes(ps,con);
		}
		
		return user;
	}

	@Override
	public int addUser(User user) {
		// TODO Auto-generated method stub
		con = DBManager.getConnection();
		String sql = "insert into tb_user values (?,?,?,?,?,?,?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, user.getUserName());
			ps.setString(2, user.getUserPassword());
			ps.setString(3, user.getUserSex());
			ps.setInt(4, user.getUserAge());
			ps.setString(5, user.getTelephone());
			ps.setString(6, user.getAddress());
			ps.setString(7, user.getPic());
			ps.setInt(1, user.getType());
			return ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

}
