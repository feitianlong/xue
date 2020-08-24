package typeinfo14;

class TT {

}

public class XX {
	// final 修饰的参数必须被初始化，但是可以使用对其进行初始化
	final int x ;
	//final int y ;
	public XX(int x) {
		this.x = x;
	}
	public static void main(String[] args) {
		//XX.x++;
		int i=1 , j =1;
		System.out.println(i+" "+j);
		
	}
}
