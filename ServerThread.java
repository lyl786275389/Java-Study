package com.wx.books;
/**
 *服务器
 */
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ServerThread implements Runnable{
	Socket socket;
	String name;
	public ServerThread(Socket socket) {
		super();
		this.socket = socket;
	}

	@Override
	public void run() {
		//获取网络输入流
		Scanner ins;
		try {
			ins = new Scanner(socket.getInputStream());
			//先读一行，读到的就是名字
			this.name = ins.nextLine();
			//获取网络输出流
			PrintWriter pw;
			while(ins.hasNextLine()){
				String s = ins.nextLine();
				System.out.println(s);
				for (ServerThread st : Server.list) {
					pw = new PrintWriter(new OutputStreamWriter(st.socket.getOutputStream()));
					pw.println(this.name+"说："+s);
					pw.flush();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
