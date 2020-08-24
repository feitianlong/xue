package initialAndClean05;

/**
 * 0.基本类型的重载（不能以返回值区分重载方法）
 * 1.按照char-->byte-->short-->int-->long-->double-->float
 * 2.的顺序向上一层转换
 * @author tianlong
 *
 */
public class PrimitiveOverloading {
	void f1(char x)	{System.out.print(x+"f1(byte)");}
	void f1(byte x)	{System.out.print(x+"f1(byte)");}
	void f1(short x)	{System.out.print(x+"f1(byte)");}
	void f1(int x)	{System.out.print(x+"f1(byte)");}
	void f1(long x)	{System.out.print(x+"f1(byte)");}
	void f1(double x)	{System.out.print(x+"f1(byte)");}
	
	//void f2(char x)	{System.out.print(x+"f2(char)");}
	void f2(byte x)	{System.out.print(x+"f2(byte)");}
	void f2(short x)	{System.out.print(x+"f2(short)");}
	void f2(int x)	{System.out.print(x+"f2(int)");}
	void f2(long x)	{System.out.print(x+"f2(long)");}
	void f2(double x)	{System.out.print(x+"f2(double)");}
	
	void f3(short x)	{System.out.print(x+"f3(short)");}
	void f3(int x)	{System.out.print(x+"f3(int)");}
	void f3(long x)	{System.out.print(x+"f3(long)");}
	void f3(double x)	{System.out.print(x+"f3(double)");}
	
	void f4(int x)	{System.out.print(x+"f4(int)");}
	void f4(long x)	{System.out.print(x+"f4(long)");}
	void f4(double x)	{System.out.print(x+"f4(double)");}
	
	void f5(long x)	{System.out.print(x+"f5(long)");}
	void f5(double x)	{System.out.print(x+"f5(double)");}
	
	void f6(double x)	{System.out.print(x+"f6(double)");}

	
	
	
	public static void main(String[] args) {
		PrimitiveOverloading p = new PrimitiveOverloading();
		byte x1=1;
		short x2=2;
		int x3=3;
		long x4=4;
		double x5=5;
		p.f1(x1);
		p.f2(x1);
		p.f3(x1);
		p.f4(x1);
		p.f5(x1);
	}
}
