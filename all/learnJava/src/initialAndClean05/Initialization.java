package initialAndClean05;
/**
 * 0.��ʼ�����Դ�������������Щ���������Ѿ�����ʼ��
 * @author tianlong
 *
 */

public class Initialization {
	// ��ʼ��������
	int i = f();
	int j = g(i);
	int f() {
		return 22;
	}
	int g(int x) {
		return 32;
	}
	
	// û�г�ʼ��������
	//int s = t(h); // ���Ϸ�����ǰ����
	int h = r();
	int r() {
		return 23;
	}
	int t(int y) {
		return 42;
	}
}
