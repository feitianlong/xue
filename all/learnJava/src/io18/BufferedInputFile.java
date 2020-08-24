package io18;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BufferedInputFile {

	// 字符串sb用来累计文件中的全部内容(包括必须添加的换行符，因为readLine()已经将它们删除)
	public static String read(String filename) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader(filename));
		String s;
		StringBuilder sb = new StringBuilder();
		while ((s = in.readLine()) != null)
			sb.append(s + "\n");
		in.close();
		return sb.toString();
	}

	public static void main(String[] args) throws IOException {
		System.out.println(read("D:\\appdev\\xiti\\Learning\\src\\io18\\BufferedInputFile.java"));
	}
}
