package holding11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 
 * @author tianlong
 *
 */
class Snow{
	
}

class Powder extends Snow{
	
}
class Light extends Powder{
	
}
class Heavy extends Powder{
	
}
class Crusty extends Snow{
	
}
class Slush extends Snow{
	
}
public class AsListInference {
	public static void main(String[] args) {
		List<Snow> snow1 = Arrays.asList(new Crusty(),new Slush(),new Powder());
		
		// ����ͼ����snow2ʱ��Arrays.asList��ֻ��Powder����
		// ������ᴴ��List<Power>�����ᴴ��List<Snow>
		// ������������
		// ����ʹ����snow4�ķ�ʽ����һ�������Ը��߱�����Arrays.asList()����Ҫ����������
		List<Snow> snow2 = Arrays.asList(new Light(),new Heavy());
		
		//Collections.addAll()����������󣬴�snow3��֪������Ҫ���ɵ���������
		// Collections.addAll()��������һ��Collection�����Լ�һ���������һ���ö��ŷָ���б�
		// ��Ԫ����ӵ���һ������Collection������
		ArrayList<Snow> snow3 = new ArrayList<Snow>();
		Collections.addAll(snow3, new Light(),new Heavy());
		
		List<Snow> snow4 = Arrays.<Snow>asList(new Light(),new Heavy());
		
	}
}
