package com.boCake;

import java.util.Scanner;

public class GameUtil {
	
	private PrizeJudgeUtil prizeJudgeUtil = new PrizeJudgeUtil();
	private int n;

	public int getN() {
		return n;
	}

	/**
	 * 初始化玩家数量
	 * @return
	 */
	public Player[] initPlayer() {
		System.out.print("请输入玩家数量：");
		Scanner input = new Scanner(System.in);
		int t = input.nextInt();
		Player[] player = new Player[t];
		for(int i=0;i<t;i++) {
			player[i]=new Player();
			player[i].setId(i+1);
		}
		this.n=t;
		
		return player;
	}
	
	/**
	 * 初始化奖池
	 * @return
	 */
	public Prize initPrize() {
		Prize prize;
		int zhuangYuan,duiTang,sanHong,siJin,erJu,yiXiu;
		Scanner input = new Scanner(System.in);
		System.out.println("设置的“状元”奖品数量：1");
		zhuangYuan = 1;
		System.out.print("请输入“对堂”奖品数量：");
		duiTang = input.nextInt();
		System.out.print("请输入“三红”奖品数量：");
		sanHong = input.nextInt();
		System.out.print("请输入“四进”奖品数量：");
		siJin = input.nextInt();
		System.out.print("请输入“二举”奖品数量：");
		erJu = input.nextInt();
		System.out.print("请输入“一秀”奖品数量：");
		yiXiu = input.nextInt();
		
		prize = new Prize(zhuangYuan,duiTang,sanHong,siJin,erJu,yiXiu);
		return prize;
	}
	
	/**
	 * 相应点数处理奖池和玩家奖品
	 * @param prize
	 * @param t_prize
	 * @param p_prize
	 * @return
	 */
	public Prize[] prizeResult(Prize prize,Prize t_prize,Prize p_prize) {
		Prize[] r_prize= new Prize[3];
		r_prize[2]=new Prize();
		if(prize.getYiXiu()>0&&t_prize.getYiXiu()>0) {
			prize.YiXiu--;
			p_prize.YiXiu++;
			r_prize[2].setYiXiu(1);
		}
		if(prize.getErJu()>0&&t_prize.getErJu()>0) {
			prize.ErJu--;
			p_prize.ErJu++;
			r_prize[2].setYiXiu(0);
			r_prize[2].setErJu(1);
		}
		if(prize.getSiJin()>0&&t_prize.getSiJin()>0) {
			prize.SiJin--;
			p_prize.SiJin++;
			r_prize[2].setSiJin(1);
		}
		if(prize.getSanHong()>0&&t_prize.getSanHong()>0) {
			prize.SanHong--;
			p_prize.SanHong++;
			r_prize[2].setErJu(0);
			r_prize[2].setSanHong(1);
		}
		if(prize.getDuiTang()>0&&t_prize.getDuiTang()>0) {
			prize.DuiTang--;
			p_prize.DuiTang++;
			r_prize[2].setYiXiu(0);
			r_prize[2].setDuiTang(1);
		}
		if(t_prize.getZhuangYuan()>prize.getZY_level()) {
			if(prize.getZhuangYuan()>0) prize.setZhuangYuan(0);
			p_prize.ZhuangYuan++;
			prize.setZY_level(t_prize.getZhuangYuan());
			r_prize[2].setZhuangYuan(t_prize.getZhuangYuan());
			r_prize[2].setZY_level(t_prize.getZhuangYuan());
		}
		
		r_prize[0]=prize;
		r_prize[1]=p_prize;
		return r_prize;
	}
	
	/**
	 * 六杯红特殊情况处理
	 * @param player
	 * @param id
	 * @param prize
	 * @return
	 */
	public Player[] LiuBeiHong(Player player[],int id,int n,Prize prize) {
		Prize t_prize = new Prize();
		for(int i=0;i<n;i++) {
			if(i!=id-1) {
				player[i].setPrize(t_prize);
			}
			else {
				player[i].setPrize(prize);
			}
		}
	
		return player;
	}
	
	/**
	 * 打印最终所有玩家获得的奖品
	 * @param player
	 */
	public void displayPrize(Player player[],int n) {
		for(int i=0;i<n;i++) {
			System.out.print(player[i].getId() + "号玩家");
			player[i].prize.PrintPrize(1);
		}
	}
}
