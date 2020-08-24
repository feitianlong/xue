package io18;

import java.io.*;

/**
 * Externalizable的替代方法
 * transient字段必须在程序中明确保存和恢复
 * 非transient字段由defalutWriteObject()方法保存
 * 实现Serializable的类添加private void readObject(ObjectOutputStream stream) throws IOException
 * 和private void readObject(ObjectInputStream stream) throws IOException就不会使用后默认的
 * @author tianlong
 *
 */
public class SerialCtl implements Serializable {
	private String a;
	private transient String b;

	public SerialCtl(String aa, String bb) {
		a = "Not Transient: " + aa;
		b = "Transient: " + bb;
	}

	public String toString() {
		return a + "\n" + b;
	}

	private void writeObject(ObjectOutputStream stream) throws IOException {
		stream.defaultWriteObject();
		stream.writeObject(b);
	}

	private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
		stream.defaultReadObject();
		b = (String) stream.readObject();
	}

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		SerialCtl sc = new SerialCtl("Test1", "Test2");
		System.out.println("Before:\n" + sc);
		ByteArrayOutputStream buf = new ByteArrayOutputStream();
		ObjectOutputStream o = new ObjectOutputStream(buf);
		o.writeObject(sc);
		// Now get it back:
		ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(buf.toByteArray()));
		SerialCtl sc2 = (SerialCtl) in.readObject();
		System.out.println("After:\n" + sc2);
	}
}
