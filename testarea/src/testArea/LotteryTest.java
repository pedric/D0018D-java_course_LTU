package testArea;

import java.util.Random;
import java.util.Scanner;

public class LotteryTest {

	public static void main(String[] args) {
		
		LotteryRow winningRow = new LotteryRow();
		LotteryCard lotto = new LotteryCard();
		
		winningRow.addNumber(1);
		winningRow.addNumber(9);
		winningRow.addNumber(6);
		winningRow.addNumber(18);
		winningRow.addNumber(17);
		winningRow.addNumber(12);
		winningRow.addNumber(34);
		
		Scanner input = new Scanner(System.in);
		int user_choice = 0;
		
		System.out.println("***\n\nVälkommen till lottoautomaten");
		
		do {
			menu();
			user_choice = input.nextInt();
			
			switch(user_choice) {
			case 1:
				lotto.tipRowManually();
				break;
			case 2:
				lotto.generateRowRandomly();
				break;
			case 3:
				for(int i = 0; i < lotto.getNrOfRowsUsed();i++) {
					System.out.println("Rad " + (i+1) + ": ");
					lotto.showRow(i);
					System.out.println("\n");
				}
				break;
			case 4:
				System.out.println("Korrekt rad:\n");
				winningRow.showRow();
				break;
			case 5:
				System.out.println("u typed " + user_choice);
				break;
			default:
				System.out.println("Invalid charachter, u typed " + user_choice);
			}
			
		} while(user_choice != 5);
	}
	
	public static void menu(){
		System.out.println("\n***\nMenyval:");
		System.out.println("1. Fylla i lottorad manuellt.");
		System.out.println("2. Få en slumpad lottorad.");
		System.out.println("3. Skriv ut dina tippade rader.");
		System.out.println("4. Rätta dina rader.");
		System.out.println("5. Avsluta.\n\n***\n");
	}

}
