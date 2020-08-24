package annotations20.database;

@DBTable
public class Member {

	// ����ʹ���˿�ݷ�ʽ
	// ��Ϊ��ݷ�ʽ���������Ա��ע���ж�������Ϊvalue��Ԫ�أ�������Ӧ�ø�ע���ʱ�������Ԫ����Ψһ��Ҫ��ֵ��һ��Ԫ�أ���ô��ʱ
	// ����ʹ����-ֵ�Ե��﷨����ֻ��Ҫ�������ڸ���valueԪ�������ֵ����
	// ���ԑ��õ��κ����ͣ�����������Ԫ������Ϊvalue
	@SQLString(30)
	String firstname;
	@SQLString(50)
	String lastName;
	@SQLInteger
	Integer age;

	// @SQLString(value = 30, constraints = @Constraints(primaryKey = true)) �ⲿ����ע��
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
