package holding11;

import java.util.Map;

/**
 * 0.显示系统的所有环境变量
 * @author tianlong
 *
 */
public class EnviromentVariables {
	public static void main(String[] args) {
		for(Map.Entry entry : System.getenv().entrySet()) {
			System.out.println(entry.getKey() + ": " + entry.getValue());
		}
	}
}
