import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class SubsetNum {
	private Scanner s = new Scanner(System.in);
	private ArrayList<Integer> tempInput = new ArrayList<Integer>();
	private ArrayList<Integer> target = new ArrayList<Integer>();
	private int[] input;

	public SubsetNum() {
		InputToArray(s);
		for (int i = 0; i < target.size(); i++) {
			CalculateSubsetNumber cal = new CalculateSubsetNumber();
			cal.findSubset(input, target.get(i), 0);
			System.out.print(cal.getCount() + "\n");
		}

	}

	public void InputToArray(Scanner scanner) {
		Scanner tempScanner = new Scanner(scanner.nextLine());

		while (tempScanner.hasNextInt()) {
			tempInput.add(tempScanner.nextInt());

			input = new int[tempInput.size()];
			for (int i = 0; i < tempInput.size(); i++) {
				input[i] = tempInput.get(i);
			}
			Arrays.sort(input);
			while (scanner.hasNextInt()) {
				target.add(scanner.nextInt());
			}
		}
		tempScanner.close();
	}

	public static void main(String[] args) {
		new SubsetNum();
	}

	private class CalculateSubsetNumber {
		private int count = 0;

		public void findSubset(int[] input, int target, int fromIndex) {

			if (target == 0) {
				count++;
				return;
			}
			while (fromIndex < input.length && input[fromIndex] > target) {
				fromIndex++;
			}
			while (fromIndex < input.length && input[fromIndex] <= target) {
				findSubset(input, target - input[fromIndex], fromIndex + 1);
				fromIndex++;
			}
		}

		public int getCount() {
			return count;
		}
	}

}
