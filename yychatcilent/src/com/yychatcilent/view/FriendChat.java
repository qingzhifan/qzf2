package com.yychatcilent.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.*;

import com.yychat.model.Message;
import com.yychatcilent.control.CilentConnect;

public class FriendChat extends JFrame implements ActionListener,Runnable{
	
	

	JScrollPane jsp;
	JTextArea jta;
	
	
	
	
	JPanel jp;
	JTextField jtx;
	JButton jb;
	
	String sender;
	String receiver;
	
	
	public FriendChat(String sender,String receiver) {
		this.sender=sender;
		this.receiver=receiver;
		
		jta=new JTextArea();
		jta.setForeground(Color.red);
		jta.setEditable(false);
		jsp=new JScrollPane(jta);
		this.add(jsp);
		
	
		jp=new JPanel();
		jb=new JButton("发送");
		jb.addActionListener(this);
		jtx=new JTextField(15);
		jtx.setForeground(Color.blue);
		jp.add(jtx);jp.add(jb);
		this.add(jp,"South");
		
	
		this.setSize(350,240);
//		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle(sender+"和"+receiver+"正在聊天");
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
		
	}
	
	public static void main(String[] args) {
		//FriendChat friendChat=new FriendChat();

	}

	@Override
	public void actionPerformed(ActionEvent args) {
		if(args.getSource()==jb) jta.append(jtx.getText()+"\r\n");
		
		Message mess=new Message();
		mess.setSender(sender);
		mess.setReceiver(receiver);
		mess.setContent(jtx.getText());
		mess.setMessageType(Message.message_common);
		ObjectOutputStream oos;
		
		 try {
			oos = new ObjectOutputStream(CilentConnect.s.getOutputStream());
			oos.writeObject(mess);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void run() {
		ObjectInputStream ois;
		while(true){
			try {
				ois = new ObjectInputStream(CilentConnect.s.getInputStream());
				Message mess=(Message)ois.readObject();
				String showMessage=mess.getSender()+"对"+mess.getReceiver()+"说："+mess.getContent();
				System.out.println(showMessage);
				jta.append(showMessage+"\r\n");
				} catch (IOException | ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
		}
		
	}

}
