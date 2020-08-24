package io18;

import java.util.concurrent.*;
import java.io.*;
import java.util.*;
import static net.mindview.util.Print.*;

/**
 * 序列化的transient关键字
 * 由于Externalizable对象在默认情况下不保存它们的任何字段，所以transient关键字只能和Serializable一起使用
 * @author tianlong
 *
 */
public class Logon implements Serializable {
	private Date date = new Date();
	private String username;
	private transient String password;

	public Logon(String name, String pwd) {
		username = name;
		password = pwd;
	}

	public String toString() {
		return "logon info: \n   username: " + username + "\n   date: " + date + "\n   password: " + password;
	}

	public static void main(String[] args) throws Exception {
		Logon a = new Logon("Hulk", "myLittlePony");
		print("logon a = " + a);
		ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream("Logon.out"));
		o.writeObject(a);
		o.close();
		TimeUnit.SECONDS.sleep(1); // Delay
		// Now get them back:
		ObjectInputStream in = new ObjectInputStream(new FileInputStream("Logon.out"));
		print("Recovering object at " + new Date());
		a = (Logon) in.readObject();
		print("logon a = " + a);
	}
}
