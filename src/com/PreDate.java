package com;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PreDate {
	private static int _year;
	private static int _month;
	private static int _day;
	
	public static void preDay(Date date){
		_year = date.getYear();
		_month = date.getMonth();
		_day = date.getDay();
		if(_day>=2){//不是这个月的第一天，则直接将天数减一即可
			_day -=1; 
		}else if(_day == 1){//是第一天，则前一天为上个月的最后一天
			//1  2  3  4  5  6  7  8  9  10 11 12
			//31 ？     31 30 31 30 31 31 30 31 30 31
			if(_month==5||_month==7||_month==10||_month==12){
				_month -=1;
				_day = 30;
			}else if(_month==3){//3月，前一天为2月最后一天
				_month = 2;
				if(date.judgeYear()){
					_day = 29;
				}else{
					_day = 28;
				}
			}else if(_month==1){//1月，前一天为去年的最后一天
				_year -=1;
				_month = 12;
				_day = 31;
			}else{//即本月为2、4、6、8、9、11月中的某一月
				_month-=1;
				_day = 31;
			}
			
		}//end if(_day==1)
	}
	
	public static void main(String args[]){
		
		Date date = new Date();
		System.out.println("请分行输入年/月/日: ");
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		try{
			date.setYear(sc.nextInt());
			date.setMonth(sc.nextInt());
			date.setDay(sc.nextInt());
		}
		catch(InputMismatchException e){//当输入不是纯整数时，报错
			System.out.println("输入内容不匹配，不是整数！");
			System.exit(0);
		}
		if(date.judgeDate()==false){
			System.exit(0);
		}
		preDay(date);
		System.out.println("The preDay is:" +_year+"/"+_month+"/"+_day);
	}
}
