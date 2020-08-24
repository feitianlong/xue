package containers17;

import java.util.ArrayList;

import arrays16.Generator;

public class CollectionData<T> extends ArrayList<T>{
	
	public CollectionData(Generator<T> gen, int quantity){
		for(int i = 0 ; i < quantity; i++)
			add(gen.next());
	}
	
	// ����һstatic�������Կ��������Ҫʹ�÷��ͷ������ͱ���ʹ���Ϊ���ͷ���
	// Ҫ���巺�ͷ�����ֻ��Ҫ���Ͳ����б����ڷ���ֵ֮ǰ
	// ��public <T> void f(T x)
	public static <T> CollectionData<T> list(Generator<T> gen, int quantity){
		return new CollectionData<T>(gen , quantity);
	}
	// ��������֪����ЩԪ�ص�˳�������ǵĲ���˳����ͬ����ΪLinkedHashSetά�����Ǳ����˲���˳��������б�
	
	
}
