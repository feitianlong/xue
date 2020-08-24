package innerclasses10;

/**
 * 0.�ֲ��ڲ��ָࣺ�ڷ������������ڲ�����һ�������࣬������Ϊ�ֲ��ڲ���
 * 1. �ֲ��ڲ��಻���з���˵����(public,private,protected)����Ϊ��������Χ���һ����
 * 2. ���������Է��ʵ�ǰ������ڵĳ����Լ�����Χ������г�Ա
 * 3. �����ڲ���ֻ������ʵ����ʼ����û�й��캯��
 * 4. �ֲ��ڲ������ӵ�й��캯��
 * 5. ���⣬�ڲ���Ҳӵ��Ҳ���������.class�ļ����԰������ǵ�Class������Ϣ
 * 6. ��Щ���ļ����������ϸ�Ĺ�����Χ������֣�����$�ټ����ڲ��������
 * 7. ����ڲ����������Ķ��������򵥵ز���һ��������Ϊ���ʶ��
 * 8. ����ڲ�����Ƕ���ڱ���ڲ���֮�У�ֻ��ֱ�ӽ����ǵ����ּ�������Χ���ʶ����$�ĺ���
 * @author tianlong
 *
 */
interface Counter {
	  int next();
	}    

	public class LocalInnerClass {
	  private int count = 0;
	  Counter getCounter(final String name) {
	    // A local inner class:
	    class LocalCounter implements Counter { //�ֲ��ڲ���
	      public LocalCounter() {
	        // Local inner class can have a constructor
	        System.out.println("LocalCounter()");
	      }
	      public int next() {
	        System.out.print(name); // Access local final
	        return count++;
	      }
	    }
	    return new LocalCounter();
	  }    
	  // The same thing with an anonymous inner class:
	  Counter getCounter2(final String name) {
	    return new Counter() {  //�����ڲ���
	      // Anonymous inner class cannot have a named
	      // constructor, only an instance initializer:
	      {
	        System.out.println("Counter()");
	      }
	      public int next() {
	    	  System.out.print(name); // Access local final
	        return count++; // ��Χ��ĳ�Ա
	      }
	    };
	  }    
	  public static void main(String[] args) {
	    LocalInnerClass lic = new LocalInnerClass();
	    Counter
	      c1 = lic.getCounter("Local inner "),
	      c2 = lic.getCounter2("Anonymous inner ");
	    for(int i = 0; i < 5; i++)
	    	 System.out.println(c1.next());
	    for(int i = 0; i < 5; i++)
	    	 System.out.println(c2.next());
	  }
	} 
