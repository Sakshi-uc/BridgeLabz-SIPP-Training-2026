interface StreamingService {
	void playMovie();
	default void showSubscriptionDetails() {
		System.out.println("Streaming Service Subscription");
	}
}

interface GamingService {
	void playGame();
	default void showSubscriptionDetails() {
		System.out.println("Gaming Service Subscription");
	}
}

class SmartTV implements StreamingService, GamingService {
	private String[] movies;
	private String[] games;

	SmartTV(String[] movies, String[] games) {
		this.movies = movies;
		this.games = games;
	}

	@Override
	public void playMovie() {
		System.out.println("Playing movie from streaming service");
		displayMovies();
	}

	@Override
	public void playGame() {
		System.out.println("Playing game from gaming service");
		displayGames();
	}

	@Override
	public void showSubscriptionDetails() {
		System.out.println("SmartTV Subscription - Both Streaming and Gaming");
	}

	private void displayMovies() {
		System.out.println("Available Movies:");
		for (String movie : movies) {
			System.out.println("  - " + movie);
		}
	}

	private void displayGames() {
		System.out.println("Available Games:");
		for (String game : games) {
			System.out.println("  - " + game);
		}
	}

	void displayAllContent() {
		System.out.println("=== SmartTV Content ===\n");
		showSubscriptionDetails();
		System.out.println();
		playMovie();
		System.out.println();
		playGame();
	}
}

class SmartTVSystem {
	public static void main(String[] args) {
		String[] movies = { "Inception", "Matrix", "Interstellar", "Avatar" };
		String[] games = { "FIFA", "Call of Duty", "Minecraft", "Fortnite" };

		SmartTV tv = new SmartTV(movies, games);
		tv.displayAllContent();
	}
}
