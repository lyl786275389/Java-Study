package com.wx.books;
/**
 * �ͷ����Զ�
 */
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class kefuClient {

	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket socket = new Socket("127.0.0.1",8888);
		System.out.println("��������ͻ�ȡ����ϵ��������");
		Scanner in = new Scanner(System.in);
		//��ȡ���������
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
		//��д��һ�У���һ�о�������
		pw.println("�ͷ�С��");
		pw.flush();
		//��ȡ����������
		Scanner ins = new Scanner(socket.getInputStream());
		
		//�߳�---����
		new Thread(new ClientThread(ins)).start();
		
		while(in.hasNextLine()){
			String s = in.nextLine();
			pw.println(s);
			pw.flush();
		}
		
		socket.close();
	}

}
