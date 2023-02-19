package com.SmartCanteen.CustomerView;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

import com.SmartCanteen.dao.DishDao;
import com.SmartCanteen.dao.OrderDao;
import com.SmartCanteen.model.Dish;
import com.SmartCanteen.model.Order;
import com.SmartCanteen.util.DbUtil;
import com.SmartCanteen.util.StringUtil;


public class CheckOrderInterFrm extends javax.swing.JInternalFrame {
	private static final JTable j_orderTable = null;
	DbUtil dbUtil = new DbUtil();
	OrderDao orderDao = new OrderDao();
	DishDao dishDao = new DishDao();

	/** Creates new form checkOrderInterFrm */
	public CheckOrderInterFrm() {
		initComponents();
		this.setLocation(320, 100);
		this.userNameTxt.setText(LogOnFrm.s_currentUser.getName());
		this.fillOrderTable();
	}

	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		jScrollPane2 = new javax.swing.JScrollPane();
		cartTable = new javax.swing.JTable();
		totalMoneyTxt = new javax.swing.JTextField();
		jLabel1 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		orderStatusTxt = new javax.swing.JTextField();
		jb_status = new javax.swing.JButton();
		jLabel4 = new javax.swing.JLabel();
		userNameTxt = new javax.swing.JTextField();
		jScrollPane1 = new javax.swing.JScrollPane();
		orderTable = new javax.swing.JTable();

		setClosable(true);
		setIconifiable(true);
		setTitle("\u5386\u53F2\u8BA2\u5355");

		cartTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u83DC\u54C1\u540D\u79F0", "\u83DC\u54C1\u7C7B\u522B", "\u5355\u4EF7", "\u6570\u91CF"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		cartTable.getColumnModel().getColumn(0).setPreferredWidth(99);
		cartTable.getColumnModel().getColumn(1).setPreferredWidth(90);

		jScrollPane2.setViewportView(cartTable);

		totalMoneyTxt.setEditable(false);

		jLabel1.setText("\u603b\u91d1\u989d\uff1a");

		jLabel3.setText("\u8ba2\u5355\u72b6\u6001\uff1a");

		orderStatusTxt.setEditable(false);

