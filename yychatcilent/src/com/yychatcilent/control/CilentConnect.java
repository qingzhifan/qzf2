package com.yychatcilent.control;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.*;

import com.yychat.model.Message;
import com.yychat.model.User;

public class CilentConnect {
	 public static Socket s;
	public CilentConnect() {
				try {
					s= new Socket("127.0.0.1",3456);//±¾»úµØÖ·
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}
	public Message loginValidate(User user) {
		ObjectOutputStream oos;
		ObjectInputStream ois;
		Message mess=null;
		try {
			oos=new ObjectOutputStream(s.getOutputStream());
			oos.writeObject(user);
			
			ois=new ObjectInputStream(s.getInputStream());
			mess=(Message)ois.readObject();
			
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mess;
	}
}