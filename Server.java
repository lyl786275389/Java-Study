package com.wx.books;
/**
 * ��������
 */
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;


public class Server {
	static List<ServerThread> list = new ArrayList<ServerThread>();
	public static void main(String[] args) throws IOException {
		//��ȡServersocket����
		ServerSocket ss=  new ServerSocket(8888);
		System.out.println("���ڽ�����ϵ��������");
		while(true){
			//�����������ͻ�������
			Socket socket  = ss.accept();
			ServerThread st = new ServerThread(socket);
			//ÿһ��ServerThread��ÿ����ȡһ��Socket����Ҫ��ӵ�list��
			list.add(st);
			new Thread(st).start();
		}

	}
	
}
