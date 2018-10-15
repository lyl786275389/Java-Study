package com.wx.books;
/**
 * 管理员功能界面
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Admin {
	public void login(){
		Scanner in = new Scanner(System.in);
		System.out.println("请输入用户名：");
		String name = in.next();
		System.out.println("请输入密码：");
		String psd = in.next();
		try {
			FileReader fr = new FileReader("d:\\Admin.txt");
			BufferedReader br = new BufferedReader(fr);
			String str = br.readLine();
			boolean flag = false;
			while(str!=null){
				String [] ss = str.split("##");
				if(name.equals(ss[0])&&psd.equals(ss[1])){
					System.out.println("登录成功");
					flag = true;
					show();
					break;
				}else{
					str=br.readLine();
				}
			}
			if(!flag){
				System.out.println("登录失败,请重新登录");
				login();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void show() throws IOException{
		Scanner in = new Scanner(System.in);
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
		System.out.println("请选择你的操作：1、查找 2、增加 3、修改 4、删除 0、退出");
		switch(in.nextInt()){
		case 1:
			search();
			break;
		case 2:
			add();
			break;
		case 3:
			revise();
			break;
		case 4:
			delete();
			break;
		case 0:
			System.out.println("退出成功，下次再会!");;
			System.exit(0);
			break;
		}
	}
	public void search() throws IOException{
		Scanner in = new Scanner(System.in);
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
					System.out.println("书名"+"\t"+"单价(元)"+"\t"+"库存(本)");
					System.out.println(ss[0]+"\t"+ss[1]+"\t"+ss[2]);
					System.out.println("请选择你的操作：1、继续查找 2、增加 3、修改 4、删除 0、退出");
					switch(in.nextInt()){
					case 1:
						search();
						break;
					case 2:
						add();
						break;
					case 3:
						revise();
						break;
					case 4:
						delete();
						break;
					case 0:
						System.out.println("退出成功，下次再会!");;
						System.exit(0);
						break;

					}
					flag = true;
					break;
				}else{
					str=br.readLine();
				}
			}
		
		
	}
	public void add() throws IOException{
		Scanner in = new Scanner(System.in);
		while(true){
			System.out.println("请输入书籍名：");
			String name = in.next();
			System.out.println("请输入价格：(元)");
			double price = in.nextDouble();
			System.out.println("请输入数量：(本)");
			int num = in.nextInt();
			FileWriter fw;
			String str = name+"##"+price+"##"+num;
			try {
				fw = new FileWriter("d:\\Books.txt",true);
				BufferedWriter bw = new BufferedWriter(fw);
				bw.write(str);
				bw.newLine();
				bw.flush();
				bw.close();
				fw.close();
				System.out.println("录入成功");
				System.out.println("是否继续录入？y/n");
				String s = in.next();
				if("y".equals(s)){
					add();
				}
				if("n".equals(s)){
					System.out.println("录入完毕,返回主菜单");
					show();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	public void revise() throws IOException{
		Scanner in = new Scanner(System.in);
		System.out.println("请输入需要修改的图书名称：");
		String name = in.next();
		FileReader fr = new FileReader("d:\\Books.txt");
		BufferedReader br = new BufferedReader(fr);
		String str = br.readLine();
		boolean flag = false;
		while(str!=null){
			String [] ss = str.split("##");
			if(name.equals(ss[0])){
				System.out.println("查找成功，进行修改");
				System.out.println(ss[0]+"\t"+ss[1]+"\t"+ss[2]);
				String line = ss[0]+"\t"+ss[1]+"\t"+ss[2];
	            StringBuffer sbf=new StringBuffer();
	            sbf.append(line);
	            System.out.println("修改后的名字：(如不变输入1)");     
	            String newname = in.next();
	            if("1".equals(newname)){
	            	newname = ss[0];
	            }
	            String newString=sbf.toString().replace(ss[0], newname);
	            System.out.println("修改后的价格：(如不变输入1)");
	            String newprice = in.next();
	            if("1".equals(newprice)){
	            	newprice = ss[1];
	            }
	            newString=newString.replace(ss[1], newprice);
	            System.out.println("修改后的数量：(如不变输入1)");
	            String newnum = in.next();
	            if("1".equals(newnum)){
	            	newnum = ss[2];
	            }
	            newString=newString.replace(ss[2], newnum);
	            System.out.println("替换后："+newString);
	            //fr.write(newString);
	            System.out.println("是否继续修改(y/n)");
	            String c = in.next();
				if("y".equals(c)){
					revise();
				}
				if("n".equals(c)){
					System.out.println("录入完毕,返回主菜单");
					show();
				}
				flag = true;
				break;
			}else{
				str=br.readLine();
			}
		}
		if(flag == false){
			System.out.println("查无此书,请重新修改！");
			search();
		}
	}
	public void delete() throws IOException{
		Scanner in = new Scanner(System.in);
		System.out.println("请输入需要删除的图书名：");
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
				System.out.println("是否删除？(y/n)");
				if("y".equals(in.next())){
					FileReader fr1 = new FileReader("d:\\Books.txt");
					BufferedReader br1 = new BufferedReader(fr1);
					Scanner scan = new Scanner(new File("d:\\Books.txt"));
					Map map = new HashMap();
					String str1 = br1.readLine();//读取一行
					while(str1!=null){
						String t [] = str1.split("##");
						 map.put(t[0],t[1]+"##"+t[2]);
						str1 = br1.readLine();
				    }
					br1.close();
					fr1.close();
				 map.remove(name);
				 String reg = "[\r\n\f\t\\x20]+";
				 String str11="";
				 str11.replaceAll(reg,"");
				 try {
				 String line = System.getProperty("line.separator");
				 StringBuffer str111 = new StringBuffer();
				 FileWriter fw = new FileWriter("d:\\Books.txt");
				 Set set = map.entrySet();
				 Iterator iter = set.iterator();
				 while(iter.hasNext()){
				 Map.Entry entry = (Map.Entry)iter.next();
				 str111.append(entry.getKey()+"##"+entry.getValue()).append(line);
				
				 }
				 fw.write(str111.toString());
				 fw.close();
				 } catch (IOException e) {
				 e.printStackTrace();
				 }
					System.out.println("删除成功");
				}
				 System.out.println("是否继续删除(y/n)");
		            String c = in.next();
					if("y".equals(c)){
						delete();
					}
					if("n".equals(c)){
						System.out.println("返回主菜单");
						show();
					}
				flag = true;
				break;
			}else{
				str=br.readLine();
			}
		}
		if(flag == false){
			System.out.println("查无此书,请重新删除！");
			delete();
		}
	}
	
}
