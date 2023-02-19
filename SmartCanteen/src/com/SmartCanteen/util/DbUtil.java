package com.SmartCanteen.util;

import java.sql.Connection;
import java.sql.DriverManager;


/**
 * ���ݿ⹤����
 * @author 22276
 *
 */
public class DbUtil {

	private String dbUrl="jdbc:mysql://192.168.223.131:3306/smartcanteen";
	private String dbUserName = "root";
	private String dbPassword = "clq758748";
	private String jdbcName = "com.mysql.cj.jdbc.Driver";
	
	/**
	 * ��ȡ���ݿ�����
	 * @return
	 * @throws Exception
	 */
	public Connection getConnection() throws Exception{
		Class.forName(jdbcName);
		Connection con = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
		return con;  
	}

	/**
	 * �ر�����
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
			System.out.println("���ݿ����ӳɹ�");
		} catch (Exception e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
			System.out.println("���ݿ�����ʧ��");
		}
	}	
}
