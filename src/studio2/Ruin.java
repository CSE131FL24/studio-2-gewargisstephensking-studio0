package studio2;
import java.util.Scanner;
import java.lang.Math;

public class Ruin {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Input the Start Amount: ");
		double startAmount = in.nextDouble();
		double endAmount = startAmount;
		System.out.print("Input the Win Chance: ");
		double winChance = in.nextDouble();
		System.out.print("Input the Win Limit: ");
		double winLimit = in.nextDouble();
		int totalSimulations = 0;
		double random = Math.random();
		int wins = 0;
		int loss = 0; 
		
		while (endAmount < winLimit && endAmount > 0) {
			totalSimulations++;
			random = Math.random();
			
			if (random <= winChance) {
				endAmount++;
				wins++;
				System.out.println("Simulation " + totalSimulations + ": " + " WIN");
			}
			
			else {
				endAmount--;
				loss++;
				System.out.println("Simulation " + totalSimulations + ": " + " LOSE");
			}
			System.out.println("Current Amount: " + endAmount);
			
		}
		
		System.out.println("Start Amount: " + startAmount);
		System.out.println("End Amount: " + endAmount);
		System.out.println("WINS: " + wins + " Loss: " + loss + " Simulations: " + totalSimulations);
		double expectedRuinRate = 0.0;
		
		double a = (1-winChance)/(winChance);
		if (winChance == .5) {
			expectedRuinRate = 1 - (startAmount / winLimit);
		}
		else {
			expectedRuinRate = (((Math.pow(a, startAmount) - Math.pow(a, winLimit))/ (1-Math.pow(a, winLimit))));
		}
		System.out.println("Ruin Rate from Simulation: " + ((double) loss/totalSimulations) + " Expected Ruin Rate: " + expectedRuinRate);
		
	}

}
