package io18;

import java.io.*;

public class StoringAndRecouveringData {
	public static void main(String[] args) throws IOException {
		DataOutputStream out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("Data.txt")));

		out.writeDouble(3.14155);
		out.writeUTF("That was pi");
		out.writeDouble(1.41411);

		out.close();

		DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream("Data.txt")));
		System.out.println(in.readDouble());
		System.out.println(in.readUTF());
		System.out.println(in.readDouble());
		in.close();
	}
}
