import java.util.Scanner;
public class DeckOfCards{
	public static String[] initializeDeck(String[] suits,String[] ranks){
		int numOfCards=suits.length*ranks.length;
		String[] deck=new String[numOfCards];
		int idx=0;
		for(int i=0;i<suits.length;i++){
			for(int j=0;j<ranks.length;j++){
				deck[idx]=ranks[j]+" of "+suits[i];
				idx++;
			}
		}
		return deck;
	}
	public static String[] shuffleDeck(String[] deck){
		int n=deck.length;
		for(int i=0;i<n;i++){
			int randomCardNumber=i+(int)(Math.random()*(n-i));
			String temp=deck[i];
			deck[i]=deck[randomCardNumber];
			deck[randomCardNumber]=temp;
		}
		return deck;
	}
	public static String[][] distributeDeck(String[] deck,int numCards,int numPlayers){
		if(numCards>deck.length||numCards%numPlayers!=0){
			System.out.println("Cannot distribute cards evenly.");
			return null;
		}
		int cardsPerPlayer=numCards/numPlayers;
		String[][] players=new String[numPlayers][cardsPerPlayer];
		for(int i=0;i<numPlayers;i++){
			for(int j=0;j<cardsPerPlayer;j++){
				players[i][j]=deck[i*cardsPerPlayer+j];
			}
		}
		return players;
	}
	public static void printPlayers(String[][] players){
		for(int i=0;i<players.length;i++){
			System.out.print("Player "+(i+1)+": ");
			for(int j=0;j<players[i].length;j++){
				System.out.print(players[i][j]);
				if(j<players[i].length-1){
					System.out.print(", ");
				}
			}
			System.out.println();
		}
	}
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		String[] suits={"Hearts","Diamonds","Clubs","Spades"};
		String[] ranks={"2","3","4","5","6","7","8","9","10","Jack","Queen","King","Ace"};
		String[] deck=initializeDeck(suits,ranks);
		deck=shuffleDeck(deck);
		System.out.print("Enter number of cards to distribute: ");
		int numCards=sc.nextInt();
		System.out.print("Enter number of players: ");
		int numPlayers=sc.nextInt();
		String[][] players=distributeDeck(deck,numCards,numPlayers);
		if(players!=null){
			printPlayers(players);
		}
		sc.close();
	}
}
