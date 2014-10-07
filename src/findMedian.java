public class findMedian {
	private int[] A = new int[10];
	private int[] B = new int[10];

	static int output;

	public findMedian() {
		for (int i = 0; i < 10; i++) {
			A[i] = i;
			B[i] = i + 10;
		}
		int fromA = 0;
		int toA = A.length;
		int fromB = 0;
		int toB = B.length;
		int tar = (A.length + B.length) / 2;
		int midA, midB;

		while (tar > 0) {
			midA = (fromA + toA) / 2;
			midB = (fromB + toB) / 2;
			if (A[midA] > B[midB]) {
				tar = tar - midB + 1;
				fromB = midB;
			} else if (A[midA] < B[midB]) {
				tar = tar - midA + 1;
				fromA = midA;
			}
			if (tar == 0) {
				output = Math.min(A[fromA], B[fromB]);
			}
		}
	}

	public static void main(String[] args) {
		new findMedian();
		System.out.print(output);

	}
}
