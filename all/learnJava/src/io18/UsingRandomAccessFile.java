package io18;

import java.io.*;

/**
 * 读写随机访问文件
 * RandomAccessFile类似于组合使用DataInputStream和DataOutputStream
 * @author tianlong
 *
 */
public class UsingRandomAccessFile {
	static String file = "rtest.dat";

	static void display() throws IOException {
		RandomAccessFile rf = new RandomAccessFile(file, "r");
		for (int i = 0; i < 7; i++)
			System.out.println("Value " + i + ": " + rf.readDouble());

		System.out.println(rf.readUTF());
		rf.close();
	}

	public static void main(String[] args) throws IOException {
		RandomAccessFile rf = new RandomAccessFile(file, "rw");
		for (int i = 0; i < 7; i++)
			rf.writeDouble(i * 1.414);

		rf.writeUTF("The end of the file");
		rf.close();
		display();
		rf = new RandomAccessFile(file, "rw");
		// double 占8个字节，所以用seek()找到第五个双精度值，只需用5*8来产生查找位置
		rf.seek(5 * 8);
		rf.writeDouble(47.0001);
		rf.close();
		display();
	}
}
