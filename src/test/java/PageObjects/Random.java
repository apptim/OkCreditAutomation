package PageObjects;

public class Random {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		getRandomNumberInRange(1, 30);
		
	}
	
	  
	private static int getRandomNumberInRange(int min, int max) {

		if (min >= max) {
			throw new IllegalArgumentException("max must be greater than min");
		}
		
		return (int)(Math.random() * ((max - min) + 1)) + min;
	}

}
