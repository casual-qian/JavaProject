package com.SmartCanteen.AdminView;

import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.SmartCanteen.dao.DishDao;
import com.SmartCanteen.dao.OrderDao;
import com.SmartCanteen.model.Dish;
import com.SmartCanteen.model.Order;
import com.SmartCanteen.util.DbUtil;
import com.SmartCanteen.util.StringUtil;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 *
 * @author  __USER__
 */
public class DealOrderInterFrm extends javax.swing.JInternalFrame {
	private static final JTable j_orderTable = null;
	DbUtil dbUtil = new DbUtil();
	OrderDao orderDao = new OrderDao();
	DishDao dishDao = new DishDao();

	/** Creates new form checkOrderInterFrm */
	public DealOrderInterFrm() {
		initComponents();
		this.setLocation(320, 100);
		fillOrderTable();
	}

	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {
		jScrollPane2 = new javax.swing.JScrollPane();
		totalMoneyTxt = new javax.swing.JTextField();
		jLabel1 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		orderStatusTxt = new javax.swing.JTextField();
		jScrollPane1 = new javax.swing.JScrollPane();
		start = new javax.swing.JButton();

		setClosable(true);
		setIconifiable(true);
		setTitle("\u8BA2\u5355\u5904\u7406");

		totalMoneyTxt.setEditable(false);

		jLabel1.setText("\u603b\u91d1\u989d\uff1a");

		jLabel3.setText("\u8ba2\u5355\u72b6\u6001\uff1a");

		orderStatusTxt.setEditable(false);

		start.setIcon(null); // NOI18N
		start.setText("\u5F00\u59CB");
		start.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});
		
		finish= new JButton();
		finish.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishorder(e);
			}
		});
		finish.setText("\u5B8C\u6210");

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		layout.setHorizontalGroup(
			layout.createParallelGroup(Alignment.TRAILING)
				.addGroup(layout.createSequentialGroup()
					.addContainerGap()
					.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 385, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(layout.createParallelGroup(Alignment.TRAILING)
						.addGroup(layout.createSequentialGroup()
							.addComponent(jLabel3)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(orderStatusTxt, 80, 80, 80)
							.addPreferredGap(ComponentPlacement.RELATED, 233, Short.MAX_VALUE)
							.addComponent(jLabel1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(totalMoneyTxt, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE))
						.addGroup(layout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 510, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
				.addGroup(layout.createSequentialGroup()
					.addContainerGap(484, Short.MAX_VALUE)
					.addComponent(start, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
					.addGap(47)
					.addComponent(finish, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
					.addGap(241))
		);
		layout.setVerticalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
					.addGap(64)
					.addGroup(layout.createParallelGroup(Alignment.LEADING)
						.addGroup(layout.createSequentialGroup()
							.addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE)
							.addGap(28)
							.addGroup(layout.createParallelGroup(Alignment.BASELINE)
								.addComponent(jLabel3)
								.addComponent(totalMoneyTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel1)
								.addComponent(orderStatusTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 199, GroupLayout.PREFERRED_SIZE))
					.addGap(62)
					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
						.addComponent(start, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
						.addComponent(finish, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(135, Short.MAX_VALUE))
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
				false, false, false
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
				"\u8BA2\u5355\u7F16\u53F7", "\u9910\u4F4D\u53F7", "\u8BA2\u5355\u72B6\u6001"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		orderTable.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent evt) {
				orderTableMousePressed(evt);
			}
		});
		orderTable.getColumnModel().getColumn(0).setPreferredWidth(149);
		jScrollPane1.setViewportView(orderTable);

		pack();
	}// </editor-fold>
	//GEN-END:initComponents
	
	//完成订单操作
	protected void finishorder(ActionEvent evt) {
		//获取选中的行
				int row = orderTable.getSelectedRow();
				if (row < 0) {
					JOptionPane.showMessageDialog(null, "请选择一个订单");
					return;
				}
				//获取订单编号
				String orderId = (String) orderTable.getValueAt(row, 0);
				Order order = new Order();
				order.setOrderId(orderId);
				//
				String orderStatus = this.orderStatusTxt.getText();
				if(orderStatus.equals("未处理")) {
					this.finish.setEnabled(false);
				}else {
					this.finish.setEnabled(true);
				}
				if(orderStatus.equals("配餐中")) {
					this.start.setEnabled(false);
				}else {
					this.start.setEnabled(true);
				}
				
				int statusNum = 0;//是否为删除订单或者处理订单的标志位
				

				if (statusNum != 1) {
					try {
						order.setStatus(2);
						Connection con = dbUtil.getConnection();
						int modifyNum = orderDao.orderStatusModify(con, order);
						StringUtil stringUtil = new StringUtil();
						String finishDate = new java.text.SimpleDateFormat("yyyyMMddHHmmss")
								.format(new java.util.Date());
						double dealTime = stringUtil.dealTime(orderId, finishDate);
						orderDao.setFinishTime(con, order, dealTime);
						if (modifyNum == 1) {
							JOptionPane.showMessageDialog(null, "操作成功！");
							fillOrderTable();
							this.orderStatusTxt.setText(orderStatus);
							start.setEnabled(false);
							finish.setEnabled(true);
						} else {
							JOptionPane.showMessageDialog(null, "订单操作失败！");
						}

					} catch (Exception e) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, "订单操作失败！");
						e.printStackTrace();
					}
				} 		
	}

	//点击订单表，显示订单信息
	protected void orderTableMousePressed(MouseEvent evt) {
		//获取选中的行
				int row = orderTable.getSelectedRow();
				String orderId = (String) orderTable.getValueAt(row, 0);
				String orderStatus = (String) orderTable.getValueAt(row, 2);
				this.orderStatusTxt.setText(orderStatus);
				//修改完成按钮状态
				if (!orderStatus.equals("未处理")) {
					finish.setEnabled(true);
				} else {
					finish.setEnabled(false);
				}
				if (!orderStatus.equals("配餐中")) {
					start.setEnabled(true);
				} else {
					start.setEnabled(false);
				}
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

	//填充ordertable
	private void fillOrderTable() {
		Order order = new Order();
		order.setOrderId("");
		DefaultTableModel dtm = (DefaultTableModel) orderTable.getModel();
		dtm.setRowCount(0);
		Connection con = null;
		try {
			con = dbUtil.getConnection();
			ResultSet rs = orderDao.DealOrderList(con, order);
			while (rs.next()) {
				Vector v = new Vector();
				v.add(rs.getString("orderid"));
				v.add(rs.getString("tableid"));
				int status = rs.getInt("status");
				switch (status) {
				case 0:
					v.add("未处理");
					break;
				case 1:
					v.add("配餐中");
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

	//重置carttable
	private void resetCartTable() {

		this.totalMoneyTxt.setText("");
		this.orderStatusTxt.setText("");
		DefaultTableModel dtm = (DefaultTableModel) cartTable.getModel();
		dtm.setRowCount(0);

	}

	//开始配餐操作
	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
		//获取选中的行
		int row = orderTable.getSelectedRow();
		if (row < 0) {
			JOptionPane.showMessageDialog(null, "请选择一个订单");
			return;
		}
		//获取订单编号
		String orderId = (String) orderTable.getValueAt(row, 0);
		Order order = new Order();
		order.setOrderId(orderId);
		//
		String orderStatus = this.orderStatusTxt.getText();
		if(orderStatus.equals("未处理")) {
			this.finish.setEnabled(false);
		}else {
			this.finish.setEnabled(true);
		}
		if(orderStatus.equals("配餐中")) {
			this.start.setEnabled(false);
		}else {
			this.start.setEnabled(true);
		}
		
		int statusNum = 0;//是否为删除订单或者处理订单的标志位
		

		if (statusNum != 1) {
			try {
				order.setStatus(1);
				Connection con = dbUtil.getConnection();
				int modifyNum = orderDao.orderStatusModify(con, order);
				if (modifyNum == 1) {
					JOptionPane.showMessageDialog(null, "操作成功！");
					fillOrderTable();
					this.orderStatusTxt.setText(orderStatus);
					start.setEnabled(false);
					finish.setEnabled(true);
				} else {
					JOptionPane.showMessageDialog(null, "订单操作失败！");
				}

			} catch (Exception e) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, "订单操作失败！");
				e.printStackTrace();
			}
		} 
	}
	private javax.swing.JButton start;
	private javax.swing.JButton finish;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JTextField orderStatusTxt;
	private javax.swing.JTextField totalMoneyTxt;
	private JTable orderTable;
	private JTable cartTable;
}
