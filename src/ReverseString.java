public class ReverseString {
	final String input = "hello";
	int[] test;

	public ReverseString() {
		// reverse("Hello",0,4);
		// System.out.print(reverse("Hello", 0, 4));
		// System.out.print(log(1024));
		// System.out.print("hello");
		test = new int[10];
		for (int i = 0; i < test.length; i++) {
			test[i] = i;
		}
		find(test, 17);
	}

	public char[] reverse(String s, int i, int j) {
		char[] tempArray = s.toCharArray();
		char tempEnd = tempArray[j];
		if (i >= j) {
			return tempArray;
		} else {
			tempArray[j] = tempArray[i];
			tempArray[i] = tempEnd;
			this.reverse(s, i + 1, j - 1);
			return tempArray;
		}
	}

	public int log(int n) {
		// int intPart = 1;
		if (n < 2) {
			return 0;
		} else {
			n = n / 2;
			return log(n) + 1;
		}
	}

	// int[] temp = new int[2];

	public void find(int[] a, int tar) {
		for (int i = 0; i < a.length; i++) {
			if (findPair(a, tar - a[i], 0, a.length-1)) {
				System.out.print("+" + a[i] + "\n");
				return;
			}
		}
	}

	public boolean findPair(int[] a, int tar, int from, int to) {
		while (from <= to) {
			int mid = (from + to) / 2;
			if (a[mid] == tar) {
				System.out.print(a[mid]);
				return true;
			} else if (a[mid] > tar) {
				to = mid - 1;
			} else if (a[mid] < tar) {
				from = mid + 1;
			}
		}

		return false;
	}

	public static void main(String[] args) {
		// System.out.print("hello".charAt(3));
		new ReverseString();
	}
}
