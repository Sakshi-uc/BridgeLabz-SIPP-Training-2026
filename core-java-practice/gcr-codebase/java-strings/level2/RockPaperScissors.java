import java.util.Scanner;
public class RockPaperScissors{
	public static String getComputerChoice(){
		int rand=(int)(Math.random()*3);
		if(rand==0){return "Rock";}
		else if(rand==1){return "Paper";}
		else{return "Scissors";}
	}
	public static String findWinner(String player,String computer){
		if(player.equals(computer)){return "Draw";}
		if((player.equals("Rock")&&computer.equals("Scissors"))||(player.equals("Scissors")&&computer.equals("Paper"))||(player.equals("Paper")&&computer.equals("Rock"))){
			return "Player";
		}
		return "Computer";
	}
	public static String[][] getStats(int playerWins,int computerWins,int draws,int total){
		String[][] stats=new String[3][2];
		stats[0][0]="Player Wins";
		stats[0][1]=playerWins+" ("+Math.round((double)playerWins/total*100)+"%)";
		stats[1][0]="Computer Wins";
		stats[1][1]=computerWins+" ("+Math.round((double)computerWins/total*100)+"%)";
		stats[2][0]="Draws";
		stats[2][1]=draws+" ("+Math.round((double)draws/total*100)+"%)";
		return stats;
	}
	public static void displayResults(String[][] results,String[][] stats){
		System.out.println("Game\tPlayer\t\tComputer\tWinner");
		System.out.println("----------------------------------------------------");
		for(int i=0;i<results.length;i++){
			System.out.println((i+1)+"\t"+results[i][0]+"\t\t"+results[i][1]+"\t\t"+results[i][2]);
		}
		System.out.println("\nStats:");
		System.out.println("Category\tResult");
		System.out.println("------------------------");
		for(int i=0;i<stats.length;i++){
			System.out.println(stats[i][0]+"\t"+stats[i][1]);
		}
	}
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter number of games: ");
		int n=sc.nextInt();
		String[][] results=new String[n][3];
		int playerWins=0,computerWins=0,draws=0;
		for(int i=0;i<n;i++){
			System.out.print("Enter your choice (Rock/Paper/Scissors): ");
			String player=sc.next();
			String computer=getComputerChoice();
			String winner=findWinner(player,computer);
			results[i][0]=player;
			results[i][1]=computer;
			results[i][2]=winner;
			if(winner.equals("Player")){playerWins++;}
			else if(winner.equals("Computer")){computerWins++;}
			else{draws++;}
		}
		String[][] stats=getStats(playerWins,computerWins,draws,n);
		displayResults(results,stats);
		sc.close();
	}
}
