package com.wx.books;
/**
 * ����Ա���ܽ���
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
		System.out.println("�������û�����");
		String name = in.next();
		System.out.println("���������룺");
		String psd = in.next();
		try {
			FileReader fr = new FileReader("d:\\Admin.txt");
			BufferedReader br = new BufferedReader(fr);
			String str = br.readLine();
			boolean flag = false;
			while(str!=null){
				String [] ss = str.split("##");
				if(name.equals(ss[0])&&psd.equals(ss[1])){
					System.out.println("��¼�ɹ�");
					flag = true;
					show();
					break;
				}else{
					str=br.readLine();
				}
			}
			if(!flag){
				System.out.println("��¼ʧ��,�����µ�¼");
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
		String str = br.readLine();//��ȡһ��
		System.out.println("����"+"\t"+"����(Ԫ)"+"\t"+"���(��)");
		while(str!=null){
			String t [] = str.split("##");
			System.out.println(t[0]+"\t"+t[1]+"\t"+t[2]);
			str = br.readLine();
	    }
		br.close();
		fr.close();
		System.out.println("��ѡ����Ĳ�����1������ 2������ 3���޸� 4��ɾ�� 0���˳�");
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
			System.out.println("�˳��ɹ����´��ٻ�!");;
			System.exit(0);
			break;
		}
	}
	public void search() throws IOException{
		Scanner in = new Scanner(System.in);
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
					System.out.println("����"+"\t"+"����(Ԫ)"+"\t"+"���(��)");
					System.out.println(ss[0]+"\t"+ss[1]+"\t"+ss[2]);
					System.out.println("��ѡ����Ĳ�����1���������� 2������ 3���޸� 4��ɾ�� 0���˳�");
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
						System.out.println("�˳��ɹ����´��ٻ�!");;
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
			System.out.println("�������鼮����");
			String name = in.next();
			System.out.println("������۸�(Ԫ)");
			double price = in.nextDouble();
			System.out.println("������������(��)");
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
				System.out.println("¼��ɹ�");
				System.out.println("�Ƿ����¼�룿y/n");
				String s = in.next();
				if("y".equals(s)){
					add();
				}
				if("n".equals(s)){
					System.out.println("¼�����,�������˵�");
					show();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	public void revise() throws IOException{
		Scanner in = new Scanner(System.in);
		System.out.println("��������Ҫ�޸ĵ�ͼ�����ƣ�");
		String name = in.next();
		FileReader fr = new FileReader("d:\\Books.txt");
		BufferedReader br = new BufferedReader(fr);
		String str = br.readLine();
		boolean flag = false;
		while(str!=null){
			String [] ss = str.split("##");
			if(name.equals(ss[0])){
				System.out.println("���ҳɹ��������޸�");
				System.out.println(ss[0]+"\t"+ss[1]+"\t"+ss[2]);
				String line = ss[0]+"\t"+ss[1]+"\t"+ss[2];
	            StringBuffer sbf=new StringBuffer();
	            sbf.append(line);
	            System.out.println("�޸ĺ�����֣�(�粻������1)");     
	            String newname = in.next();
	            if("1".equals(newname)){
	            	newname = ss[0];
	            }
	            String newString=sbf.toString().replace(ss[0], newname);
	            System.out.println("�޸ĺ�ļ۸�(�粻������1)");
	            String newprice = in.next();
	            if("1".equals(newprice)){
	            	newprice = ss[1];
	            }
	            newString=newString.replace(ss[1], newprice);
	            System.out.println("�޸ĺ��������(�粻������1)");
	            String newnum = in.next();
	            if("1".equals(newnum)){
	            	newnum = ss[2];
	            }
	            newString=newString.replace(ss[2], newnum);
	            System.out.println("�滻��"+newString);
	            //fr.write(newString);
	            System.out.println("�Ƿ�����޸�(y/n)");
	            String c = in.next();
				if("y".equals(c)){
					revise();
				}
				if("n".equals(c)){
					System.out.println("¼�����,�������˵�");
					show();
				}
				flag = true;
				break;
			}else{
				str=br.readLine();
			}
		}
		if(flag == false){
			System.out.println("���޴���,�������޸ģ�");
			search();
		}
	}
	public void delete() throws IOException{
		Scanner in = new Scanner(System.in);
		System.out.println("��������Ҫɾ����ͼ������");
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
				System.out.println("�Ƿ�ɾ����(y/n)");
				if("y".equals(in.next())){
					FileReader fr1 = new FileReader("d:\\Books.txt");
					BufferedReader br1 = new BufferedReader(fr1);
					Scanner scan = new Scanner(new File("d:\\Books.txt"));
					Map map = new HashMap();
					String str1 = br1.readLine();//��ȡһ��
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
					System.out.println("ɾ���ɹ�");
				}
				 System.out.println("�Ƿ����ɾ��(y/n)");
		            String c = in.next();
					if("y".equals(c)){
						delete();
					}
					if("n".equals(c)){
						System.out.println("�������˵�");
						show();
					}
				flag = true;
				break;
			}else{
				str=br.readLine();
			}
		}
		if(flag == false){
			System.out.println("���޴���,������ɾ����");
			delete();
		}
	}
	
}
