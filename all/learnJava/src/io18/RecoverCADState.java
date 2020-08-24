package io18;

/**
 * static数据不能被自动序列化
 *    假如需要序列化static值，必須自己去实现
 *    Line的serializeStaicState就实现了这样的作用
 * @author tianlong
 *
 */
import java.io.*;
import java.util.*;

public class RecoverCADState {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception {
		ObjectInputStream in = new ObjectInputStream(new FileInputStream("CADState.out"));
		// Read in the same order they were written:
		List<Class<? extends Shape>> shapeTypes = (List<Class<? extends Shape>>) in.readObject();
		//Line.deserializeStaticState(in);
		List<Shape> shapes = (List<Shape>) in.readObject();
		System.out.println(shapes);
	}
}
