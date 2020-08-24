package io18;

import java.io.*;
import java.util.*;

/**
 * static��������л�����
 * 
 * @author tianlong
 *
 */
 

public class CADState {
	public static void main(String[] args) throws Exception {
		
		List<Shape> shape = new LinkedList<Shape>();
		Circle c = (Circle) Shape.randomFactory();
		Square s = (Square) Shape.randomFactory();
		Line l = (Line) Shape.randomFactory();
		c.setColor(Shape.GREEN);
		s.setColor(Shape.GREEN);
		l.setColor(Shape.GREEN);
		
		shape.add(c);
		shape.add(s);
		shape.add(l);
		
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("CADState1.out"));


		
		// ��̫���@�Y���ግ�Fstatic�ֶε����л���
		Circle.serializeStaticState(out);
		Square.serializeStaticState(out);
		Line.serializeStaticState(out);
		
		out.writeObject(shape);
		
		ObjectInputStream in = new ObjectInputStream(new FileInputStream("CADState1.out"));
		Circle.deserializeStaticState(in);
		Square.deserializeStaticState(in);
		Line.deserializeStaticState(in);
		
		
		System.out.println(in.readObject());

	}
}
