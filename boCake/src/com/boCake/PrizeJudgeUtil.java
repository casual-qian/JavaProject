package com.boCake;

public class PrizeJudgeUtil {

	/**
	 * 判断奖池是否为空
	 * @param prize
	 * @return
	 */
	public boolean prizeIsEmpty(Prize prize){
		if(prize.getZhuangYuan()==0&&prize.getDuiTang()==0&&prize.getSanHong()==0&&prize.getSiJin()==0&&prize.getErJu()==0&&prize.getYiXiu()==0)
			return true;
		else 
			return false;
	}
	
	/**
	 * 判断是否是一秀
	 * @param arr
	 * @return
	 */
	private boolean arrIsYiXiu(int arr[]) {
		for(int i = 0;i<6;i++) {
			if(arr[i]==4)
				return true;
		}
		return false;
	}
	
	/**
	 * 判断是否是二举
	 * @param arr
	 * @return
	 */
	private boolean arrIsErJu(int arr[]) {
		int flag = 0;
		for(int i = 0;i<6;i++) {
			if(arr[i]==4)
				flag++;
		}
		if(flag>=2) return true;
		else return false;
	}
	
	/**
	 * 判断是否是四进
	 * @param arr
	 * @return
	 */
	private boolean arrIsSiJin(int arr[]) {
		int b[] = new int[7];
		for(int i = 0;i<7;i++) {
			b[i]=0;
		}
		for(int i=0;i<6;i++) {
			b[arr[i]]++;
			if(b[arr[i]]==4&&!this.arrIsZhuangYuan(arr))
				return true;
		}
		return false;
	}
	
	/**
	 * 判断是否是三红
	 * @param arr
	 * @return
	 */
	private boolean arrIsSanHong(int arr[]) {
		int flag = 0;
		for(int i = 0;i<6;i++) {
			if(arr[i]==4)
				flag++;
		}
		if(flag>=3) return true;
		else return false;
	}
	
	/**
	 * 判断是否是对堂
	 * @param arr
	 * @return
	 */
	private boolean arrIsDuiTang(int arr[]) {
		int b[] = new int[7];
		for(int i = 0;i<7;i++) {
			b[i]=0;
		}
		for(int i=0;i<6;i++) {
			b[arr[i]]++;
			if(b[arr[i]]>1)
				return false;
		}
		return true;
	}
	
	/**
	 * 判断是否是状元（四个4）
	 * @param arr
	 * @return
	 */
	private boolean arrIsZhuangYuan(int arr[]) {
		int flag = 0;
		for(int i = 0;i<6;i++) {
			if(arr[i]==4)
				flag++;
		}
		if(flag>=4) return true;
		else return false;
	}
	
	/**
	 * 判断是否是五子登科
	 * @param arr
	 * @return
	 */
	private boolean arrIsWuZiDengKe(int arr[]) {
		int b[] = new int[7];
		for(int i = 0;i<6;i++) {
			b[i]=0;
		}
		for(int i=0;i<6;i++) {
			b[arr[i]]++;
			if(b[arr[i]]>=5)
				return true;
		}
		return false;
	}
	
	/**
	 * 判断是否是六杯红
	 * @param arr
	 * @return
	 */
	private boolean arrIsLiuBeiHong(int arr[]) {
		int flag = 0;
		for(int i = 0;i<6;i++) {
			if(arr[i]==4)
				flag++;
		}
		if(flag==6) return true;
		else return false;
	}
	
	/**
	 * 判断是否是状元插金花
	 * @param arr
	 * @return
	 */
	private boolean arrIsChaJinHua(int arr[]) {
		int b[] = new int[7];
		for(int i = 0;i<6;i++) {
			b[i]=0;
		}
		for(int i = 0;i<6;i++) {
			b[arr[i]]++;
		}
		if(b[4]==4&&b[1]==2) return true;
		else return false;
	}
	
	/**
	 * 判断一次点数对应的奖品
	 * @param arr
	 * @return
	 */
	public Prize prizeJudge(int arr[]) {
		Prize prize = new Prize();
		if(this.arrIsYiXiu(arr)) {
			prize.setYiXiu(1);
		}
		if(this.arrIsErJu(arr)) {
			prize.setYiXiu(0);
			prize.setErJu(1);
		}
		if(this.arrIsSiJin(arr)) {
			prize.setSiJin(1);
		}
		if(this.arrIsSanHong(arr)) {
			prize.setErJu(0);
			prize.setSanHong(1);
		}
		if(this.arrIsDuiTang(arr)) {
			prize.setYiXiu(0);
			prize.setDuiTang(1);
		}
		if(this.arrIsZhuangYuan(arr)) {
			prize.setSanHong(0);
			prize.setZhuangYuan(1);
		}
		if(this.arrIsWuZiDengKe(arr)) {
			prize.setSiJin(0);
			prize.setZhuangYuan(2);
		}
		if(this.arrIsChaJinHua(arr)) {
			prize.setZhuangYuan(3);
		}
		if(this.arrIsLiuBeiHong(arr)) {
			prize.setZhuangYuan(4);
		}
		
		return prize;
	}
	
	/**
	 * 测试判别
	 * @param a
	 */
	public void testJudge(int a[]) {
		if(this.arrIsYiXiu(a)) System.out.println("一秀");
		if(this.arrIsErJu(a)) System.out.println("二举");
		if(this.arrIsSiJin(a)) System.out.println("四进");
		if(this.arrIsSanHong(a)) System.out.println("三红");
		if(this.arrIsDuiTang(a)) System.out.println("对堂");
		if(this.arrIsZhuangYuan(a)) System.out.println("状元");
		if(this.arrIsWuZiDengKe(a)) System.out.println("五子登科");
		if(this.arrIsLiuBeiHong(a)) System.out.println("六杯红");
		if(this.arrIsChaJinHua(a)) System.out.println("插金花");
	}
}
