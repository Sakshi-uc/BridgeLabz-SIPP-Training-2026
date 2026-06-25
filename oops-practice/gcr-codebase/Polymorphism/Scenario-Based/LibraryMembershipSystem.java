class LibraryMember {
	protected String memberName;
	protected String memberId;

	LibraryMember(String memberName, String memberId) {
		this.memberName = memberName;
		this.memberId = memberId;
	}

	double calculateFine(int overdueDays) {
		return 0;
	}

	void displayMember() {
		System.out.println("Member: " + memberName + " (" + memberId + ")");
	}
}

class StudentMember extends LibraryMember {
	StudentMember(String memberName, String memberId) {
		super(memberName, memberId);
	}

	@Override
	double calculateFine(int overdueDays) {
		return overdueDays * 2;
	}
}

class FacultyMember extends LibraryMember {
	FacultyMember(String memberName, String memberId) {
		super(memberName, memberId);
	}

	@Override
	double calculateFine(int overdueDays) {
		return overdueDays * 1;
	}
}

class GuestMember extends LibraryMember {
	GuestMember(String memberName, String memberId) {
		super(memberName, memberId);
	}

	@Override
	double calculateFine(int overdueDays) {
		return overdueDays * 5;
	}
}

class SmartLibraryMembershipSystem {
	static LibraryMember searchMember(String memberId, LibraryMember[] members) {
		for (LibraryMember member : members) {
			if (member.memberId.equals(memberId)) {
				return member;
			}
		}
		return null;
	}

	public static void main(String[] args) {
		LibraryMember[] members = {
			new StudentMember("Alice Johnson", "STU001"),
			new FacultyMember("Dr. Smith", "FAC001"),
			new GuestMember("Bob Wilson", "GUS001"),
			new StudentMember("Carol White", "STU002")
		};

		int overdueDays = 5;
		System.out.println("=== Library Fine Calculation (Overdue: " + overdueDays + " days) ===\n");

		for (LibraryMember member : members) {
			member.displayMember();
			System.out.printf("Fine: %.2f\n\n", member.calculateFine(overdueDays));
		}

		System.out.println("=== Search Member ===");
		LibraryMember found = searchMember("FAC001", members);
		if (found != null) {
			found.displayMember();
			System.out.printf("Fine for 3 days: %.2f\n", found.calculateFine(3));
		}
	}
}
