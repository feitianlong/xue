package typeinfo14;

/**
 * 没有Pets和Pet的代码，Pet需要Indivuals类(在第17章)
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
