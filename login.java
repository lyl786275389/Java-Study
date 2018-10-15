package com.wx.books;
/**
 * 登录界面
 */
import java.util.Scanner;

public class login {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("************************************");
		System.out.println("欢迎来到任你看图书管理系统");
		System.out.println("请选择登陆方式(1.管理员  2.顾客)");
		System.out.println("************************************");
		int choice = in.nextInt();
		if(choice==1){
			new Admin().login();
		}else if(choice==2){
			new User();
			System.out.println("是否已有账号？1.有，直接登陆  2.没有,进行注册");
			int a = in.nextInt();
			switch(a){
			case 1:
				new User().login();
				break;
			case 2:
				new User().register();
				break;
			}
					
		}
	}

}
