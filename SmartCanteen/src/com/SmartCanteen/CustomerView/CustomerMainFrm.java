package com.SmartCanteen.CustomerView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

/**
 *
 * @author  __USER__
 */
public class CustomerMainFrm extends javax.swing.JFrame {

	/** Creates new form UserFrm */
	public CustomerMainFrm() {
		initComponents();
		//设置最大化
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
	}

	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		table = new javax.swing.JDesktopPane();
		jMenuBar1 = new javax.swing.JMenuBar();
		jm_order = new javax.swing.JMenu();
		jmi_order = new javax.swing.JMenuItem();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("\u7528\u6237\u70b9\u9910\u4e3b\u754c\u9762");

		jm_order.setIcon(null); // NOI18N
		jm_order.setText("\u70B9\u9910");

		jmi_order.setIcon(null); // NOI18N
		jmi_order.setText("\u5f00\u59cb\u70b9\u9910");
		jmi_order.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jmi_orderActionPerformed(evt);
			}
		});
		jm_order.add(jmi_order);

		jMenuBar1.add(jm_order);

		setJMenuBar(jMenuBar1);
		
		JMenu mnNewMenu = new JMenu("\u8BA2\u5355\u4FE1\u606F");
		jMenuBar1.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("\u5386\u53F2\u8BA2\u5355");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jmi_checkOrderActionPerformed(e);
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("\u7B49\u5F85\u987A\u5E8F");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				orderList(e);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
		
		mnNewMenu_1 = new JMenu("\u5176\u4ED6");
		jMenuBar1.add(mnNewMenu_1);
		
		mntmNewMenuItem_2 = new JMenuItem("\u4E2A\u4EBA\u4FE1\u606F");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jmi_modifyActionPerformed(e);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_2);
		
		mntmNewMenuItem_3 = new JMenuItem("\u9000\u51FA\u7CFB\u7EDF");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jmiExitActionPerformed(e);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_3);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(table,
				javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(table,
				javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE));

		pack();
	}
	protected void orderList(ActionEvent e) {
		OrderListInterFrm orderListInterFrm = new OrderListInterFrm();
		orderListInterFrm.setVisible(true);	
		this.table.add(orderListInterFrm);
	}

	private void jmi_checkOrderActionPerformed(java.awt.event.ActionEvent evt) {
		CheckOrderInterFrm CheckOrderInterFrm = new CheckOrderInterFrm();
		CheckOrderInterFrm.setVisible(true);
		this.table.add(CheckOrderInterFrm);
	}
	
	private void jmi_modifyActionPerformed(java.awt.event.ActionEvent evt) {
		InfoInterFrm infoInterFrm = new InfoInterFrm();
		infoInterFrm.setVisible(true);
		this.table.add(infoInterFrm);
	}
    
    //退出按钮
	private void jmiExitActionPerformed(java.awt.event.ActionEvent evt) {
		int result = JOptionPane.showConfirmDialog(null, "是否退出系统？");
		//System.out.println(result);
		if (result == 0)
			this.dispose();
	}
    //点餐按钮
	private void jmi_orderActionPerformed(java.awt.event.ActionEvent evt) {
		CustomerOrderInterFrm customerOrderInterFrm = new CustomerOrderInterFrm();
		customerOrderInterFrm.setVisible(true);
		this.table.add(customerOrderInterFrm);
	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new CustomerMainFrm().setVisible(true);
			}
		});
	}
	private javax.swing.JMenuBar jMenuBar1;
	private javax.swing.JMenu jm_order;
	private javax.swing.JMenuItem jmi_order;
	private javax.swing.JDesktopPane table;
	private JMenu mnNewMenu_1;
	private JMenuItem mntmNewMenuItem_2;
	private JMenuItem mntmNewMenuItem_3;
}
