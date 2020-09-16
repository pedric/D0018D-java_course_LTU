package testArea;

import java.util.Random;
import java.util.Scanner;

/**
 * Representerar en lottotalong med 10 lottorader
 * Man kan manuellt mata in rader eller be programmet
 * slumpa fram rader.
 */

public class LotteryCard {
	
	private LotteryRow[] rows;  // En array med alla 10 lottorader
	private int nrOfRowsUsed;   // Antal rader som är använda
	
	public LotteryCard() {
		this.rows  = new LotteryRow[10];
		this.nrOfRowsUsed = 0;
		for(int i = 0; i < this.rows.length;i++) {
			this.rows[i] = new LotteryRow();
		}
	}

	/**
	 * Användaren matar in 7 unika nummer som läggs 
	 * in som en ny lottorad i medlemsarrayen rows
	 */
	public void tipRowManually() {
		Scanner input = new Scanner(System.in);
		int user_choice = 0;
		System.out.println(user_choice + " Fylla i rad manuellt\n");
		LotteryRow row =  this.rows[nrOfRowsUsed];
		do {
			System.out.println("ange nummer: ");
			int number = input.nextInt();
			if(!row.addNumber(number)) {
				System.out.println("Numret redan inmatat, försök igen.");
			}
		} while(row.getChosenNumbers() < 7);
		nrOfRowsUsed++;
		System.out.println("Raden är komplett, du valde: ");
		row.showRow();
	}

	/** 
	 * Genererar 7 unika nummer som läggs in som
	 * en ny lottorad i medlemsarrayen rows
	 */
	public void generateRowRandomly() {
		LotteryRow auto_row = this.rows[nrOfRowsUsed];
		auto_row.automatedRow();
		if(nrOfRowsUsed < 10) {
			this.rows[nrOfRowsUsed] = auto_row;
			nrOfRowsUsed++;
		}
	}

	/** 
	 * Rättar en specifik lottorad och returnerar 
	 * hur många rätt den har
	 * @param theRow den rätta raden
	 * @param rowNr raden som ska rättas (1-10)
	 * @return antal rätt
	 */
	public int nrOfEqualNumbers(LottoRow theRow, int rowNr) {
		return this.rows[rowNr].nrOfEqualNumbers(theRow);
	}
	/** 
	 * Skriver ut vald rad
	 * @param rowNr den rad som ska skrivas ut (1-10)
	 */
	public void showRow(int rowNr) {
		this.rows[rowNr].showRow();
	}

	/** 
	 * Hämtar antal rader som används
	 */
	public int getNrOfRowsUsed() {
		return this.nrOfRowsUsed;
	}

}
