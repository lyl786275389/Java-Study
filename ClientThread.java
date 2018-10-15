package com.wx.books;
/**
 * ×ÓÏß³Ì--¶Á
 *
 */
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;


public class ClientThread implements Runnable {
	Scanner ins;
	
	public ClientThread(Scanner ins) {
		super();
		this.ins = ins;
	}
	@Override
	public void run() {
		while(ins.hasNextLine()){
			System.out.println(ins.nextLine());
		}
	}

}
