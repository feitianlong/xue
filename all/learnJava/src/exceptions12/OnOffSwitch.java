package exceptions12;

/**
 * 0.ʹ��finally�Ӿ��������
 * 1.����һЩ���룬���ܻ�ϣ������try���е��쳣�Ƿ��׳������Ƕ��ܵõ�ִ��
 * 2.�����쳣�Ƿ��׳���finally�Ӿ䶼���Ա�ִ��
 * 
 * 
 * 3.finally�Ӿ�Ķ����ͷ��ڴ�ǳ���Ҫ
 * 4.��Ҫ�ѳ��ڴ�֮�����Դ�ָ������ǵĳ�ʼ״̬ʱ���Ǿ�Ҫ�õ�finally�Ӿ䡣
 * 5.�����������Դ�������Ѿ��򿪵��ļ����������ӣ�����Ļ�ϻ���ͼ�λ��߿��أ�����������ʾ
 * 
 * 6.�����Ŀ����Ҫȷ��main()�����Ŀ��ر����ǹرյģ�������ÿ��try����쳣��������ĩβ�������˶�sw.off()�����ĵ���
 * 7.��Ҳ������������쳣���׳�����û�б�������򲶻���ʱsw.off()�͵ò������á���������finally��ֻҪ��try�������������һ�𼴿�
 * 8.��ע��(1)
 * 
 * 9.���⣬���漰break��continue����ʱ��finally�Ӿ�Ҳ��õ�ִ�С�
 * @author tianlong
 *
 */
public class OnOffSwitch {
	private static Switch sw = new Switch();
	public static void f() throws OnOffException1,OnOffException2{
		
	}
	public static void main(String[] args) {
		// (1)
//		try {
//			sw.on();
//			f();
//			sw.off();
//		}catch(OnOffException1 e) {
//			System.out.println("OnOffException1");
//			sw.off();
//		}catch(OnOffException2 e) {
//			System.out.println("OnOffException2");
//			sw.off();
//		}
		try {
			sw.on();
			f();
		}catch(OnOffException1 e) {
			System.out.println("OnOffException1");
		}catch(OnOffException2 e) {
			System.out.println("OnOffException2");
		}finally {
			sw.off();
		}
	}
}
