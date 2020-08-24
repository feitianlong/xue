package generics15;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;

/**
 * 0. 泛型应用于内部类以及匿名内部类
 * @author feitianlong
 *
 */


class Customer {
	private static long counter = 1;
	private final long id = counter++;
	private Customer() {
		
	}
	public String toString() {
		return "Customer " + id;
	}
	
	// 每次调用都会新生成一个Generator对象
	public static Generator<Customer> generator(){
		return new Generator<Customer>() {
			public Customer next() {
				return new Customer();
			}
		};
	}
}

class Teller{
	private static long counter = 1;
	private final long id = counter++;
	
	private Teller() {
		
	}
	
	public String toString() {
		return "Teller " + id;
	}
	// 单例生成器对象,每次调用next()都生成新的Teller对象
	public static Generator<Teller> generator = new Generator<Teller>() {
		public Teller next(){
			return new Teller();
		}
	};
	
}

public class BankTeller {
	
	public static void serve(Teller t, Customer c) {
		System.out.println(t + " servrs " + c);
	}
	
	public static void main(String[] args) {
		Random rand = new Random(47);
		
		Queue<Customer> line = new LinkedList<Customer>();
		Generators.fill(line , Customer.generator(), 15);
		
		List<Teller> tellers = new ArrayList<Teller>();
		Generators.fill(tellers, Teller.generator, 4);
		
		for(Customer c : line)
			serve(tellers.get(rand.nextInt(tellers.size())),c);
	}
	
}
