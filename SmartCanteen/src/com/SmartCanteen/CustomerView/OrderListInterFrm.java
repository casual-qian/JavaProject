package com.SmartCanteen.CustomerView;

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

public class OrderListInterFrm extends JInternalFrame {
	private static final JTable j_orderTable = null;
	DbUtil dbUtil = new DbUtil();
	OrderDao orderDao = new OrderDao();
	DishDao dishDao = new DishDao();

	/** Creates new form checkOrderInterFrm */
	public OrderListInterFrm() {
		initComponents();
		this.setLocation(320, 100);
		fillOrderTable();
	}

	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {
		jScrollPane1 = new javax.swing.JScrollPane();

		setClosable(true);
		setIconifiable(true);
		setTitle("\u7B49\u5F85\u987A\u5E8F");
		
		JButton resetTable = new JButton("\u5237\u65B0");
		resetTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetTable(e);
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		layout.setHorizontalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
					.addGroup(layout.createParallelGroup(Alignment.LEADING)
						.addGroup(layout.createSequentialGroup()
							.addContainerGap()
							.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 481, GroupLayout.PREFERRED_SIZE))
						.addGroup(layout.createSequentialGroup()
							.addGap(163)
							.addComponent(resetTable, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(117, Short.MAX_VALUE))
		);
		layout.setVerticalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
					.addGap(64)
					.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 199, GroupLayout.PREFERRED_SIZE)
					.addGap(30)
					.addComponent(resetTable, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(67, Short.MAX_VALUE))
		);
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
		orderTable.getColumnModel().getColumn(0).setPreferredWidth(149);
		jScrollPane1.setViewportView(orderTable);

		pack();
	}// </editor-fold>

	

	protected void resetTable(ActionEvent e) {
		this.fillOrderTable();
		
	}

	//ÃÓ≥‰ordertable
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
					v.add("Œ¥¥¶¿Ì");
					break;
				case 1:
					v.add("≈‰≤Õ÷–");
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


	private javax.swing.JScrollPane jScrollPane1;
	private JTable orderTable;
}