		jb_status.setText("\u53d6\u6d88\u8ba2\u5355");
		jb_status.setFocusPainted(false);
		jb_status.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jb_statusActionPerformed(evt);
			}
		});

		jLabel4.setText("\u70b9\u9910\u4eba\uff1a");

		userNameTxt.setEditable(false);

		orderTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u8BA2\u5355\u7F16\u53F7", "\u8BA2\u5355\u603B\u91D1\u989D", "\u8BA2\u5355\u72B6\u6001"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		orderTable.getColumnModel().getColumn(0).setPreferredWidth(154);
		orderTable.getColumnModel().getColumn(1).setPreferredWidth(83);
		orderTable.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent evt) {
				orderTableMousePressed(evt);
			}
		});
		jScrollPane1.setViewportView(orderTable);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		layout.setHorizontalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
					.addGap(29)
					.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 367, GroupLayout.PREFERRED_SIZE)
					.addGap(35)
					.addGroup(layout.createParallelGroup(Alignment.TRAILING)
						.addGroup(layout.createSequentialGroup()
							.addComponent(jLabel4)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(userNameTxt, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
							.addGap(35))
						.addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 510, GroupLayout.PREFERRED_SIZE)
						.addGroup(layout.createSequentialGroup()
							.addComponent(jLabel3)
							.addGap(18)
							.addComponent(orderStatusTxt, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(jLabel1)
							.addGap(10)
							.addComponent(totalMoneyTxt, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
							.addGap(32)
							.addComponent(jb_status)))
					.addContainerGap(23, Short.MAX_VALUE))
		);
		layout.setVerticalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
					.addContainerGap()
					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
						.addComponent(jLabel4)
						.addComponent(userNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(23)
					.addGroup(layout.createParallelGroup(Alignment.LEADING)
						.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 297, GroupLayout.PREFERRED_SIZE)
						.addGroup(layout.createSequentialGroup()
							.addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE)
							.addGap(38)
							.addGroup(layout.createParallelGroup(Alignment.BASELINE)
								.addComponent(jLabel3)
								.addComponent(orderStatusTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel1)
								.addComponent(totalMoneyTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(jb_status))))
					.addContainerGap(133, Short.MAX_VALUE))
		);
		getContentPane().setLayout(layout);

		pack();
	}// </editor-fold>
	//GEN-END:initComponents

	//填充ordertable
	private void fillOrderTable() {
		String userName = this.userNameTxt.getText();
		Order order = new Order();
		order.setUserName(userName);
		DefaultTableModel dtm = (DefaultTableModel) orderTable.getModel();
		dtm.setRowCount(0);
		Connection con = null;
		try {
			con = dbUtil.getConnection();
			ResultSet rs = orderDao.orderList(con, order);
			while (rs.next()) {
				Vector v = new Vector();
				v.add(rs.getString("orderid"));
				v.add(rs.getDouble("total"));
				int status = rs.getInt("status");
				switch (status) {
				case 0:
					v.add("未处理");
					break;
				case 1:
					v.add("配餐中");
					break;
				case 2:
					v.add("已完成");
					break;
				case 3:
					v.add("已取消");
					break;
				}
				dtm.addRow(v);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				dbUtil.closeConnection(con);;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	//取消订单操作
	private void jb_statusActionPerformed(java.awt.event.ActionEvent evt) {
		//获取选中的行，如果为选中，row默认为-1
		int row = orderTable.getSelectedRow();//
		if (row < 0) {
			JOptionPane.showMessageDialog(null, "请选择一个订单");
			return;
		}
		//获取订单编号
		String orderId = (String) orderTable.getValueAt(row, 0);
		Order order = new Order();
		order.setOrderId(orderId);
		if(this.orderStatusTxt.getText().equals("未处理")) {
			order.setStatus(3);//取消订单
		}
		else {
			JOptionPane.showMessageDialog(null, "正在配餐或已完成，无法取消");
			return;
		}
		try {
			Connection con = dbUtil.getConnection();
			int modifyNum = orderDao.orderStatusModify(con, order);
			if (modifyNum == 1) {
				JOptionPane.showMessageDialog(null, "取消成功！");
				this.orderStatusTxt.setText("已取消");
				this.jb_status.setEnabled(false);
				fillOrderTable();
			} else {
				JOptionPane.showMessageDialog(null, "取消订单失败！");
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//点击订单table	
	private void orderTableMousePressed(java.awt.event.MouseEvent evt) {
		//获取选中的行
		int row = orderTable.getSelectedRow();
		String orderId = (String) orderTable.getValueAt(row, 0);
		this.totalMoneyTxt.setText(orderTable.getValueAt(row, 1) + "");
		String orderStatus = (String) orderTable.getValueAt(row, 2);
		this.orderStatusTxt.setText(orderStatus);

		//修改取消订单按钮状态
		if (!orderStatus.equals("未处理")) {
			jb_status.setEnabled(false);
		} else {
			jb_status.setEnabled(true);
		}
		Order order = new Order();
		order.setOrderId(orderId);
		DefaultTableModel dtm = (DefaultTableModel) cartTable.getModel();
		dtm.setRowCount(0);
		Connection con = null;
		try {
			con = dbUtil.getConnection();
			ResultSet rs = orderDao.dishList(con, order);
			while (rs.next()) {
				Vector v = new Vector();
				v.add(rs.getString("dishname"));
				v.add(rs.getString("dishtype"));
				v.add(rs.getFloat("dishprice"));
				v.add(rs.getInt("dishnum"));
				dtm.addRow(v);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				dbUtil.closeConnection(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JTable cartTable;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JButton jb_status;
	private javax.swing.JTextField orderStatusTxt;
	private javax.swing.JTable orderTable;
	private javax.swing.JTextField totalMoneyTxt;
	private javax.swing.JTextField userNameTxt;
	// End of variables declaration//GEN-END:variables

}
