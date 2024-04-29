import java.util.Scanner;

public class SimpleCalculator {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		
		try {
			int result = calculate(input);
			System.out.println(result);
		} catch (Exception e) {
			System.out.println(e.getClass().getSimpleName());
		}
	}
	
	private static int calculate(String input) throws OutOfRangeException, AddZeroException, SubtractZeroException {
		String[] parts = input.split("(?=[+-])", 2);
		int x = Integer.parseInt(parts[0]);
		char operator = parts[1].charAt(0);
		int y = Integer.parseInt(parts[1].substring(1));
		
		if (x == 0 || y == 0) {
			if (operator == '+') {
				throw new AddZeroException();
			} else if (operator == '-') {
				throw new SubtractZeroException();
			}
		}
		
		int result;
		if (operator == '+') {
			result = x + y;
		} else {
			result = x - y;
		}
		
		if (x < 0 || x > 1000 || y < 0 || y > 1000 || result < 0 || result > 1000) {
			throw new OutOfRangeException();
		}
		
		return result;
	}

}

class OutOfRangeException extends Exception {
	
}

class AddZeroException extends Exception {
	
}

class SubtractZeroException extends Exception {
	
}