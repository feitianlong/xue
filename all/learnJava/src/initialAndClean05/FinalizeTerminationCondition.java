package initialAndClean05;

class Book {
	boolean checkedOut = false;

	Book(boolean checkOut) {
		checkedOut = checkOut;
	}

	void checkIn() {
		checkedOut = false;
	}

	protected void finalize() {

		if (checkedOut) {
			System.out.println("Error:checked out");
		}
	}
}

public class FinalizeTerminationCondition {
	public static void main(String[] args) {
		Book novel = new Book(true);
		novel.checkIn();

		// Drop the reference,forget to clean up
		new Book(true);
		System.gc();
	}
}
