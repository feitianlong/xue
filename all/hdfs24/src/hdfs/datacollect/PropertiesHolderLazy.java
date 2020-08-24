package hdfs.datacollect;

import java.util.Properties;
/**
 * 	单例模式：懒汉式——考虑线程安全
 *  		
 * @author tianlong
 *
 */
public class PropertiesHolderLazy {
	private static Properties prop = null;
	
	public static Properties getProp() throws Exception {

		if (prop == null) {
			synchronized (PropertiesHolderLazy.class) {
				// 加锁的目的:防止时间很近的两个进程都进入判断
				if (prop == null) {
					// 第二个null判断的目的： 防止已经进入第一个null的线程再次进入第二个null里
					// 虽然加锁，但是相近的两个线程可以已经都已经进入了第一个null判断中
					prop = new Properties();
					prop.load(PropertiesHolderLazy.class.getClassLoader().getResourceAsStream("collect.properties"));
				}
			}
		}
		return prop;
	}
}
