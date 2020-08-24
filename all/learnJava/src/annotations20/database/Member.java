package annotations20.database;

@DBTable
public class Member {

	// 这里使用了快捷方式
	// 何为快捷方式，如果程序员的注解中定义了名为value的元素，并且在应用该注解的时候，如果该元素是唯一需要赋值的一个元素，那么此时
	// 无需使用名-值对的语法，而只需要在括号内给出value元素所需的值即可
	// 可以應用到任何类型，但是限制其元素命名为value
	@SQLString(30)
	String firstname;
	@SQLString(50)
	String lastName;
	@SQLInteger
	Integer age;

	// @SQLString(value = 30, constraints = @Constraints(primaryKey = true)) 这部分是注解
	@SQLString(value = 30, constraints = @Constraints(primaryKey = true))
	String handle;

	static int memberCount;

	public String getHandle() {
		return handle;
	}

	public String getFirstName() {
		return firstname;
	}

	public String getLastName() {
		return lastName;
	}

	public String toString() {
		return handle;
	}

	public Integer getAge() {
		return age;
	}
}
