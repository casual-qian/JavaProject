package com.boCake;

import java.util.Scanner;

public class BoCake {

	private Player player[];
	private Prize prize;
	private GameUtil gameUtil = new GameUtil();
	private PrizeJudgeUtil prizeJudgeUtil = new PrizeJudgeUtil();
	private Prize originalPrize;
	
	public Prize getPrize() {
		return prize;
	}

	public void setPrize(Prize prize) {
		this.prize = prize;
	}

	public Player[] getPlayer() {
		return player;
	}

	public void setPlayer(Player[] player) {
		this.player = player;
	}

	/*
	 * 主函数
	 */
	public static void main(String[] args) {
		BoCake boCake = new BoCake();
		boCake.initGame();
		boCake.playGame();
		boCake.gameOver();
		
	}
	
	/**
	 * 初始化游戏
	 */
	private  void initGame() {
		this.player= this.gameUtil.initPlayer();
		this.originalPrize= this.gameUtil.initPrize();
		this.prize = this.originalPrize;
	}
	
	/**
	 *开始游戏
	 * @param player
	 * @param prize
	 */
	public void playGame() {
		int i=1;//i为轮次
		int flag=0;//后的六杯红的玩家的id
		Scanner input = new Scanner(System.in);
		for(i=1;!prizeJudgeUtil.prizeIsEmpty(this.getPrize())&&flag==0;i++) {
			System.out.println("第" + i + "轮开始");
			//进行一轮的投掷骰子
			for(int j=1;j<=6;j++) {
				for(int k=0;k<this.gameUtil.getN();k++) {
					System.out.println(this.player[k].getId() + "号玩家第" + j + "次掷得筛子：" + this.player[k].setArr(j-1));
				}
				System.out.println();
			}
			//一轮结束，打印奖品
			for(int k=0;k<this.gameUtil.getN();k++) {
				System.out.print(this.player[k].getId() + "号玩家第" + i + "轮掷得点数：");
				this.player[k].printArr();
				//判断奖品
				Prize t_pirce = this.prizeJudgeUtil.prizeJudge(this.player[k].getArr());
				Prize r_prize[] = this.gameUtil.prizeResult(prize, t_pirce, player[k].prize);
				this.setPrize(r_prize[0]);
				this.player[k].setPrize(r_prize[1]);
				Prize b_prize = r_prize[2];
				
				//六杯红特殊情况
				if(this.prize.getZY_level()==4) {
					flag=this.player[k].getId();
					break;
				}
				
				//打印奖品
				b_prize.PrintPrize(1);
				
				//有状元或状元被抢
				if(b_prize.ZhuangYuan>0) {
					if(this.prize.getZY_id()!=0) {
						this.player[this.prize.getZY_id()-1].prize.ZhuangYuan--;
						if(this.player[k].getId()!=this.prize.getZY_id()) {
							System.out.println(this.prize.getZY_id() + "号玩家的“状元”奖品被" + this.player[k].getId() + "号玩家抢走");
							prize.setZY_id(this.player[k].getId());
						}
					}else {
						this.prize.setZY_id(this.player[k].getId());
					}
				}
			}
			//六杯红情况处理
			if(flag>0) {
				System.out.println("恭喜" + flag + "号玩家获得“六杯红”，获得奖池所有奖品！");
				this.player=this.gameUtil.LiuBeiHong(this.player, flag, this.gameUtil.getN(), originalPrize);
				this.prize=new Prize();
				break;
			}
			this.prize.PrintPrize(0);
			System.out.print("按回车键开始下一轮");
			System.out.println("----------------------------------");
			input.nextLine();
		}
	}
	/**
	 * 游戏结束，打印奖品
	 */
	public void gameOver() {
		System.out.println("游戏结束");
		this.gameUtil.displayPrize(this.player, this.gameUtil.getN());
	}
}