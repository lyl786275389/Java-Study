package com.wx.books;
/**
 * ����Ա����
 */
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import com.wx.test16.Penguin;

public class ServiceTest {
	
	public void ser(){
		Scanner in = new Scanner(System.in);
		System.out.println("�ͻ�����Ա�ܸ���Ϊ������");
		Service ser1 = new Service("��ͯͼ�����Ա");
		Service ser2 = new Service("С˵����Ա");
		Service ser3 = new Service("��ʷ����Ա");
		Service ser4 = new Service("�ƻ÷���Ա");
		Map map = new HashMap();
		map.put("1��С��", ser1);
		map.put("2��С��", ser2);
		map.put("3��С��", ser3);
		map.put("4��С��", ser4);
	
		Set set = map.keySet();
		Iterator ite = set.iterator();
		
		while(ite.hasNext()){
			String name = (String) ite.next();
			Service ser =  (Service) map.get(name);
			System.out.println(name+"\t"+ser.getKind());
		}
		System.out.println("��������Ҫѡ��Ŀͷ���ţ�1~4��");
			int a = in.nextInt();
			switch(a){
			case 1:
				System.out.println("��Ⱥ򣬿ͷ�С���������ϵ");
				break;
			case 2:
				System.out.println("��Ⱥ򣬿ͷ�С������������ϵ");
				break;
			case 3:
				System.out.println("��Ⱥ򣬿ͷ�С�Լ���������ϵ");
				break;
			case 4:
				System.out.println("��Ⱥ򣬿ͷ�С�ż���������ϵ");
				break;
			}
	}

}
