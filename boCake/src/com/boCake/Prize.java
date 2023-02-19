package com.boCake;

public class Prize {

	public int ZhuangYuan = 0;
	public int DuiTang = 0;
	public int SanHong = 0;
	public int SiJin = 0;
	public int ErJu = 0;
	public int YiXiu = 0;
	
	public int ZY_id=0;
	public int ZY_level=0;
	
	public Prize() {
		super();
	}
	public Prize(int zhuangYuan, int duiTang, int sanHong, int siJin, int erJu, int yiXiu) {
		super();
		ZhuangYuan = zhuangYuan;
		DuiTang = duiTang;
		SanHong = sanHong;
		SiJin = siJin;
		ErJu = erJu;
		YiXiu = yiXiu;
	}
	
	public int getDuiTang() {
		return DuiTang;
	}
	public void setDuiTang(int duiTang) {
		DuiTang = duiTang;
	}
	public int getSanHong() {
		return SanHong;
	}
	public void setSanHong(int sanHong) {
		SanHong = sanHong;
	}
	public int getSiJin() {
		return SiJin;
	}
	public void setSiJin(int siJin) {
		SiJin = siJin;
	}
	public int getErJu() {
		return ErJu;
	}
	public void setErJu(int erJu) {
		ErJu = erJu;
	}
	public int getYiXiu() {
		return YiXiu;
	}
	public void setYiXiu(int yiXiu) {
		YiXiu = yiXiu;
	}
	public int getZhuangYuan() {
		return ZhuangYuan;
	}
	public void setZhuangYuan(int zhuangYuan) {
		ZhuangYuan = zhuangYuan;
	}
	public int getZY_id() {
		return ZY_id;
	}
	public void setZY_id(int zY_id) {
		ZY_id = zY_id;
	}
	public int getZY_level() {
		return ZY_level;
	}
	public void setZY_level(int zY_level) {
		ZY_level = zY_level;
	}
	
	/**
	 * 打印奖品
	 * @param flag=1为玩家奖品 flag=0为奖池
	 */
	public void PrintPrize(int flag) {
		if(this.ZhuangYuan==0&&this.DuiTang==0&&this.SanHong==0&&this.SiJin==0&&this.ErJu==0&&this.YiXiu==0&&flag==1) 
			System.out.println("  很遗憾没有获得奖品");
		else {
			if(flag==1)System.out.print("  获得奖品：");
			else System.out.print("奖池剩余奖品：");
			if(this.ZhuangYuan!=0) System.out.print("“状元”");
			if(this.ZhuangYuan==2) System.out.print("（五子登科）"); if(this.ZhuangYuan==3) System.out.print("（状元插金花）"); if(this.ZhuangYuan==4) System.out.print("（六杯红）");
			if(this.ZhuangYuan!=0) System.out.print("1个 ");
			if(this.DuiTang!=0) System.out.print("“对堂”" + this.getDuiTang() + "个 ");
			if(this.SanHong!=0) System.out.print("“三红”" + this.getSanHong() + "个 ");
			if(this.SiJin!=0) System.out.print("“四进”" + this.getSiJin() + "个 ");
			if(this.ErJu!=0) System.out.print("“二举”" + this.getErJu() + "个 ");
			if(this.YiXiu!=0) System.out.print("“一秀”" + this.getYiXiu() + "个 ");
			System.out.println();
		}
	}
}
