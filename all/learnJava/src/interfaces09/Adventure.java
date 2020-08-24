package interfaces09;

import java.util.Random;

/**
 * 0. java�Ķ����^��
 * 1. ����϶���ӿں;�����ʱ��
 * 2. ���������������ǰ�棬������ŵĲ��ǽӿڣ��ӿڼ��ö��Ÿ���
 * 3. ע��Hero��û����ʽʵ��fly()���������Ķ���ͨ���̳�ActionCharacter��֮����
 * 4. �����Ϳ���ʹHeroʵ�����нӿڣ���������
 * 5. ����extendsֻ�������ڵ�һ�࣬���ǿ������ö������ӿ�
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
