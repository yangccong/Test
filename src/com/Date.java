package com;

public class Date {
	private int year;//�Ϸ����Ϊ1812~2017
	private int month;//�Ϸ��·�Ϊ1~12
	private int day;//���������
	private boolean state = true;
	
	public boolean judgeYear(){//�ж�ƽ�껹�����꣬�������򷵻�true�����򷵻�false
		if((year%400==0)||(year%4==0&&year%100!=0)){
			return true;
		}else{
			return false;
		}
	}
	
	public boolean judgeDate(){//��������ֻҪ��һ�����������Ϲ淶���ͻὫstate��ֵΪfalse
		if(year<1812||year>2017){//���ж����
			System.out.println("��ݲ��ںϷ���1812~2017��");
			state = false;
		}
		if(month<1||month>12){//���ж��·�
			System.out.println("�·ݲ��ںϷ���1~12��");
			state = false;
		}else if(month==2){
			if(judgeYear()==true){
				if(day<1||day>29){
					System.out.println("���첻���ڸ��·�");
					state = false;
				}
			}else{
				if(day<1||day>28){
					System.out.println("���첻���ڸ��·�");
					state = false;
				}
			}
		}else if((month==4)||(month==6)||(month==9)||(month==11)){
			if(day<1||day>30){
				System.out.println("���첻���ڸ��·�");
				state = false;
			}
		}else{
			if(day<1||day>31){
				System.out.println("���첻���ڸ��·�");
				state = false;
			}
		}
		return state;
	}
	
	//����˽�г�Ա������get��set����
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
