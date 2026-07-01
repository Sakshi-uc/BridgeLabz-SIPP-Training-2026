import java.util.*;

public class MusicPlaylistRecommendationEngine {

    static final int MAX_SIZE = 10;
    LinkedList<String> recentlyPlayed = new LinkedList<>();

    void playSong(String song) {
        recentlyPlayed.remove(song);
        recentlyPlayed.addFirst(song);

        if (recentlyPlayed.size() > MAX_SIZE) {
            String removed = recentlyPlayed.removeLast();
            System.out.println("Playlist limit exceeded. Removed oldest song: " + removed);
        }
        System.out.println("Now playing: " + song);
    }

    void searchSong(String song) {
        if (recentlyPlayed.contains(song)) {
            System.out.println(song + " is in the recently played list.");
        } else {
            System.out.println(song + " was not found in the recently played list.");
        }
    }

    void displayHistory() {
        System.out.println("\n--- Recently Played ---");
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
            System.out.println("\n1. Play a Song");
            System.out.println("2. Search for a Song");
            System.out.println("3. Display Recently Played History");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            choice = Integer.parseInt(sc.nextLine().trim());

            if (choice == 1) {
                System.out.print("Enter song name: ");
                engine.playSong(sc.nextLine());
            } else if (choice == 2) {
                System.out.print("Enter song name to search: ");
                engine.searchSong(sc.nextLine());
            } else if (choice == 3) {
                engine.displayHistory();
            } else if (choice == 4) {
                System.out.println("Bye!");
            } else {
                System.out.println("Invalid choice.");
            }
        } while (choice != 4);

        sc.close();
    }
}
