package enumerated19.menu;

import static enumerated19.menu.Food.*;

/**
 * static �ܽ�enumʵ���ı�ʶ�����뵽��ǰ�������ռ�
 * @author tianlong
 *
 */
public class TypeOfFood {
	public static void main(String[] args) {
		Food food = Appetizer.SALAD;
		food = MainCourse.LASAGNE;
		food = Dessert.GELATO;
		food = Coffee.CAPPUCCINO;
	}
}