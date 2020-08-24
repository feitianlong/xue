package strings13;

import java.util.*;

/**
 * 0. StringBuilder
 * 1. �����toString()ʹ��ѭ�������ʹ���Լ�����һ��StringBuilder���������յĶ���
 * 2. ������ʵ���У����յĽ����һ���ƴ�������ġ������Ҫ�߽ݾ�������append(a+":"+c)
 * 3. �Ǳ�������������壬�Ӷ�Ϊ�����ⴴ��һ��StringBuilder���������������ڵ��ַ�
 * 4. ����ò�׼ʹ���ĸ���ʽ������ʹ��javap���������������
 * @author tianlong
 * 
 */
public class UsingStringBuilder {
	public static Random rand = new Random(47);

	public String toString() {
		StringBuilder result = new StringBuilder("[");
		for (int i = 0; i < 25; i++) {
			result.append(rand.nextInt(100));
			//.�Ϳո�
			result.append(". ");
		}
		//ɾ����������ַ�.�Ϳո�
		result.delete(result.length() - 2, result.length());
		result.append("]");
		return result.toString();
	}

	public static void main(String[] args) {
		UsingStringBuilder usb = new UsingStringBuilder();
		System.out.println(usb);
	}
}
