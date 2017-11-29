package com.sea.sbms.provider.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sea.sbms.common.bean.PageBean;
import com.sea.sbms.provider.bean.Provider;
import com.sea.sbms.provider.dao.ProviderDao;
import com.sea.sbms.utils.DBManager;
public class ProviderDaoImpl implements ProviderDao {
	private Connection con = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;

	@Override
	public List<Provider> getProvider() {
		List<Provider> list = new ArrayList<>();
		Provider provider = null;
		con = DBManager.getConnection();
		String sql = "select * from tb_provider";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				provider = new Provider(rs.getInt("providerId"),
						rs.getString("providerName"),
						rs.getString("providerDetail"),
						rs.getString("contact"), 
						rs.getString("telephone"),
						rs.getString("facsimile"), 
						rs.getString("address"));
				list.add(provider);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public PageBean allProvider(int p) {
		// TODO Auto-generated method stub
		PageBean pb = new PageBean();
		con = DBManager.getConnection();
		String sql="select count(*) cnt from tb_provider";//查询记录总条数
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			rs.next();
			pb.setPagesize(4);//设置每页显示4条记录。首先调用
			pb.setCount(rs.getInt("cnt"));//其次调用
			pb.setP(p);//最后调用，这三个方法一定注意调用顺序
			rs.close();
			sql="select top "+pb.getPagesize()+" * ";
			sql+="from tb_provider ";
			sql+="where providerId not in";
			sql+="(select top "+(pb.getP()-1)*pb.getPagesize()+" providerId from tb_provider)";
			ps = con.prepareStatement(sql);
			ResultSet rs1 = ps.executeQuery();
			while(rs1.next()){
				Provider provider = new Provider();
				provider.setProviderId(rs1.getInt("providerId"));
				provider.setProviderName(rs1.getString("providerName"));
				provider.setProviderDetail(rs1.getString("providerDetail"));
				provider.setContact(rs1.getString("contact"));
				provider.setTelephone(rs1.getString("telephone"));
				provider.setAddress(rs1.getString("address"));
				pb.addData(provider);
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
	public int deleteProvider(int providerId) {
		// TODO Auto-generated method stub
		con = DBManager.getConnection();
		String sql = "delete from tb_provider where providerId = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, providerId);
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
	public int updateProvider(Provider provider, int providerId) {
		// TODO Auto-generated method stub
		con = DBManager.getConnection();
		String sql = "update tb_provider set "
				+ "providerName=?,providerDetail=?,contact=?,telephone=?,facsimile=?,address=? "
				+ "where providerId=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, provider.getProviderName());
			ps.setString(2, provider.getProviderDetail());
			ps.setString(3, provider.getContact());
			ps.setString(4, provider.getTelephone());
			ps.setString(5, provider.getFacsimile());
			ps.setString(6, provider.getAddress());
			ps.setInt(7, providerId);
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
	public int addProvider(Provider provider) {
		// TODO Auto-generated method stub
		con = DBManager.getConnection();
		String sql = "insert into tb_provider values(?,?,?,?,?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, provider.getProviderName());
			ps.setString(2, provider.getProviderDetail());
			ps.setString(3, provider.getContact());
			ps.setString(4, provider.getTelephone());
			ps.setString(5, provider.getFacsimile());
			ps.setString(6, provider.getAddress());
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
