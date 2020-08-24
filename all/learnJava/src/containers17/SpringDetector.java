package containers17;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

/**
 * ɢ����ɢ����
 * ����������У��޷���������3�������
 * ��������Groundhog�Զ��̳�Object�����������hashCode()ʹ�õ���Object�ķ��������ɵ�ɢ���룬����Ĭ��ʹ�ö���ĵ�ַ����ɢ����
 * ��ˣ���Groundhog(3)���ɵĵ�һ��ʵ����ɢ��������Groundhog���ɵĵڶ���ʵ����ɢ�����ǲ�ͬ�ģ�����������ʹ�ú��ߵ�ɢ�������
 * ���ǣ����ֻ��дǡ����hashCode()�����ĸ��ǰ汾�޷������������ͬʱ����equals()��������Ҳ��Object��һ���֡�
 * �ٴ�ǿ����Ĭ�ϵ�Object.equals()ֻ�ǱȽ϶���ĵ�ַ������һ��Groundhog(3)��������Groundhog(3)��
 * ��ˣ����Ҫʹ���Լ�������ΪHashMap�ļ�������ͬʱ����hashCode()��equals()
 * @author tianlong
 *
 */
public class SpringDetector {
	public static <T extends Groundhog> void  detectSpring(Class<T> type) throws Exception {
		Constructor<T> ghog = type.getConstructor(int.class);
		Map<Groundhog, Prediction> map = new HashMap<Groundhog , Prediction>();
		
		for (int i = 0; i < 10; i++)
			map.put(ghog.newInstance(i), new Prediction());
		System.out.println("map = "+ map);
		
		Groundhog gh = ghog.newInstance(3);
		System.out.println("Looking up prediction for "+ gh);
		if(map.containsKey(gh))
			System.out.println(map.get(gh));
		else
			System.out.println("Key not found: "+gh);
		
	}
	public static void main(String[] args) throws Exception {
		detectSpring(Groundhog.class);
		detectSpring(Groundhog2.class);
	}
	
}
