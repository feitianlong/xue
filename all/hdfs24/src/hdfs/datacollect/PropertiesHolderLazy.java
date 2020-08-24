package hdfs.datacollect;

import java.util.Properties;
/**
 * 	����ģʽ������ʽ���������̰߳�ȫ
 *  		
 * @author tianlong
 *
 */
public class PropertiesHolderLazy {
	private static Properties prop = null;
	
	public static Properties getProp() throws Exception {

		if (prop == null) {
			synchronized (PropertiesHolderLazy.class) {
				// ������Ŀ��:��ֹʱ��ܽ����������̶������ж�
				if (prop == null) {
					// �ڶ���null�жϵ�Ŀ�ģ� ��ֹ�Ѿ������һ��null���߳��ٴν���ڶ���null��
					// ��Ȼ��������������������߳̿����Ѿ����Ѿ������˵�һ��null�ж���
					prop = new Properties();
					prop.load(PropertiesHolderLazy.class.getClassLoader().getResourceAsStream("collect.properties"));
				}
			}
		}
		return prop;
	}
}
