package com.wx.books;
/**
 * ��ͨ�û���¼����
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class User {
	public void register(){
		Scanner in = new Scanner(System.in);
		while(true){
			System.out.println("�������û�����");
			String name = in.next();
			System.out.println("���������룺");
			String pwd = in.next();
			FileWriter fw;
			String str = name+"##"+pwd;
			try {
				fw = new FileWriter("d:\\user.txt",true);
				BufferedWriter bw = new BufferedWriter(fw);
				bw.write(str);
				bw.newLine();
				bw.flush();
				bw.close();
				fw.close();
				System.out.println("ע��ɹ�");
				System.out.println("�Ƿ����ע�᣿y/n");
				String s = in.next();
				if("n".equals(s)){
					System.out.println("ллʹ��,���¼");
					/*System.exit(0);*/
					login();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	public void login(){
		Scanner in = new Scanner(System.in);
		System.out.println("�������û�����");
		String name = in.next();
		System.out.println("���������룺");
		String psd = in.next();
		try {
			FileReader fr = new FileReader("d:\\user.txt");
			BufferedReader br = new BufferedReader(fr);
			String str = br.readLine();
			boolean flag = false;
			while(str!=null){
				String [] ss = str.split("##");
				if(name.equals(ss[0])&&psd.equals(ss[1])){
					System.out.println("��¼�ɹ�");
					flag = true;
					new Shopping().show();
					break;
				}else{
					str=br.readLine();
				}
			}
			if(!flag){
				System.out.println("��¼ʧ��");
				login();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
