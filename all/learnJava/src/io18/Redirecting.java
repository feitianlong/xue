package io18;

import java.io.*;

/**
 * IO重定向操作的是字节流，因此我们使用InputStream和OutputStream
 * @author tianlong
 *
 */
public class Redirecting {
	public static void main(String[] args) throws IOException {
		
		PrintStream console = System.out;
		BufferedInputStream in = new BufferedInputStream(
				new FileInputStream("D:\\appdev\\xiti\\Learning\\src\\io18\\Redirecting.java"));
		PrintStream out = new PrintStream(new BufferedOutputStream(new FileOutputStream("test.out")));
		
		// 将标准输入和in绑定，将标准输出和错误输出和out绑定
		System.setIn(in);
		System.setOut(out);
		System.setErr(out);

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s;
		while ((s = br.readLine()) != null)
			System.out.println(s);

		out.close();
		// 恢复标准输出到System.out
		System.setOut(console);
	}
}
