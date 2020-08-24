package enumerated19;

//import static net.mindview.util.Print.*;

/**
 * enum类型的构造器使用
 * @author tianlong
 *
 */
public enum OzWitch {
	// Instances must be defined first, before methods:
	WEST("Miss Gulch, aka the Wicked Witch of the West"), NORTH("Glinda, the Good Witch of the North"),
	EAST("Wicked Witch of the East, wearer of the Ruby " + "Slippers, crushed by Dorothy's house"),
	SOUTH("Good by inference, but missing");

	private String description;

	// Constructor must be package or private access:
	// 即使不定义成private，构造器也只能在enum定义内使用，结束后，就不能使用
	private OzWitch(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public static void main(String[] args) {
		for (OzWitch witch : OzWitch.values())
			System.out.println(witch + ": " + witch.getDescription());
	}
}