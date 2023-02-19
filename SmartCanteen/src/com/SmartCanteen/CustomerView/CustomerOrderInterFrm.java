package com.SmartCanteen.CustomerView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

import com.SmartCanteen.dao.DishDao;
import com.SmartCanteen.dao.OrderDao;
import com.SmartCanteen.dao.UserDao;
import com.SmartCanteen.model.Dish;
import com.SmartCanteen.model.Order;
import com.SmartCanteen.util.DbUtil;
import javax.swing.JComboBox;
import javax.swing.JLabel;

public class CustomerOrderInterFrm extends javax.swing.JInternalFrame {

	DbUtil dbUtil = new DbUtil();
	DishDao dishDao = new DishDao();
	OrderDao orderDao = new OrderDao();
	private JTable dishTable = new JTable();;

	/** Creates new form OrderDishFrm */
	public CustomerOrderInterFrm() {
		initComponents();
		this.setLocation(220, 100);
		this.fillDishTable(new Dish());
		this.fillTableIdBox();
	}

	private void fillDishTable(Dish dish) {
		DefaultTableModel dtm = (DefaultTableModel) dishTable.getModel();
		//���֮ǰ��ʾ
		dtm.setRowCount(0);
		Connection con = null;
		try {
			con = dbUtil.getConnection();
			ResultSet rs = dishDao.dishList(con, dish);
			while (rs.next()) {
				Vector v = new Vector();
				v.add(rs.getString("dishname"));
				v.add(rs.getString("dishtype"));
				v.add(rs.getString("price"));
				v.add(rs.getString("Ingredient"));
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

	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		jScrollPane2 = new javax.swing.JScrollPane();
		jb_add = new javax.swing.JButton();
		jb_ok = new javax.swing.JButton();
		jb_delete = new javax.swing.JButton();
		totalMoneyTxt = new javax.swing.JTextField();
		jLabel1 = new javax.swing.JLabel();
		jScrollPane1 = new javax.swing.JScrollPane();

		setClosable(true);
		setIconifiable(true);
		setTitle("\u70B9\u9910\u754C\u9762");

		jb_add.setIcon(null); // NOI18N
		jb_add.setText("\u52a0\u5165\u8d2d\u7269\u8f66");
		jb_add.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jb_addActionPerformed(evt);
			}
		});

