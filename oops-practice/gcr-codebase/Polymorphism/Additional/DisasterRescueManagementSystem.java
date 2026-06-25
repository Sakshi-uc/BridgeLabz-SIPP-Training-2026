class RescueTeam {
	protected String teamId;
	protected String location;

	RescueTeam(String teamId, String location) {
		this.teamId = teamId;
		this.location = location;
	}

	void performDuty() {
		System.out.println("Team " + teamId + " at " + location + " performing rescue");
	}

	void displayInfo() {
		System.out.println("Team ID: " + teamId + ", Location: " + location);
	}
}

class MedicalTeam extends RescueTeam {
	MedicalTeam(String teamId, String location) {
		super(teamId, location);
	}

	@Override
	void performDuty() {
		System.out.println("Medical Team " + teamId + " providing emergency medical aid at " + location);
	}
}

class FireRescueTeam extends RescueTeam {
	FireRescueTeam(String teamId, String location) {
		super(teamId, location);
	}

	@Override
	void performDuty() {
		System.out.println("Fire Rescue Team " + teamId + " extinguishing fires at " + location);
	}
}

class FoodSupplyTeam extends RescueTeam {
	FoodSupplyTeam(String teamId, String location) {
		super(teamId, location);
	}

	@Override
	void performDuty() {
		System.out.println("Food Supply Team " + teamId + " distributing food at " + location);
	}
}

class DisasterRescueManagementSystem {
	static RescueTeam[] findTeamByLocation(String location, RescueTeam[] teams) {
		java.util.List<RescueTeam> result = new java.util.ArrayList<>();
		for (RescueTeam team : teams) {
			if (team.location.equals(location)) {
				result.add(team);
			}
		}
		return result.toArray(new RescueTeam[0]);
	}

	static void displayTeamsByPrefix(String prefix, RescueTeam[] teams) {
		System.out.println("\nTeams with ID starting with '" + prefix + "':");
		for (RescueTeam team : teams) {
			if (team.teamId.startsWith(prefix)) {
				team.displayInfo();
			}
		}
	}

	public static void main(String[] args) {
		RescueTeam[] teams = {
			new MedicalTeam("MED001", "Downtown"),
			new FireRescueTeam("FIR001", "Downtown"),
			new FoodSupplyTeam("FOOD001", "Suburb"),
			new MedicalTeam("MED002", "Downtown"),
			new FireRescueTeam("FIR002", "Suburb"),
			new MedicalTeam("MED003", "Suburb")
		};

		System.out.println("=== Disaster Rescue Management System ===\n");

		System.out.println("All Teams Performing Duties:");
		int medical = 0, fire = 0, food = 0;
		for (RescueTeam team : teams) {
			team.performDuty();
			if (team instanceof MedicalTeam) medical++;
			else if (team instanceof FireRescueTeam) fire++;
			else if (team instanceof FoodSupplyTeam) food++;
		}

		System.out.println("\n=== Deployment Count ===");
		System.out.println("Medical Teams: " + medical);
		System.out.println("Fire Rescue Teams: " + fire);
		System.out.println("Food Supply Teams: " + food);

		System.out.println("\nMaximum Deployments: " + Math.max(medical, Math.max(fire, food)));

		RescueTeam[] downtownTeams = findTeamByLocation("Downtown", teams);
		System.out.println("\nTeams at Downtown: " + downtownTeams.length);

		displayTeamsByPrefix("MED", teams);
	}
}
