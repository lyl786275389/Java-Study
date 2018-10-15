package com.wx.books;
/**
 * 购书界面
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Shopping {
	String name;
	int num; 
	double money;
	double sum = 0.0;
	public void show() throws IOException{
		FileReader fr = new FileReader("d:\\Books.txt");
		BufferedReader br = new BufferedReader(fr);
		Scanner scan = new Scanner(new File("d:\\Books.txt"));
		String str = br.readLine();//读取一行
		System.out.println("书名"+"\t"+"单价(元)"+"\t"+"库存(本)");
		while(str!=null){
			String t [] = str.split("##");
			System.out.println(t[0]+"\t"+t[1]+"\t"+t[2]);
			str = br.readLine();
	    }
		br.close();
		fr.close();
		search();
	}
	public void search() throws IOException{
		Scanner in = new Scanner(System.in);
		System.out.println("是否需要查询？(y/n)(如需人工服务请输入0)");
		String a = in.next();
		if("y".equals(a)){
			System.out.println("请输入需要查询的书籍名称：");
			String name = in.next();
			FileReader fr = new FileReader("d:\\Books.txt");
			BufferedReader br = new BufferedReader(fr);
			String str = br.readLine();
			boolean flag = false;
			while(str!=null){
				String [] ss = str.split("##");
				if(name.equals(ss[0])){
					System.out.println("查找成功");
					System.out.println(ss[0]+"\t"+ss[1]+"\t"+ss[2]);
					flag = true;
					System.out.println("是否需要购买书籍？(y/n)");
					if("y".equals(in.next())){
						shop();
					}
					break;
				}else{
					str=br.readLine();
				}
			
			}
			if(flag == false){
				System.out.println("查无此书,请重新查询！");
				search();
			}
		}else if("n".equals(a)){
			System.out.println("是否需要购买书籍？(y/n)");
			String b = in.next();
			if("y".equals(b)){
				shop();
			}else if("n".equals(b)){
				System.out.println("请选择你的操作：1、返回主菜单 2、退出");
				switch(in.nextInt()){
				case 1 :
					show();
					break;
				case 2 :
					System.out.println("欢迎下次光临");
					System.exit(0);
				}
			}
		}else if("0".equals(a)){
			new ServiceTest().ser();
		}
	}
	public void shop() throws IOException{
		Scanner in = new Scanner(System.in);
		
			System.out.println("请输入需要购买的书籍名称：");
			String name = in.next();
			FileReader fr = new FileReader("d:\\Books.txt");
			BufferedReader br = new BufferedReader(fr);
			String str = br.readLine();
			boolean flag = false;
			while(str!=null){
				String [] ss = str.split("##");
				if(name.equals(ss[0])){
					System.out.println("非常高兴有您需要的图书");
					System.out.println("书籍名称："+ss[0]+"单价"+ss[1]+"(元)"+"库存"+ss[2]+"(本)");
					System.out.println("是否购买？(y/n)");
					if("y".equals(in.next())){
						System.out.println("请输入购买数量");
						int b = Integer.parseInt(ss[2]);
						num = in.nextInt();
						double a1 = Double.parseDouble(ss[1]);
						money = a1*num;
						sum = sum + money;
						System.out.println(ss[0]+"共花费"+money);
						System.out.println("是否继续购买？(y/n)");
						String a = in.next();
						if("y".equals(a)){
							shop();
						}else if("n".equals(a)){
							System.out.println("您一共花费"+sum+"元");
							System.out.println("请选择你的操作：1、返回主菜单 2、退出");
							switch(in.nextInt()){
							case 1 :
								show();
								break;
							case 2 :
								System.exit(0);
							}
						}
						
					}
					flag = true;
					break;
				}else{
					str=br.readLine();
				}
				
			}
			if(flag == false){
				System.out.println("查无此书,请重新购买！");
				shop();
			}
		
	}
	
}
