package com.wx.books;
/**
 * 服务器端
 */
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;


public class Server {
	static List<ServerThread> list = new ArrayList<ServerThread>();
	public static void main(String[] args) throws IOException {
		//获取Serversocket对象
		ServerSocket ss=  new ServerSocket(8888);
		System.out.println("正在建立联系。。。。");
		while(true){
			//服务器监听客户端连接
			Socket socket  = ss.accept();
			ServerThread st = new ServerThread(socket);
			//每一个ServerThread，每个获取一个Socket，都要添加到list里
			list.add(st);
			new Thread(st).start();
		}

	}
	
}
