package com.wx.books;
/**
 * 客户发言端
 */
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;


public class Client {
	public static void main(String[] args) throws UnknownHostException, IOException {
		//获取Socket连接，指定IP地址和端口号
		Socket socket = new Socket("127.0.0.1",8888);
		System.out.println("请等待，客服人员马上就来。。。。");
		Scanner in = new Scanner(System.in);
		//获取网络输出流
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
		pw.println("客户");
		pw.flush();
		//获取网络输入流
		Scanner ins = new Scanner(socket.getInputStream());
		
		//线程---读的
		new Thread(new ClientThread(ins)).start();
		
		while(in.hasNextLine()){
			String s = in.nextLine();
			pw.println(s);
			pw.flush();
		}
		
		socket.close();
	}
}
