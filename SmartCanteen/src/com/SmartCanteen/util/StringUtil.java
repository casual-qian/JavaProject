package com.SmartCanteen.util;

public class StringUtil {
	public static boolean isEmpty(String str){
		if("".equals(str)||str==null){
			return true;
		}else{
			return false;
		}
	}
	public static boolean isNotEmpty(String str){
		if(!"".equals(str)&&str!=null){
			return true;
		}else{
			return false;
		}
	}
	
	 //浮点型判断
    public static boolean isNum(String str){	
    	return str.matches("^[-+]?(([0-9]+)([.]([0-9]+))?|([.]([0-9]+))?)$");	
    	}
    
    /**
	 * 为userId添加前导0
	 * @param bookId
	 * @return
	 */
	public static String fillUserId(int Id) {
		Id++;
		String userId = Id+"";
		while(userId.length() != 5) {
			userId = "0" + userId;
		}
		return userId;
	}
	
	//配餐时间计算
	public static int dealTime(String start, String finish) {
		int s_day = Integer.parseInt(start.substring(6,8));
		int s_hour = Integer.parseInt(start.substring(8,10));
		int s_minute = Integer.parseInt(start.substring(10,12));
		int f_day = Integer.parseInt(finish.substring(6,8));
		int f_hour = Integer.parseInt(finish.substring(8,10));
		int f_minute = Integer.parseInt(finish.substring(10,12));
		
		int time=f_minute-s_minute;
		int hour=f_hour-s_hour;
		if(s_day!=s_day) {
			hour+=24;
		}
		time=time+hour*60;
		return time;
	}
	
	/*用餐时间所属时间段判断
	 * 1	6点~10点
	 * 2	10点~15点
	 * 3	15点~19点
	 * 4	19点~1点
	 * 5	1点~6点
	 */
	public static int timeJudge(String orderId) {
		int time = Integer.parseInt(orderId.substring(8,10));
		int flag = 0;
		if(6<time&&time<=10) flag = 1;
		if(10<time&&time<=15) flag = 2;
		if(15<time&&time<=19) flag = 3;
		if(19<time&&time<=24) flag = 4;
		if(0<time&&time<=6) flag = 5;
		
		return flag;
	}
}
