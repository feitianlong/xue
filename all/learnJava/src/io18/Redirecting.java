package io18;

import java.io.*;

/**
 * IO�ض�����������ֽ������������ʹ��InputStream��OutputStream
 * @author tianlong
 *
 */
public class Redirecting {
	public static void main(String[] args) throws IOException {
		
		PrintStream console = System.out;
		BufferedInputStream in = new BufferedInputStream(
				new FileInputStream("D:\\appdev\\xiti\\Learning\\src\\io18\\Redirecting.java"));
		PrintStream out = new PrintStream(new BufferedOutputStream(new FileOutputStream("test.out")));
		
		// ����׼�����in�󶨣�����׼����ʹ��������out��
		System.setIn(in);
		System.setOut(out);
		System.setErr(out);

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s;
		while ((s = br.readLine()) != null)
			System.out.println(s);

		out.close();
		// �ָ���׼�����System.out
		System.setOut(console);
	}
}
