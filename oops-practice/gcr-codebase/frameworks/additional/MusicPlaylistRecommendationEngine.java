import java.util.*;

/**
 * Additional 1. Music Playlist Recommendation Engine
 * Uses LinkedList<String> to store recently played songs (most recent at the top).
 * Keeps only the latest 10 songs.
 */
public class MusicPlaylistRecommendationEngine {

    private static final int MAX_SIZE = 10;
    private LinkedList<String> recentlyPlayed = new LinkedList<>();

    public void playSong(String song) {
        // Remove if already exists so it moves to the top instead of duplicating
        recentlyPlayed.remove(song);
        recentlyPlayed.addFirst(song);

        if (recentlyPlayed.size() > MAX_SIZE) {
            String removed = recentlyPlayed.removeLast();
            System.out.println("Playlist limit exceeded. Removed oldest song: " + removed);
        }
        System.out.println("Now playing: " + song);
    }

    public void searchSong(String song) {
        if (recentlyPlayed.contains(song)) {
            System.out.println(song + " is in the recently played list.");
        } else {
            System.out.println(song + " was NOT found in the recently played list.");
        }
    }

    public void displayHistory() {
        System.out.println("\n--- Recently Played (most recent first) ---");
        if (recentlyPlayed.isEmpty()) {
            System.out.println("No songs played yet.");
        } else {
            int rank = 1;
            for (String song : recentlyPlayed) {
                System.out.println(rank++ + ". " + song);
            }
        }
    }

    public static void main(String[] args) {
        MusicPlaylistRecommendationEngine engine = new MusicPlaylistRecommendationEngine();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== Music Playlist Recommendation Engine =====");
            System.out.println("1. Play a Song");
            System.out.println("2. Search for a Song");
            System.out.println("3. Display Recently Played History");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            choice = Integer.parseInt(sc.nextLine().trim());

            switch (choice) {
                case 1:
                    System.out.print("Enter song name: ");
                    engine.playSong(sc.nextLine());
                    break;
                case 2:
                    System.out.print("Enter song name to search: ");
                    engine.searchSong(sc.nextLine());
                    break;
                case 3:
                    engine.displayHistory();
                    break;
                case 4:
                    System.out.println("Exiting Music Playlist Engine. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 4);

        sc.close();
    }
}
