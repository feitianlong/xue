package StringQuestion;


import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

import javax.print.attribute.ResolutionSyntax;

/**
 * �����ַ�������ִ��������ַ���
 * 
 * @author tianlong
 * 
 */
public class SearchMostChar {
	public static void main(String[] args) {
		SearchMostChar.Resolution();
	}

	public static void Resolution(){
		String str1 = "sfdsafsgasgr";
		char[] chArr = str1.toCharArray();
		HashMap<Character,Integer> map = new HashMap<Character,Integer>();
		for (char c : chArr){
			if (map.containsKey(c)){
				map.put(c, map.get(c)+ 1 );
			}else {
				map.put(c, 1);
			}
		}
		
		// ���ֵ�������ֵ�����ܶ����
		int max = 0;
		for (Integer value : map.values()){
			if (value > max ){
				max = value;
				System.out.println(value);
			}
		}
		
		// ����������ֵ��Key
		int count = 0;
		for (Entry<Character,Integer> m : map.entrySet() ){
			if (m.getValue() == max){
				count ++;
				System.out.println(m.getKey());
			}
		}
		
		
		
	}
}
