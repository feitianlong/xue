package containers17;

import arrays16.CountingGenerator;
import arrays16.Generator;

class Letters implements Generator<Pair<Integer,String>>{
	
	private int size = 9;
	private int number = 1;
	private char letter = 'A';
	
	
	@Override
	public Pair<Integer,String> next() {
		// TODO Auto-generated method stub
		return new Pair<Integer,String>(number++ , "" + letter++);
	}
	
}

public class MapDataTest {
	public static void main(String[] args) {
		System.out.println(MapData.map(new Letters(), 5));
		
		// 没写关于生成Integer和String的生成器
		//System.out.println(MapData.map());
		
		System.out.println(MapData.map(new CountingGenerator.Character(), new CountingGenerator.Integer(), 10));
	}
	
	
}
