package io18;

import java.nio.ByteBuffer;

/**
 * ByteBuffer��ȡ��������
 * ����ByteBufferֻ�ܱ����ֽ����͵����ݣ����������Դ��������ɵ��ֽ��в��������ֲ�ͬ��������ֵ�ķ���
 * @author tianlong
 *
 */
public class GetData {
	private static final int BSIZE = 1024;

	public static void main(String[] args) {
		ByteBuffer bb = ByteBuffer.allocate(BSIZE);

		int i = 0;
		while ((i++ < bb.limit()))
			// bb�������ǿյ�
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
		
		// ... ������������������

	}
}
