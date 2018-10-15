package com.wx.books;
/**
 * 服务员界面
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
		System.out.println("客户服务员很高兴为您服务！");
		Service ser1 = new Service("儿童图书服务员");
		Service ser2 = new Service("小说服务员");
		Service ser3 = new Service("历史服务员");
		Service ser4 = new Service("科幻服务员");
		Map map = new HashMap();
		map.put("1、小李", ser1);
		map.put("2、小王", ser2);
		map.put("3、小赵", ser3);
		map.put("4、小张", ser4);
	
		Set set = map.keySet();
		Iterator ite = set.iterator();
		
		while(ite.hasNext()){
			String name = (String) ite.next();
			Service ser =  (Service) map.get(name);
			System.out.println(name+"\t"+ser.getKind());
		}
		System.out.println("请输入您要选择的客服编号（1~4）");
			int a = in.nextInt();
			switch(a){
			case 1:
				System.out.println("请等候，客服小李即将与您联系");
				break;
			case 2:
				System.out.println("请等候，客服小王即将与您联系");
				break;
			case 3:
				System.out.println("请等候，客服小赵即将与您联系");
				break;
			case 4:
				System.out.println("请等候，客服小张即将与您联系");
				break;
			}
	}

}
