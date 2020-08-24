package io18;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BufferedInputFile {

	// �ַ���sb�����ۼ��ļ��е�ȫ������(����������ӵĻ��з�����ΪreadLine()�Ѿ�������ɾ��)
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
