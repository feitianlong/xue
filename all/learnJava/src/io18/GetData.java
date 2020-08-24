package io18;

import java.nio.ByteBuffer;

/**
 * ByteBuffer获取基本类型
 * 尽管ByteBuffer只能保存字节类型的数据，但是它可以从其所容纳的字节中产生出各种不同基本类型值的方法
 * @author tianlong
 *
 */
public class GetData {
	private static final int BSIZE = 1024;

	public static void main(String[] args) {
		ByteBuffer bb = ByteBuffer.allocate(BSIZE);

		int i = 0;
		while ((i++ < bb.limit()))
			// bb缓冲器是空的
			if (bb.get() != 0)
				System.out.print("nonzero");

		System.out.println("i = " + i);
		bb.rewind();

		bb.asCharBuffer().put("Howdy");

		char c;
		while ((c = bb.getChar()) != 0)
			System.out.print(c + "  ");

		System.out.println();

		bb.rewind();
		bb.asShortBuffer().put((short) 14144);
		System.out.println(bb.getShort());

		bb.rewind();
		bb.asIntBuffer().put(1343);
		System.out.println(bb.getInt());
		
		// ... 其他基本數據類型類似

	}
}
