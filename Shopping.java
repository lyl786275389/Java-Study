package com.wx.books;
/**
 * �������
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
		String str = br.readLine();//��ȡһ��
		System.out.println("����"+"\t"+"����(Ԫ)"+"\t"+"���(��)");
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
		System.out.println("�Ƿ���Ҫ��ѯ��(y/n)(�����˹�����������0)");
		String a = in.next();
		if("y".equals(a)){
			System.out.println("��������Ҫ��ѯ���鼮���ƣ�");
			String name = in.next();
			FileReader fr = new FileReader("d:\\Books.txt");
			BufferedReader br = new BufferedReader(fr);
			String str = br.readLine();
			boolean flag = false;
			while(str!=null){
				String [] ss = str.split("##");
				if(name.equals(ss[0])){
					System.out.println("���ҳɹ�");
					System.out.println(ss[0]+"\t"+ss[1]+"\t"+ss[2]);
					flag = true;
					System.out.println("�Ƿ���Ҫ�����鼮��(y/n)");
					if("y".equals(in.next())){
						shop();
					}
					break;
				}else{
					str=br.readLine();
				}
			
			}
			if(flag == false){
				System.out.println("���޴���,�����²�ѯ��");
				search();
			}
		}else if("n".equals(a)){
			System.out.println("�Ƿ���Ҫ�����鼮��(y/n)");
			String b = in.next();
			if("y".equals(b)){
				shop();
			}else if("n".equals(b)){
				System.out.println("��ѡ����Ĳ�����1���������˵� 2���˳�");
				switch(in.nextInt()){
				case 1 :
					show();
					break;
				case 2 :
					System.out.println("��ӭ�´ι���");
					System.exit(0);
				}
			}
		}else if("0".equals(a)){
			new ServiceTest().ser();
		}
	}
	public void shop() throws IOException{
		Scanner in = new Scanner(System.in);
		
			System.out.println("��������Ҫ������鼮���ƣ�");
			String name = in.next();
			FileReader fr = new FileReader("d:\\Books.txt");
			BufferedReader br = new BufferedReader(fr);
			String str = br.readLine();
			boolean flag = false;
			while(str!=null){
				String [] ss = str.split("##");
				if(name.equals(ss[0])){
					System.out.println("�ǳ�����������Ҫ��ͼ��");
					System.out.println("�鼮���ƣ�"+ss[0]+"����"+ss[1]+"(Ԫ)"+"���"+ss[2]+"(��)");
					System.out.println("�Ƿ���(y/n)");
					if("y".equals(in.next())){
						System.out.println("�����빺������");
						int b = Integer.parseInt(ss[2]);
						num = in.nextInt();
						double a1 = Double.parseDouble(ss[1]);
						money = a1*num;
						sum = sum + money;
						System.out.println(ss[0]+"������"+money);
						System.out.println("�Ƿ��������(y/n)");
						String a = in.next();
						if("y".equals(a)){
							shop();
						}else if("n".equals(a)){
							System.out.println("��һ������"+sum+"Ԫ");
							System.out.println("��ѡ����Ĳ�����1���������˵� 2���˳�");
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
				System.out.println("���޴���,�����¹���");
				shop();
			}
		
	}
	
}
