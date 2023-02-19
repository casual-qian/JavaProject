package com.SmartCanteen.model;

public class Order {

	private int id;
	private String OrderId;
	private int DishId;
	private double DishPrice;
	private int DishNum;
	private String DishName;
	private String DishType;
	//订单状态 0 未处理（可以取消）1 配餐中 2 已完成 3 已取消
	private int Status;
	private int OrderNum;
	private double Total;
	private String UserName;
	private String UserId;
	private String TableId;
	
	public String getTableId() {
		return TableId;
	}
	public void setTableId(String tableId) {
		TableId = tableId;
	}
	public String getDishType() {
		return DishType;
	}
	public void setDishType(String dishType) {
		DishType = dishType;
	}
	public String getUserId() {
		return UserId;
	}
	public void setUserId(String userId) {
		UserId = userId;
	}
	private String Date;
	
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Order(String orderId, int status,  double total, String userName, String date, String userId, String tableId) {
		super();
		OrderId = orderId;
		Status = status;
		Total = total;
		UserName = userName;
		Date = date;
		UserId = userId;
		TableId = tableId;
	}
	public Order(String orderId,  double dishPrice, int dishNum, String dishName, String dishType) {
		super();
		OrderId = orderId;
		DishPrice = dishPrice;
		DishNum = dishNum;
		DishName = dishName;
		DishType = dishType;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOrderId() {
		return OrderId;
	}
	public void setOrderId(String orderId) {
		OrderId = orderId;
	}
	public int getDishId() {
		return DishId;
	}
	public void setDishId(int dishId) {
		DishId = dishId;
	}
	public double getDishPrice() {
		return DishPrice;
	}
	public void setDishPrice(double dishPrice) {
		DishPrice = dishPrice;
	}
	public int getDishNum() {
		return DishNum;
	}
	public void setDishNum(int dishNum) {
		DishNum = dishNum;
	}
	public String getDishName() {
		return DishName;
	}
	public void setDishName(String dishName) {
		DishName = dishName;
	}
	public int getStatus() {
		return Status;
	}
	public void setStatus(int status) {
		Status = status;
	}
	public int getOrderNum() {
		return OrderNum;
	}
	public void setOrderNum(int orderNum) {
		OrderNum = orderNum;
	}
	public double getTotal() {
		return Total;
	}
	public void setTotal(double total) {
		Total = total;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}
}
