package com.wx.books;
/**
 * ��¼����
 */
import java.util.Scanner;

public class login {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("************************************");
		System.out.println("��ӭ�������㿴ͼ�����ϵͳ");
		System.out.println("��ѡ���½��ʽ(1.����Ա  2.�˿�)");
		System.out.println("************************************");
		int choice = in.nextInt();
		if(choice==1){
			new Admin().login();
		}else if(choice==2){
			new User();
			System.out.println("�Ƿ������˺ţ�1.�У�ֱ�ӵ�½  2.û��,����ע��");
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
