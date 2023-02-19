package com.boCake;

import java.util.Random;

public class Player {

	private int id;
	public Prize prize;
	private int arr[];
	
	public Player() {
		super();
		// TODO 自动生成的构造函数存根
		this.arr = new int[6];
		for(int i=0;i<6;i++) {
			this.arr[i]=0;
		}
		this.prize=new Prize();
	}
	public Player(int id, Prize prize, int[] arr) {
		super();
		this.id = id;
		this.prize = prize;
		this.arr = arr;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Prize getPrize() {
		return prize;
	}

	public void setPrize(Prize prize) {
		this.prize = prize;
	}

	public int[] getArr() {
		return arr;
	}
	
	/**
	 * 生成随机点数
	 * @param index
	 */
	public int setArr(int index) {
		Random random = new Random();
		this.arr[index]=random.nextInt(6)+1;
		return this.arr[index];
	}
	
	/**
	 * 打印点数
	 */
	public void printArr() {
		for(int i=0;i<6;i++) {
			System.out.print(this.arr[i]);
			if(i!=5) System.out.print(",");
		}
	}
	
}
