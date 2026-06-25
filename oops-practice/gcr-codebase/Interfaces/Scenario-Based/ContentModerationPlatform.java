interface TextModeration {
	boolean moderateText(String text);
	default void displayModerationPolicy() {
		System.out.println("Text content must comply with community standards");
	}
}

interface SpamDetection {
	boolean detectSpam(String text);
	default void displayModerationPolicy() {
		System.out.println("Spam content will be flagged and removed");
	}
}

class ContentModerator implements TextModeration, SpamDetection {
	private String[] restrictedWords = { "abuse", "spam", "hate", "violence" };

	@Override
	public boolean moderateText(String text) {
		return !containsRestrictedWords(text);
	}

	@Override
	public boolean detectSpam(String text) {
		return !text.matches(".*\\b(click|buy|follow|subscribe)\\b.*");
	}

	static boolean containsRestrictedWords(String text) {
		String[] restricted = { "abuse", "spam", "hate", "violence" };
		for (String word : restricted) {
			if (text.toLowerCase().contains(word)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void displayModerationPolicy() {
		System.out.println("Content Moderation Policy: Strict standards apply");
	}

	void analyzePosts(String[] posts) {
		System.out.println("=== Content Moderation Results ===\n");
		for (String post : posts) {
			boolean isOffensive = !moderateText(post);
			boolean isSpam = !detectSpam(post);

			String status = "VALID";
			if (isSpam) status = "SPAM";
			else if (isOffensive) status = "OFFENSIVE";

			System.out.println("Post: \"" + post + "\" -> " + status);
		}
	}
}

class ContentModerationSystem {
	public static void main(String[] args) {
		String[] posts = {
			"Great content, loved it!",
			"Click here to buy cheap products now",
			"I hate this so much",
			"Have a wonderful day everyone",
			"SPAM SPAM SPAM follow my channel",
			"This is abusive language"
		};

		ContentModerator moderator = new ContentModerator();
		moderator.displayModerationPolicy();
		System.out.println();
		moderator.analyzePosts(posts);
	}
}
