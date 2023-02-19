package com.SmartCanteen.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.SmartCanteen.model.Dish;
import com.SmartCanteen.util.StringUtil;

public class DishDao {
	public int dishAdd(Connection con,Dish dish) throws Exception{
		String sql="insert into dish values(?,?,?,?)";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, dish.getDishName());
		pstmt.setString(2, dish.getDishType());
		pstmt.setDouble(3, dish.getPrice());
		pstmt.setString(4, dish.getIngredient());
		return pstmt.executeUpdate();
	}
	
	public ResultSet dishList(Connection con,Dish dish) throws Exception{	
		StringBuffer sb=new StringBuffer("select * from `dish`");
		if(StringUtil.isNotEmpty(dish.getDishName())){
			sb.append(" and dishname like '%"+dish.getDishName()+"%'");
		}
		if(StringUtil.isNotEmpty(dish.getDishType())) {
			sb.append(" and dishtype like '%"+dish.getDishType()+"%'");
		}
		if(dish.getPrice()!=0){
			sb.append(" and price="+dish.getPrice());
		}
		sb.append(" order by dishtype");
		//System.out.println(sb.toString().replaceFirst("and", "where"));
		PreparedStatement pstmt=con.prepareStatement(sb.toString().replaceFirst("and", "where"));
		return pstmt.executeQuery();
	}
	
	
	public int dishDelete(Connection con,String name) throws Exception{
		String sql="delete from dish where dishname=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, name);
		return pstmt.executeUpdate();
	}
	
	public int dishModify(Connection con,Dish dish) throws Exception{
		String sql="update dish set dishname=?,dishtype=?,price=?,ingredient=? where id=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, dish.getDishName());
		pstmt.setString(2, dish.getDishType());
		pstmt.setDouble(3, dish.getPrice());
		pstmt.setString(4, dish.getIngredient());
		return pstmt.executeUpdate();
	}
}

