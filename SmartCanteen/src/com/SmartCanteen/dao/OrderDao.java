package com.SmartCanteen.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.SmartCanteen.model.Order;
import com.SmartCanteen.util.StringUtil;

public class OrderDao {
	public int order_dishAdd(Connection con ,Order order) throws Exception{
		String sql="insert into `order_dish` values(?,?,?,?,?)";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, order.getOrderId());
		pstmt.setDouble(2, order.getDishPrice());		
		pstmt.setInt(3, order.getDishNum());
		pstmt.setString(4, order.getDishName()	);
		pstmt.setString(5, order.getDishType());
		return pstmt.executeUpdate();
	}
	
	public int order_infoAdd(Connection con ,Order order) throws Exception{
		String sql="insert into `order_info` values(?,?,?,?,?,null,?)";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, order.getOrderId());
		pstmt.setString(2, order.getUserName());
		pstmt.setInt(3, order.getStatus());		
		pstmt.setDouble(4, order.getTotal());
		pstmt.setString(5, order.getUserId());
		pstmt.setString(6, order.getTableId());

		return pstmt.executeUpdate();
	}
	
	public ResultSet orderList(Connection con,Order order) throws Exception{	
		StringBuffer sb=new StringBuffer("select * from `order_info`");
		if(StringUtil.isNotEmpty(order.getOrderId())){
			sb.append(" and orderId like '%"+order.getOrderId()+"%'");
		}
		if(StringUtil.isNotEmpty(order.getUserName())){
			sb.append(" and userName like '%"+order.getUserName()+"%'");
		}
		sb.append(" order by orderid desc");
		PreparedStatement pstmt=con.prepareStatement(sb.toString().replaceFirst("and", "where"));
		return pstmt.executeQuery();
	}
	
	public ResultSet DealOrderList(Connection con,Order order) throws Exception{	
		StringBuffer sb=new StringBuffer("select * from `order_info` where status=0 or status=1 order by status,orderid");
		
		PreparedStatement pstmt=con.prepareStatement(sb.toString());
		return pstmt.executeQuery();
	}
	
	public ResultSet dishList(Connection con,Order order) throws Exception{	
		StringBuffer sb=new StringBuffer("select * from `order_dish`");
		if(StringUtil.isNotEmpty(order.getOrderId())){
			sb.append(" and orderId like '%"+order.getOrderId()+"%'");
		}
		PreparedStatement pstmt=con.prepareStatement(sb.toString().replaceFirst("and", "where"));
		return pstmt.executeQuery();
	}
	
	public int orderStatusModify(Connection con,Order order) throws Exception{
		String sql="update order_info set status=? where orderId=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setInt(1, order.getStatus());
		pstmt.setString(2, order.getOrderId());
		return pstmt.executeUpdate();
	}
	
	public int setFinishTime(Connection con,Order order,double finishTime) throws Exception{
		String sql="update order_info set finishtime=? where orderId=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setDouble(1, finishTime);
		pstmt.setString(2, order.getOrderId());
		return pstmt.executeUpdate();
	}
	
	public ResultSet dishTimes(Connection con,Order order) throws Exception{
		String sql="select dishname,dishtype,dishprice ,sum(dishnum) from `order_dish` group by dishname order by sum(dishnum) desc";
		PreparedStatement pstmt=con.prepareStatement(sql);
		return pstmt.executeQuery();
	}
	
	public ResultSet avgTime(Connection con,Order order) throws Exception{
		String sql="select count(*),sum(finishtime)  from order_info where finishtime is not null";
		PreparedStatement pstmt=con.prepareStatement(sql);
		return pstmt.executeQuery();
	}
	
	public ResultSet income(Connection con,Order order) throws Exception{
		String sql="select sum(total)  from order_info";
		PreparedStatement pstmt=con.prepareStatement(sql);
		return pstmt.executeQuery();
	}
}
