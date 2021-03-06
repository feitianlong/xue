package io18;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;

public class BasicFileOutput {
	static String file = "BasicFileOutput.out";

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new StringReader(
				BufferedInputFile.read("D:\\appdev\\xiti\\Learning\\src\\io18\\BasicFileOutput.java")));

		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file)));

		int lineCount = 1;
		String s;
		while ((s = in.readLine()) != null)
			// 输出到文件中
			out.println(lineCount++ + ": " + s);
		out.close();

		System.out.println(BufferedInputFile.read(file));
	}
}
