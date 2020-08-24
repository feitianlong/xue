package interfaces09;

import java.util.Random;

/**
 * 0. java的多重繼承
 * 1. 当组合多个接口和具体类时，
 * 2. 这个具体类必须放在前面，后面跟着的才是接口，接口间用逗号隔开
 * 3. 注意Hero并没有显式实现fly()，但是它的定义通过继承ActionCharacter随之而来
 * 4. 这样就可以使Hero实现所有接口，创建对象
 * 5. 此外extends只可以用于单一类，但是可以引用多个基类接口
 * @author tianlong
 *
 */
interface CanFight {
	void fight();
}

interface CanSwim {
	void swim();
}

interface CanFly {
	void fly();
}

class ActionCharacter {
	public void fight() {

	}
}

class Hero extends ActionCharacter implements CanFight, CanSwim, CanFly {
	public void swim() {

	}

	public void fly() {

	}
}

public class Adventure {
	 public static void t(CanFight x) {
		 x.fight();
	 }
	 public static void u(CanSwim x) {
		 x.swim();
	 }
	 public static void v(CanFly x) {
		 x.fly();
	 }
	 public static void w(ActionCharacter x) {
		 x.fight();
	 }
	 public static void main(String[] args) {
		Hero h = new Hero();
		t(h);
		u(h);
		v(h);
		w(h);
		Random random = new Random(20);

	}
}
