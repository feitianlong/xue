package typeinfo14;

/**
 * û��Pets��Pet�Ĵ��룬Pet��ҪIndivuals��(�ڵ�17��)
 * @author feitianlong
 *
 */
public class PetCount4 {
	public static void main(String[] args) {
		TypeCounter counter = new TypeCounter(Pet.class);
		/*
		 * for(Pet pet : Pets.createArray(20)) {
		 * System.out.println(pet.getClass().getSimpleName()); counter.count(pet); }
		 */
	}
}
