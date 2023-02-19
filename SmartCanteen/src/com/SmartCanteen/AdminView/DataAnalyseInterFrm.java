package com.SmartCanteen.AdminView;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.SmartCanteen.dao.DishDao;
import com.SmartCanteen.dao.OrderDao;
import com.SmartCanteen.model.Dish;
import com.SmartCanteen.model.Order;
import com.SmartCanteen.util.DbUtil;
import com.SmartCanteen.util.StringUtil;

public class DataAnalyseInterFrm extends JInternalFrame {

	DbUtil dbUtil = new DbUtil();
	DishDao dishDao = new DishDao();
	OrderDao orderDao = new OrderDao();
	private JTable dishTable = new JTable();;

	/** Creates new form OrderDishFrm */
	public DataAnalyseInterFrm() {
		incomeTxt.setEnabled(false);
		incomeTxt.setColumns(10);
		avgTimeTxt.setEnabled(false);
		avgTimeTxt.setColumns(10);
		initComponents();
		this.setLocation(220, 100);
		this.fillDishTable(new Dish());
		this.fillData();
	}

	private void fillDishTable(Dish dish) {
		DefaultTableModel dtm = (DefaultTableModel) dishTable.getModel();
		//清空之前显示
		dtm.setRowCount(0);
		Connection con = null;
		try {
			con = dbUtil.getConnection();
			ResultSet rs = orderDao.dishTimes(con, null);
			while (rs.next()) {
				Vector v = new Vector();
				v.add(rs.getString("dishname"));
				v.add(rs.getString("dishtype"));
				v.add(rs.getString("dishprice"));
				v.add(rs.getString("sum(dishnum)"));
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
	
	//填写各项数据
	private void fillData() {
		int t1=0,t2=0,t3=0,t4=0,t5=0;
		Order order = new Order();
		order.setOrderId("");
		order.setUserName("");
		Connection con = null;
		try {
			con = dbUtil.getConnection();
			ResultSet rs = orderDao.orderList(con, order);
			while (rs.next()) {
				String str = rs.getString("orderid");
				int t = stringUtil.timeJudge(str);
				switch(t) {
				case 1:
					t1++;
					break;
				case 2:
					t2++;
					break;
				case 3:
					t3++;
					break;
				case 4:
					t4++;
					break;
				case 5:
					t5++;
					break;
				}
			}
			this.time_1.setText(t1+"");
			this.time_2.setText(t2+"");
			this.time_3.setText(t3+"");
			this.time_4.setText(t4+"");
			this.time_5.setText(t5+"");
			
			rs = orderDao.avgTime(con, order);
			int sum=0,count=0;
			while (rs.next()) {
				sum = rs.getInt("sum(finishtime)");
				count = rs.getInt("count(*)");
			}
			double avg = 1.0*sum/count;
			String str = String.format("%.2f", avg);
			this.avgTimeTxt.setText(str+"分钟");
			
			rs = orderDao.income(con, order);
			double income=0;
			while (rs.next()) {
				income = rs.getDouble("sum(total)");
			}
			this.incomeTxt.setText(income+"元");
			
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {
		jScrollPane1 = new javax.swing.JScrollPane();

		setClosable(true);
		setIconifiable(true);
		setTitle("\u67E5\u8BE2\u5206\u6790");
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u5404\u65F6\u95F4\u6BB5\u7528\u9910\u4EBA\u6570\u7EDF\u8BA1", TitledBorder.LEADING, TitledBorder.TOP, null, null));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		layout.setHorizontalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
					.addContainerGap()
					.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 551, GroupLayout.PREFERRED_SIZE)
					.addGroup(layout.createParallelGroup(Alignment.LEADING)
						.addGroup(layout.createSequentialGroup()
							.addGap(92)
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 401, GroupLayout.PREFERRED_SIZE))
						.addGroup(layout.createSequentialGroup()
							.addGap(100)
							.addGroup(layout.createParallelGroup(Alignment.LEADING)
								.addGroup(layout.createSequentialGroup()
									.addGap(40)
									.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(incomeTxt, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE))
								.addGroup(layout.createSequentialGroup()
									.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(avgTimeTxt, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)))))
					.addContainerGap(69, Short.MAX_VALUE))
		);
		layout.setVerticalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
					.addGap(38)
					.addGroup(layout.createParallelGroup(Alignment.LEADING)
						.addGroup(layout.createSequentialGroup()
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE)
							.addGap(75)
							.addGroup(layout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel)
								.addComponent(avgTimeTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(56)
							.addGroup(layout.createParallelGroup(Alignment.BASELINE)
								.addComponent(incomeTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_1)))
						.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 464, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(82, Short.MAX_VALUE))
		);
		
		time_1 = new JTextField();
		time_1.setEnabled(false);
		time_1.setColumns(10);
		
		time_2 = new JTextField();
		time_2.setEnabled(false);
		time_2.setColumns(10);
		
		time_3 = new JTextField();
		time_3.setEnabled(false);
		time_3.setColumns(10);
		
		time_4 = new JTextField();
		time_4.setEnabled(false);
		time_4.setColumns(10);
		
		time_5 = new JTextField();
		time_5.setEnabled(false);
		time_5.setColumns(10);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(26)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(time_3, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(label, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(time_1, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(time_4, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
								.addComponent(time_2, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(time_5, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(25)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(time_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(label, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
							.addComponent(time_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(29)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(time_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(time_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(27)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(time_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(58, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		dishTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u83DC\u54C1\u540D\u79F0", "\u83DC\u54C1\u7C7B\u522B", "\u5355\u4EF7", "\u5DF2\u70B9\u6B21\u6570"
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
		jScrollPane1.setViewportView(dishTable);
		getContentPane().setLayout(layout);

		pack();
	}// </editor-fold>

	private javax.swing.JScrollPane jScrollPane1;
	private final JLabel label = new JLabel("6\u65F6~10\u65F6");
	private final JLabel label_1 = new JLabel("10\u65F6~15\u65F6");
	private final JLabel label_2 = new JLabel("15\u65F6~19\u65F6");
	private final JLabel label_3 = new JLabel("19\u65F6~1\u65F6");
	private final JLabel label_4 = new JLabel("1\u65F6~6\u65F6");
	private JTextField time_1;
	private JTextField time_2;
	private JTextField time_3;
	private JTextField time_4;
	private JTextField time_5;
	private StringUtil stringUtil =new StringUtil();
	private final JLabel lblNewLabel = new JLabel("\u5E73\u5747\u70B9\u9910\u914D\u9910\u65F6\u95F4:");
	private final JTextField avgTimeTxt = new JTextField();
	private final JLabel lblNewLabel_1 = new JLabel("\u7D2F\u8BA1\u6536\u5165\uFF1A");
	private final JTextField incomeTxt = new JTextField();
}
