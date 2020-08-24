package hdfs.datacollect;

import java.io.IOException;
import java.util.Properties;
/**
 * 	单例设计模式：饿汉式，不管有没有对象都创建了
 * @author tianlong
 *
 */	
public class PropertiesHolderHunger {
	private static Properties prop = new Properties();
	
	// 静态代码块只加载一次
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
		// 得到配置文件
		
		return prop;
	}

}
