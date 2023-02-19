package com.SmartCanteen.util;

import java.sql.Connection;
import java.sql.DriverManager;


/**
 * 数据库工具类
 * @author 22276
 *
 */
public class DbUtil {

	private String dbUrl="jdbc:mysql://192.168.223.131:3306/smartcanteen";
	private String dbUserName = "root";
	private String dbPassword = "clq758748";
	private String jdbcName = "com.mysql.cj.jdbc.Driver";
	
	/**
	 * 获取数据库连接
	 * @return
	 * @throws Exception
	 */
	public Connection getConnection() throws Exception{
		Class.forName(jdbcName);
		Connection con = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
		return con;  
	}

	/**
	 * 关闭连接
	 * @param con
	 * @throws Exception
	 */
	public void closeConnection(Connection con) throws Exception{
		if(con!=null) {
			con.close();
		}
	}
	
	public static void main(String[] args) {
		DbUtil dbutil = new DbUtil();
		try {
			dbutil.getConnection();
			System.out.println("数据库连接成功");
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			System.out.println("数据库连接失败");
		}
	}	
}
