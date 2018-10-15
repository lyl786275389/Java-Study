package com.wx.books;
/**
 * �ͻ����Զ�
 */
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;


public class Client {
	public static void main(String[] args) throws UnknownHostException, IOException {
		//��ȡSocket���ӣ�ָ��IP��ַ�Ͷ˿ں�
		Socket socket = new Socket("127.0.0.1",8888);
		System.out.println("��ȴ����ͷ���Ա���Ͼ�����������");
		Scanner in = new Scanner(System.in);
		//��ȡ���������
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
		pw.println("�ͻ�");
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
