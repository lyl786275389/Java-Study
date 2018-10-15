package com.wx.books;
/**
 *������
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
		//��ȡ����������
		Scanner ins;
		try {
			ins = new Scanner(socket.getInputStream());
			//�ȶ�һ�У������ľ�������
			this.name = ins.nextLine();
			//��ȡ���������
			PrintWriter pw;
			while(ins.hasNextLine()){
				String s = ins.nextLine();
				System.out.println(s);
				for (ServerThread st : Server.list) {
					pw = new PrintWriter(new OutputStreamWriter(st.socket.getOutputStream()));
					pw.println(this.name+"˵��"+s);
					pw.flush();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
