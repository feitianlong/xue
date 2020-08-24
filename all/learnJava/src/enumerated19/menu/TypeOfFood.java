package enumerated19.menu;

import static enumerated19.menu.Food.*;

/**
 * static 能将enum实例的标识符带入到当前的命名空间
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