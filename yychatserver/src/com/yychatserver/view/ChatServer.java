package com.yychatserver.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import com.yychatserver.controller.StartServer;

public class ChatServer extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	JButton jb1,jb2;
	JPanel jp;
	
	public ChatServer(){
		jb1=new JButton("����������");
		jb1.addActionListener(this);
		jb2=new JButton("�رշ�����");
		jp=new JPanel();
		jp.add(jb1);jp.add(jb2);
		this.add(jp);
		
		
		
		this.setSize(240,240);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("qq������");
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	
		
	}
	public static void main(String[] args) {
		ChatServer chatServer=new ChatServer();

	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		new StartServer();
		
	}

}
