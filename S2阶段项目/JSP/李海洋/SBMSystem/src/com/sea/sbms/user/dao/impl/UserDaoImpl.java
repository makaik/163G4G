package com.sea.sbms.user.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.sea.sbms.common.bean.PageBean;
import com.sea.sbms.provider.bean.Provider;
import com.sea.sbms.user.bean.User;
import com.sea.sbms.user.dao.UserDao;
import com.sea.sbms.utils.DBManager;

public class UserDaoImpl implements UserDao {
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	private User user = null;

	@Override
	public User doLogin(String userName, String userPassword) {
		con = DBManager.getConnection();
		String sql = "select * from tb_user where userName = ? and userPassword = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, userName);
			ps.setString(2, userPassword);

			rs = ps.executeQuery();

			if (rs.next()) {
				user = new User(rs.getInt("userId"), userName, userPassword,
						rs.getString("userSex"), rs.getInt("userAge"),
						rs.getString("telephone"), rs.getString("address"),
						rs.getString("pic"), rs.getInt("type"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBManager.close(ps, con);
		}
		return user;
	}

	@Override
	public int updatePwd(int userId,String userPassword1) {
		// TODO Auto-generated method stub
		con = DBManager.getConnection();
		String sql = "update tb_user set userPassword = ? where userId = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, userPassword1);
			ps.setInt(2, userId);
			return ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public PageBean allUser(int p) {
		// TODO Auto-generated method stub
		PageBean pb = new PageBean();
		con = DBManager.getConnection();
		String sql="select count(*) cnt from tb_user";//查询记录总条数
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			rs.next();
			pb.setPagesize(4);//设置每页显示4条记录。首先调用
			pb.setCount(rs.getInt("cnt"));//其次调用
			pb.setP(p);//最后调用，这三个方法一定注意调用顺序
			rs.close();
			sql="select top "+pb.getPagesize()+" * ";
			sql+="from tb_user ";
			sql+="where userId not in";
			sql+="(select top "+(pb.getP()-1)*pb.getPagesize()+" userId from tb_user)";
			ps = con.prepareStatement(sql);
			ResultSet rs1 = ps.executeQuery();
			while(rs1.next()){
				User user = new User();
				user.setUserId(rs1.getInt("userId"));
				user.setUserName(rs1.getString("userName"));
				user.setUserSex(rs1.getString("userSex"));
				user.setUserAge(rs1.getInt("userAge"));
				user.setTelephone(rs1.getString("telephone"));
				user.setAddress(rs1.getString("address"));
				user.setType(rs1.getInt("type"));
				pb.addData(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBManager.close(ps, con);
		}
		return pb;
	}

	@Override
	public PageBean findUser(User user, int p) {
		// TODO Auto-generated method stub
		PageBean pb=new PageBean();
		con = DBManager.getConnection();
		String condition="";//用于存放查询的条件
		if(user.getUserName() != null && !user.getUserName().equals("")){
			condition+=" where user.userName like '%"+user.getUserName()+"%' ";
		}
		String sql="select count(*) cnt ";
		sql+="from tb_user ";
		sql+=condition;//查询记录总条数的SQL语句
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			rs.next();
			pb.setPagesize(4);//设置每页显示4条记录。首先调用
			pb.setCount(rs.getInt("cnt"));//其次调用
			pb.setP(p);//最后调用，这三个方法一定注意调用顺序
			rs.close();
			sql="select top "+pb.getPagesize()+" * ";
			sql+="from tb_user ";
			sql+=" where userId not in ";
			sql+="(select top "+(pb.getP()-1)*pb.getPagesize()+" userId ";
			sql+="from tb_user ";
			sql+=condition;//添加查询条件
			sql+=") ";
			ps = con.prepareStatement(sql);
			ResultSet rs1 = ps.executeQuery();
			System.out.println(sql);
			while(rs1.next()){
				user.setUserId(rs1.getInt("userId"));
				user.setUserName(rs1.getString("userName"));
				user.setUserSex(rs1.getString("userSex"));
				user.setUserAge(rs1.getInt("userAge"));
				user.setTelephone(rs1.getString("telephone"));
				user.setAddress(rs1.getString("address"));
				user.setType(rs1.getInt("type"));
				pb.addData(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBManager.close(ps, con);
		}
		return pb;
	}

	@Override
	public int deleteUser(int userId) {
		// TODO Auto-generated method stub
		con = DBManager.getConnection();
		String sql = "delete from tb_user where userId = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, userId);
			return ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBManager.close(ps, con);
		}
		return 0;
	}

	@Override
	public int updateUser(User user,int userId) {
		// TODO Auto-generated method stub
		con = DBManager.getConnection();
		String sql = "update tb_user set "
				+ "userName=?,userSex=?,userAge=?,telephone=?,address=?,type=? "
				+ "where userId=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, user.getUserName());
			ps.setString(2, user.getUserSex());
			ps.setInt(3, user.getUserAge());
			ps.setString(4, user.getTelephone());
			ps.setString(5, user.getAddress());
			ps.setInt(6, user.getType());
			ps.setInt(7, userId);
			return ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBManager.close(ps, con);
		}
		return 0;
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
			ps.setInt(8, user.getType());
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