		jb_ok.setIcon(null); // NOI18N
		jb_ok.setText("\u63D0\u4EA4\u8BA2\u5355");
		jb_ok.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jb_okActionPerformed(evt);
			}
		});

		jb_delete.setIcon(null); // NOI18N
		jb_delete.setText("\u5220\u9664");
		jb_delete.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jb_deleteActionPerformed(evt);
			}
		});

		totalMoneyTxt.setEditable(false);

		jLabel1.setText("\u603b\u91d1\u989d\uff1a");
		
		btnNewButton = new JButton("\u5237\u65B0\u603B\u91D1\u989D");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fillCartTable();
			}
		});
		
		tableIdBox = new JComboBox();
		
		JLabel lblNewLabel = new JLabel("\u9009\u62E9\u9910\u4F4D\u53F7\uFF1A");

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		layout.setHorizontalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
					.addGroup(layout.createParallelGroup(Alignment.LEADING)
						.addGroup(layout.createSequentialGroup()
							.addContainerGap()
							.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 432, GroupLayout.PREFERRED_SIZE)
							.addGap(105)
							.addGroup(layout.createParallelGroup(Alignment.LEADING)
								.addGroup(layout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(tableIdBox, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
									.addGap(48)
									.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
										.addComponent(jb_delete, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
									.addGap(31)
									.addGroup(layout.createParallelGroup(Alignment.TRAILING)
										.addGroup(layout.createSequentialGroup()
											.addComponent(jLabel1)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(totalMoneyTxt, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE))
										.addComponent(jb_ok, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)))
								.addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 485, GroupLayout.PREFERRED_SIZE)))
						.addGroup(layout.createSequentialGroup()
							.addGap(126)
							.addComponent(jb_add)))
					.addContainerGap(306, Short.MAX_VALUE))
		);
		layout.setVerticalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
					.addGap(38)
					.addGroup(layout.createParallelGroup(Alignment.TRAILING)
						.addGroup(layout.createSequentialGroup()
							.addGroup(layout.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel1)
								.addComponent(totalMoneyTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel)
								.addComponent(tableIdBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(37))
						.addGroup(layout.createSequentialGroup()
							.addGroup(layout.createParallelGroup(Alignment.BASELINE)
								.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 321, GroupLayout.PREFERRED_SIZE)
								.addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 244, GroupLayout.PREFERRED_SIZE))
							.addGap(45)))
					.addGroup(layout.createParallelGroup(Alignment.TRAILING)
						.addGroup(layout.createParallelGroup(Alignment.BASELINE)
							.addComponent(jb_delete, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
							.addComponent(jb_ok, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
						.addComponent(jb_add))
					.addContainerGap(133, Short.MAX_VALUE))
		);
		
		cartTable = new JTable();
		cartTable.getModel().addTableModelListener(new TableModelListener() {
			public void tableChanged(TableModelEvent e)
			{
				tableChange(e);
            }
		});
		cartTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u83DC\u54C1\u540D\u79F0", "\u83DC\u54C1\u7C7B\u522B", "\u5355\u4EF7", "\u6570\u91CF"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		cartTable.getColumnModel().getColumn(0).setPreferredWidth(94);
		cartTable.getColumnModel().getColumn(1).setPreferredWidth(101);
		cartTable.getColumnModel().getColumn(2).setPreferredWidth(87);
		jScrollPane2.setViewportView(cartTable);
		dishTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u83DC\u54C1\u540D\u79F0", "\u83DC\u54C1\u7C7B\u522B", "\u5355\u4EF7", "\u914D\u6599"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		dishTable.getColumnModel().getColumn(0).setPreferredWidth(100);
		dishTable.getColumnModel().getColumn(1).setPreferredWidth(89);
		dishTable.getColumnModel().getColumn(3).setPreferredWidth(209);
		jScrollPane1.setViewportView(dishTable);
		getContentPane().setLayout(layout);

		pack();
	}// </editor-fold>
	protected void tableChange(TableModelEvent e) {
		fillCartTable();
		
	}

	//GEN-END:initComponents

	private void jb_okActionPerformed(java.awt.event.ActionEvent evt) {
		String userName = LogOnFrm.s_currentUser.getName();
		String userId = LogOnFrm.s_currentUser.getId();
		Double Account = LogOnFrm.s_currentUser.getAccount();
		String tableId = (String)this.tableIdBox.getSelectedItem();
		
		//���ɶ�����
		String orderId = new java.text.SimpleDateFormat("yyyyMMddHHmmss")
				.format(new java.util.Date());//����ǰʱ����Ϊ��������
		double orderTotalMoney = Double.parseDouble(this.totalMoneyTxt.getText());//
		
		int rowNum = cartTable.getRowCount();//��������
		if (rowNum == 0) {
			JOptionPane.showMessageDialog(null, "���������Ʒ�����ύ������");
			return;
		}
		Connection con = null;
		try {
			con = dbUtil.getConnection();
			Order order = new Order(orderId, 0,  orderTotalMoney,
					userName, orderId, userId,tableId);
			if(Account<orderTotalMoney) {
				JOptionPane.showMessageDialog(null, "�˻����㣬���ֵ���ٵ��");
				return;
			}
			int addNum = orderDao.order_infoAdd(con, order);//�������ݵ�order_info��
			if (addNum == 1&&Account>=orderTotalMoney) {
				for (int i = 0; i < rowNum; i++) {
					String dishName = (String) cartTable.getValueAt(i, 0);
					String dishType = (String) cartTable.getValueAt(i, 1);
					int dishNum = Integer.parseInt((String) cartTable
							.getValueAt(i, 3));
					double dishPrice = Float.parseFloat((String) cartTable
							.getValueAt(i, 2));
					order = new Order(orderId, dishPrice,
							 dishNum, dishName, dishType);
					//ѭ���������ݵ�order_dish��
					addNum += orderDao.order_dishAdd(con, order);
				}
			} else {
				JOptionPane.showMessageDialog(null, "�����ύʧ��");
			}
			if (addNum == (1 + rowNum)) {
				UserDao userDao=new UserDao();
				userDao.reduceAccount(con, LogOnFrm.s_currentUser,orderTotalMoney );
				LogOnFrm.s_currentUser.setAccount(Account-orderTotalMoney);
				JOptionPane.showMessageDialog(null, "�����ύ�ɹ������ζ����ţ�"
						+ orderId);
			} else {
				JOptionPane.showMessageDialog(null, "�����ύʧ��");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "�����ύʧ��");
		} finally {
			try {
				dbUtil.closeConnection(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		DefaultTableModel dtm = (DefaultTableModel) cartTable.getModel();
		//ɾ��ѡ�����
		dtm.setRowCount(0);
		fillCartTable();
	}

	private void fillCartTable() {
		//�޸���Ʒ�������ܽ��
		int rowNum = cartTable.getRowCount();//��������
		double totalMoney = 0;//�ܽ��
		int dishNum;
		double dishPrice;
		//�ۼ��ܽ��
		for (int i = 0; i < rowNum; i++) {
			dishNum = Integer.parseInt((String) cartTable.getValueAt(i, 3));
			dishPrice = Float.parseFloat((String) cartTable.getValueAt(i, 2));
			totalMoney += dishNum*dishPrice;
		}
		//�ı���ֵ
		this.totalMoneyTxt.setText(Double.toString(totalMoney));
	}

	private void jb_deleteActionPerformed(java.awt.event.ActionEvent evt) {
		int row = cartTable.getSelectedRow();
		if (row == -1) {
			JOptionPane.showMessageDialog(null, "��ѡ��Ҫɾ�����У�");
		} else {
			DefaultTableModel dtm = (DefaultTableModel) cartTable.getModel();
			//ɾ��ѡ�����
			dtm.removeRow(row);
		}
		fillCartTable();
	}

	private void jb_addActionPerformed(java.awt.event.ActionEvent evt) {
		DefaultTableModel dtm = (DefaultTableModel) cartTable.getModel();
		//��ȡѡ�е���
		int row = dishTable.getSelectedRow();
		if (row < 0) {
			JOptionPane.showMessageDialog(null, "��ѡ��һ�ֲ�Ʒ");
			return;
		}
		//�ڱ��й��ﳵtable����ʾ���������
		int i = 0, flag = 0;//����Ƿ��Ѿ�����
		int rowNum = cartTable.getRowCount();
		for (i = 0; i < rowNum; i++) {
			if (dishTable.getValueAt(row, 0)
					.equals(cartTable.getValueAt(i, 0))) {
				flag = 1;
				break;
			}
		}
		if (flag == 0) {
			Vector v = new Vector();
			v.add((String) dishTable.getValueAt(row, 0));
			v.add((String) dishTable.getValueAt(row, 1));
			v.add((String) dishTable.getValueAt(row, 2));
			v.add("1");
			dtm.addRow(v);
		} else {

			int dishNum = Integer
					.parseInt((String) cartTable.getValueAt(i, 3)) + 1;//��ȡ��ǰ����
			double dishPrice = Double.parseDouble((String) cartTable.getValueAt(
					i, 2));//��ȡ��ǰ����

			dishPrice = dishPrice
					+ Float.parseFloat((String) cartTable.getValueAt(i, 4));//��ȡ�����޸��Ժ���ܼ�
			this.cartTable.setValueAt(Integer.toString(dishNum), i, 3);
			this.cartTable.setValueAt(Double.toString(dishPrice), i, 2);
		}
		fillCartTable();
	}
	
	private void fillTableIdBox() {
		for(int i=1;i<=10;i++) {
			this.tableIdBox.addItem(i+"");
		}
	}
	
	private javax.swing.JLabel jLabel1;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JButton jb_add;
	private javax.swing.JButton jb_delete;
	private javax.swing.JButton jb_ok;
	private javax.swing.JTextField totalMoneyTxt;
	private JTable cartTable;
	private JButton btnNewButton;
	private JComboBox tableIdBox;
}
