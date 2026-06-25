class GameCharacter {
	protected String characterName;

	GameCharacter(String characterName) {
		this.characterName = characterName;
	}

	void performAttack() {
		System.out.println(characterName + " attacks!");
	}
}

class Warrior extends GameCharacter {
	Warrior(String characterName) {
		super(characterName);
	}

	@Override
	void performAttack() {
		System.out.println(characterName + " (Warrior) swings sword with great force!");
	}
}

class Mage extends GameCharacter {
	Mage(String characterName) {
		super(characterName);
	}

	@Override
	void performAttack() {
		System.out.println(characterName + " (Mage) casts a powerful spell!");
	}
}

class Archer extends GameCharacter {
	Archer(String characterName) {
		super(characterName);
	}

	@Override
	void performAttack() {
		System.out.println(characterName + " (Archer) shoots arrows rapidly!");
	}
}

class AdventureGameCharacterSystem {
	static void startBattle(GameCharacter[] characters) {
		System.out.println("=== Battle Started ===\n");
		int warriors = 0, mages = 0, archers = 0;

		for (GameCharacter character : characters) {
			character.performAttack();
			if (character instanceof Warrior) warriors++;
			else if (character instanceof Mage) mages++;
			else if (character instanceof Archer) archers++;
		}

		System.out.println("\n=== Battle Statistics ===");
		System.out.println("Warriors: " + warriors);
		System.out.println("Mages: " + mages);
		System.out.println("Archers: " + archers);
	}

	public static void main(String[] args) {
		GameCharacter[] characters = {
			new Warrior("Conan"),
			new Mage("Gandalf"),
			new Archer("Legolas"),
			new Warrior("Hercules"),
			new Mage("Merlin"),
			new Archer("Robin")
		};

		startBattle(characters);
	}
}
