package com.SmartCanteen.AdminView;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

import com.SmartCanteen.dao.DishDao;
import com.SmartCanteen.dao.OrderDao;
import com.SmartCanteen.model.Order;
import com.SmartCanteen.util.DbUtil;
import com.SmartCanteen.util.StringUtil;

public class HistoricalOrderInterFrm extends JInternalFrame {
	private static final JTable j_orderTable = null;
	DbUtil dbUtil = new DbUtil();
	OrderDao orderDao = new OrderDao();
	DishDao dishDao = new DishDao();

	/** Creates new form checkOrderInterFrm */
	public HistoricalOrderInterFrm() {
		initComponents();
		this.setLocation(320, 100);
		fillOrderTable();
	}

	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {
		jScrollPane2 = new javax.swing.JScrollPane();
		jLabel3 = new javax.swing.JLabel();
		orderStatusTxt = new javax.swing.JTextField();
		jScrollPane1 = new javax.swing.JScrollPane();

		setClosable(true);
		setIconifiable(true);
		setTitle("\u5386\u53F2\u8BA2\u5355");

		jLabel3.setText("\u8ba2\u5355\u72b6\u6001\uff1a");

		orderStatusTxt.setEditable(false);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		layout.setHorizontalGroup(
			layout.createParallelGroup(Alignment.TRAILING)
				.addGroup(layout.createSequentialGroup()
					.addContainerGap()
					.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 410, GroupLayout.PREFERRED_SIZE)
					.addGap(51)
					.addGroup(layout.createParallelGroup(Alignment.TRAILING)
						.addGroup(layout.createSequentialGroup()
							.addComponent(jLabel3)
							.addGap(39)
							.addComponent(orderStatusTxt, 80, 80, 80)
							.addGap(262))
						.addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 510, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		layout.setVerticalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
					.addGap(64)
					.addGroup(layout.createParallelGroup(Alignment.LEADING)
						.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 344, GroupLayout.PREFERRED_SIZE)
						.addGroup(layout.createSequentialGroup()
							.addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE)
							.addGap(28)
							.addGroup(layout.createParallelGroup(Alignment.BASELINE)
								.addComponent(orderStatusTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel3))))
					.addContainerGap(119, Short.MAX_VALUE))
		);
		
		cartTable = new JTable();
		cartTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u83DC\u54C1\u540D\u79F0", "\u83DC\u54C1\u7C7B\u522B", "\u6570\u91CF"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		cartTable.getColumnModel().getColumn(0).setPreferredWidth(151);
		cartTable.getColumnModel().getColumn(1).setPreferredWidth(104);
		jScrollPane2.setViewportView(cartTable);
		getContentPane().setLayout(layout);
		
		orderTable = new JTable();
		orderTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u8BA2\u5355\u7F16\u53F7", "\u70B9\u9910\u4EBAID", "\u914D\u9910\u7528\u65F6(\u5206\u949F)", "\u8BA2\u5355\u72B6\u6001"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		orderTable.getColumnModel().getColumn(0).setPreferredWidth(149);
		orderTable.getColumnModel().getColumn(1).setPreferredWidth(85);
		orderTable.getColumnModel().getColumn(2).setPreferredWidth(98);
		jScrollPane1.setViewportView(orderTable);
		orderTable.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent evt) {
				orderTableMousePressed(evt);
			}
		});

		pack();
	}// </editor-fold>

	

	//填充ordertable
	private void fillOrderTable() {
		Order order = new Order();
		order.setOrderId("");
		DefaultTableModel dtm = (DefaultTableModel) orderTable.getModel();
		dtm.setRowCount(0);
		Connection con = null;
		try {
			con = dbUtil.getConnection();
			ResultSet rs = orderDao.orderList(con, order);
			while (rs.next()) {
				Vector v = new Vector();
				v.add(rs.getString("orderid"));
				v.add(rs.getString("userid"));
				v.add(rs.getString("finishtime"));
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
				dbUtil.closeConnection(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
	
	//点击订单表，显示订单信息
		protected void orderTableMousePressed(MouseEvent evt) {
			//获取选中的行
					int row = orderTable.getSelectedRow();
					String orderId = (String) orderTable.getValueAt(row, 0);
					String orderStatus = (String) orderTable.getValueAt(row, 3);
					this.orderStatusTxt.setText(orderStatus);
					Order order = new Order();
					order.setOrderId(orderId);
					DefaultTableModel dtm = (DefaultTableModel) cartTable.getModel();
					dtm.setRowCount(0);
					Connection con = null;
					try {
						con = dbUtil.getConnection() ;
						ResultSet rs = orderDao.dishList(con, order);
						while (rs.next()) {
							Vector v = new Vector();
							v.add(rs.getString("dishname"));
							v.add(rs.getString("dishtype"));
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

	//重置carttable
	private void resetCartTable() {

		this.orderStatusTxt.setText("");
		DefaultTableModel dtm = (DefaultTableModel) cartTable.getModel();
		dtm.setRowCount(0);

	}
	private javax.swing.JLabel jLabel3;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JTextField orderStatusTxt;
	private JTable orderTable;
	private JTable cartTable;
}
