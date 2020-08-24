package hdfs.datacollect;

import java.io.IOException;
import java.util.Properties;
/**
 * 	�������ģʽ������ʽ��������û�ж��󶼴�����
 * @author tianlong
 *
 */	
public class PropertiesHolderHunger {
	private static Properties prop = new Properties();
	
	// ��̬�����ֻ����һ��
	static {
		try {
			prop.load(PropertiesHolderHunger.class.getClassLoader().getResourceAsStream("collect.properties"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private PropertiesHolderHunger(){
		
	}
	
	public static Properties getProps() throws Exception {
		// �õ������ļ�
		
		return prop;
	}

}
