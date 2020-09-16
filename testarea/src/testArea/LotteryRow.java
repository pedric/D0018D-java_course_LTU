package testArea;

import java.util.Random;
import java.util.ArrayList;

/**
 * Representerar en lottorad som består av 
 * 7 unika nummer från 1 till och med 35
 */

public class LotteryRow {
	
	// Markerar de 7 tal som är valda med true 
	// och de tal som inte valda med false
	// Notera att element 1 (index 0) inte används
	// Talen som kan väljas är alltså 1-35
	private boolean[] row;
	
	public LotteryRow() {
		this.row = new boolean[36];
		for(int i = 0;i < this.row.length;i++) {
			row[i] = false;
		}
	}
	
	public boolean[] automatedRow() {
		Random random = new Random();
		int[] right_row = new int[6];
		int counter = 0;
		do {
			int randomNumber = random.nextInt(36);
			boolean unique_number = true;
			// Make sure number is not already in the array
			for(int number : right_row) {
				if(randomNumber == number) {
					unique_number = false;
				}
			}
			// Add number to right row
			if(randomNumber > 0 && unique_number){
//				right_row[counter] = randomNumber;
				this.row[randomNumber] = true;
				counter++;
			}
		} while(counter < 7);
		return this.row;
	}

	/** 
	 * Lägger till inskickat nummer som valt
	 * men bara om det inte är valt redan
	 * @param nr det nummer man vill ha med i lottoraden
	 * @return false om numret redan var taget annars true
	 */
	public boolean addNumber(int nr) {
		if(!row[nr]) {
			row[nr] = true;
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Rättar en lottoraden och returnerar 
	 * hur många rätt den har
	 * @param theRow den rätta raden
	 * @return antal rätt
	 */
	public int nrOfEqualNumbers(LottoRow theRow) {
		int equals = 0;
		for(int i = 0; i < this.row.length;i++) {
			if(this.row[i] && theRow.row[i]) {
				equals++;
			}
		}
		return equals;
	}

	/** 
	 * Skriver ut raden till skärmen
	 */
	public void showRow() {
		String row = "";
		for(int i = 0; i < this.row.length;i++) {
			if(this.row[i] == true) {
				row += i + " ";
			}
		}
		System.out.println(row + "\n");
	}
	
	public boolean[] getRow() {
		return this.row;
	}
	
	public int getChosenNumbers() {
		int addedNumbers = 0;
		for(boolean value : this.row) {
			if(value == true) {
				addedNumbers++;
			}
		}
		return addedNumbers;
	}

}



//Random random = new Random();
//int[] right_row = new int[6];
//int counter = 0;
//
//// ArrayList
//var list = new ArrayList<Integer>();
//do {
//	int random_number = random.nextInt(36);
//	boolean unique_number = true;
//	if(!list.contains(random_number)) {
//		list.add(random_number);
//	}
//}while(list.size() < 7);



// fixed array
//do {
//	int randomNumber = random.nextInt(36);
//	boolean unique_number = true;
//	// Make sure number is not already in the array
//	for(int number : right_row) {
//		if(randomNumber == number) {
//			unique_number = false;
//		}
//	}
//	// Add number to right row
//	if(randomNumber > 0 && unique_number){
//		right_row[counter] = randomNumber;
//		counter++;
//	}
//} while(counter <= 7);
