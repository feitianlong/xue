package io18;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;

public class FormattedMemoryInput {
	public static void main(String[] args) throws IOException {
		
		try {
			// 读取字节数组
			
			DataInputStream in = new DataInputStream(new ByteArrayInputStream((new BufferedInputFile()).read("D:\\appdev\\xiti\\Learning\\src\\io18\\FormattedMemoryInput.java").getBytes()));
			
			while(true)
				System.out.print((char)in.readByte());
		}catch(EOFException e) {
			System.out.println("end of stream");
		}

		
		
	}
}
