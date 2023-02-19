package com.SmartCanteen.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.SmartCanteen.model.User;
import com.SmartCanteen.util.StringUtil;


public class UserDao {

	public User login(Connection con,User user) throws Exception{
		User resultUser = null;
		String sql="select *from user where name=? and password=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, user.getName());
		pstmt.setString(2, user.getPassWord());
		ResultSet rs=pstmt.executeQuery();
		if(rs.next()){
			resultUser = new User();
			resultUser.setName(rs.getString("name"));
			resultUser.setPassWord(rs.getString("password"));
			resultUser.setId(rs.getString("id"));
			resultUser.setAccount(rs.getDouble("account"));
		}
		return resultUser;
	}
	public int getLatestId(Connection con) throws Exception{
		String sql="select max(t_id) from user";
		PreparedStatement pstmt=con.prepareStatement(sql);
		ResultSet rs=pstmt.executeQuery();
		int id=0;
		while(rs.next())
			id = rs.getInt("max(t_id)");
		System.out.println(id);
		return id;
	}
	
	public int userAdd(Connection con,User user) throws Exception{
		UserDao userDao = new UserDao();
		StringUtil stringUtil = new StringUtil();
		int Id = userDao.getLatestId(con);
		String userId = stringUtil.fillUserId(Id);
		String sql="insert into `user` values(?,null,?,?,?)";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, userId);
		pstmt.setString(2, user.getName());
		pstmt.setDouble(3, 0);
		pstmt.setString(4, user.getPassWord());
		
		return pstmt.executeUpdate();
	}
	public boolean isUserExist(Connection con,User user) throws Exception{
		String sql="select *from user where name=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, user.getName());
		ResultSet rs =pstmt.executeQuery();
		return rs.next();
	}
	
	public int Charge(Connection con,User user,double addAccount) throws Exception{
		String sql="update `user` set account=account+? where id=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setDouble(1, addAccount);
		pstmt.setString(2, user.getId());
		
		return pstmt.executeUpdate();
	}
	
	public int reduceAccount(Connection con,User user,double Account) throws Exception{
		String sql="update `user` set account=account-? where id=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setDouble(1, Account);
		pstmt.setString(2, user.getId());
		
		return pstmt.executeUpdate();
	}
	/*
	public int userModify(Connection con,User user) throws Exception{
		String sql="update `user` set userName=?,password=?,email=? where id=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, user.getName());
		pstmt.setString(2, user.getPassWord());
		pstmt.setInt(4, user.getId());;
		return pstmt.executeUpdate();
	}
	*/
}
