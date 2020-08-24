package io18;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

public class BufferToText {
	private static final int BSIZE = 1024;

	public static void main(String[] args) throws Exception {

		FileChannel fc = new FileOutputStream("data.txt").getChannel();
		fc.write(ByteBuffer.wrap("Some text".getBytes()));
		fc.close();
		fc = new FileInputStream("data.txt").getChannel();
		ByteBuffer buff = ByteBuffer.allocate(BSIZE);
		fc.read(buff);
		buff.flip();
		// 无法产生正常的字符
		System.out.println(buff.asCharBuffer());

		// 解码
		buff.rewind();

		String encoding = System.getProperty("file.encoding");
		System.out.println(encoding);
		
		System.out.println("Decoding using" + encoding + ":" + Charset.forName(encoding).decode(buff));

		fc = new FileOutputStream("data2.txt").getChannel();
		fc.write(ByteBuffer.wrap("Some text".getBytes("UTF-16BE")));

		fc.close();

		fc = new FileInputStream("data2.txt").getChannel();
		buff.clear();
		fc.read(buff);
		buff.flip();
		System.out.println(buff.asCharBuffer());

		fc = new FileOutputStream("data2.txt").getChannel();
		buff = ByteBuffer.allocate(BSIZE);
		buff.asCharBuffer().put("Some text");
		fc.write(buff);

		fc.close();

		fc = new FileInputStream("data2.txt").getChannel();
		buff.clear();
		fc.read(buff);
		buff.flip();
		System.out.println(buff.asCharBuffer());

	}
}
