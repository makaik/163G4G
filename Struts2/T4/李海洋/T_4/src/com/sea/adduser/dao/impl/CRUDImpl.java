package com.sea.adduser.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sea.adduser.bean.User;
import com.sea.adduser.dao.CRUD;
import com.sea.adduser.util.ConFactory;

public class CRUDImpl implements CRUD {
	private Connection con = null;
	private PreparedStatement ps =null;
	private ResultSet rs = null;
	@Override
	public void addUser(User user) {
		// 添加
		con = ConFactory.getConnection();
		String sql = "insert into tb_user values(?,?,?,?,?,?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, user.getUserName());
			ps.setString(2, user.getUserPassword());
			ps.setString(3, user.getUserSex());
			ps.setInt(4, user.getUserAge());
			ps.setString(5, user.getPhone());
			ps.setString(6, user.getQQ());
			ps.setString(7, user.getAddress());
			System.out.println(ps.executeUpdate()+"已保存");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			ConFactory.close(ps, con);
		}

	}

	@Override
	public List<User> allUser() {
		// 遍历查询
		List<User> list = new ArrayList<User>();
		con = ConFactory.getConnection();
		String sql = "select * from tb_user";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				 User user = new User(
						 rs.getInt("userId"),
						 rs.getString("userName"), 
						 rs.getString("userPassword"),
						 rs.getString("userSex"),
						 rs.getInt("userAge"),
						 rs.getString("phone"),
						 rs.getString("qQ"),
						 rs.getString("address"));
				 list.add(user);
			}
			System.out.println("kkk");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			ConFactory.close(ps, con);
		}
		return list;
	}

	@Override
	public void del(int userId) {
		// 删除
		con = ConFactory.getConnection();
		String sql = "delete from tb_user where userId = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, userId);
			System.out.println(ps.executeUpdate()+"条数据删除");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			ConFactory.close(ps, con);
		}
	}

	@Override
	public User perUpdate(int userId) {
		// 预查询
		User user = null;
		con = ConFactory.getConnection();
		String sql = "select * from tb_user where userId = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, userId);
			rs = ps.executeQuery();
			while (rs.next()) {
				 user = new User(
						 rs.getInt("userId"),
						 rs.getString("userName"), 
						 rs.getString("userPassword"),
						 rs.getString("userSex"),
						 rs.getInt("userAge"),
						 rs.getString("phone"),
						 rs.getString("qQ"),
						 rs.getString("address"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			ConFactory.close(ps, con);
		}
		return user;
	}

	@Override
	public void update(User user) {
		// 修改
		con = ConFactory.getConnection();
		String sql = "update tb_user set userName = ?,userPassword = ?,userSex = ?,userAge = ?,phone = ?,QQ = ?,address = ? where userId = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, user.getUserName());
			ps.setString(2, user.getUserPassword());
			ps.setString(3, user.getUserSex());
			ps.setInt(4, user.getUserAge());
			ps.setString(5, user.getPhone());
			ps.setString(6, user.getQQ());
			ps.setString(7, user.getAddress());
			ps.setInt(8, user.getUserId());
			System.out.println(ps.executeUpdate()+"条数据修改");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			ConFactory.close(ps, con);
		}
	}

}
