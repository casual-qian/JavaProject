package com.SmartCanteen.model;

public class Dish {

	private String DishName;
	private String DishType;
	private double Price;
	private int Count;
	private String Ingredient;
	
	public Dish() {
		super();
		// TODO 自动生成的构造函数存根
	}

	public Dish(String dishName, String dishType, double price, int count, String ingredient) {
		super();
		DishName = dishName;
		DishType = dishType;
		Price = price;
		Count = count;
		Ingredient = ingredient;
	}

	public String getDishName() {
		return DishName;
	}

	public void setDishName(String dishName) {
		DishName = dishName;
	}

	public String getDishType() {
		return DishType;
	}

	public void setDishType(String dishType) {
		DishType = dishType;
	}

	public double getPrice() {
		return Price;
	}

	public void setPrice(double price) {
		Price = price;
	}

	public int getCount() {
		return Count;
	}

	public void setCount(int count) {
		Count = count;
	}

	public String getIngredient() {
		return Ingredient;
	}

	public void setIngredient(String ingredient) {
		Ingredient = ingredient;
	}

	
}
