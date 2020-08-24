package resuing07;
/**
 * 0。 当运行Beetle.java时，第一次事是试图访问main(),于是开始
 * 1. 加载Beetle的编译代码(.class)，在对他加载的过程中,编译器注意到它
 * 2. 有一个基类于是开始加载基类，依次向上加载，加载完毕后才开始执行main中的内容
 * @author tianlong
 *
 */
class Insect {
	
}
public class Beetle extends Insect{
	public static void main(String[] args) {
		
	}
}
