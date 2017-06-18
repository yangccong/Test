package com;

public class Date {
	private int year;//合法年份为1812~2017
	private int month;//合法月份为1~12
	private int day;//与年月相关
	private boolean state = true;
	
	public boolean judgeYear(){//判断平年还是闰年，是闰年则返回true，否则返回false
		if((year%400==0)||(year%4==0&&year%100!=0)){
			return true;
		}else{
			return false;
		}
	}
	
	public boolean judgeDate(){//年月日中只要有一个变量不符合规范，就会将state赋值为false
		if(year<1812||year>2017){//先判断年份
			System.out.println("年份不在合法域1812~2017内");
			state = false;
		}
		if(month<1||month>12){//再判断月份
			System.out.println("月份不在合法域1~12内");
			state = false;
		}else if(month==2){
			if(judgeYear()==true){
				if(day<1||day>29){
					System.out.println("该天不属于该月份");
					state = false;
				}
			}else{
				if(day<1||day>28){
					System.out.println("该天不属于该月份");
					state = false;
				}
			}
		}else if((month==4)||(month==6)||(month==9)||(month==11)){
			if(day<1||day>30){
				System.out.println("该天不属于该月份");
				state = false;
			}
		}else{
			if(day<1||day>31){
				System.out.println("该天不属于该月份");
				state = false;
			}
		}
		return state;
	}
	
	//各个私有成员变量的get及set方法
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	
}
